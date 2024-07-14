package com.github.tartaricacid.touhoulittlemaid.init;

import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import com.github.tartaricacid.touhoulittlemaid.loot.AdditionLootModifier;
import com.mojang.serialization.Codec;
import io.github.fabricators_of_create.porting_lib.loot.IGlobalLootModifier;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;

public final class InitLootModifier {
    public static final LazyRegistrar<Codec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIER_SERIALIZER = LazyRegistrar.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, TouhouLittleMaid.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADDITION = GLOBAL_LOOT_MODIFIER_SERIALIZER.register("addition", AdditionLootModifier.CODEC);
}