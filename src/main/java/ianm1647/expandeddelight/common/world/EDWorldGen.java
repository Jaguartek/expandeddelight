package ianm1647.expandeddelight.common.world;

import ianm1647.expandeddelight.ExpandedDelight;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.function.Predicate;

/** Adds our placed features to biomes. This replaces the NeoForge biome modifier files. */
public class EDWorldGen {

    public static void register() {
        add(BiomeSelectors.includeByKey(Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS), GenerationStep.Decoration.VEGETAL_DECORATION, "patch_wild_asparagus");
        add(BiomeSelectors.includeByKey(Biomes.DESERT), GenerationStep.Decoration.VEGETAL_DECORATION, "patch_wild_chili_pepper");
        add(BiomeSelectors.tag(BiomeTags.IS_SAVANNA), GenerationStep.Decoration.VEGETAL_DECORATION, "patch_wild_peanuts");
        add(BiomeSelectors.tag(BiomeTags.IS_JUNGLE), GenerationStep.Decoration.VEGETAL_DECORATION, "patch_wild_sweet_potato");
        add(BiomeSelectors.includeByKey(Biomes.SWAMP, Biomes.MANGROVE_SWAMP), GenerationStep.Decoration.VEGETAL_DECORATION, "patch_cranberries");
        add(BiomeSelectors.tag(BiomeTags.IS_OCEAN), GenerationStep.Decoration.UNDERGROUND_ORES, "salt_ore");
    }

    private static void add(Predicate<BiomeSelectionContext> biomes, GenerationStep.Decoration step, String placedFeature) {
        BiomeModifications.addFeature(biomes, step, ResourceKey.create(Registries.PLACED_FEATURE, ExpandedDelight.loc(placedFeature)));
    }
}
