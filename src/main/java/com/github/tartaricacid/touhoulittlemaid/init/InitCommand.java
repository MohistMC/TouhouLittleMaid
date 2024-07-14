package com.github.tartaricacid.touhoulittlemaid.init;

import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import com.github.tartaricacid.touhoulittlemaid.command.arguments.HandleTypeArgument;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;
import net.minecraft.commands.synchronization.ArgumentTypeInfo;
import net.minecraft.commands.synchronization.ArgumentTypeInfos;
import net.minecraft.commands.synchronization.SingletonArgumentInfo;
import net.minecraft.core.registries.BuiltInRegistries;

public class InitCommand {
    public static final LazyRegistrar<ArgumentTypeInfo<?, ?>> ARGUMENT_TYPE = LazyRegistrar.create(BuiltInRegistries.COMMAND_ARGUMENT_TYPE, TouhouLittleMaid.MOD_ID);

    public static final RegistryObject<ArgumentTypeInfo<?, ?>> MAID_HANDLE_TYPES = ARGUMENT_TYPE.register("handle_types", () -> ArgumentTypeInfos.registerByClass(HandleTypeArgument.class, SingletonArgumentInfo.contextFree(HandleTypeArgument::type)));
}
