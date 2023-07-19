package com.TheRealDoomSlayer69.littleadditions.entity.human;

import com.TheRealDoomSlayer69.littleadditions.LittleAdditions;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class HumanRenderer<Type extends HumanEntity> extends HumanoidMobRenderer<Type, HumanModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(LittleAdditions.MOD_ID,
            "textures/entity/human/steve.png");


    public HumanRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanModel<>(context.bakeLayer(HumanModel.LAYER_LOCATION)), 0.6f);
        this.addLayer(new ItemInHandLayer<>(this));
        this.addLayer(new HumanoidArmorLayer<>(this,
                new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
                new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));

    }


    public ResourceLocation getTextureLocation(Type entity) {
        return  TEXTURE;
    }
}
