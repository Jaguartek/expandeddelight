package ianm1647.expandeddelight.common.event;

import ianm1647.expandeddelight.ExpandedDelight;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;

import java.util.Map;

/** Adds our items to the vanilla village house chests. This replaces the loot modifier files. */
public class EDLootEvents {

    public static void init() {
        Map<ResourceKey<LootTable>, String> additions = Map.of(
                BuiltInLootTables.VILLAGE_DESERT_HOUSE, "village_desert_house",
                BuiltInLootTables.VILLAGE_PLAINS_HOUSE, "village_plains_house",
                BuiltInLootTables.VILLAGE_SAVANNA_HOUSE, "village_savanna_house",
                BuiltInLootTables.VILLAGE_SNOWY_HOUSE, "village_snowy_house",
                BuiltInLootTables.VILLAGE_TAIGA_HOUSE, "village_taiga_house");

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            String ours = additions.get(key);
            if (ours != null) {
                ResourceKey<LootTable> extra = ResourceKey.create(Registries.LOOT_TABLE, ExpandedDelight.loc("chests/" + ours));
                tableBuilder.withPool(LootPool.lootPool().add(NestedLootTable.lootTableReference(extra)));
            }
        });
    }
}
