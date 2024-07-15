package com.github.tartaricacid.touhoulittlemaid.client.animation.gecko.condition;

import com.google.common.collect.Lists;
import net.minecraft.resources.ResourceLocation;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ConditionTAC {
    private static final String EMPTY = "";
    private final List<String> nameTest = Lists.newArrayList();
    private final List<ResourceLocation> idTest = Lists.newArrayList();

    public void addTest(String name) {
        if (!name.startsWith("tac:") || !name.contains("$")) {
            return;
        }
        String[] split = StringUtils.split(name, "$", 2);
        if (split.length < 2) {
            return;
        }
        String itemId = split[1];
        if (ResourceLocation.isValidResourceLocation(itemId)) {
            nameTest.add(name);
            idTest.add(new ResourceLocation(itemId));
        }
    }
}
