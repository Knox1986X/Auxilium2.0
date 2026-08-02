package com.knox.auxilium.item.custom;

import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;

public class EnhancedShieldArmorItem extends ArmorItem {
    private final boolean hasLight;

    public EnhancedShieldArmorItem(ArmorMaterial material, Type type, Properties properties, boolean hasLight) {
        super(material, type, properties);
        this.hasLight = hasLight;
    }

    public boolean hasLight() {
        return hasLight;
    }

    // Блок и парирование будут реализованы через события
    // При зажатии ПКМ - блок 1.8
    // Первые 0.4 сек - полная блокировка урона
    // Далее - 50% блокировка, стрелы отлетают
    // Парирование - возврат 50% урона в первые 0.4 сек
}
