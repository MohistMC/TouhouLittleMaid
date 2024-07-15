package com.github.tartaricacid.touhoulittlemaid.config.subconfig;

import io.github.fabricators_of_create.porting_lib.config.ModConfigSpec;

public class VanillaConfig {
    public static ModConfigSpec.BooleanValue REPLACE_SLIME_MODEL;
    public static ModConfigSpec.BooleanValue REPLACE_XP_TEXTURE;
    public static ModConfigSpec.BooleanValue REPLACE_TOTEM_TEXTURE;
    public static ModConfigSpec.BooleanValue REPLACE_XP_BOTTLE_TEXTURE;

    public static void init(ModConfigSpec.Builder builder) {
        builder.push("vanilla");

        builder.comment("Whether to replace the vanilla slime model with the yukkuri.");
        REPLACE_SLIME_MODEL = builder.define("ReplaceSlimeModel", true);

        builder.comment("Whether to replace the vanilla xp orb texture with the point items.");
        REPLACE_XP_TEXTURE = builder.define("ReplaceXPTexture", true);

        builder.comment("Whether to replace the vanilla totem texture with the life point.");
        REPLACE_TOTEM_TEXTURE = builder.define("ReplaceTotemTexture", true);

        builder.comment("Whether to replace the vanilla bottle of xp texture with the point items.");
        REPLACE_XP_BOTTLE_TEXTURE = builder.define("ReplaceXPBottleTexture", true);

        builder.pop();
    }
}
