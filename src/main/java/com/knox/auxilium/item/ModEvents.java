package com.knox.auxilium.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = "auxilium")
public class ModEvents {

    // Временное хранение эффектов кровотечения по UUID сущности
    private static final Map<UUID, BleedEffect> bleedEffects = new HashMap<>();

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        // Обработка парирования и блока для мечей/скимитаров
        // Обработка вертушки для скимитаров
        // Обработка усиленных ударов (каждый 3-й)
        
        Entity attacker = event.getSource().getEntity();
        if (attacker instanceof LivingEntity livingAttacker) {
            // Проверка на кровотечение
            if (bleedEffects.containsKey(livingAttacker.getUUID())) {
                // Урон от кровотечения уже применен
            }
        }
    }

    @SubscribeEvent
    public static void onEntityTick(EntityTickEvent.Pre event) {
        if (event.getEntity() instanceof LivingEntity living) {
            // Обновление эффектов кровотечения
            UUID uuid = living.getUUID();
            if (bleedEffects.containsKey(uuid)) {
                BleedEffect effect = bleedEffects.get(uuid);
                effect.tick(living);
                if (effect.isExpired()) {
                    bleedEffects.remove(uuid);
                }
            }
        }
    }

    // Класс для хранения эффекта кровотечения
    private static class BleedEffect {
        private int duration;
        private int damagePerTick;

        public BleedEffect(int duration, int damagePerTick) {
            this.duration = duration;
            this.damagePerTick = damagePerTick;
        }

        public void tick(LivingEntity entity) {
            if (!entity.level().isClientSide()) {
                entity.hurt(entity.damageSources().magic(), damagePerTick);
            }
            duration--;
        }

        public boolean isExpired() {
            return duration <= 0;
        }
    }
}
