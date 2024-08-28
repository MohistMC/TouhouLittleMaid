package com.github.tartaricacid.touhoulittlemaid.mixin.capabilities;

import io.github.fabricators_of_create.porting_lib.extensions.extensions.LevelExtensions;
import io.github.fabricators_of_create.porting_lib.util.LazyOptional;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import xyz.bluspring.forgecapabilities.capabilities.*;
import xyz.bluspring.forgecapabilities.extensions.capabilities.CapabilityProviderExtension;
import xyz.bluspring.forgecapabilities.extensions.capabilities.LevelCapabilityProviderImpl;

import java.util.function.Supplier;

@Mixin(Level.class)
public abstract class LevelMixin implements CapabilityProviderExtension, LevelCapabilityProviderImpl, LevelExtensions, io.github.fabricators_of_create.porting_lib.entity.extensions.LevelExtensions {
	private final CapabilityProviderWorkaround<Level> workaround = new CapabilityProviderWorkaround<>(Level.class, (Level) (Object) this);

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		return workaround.getCapability(cap, side);
	}

	@Override
	public @Nullable CapabilityDispatcher getCapabilities() {
		return workaround.invokeGetCapabilities();
	}

	@Override
	public CapabilityProviderWorkaround<Level> port_lib$getWorkaround() {
		return workaround;
	}

	@Override
	public boolean areCapsCompatible(CapabilityProvider<Level> other) {
		return workaround.areCapsCompatible(other);
	}

	@Override
	public boolean areCapsCompatible(@Nullable CapabilityDispatcher other) {
		return workaround.areCapsCompatible(other);
	}

	@Override
	public void invalidateCaps() {
		workaround.invalidateCaps();
	}

	@Override
	public void reviveCaps() {
		workaround.reviveCaps();
	}

	@Override
	public void gatherCapabilities(@Nullable Supplier<ICapabilityProvider> parent) {
		workaround.invokeGatherCapabilities(parent);
	}
}
