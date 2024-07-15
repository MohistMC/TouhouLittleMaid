package com.github.tartaricacid.touhoulittlemaid.client.event;

import com.github.tartaricacid.touhoulittlemaid.client.gui.mod.OptifineScreen;
import com.github.tartaricacid.touhoulittlemaid.config.subconfig.MiscConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;

@Environment(EnvType.CLIENT)
public final class ShowOptifineScreen {
    private static boolean optifinePresent = false;
    private static boolean firstTitleScreenShown = false;

    @SubscribeEvent
    public static void showOptifineWarning(ScreenEvent.Init.Post event) {
        if (firstTitleScreenShown || !(event.getScreen() instanceof TitleScreen)) {
            return;
        }
        if (!MiscConfig.CLOSE_OPTIFINE_WARNING.get() && optifinePresent) {
            Minecraft.getInstance().setScreen(new OptifineScreen(event.getScreen()));
        }
        firstTitleScreenShown = true;
    }

    public static void checkOptifineIsLoaded() {
        try {
            Class.forName("net.optifine.Config");
            optifinePresent = true;
        } catch (ClassNotFoundException e) {
            optifinePresent = false;
        }
    }
}
