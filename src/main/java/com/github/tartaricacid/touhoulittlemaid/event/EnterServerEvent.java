package com.github.tartaricacid.touhoulittlemaid.event;

import com.github.tartaricacid.touhoulittlemaid.init.InitTrigger;
import io.github.fabricators_of_create.porting_lib.entity.events.PlayerEvents;
import net.minecraft.server.level.ServerPlayer;

public final class EnterServerEvent {
    public static void onAttachCapabilityEvent() {
        PlayerEvents.LOGGED_IN.register(player -> {
            if (player instanceof ServerPlayer serverPlayer) {
                InitTrigger.GIVE_SMART_SLAB_CONFIG.trigger(serverPlayer);
                InitTrigger.GIVE_PATCHOULI_BOOK_CONFIG.trigger(serverPlayer);
            }
        });
    }
}
