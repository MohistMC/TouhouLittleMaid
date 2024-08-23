package com.github.tartaricacid.touhoulittlemaid.client.animation.inner;

import com.google.common.collect.Maps;
import java.util.HashMap;
import net.minecraft.resources.ResourceLocation;

public final class InnerAnimation {
    static final HashMap<ResourceLocation, IAnimation<?>> INNER_ANIMATION = Maps.newHashMap();

    public static boolean containsKey(ResourceLocation resourceLocation) {
        return INNER_ANIMATION.containsKey(resourceLocation);
    }

    public static IAnimation<?> get(ResourceLocation resourceLocation) {
        return INNER_ANIMATION.get(resourceLocation);
    }

    public static void init() {
        INNER_ANIMATION.clear();
        MaidBaseAnimation.init();
        MaidExtraAnimation.init();
        MaidArmorAnimation.init();
        MaidTaskAnimation.init();
        ChairBaseAnimation.init();
        EntityBaseAnimation.init();
        PlayerMaidAnimation.init();
        SpecialAnimation.init();
        FestivalAnimation.init();
    }
}
