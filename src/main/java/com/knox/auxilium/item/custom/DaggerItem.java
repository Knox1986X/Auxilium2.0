package com.knox.auxilium.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class DaggerItem extends SwordItem {
    public DaggerItem(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public void onPostHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Шанс вызвать кровотечение
        if (!target.level().isClientSide() && target.getRandom().nextFloat() < 0.3f) {
            // TODO: применить эффект кровотечения
        }
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return false;
    }
}
