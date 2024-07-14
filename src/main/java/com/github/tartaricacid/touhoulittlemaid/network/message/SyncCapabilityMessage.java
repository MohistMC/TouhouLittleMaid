package com.github.tartaricacid.touhoulittlemaid.network.message;

import com.github.tartaricacid.touhoulittlemaid.capability.MaidNumCapabilityProvider;
import com.github.tartaricacid.touhoulittlemaid.capability.PowerCapabilityProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SyncCapabilityMessage {
    private final float power;
    private final int maidNum;

    public SyncCapabilityMessage(float power, int maidNum) {
        this.power = power;
        this.maidNum = maidNum;
    }

    public static void encode(SyncCapabilityMessage message, FriendlyByteBuf buf) {
        buf.writeFloat(message.power);
        buf.writeVarInt(message.maidNum);
    }

    public static SyncCapabilityMessage decode(FriendlyByteBuf buf) {
        return new SyncCapabilityMessage(buf.readFloat(), buf.readVarInt());
    }

    public static void handle(SyncCapabilityMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        if (context.getDirection().getReceptionSide().isClient()) {
            context.enqueueWork(() -> handleCapability(message));
        }
        context.setPacketHandled(true);
    }

    @Environment(EnvType.CLIENT)
    private static void handleCapability(SyncCapabilityMessage message) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null || mc.player == null) {
            return;
        }
        mc.player.getCapability(PowerCapabilityProvider.POWER_CAP).ifPresent(cap -> cap.set(message.power));
        mc.player.getCapability(MaidNumCapabilityProvider.MAID_NUM_CAP).ifPresent(cap -> cap.set(message.maidNum));
    }
}
