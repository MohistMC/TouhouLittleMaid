package com.github.tartaricacid.touhoulittlemaid.inventory.tooltip;

import io.github.fabricators_of_create.porting_lib.transfer.item.ItemStackHandler;
import net.minecraft.world.inventory.tooltip.TooltipComponent;

public record ItemContainerTooltip(ItemStackHandler handler) implements TooltipComponent {
}
