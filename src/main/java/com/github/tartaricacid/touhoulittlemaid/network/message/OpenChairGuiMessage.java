package com.github.tartaricacid.touhoulittlemaid.network.message;

import com.github.tartaricacid.touhoulittlemaid.client.gui.entity.model.ChairModelGui;
import com.github.tartaricacid.touhoulittlemaid.entity.item.EntityChair;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class OpenChairGuiMessage {
    private final int id;

    public OpenChairGuiMessage(int id) {
        this.id = id;
    }

    public static void encode(OpenChairGuiMessage message, FriendlyByteBuf buf) {
        buf.writeInt(message.id);
    }

    public static OpenChairGuiMessage decode(FriendlyByteBuf buf) {
        return new OpenChairGuiMessage(buf.readInt());
    }

    public static void handle(OpenChairGuiMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        if (context.getDirection().getReceptionSide().isClient()) {
            context.enqueueWork(() -> handleOpenGui(message));
        }
        context.setPacketHandled(true);
    }

    @Environment(EnvType.CLIENT)
    private static void handleOpenGui(OpenChairGuiMessage message) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null) {
            return;
        }
        Entity e = mc.level.getEntity(message.id);
        if (mc.player != null && mc.player.isAlive() && e instanceof EntityChair && e.isAlive()) {
            mc.setScreen(new ChairModelGui((EntityChair) e));
        }
    }
}
