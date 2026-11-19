package ianm1647.expandeddelight.client;

import net.fabricmc.api.ClientModInitializer;

public class ExpandedDelightClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Minecraft 26.x picks the chunk render layer (solid, cutout, translucent) from each texture's transparency,
        // and Fabric API no longer has a block render layer map, so the crops and plants need no registration here.
    }
}
