package com.github.tartaricacid.touhoulittlemaid.item;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class ItemFavorabilityTool extends Item {
    private final String type;

    public ItemFavorabilityTool(String type) {
        super(new Item.Properties().stacksTo(1));
        this.type = type;
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> components, TooltipFlag pIsAdvanced) {
        components.add(Component.translatable("tooltips.touhou_little_maid.favorability_tool." + this.type).withStyle(ChatFormatting.GRAY));
    }
}
