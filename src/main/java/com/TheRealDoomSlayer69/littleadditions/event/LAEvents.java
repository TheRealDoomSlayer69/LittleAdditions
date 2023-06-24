package com.TheRealDoomSlayer69.littleadditions.event;


import com.TheRealDoomSlayer69.littleadditions.entity.zombie_pigman.ZombiePigmanEntity;
import com.TheRealDoomSlayer69.littleadditions.particle.LAParticles;
import com.TheRealDoomSlayer69.littleadditions.LittleAdditions;
import com.TheRealDoomSlayer69.littleadditions.entity.LAEntities;
import com.TheRealDoomSlayer69.littleadditions.entity.pigman.PigmanEntity;
import com.TheRealDoomSlayer69.littleadditions.particle.SkyPortalParticle;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LittleAdditions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LAEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(LAEntities.PIGMAN.get(), PigmanEntity.setAttributes());
        event.put(LAEntities.ZOMBIE_PIGMAN.get(), ZombiePigmanEntity.setAttributes());

    }

        @SubscribeEvent
        public static void registerParticleFactories(final ParticleFactoryRegisterEvent event){
            Minecraft.getInstance().particleEngine.register(LAParticles.SKY_PORTAL_PARTICLE.get(),
                    SkyPortalParticle.Provider::new);
            }
        }



