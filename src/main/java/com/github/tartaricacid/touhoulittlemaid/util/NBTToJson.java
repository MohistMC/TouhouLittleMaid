package com.github.tartaricacid.touhoulittlemaid.util;

import com.google.gson.JsonElement;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.JsonOps;
import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;

@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public final class NBTToJson {
    public static Optional<JsonElement> getJson(@Nullable Tag nbt) {
        JsonElement element = null;
        if (nbt != null) {
            element = Dynamic.convert(NbtOps.INSTANCE, JsonOps.INSTANCE, nbt);
        }
        return Optional.ofNullable(element);
    }
}
