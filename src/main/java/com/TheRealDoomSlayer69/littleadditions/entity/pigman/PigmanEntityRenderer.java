package com.TheRealDoomSlayer69.littleadditions.entity.pigman;

import com.TheRealDoomSlayer69.littleadditions.LittleAdditions;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;



public class PigmanEntityRenderer<Type extends PigmanEntity> extends HumanoidMobRenderer<Type, PigmanEntityModel<Type>> {


private static final ResourceLocation TEXTURE = new ResourceLocation(LittleAdditions.MOD_ID,
        "textures/entity/pigman/pigman.png");

private static final ResourceLocation JOHN_PORK = new ResourceLocation(LittleAdditions.MOD_ID,
                "textures/entity/pigman/john_pork.png");

public PigmanEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new PigmanEntityModel<>(context.bakeLayer(PigmanEntityModel.LAYER_LOCATION)), 0.6f);
        this.addLayer(new ItemInHandLayer<>(this));
        this.addLayer(new HumanoidArmorLayer<>(this,
                new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
                new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
}

@Override
public ResourceLocation getTextureLocation(Type entity) {
        String s = ChatFormatting.stripFormatting(entity.getName().getString());
        if (s != null && "John Pork".equals(s)) {
                return JOHN_PORK;
        } else
        return TEXTURE;
        }
}
