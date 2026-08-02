package com.knox.auxilium.item;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import com.knox.auxilium.Auxilium;
import com.knox.auxilium.item.custom.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Auxilium.MODID);

    // === БОЕВЫЕ ТОПОРЫ ===
    public static final DeferredItem<Item> IRON_BATTLE_AXE = ITEMS.register("iron_battle_axe",
            () -> new BattleAxeItem(ModTiers.IRON_TIER, 7, -3.0F, new Item.Properties()));
    public static final DeferredItem<Item> GOLDEN_BATTLE_AXE = ITEMS.register("golden_battle_axe",
            () -> new BattleAxeItem(ModTiers.GOLD_TIER, 6, -2.8F, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_BATTLE_AXE = ITEMS.register("diamond_battle_axe",
            () -> new BattleAxeItem(ModTiers.DIAMOND_TIER, 9, -3.2F, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_BATTLE_AXE = ITEMS.register("netherite_battle_axe",
            () -> new BattleAxeItem(ModTiers.NETHERITE_TIER, 10, -3.4F, new Item.Properties().fireResistant()));

    // === КИНЖАЛЫ ===
    public static final DeferredItem<Item> IRON_DAGGER = ITEMS.register("iron_dagger",
            () -> new DaggerItem(ModTiers.IRON_TIER, 4, 1.6F, new Item.Properties()));
    public static final DeferredItem<Item> GOLDEN_DAGGER = ITEMS.register("golden_dagger",
            () -> new DaggerItem(ModTiers.GOLD_TIER, 3, 1.8F, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_DAGGER = ITEMS.register("diamond_dagger",
            () -> new DaggerItem(ModTiers.DIAMOND_TIER, 5, 1.5F, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_DAGGER = ITEMS.register("netherite_dagger",
            () -> new DaggerItem(ModTiers.NETHERITE_TIER, 6, 1.4F, new Item.Properties().fireResistant()));

    // === УЛУЧШЕННЫЕ ЩИТЫ ===
    public static final DeferredItem<Item> IRON_SHIELD = ITEMS.register("iron_shield",
            () -> new EnhancedShieldItem(new Item.Properties().durability(224), false));
    public static final DeferredItem<Item> GOLDEN_SHIELD = ITEMS.register("golden_shield",
            () -> new EnhancedShieldItem(new Item.Properties().durability(112), false));
    public static final DeferredItem<Item> DIAMOND_SHIELD = ITEMS.register("diamond_shield",
            () -> new EnhancedShieldItem(new Item.Properties().durability(448), false));
    public static final DeferredItem<Item> NETHERITE_SHIELD = ITEMS.register("netherite_shield",
            () -> new EnhancedShieldItem(new Item.Properties().durability(592).fireResistant(), false));
    
    // Щиты со светом (крафт со светокамнем)
    public static final DeferredItem<Item> IRON_LIGHT_SHIELD = ITEMS.register("iron_light_shield",
            () -> new EnhancedShieldItem(new Item.Properties().durability(224), true));
    public static final DeferredItem<Item> GOLDEN_LIGHT_SHIELD = ITEMS.register("golden_light_shield",
            () -> new EnhancedShieldItem(new Item.Properties().durability(112), true));
    public static final DeferredItem<Item> DIAMOND_LIGHT_SHIELD = ITEMS.register("diamond_light_shield",
            () -> new EnhancedShieldItem(new Item.Properties().durability(448), true));
    public static final DeferredItem<Item> NETHERITE_LIGHT_SHIELD = ITEMS.register("netherite_light_shield",
            () -> new EnhancedShieldItem(new Item.Properties().durability(592).fireResistant(), true));

    // === КОСЫ ===
    public static final DeferredItem<Item> IRON_SCYTHE = ITEMS.register("iron_scythe",
            () -> new ScytheItem(ModTiers.IRON_TIER, 5, -2.8F, new Item.Properties()));
    public static final DeferredItem<Item> GOLDEN_SCYTHE = ITEMS.register("golden_scythe",
            () -> new ScytheItem(ModTiers.GOLD_TIER, 4, -2.5F, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_SCYTHE = ITEMS.register("diamond_scythe",
            () -> new ScytheItem(ModTiers.DIAMOND_TIER, 6, -3.0F, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_SCYTHE = ITEMS.register("netherite_scythe",
            () -> new ScytheItem(ModTiers.NETHERITE_TIER, 7, -3.2F, new Item.Properties().fireResistant()));

    // === МУЛЬТИИНСТРУМЕНТЫ ===
    public static final DeferredItem<Item> IRON_MULTI_TOOL = ITEMS.register("iron_multi_tool",
            () -> new MultiToolItem(ModTiers.IRON_TIER, new Item.Properties()));
    public static final DeferredItem<Item> GOLDEN_MULTI_TOOL = ITEMS.register("golden_multi_tool",
            () -> new MultiToolItem(ModTiers.GOLD_TIER, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_MULTI_TOOL = ITEMS.register("diamond_multi_tool",
            () -> new MultiToolItem(ModTiers.DIAMOND_TIER, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_MULTI_TOOL = ITEMS.register("netherite_multi_tool",
            () -> new MultiToolItem(ModTiers.NETHERITE_TIER, new Item.Properties().fireResistant()));

    // === РЮКЗАКИ ===
    public static final DeferredItem<Item> LEATHER_BACKPACK = ITEMS.register("leather_backpack",
            () -> new BackpackItem(new Item.Properties(), 27));
    public static final DeferredItem<Item> IRON_BACKPACK = ITEMS.register("iron_backpack",
            () -> new BackpackItem(new Item.Properties(), 36));
    public static final DeferredItem<Item> GOLDEN_BACKPACK = ITEMS.register("golden_backpack",
            () -> new BackpackItem(new Item.Properties(), 45));
    public static final DeferredItem<Item> DIAMOND_BACKPACK = ITEMS.register("diamond_backpack",
            () -> new BackpackItem(new Item.Properties(), 54));
    public static final DeferredItem<Item> NETHERITE_BACKPACK = ITEMS.register("netherite_backpack",
            () -> new BackpackItem(new Item.Properties().fireResistant(), 63));

    // === УЛУЧШЕННЫЕ ТОТЕМЫ ===
    public static final DeferredItem<Item> DIAMOND_TOTEM = ITEMS.register("diamond_totem",
            () -> new ImprovedTotemItem(new Item.Properties().stacksTo(1), 2));
    public static final DeferredItem<Item> NETHERITE_TOTEM = ITEMS.register("netherite_totem",
            () -> new ImprovedTotemItem(new Item.Properties().stacksTo(1).fireResistant(), 3));

    // === ДВУРУЧНЫЕ МЕЧИ ===
    public static final DeferredItem<Item> IRON_GREAT_SWORD = ITEMS.register("iron_great_sword",
            () -> new GreatSwordItem(ModTiers.IRON_TIER, 10, -3.5F, new Item.Properties()));
    public static final DeferredItem<Item> GOLDEN_GREAT_SWORD = ITEMS.register("golden_great_sword",
            () -> new GreatSwordItem(ModTiers.GOLD_TIER, 8, -3.2F, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_GREAT_SWORD = ITEMS.register("diamond_great_sword",
            () -> new GreatSwordItem(ModTiers.DIAMOND_TIER, 12, -3.8F, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_GREAT_SWORD = ITEMS.register("netherite_great_sword",
            () -> new GreatSwordItem(ModTiers.NETHERITE_TIER, 14, -4.0F, new Item.Properties().fireResistant()));

    // === КАТАРЫ ===
    public static final DeferredItem<Item> IRON_KATAR = ITEMS.register("iron_katar",
            () -> new KatarItem(ModTiers.IRON_TIER, 6, 1.4F, new Item.Properties()));
    public static final DeferredItem<Item> GOLDEN_KATAR = ITEMS.register("golden_katar",
            () -> new KatarItem(ModTiers.GOLD_TIER, 5, 1.6F, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_KATAR = ITEMS.register("diamond_katar",
            () -> new KatarItem(ModTiers.DIAMOND_TIER, 8, 1.3F, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_KATAR = ITEMS.register("netherite_katar",
            () -> new KatarItem(ModTiers.NETHERITE_TIER, 9, 1.2F, new Item.Properties().fireResistant()));

    // === КАТАНЫ ===
    public static final DeferredItem<Item> IRON_KATANA = ITEMS.register("iron_katana",
            () -> new KatanaItem(ModTiers.IRON_TIER, 6, 1.45F, new Item.Properties()));
    public static final DeferredItem<Item> GOLDEN_KATANA = ITEMS.register("golden_katana",
            () -> new KatanaItem(ModTiers.GOLD_TIER, 5, 1.6F, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_KATANA = ITEMS.register("diamond_katana",
            () -> new KatanaItem(ModTiers.DIAMOND_TIER, 8, 1.35F, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_KATANA = ITEMS.register("netherite_katana",
            () -> new KatanaItem(ModTiers.NETHERITE_TIER, 9, 1.25F, new Item.Properties().fireResistant()));

    // === КОПЬЯ ===
    public static final DeferredItem<Item> IRON_SPEAR = ITEMS.register("iron_spear",
            () -> new SpearItem(ModTiers.IRON_TIER, 11, 0.7F, new Item.Properties()));
    public static final DeferredItem<Item> GOLDEN_SPEAR = ITEMS.register("golden_spear",
            () -> new SpearItem(ModTiers.GOLD_TIER, 9, 0.8F, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_SPEAR = ITEMS.register("diamond_spear",
            () -> new SpearItem(ModTiers.DIAMOND_TIER, 13, 0.6F, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_SPEAR = ITEMS.register("netherite_spear",
            () -> new SpearItem(ModTiers.NETHERITE_TIER, 15, 0.5F, new Item.Properties().fireResistant()));

    // === СКИМИТАРЫ ===
    public static final DeferredItem<Item> IRON_SCIMITAR = ITEMS.register("iron_scimitar",
            () -> new ScimitarItem(ModTiers.IRON_TIER, 4, 1.9F, new Item.Properties()));
    public static final DeferredItem<Item> GOLDEN_SCIMITAR = ITEMS.register("golden_scimitar",
            () -> new ScimitarItem(ModTiers.GOLD_TIER, 3, 2.1F, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_SCIMITAR = ITEMS.register("diamond_scimitar",
            () -> new ScimitarItem(ModTiers.DIAMOND_TIER, 6, 1.8F, new Item.Properties()));
    public static final DeferredItem<Item> NETHERITE_SCIMITAR = ITEMS.register("netherite_scimitar",
            () -> new ScimitarItem(ModTiers.NETHERITE_TIER, 7, 1.7F, new Item.Properties().fireResistant()));

    // === БОЛЬШОЙ ЛУК ===
    public static final DeferredItem<Item> GREAT_BOW = ITEMS.register("great_bow",
            () -> new GreatBowItem(new Item.Properties().durability(500)));
}
