package com.github.tartaricacid.touhoulittlemaid.inventory.handler;


import io.github.fabricators_of_create.porting_lib.transfer.item.ItemStackHandler;

public class AltarItemHandler extends ItemStackHandler {
    @Override
    public int getSlotLimit(int slot) {
        return 1;
    }
}
