package com.github.tartaricacid.touhoulittlemaid.event;

import com.github.tartaricacid.touhoulittlemaid.entity.ai.goal.MaidTemptGoal;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import io.github.fabricators_of_create.porting_lib.entity.events.EntityEvents;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Creeper;

public class EntityJoinWorldEvent {

    public static void onEvent() {
        EntityEvents.ON_JOIN_WORLD.register((entity, world, loadedFromDisk) -> {
            if (entity instanceof Creeper creeper) {
                creeper.goalSelector.addGoal(1, new AvoidEntityGoal<>(creeper, EntityMaid.class, 6, 1, 1.2));
            }
            if (entity instanceof Animal animal) {
                animal.goalSelector.getAvailableGoals().stream().filter(goal -> goal.getGoal() instanceof TemptGoal).findFirst().ifPresent(g -> {
                    if (g.getGoal() instanceof TemptGoal temptGoal) {
                        animal.goalSelector.addGoal(g.getPriority(), new MaidTemptGoal(temptGoal.mob, temptGoal.speedModifier, temptGoal.items, temptGoal.canScare));
                    }
                });
            }
            return loadedFromDisk;
        });
    }
}