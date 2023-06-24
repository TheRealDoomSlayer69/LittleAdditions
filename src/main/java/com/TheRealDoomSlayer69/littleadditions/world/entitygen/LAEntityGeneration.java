package com.TheRealDoomSlayer69.littleadditions.world.entitygen;

import com.TheRealDoomSlayer69.littleadditions.entity.LAEntities;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class LAEntityGeneration {

    public static void onEntitySpawn(final BiomeLoadingEvent event) {
        addEntityToAllOverworldBiomes(event, LAEntities.PIGMAN.get(),
                10, 2, 4);
        addEntityToAllNetherBiomes(event, LAEntities.ZOMBIE_PIGMAN.get(),
                6, 2, 4);

    }

    private static void addEntityToAllBiomesExceptThese(BiomeLoadingEvent event, EntityType<?> type,
                                                        int weight, int minCount, int maxCount, ResourceKey<Biome>... biomes) {
        boolean isBiomeSelected = Arrays.stream(biomes).map(ResourceKey::location)
                .map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));

        if(!isBiomeSelected) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }

    @SafeVarargs
    private static void addEntityToSpecificBiomes(BiomeLoadingEvent event, EntityType<?> type,
                                                  int weight, int minCount, int maxCount, ResourceKey<Biome>... biomes) {
        boolean isBiomeSelected = Arrays.stream(biomes).map(ResourceKey::location)
                .map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));

        if(isBiomeSelected) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }

    private static void addEntityToAllOverworldBiomes(BiomeLoadingEvent event, EntityType<?> type,
                                                      int weight, int minCount, int maxCount) {
        if(!event.getCategory().equals(Biome.BiomeCategory.THEEND) && !event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }

    private static void addEntityToAllBiomesNoNether(BiomeLoadingEvent event, EntityType<?> type,
                                                     int weight, int minCount, int maxCount) {
        if(!event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
            List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
            base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
        }
    }

    private static void addEntityToAllBiomesNoEnd(BiomeLoadingEvent event, EntityType<?> type,
                                                  int weight, int minCount, int maxCount) {
        if(!event.getCategory().equals(Biome.BiomeCategory.THEEND)) {
            List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
            base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
        }
    }

    private static void addEntityToAllBiomes(BiomeLoadingEvent event, EntityType<?> type,
                                             int weight, int minCount, int maxCount) {
        List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
        base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
    }

    private static void addEntityToAllNetherBiomes(BiomeLoadingEvent event, EntityType<?> type,
                                                   int weight, int minCount, int maxCount) {
        Set<Biome.BiomeCategory> excludedCategories = Set.of(
                Biome.BiomeCategory.THEEND, Biome.BiomeCategory.ICY, Biome.BiomeCategory.BEACH,
                Biome.BiomeCategory.DESERT, Biome.BiomeCategory.EXTREME_HILLS, Biome.BiomeCategory.FOREST,
                Biome.BiomeCategory.JUNGLE, Biome.BiomeCategory.MESA, Biome.BiomeCategory.MOUNTAIN,
                Biome.BiomeCategory.MUSHROOM, Biome.BiomeCategory.OCEAN, Biome.BiomeCategory.PLAINS,
                Biome.BiomeCategory.RIVER, Biome.BiomeCategory.SAVANNA, Biome.BiomeCategory.TAIGA,
                Biome.BiomeCategory.SWAMP, Biome.BiomeCategory.UNDERGROUND);

        if (!excludedCategories.contains(event.getCategory())) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }
}
