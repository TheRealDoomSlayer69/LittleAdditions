package com.TheRealDoomSlayer69.littleadditions.particle;

import com.TheRealDoomSlayer69.littleadditions.LittleAdditions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LAParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, LittleAdditions.MOD_ID);

    public static final RegistryObject<SimpleParticleType> SKY_PORTAL_PARTICLE =
            PARTICLE_TYPES.register("sky_portal_particle", () -> new SimpleParticleType(false));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}

