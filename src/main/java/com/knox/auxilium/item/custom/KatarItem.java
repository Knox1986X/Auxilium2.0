package com.knox.auxilium.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class KatarItem extends SwordItem {
    public KatarItem(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public void onPostHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // При убийстве моба даёт 1 сердечко целое
        if (target.isDeadOrDying() && !attacker.level().isClientSide()) {
            // TODO: восстановить 2 HP атакующему
        }
        
        // Шанс вызвать кровотечение
        if (!target.level().isClientSide() && target.getRandom().nextFloat() < 0.3f) {
            // TODO: применить эффект кровотечения
        }
    }
}
