package com.github.tartaricacid.touhoulittlemaid.mixin;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IContainerFactory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MenuType.class)
public class MIxinMenuType<T extends AbstractContainerMenu> implements net.minecraftforge.common.extensions.IForgeMenuType<T> {

    @Shadow @Final private MenuType.MenuSupplier<T> constructor;

    @Shadow
    public T create(int p_39986_, Inventory p_39987_) {
        return null;
    }

    @Override
    public T create(int windowId, Inventory playerInv, net.minecraft.network.FriendlyByteBuf extraData) {
        if (this.constructor instanceof IContainerFactory) {
            return ((IContainerFactory<T>) this.constructor).create(windowId, playerInv, extraData);
        }
        return create(windowId, playerInv);
    }
}
