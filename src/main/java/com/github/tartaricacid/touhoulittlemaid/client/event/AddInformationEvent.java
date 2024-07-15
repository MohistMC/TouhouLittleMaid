package com.github.tartaricacid.touhoulittlemaid.client.event;

import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import com.github.tartaricacid.touhoulittlemaid.entity.backpack.BackpackManager;
import com.github.tartaricacid.touhoulittlemaid.item.bauble.BaubleManager;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public final class AddInformationEvent {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onRenderTooltips(ItemTooltipEvent event) {
        if (BaubleManager.getBauble(event.getItemStack()) != null) {
            event.getToolTip().add(Component.literal(" "));
            event.getToolTip().add(Component.translatable("tooltips.touhou_little_maid.bauble.desc"));
            event.getToolTip().add(Component.translatable("tooltips.touhou_little_maid.bauble.usage").withStyle(ChatFormatting.GRAY));
        }
        if (BackpackManager.findBackpack(event.getItemStack()).isPresent()) {
            event.getToolTip().add(Component.literal(" "));
            event.getToolTip().add(Component.translatable("tooltips.touhou_little_maid.backpack.desc"));
            event.getToolTip().add(Component.translatable("tooltips.touhou_little_maid.backpack.usage").withStyle(ChatFormatting.GRAY));
        }
    }
}
