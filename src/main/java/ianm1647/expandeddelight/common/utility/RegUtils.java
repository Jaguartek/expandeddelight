package ianm1647.expandeddelight.common.utility;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

import ianm1647.expandeddelight.ExpandedDelight;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.storage.loot.LootTable;
import java.util.Optional;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class RegUtils {
    public RegUtils() {
    }

    // Since 1.21.2 every item and block needs its registry id set on its properties
    // before it is constructed. The id of whatever is being registered right now is kept
    // here so the property helpers below can use it.
    private static Identifier pendingId;

    public static <R, T extends R> Supplier<T> register(String name, Supplier<T> supplier, Registry<R> reg) {
        Identifier id = ExpandedDelight.loc(name);
        pendingId = id;
        T object;
        try {
            object = supplier.get();
        } finally {
            pendingId = null;
        }
        Registry.register(reg, id, object);
        return () -> object;
    }

    public static Item.Properties itemProps() {
        return new Item.Properties().setId(ResourceKey.create(Registries.ITEM, pendingId));
    }

    public static BlockBehaviour.Properties blockProps() {
        return withBlockId(BlockBehaviour.Properties.of());
    }

    public static BlockBehaviour.Properties blockPropsCopy(Block source) {
        return withBlockId(BlockBehaviour.Properties.ofFullCopy(source));
    }

    private static BlockBehaviour.Properties withBlockId(BlockBehaviour.Properties props) {
        // Point the loot table at this mod's own table so a copied block never inherits vanilla drops.
        return props.setId(ResourceKey.create(Registries.BLOCK, pendingId))
                .overrideLootTable(Optional.of(ResourceKey.create(Registries.LOOT_TABLE, pendingId.withPrefix("blocks/"))));
    }

    public static <B extends EntityType<?>> Supplier<B> regEntity(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.ENTITY_TYPE);
    }

    public static <B extends MenuType<?>> Supplier<B> regMenu(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.MENU);
    }

    public static <B extends PlacementModifierType<?>> Supplier<B> regPlacementMod(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.PLACEMENT_MODIFIER_TYPE);
    }

    public static <B extends RecipeSerializer<?>> Supplier<B> regRecipeSerializer(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.RECIPE_SERIALIZER);
    }

    public static <B extends RecipeType<?>> Supplier<B> regRecipe(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.RECIPE_TYPE);
    }

    public static <B extends ParticleType<?>> Supplier<B> regParticle(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.PARTICLE_TYPE);
    }

    public static <B extends SoundEvent> Supplier<B> regSound(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.SOUND_EVENT);
    }

    public static <B extends Feature<?>> Supplier<B> regFeature(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.FEATURE);
    }

    public static <B extends BlockEntityType<?>> Supplier<B> regBlockEntity(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.BLOCK_ENTITY_TYPE);
    }

    public static <B extends CreativeModeTab> Supplier<B> regTab(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.CREATIVE_MODE_TAB);
    }

    public static <B extends DataComponentType<?>> Supplier<B> regComponent(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.DATA_COMPONENT_TYPE);
    }

    public static <A> Supplier<DataComponentType<A>> regComponent(String name, Consumer<DataComponentType.Builder<A>> stuff) {
        DataComponentType.Builder<A> builder = DataComponentType.builder();
        stuff.accept(builder);
        Objects.requireNonNull(builder);
        return register(name, builder::build, BuiltInRegistries.DATA_COMPONENT_TYPE);
    }

    public static <A> Supplier<DataComponentType<A>> regEnchComponent(String name, Consumer<DataComponentType.Builder<A>> stuff) {
        DataComponentType.Builder<A> builder = DataComponentType.builder();
        stuff.accept(builder);
        Objects.requireNonNull(builder);
        return register(name, builder::build, BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE);
    }

    public static <B extends MobEffect> Supplier<B> regEffect(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.MOB_EFFECT);
    }

    public static <B extends Item> Supplier<B> regItem(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.ITEM);
    }

    public static <B extends Block> Supplier<B> regBlock(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.BLOCK);
    }

    public static <B extends FoliagePlacerType<?>> Supplier<B> regFoliagePlacer(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.FOLIAGE_PLACER_TYPE);
    }
}