package com.github.tartaricacid.touhoulittlemaid.util;

import com.github.tartaricacid.touhoulittlemaid.entity.backpack.BackpackManager;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import io.github.fabricators_of_create.porting_lib.entity.events.EntityEvents;
import java.util.concurrent.TimeUnit;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@Environment(EnvType.CLIENT)
public final class EntityCacheUtil {
    /**
     * 实体缓存，在客户端会大量运用实体渲染，这个缓存可以减少重复创建实体带来的性能问题
     */
    public static final Cache<EntityType<?>, Entity> ENTITY_CACHE = CacheBuilder.newBuilder().expireAfterAccess(5, TimeUnit.MINUTES).build();
    private static ResourceKey<Level> dimAt;

    public static void clearMaidDataResidue(EntityMaid maid, boolean clearEquipmentData) {
        maid.hurtDuration = 0;
        maid.hurtTime = 0;
        maid.deathTime = 0;
        maid.setOnGround(true);
        maid.setInSittingPose(false);
        maid.setMaidBackpackType(BackpackManager.getEmptyBackpack());
        maid.setCustomName(Component.empty());
        if (clearEquipmentData) {
            for (EquipmentSlot slot : EquipmentSlot.values()) {
                maid.setItemSlot(slot, ItemStack.EMPTY);
            }
        }
    }

    public static void onChangeDim() {
        EntityEvents.ON_JOIN_WORLD.register((entity, world, loadedFromDisk) -> {
            if (world.isClientSide && entity == Minecraft.getInstance().player) {
                ResourceKey<Level> dim = entity.level.dimension();
                if (!dim.equals(dimAt)) {
                    dimAt = dim;
                    EntityCacheUtil.ENTITY_CACHE.invalidateAll();
                }
            }
            return loadedFromDisk;
        });
    }
}
