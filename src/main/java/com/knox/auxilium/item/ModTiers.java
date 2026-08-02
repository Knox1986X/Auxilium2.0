package com.knox.auxilium.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;

public class ModTiers {
    
    // Железо: урон +1, скорость -0.2, прочность 250, зачаровываемость 14
    public static final Tier IRON_TIER = new SimpleTier(
        BlockTags.INCORRECT_FOR_IRON_TOOL, // mineable
        250, // uses
        6.0F, // speed
        2.0F, // attack damage bonus (added to base)
        14, // enchantment value
        () -> Ingredient.of(net.minecraft.world.item.Items.IRON_INGOT)
    );

    // Золото: урон +0, скорость +0.5, прочность 32, зачаровываемость 22
    public static final Tier GOLD_TIER = new SimpleTier(
        BlockTags.INCORRECT_FOR_GOLD_TOOL,
        32,
        12.0F,
        0.0F,
        22,
        () -> Ingredient.of(net.minecraft.world.item.Items.GOLD_INGOT)
    );

    // Алмаз: урон +2, скорость 0, прочность 1561, зачаровываемость 10
    public static final Tier DIAMOND_TIER = new SimpleTier(
        BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
        1561,
        8.0F,
        3.0F,
        10,
        () -> Ingredient.of(net.minecraft.world.item.Items.DIAMOND)
    );

    // Незерит: урон +3, скорость +0.1, прочность 2031, зачаровываемость 15
    public static final Tier NETHERITE_TIER = new SimpleTier(
        BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
        2031,
        9.0F,
        4.0F,
        15,
        () -> Ingredient.of(net.minecraft.world.item.Items.NETHERITE_INGOT)
    );
}
