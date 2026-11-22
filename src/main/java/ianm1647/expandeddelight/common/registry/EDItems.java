package ianm1647.expandeddelight.common.registry;

import com.google.common.collect.Sets;
import ianm1647.expandeddelight.common.item.JellyItem;
import ianm1647.expandeddelight.common.item.LilypadCropItem;
import ianm1647.expandeddelight.common.utility.RegUtils;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.*;
import net.minecraft.world.item.consume_effects.*;
import net.minecraft.world.item.*;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.Supplier;

public class EDItems {
    public static LinkedHashSet<Supplier<Item>> CREATIVE_TAB_ITEMS;

    public static Supplier<Item> CINNAMON_SAPLING;
    public static Supplier<Item> CINNAMON_LEAVES;
    public static Supplier<Item> CINNAMON_LOG;
    public static Supplier<Item> CINNAMON_STRIPPED_LOG;

    public static Supplier<Item> CASK;
    public static Supplier<Item> MILK_CASK;
    public static Supplier<Item> GOAT_MILK_CASK;
    public static Supplier<Item> CHEESE_CASK;
    public static Supplier<Item> GOAT_CHEESE_CASK;

    public static Supplier<Item> ASPARAGUS_CRATE;
    public static Supplier<Item> SWEET_POTATO_CRATE;
    public static Supplier<Item> CHILI_PEPPER_CRATE;
    public static Supplier<Item> CRANBERRY_BAG;

    public static Supplier<Item> WILD_ASPARAGUS;
    public static Supplier<Item> WILD_SWEET_POTATO;
    public static Supplier<Item> WILD_CHILI_PEPPER;
    public static Supplier<Item> WILD_PEANUTS;

    public static Supplier<Item> SALT_ORE;
    public static Supplier<Item> DEEPSLATE_SALT_ORE;

    public static Supplier<Item> CRUSHING_MALLET;
    public static Supplier<Item> GLASS_JAR;

    public static Supplier<Item> CINNAMON_STICK;
    public static Supplier<Item> CINNAMON;
    public static Supplier<Item> SALT_ROCK;
    public static Supplier<Item> SALT;

    public static Supplier<Item> GOAT_MILK_BUCKET;
    public static Supplier<Item> GOAT_MILK_BOTTLE;

    public static Supplier<Item> ASPARAGUS;
    public static Supplier<Item> ASPARAGUS_SEEDS;
    public static Supplier<Item> SWEET_POTATO;
    public static Supplier<Item> BAKED_SWEET_POTATO;
    public static Supplier<Item> LOADED_BAKED_POTATO;
    public static Supplier<Item> CHILI_PEPPER;
    public static Supplier<Item> CHILI_PEPPER_SEEDS;
    public static Supplier<Item> PEANUT;

    public static Supplier<Item> ANCIENT_FRUIT;
    public static Supplier<Item> ANCIENT_SEEDS;
    public static Supplier<Item> CRANBERRIES;
    public static Supplier<Item> CRANBERRY_PLANT;
    public static Supplier<Item> LEMON;
    public static Supplier<Item> LEMON_SEEDS;

    public static Supplier<Item> CHEESE_WHEEL;
    public static Supplier<Item> GOAT_CHEESE_WHEEL;
    public static Supplier<Item> CHEESE_SLICE;
    public static Supplier<Item> GOAT_CHEESE_SLICE;

    public static Supplier<Item> CHEESE_SANDWICH;
    public static Supplier<Item> GRILLED_CHEESE;
    public static Supplier<Item> CRANBERRY_GOAT_CHESE_TOAST;
    public static Supplier<Item> GOAT_CHEESE_SOUFFLE;

