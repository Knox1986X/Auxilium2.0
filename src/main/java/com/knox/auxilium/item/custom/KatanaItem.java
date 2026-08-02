package com.knox.auxilium.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class KatanaItem extends SwordItem {
    public KatanaItem(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public void onPostHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Шанс вызвать кровотечение
        if (!target.level().isClientSide() && target.getRandom().nextFloat() < 0.35f) {
            // TODO: применить эффект кровотечения
        }
        
        // Ускорение владельца
        if (attacker instanceof Player player) {
            // TODO: добавить эффект скорости на короткое время
        }
    }
}
