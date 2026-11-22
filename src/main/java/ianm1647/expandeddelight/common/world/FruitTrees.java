package ianm1647.expandeddelight.common.world;

import ianm1647.expandeddelight.common.block.FruitBlock;
import ianm1647.expandeddelight.common.registry.EDBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Supplier;

/**
 * Which vanilla leaves bear which fruit, and the rules for growing a new fruit under a leaf.
 * Called from LeavesFruitMixin.
 */
public final class FruitTrees {
    /** 1 in N chance per leaf random tick to try to grow a bud (tune this for fruit density/regrowth speed). */
    public static final int BUD_CHANCE = 40;
    /** Percentage of natural trees (decided per trunk) that bear fruit at all. */
    public static final int FRUITING_TREE_PERCENT = 20;

    private static final Map<Block, Supplier<Block>> FRUITS = new HashMap<>();

    private FruitTrees() {}

    public static void register() {
        FRUITS.put(Blocks.OAK_LEAVES, () -> EDBlocks.APPLE_FRUIT.get());
        FRUITS.put(Blocks.BIRCH_LEAVES, () -> EDBlocks.LEMON_FRUIT.get());
        FRUITS.put(Blocks.ACACIA_LEAVES, () -> EDBlocks.ORANGE_FRUIT.get());
        FRUITS.put(Blocks.CHERRY_LEAVES, () -> EDBlocks.CHERRY_FRUIT.get());

        // Block states cache "isRandomlyTicking" when the game starts, before this mod loads and before
        // the mixin could see FRUITS. Rebuild the cache for the fruit-bearing leaves so the mixin takes effect.
        for (Block leaves : FRUITS.keySet()) {
            for (BlockState state : leaves.getStateDefinition().getPossibleStates()) {
                state.initCache();
            }
        }
    }

    /** True for naturally generated (non persistent) leaves of a fruit tree species. */
    public static boolean bearsFruit(BlockState state) {
        return FRUITS.containsKey(state.getBlock()) && !state.getValue(LeavesBlock.PERSISTENT);
    }

    public static void tryGrow(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!bearsFruit(state)) return;
        if (state.getValue(LeavesBlock.DISTANCE) >= 7) return; // decaying leaf
        if (random.nextInt(BUD_CHANCE) != 0) return;

        BlockPos below = pos.below();
        if (!level.isEmptyBlock(below)) return;

        BlockState fruit = FRUITS.get(state.getBlock()).get().defaultBlockState();
        if (!fruit.canSurvive(level, below)) return;
        if (fruitNearby(level, pos)) return;
        if (!isFruitingTree(level, pos, state)) return;

        level.setBlock(below, fruit, 2);
    }

    private static boolean fruitNearby(ServerLevel level, BlockPos pos) {
        for (BlockPos p : BlockPos.betweenClosed(pos.offset(-2, -3, -2), pos.offset(2, 1, 2))) {
            if (level.getBlockState(p).getBlock() instanceof FruitBlock) return true;
        }
        return false;
    }

    /**
     * Follows the leaf "distance to log" values down to the trunk, then flips a coin seeded by the trunk position,
     * so every leaf of one tree agrees on whether it is a fruiting tree.
     */
    private static boolean isFruitingTree(ServerLevel level, BlockPos leafPos, BlockState leafState) {
        BlockPos current = leafPos;
        int distance = leafState.getValue(LeavesBlock.DISTANCE);
        BlockPos.MutableBlockPos neighbor = new BlockPos.MutableBlockPos();

        for (int step = 0; step < 8; step++) {
            BlockPos best = null;
            int bestDistance = distance;
            for (Direction direction : Direction.values()) {
                neighbor.setWithOffset(current, direction);
                OptionalInt candidate = LeavesBlock.getOptionalDistanceAt(level.getBlockState(neighbor));
                if (candidate.isPresent() && candidate.getAsInt() < bestDistance) {
                    bestDistance = candidate.getAsInt();
                    best = neighbor.immutable();
                }
            }
            if (best == null) return false; // no path to a trunk
            if (bestDistance == 0) return trunkCoinFlip(best);
            current = best;
            distance = bestDistance;
        }
        return false;
    }

    private static boolean trunkCoinFlip(BlockPos trunk) {
        long h = ((long) trunk.getX() * 341873128712L) ^ ((long) trunk.getZ() * 132897987541L) ^ 0x5DEECE66DL;
        h ^= h >>> 33;
        h *= 0xff51afd7ed558ccdL;
        h ^= h >>> 33;
        h *= 0xc4ceb9fe1a85ec53L;
        h ^= h >>> 33;
        return (h >>> 16) % 100 < FRUITING_TREE_PERCENT;
    }
}
