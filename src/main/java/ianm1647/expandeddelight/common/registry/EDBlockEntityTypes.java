package ianm1647.expandeddelight.common.registry;

import ianm1647.expandeddelight.common.utility.RegUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;
import vectorwing.farmersdelight.common.registry.ModBlocks;

import java.util.function.Supplier;

public class EDBlockEntityTypes {


    public static final Supplier<BlockEntityType<CookingPotBlockEntity>> COOKING_POT = RegUtils.regBlockEntity("cooking_pot",
            () -> BlockEntityType.Builder.of(CookingPotBlockEntity::new, new Block[]{ModBlocks.COOKING_POT.get()}).build());

    public EDBlockEntityTypes() {
    }

    public static void register() {
    }
}
