package com.knox.auxilium.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;

public class BattleAxeItem extends SwordItem {
    public BattleAxeItem(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public boolean canDisableShield(ItemStack stack, LivingEntity attacker, LivingEntity defender, ItemStack shield) {
        return true; // Сбивает щиты
    }

    // Здесь будет логика оглушения и кровотечения в событиях атаки
}
