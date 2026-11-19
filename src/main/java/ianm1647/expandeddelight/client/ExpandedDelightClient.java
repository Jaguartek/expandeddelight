package ianm1647.expandeddelight.client;

import net.fabricmc.api.ClientModInitializer;

public class ExpandedDelightClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // TODO: put these blocks in the CUTOUT chunk layer using Fabric API's block render layer map.
        // The class was renamed in 26.x and ChunkSectionLayerMap is not at net.fabricmc.fabric.api.client.rendering.v1.
        // Blocks to register: CINNAMON_SAPLING, WILD_SWEET_POTATO, WILD_ASPARAGUS, WILD_CHILI_PEPPER, WILD_PEANUTS,
        // CRANBERRY_PLANT, SWEET_POTATO_CROP, ASPARAGUS_CROP, CHILI_PEPPER_CROP, PEANUT_CROP.
    }
}
