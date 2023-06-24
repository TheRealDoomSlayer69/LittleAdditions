package com.TheRealDoomSlayer69.littleadditions.world;

import com.TheRealDoomSlayer69.littleadditions.LittleAdditions;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class LADimensions {

        public static final ResourceKey<Level> SKYDIM_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY,
                new ResourceLocation(LittleAdditions.MOD_ID, "sky_dimension"));
        public static final ResourceKey<DimensionType> SKYDIM_TYPE =
                ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, SKYDIM_KEY.getRegistryName());

        public static void register() {
            System.out.println("Registering ModDimensions for " + LittleAdditions.MOD_ID);
        }
    }
