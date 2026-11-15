package ianm1647.expandeddelight;

import ianm1647.expandeddelight.common.event.EDEvents;
import ianm1647.expandeddelight.common.registry.*;
import ianm1647.expandeddelight.common.world.tree.EDTreePlacers;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExpandedDelight implements ModInitializer {
	public static final String MODID = "expandeddelight";
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public void onInitialize() {
		EDBlocks.register();
		EDItems.register();
		EDBlockEntityTypes.register();
		EDTabs.register();

		EDTreePlacers.register();
		EDWoodTypes.bootstrap();

		EDEvents.register();
		LOGGER.info("Expanded Delight is loading...");
	}

	public static ResourceLocation loc(String path) {
		return ResourceLocation.fromNamespaceAndPath(MODID, path);
	}
}