    public static Supplier<Item> PEANUT_BUTTER;
    public static Supplier<Item> PEANUT_BUTTER_SANDWICH;
    public static Supplier<Item> PEANUT_BUTTER_HONEY_SANDWICH;
    public static Supplier<Item> APPLE_JELLY_SANDWICH;
    public static Supplier<Item> MELON_JELLY_SANDWICH;
    public static Supplier<Item> SWEET_BERRY_JELLY_SANDWICH;
    public static Supplier<Item> GLOW_BERRY_JELLY_SANDWICH;
    public static Supplier<Item> CRANBERRY_JELLY_SANDWICH;

    public static Supplier<Item> CHOCOLATE_COOKIE;
    public static Supplier<Item> SUGAR_COOKIE;
    public static Supplier<Item> SNICKERDOODLE;

    public static Supplier<Item> CINNAMON_RICE;
    public static Supplier<Item> CINNAMON_APPLES;

    public static Supplier<Item> APPLE_JUICE;
    public static Supplier<Item> SWEET_BERRY_JUICE;
    public static Supplier<Item> GLOW_BERRY_JUICE;
    public static Supplier<Item> CRANBERRY_JUICE;
    public static Supplier<Item> LEMONADE;
    public static Supplier<Item> SWEET_BERRY_LEMONADE;
    public static Supplier<Item> GLOW_BERRY_LEMONADE;
    public static Supplier<Item> CRANBERRY_LEMONADE;

    public static Supplier<Item> APPLE_JELLY;
    public static Supplier<Item> MELON_JELLY;
    public static Supplier<Item> SWEET_BERRY_JELLY;
    public static Supplier<Item> GLOW_BERRY_JELLY;
    public static Supplier<Item> CRANBERRY_JELLY;

    public static Supplier<Item> SWEET_ROLL;
    public static Supplier<Item> BERRY_SWEET_ROLL;
    public static Supplier<Item> GLOW_BERRY_SWEET_ROLL;

    public static Supplier<Item> CRANBERRY_COBBLER;
    public static Supplier<Item> CRANBERRY_COBBLER_SLICE;
    public static Supplier<Item> UNCOOKED_CHEESE_PIZZA;
    public static Supplier<Item> CHEESE_PIZZA;
    public static Supplier<Item> CHEESE_PIZZA_SLICE;
    public static Supplier<Item> UNCOOKED_SAUSAGE_PIZZA;
    public static Supplier<Item> SAUSAGE_PIZZA;
    public static Supplier<Item> SAUSAGE_PIZZA_SLICE;
    public static Supplier<Item> UNCOOKED_PEPPERONI_PIZZA;
    public static Supplier<Item> PEPPERONI_PIZZA;
    public static Supplier<Item> PEPPERONI_PIZZA_SLICE;
    public static Supplier<Item> HONEYED_GOAT_CHEESE_TART;
    public static Supplier<Item> HONEYED_GOAT_CHEESE_TART_SLICE;
    public static Supplier<Item> LEMON_MERINGUE_PIE;
    public static Supplier<Item> LEMON_MERINGUE_PIE_SLICE;

    public static Supplier<Item> PEANUT_SALAD;
    public static Supplier<Item> SWEET_POTATO_SALAD;
    public static Supplier<Item> GOAT_CHEESE_BEETROOT_SALAD;
    public static Supplier<Item> CHILI_CUCUMBER_SALAD;

    public static Supplier<Item> ASPARAGUS_SOUP;
    public static Supplier<Item> ASPARAGUS_SOUP_CREAMY;
    public static Supplier<Item> PEANUT_HONEY_SOUP;
    public static Supplier<Item> TOMATO_SOUP;
    public static Supplier<Item> CHICKEN_GOAT_CHEESE_SOUP;

    public static Supplier<Item> MAC_AND_CHEESE;
    public static Supplier<Item> ASPARAGUS_BACON_MEAL;
    public static Supplier<Item> ASPARAGUS_MUSHROOM_PASTA;
    public static Supplier<Item> ASPARAGUS_FRITTATA;
    public static Supplier<Item> PEPERONATA;
    public static Supplier<Item> CHILI_PEPPER_SALMON;
    public static Supplier<Item> SWEET_POTATO_CASSEROLE;
    public static Supplier<Item> CRANBERRY_CHICKEN;
    public static Supplier<Item> GOAT_CHEESE_RATATOUILLE;

