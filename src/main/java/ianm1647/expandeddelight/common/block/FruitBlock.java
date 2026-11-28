package ianm1647.expandeddelight.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

/**
 * A fruit hanging from the underside of a leaf block. It ripens over time (age 0-3) and only drops
 * its fruit (see the loot table) when broken at age 3. Leaves grow new buds via LeavesFruitMixin / FruitTrees.
 */
public class FruitBlock extends Block {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    public static final BooleanProperty HANGING = BlockStateProperties.HANGING;
    public static final int MAX_AGE = 3;
    /** Each random tick has a 1 in RIPEN_CHANCE chance to advance one stage (about 2-3 days from bud to ripe). */
    public static final int RIPEN_CHANCE = 16;

    private static final VoxelShape[] HANGING_SHAPES = new VoxelShape[MAX_AGE + 1];
    private static final VoxelShape[] GROUND_SHAPES = new VoxelShape[MAX_AGE + 1];

    static {
        for (int age = 0; age <= MAX_AGE; age++) {
            double size = 3.0 + age;
            double lo = 8.0 - size / 2.0;
            double hi = 8.0 + size / 2.0;
            HANGING_SHAPES[age] = Block.box(lo, 15.0 - size, lo, hi, 16.0, hi);
            GROUND_SHAPES[age] = Block.box(lo, 0.0, lo, hi, 1.0 + size, hi);
        }
    }

    private final Supplier<Item> fruitItem;

    public FruitBlock(Properties properties, Supplier<Item> fruitItem) {
        super(properties);
        this.fruitItem = fruitItem;
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(HANGING, true));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, HANGING);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return (state.getValue(HANGING) ? HANGING_SHAPES : GROUND_SHAPES)[state.getValue(AGE)];
    }

    // Walking through the canopy shouldn't bump into fruit.
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (state.getValue(HANGING)) {
            return level.getBlockState(pos.above()).is(BlockTags.LEAVES);
        }
        BlockPos below = pos.below();
        return level.getBlockState(below).isFaceSturdy(level, below, Direction.UP);
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos,
                                     Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        Direction support = state.getValue(HANGING) ? Direction.UP : Direction.DOWN;
        if (direction == support && !state.canSurvive(level, pos)) {
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(state, level, ticks, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < MAX_AGE;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int age = state.getValue(AGE);
        if (age < MAX_AGE && random.nextInt(RIPEN_CHANCE) == 0) {
            level.setBlock(pos, state.setValue(AGE, age + 1), 2);
        }
    }

    // Middle click (pick block) gives the fruit item. The exact vanilla signature differs between Minecraft
    // versions, so a few variants are declared; the one matching this version overrides the vanilla method.
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData) {
        return new ItemStack(fruitItem.get());
    }

    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        return new ItemStack(fruitItem.get());
    }

    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData, Player player) {
        return new ItemStack(fruitItem.get());
    }
}
