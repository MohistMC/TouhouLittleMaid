package com.github.tartaricacid.touhoulittlemaid.client.event;

import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import com.github.tartaricacid.touhoulittlemaid.init.InitItems;
import com.github.tartaricacid.touhoulittlemaid.item.ItemWirelessIO;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public final class WirelessIORenderEvent {
    @SubscribeEvent
    public static void onRender(RenderLevelStageEvent event) {
        if (event.getStage() == RenderLevelStageEvent.Stage.AFTER_BLOCK_ENTITIES) {
            Minecraft mc = Minecraft.getInstance();
            if (mc.player == null) {
                return;
            }
            ItemStack mainStack = mc.player.getMainHandItem();
            if (mainStack.getItem() != InitItems.WIRELESS_IO.get()) {
                return;
            }
            BlockPos pos = ItemWirelessIO.getBindingPos(mainStack);
            if (pos == null) {
                return;
            }
            Vec3 position = event.getCamera().getPosition().reverse();
            AABB aabb = new AABB(pos).move(position);
            VertexConsumer buffer = mc.renderBuffers().bufferSource().getBuffer(RenderType.LINES);
            LevelRenderer.renderLineBox(event.getPoseStack(), buffer, aabb, 1.0F, 0, 0, 1.0F);
        }
    }
}
