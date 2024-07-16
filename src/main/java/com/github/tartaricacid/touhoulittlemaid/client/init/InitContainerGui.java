package com.github.tartaricacid.touhoulittlemaid.client.init;

import com.github.tartaricacid.touhoulittlemaid.client.gui.entity.maid.MaidConfigContainerGui;
import com.github.tartaricacid.touhoulittlemaid.client.gui.entity.maid.backpack.*;
import com.github.tartaricacid.touhoulittlemaid.client.gui.item.PicnicBasketContainerScreen;
import com.github.tartaricacid.touhoulittlemaid.client.gui.item.WirelessIOContainerGui;
import com.github.tartaricacid.touhoulittlemaid.inventory.container.MaidConfigContainer;
import com.github.tartaricacid.touhoulittlemaid.inventory.container.PicnicBasketContainer;
import com.github.tartaricacid.touhoulittlemaid.inventory.container.WirelessIOContainer;
import com.github.tartaricacid.touhoulittlemaid.inventory.container.backpack.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screens.MenuScreens;

@Environment(EnvType.CLIENT)
public final class InitContainerGui {

    public static void clientSetup() {
        MenuScreens.register(EmptyBackpackContainer.TYPE, EmptyBackpackContainerScreen::new);
        MenuScreens.register(SmallBackpackContainer.TYPE, SmallBackpackContainerScreen::new);
        MenuScreens.register(MiddleBackpackContainer.TYPE, MiddleBackpackContainerScreen::new);
        MenuScreens.register(BigBackpackContainer.TYPE, BigBackpackContainerScreen::new);
        MenuScreens.register(CraftingTableBackpackContainer.TYPE, CraftingTableBackpackContainerScreen::new);
        MenuScreens.register(EnderChestBackpackContainer.TYPE, EnderChestBackpackContainerScreen::new);
        MenuScreens.register(FurnaceBackpackContainer.TYPE, FurnaceBackpackContainerScreen::new);
        MenuScreens.register(TankBackpackContainer.TYPE, TankBackpackContainerScreen::new);

        MenuScreens.register(MaidConfigContainer.TYPE, MaidConfigContainerGui::new);
        MenuScreens.register(WirelessIOContainer.TYPE, WirelessIOContainerGui::new);
        MenuScreens.register(PicnicBasketContainer.TYPE, PicnicBasketContainerScreen::new);
    }
}
