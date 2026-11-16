package ianm1647.expandeddelight.client;

import ianm1647.expandeddelight.common.registry.EDBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ChunkSectionLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.world.level.block.Block;

public class ExpandedDelightClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ChunkSectionLayerMap.INSTANCE.putBlocks(ChunkSectionLayer.CUTOUT,
                EDBlocks.CINNAMON_SAPLING.get(),
                EDBlocks.WILD_SWEET_POTATO.get(),
                EDBlocks.WILD_ASPARAGUS.get(),
                EDBlocks.WILD_CHILI_PEPPER.get(),
                EDBlocks.WILD_PEANUTS.get(),
                EDBlocks.CRANBERRY_PLANT.get(),
                EDBlocks.SWEET_POTATO_CROP.get(),
                EDBlocks.ASPARAGUS_CROP.get(),
                EDBlocks.CHILI_PEPPER_CROP.get(),
                EDBlocks.PEANUT_CROP.get());

    }
}
