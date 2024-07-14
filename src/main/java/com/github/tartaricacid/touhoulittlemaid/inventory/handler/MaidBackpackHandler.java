package com.github.tartaricacid.touhoulittlemaid.inventory.handler;

import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import io.github.fabricators_of_create.porting_lib.transfer.item.ItemStackHandler;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class MaidBackpackHandler extends ItemStackHandler {
    public static final int BACKPACK_ITEM_SLOT = 5;
    private final EntityMaid maid;

    public MaidBackpackHandler(int size, EntityMaid maid) {
        super(size);
        this.maid = maid;
    }

    @Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
        return EntityMaid.canInsertItem(stack);
    }

    @Override
    protected void onContentsChanged(int slot) {
        if (slot == BACKPACK_ITEM_SLOT) {
            maid.setBackpackShowItem(this.getStackInSlot(slot));
        }
    }
}
