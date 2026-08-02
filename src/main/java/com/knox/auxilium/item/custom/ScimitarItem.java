package com.knox.auxilium.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class ScimitarItem extends SwordItem {
    public ScimitarItem(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    // Вертушка активируется через событие использования предмета
    // Кулдаун 10 секунд, трата 4 голода
    
    public static void performSpinAttack(Level level, Player player, ItemStack stack) {
        // Логика вертушки: вращение 0.6 сек, радиус 3.5 блока
        // 60% урона от основной сабли всем мобам в радиусе
        // Защита во время вращения
        // TODO: реализовать через события
    }
}
