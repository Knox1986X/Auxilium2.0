package com.knox.auxilium.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ToolAction;
import net.neoforged.neoforge.common.ToolActions;

public class MultiToolItem extends net.minecraft.world.item.DiggerItem {
    public MultiToolItem(Tier tier, Properties properties) {
        super(tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();
        BlockState state = level.getBlockState(clickedPos);

        // Кирка - ломает руды и камень
        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE)) {
            return InteractionResult.SUCCESS;
        }

        // Топор - ломает дерево
        if (state.is(BlockTags.MINEABLE_WITH_AXE)) {
            return InteractionResult.SUCCESS;
        }

        // Лопата - ломает землю
        if (state.is(BlockTags.MINEABLE_WITH_SHOVEL)) {
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction) ||
               ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction) ||
               ToolActions.DEFAULT_SHOVEL_ACTIONS.contains(toolAction);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE) ||
            state.is(BlockTags.MINEABLE_WITH_AXE) ||
            state.is(BlockTags.MINEABLE_WITH_SHOVEL)) {
            return super.getDestroySpeed(stack, state);
        }
        return 1.0f;
    }
}
