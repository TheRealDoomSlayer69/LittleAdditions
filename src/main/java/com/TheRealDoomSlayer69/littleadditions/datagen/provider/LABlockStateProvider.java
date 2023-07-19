package com.TheRealDoomSlayer69.littleadditions.datagen.provider;

import com.TheRealDoomSlayer69.littleadditions.LittleAdditions;
import com.TheRealDoomSlayer69.littleadditions.block.LABlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class LABlockStateProvider extends BlockStateProvider {
    public LABlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper){
        super(gen, LittleAdditions.MOD_ID, exFileHelper);
    }


    @Override
    protected void registerStatesAndModels() {
        simpleBlock(LABlocks.RUBY_BLOCK.get());
        simpleBlock(LABlocks.RUBY_ORE.get());
        simpleBlock(LABlocks.DEEPSLATE_RUBY_ORE.get());
        simpleBlock(LABlocks.NETHER_RUBY_ORE.get());
        simpleBlock(LABlocks.END_RUBY_ORE.get());
        simpleBlock(LABlocks.NETHER_DIAMOND_ORE.get());
        simpleBlock(LABlocks.END_DIAMOND_ORE.get());
        simpleBlock(LABlocks.NETHER_IRON_ORE.get());
        simpleBlock(LABlocks.END_IRON_ORE.get());
        simpleBlock(LABlocks.NETHER_COAL_ORE.get());
        simpleBlock(LABlocks.END_COAL_ORE.get());
        simpleBlock(LABlocks.NETHER_COPPER_ORE.get());
        simpleBlock(LABlocks.END_COPPER_ORE.get());
        simpleBlock(LABlocks.NETHER_LAPIS_ORE.get());
        simpleBlock(LABlocks.END_LAPIS_ORE.get());
        simpleBlock(LABlocks.NETHER_EMERALD_ORE.get());
        simpleBlock(LABlocks.END_EMERALD_ORE.get());
        simpleBlock(LABlocks.END_GOLD_ORE.get());
        simpleBlock(LABlocks.STABLE_CRYING_OBSIDIAN.get());
        simpleBlock(LABlocks.NETHER_REDSTONE_ORE.get());
        simpleBlock(LABlocks.END_REDSTONE_ORE.get());
    }

}
