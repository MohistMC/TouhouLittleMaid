package xyz.bluspring.forgecapabilities.extensions.capabilities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import xyz.bluspring.forgecapabilities.capabilities.ICapabilityProvider;

public interface ItemCapabilityExtension extends InitializableCapabilityExtension<ItemStack> {
	@Override
	default void initCapabilities() {}

	@Override
	default ICapabilityProvider initCapabilities(ItemStack type, @Nullable CompoundTag tag) {
		throw new IllegalStateException("should be overridden by mixin");
	}
}
