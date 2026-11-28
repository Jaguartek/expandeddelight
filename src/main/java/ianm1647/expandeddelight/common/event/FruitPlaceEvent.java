package ianm1647.expandeddelight.common.event;

import ianm1647.expandeddelight.common.block.FruitBlock;
import ianm1647.expandeddelight.common.registry.EDBlocks;
import ianm1647.expandeddelight.common.registry.EDItems;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Sneak + right click with an apple, orange, lemon or cherry hangs a ripe fruit under leaves, for decoration.
 * Hand placed fruit has no effect on whether a tree bears fruit (that is decided by the trunk position).
 */
public class FruitPlaceEvent {

    public static void init() {
        UseBlockCallback.EVENT.register((player, level, hand, hitResult) -> {
            if (!player.isShiftKeyDown() || player.isSpectator()) return InteractionResult.PASS;

            ItemStack stack = player.getItemInHand(hand);
            Block fruit = fruitFor(stack);
            if (fruit == null) return InteractionResult.PASS;

            BlockPos target = hitResult.getBlockPos().relative(hitResult.getDirection());
            if (!level.isEmptyBlock(target)) return InteractionResult.PASS;

            BlockState state = fruit.defaultBlockState().setValue(FruitBlock.AGE, FruitBlock.MAX_AGE);
            if (!state.canSurvive(level, target)) return InteractionResult.PASS;

            if (!level.isClientSide()) {
                level.setBlock(target, state, 3);
                level.playSound(null, target, SoundType.CROP.getPlaceSound(), SoundSource.BLOCKS, 1.0f, 1.0f);
                if (!player.getAbilities().instabuild) stack.shrink(1);
            }
            player.swing(hand);
            return InteractionResult.SUCCESS;
        });
    }

    private static Block fruitFor(ItemStack stack) {
        if (stack.is(Items.APPLE)) return EDBlocks.APPLE_FRUIT.get();
        if (stack.is(EDItems.ORANGE.get())) return EDBlocks.ORANGE_FRUIT.get();
        if (stack.is(EDItems.LEMON.get())) return EDBlocks.LEMON_FRUIT.get();
        if (stack.is(EDItems.CHERRY.get())) return EDBlocks.CHERRY_FRUIT.get();
        return null;
    }
}
