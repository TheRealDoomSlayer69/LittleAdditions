package com.TheRealDoomSlayer69.littleadditions.event;

import com.TheRealDoomSlayer69.littleadditions.LittleAdditions;
import com.TheRealDoomSlayer69.littleadditions.world.entitygen.LAEntityGeneration;
import com.TheRealDoomSlayer69.littleadditions.world.oregen.LAOreGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LittleAdditions.MOD_ID)
public class LAWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        LAOreGeneration.generateOres(event);
        LAEntityGeneration.onEntitySpawn(event);
    }

}
