package com.TheRealDoomSlayer69.littleadditions.datagen.provider;

import com.TheRealDoomSlayer69.littleadditions.LittleAdditions;
import com.TheRealDoomSlayer69.littleadditions.item.LAItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class LAItemModelProvider extends ItemModelProvider {
    public LAItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper){
        super(generator, LittleAdditions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(LAItems.RUBY.get());

        handheldItem(LAItems.RUBY_AXE.get());
        handheldItem(LAItems.RUBY_SHOVEL.get());
        handheldItem(LAItems.RUBY_PICKAXE.get());
        handheldItem(LAItems.RUBY_SWORD.get());
        handheldItem(LAItems.RUBY_HOE.get());

        handheldItem(LAItems.EMERALD_AXE.get());
        handheldItem(LAItems.EMERALD_SHOVEL.get());
        handheldItem(LAItems.EMERALD_PICKAXE.get());
        handheldItem(LAItems.EMERALD_SWORD.get());
        handheldItem(LAItems.EMERALD_HOE.get());

        simpleItem(LAItems.RUBY_HELMET.get());
        simpleItem(LAItems.RUBY_CHESTPLATE.get());
        simpleItem(LAItems.RUBY_LEGGINGS.get());
        simpleItem(LAItems.RUBY_BOOTS.get());
        simpleItem(LAItems.RUBY_HORSE_ARMOR.get());

        simpleItem(LAItems.EMERALD_HELMET.get());
        simpleItem(LAItems.EMERALD_CHESTPLATE.get());
        simpleItem(LAItems.EMERALD_LEGGINGS.get());
        simpleItem(LAItems.EMERALD_BOOTS.get());
        simpleItem(LAItems.EMERALD_HORSE_ARMOR.get());


    }

    private ItemModelBuilder simpleItem(Item item) {
        return withExistingParent(item.getRegistryName().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(LittleAdditions.MOD_ID,"item/" + item.getRegistryName().getPath()));
    }

    private ItemModelBuilder handheldItem(Item item) {
        return withExistingParent(item.getRegistryName().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(LittleAdditions.MOD_ID,"item/" + item.getRegistryName().getPath()));
    }
}
