package ianm1647.expandeddelight.common.registry;

import ianm1647.expandeddelight.common.block.*;
import ianm1647.expandeddelight.common.utility.RegUtils;
import ianm1647.expandeddelight.common.world.tree.EDTreeGrowers;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;

import java.util.function.Supplier;

public class EDBlocks {

    public static Supplier<Block> CINNAMON_SAPLING;
    public static Supplier<Block> CINNAMON_LEAVES;
    public static Supplier<Block> CINNAMON_LOG;
    public static Supplier<Block> CINNAMON_STRIPPED_LOG;

    public static Supplier<Block> CASK;
    public static Supplier<Block> MILK_CASK;
    public static Supplier<Block> GOAT_MILK_CASK;
    public static Supplier<Block> CHEESE_CASK;
    public static Supplier<Block> GOAT_CHEESE_CASK;

    public static Supplier<Block> CHEESE_WHEEL;
    public static Supplier<Block> GOAT_CHEESE_WHEEL;

    public static Supplier<Block> ASPARAGUS_CRATE;
    public static Supplier<Block> SWEET_POTATO_CRATE;
    public static Supplier<Block> CHILI_PEPPER_CRATE;
    public static Supplier<Block> CRANBERRY_BAG;

    public static Supplier<Block> WILD_ASPARAGUS;
    public static Supplier<Block> WILD_SWEET_POTATO;
    public static Supplier<Block> WILD_CHILI_PEPPER;
    public static Supplier<Block> WILD_PEANUTS;

    public static Supplier<Block> SALT_ORE;
    public static Supplier<Block> DEEPSLATE_SALT_ORE;

    public static Supplier<Block> ASPARAGUS_CROP;
    public static Supplier<Block> SWEET_POTATO_CROP;
    public static Supplier<Block> CHILI_PEPPER_CROP;
    public static Supplier<Block> PEANUT_CROP;

    public static Supplier<Block> CRANBERRY_PLANT;
    public static Supplier<Block> CRANBERRY_COBBLER;
    public static Supplier<Block> HONEYED_GOAT_CHEESE_TART;

    public EDBlocks() {}

