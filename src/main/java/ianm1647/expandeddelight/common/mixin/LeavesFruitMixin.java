package ianm1647.expandeddelight.common.mixin;

import ianm1647.expandeddelight.common.world.FruitTrees;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Vanilla leaves only random tick while decaying. Fruit-bearing leaves also tick so they can grow fruit.
 */
@Mixin(LeavesBlock.class)
public abstract class LeavesFruitMixin {

    @Inject(method = "isRandomlyTicking", at = @At("RETURN"), cancellable = true)
    private void expandeddelight$fruitLeavesTick(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValue() && FruitTrees.bearsFruit(state)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "randomTick", at = @At("HEAD"))
    private void expandeddelight$growFruit(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, CallbackInfo ci) {
        FruitTrees.tryGrow(state, level, pos, random);
    }
}
