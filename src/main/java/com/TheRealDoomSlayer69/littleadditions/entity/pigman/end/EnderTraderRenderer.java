package com.TheRealDoomSlayer69.littleadditions.entity.pigman.end;

import com.TheRealDoomSlayer69.littleadditions.LittleAdditions;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EnderTraderRenderer <Type extends EnderTrader> extends HumanoidMobRenderer<Type, EnderTraderModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(LittleAdditions.MOD_ID,
            "textures/entity/pigman/ender_trader.png");

    public EnderTraderRenderer(EntityRendererProvider.Context context) {
        super(context, new EnderTraderModel<>(context.bakeLayer(EnderTraderModel.LAYER_LOCATION)), 0.6f);
    }

    public ResourceLocation getTextureLocation(EnderTrader entity) {
        return  TEXTURE;
    }
}
