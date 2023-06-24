package com.TheRealDoomSlayer69.littleadditions;


import com.TheRealDoomSlayer69.littleadditions.block.LABlocks;
import com.TheRealDoomSlayer69.littleadditions.particle.LAParticles;
import com.TheRealDoomSlayer69.littleadditions.util.LAPOIs;
import com.TheRealDoomSlayer69.littleadditions.entity.LAEntities;
import com.TheRealDoomSlayer69.littleadditions.item.LAItems;
import com.TheRealDoomSlayer69.littleadditions.world.LADimensions;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(LittleAdditions.MOD_ID)
public class LittleAdditions {
    public static final String MOD_ID = "littleadditions";

    public LittleAdditions() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        LAItems.register(eventBus);
        LABlocks.register(eventBus);
        LAEntities.register(eventBus);
        LADimensions.register();
        LAPOIs.register(eventBus);
        LAParticles.register(eventBus);

        eventBus.addListener(this::clientSetup);



        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(LABlocks.SKY_PORTAL.get(), RenderType.translucent());
    }

    }




