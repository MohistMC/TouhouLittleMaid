package com.github.tartaricacid.touhoulittlemaid.block.properties;

import java.util.Locale;
import net.minecraft.util.StringRepresentable;

public enum PicnicMatPart implements StringRepresentable {
    CENTER,
    SIDE;

    @Override
    public String getSerializedName() {
        return this.name().toLowerCase(Locale.US);
    }

    public boolean isCenter() {
        return this == CENTER;
    }
}
