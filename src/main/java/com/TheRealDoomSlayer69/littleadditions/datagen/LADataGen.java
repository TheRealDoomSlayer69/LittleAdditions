package com.TheRealDoomSlayer69.littleadditions.datagen;

import com.TheRealDoomSlayer69.littleadditions.LittleAdditions;
import com.TheRealDoomSlayer69.littleadditions.datagen.provider.LABlockStateProvider;
import com.TheRealDoomSlayer69.littleadditions.datagen.provider.LARecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = LittleAdditions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LADataGen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(new LARecipeProvider(generator));
        generator.addProvider(new LABlockStateProvider(generator, existingFileHelper));
    }
}
