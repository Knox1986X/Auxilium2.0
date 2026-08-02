package com.knox.auxilium.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class GreatSwordItem extends SwordItem {
    public GreatSwordItem(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    // Увеличенная дальность атаки будет через атрибуты
    // Урон по площади и каждый 3-й удар усиленный - через события атаки
    
    @Override
    public void onPostHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Логика подсчета ударов для каждого 3-го удара
        // TODO: реализовать счетчик ударов в NBT или через Capability
    }
}
