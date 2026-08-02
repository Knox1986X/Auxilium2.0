package com.knox.auxilium.item.custom;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

public class BackpackItem extends Item {
    private final int slots;

    public BackpackItem(Properties properties, int slots) {
        super(properties);
        this.slots = slots;
    }

    public int getSlots() {
        return slots;
    }

    // Логика открытия рюкзака будет в событии использования
    // Для разных материалов: кожа (27 слотов), железо (36), золото (45), алмаз (54), незерит (63)
}
