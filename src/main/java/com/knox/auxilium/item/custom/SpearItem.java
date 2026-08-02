package com.knox.auxilium.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class SpearItem extends SwordItem {
    public SpearItem(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    // Увеличенная дальность через атрибуты
    // Каждый 3-й удар усиленный - через события
    
    @Override
    public void onPostHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Шанс оглушить и вызвать кровотечение
        if (!target.level().isClientSide()) {
            float chance = target.getRandom().nextFloat();
            if (chance < 0.25f) {
                // TODO: оглушение
            }
            if (chance < 0.3f) {
                // TODO: кровотечение
            }
        }
    }
}
