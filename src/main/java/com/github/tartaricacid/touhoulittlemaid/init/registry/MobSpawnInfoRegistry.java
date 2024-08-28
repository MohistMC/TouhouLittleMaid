package com.github.tartaricacid.touhoulittlemaid.init.registry;

import com.github.tartaricacid.touhoulittlemaid.config.subconfig.MiscConfig;
import com.github.tartaricacid.touhoulittlemaid.init.InitEntities;
import fuzs.puzzleslib.api.event.v1.level.GatherPotentialSpawnsCallback;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;


import static com.github.tartaricacid.touhoulittlemaid.config.subconfig.MiscConfig.MAID_FAIRY_BLACKLIST_BIOME;
import static com.github.tartaricacid.touhoulittlemaid.config.subconfig.MiscConfig.MAID_FAIRY_BLACKLIST_DIMENSION;


public final class MobSpawnInfoRegistry {
    private static MobSpawnSettings.SpawnerData SPAWNER_DATA;

    public void init() {
        GatherPotentialSpawnsCallback.EVENT.register(((serverLevel, structureManager, chunkGenerator, mobCategory, blockPos, list) -> {
            ResourceLocation dimension = serverLevel.dimension().location();
            Holder<Biome> biome = serverLevel.getBiome(blockPos);
            if (dimensionIsOkay(dimension) && biomeIsOkay(biome) && mobCategory == MobCategory.MONSTER) {
                boolean canZombieSpawn = list.stream().anyMatch(data -> data.type.equals(EntityType.ZOMBIE));
                if (SPAWNER_DATA == null) {
                    SPAWNER_DATA = new MobSpawnSettings.SpawnerData(InitEntities.FAIRY.get(), MiscConfig.MAID_FAIRY_SPAWN_PROBABILITY.get(), 2, 4);
                }
                if (canZombieSpawn) {
                    list.add(SPAWNER_DATA);
                }
            }

        }));
    }

    private static boolean dimensionIsOkay(ResourceLocation id) {
        return !MAID_FAIRY_BLACKLIST_DIMENSION.get().contains(id.toString());
    }

    private static boolean biomeIsOkay(Holder<Biome> biome) {
        return MAID_FAIRY_BLACKLIST_BIOME.get().stream().noneMatch(name -> biome.is(new ResourceLocation(name)));
    }
}
