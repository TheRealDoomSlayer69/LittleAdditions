package com.TheRealDoomSlayer69.littleadditions.event;

import com.TheRealDoomSlayer69.littleadditions.LittleAdditions;
import com.TheRealDoomSlayer69.littleadditions.entity.LAEntities;
import com.TheRealDoomSlayer69.littleadditions.entity.human.HumanModel;
import com.TheRealDoomSlayer69.littleadditions.entity.human.HumanRenderer;
import com.TheRealDoomSlayer69.littleadditions.entity.pigman.PigmanEntityModel;
import com.TheRealDoomSlayer69.littleadditions.entity.pigman.PigmanEntityRenderer;
import com.TheRealDoomSlayer69.littleadditions.entity.pigman.end.EnderTraderModel;
import com.TheRealDoomSlayer69.littleadditions.entity.pigman.end.EnderTraderRenderer;
import com.TheRealDoomSlayer69.littleadditions.entity.zombie_pigman.ZombiePigmanEntityModel;
import com.TheRealDoomSlayer69.littleadditions.entity.zombie_pigman.ZombiePigmanEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = LittleAdditions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class LAClientEvents {

    private LAClientEvents() {
    }

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {

    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(PigmanEntityModel.LAYER_LOCATION, PigmanEntityModel::createBodyLayer);
        event.registerLayerDefinition(ZombiePigmanEntityModel.LAYER_LOCATION, ZombiePigmanEntityModel::createBodyLayer);
        event.registerLayerDefinition(HumanModel.LAYER_LOCATION, HumanModel::createBodyLayer);
        event.registerLayerDefinition(EnderTraderModel.LAYER_LOCATION, EnderTraderModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(LAEntities.PIGMAN.get(), PigmanEntityRenderer::new);
        event.registerEntityRenderer(LAEntities.ZOMBIE_PIGMAN.get(), ZombiePigmanEntityRenderer::new);
        event.registerEntityRenderer(LAEntities.HUMAN.get(), HumanRenderer::new);
        event.registerEntityRenderer(LAEntities.ENDER_TRADER.get(), EnderTraderRenderer::new);
    }
}
