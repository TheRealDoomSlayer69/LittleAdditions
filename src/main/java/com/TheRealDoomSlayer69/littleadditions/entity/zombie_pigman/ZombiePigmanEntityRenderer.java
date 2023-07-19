package com.TheRealDoomSlayer69.littleadditions.entity.zombie_pigman;

import com.TheRealDoomSlayer69.littleadditions.LittleAdditions;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class ZombiePigmanEntityRenderer extends AbstractZombieRenderer<ZombiePigmanEntity, ZombiePigmanEntityModel<ZombiePigmanEntity>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(LittleAdditions.MOD_ID,
            "textures/entity/zombie_pigman/zombie_pigman.png");


    public ZombiePigmanEntityRenderer(EntityRendererProvider.Context context) {
        this(context, ModelLayers.ZOMBIE, ModelLayers.ZOMBIE_INNER_ARMOR, ModelLayers.ZOMBIE_OUTER_ARMOR);
    }

    public ZombiePigmanEntityRenderer(EntityRendererProvider.Context context, ModelLayerLocation pZombieLayer, ModelLayerLocation pInnerArmor, ModelLayerLocation pOuterArmor) {
        super(context, new ZombiePigmanEntityModel<>(context.bakeLayer(pZombieLayer)), new ZombiePigmanEntityModel<>(context.bakeLayer(pInnerArmor)), new ZombiePigmanEntityModel<>(context.bakeLayer(pOuterArmor)));
        this.addLayer(new ItemInHandLayer<>(this));
    }


    public ResourceLocation getTextureLocation(ZombiePigmanEntity entity) {
        return  TEXTURE;
    }

}
