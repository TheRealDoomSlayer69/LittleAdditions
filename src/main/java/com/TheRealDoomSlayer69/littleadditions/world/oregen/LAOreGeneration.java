package com.TheRealDoomSlayer69.littleadditions.world.oregen;

import com.TheRealDoomSlayer69.littleadditions.world.features.LAPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class LAOreGeneration {

    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        base.add(LAPlacedFeatures.RUBY_ORE_PLACED);

        if(event.getCategory() == Biome.BiomeCategory.THEEND) {
            base.add(LAPlacedFeatures.END_RUBY_ORE_PLACED);
            base.add(LAPlacedFeatures.END_DIAMOND_ORE_PLACED);
            base.add(LAPlacedFeatures.END_GOLD_ORE_PLACED);
            base.add(LAPlacedFeatures.END_COPPER_ORE_PLACED);
            base.add(LAPlacedFeatures.END_EMERALD_ORE_PLACED);
            base.add(LAPlacedFeatures.END_COAL_ORE_PLACED);
            base.add(LAPlacedFeatures.END_IRON_ORE_PLACED);
            base.add(LAPlacedFeatures.END_LAPIS_ORE_PLACED);
            base.add(LAPlacedFeatures.END_REDSTONE_ORE_PLACED);
        }

        if(event.getCategory() == Biome.BiomeCategory.NETHER) {
            base.add(LAPlacedFeatures.NETHER_RUBY_ORE_PLACED);
            base.add(LAPlacedFeatures.NETHER_DIAMOND_ORE_PLACED);
            base.add(LAPlacedFeatures.NETHER_COPPER_ORE_PLACED);
            base.add(LAPlacedFeatures.NETHER_EMERALD_ORE_PLACED);
            base.add(LAPlacedFeatures.NETHER_COAL_ORE_PLACED);
            base.add(LAPlacedFeatures.NETHER_IRON_ORE_PLACED);
            base.add(LAPlacedFeatures.NETHER_LAPIS_ORE_PLACED);
            base.add(LAPlacedFeatures.NETHER_REDSTONE_ORE_PLACED);
        }
    }
}