    public EDItems() {}

    public static void register() {
        CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();

        CINNAMON_SAPLING = registerWithTab("cinnamon_sapling", () -> new BlockItem(EDBlocks.CINNAMON_SAPLING.get(), basicItem().useBlockDescriptionPrefix()));
        CINNAMON_LEAVES = registerWithTab("cinnamon_leaves", () -> new BlockItem(EDBlocks.CINNAMON_LEAVES.get(), basicItem().useBlockDescriptionPrefix()));
        CINNAMON_LOG = registerWithTab("cinnamon_log", () -> new BlockItem(EDBlocks.CINNAMON_LOG.get(), basicItem().useBlockDescriptionPrefix()));
        CINNAMON_STRIPPED_LOG = registerWithTab("stripped_cinnamon_log", () -> new BlockItem(EDBlocks.CINNAMON_STRIPPED_LOG.get(), basicItem().useBlockDescriptionPrefix()));

        CASK = registerWithTab("cask", () -> new BlockItem(EDBlocks.CASK.get(), basicItem().useBlockDescriptionPrefix()));
        MILK_CASK = registerWithoutTab("milk_cask", () -> new BlockItem(EDBlocks.MILK_CASK.get(), basicItem().useBlockDescriptionPrefix()));
        CHEESE_CASK = registerWithoutTab("cheese_cask", () -> new BlockItem(EDBlocks.CHEESE_CASK.get(), basicItem().useBlockDescriptionPrefix()));
        GOAT_MILK_CASK = registerWithoutTab("goat_milk_cask", () -> new BlockItem(EDBlocks.GOAT_MILK_CASK.get(), basicItem().useBlockDescriptionPrefix()));
        GOAT_CHEESE_CASK = registerWithoutTab("goat_cheese_cask", () -> new BlockItem(EDBlocks.GOAT_CHEESE_CASK.get(), basicItem().useBlockDescriptionPrefix()));

        ASPARAGUS_CRATE = registerWithTab("asparagus_crate", () -> new BlockItem(EDBlocks.ASPARAGUS_CRATE.get(), basicItem().useBlockDescriptionPrefix()));
        SWEET_POTATO_CRATE = registerWithTab("sweet_potato_crate", () -> new BlockItem(EDBlocks.SWEET_POTATO_CRATE.get(), basicItem().useBlockDescriptionPrefix()));
        CHILI_PEPPER_CRATE = registerWithTab("chili_pepper_crate", () -> new BlockItem(EDBlocks.CHILI_PEPPER_CRATE.get(), basicItem().useBlockDescriptionPrefix()));
        CRANBERRY_BAG = registerWithTab("cranberry_bag", () -> new BlockItem(EDBlocks.CRANBERRY_BAG.get(), basicItem().useBlockDescriptionPrefix()));

        WILD_ASPARAGUS = registerWithTab("wild_asparagus", () -> new BlockItem(EDBlocks.WILD_ASPARAGUS.get(), basicItem().useBlockDescriptionPrefix()));
        WILD_SWEET_POTATO = registerWithTab("wild_sweet_potato", () -> new BlockItem(EDBlocks.WILD_SWEET_POTATO.get(), basicItem().useBlockDescriptionPrefix()));
        WILD_CHILI_PEPPER = registerWithTab("wild_chili_pepper", () -> new BlockItem(EDBlocks.WILD_CHILI_PEPPER.get(), basicItem().useBlockDescriptionPrefix()));
        WILD_PEANUTS = registerWithTab("wild_peanuts", () -> new BlockItem(EDBlocks.WILD_PEANUTS.get(), basicItem().useBlockDescriptionPrefix()));
        CRANBERRY_PLANT = registerWithoutTab("cranberry_plant", () -> new BlockItem(EDBlocks.CRANBERRY_PLANT.get(), basicItem().useBlockDescriptionPrefix()));

        SALT_ORE = registerWithTab("salt_ore", () -> new BlockItem(EDBlocks.SALT_ORE.get(), basicItem().useBlockDescriptionPrefix()));
        DEEPSLATE_SALT_ORE = registerWithTab("deepslate_salt_ore", () -> new BlockItem(EDBlocks.DEEPSLATE_SALT_ORE.get(), basicItem().useBlockDescriptionPrefix()));

        CRUSHING_MALLET = registerWithTab("crushing_mallet", () -> new Item(basicItem().durability(64).stacksTo(1)));
        GLASS_JAR = registerWithTab("glass_jar", () -> new Item(basicItem()));

        CINNAMON_STICK = registerWithTab("cinnamon_stick", () -> new Item(basicItem()));
        CINNAMON = registerWithTab("cinnamon", () -> new Item(basicItem()));
        SALT_ROCK = registerWithTab("salt_rock", () -> new Item(basicItem()));
        SALT = registerWithTab("salt", () -> new Item(basicItem()));

        GOAT_MILK_BUCKET = registerWithTab("goat_milk_bucket", () -> new Item(basicItem().craftRemainder(Items.BUCKET)
                .component(DataComponents.CONSUMABLE, Consumables.MILK_BUCKET).usingConvertsTo(Items.BUCKET).stacksTo(1)));
        GOAT_MILK_BOTTLE = registerWithTab("goat_milk_bottle", () -> new Item(basicItem().craftRemainder(Items.GLASS_BOTTLE).usingConvertsTo(Items.GLASS_BOTTLE).stacksTo(16)
                .component(DataComponents.CONSUMABLE, Consumable.builder().consumeSeconds(1.6f).animation(ItemUseAnimation.DRINK)
                        .sound(SoundEvents.HONEY_DRINK).onConsume(new ClearAllStatusEffectsConsumeEffect()).build())));

        ASPARAGUS_SEEDS = registerWithTab("asparagus_seeds", () -> new BlockItem(EDBlocks.ASPARAGUS_CROP.get(), basicItem().useItemDescriptionPrefix()));
        ASPARAGUS = registerWithTab("asparagus", () -> new Item(foodItem(2, 0.2f)));
        SWEET_POTATO = registerWithTab("sweet_potato", () -> new BlockItem(EDBlocks.SWEET_POTATO_CROP.get(), foodItem(2, 0.2f).useItemDescriptionPrefix()));
        CHILI_PEPPER_SEEDS = registerWithTab("chili_pepper_seeds", () -> new BlockItem(EDBlocks.CHILI_PEPPER_CROP.get(), basicItem().useItemDescriptionPrefix()));
        CHILI_PEPPER = registerWithTab("chili_pepper", () -> new Item(foodItem(2, 0.1f)));
        PEANUT = registerWithTab("peanut", () -> new BlockItem(EDBlocks.PEANUT_CROP.get(), foodItem(1, 0f).useItemDescriptionPrefix()));
        CRANBERRIES = registerWithTab("cranberries", () -> new LilypadCropItem(EDBlocks.CRANBERRY_PLANT.get(), foodItem(2, 0.5f)));

        BAKED_SWEET_POTATO = registerWithTab("baked_sweet_potato", () -> new Item(foodItem(6, 0.4f)));
        LOADED_BAKED_POTATO = registerWithTab("loaded_baked_potato", () -> new Item(foodItem(10, 0.6f)));

        CHEESE_WHEEL = registerWithTab("cheese_wheel", () -> new BlockItem(EDBlocks.CHEESE_WHEEL.get(), basicItem().useBlockDescriptionPrefix()));
        CHEESE_SLICE = registerWithTab("cheese_slice", () -> new Item(foodItem(2, 0.2f)));
        GOAT_CHEESE_WHEEL = registerWithTab("goat_cheese_wheel", () -> new BlockItem(EDBlocks.GOAT_CHEESE_WHEEL.get(), basicItem().useBlockDescriptionPrefix()));
        GOAT_CHEESE_SLICE = registerWithTab("goat_cheese_slice", () -> new Item(foodItem(2, 0.2f)));

        CHEESE_SANDWICH = registerWithTab("cheese_sandwich", () -> new Item(foodItem(5, 0.3f)));
        GRILLED_CHEESE = registerWithTab("grilled_cheese", () -> new Item(foodItem(8, 0.5f)));
        CRANBERRY_GOAT_CHESE_TOAST = registerWithTab("cranberry_goat_cheese_toast", () -> new Item(foodItem(4, 0.6f)));

        PEANUT_BUTTER = registerWithTab("peanut_butter", () -> new Item(foodItem(2, 0.3f).craftRemainder(Items.BOWL)));
        PEANUT_BUTTER_SANDWICH = registerWithTab("peanut_butter_sandwich", () -> new Item(foodItem(6, 0.4f)));
        PEANUT_BUTTER_HONEY_SANDWICH = registerWithTab("peanut_butter_honey_sandwich", () -> new Item(foodItem(7, 0.5f)));
        SWEET_BERRY_JELLY_SANDWICH = registerWithTab("sweet_berry_jelly_sandwich", () -> new Item(foodItem(7, 0.5f)));
        GLOW_BERRY_JELLY_SANDWICH = registerWithTab("glow_berry_jelly_sandwich", () -> new Item(foodItem(7, 0.5f)));
        CRANBERRY_JELLY_SANDWICH = registerWithTab("cranberry_jelly_sandwich", () -> new Item(foodItem(7, 0.6f)));

        SWEET_ROLL = registerWithTab("sweet_roll", () -> new Item(foodItem(5, 0.3f)));
        BERRY_SWEET_ROLL = registerWithTab("berry_sweet_roll", () -> new Item(foodItem(6, 0.5f)));
        GLOW_BERRY_SWEET_ROLL = registerWithTab("glow_berry_sweet_roll", () -> new Item(foodItem(6, 0.5f)));

        CRANBERRY_COBBLER = registerWithTab("cranberry_cobbler", () -> new BlockItem(EDBlocks.CRANBERRY_COBBLER.get(), basicItem().useBlockDescriptionPrefix()));
        CRANBERRY_COBBLER_SLICE = registerWithTab("cranberry_cobbler_slice", () -> new Item(pieSliceItem(3, 0.3f)));
        UNCOOKED_CHEESE_PIZZA = registerWithTab("uncooked_cheese_pizza", () -> new Item(basicItem()));
        CHEESE_PIZZA = registerWithTab("cheese_pizza", () -> new BlockItem(EDBlocks.CHEESE_PIZZA.get(), basicItem().useBlockDescriptionPrefix()));
        CHEESE_PIZZA_SLICE = registerWithTab("cheese_pizza_slice", () -> new Item(pizzaSliceItem(5, 0.5f)));
        UNCOOKED_SAUSAGE_PIZZA = registerWithTab("uncooked_sausage_pizza", () -> new Item(basicItem()));
        SAUSAGE_PIZZA = registerWithTab("sausage_pizza", () -> new BlockItem(EDBlocks.SAUSAGE_PIZZA.get(), basicItem().useBlockDescriptionPrefix()));
        SAUSAGE_PIZZA_SLICE = registerWithTab("sausage_pizza_slice", () -> new Item(pizzaSliceItem(6, 0.6f)));
        UNCOOKED_PEPPERONI_PIZZA = registerWithTab("uncooked_pepperoni_pizza", () -> new Item(basicItem()));
        PEPPERONI_PIZZA = registerWithTab("pepperoni_pizza", () -> new BlockItem(EDBlocks.PEPPERONI_PIZZA.get(), basicItem().useBlockDescriptionPrefix()));
        PEPPERONI_PIZZA_SLICE = registerWithTab("pepperoni_pizza_slice", () -> new Item(pizzaSliceItem(7, 0.6f)));
        HONEYED_GOAT_CHEESE_TART = registerWithTab("honeyed_goat_cheese_tart", () -> new BlockItem(EDBlocks.HONEYED_GOAT_CHEESE_TART.get(), basicItem().useBlockDescriptionPrefix()));
        HONEYED_GOAT_CHEESE_TART_SLICE = registerWithTab("honeyed_goat_cheese_tart_slice", () -> new Item(pieSliceItem(4, 0.5f)));

        CHOCOLATE_COOKIE = registerWithTab("chocolate_cookie", () -> new Item(foodItem(2, 0.3f)));
        SUGAR_COOKIE = registerWithTab("sugar_cookie", () -> new Item(foodItem(2, 0.3f)));
        SNICKERDOODLE = registerWithTab("snickerdoodle", () -> new Item(foodItem(2, 0.4f)));

        CINNAMON_RICE = registerWithTab("cinnamon_rice", () -> new Item(foodItem(7, 0.5f).craftRemainder(Items.BOWL)));
        CINNAMON_APPLES = registerWithTab("cinnamon_apples", () -> new Item(foodItem(7, 0.5f).craftRemainder(Items.BOWL)));

        APPLE_JUICE = registerWithTab("apple_juice", () -> new Item(drinkItem(1, 1.2f, MobEffects.SPEED)));
        SWEET_BERRY_JUICE = registerWithTab("sweet_berry_juice", () -> new Item(drinkItem(1, 1.2f, MobEffects.HEALTH_BOOST)));
        GLOW_BERRY_JUICE = registerWithTab("glow_berry_juice", () -> new Item(drinkItem(1, 1.2f, MobEffects.NIGHT_VISION)));
        CRANBERRY_JUICE = registerWithTab("cranberry_juice", () -> new Item(drinkItem(1, 1.2f, MobEffects.ABSORPTION)));

        SWEET_BERRY_JELLY = registerWithTab("sweet_berry_jelly", () -> new JellyItem(jellyItem(3, 0.6f, MobEffects.HEALTH_BOOST), true));
        GLOW_BERRY_JELLY = registerWithTab("glow_berry_jelly", () -> new JellyItem(jellyItem(3, 0.6f, MobEffects.NIGHT_VISION), true));
        CRANBERRY_JELLY = registerWithTab("cranberry_jelly", () -> new JellyItem(jellyItem(3, 0.6f, MobEffects.ABSORPTION), true));

        PEANUT_SALAD = registerWithTab("peanut_salad", () -> new ConsumableItem(saladItem(8, 0.6f)));
        SWEET_POTATO_SALAD = registerWithTab("sweet_potato_salad", () -> new ConsumableItem(saladItem(8, 0.4f)));
        GOAT_CHEESE_BEETROOT_SALAD = registerWithTab("goat_cheese_beetroot_salad", () -> new ConsumableItem(saladItem(7, 0.3f)));

        ASPARAGUS_SOUP = registerWithTab("asparagus_soup", () -> new ConsumableItem(stewItem(10, 0.8f)));
        ASPARAGUS_SOUP_CREAMY = registerWithTab("asparagus_soup_creamy", () -> new ConsumableItem(stewItem(11, 0.9f)));
        PEANUT_HONEY_SOUP = registerWithTab("peanut_honey_soup", () -> new ConsumableItem(stewItem(10, 0.8f)));
        TOMATO_SOUP = registerWithTab("tomato_soup", () -> new ConsumableItem(stewItem(10, 0.8f)));
        MAC_AND_CHEESE = registerWithTab("mac_and_cheese", () -> new ConsumableItem(stewItem(12, 0.8f)));

        ASPARAGUS_BACON_MEAL = registerWithTab("asparagus_and_bacon_cheesy", () -> new ConsumableItem(mealItem(10, 0.8f)));
        ASPARAGUS_MUSHROOM_PASTA = registerWithTab("asparagus_mushroom_pasta", () -> new ConsumableItem(mealItem(12, 0.9f)));
        ASPARAGUS_FRITTATA = registerWithTab("asparagus_frittata", () -> new ConsumableItem(mealItem(11, 0.8f)));
        PEPERONATA = registerWithTab("peperonata", () -> new ConsumableItem(mealItem(12, 0.9f)));
        CHILI_PEPPER_SALMON = registerWithTab("chili_pepper_salmon", () -> new ConsumableItem(mealItem(13, 1.0f)));
        CRANBERRY_CHICKEN = registerWithTab("cranberry_chicken", () -> new ConsumableItem(mealItem(10, 0.8f)));
        SWEET_POTATO_CASSEROLE = registerWithTab("sweet_potato_casserole", () -> new ConsumableItem(mealItem(11, 0.8f)));

    }

