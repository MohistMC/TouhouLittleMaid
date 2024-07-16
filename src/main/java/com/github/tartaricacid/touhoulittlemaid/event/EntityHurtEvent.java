package com.github.tartaricacid.touhoulittlemaid.event;

import com.github.tartaricacid.touhoulittlemaid.config.subconfig.MaidConfig;
import io.github.fabricators_of_create.porting_lib.entity.events.ProjectileImpactCallback;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.phys.EntityHitResult;

public final class EntityHurtEvent {

    public static void onArrowImpact() {
        ProjectileImpactCallback.EVENT.register((proj, hit) -> {
            Entity attacker = proj.getOwner();
            if (attacker instanceof TamableAnimal thrower && hit instanceof EntityHitResult) {
                Entity victim = ((EntityHitResult) hit).getEntity();
                if (victim instanceof TamableAnimal tameable) {
                    if (tameable.getOwnerUUID() != null && tameable.getOwnerUUID().equals(thrower.getOwnerUUID())) {
                        return true;
                    }
                }
                if (victim instanceof LivingEntity) {
                    if (thrower.isOwnedBy((LivingEntity) victim)) {
                        return true;
                    }
                }
                ResourceLocation registryName = BuiltInRegistries.ENTITY_TYPE.getKey(victim.getType());
                if (registryName != null && MaidConfig.MAID_RANGED_ATTACK_IGNORE.get().contains(registryName.toString())) {
                    return true;
                }
            }
            return false;
        });

    }
}
