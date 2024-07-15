package com.github.tartaricacid.touhoulittlemaid.client.event;

import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import io.github.fabricators_of_create.porting_lib.event.client.RenderHandCallback.RenderHandEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class CarryMaidHideArmEvent {
    @SubscribeEvent
    public static void onRenderHandEvent(RenderHandEvent event) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player == null) {
            return;
        }
        if (player.getFirstPassenger() instanceof EntityMaid) {
            event.setCanceled(true);
        }
    }
}
