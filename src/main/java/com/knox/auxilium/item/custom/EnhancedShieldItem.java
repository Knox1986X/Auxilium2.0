package com.knox.auxilium.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.lighting.LightEngine;

public class EnhancedShieldItem extends ShieldItem {
    private final boolean hasLight;

    public EnhancedShieldItem(Properties properties, boolean hasLight) {
        super(properties);
        this.hasLight = hasLight;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, LivingEntity entity, int slotId, boolean isSelected) {
        if (hasLight && entity instanceof Player player && player.isHolding(stack)) {
            // TODO: добавить динамическое освещение вокруг игрока
            // Для совместимости с LambDynamicLights, RyoamicLights, Embeddium, Sodium
            BlockPos pos = entity.blockPosition();
            // Свет будет добавлен через событие или тик
        }
    }

    public boolean hasLight() {
        return hasLight;
    }
}
