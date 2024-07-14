package com.github.tartaricacid.touhoulittlemaid.util;

import net.minecraft.client.gui.components.Button;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public final class GuiTools {
    public static final Button.OnPress NO_ACTION = (button) -> {
    };
}
