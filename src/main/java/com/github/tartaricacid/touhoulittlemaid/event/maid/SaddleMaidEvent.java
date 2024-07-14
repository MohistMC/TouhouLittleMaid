package com.github.tartaricacid.touhoulittlemaid.event.maid;

import com.github.tartaricacid.touhoulittlemaid.api.event.InteractMaidEvent;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SaddleMaidEvent {
    @SubscribeEvent
    public static void onInteract(InteractMaidEvent event) {
        Player player = event.getPlayer();
        EntityMaid maid = event.getMaid();
        ItemStack stack = event.getStack();
        if (stack.is(Items.SADDLE)) {
            if (player.getPassengers().isEmpty() && maid.getPassengers().isEmpty()) {
                boolean success = maid.startRiding(player);
                if (success) {
                    DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> SaddleMaidEvent::showTips);
                }
                event.setCanceled(true);
                return;
            }
            if (!player.getPassengers().isEmpty()) {
                player.ejectPassengers();
                event.setCanceled(true);
            }
        }
    }

    @Environment(EnvType.CLIENT)
    public static void showTips() {
        Minecraft minecraft = Minecraft.getInstance();
        Component component = Component.translatable("message.touhou_little_maid.saddle.how_to_eject");
        minecraft.gui.setOverlayMessage(component, false);
        minecraft.getNarrator().sayNow(component);
    }
}
