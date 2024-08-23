package com.github.tartaricacid.touhoulittlemaid.event;

import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import com.github.tartaricacid.touhoulittlemaid.config.subconfig.MaidConfig;
import com.google.common.collect.Lists;
import io.github.fabricators_of_create.porting_lib.config.ConfigEvents;
import java.util.List;
import java.util.regex.Pattern;
import net.minecraft.core.registries.BuiltInRegistries;
import org.jetbrains.annotations.NotNull;

public class MaidMealRegConfigEvent {
    private static final String CONFIG_NAME = TouhouLittleMaid.MOD_ID + "-common.toml";

    public static List<String> HEAL_MEAL_REGEX = Lists.newArrayList();
    public static List<String> HOME_MEAL_REGEX = Lists.newArrayList();
    public static List<String> WORK_MEAL_REGEX = Lists.newArrayList();

    public static void onEvent() {
        ConfigEvents.LOADING.register(config -> {
            String fileName = config.getFileName();
            if (CONFIG_NAME.equals(fileName)) {
                handleConfig(MaidConfig.MAID_HEAL_MEALS_BLOCK_LIST_REGEX.get(), HEAL_MEAL_REGEX);
                handleConfig(MaidConfig.MAID_HOME_MEALS_BLOCK_LIST_REGEX.get(), HOME_MEAL_REGEX);
                handleConfig(MaidConfig.MAID_WORK_MEALS_BLOCK_LIST_REGEX.get(), WORK_MEAL_REGEX);
            }
        });

    }

    public static void handleConfig(List<String> config, List<String> output) {
        output.clear();
        output.addAll(getMatchedList(config));
    }

    private static @NotNull List<String> getMatchedList(List<String> matchList) {
        List<String> list = Lists.newArrayList();
        for (String match : matchList) {
            Pattern pattern = Pattern.compile(match);
            BuiltInRegistries.ITEM.keySet().stream().filter(id -> pattern.matcher(id.toString()).matches()).forEach(e -> list.add(e.toString()));
        }
        return list;
    }
}
