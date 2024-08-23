package com.github.tartaricacid.touhoulittlemaid;

import com.github.tartaricacid.touhoulittlemaid.client.init.InitContainerGui;
import com.github.tartaricacid.touhoulittlemaid.util.EntityCacheUtil;
import net.fabricmc.api.ClientModInitializer;

public class TouhouLittleMaidClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityCacheUtil.onChangeDim();
        InitContainerGui.clientSetup();
    }
}