    public static void register() {
        CINNAMON_SAPLING = RegUtils.regBlock("cinnamon_sapling",
                () -> new SaplingBlock(EDTreeGrowers.CINNAMON, RegUtils.blockPropsCopy(Blocks.OAK_SAPLING)));
        CINNAMON_LEAVES = RegUtils.regBlock("cinnamon_leaves",
                () -> new TintedParticleLeavesBlock(0.0F, RegUtils.blockPropsCopy(Blocks.OAK_LEAVES)));
        CINNAMON_LOG = RegUtils.regBlock("cinnamon_log",
                () -> new RotatedPillarBlock(RegUtils.blockPropsCopy(Blocks.OAK_LOG)));
        CINNAMON_STRIPPED_LOG = RegUtils.regBlock("stripped_cinnamon_log",
                () -> new RotatedPillarBlock(RegUtils.blockPropsCopy(Blocks.STRIPPED_OAK_LOG)));

        CASK = RegUtils.regBlock("cask",
                    () -> new CaskBlock(RegUtils.blockProps().mapColor(MapColor.WOOD).strength(1.0F, 1.0F).sound(SoundType.CHERRY_WOOD)));
        MILK_CASK = RegUtils.regBlock("milk_cask",
                    () -> new MilkCaskBlock(RegUtils.blockProps().mapColor(MapColor.WOOD).strength(1.0F, 1.0F).sound(SoundType.CHERRY_WOOD)));
        CHEESE_CASK = RegUtils.regBlock("cheese_cask",
                    () -> new CheeseCaskBlock(RegUtils.blockProps().mapColor(MapColor.WOOD).strength(1.0F, 1.0F).sound(SoundType.CHERRY_WOOD)));
        GOAT_MILK_CASK = RegUtils.regBlock("goat_milk_cask",
                () -> new MilkCaskBlock(RegUtils.blockProps().mapColor(MapColor.WOOD).strength(1.0F, 1.0F).sound(SoundType.CHERRY_WOOD)));
        GOAT_CHEESE_CASK = RegUtils.regBlock("goat_cheese_cask",
                () -> new CheeseCaskBlock(RegUtils.blockProps().mapColor(MapColor.WOOD).strength(1.0F, 1.0F).sound(SoundType.CHERRY_WOOD)));
        CHEESE_WHEEL = RegUtils.regBlock("cheese_wheel",
                    () -> new PieBlock(RegUtils.blockPropsCopy(Blocks.CAKE), () -> EDItems.CHEESE_SLICE.get()));
        GOAT_CHEESE_WHEEL = RegUtils.regBlock("goat_cheese_wheel",
                () -> new PieBlock(RegUtils.blockPropsCopy(Blocks.CAKE), () -> EDItems.GOAT_CHEESE_SLICE.get()));

        ASPARAGUS_CRATE = RegUtils.regBlock("asparagus_crate",
                () -> new CrateBlock(RegUtils.blockPropsCopy(Blocks.OAK_PLANKS)));
        SWEET_POTATO_CRATE = RegUtils.regBlock("sweet_potato_crate",
                () -> new CrateBlock(RegUtils.blockPropsCopy(Blocks.OAK_PLANKS)));
        CHILI_PEPPER_CRATE = RegUtils.regBlock("chili_pepper_crate",
                () -> new CrateBlock(RegUtils.blockPropsCopy(Blocks.OAK_PLANKS)));
        CRANBERRY_BAG = RegUtils.regBlock("cranberry_bag",
                () -> new CrateBlock(RegUtils.blockProps().mapColor(MapColor.COLOR_RED).strength(0.8F).sound(SoundType.WOOL).ignitedByLava()));

        WILD_ASPARAGUS  = RegUtils.regBlock("wild_asparagus",
                () -> new EDWildCropBlock(MobEffects.ABSORPTION, 6, RegUtils.blockPropsCopy(Blocks.TALL_GRASS)));
        WILD_SWEET_POTATO  = RegUtils.regBlock("wild_sweet_potato",
                () -> new EDWildCropBlock(MobEffects.OOZING, 6, RegUtils.blockPropsCopy(Blocks.TALL_GRASS)));
        WILD_CHILI_PEPPER  = RegUtils.regBlock("wild_chili_pepper",
                () -> new EDWildCropBlock(MobEffects.NAUSEA, 6, RegUtils.blockPropsCopy(Blocks.TALL_GRASS)));
        WILD_PEANUTS  = RegUtils.regBlock("wild_peanuts",
                () -> new EDWildCropBlock(MobEffects.RESISTANCE, 6, RegUtils.blockPropsCopy(Blocks.TALL_GRASS)));

        SALT_ORE = RegUtils.regBlock("salt_ore",
                () -> new DropExperienceBlock(UniformInt.of(0, 2), RegUtils.blockProps().mapColor(MapColor.STONE)
                        .strength(3.0f, 3.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
        DEEPSLATE_SALT_ORE = RegUtils.regBlock("deepslate_salt_ore",
                () -> new DropExperienceBlock(UniformInt.of(0, 2), RegUtils.blockProps().mapColor(MapColor.STONE)
                        .strength(4.5f, 3.0f).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));

        CRANBERRY_PLANT = RegUtils.regBlock("cranberry_plant",
                () -> new CranberryPlantBlock(RegUtils.blockPropsCopy(Blocks.LILY_PAD).mapColor(MapColor.PLANT).sound(SoundType.LILY_PAD)));
        CRANBERRY_COBBLER = RegUtils.regBlock("cranberry_cobbler",
                () -> new PieBlock(RegUtils.blockPropsCopy(Blocks.CAKE), () -> EDItems.CRANBERRY_COBBLER_SLICE.get()));
        HONEYED_GOAT_CHEESE_TART = RegUtils.regBlock("honeyed_goat_cheese_tart",
                () -> new PieBlock(RegUtils.blockPropsCopy(Blocks.CAKE), () -> EDItems.HONEYED_GOAT_CHEESE_TART_SLICE.get()));

        ASPARAGUS_CROP = RegUtils.regBlock("asparagus_crop", EDCropBlock::new);
        SWEET_POTATO_CROP = RegUtils.regBlock("sweet_potato_crop", EDCropBlock::new);
        CHILI_PEPPER_CROP = RegUtils.regBlock("chili_pepper_crop", EDCropBlock::new);
        PEANUT_CROP = RegUtils.regBlock("peanut_crop", EDCropBlock::new);
    }
}
