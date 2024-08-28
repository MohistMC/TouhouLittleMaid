/*
 * Copyright (c) Forge Development LLC and contributors
 * SPDX-License-Identifier: LGPL-2.1-only
 */

package net.minecraftforge.common.extensions;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public interface IForgeMenuType<T>
{
    static <T extends AbstractContainerMenu> MenuType<T> create(IContainerFactory<T> factory)
    {
        return new MenuType<>(factory, FeatureFlags.DEFAULT_FLAGS);
    }
    
    T create(int windowId, Inventory playerInv, FriendlyByteBuf extraData);
}
