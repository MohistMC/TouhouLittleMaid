package com.github.tartaricacid.touhoulittlemaid.capability;

import io.github.fabricators_of_create.porting_lib.util.LazyOptional;
import net.minecraft.core.Direction;
import net.minecraft.nbt.IntTag;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MaidNumCapabilityProvider implements ICapabilitySerializable<IntTag> {
    public static Capability<MaidNumCapability> MAID_NUM_CAP = CapabilityManager.get(new CapabilityToken<>() {
    });
    private MaidNumCapability instance = null;

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == MAID_NUM_CAP) {
            return LazyOptional.of(this::createCapability).cast();
        }
        return LazyOptional.empty();
    }

    @Nonnull
    private MaidNumCapability createCapability() {
        if (instance == null) {
            this.instance = new MaidNumCapability();
        }
        return instance;
    }

    @Override
    public void deserializeNBT(IntTag nbt) {
        createCapability().deserializeNBT(nbt);
    }

    @Override
    public IntTag serializeNBT() {
        return createCapability().serializeNBT();
    }
}
