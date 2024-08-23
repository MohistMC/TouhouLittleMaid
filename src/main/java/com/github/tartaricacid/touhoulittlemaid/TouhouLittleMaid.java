package com.github.tartaricacid.touhoulittlemaid;

import com.github.tartaricacid.touhoulittlemaid.api.ILittleMaid;
import com.github.tartaricacid.touhoulittlemaid.block.multiblock.MultiBlockManager;
import com.github.tartaricacid.touhoulittlemaid.config.GeneralConfig;
import com.github.tartaricacid.touhoulittlemaid.entity.backpack.BackpackManager;
import com.github.tartaricacid.touhoulittlemaid.entity.chatbubble.ChatBubbleManger;
import com.github.tartaricacid.touhoulittlemaid.entity.task.TaskManager;
import com.github.tartaricacid.touhoulittlemaid.entity.task.meal.MaidMealManager;
import com.github.tartaricacid.touhoulittlemaid.init.*;
import com.github.tartaricacid.touhoulittlemaid.init.registry.CommandRegistry;
import com.github.tartaricacid.touhoulittlemaid.init.registry.CommonRegistry;
import com.github.tartaricacid.touhoulittlemaid.inventory.chest.ChestManager;
import com.github.tartaricacid.touhoulittlemaid.item.bauble.BaubleManager;
import com.github.tartaricacid.touhoulittlemaid.util.AnnotatedInstanceUtil;
import com.google.common.collect.Lists;
import io.github.fabricators_of_create.porting_lib.config.ConfigRegistry;
import io.github.fabricators_of_create.porting_lib.config.ConfigType;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public final class TouhouLittleMaid implements ModInitializer {
    public static final String MOD_ID = "touhou_little_maid";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static List<ILittleMaid> EXTENSIONS = Lists.newArrayList();

    private static void initRegister() {
        InitEntities.ENTITY_TYPES.register();
        InitEntities.ATTRIBUTES.register();
        InitEntities.MEMORY_MODULE_TYPES.register();
        InitEntities.SENSOR_TYPES.register();
        InitEntities.SCHEDULES.register();
        InitEntities.DATA_SERIALIZERS.register();
        InitBlocks.BLOCKS.register();
        InitBlocks.TILE_ENTITIES.register();
        InitItems.ITEMS.register();
        InitEnchantments.ENCHANTMENTS.register();
        InitCreativeTabs.TABS.register();
        InitContainer.CONTAINER_TYPE.register();
        InitSounds.SOUNDS.register();
        InitRecipes.RECIPE_SERIALIZERS.register();
        InitLootModifier.GLOBAL_LOOT_MODIFIER_SERIALIZER.register();
        InitCommand.ARGUMENT_TYPE.register();
        InitPoi.POI_TYPES.register();
    }

    private static void modApiInit() {
        EXTENSIONS = AnnotatedInstanceUtil.getModExtensions();
        TaskManager.init();
        BackpackManager.init();
        BaubleManager.init();
        MultiBlockManager.init();
        ChestManager.init();
        MaidMealManager.init();
    }

    @Override
    public void onInitialize() {
        initRegister();
        InitTrigger.init();
        ConfigRegistry.registerConfig(MOD_ID, ConfigType.COMMON, GeneralConfig.init());
        ChatBubbleManger.initDefaultChat();
        modApiInit();
        CommonRegistry.onSetupEvent();
        CommandRegistry.onServerStaring();
    }
}
