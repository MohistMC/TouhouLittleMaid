package com.github.tartaricacid.touhoulittlemaid.init.registry;

import com.github.tartaricacid.touhoulittlemaid.entity.backpack.BackpackManager;
import com.github.tartaricacid.touhoulittlemaid.entity.info.ServerCustomPackLoader;
import com.github.tartaricacid.touhoulittlemaid.network.NetworkHandler;

public final class CommonRegistry {

    public static void onSetupEvent() {
        ServerCustomPackLoader.reloadPacks();
        NetworkHandler.init();
        BackpackManager.initItemIndex();
    }
}