    public static Supplier<Item> registerWithTab(String name, Supplier<Item> supplier) {
        Supplier<Item> item = RegUtils.regItem(name, supplier);
        CreativeModeTabEvents.modifyOutputEvent(EDTabs.ED_TAB_KEY).register(output -> output.accept(item.get()));
        return item;
    }

    public static Supplier<Item> registerWithoutTab(String name, Supplier<Item> supplier) {
        return RegUtils.regItem(name, supplier);
    }

    public static Item.Properties basicItem() {
        return RegUtils.itemProps();
    }

    public static Item.Properties foodItem(int nutrition, float saturation) {
        return (basicItem().food(new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation).build()));
    }

    private static FoodProperties food(int nutrition, float saturation) {
        return new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation).build();
    }

    private static Consumable consumable(Consumable.Builder builder, Holder<MobEffect> effect, int durationTicks) {
        return builder.onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(effect, durationTicks, 0), 1.0f)).build();
    }

    public static Item.Properties drinkItem(int nutrition, float saturation, Holder<MobEffect> effect) {
        return basicItem().craftRemainder(Items.GLASS_BOTTLE).usingConvertsTo(Items.GLASS_BOTTLE).stacksTo(16)
                .food(food(nutrition, saturation), consumable(Consumables.defaultDrink(), effect, 200));
    }

    public static Item.Properties jellyItem(int nutrition, float saturation, Holder<MobEffect> effect) {
        return basicItem().craftRemainder(GLASS_JAR.get()).stacksTo(16)
                .food(food(nutrition, saturation), consumable(Consumables.defaultFood(), effect, 400));
    }

    public static Item.Properties pieSliceItem(int nutrition, float saturation) {
        return basicItem().food(food(nutrition, saturation),
                consumable(Consumables.defaultFood().consumeSeconds(0.8f), MobEffects.SPEED, 600));
    }

    public static Item.Properties pizzaSliceItem(int nutrition, float saturation) {
        return basicItem().food(food(nutrition, saturation), Consumables.defaultFood().consumeSeconds(0.8f).build());
    }

    public static Item.Properties stewItem(int nutrition, float saturation) {
        return basicItem().craftRemainder(Items.BOWL).stacksTo(16)
                .food(food(nutrition, saturation), consumable(Consumables.defaultFood(), ModEffects.COMFORT, 2400));
    }

    public static Item.Properties saladItem(int nutrition, float saturation) {
        return basicItem().craftRemainder(Items.BOWL).stacksTo(16)
                .food(food(nutrition, saturation), consumable(Consumables.defaultFood(), MobEffects.REGENERATION, 100));
    }

    public static Item.Properties mealItem(int nutrition, float saturation) {
        return basicItem().craftRemainder(Items.BOWL).stacksTo(16)
                .food(food(nutrition, saturation), consumable(Consumables.defaultFood(), ModEffects.NOURISHMENT, 3600));
    }

}
