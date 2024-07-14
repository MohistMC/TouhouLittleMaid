package com.github.tartaricacid.touhoulittlemaid.init;

import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import com.github.tartaricacid.touhoulittlemaid.entity.poi.MaidPoiManager;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;

public class InitPoi {
    public static final LazyRegistrar<PoiType> POI_TYPES = LazyRegistrar.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, TouhouLittleMaid.MOD_ID);

    public static final RegistryObject<PoiType> MAID_BED = POI_TYPES.register("maid_bed", MaidPoiManager::getMaidBed);
    public static final RegistryObject<PoiType> JOY_BLOCK = POI_TYPES.register("joy_block", MaidPoiManager::getJoyBlock);
    public static final RegistryObject<PoiType> HOME_MEAL_BLOCK = POI_TYPES.register("home_meal", MaidPoiManager::getHomeMeal);
}