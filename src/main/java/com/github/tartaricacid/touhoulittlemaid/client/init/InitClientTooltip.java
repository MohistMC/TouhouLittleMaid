package com.github.tartaricacid.touhoulittlemaid.client.init;

import com.github.tartaricacid.touhoulittlemaid.client.tooltip.ClientItemContainerTooltip;
import com.github.tartaricacid.touhoulittlemaid.client.tooltip.ClientMaidTooltip;
import com.github.tartaricacid.touhoulittlemaid.inventory.tooltip.ItemContainerTooltip;
import com.github.tartaricacid.touhoulittlemaid.inventory.tooltip.ItemMaidTooltip;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class InitClientTooltip {
    @SubscribeEvent
    public static void onRegisterClientTooltip(RegisterClientTooltipComponentFactoriesEvent event) {
        event.register(ItemMaidTooltip.class, ClientMaidTooltip::new);
        event.register(ItemContainerTooltip.class, ClientItemContainerTooltip::new);
    }
}
