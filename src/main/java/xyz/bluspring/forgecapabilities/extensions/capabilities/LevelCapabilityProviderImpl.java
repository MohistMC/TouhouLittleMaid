package xyz.bluspring.forgecapabilities.extensions.capabilities;

import io.github.fabricators_of_create.porting_lib.entity.extensions.LevelExtensions;
import io.github.fabricators_of_create.porting_lib.util.LazyOptional;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.bluspring.forgecapabilities.capabilities.Capability;

public interface LevelCapabilityProviderImpl extends ICapabilityProviderImplWorkaround<Level>, LevelExtensions, io.github.fabricators_of_create.porting_lib.transfer.internal.extensions.LevelExtensions, io.github.fabricators_of_create.porting_lib.extensions.extensions.LevelExtensions {
    @Override
    default @NotNull <T> LazyOptional<T> getCapability(final @NotNull Capability<T> cap, final @Nullable Direction side) {
        throw new IllegalStateException("bruh");
    }

    @Override
    default void invalidateCaps() {
        ICapabilityProviderImplWorkaround.super.invalidateCaps();
    }
}
