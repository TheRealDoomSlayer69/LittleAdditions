package com.TheRealDoomSlayer69.littleadditions.world.features;

import com.TheRealDoomSlayer69.littleadditions.world.oregen.LAOrePlacement;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.core.Holder;

public class LAPlacedFeatures {

    public static final Holder<PlacedFeature> RUBY_ORE_PLACED = PlacementUtils.register("ruby_ore_placed",
            LAConfiguredFeatures.RUBY_ORE, LAOrePlacement.commonOrePlacement(8,
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

    public static final Holder<PlacedFeature> END_RUBY_ORE_PLACED = PlacementUtils.register("end_ruby_ore_placed",
            LAConfiguredFeatures.END_RUBY_ORE, LAOrePlacement.commonOrePlacement(6,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-75), VerticalAnchor.aboveBottom(70))));

    public static final Holder<PlacedFeature> NETHER_RUBY_ORE_PLACED = PlacementUtils.register("nether_ruby_ore_placed",
            LAConfiguredFeatures.NETHER_RUBY_ORE, LAOrePlacement.commonOrePlacement(6,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-60), VerticalAnchor.aboveBottom(50))));


    public static final Holder<PlacedFeature> END_DIAMOND_ORE_PLACED = PlacementUtils.register("end_diamond_ore_placed",
            LAConfiguredFeatures.END_DIAMOND_ORE, LAOrePlacement.rareOrePlacement(5,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-55), VerticalAnchor.aboveBottom(60))));

    public static final Holder<PlacedFeature> NETHER_DIAMOND_ORE_PLACED = PlacementUtils.register("nether_diamond_ore_placed",
            LAConfiguredFeatures.NETHER_DIAMOND_ORE, LAOrePlacement.rareOrePlacement(6,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-45), VerticalAnchor.aboveBottom(50))));

    public static final Holder<PlacedFeature> END_COPPER_ORE_PLACED = PlacementUtils.register("end_copper_ore_placed",
            LAConfiguredFeatures.END_COPPER_ORE, LAOrePlacement.rareOrePlacement(6,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-55), VerticalAnchor.aboveBottom(55))));

    public static final Holder<PlacedFeature> NETHER_COPPER_ORE_PLACED = PlacementUtils.register("nether_copper_ore_placed",
            LAConfiguredFeatures.NETHER_COPPER_ORE, LAOrePlacement.rareOrePlacement(7,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-45), VerticalAnchor.aboveBottom(45))));

    public static final Holder<PlacedFeature> END_EMERALD_ORE_PLACED = PlacementUtils.register("end_emerald_ore_placed",
            LAConfiguredFeatures.END_EMERALD_ORE, LAOrePlacement.rareOrePlacement(4,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-55), VerticalAnchor.aboveBottom(45))));

    public static final Holder<PlacedFeature> NETHER_EMERALD_ORE_PLACED = PlacementUtils.register("nether_emerald_ore_placed",
            LAConfiguredFeatures.NETHER_EMERALD_ORE, LAOrePlacement.rareOrePlacement(5,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-45), VerticalAnchor.aboveBottom(40))));

    public static final Holder<PlacedFeature> END_COAL_ORE_PLACED = PlacementUtils.register("end_coal_ore_placed",
            LAConfiguredFeatures.END_COAL_ORE, LAOrePlacement.rareOrePlacement(7,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-55), VerticalAnchor.aboveBottom(65))));

    public static final Holder<PlacedFeature> NETHER_COAL_ORE_PLACED = PlacementUtils.register("nether_coal_ore_placed",
            LAConfiguredFeatures.NETHER_COAL_ORE, LAOrePlacement.rareOrePlacement(7,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-45), VerticalAnchor.aboveBottom(70))));

    public static final Holder<PlacedFeature> END_IRON_ORE_PLACED = PlacementUtils.register("end_iron_ore_placed",
            LAConfiguredFeatures.END_IRON_ORE, LAOrePlacement.rareOrePlacement(6,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-55), VerticalAnchor.aboveBottom(60))));

    public static final Holder<PlacedFeature> NETHER_IRON_ORE_PLACED = PlacementUtils.register("nether_iron_ore_placed",
            LAConfiguredFeatures.NETHER_IRON_ORE, LAOrePlacement.rareOrePlacement(7,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-35), VerticalAnchor.aboveBottom(60))));

    public static final Holder<PlacedFeature> END_LAPIS_ORE_PLACED = PlacementUtils.register("end_lapis_ore_placed",
            LAConfiguredFeatures.END_LAPIS_ORE, LAOrePlacement.rareOrePlacement(5,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-55), VerticalAnchor.aboveBottom(65))));

    public static final Holder<PlacedFeature> NETHER_LAPIS_ORE_PLACED = PlacementUtils.register("nether_lapis_ore_placed",
            LAConfiguredFeatures.NETHER_LAPIS_ORE, LAOrePlacement.rareOrePlacement(7,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-45), VerticalAnchor.aboveBottom(50))));

    public static final Holder<PlacedFeature> END_REDSTONE_ORE_PLACED = PlacementUtils.register("end_redstone_ore_placed",
            LAConfiguredFeatures.END_REDSTONE_ORE, LAOrePlacement.rareOrePlacement(5,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-55), VerticalAnchor.aboveBottom(55))));

    public static final Holder<PlacedFeature> NETHER_REDSTONE_ORE_PLACED = PlacementUtils.register("nether_redstone_ore_placed",
            LAConfiguredFeatures.NETHER_REDSTONE_ORE, LAOrePlacement.rareOrePlacement(7,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-46), VerticalAnchor.aboveBottom(40))));


    public static final Holder<PlacedFeature> END_GOLD_ORE_PLACED = PlacementUtils.register("end_gold_ore_placed",
            LAConfiguredFeatures.END_GOLD_ORE, LAOrePlacement.commonOrePlacement(5,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-65), VerticalAnchor.aboveBottom(55))));
}
