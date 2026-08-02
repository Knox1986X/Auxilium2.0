package com.knox.auxilium.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ImprovedTotemItem extends Item {
    private final int uses;

    public ImprovedTotemItem(Properties properties, int uses) {
        super(properties);
        this.uses = uses; // 2 для алмазного, 3 для незеритового
    }

    public int getUses() {
        return uses;
    }

    // Логика использования будет в событии смерти игрока
    // Тотем не исчезает после использования, а теряет заряд
}
