package com.TheRealDoomSlayer69.littleadditions.world.features;

import com.TheRealDoomSlayer69.littleadditions.block.LABlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

import java.util.List;

public class LAConfiguredFeatures {

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_RUBY_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, LABlocks.RUBY_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, LABlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> RUBY_ORE = FeatureUtils.register("ruby_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_RUBY_ORES, 10));

    public static final List<OreConfiguration.TargetBlockState> END_RUBY_ORES = List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), LABlocks.END_RUBY_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> NETHER_RUBY_ORES = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES,LABlocks.NETHER_RUBY_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> END_DIAMOND_ORES = List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), LABlocks.END_DIAMOND_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> NETHER_DIAMOND_ORES = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES,LABlocks.NETHER_DIAMOND_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> END_COPPER_ORES = List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), LABlocks.END_COPPER_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> NETHER_COPPER_ORES = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES,LABlocks.NETHER_COPPER_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> END_EMERALD_ORES = List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), LABlocks.END_EMERALD_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> NETHER_EMERALD_ORES = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES,LABlocks.NETHER_EMERALD_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> END_COAL_ORES = List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), LABlocks.END_COAL_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> NETHER_COAL_ORES = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES,LABlocks.NETHER_COAL_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> END_IRON_ORES = List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), LABlocks.END_IRON_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> NETHER_IRON_ORES = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES,LABlocks.NETHER_IRON_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> END_LAPIS_ORES = List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), LABlocks.END_LAPIS_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> NETHER_LAPIS_ORES = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES,LABlocks.NETHER_LAPIS_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> END_REDSTONE_ORES = List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), LABlocks.END_REDSTONE_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> NETHER_REDSTONE_ORES = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES,LABlocks.NETHER_REDSTONE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> END_GOLD_ORES = List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), LABlocks.END_GOLD_ORE.get().defaultBlockState()));


    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> END_RUBY_ORE = FeatureUtils.register("end_ruby_ore",
            Feature.ORE, new OreConfiguration(END_RUBY_ORES, 7));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_RUBY_ORE = FeatureUtils.register("nether_ruby_ore",
            Feature.ORE, new OreConfiguration(NETHER_RUBY_ORES, 9));


    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> END_DIAMOND_ORE = FeatureUtils.register("end_diamond_ore",
            Feature.ORE, new OreConfiguration(END_DIAMOND_ORES, 6));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_DIAMOND_ORE = FeatureUtils.register("nether_diamond_ore",
            Feature.ORE, new OreConfiguration(NETHER_DIAMOND_ORES, 5));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> END_COPPER_ORE = FeatureUtils.register("end_copper_ore",
            Feature.ORE, new OreConfiguration(END_COPPER_ORES, 6));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_COPPER_ORE = FeatureUtils.register("nether_copper_ore",
            Feature.ORE, new OreConfiguration(NETHER_COPPER_ORES, 9));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> END_EMERALD_ORE = FeatureUtils.register("end_emerald_ore",
            Feature.ORE, new OreConfiguration(END_EMERALD_ORES, 5));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_EMERALD_ORE = FeatureUtils.register("nether_emerald_ore",
            Feature.ORE, new OreConfiguration(NETHER_EMERALD_ORES, 6));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> END_COAL_ORE = FeatureUtils.register("end_coal_ore",
            Feature.ORE, new OreConfiguration(END_COAL_ORES, 7));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_COAL_ORE = FeatureUtils.register("nether_coal_ore",
            Feature.ORE, new OreConfiguration(NETHER_COAL_ORES, 10));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> END_IRON_ORE = FeatureUtils.register("end_iron_ore",
            Feature.ORE, new OreConfiguration(END_IRON_ORES, 6));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_IRON_ORE = FeatureUtils.register("nether_iron_ore",
            Feature.ORE, new OreConfiguration(NETHER_IRON_ORES, 7));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> END_LAPIS_ORE = FeatureUtils.register("end_lapis_ore",
            Feature.ORE, new OreConfiguration(END_LAPIS_ORES, 7));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_LAPIS_ORE = FeatureUtils.register("nether_lapis_ore",
            Feature.ORE, new OreConfiguration(NETHER_LAPIS_ORES, 9));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> END_REDSTONE_ORE = FeatureUtils.register("end_redstone_ore",
            Feature.ORE, new OreConfiguration(END_REDSTONE_ORES, 6));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> NETHER_REDSTONE_ORE = FeatureUtils.register("nether_redstone_ore",
            Feature.ORE, new OreConfiguration(NETHER_REDSTONE_ORES, 8));


    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> END_GOLD_ORE = FeatureUtils.register("end_gold_ore",
            Feature.ORE, new OreConfiguration(END_GOLD_ORES, 6));
}
