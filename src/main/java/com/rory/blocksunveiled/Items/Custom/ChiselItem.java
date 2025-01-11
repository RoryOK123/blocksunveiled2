package com.rory.blocksunveiled.Items.Custom;

import com.rory.blocksunveiled.Blocks.ModBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block,Block> chiselContents = Map.of(
            Blocks.STONE, Blocks.STONE_BRICKS,
            Blocks.END_STONE, Blocks.END_STONE_BRICKS,
            Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
            Blocks.COPPER_BLOCK, Blocks.CHISELED_COPPER,
            Blocks.DEEPSLATE_BRICKS, Blocks.CHISELED_DEEPSLATE,
            Blocks.QUARTZ_BLOCK, Blocks.CHISELED_QUARTZ_BLOCK,
            Blocks.BOOKSHELF, Blocks.CHISELED_BOOKSHELF,
            Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE,
            ModBlocks.ALPHORITE_BLOCK.get(), ModBlocks.CHISELED_ALPHORITE.get()
    );

    public ChiselItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block targetBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if(chiselContents.containsKey(targetBlock)){
            if(!level.isClientSide()){
                level.setBlockAndUpdate(pContext.getClickedPos(), chiselContents.get(targetBlock).defaultBlockState());
                pContext.getItemInHand().hurtAndBreak(1,((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                item->pContext.getPlayer().onEquippedItemBroken(item,EquipmentSlot.MAINHAND));
                level.playSound(null,pContext.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
