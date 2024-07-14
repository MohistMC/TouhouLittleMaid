package com.github.tartaricacid.touhoulittlemaid.event.maid;

import com.github.tartaricacid.touhoulittlemaid.api.event.InteractMaidEvent;
import com.github.tartaricacid.touhoulittlemaid.client.gui.item.NameTagGui;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public final class UseNameTagEvent {
    @SubscribeEvent
    @Environment(EnvType.CLIENT)
    public static void onInteractClient(InteractMaidEvent event) {
        ItemStack stack = event.getStack();
        Player player = event.getPlayer();
        EntityMaid maid = event.getMaid();

        if (!stack.hasCustomHoverName() && player.getMainHandItem().getItem() == Items.NAME_TAG && player.equals(maid.getOwner())) {
            if (player.level.isClientSide()) {
                Minecraft.getInstance().setScreen(new NameTagGui(maid));
            }
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    @OnlyIn(Dist.DEDICATED_SERVER)
    public static void onInteractServer(InteractMaidEvent event) {
        ItemStack stack = event.getStack();
        Player player = event.getPlayer();
        EntityMaid maid = event.getMaid();

        if (!stack.hasCustomHoverName() && player.getMainHandItem().getItem() == Items.NAME_TAG && player.equals(maid.getOwner())) {
            event.setCanceled(true);
        }
    }
}
