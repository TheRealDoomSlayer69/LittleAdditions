package com.TheRealDoomSlayer69.littleadditions.fluid;

import com.TheRealDoomSlayer69.littleadditions.LittleAdditions;
import com.TheRealDoomSlayer69.littleadditions.block.LABlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LAFluids {

    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, LittleAdditions.MOD_ID);


    public static final RegistryObject<FlowingFluid> MILK_FLUID
            = FLUIDS.register("milk_fluid", () -> new ForgeFlowingFluid.Source(LAFluids.MILK_PROPERTIES));

    public static final RegistryObject<FlowingFluid> MILK_FLOWING
            = FLUIDS.register("milk_flowing", () -> new ForgeFlowingFluid.Flowing(LAFluids.MILK_PROPERTIES));


    public static final ForgeFlowingFluid.Properties MILK_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> MILK_FLUID.get(), () -> MILK_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .density(15).luminosity(1).viscosity(6).sound(SoundEvents.WANDERING_TRADER_DRINK_MILK).overlay(WATER_OVERLAY_RL)
            .color(0xb4bebf)).slopeFindDistance(3).levelDecreasePerBlock(2)
            .block(() -> LAFluids.MILK_BLOCK.get()).bucket(() -> Items.MILK_BUCKET);

    public static final RegistryObject<LiquidBlock> MILK_BLOCK = LABlocks.BLOCKS.register("milk",
            () -> new LiquidBlock(() -> LAFluids.MILK_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission().strength(100f).noDrops()));
    //FlowingFluidBlock
    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }

}
