package com.TheRealDoomSlayer69.littleadditions.util;

import com.TheRealDoomSlayer69.littleadditions.LittleAdditions;
import com.TheRealDoomSlayer69.littleadditions.block.LABlocks;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LAPOIs {

    public static final DeferredRegister<PoiType> POI
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, LittleAdditions.MOD_ID);

    public static final RegistryObject<PoiType> SKY_PORTAL =
            POI.register("sky_portal", () -> new PoiType("sky_portal",
                    PoiType.getBlockStates(LABlocks.SKY_PORTAL.get()), 0, 1));


    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}
