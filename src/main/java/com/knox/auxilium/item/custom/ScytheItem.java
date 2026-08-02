package com.knox.auxilium.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.ToolAction;
import net.neoforged.neoforge.common.ToolActions;

import java.util.ArrayList;
import java.util.List;

public class ScytheItem extends AxeItem {
    public ScytheItem(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos clickedPos = context.getClickedPos();
        Player player = context.getPlayer();

        if (player == null || !player.mayBuild()) return InteractionResult.PASS;

        // Вспахивание 3x3
        if (level.getBlockState(clickedPos).is(BlockTags.DIRT)) {
            List<BlockPos> positions = get3x3Area(clickedPos, context.getClickedFace());
            for (BlockPos pos : positions) {
                BlockState state = level.getBlockState(pos);
                if (state.is(BlockTags.DIRT)) {
                    level.setBlock(pos, Blocks.FARMLAND.defaultBlockState(), 3);
                    level.playSound(player, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0f, 1.0f);
                }
            }
            if (!level.isClientSide() && player instanceof ServerLevel) {
                context.getItemInHand().hurtAndBreak(3, player, LivingEntity.getSlotForHand(context.getHand()));
            }
            return InteractionResult.SUCCESS;
        }

        // Сбор травы 3x3
        if (level.getBlockState(clickedPos).is(BlockTags.REPLACEABLE_BY_TREES)) {
            List<BlockPos> positions = get3x3Area(clickedPos, context.getClickedFace());
            for (BlockPos pos : positions) {
                BlockState state = level.getBlockState(pos);
                if (state.is(BlockTags.REPLACEABLE_BY_TREES) || state.is(Blocks.SHORT_GRASS)) {
                    level.destroyBlock(pos, true, player);
                }
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    private List<BlockPos> get3x3Area(BlockPos center, Direction face) {
        List<BlockPos> positions = new ArrayList<>();
        Direction.Axis axis = face.getAxis();
        
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                if (axis == Direction.Axis.Y) {
                    positions.add(center.offset(x, 0, z));
                } else if (axis == Direction.Axis.X) {
                    positions.add(center.offset(0, x, z));
                } else {
                    positions.add(center.offset(x, z, 0));
                }
            }
        }
        return positions;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction) || 
               toolAction == ToolActions.SHOVEL_DIG || 
               toolAction == ToolActions.PICKAXE_DIG;
    }
}
