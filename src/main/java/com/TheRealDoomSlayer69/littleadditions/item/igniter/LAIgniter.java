package com.TheRealDoomSlayer69.littleadditions.item.igniter;

import com.TheRealDoomSlayer69.littleadditions.block.LABlocks;
import com.TheRealDoomSlayer69.littleadditions.block.portal.SkyPortalBlock;
import com.TheRealDoomSlayer69.littleadditions.item.tab.LACreativeModeTab;
import com.TheRealDoomSlayer69.littleadditions.world.LADimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class LAIgniter extends Item {

    public LAIgniter() {
        super(new Properties()
                .tab(LACreativeModeTab.LITTLE_ADDITIONS)
                .stacksTo(1)
                .rarity(Rarity.EPIC)
        );
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(context.getPlayer() != null) {
            if(context.getPlayer().level.dimension() == LADimensions.SKYDIM_KEY
                    || context.getPlayer().level.dimension() == Level.OVERWORLD) {
                for(Direction direction : Direction.Plane.VERTICAL) {
                    BlockPos framePos = context.getClickedPos().relative(direction);
                    if(((SkyPortalBlock) LABlocks.SKY_PORTAL.get()).trySpawnPortal(context.getLevel(), framePos)) {
                        context.getLevel().playSound(context.getPlayer(), framePos,
                                SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                        return InteractionResult.CONSUME;
                    }
                    else return InteractionResult.FAIL;
                }
            }
        }
        return InteractionResult.FAIL;
    }
}
