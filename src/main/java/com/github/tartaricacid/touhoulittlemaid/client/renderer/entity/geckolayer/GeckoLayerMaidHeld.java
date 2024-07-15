package com.github.tartaricacid.touhoulittlemaid.client.renderer.entity.geckolayer;

import com.github.tartaricacid.touhoulittlemaid.geckolib3.core.IAnimatable;
import com.github.tartaricacid.touhoulittlemaid.geckolib3.geo.GeoLayerRenderer;
import com.github.tartaricacid.touhoulittlemaid.geckolib3.geo.IGeoRenderer;
import com.github.tartaricacid.touhoulittlemaid.geckolib3.geo.render.built.GeoBone;
import com.github.tartaricacid.touhoulittlemaid.geckolib3.geo.render.built.GeoModel;
import com.github.tartaricacid.touhoulittlemaid.geckolib3.util.RenderUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class GeckoLayerMaidHeld<T extends LivingEntity & IAnimatable> extends GeoLayerRenderer<T> {
    private final ItemInHandRenderer itemInHandRenderer;

    public GeckoLayerMaidHeld(IGeoRenderer<T> entityRendererIn, ItemInHandRenderer itemInHandRenderer) {
        super(entityRendererIn);
        this.itemInHandRenderer = itemInHandRenderer;
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn, T entityLivingBaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entityRenderer.getGeoModel() == null) {
            return;
        }
        ItemStack offhandItem = entityLivingBaseIn.getOffhandItem();
        ItemStack mainHandItem = entityLivingBaseIn.getMainHandItem();
        GeoModel geoModel = entityRenderer.getGeoModel();
        if (!offhandItem.isEmpty() || !mainHandItem.isEmpty()) {
            poseStack.pushPose();
            if (!geoModel.rightHandBones.isEmpty()) {
                this.renderArmWithItem(entityLivingBaseIn, mainHandItem, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, HumanoidArm.RIGHT, poseStack, bufferIn, packedLightIn);
            }
            if (!geoModel.leftHandBones.isEmpty()) {
                this.renderArmWithItem(entityLivingBaseIn, offhandItem, ItemDisplayContext.THIRD_PERSON_LEFT_HAND, HumanoidArm.LEFT, poseStack, bufferIn, packedLightIn);
            }
            poseStack.popPose();
        }
    }

    protected void renderArmWithItem(LivingEntity livingEntity, ItemStack itemStack, ItemDisplayContext displayContext, HumanoidArm arm, PoseStack poseStack, MultiBufferSource bufferSource, int light) {
        if (!itemStack.isEmpty() && this.entityRenderer.getGeoModel() != null) {
            poseStack.pushPose();
            translateToHand(arm, poseStack, this.entityRenderer.getGeoModel());
            poseStack.translate(0, -0.0625, -0.1);
            poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
            boolean isLeftHand = arm == HumanoidArm.LEFT;
            this.itemInHandRenderer.renderItem(livingEntity, itemStack, displayContext, isLeftHand, poseStack, bufferSource, light);
            poseStack.popPose();
        }
    }

    protected void translateToHand(HumanoidArm arm, PoseStack poseStack, GeoModel geoModel) {
        if (arm == HumanoidArm.LEFT) {
            int size = geoModel.leftHandBones.size();
            for (int i = 0; i < size - 1; i++) {
                RenderUtils.prepMatrixForBone(poseStack, geoModel.leftHandBones.get(i));
            }
            GeoBone lastBone = geoModel.leftHandBones.get(size - 1);
            RenderUtils.translateMatrixToBone(poseStack, lastBone);
            RenderUtils.translateToPivotPoint(poseStack, lastBone);
            RenderUtils.rotateMatrixAroundBone(poseStack, lastBone);
            RenderUtils.scaleMatrixForBone(poseStack, lastBone);
        } else {
            int size = geoModel.rightHandBones.size();
            for (int i = 0; i < size - 1; i++) {
                RenderUtils.prepMatrixForBone(poseStack, geoModel.rightHandBones.get(i));
            }
            GeoBone lastBone = geoModel.rightHandBones.get(size - 1);
            RenderUtils.translateMatrixToBone(poseStack, lastBone);
            RenderUtils.translateToPivotPoint(poseStack, lastBone);
            RenderUtils.rotateMatrixAroundBone(poseStack, lastBone);
            RenderUtils.scaleMatrixForBone(poseStack, lastBone);
        }
    }
}
