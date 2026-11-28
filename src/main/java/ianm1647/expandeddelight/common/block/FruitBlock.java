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
    public static final int MAX_AGE = 3;
    /** Each random tick has a 1 in RIPEN_CHANCE chance to advance one stage (about 2-3 days from bud to ripe). */
    public static final int RIPEN_CHANCE = 16;

    private static final VoxelShape[] SHAPES = new VoxelShape[MAX_AGE + 1];

    static {
        for (int age = 0; age <= MAX_AGE; age++) {
            double size = 3.0 + age;
            SHAPES[age] = Block.box(8.0 - size / 2.0, 15.0 - size, 8.0 - size / 2.0, 8.0 + size / 2.0, 16.0, 8.0 + size / 2.0);
        }
    }

    private final Supplier<Item> fruitItem;

    public FruitBlock(Properties properties, Supplier<Item> fruitItem) {
        super(properties);
        this.fruitItem = fruitItem;
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES[state.getValue(AGE)];
    }

    // Walking through the canopy shouldn't bump into fruit.
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.above()).is(BlockTags.LEAVES);
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos,
                                     Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        if (direction == Direction.UP && !state.canSurvive(level, pos)) {
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
