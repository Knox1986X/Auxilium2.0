package com.knox.auxilium.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GreatBowItem extends BowItem {
    public GreatBowItem(Properties properties) {
        super(properties);
    }

    // Увеличенная дальность и урон
    // Пробивание 3 мобов или 1 щита
    
    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof Player player) {
            // Логика стрельбы с пробиванием
            // TODO: реализовать кастомную стрелу или модифицировать существующую
        }
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 20; // Быстрее зарядка
    }
}
