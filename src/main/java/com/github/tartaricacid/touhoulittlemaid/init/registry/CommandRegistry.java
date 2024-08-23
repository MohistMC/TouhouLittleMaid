package com.github.tartaricacid.touhoulittlemaid.init.registry;

import com.github.tartaricacid.touhoulittlemaid.command.RootCommand;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public final class CommandRegistry {
    public static void onServerStaring() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            RootCommand.register(dispatcher);
        });
    }
}
