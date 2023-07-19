package com.TheRealDoomSlayer69.littleadditions.entity;

import com.TheRealDoomSlayer69.littleadditions.LittleAdditions;
import com.TheRealDoomSlayer69.littleadditions.entity.human.HumanEntity;
import com.TheRealDoomSlayer69.littleadditions.entity.pigman.PigmanEntity;
import com.TheRealDoomSlayer69.littleadditions.entity.pigman.end.EnderTrader;
import com.TheRealDoomSlayer69.littleadditions.entity.zombie_pigman.ZombiePigmanEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LAEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, LittleAdditions.MOD_ID);

    public static final RegistryObject<EntityType<PigmanEntity>> PIGMAN = ENTITY_TYPES.register("pigman",
            () -> EntityType.Builder.of(PigmanEntity::new, MobCategory.MONSTER)
                    .sized(0.7f, 2.0f)
                    .build(new ResourceLocation(LittleAdditions.MOD_ID, "pigman").toString()));

    public static final RegistryObject<EntityType<EnderTrader>> ENDER_TRADER = ENTITY_TYPES.register("ender_trader",
            () -> EntityType.Builder.of(EnderTrader::new, MobCategory.MONSTER)
                    .sized(0.7f, 2.0f)
                    .build(new ResourceLocation(LittleAdditions.MOD_ID, "ender_trader").toString()));

    public static final RegistryObject<EntityType<ZombiePigmanEntity>> ZOMBIE_PIGMAN = ENTITY_TYPES.register("zombie_pigman",
            () -> EntityType.Builder.of(ZombiePigmanEntity::new, MobCategory.MONSTER)
                    .sized(0.8f, 2.0f)
                    .build(new ResourceLocation(LittleAdditions.MOD_ID, "zombie_pigman").toString()));

    //public static final RegistryObject<EntityType<MooBloomEntity>> MOOBLOOM = ENTITY_TYPES.register("moobloom",
           // () -> EntityType.Builder.of(MooBloomEntity::new, MobCategory.CREATURE)
                   // .sized(1.5f, 0.5f)
                    //.build(new ResourceLocation(LittleAdditions.MOD_ID, "moobloom").toString()));

    public static final RegistryObject<EntityType<HumanEntity>> HUMAN = ENTITY_TYPES.register("human",
            () -> EntityType.Builder.of(HumanEntity::new, MobCategory.MONSTER)
                    .sized(0.7f, 2.0f)
                    .build(new ResourceLocation(LittleAdditions.MOD_ID, "human").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
