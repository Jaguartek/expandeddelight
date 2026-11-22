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
    public static final int FRUITING_TREE_PERCENT = 50;

    private static final Map<Block, Supplier<Block>> FRUITS = new HashMap<>();

    private FruitTrees() {}

    public static void register() {
        FRUITS.put(Blocks.OAK_LEAVES, () -> EDBlocks.APPLE_FRUIT.get());
        FRUITS.put(Blocks.BIRCH_LEAVES, () -> EDBlocks.LEMON_FRUIT.get());
        FRUITS.put(Blocks.ACACIA_LEAVES, () -> EDBlocks.ORANGE_FRUIT.get());
        FRUITS.put(Blocks.CHERRY_LEAVES, () -> EDBlocks.CHERRY_FRUIT.get());
    }

    /** True for naturally generated (non persistent) leaves of a fruit tree species. */
    public static boolean bearsFruit(BlockState state) {
        return FRUITS.containsKey(state.getBlock()) && !state.getValue(LeavesBlock.PERSISTENT);
    }

    // TEMPORARY DEBUG: counts how far leaf ticks get through the checks. Remove once fruit growth is confirmed.
    private static final java.util.concurrent.atomic.AtomicIntegerArray DEBUG = new java.util.concurrent.atomic.AtomicIntegerArray(10);
    private static final String[] DEBUG_NAMES = {"calls", "bearsFruit", "notDecaying", "chance", "airBelow", "canSurvive", "noFruitNearby", "fruitingTree", "placed", "unused"};

    private static void dbg(int stage) {
        DEBUG.incrementAndGet(stage);
        if (stage == 0 && (DEBUG.get(0) == 1 || DEBUG.get(0) % 2000 == 0)) {
            StringBuilder sb = new StringBuilder("[FruitTrees debug]");
            for (int i = 0; i < 9; i++) sb.append(' ').append(DEBUG_NAMES[i]).append('=').append(DEBUG.get(i));
            ianm1647.expandeddelight.ExpandedDelight.LOGGER.info(sb.toString());
        }
    }

    public static void tryGrow(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        dbg(0);
        if (!bearsFruit(state)) return;
        dbg(1);
        if (state.getValue(LeavesBlock.DISTANCE) >= 7) return; // decaying leaf
        dbg(2);
        if (random.nextInt(BUD_CHANCE) != 0) return;
        dbg(3);

        BlockPos below = pos.below();
        if (!level.isEmptyBlock(below)) return;
        dbg(4);

        BlockState fruit = FRUITS.get(state.getBlock()).get().defaultBlockState();
        if (!fruit.canSurvive(level, below)) return;
        dbg(5);
        if (fruitNearby(level, pos)) return;
        dbg(6);
        if (!isFruitingTree(level, pos, state)) return;
        dbg(7);

        level.setBlock(below, fruit, 2);
        dbg(8);
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
