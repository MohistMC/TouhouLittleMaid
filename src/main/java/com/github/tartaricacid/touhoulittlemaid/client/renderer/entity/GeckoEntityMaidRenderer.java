package com.github.tartaricacid.touhoulittlemaid.client.renderer.entity;

import com.github.tartaricacid.touhoulittlemaid.api.entity.IMaid;
import com.github.tartaricacid.touhoulittlemaid.client.entity.GeckoMaidEntity;
import com.github.tartaricacid.touhoulittlemaid.client.model.GeckoMaidModel;
import com.github.tartaricacid.touhoulittlemaid.client.renderer.entity.geckolayer.GeckoLayerMaidBackItem;
import com.github.tartaricacid.touhoulittlemaid.client.renderer.entity.geckolayer.GeckoLayerMaidBackpack;
import com.github.tartaricacid.touhoulittlemaid.client.renderer.entity.geckolayer.GeckoLayerMaidBanner;
import com.github.tartaricacid.touhoulittlemaid.client.renderer.entity.geckolayer.GeckoLayerMaidBipedHead;
import com.github.tartaricacid.touhoulittlemaid.client.renderer.entity.geckolayer.GeckoLayerMaidHeld;
import com.github.tartaricacid.touhoulittlemaid.client.resource.pojo.MaidModelInfo;
import com.github.tartaricacid.touhoulittlemaid.geckolib3.geo.GeoReplacedEntityRenderer;
import com.github.tartaricacid.touhoulittlemaid.geckolib3.geo.render.built.GeoModel;
import com.github.tartaricacid.touhoulittlemaid.geckolib3.resource.GeckoLibCache;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import org.jetbrains.annotations.Nullable;

public class GeckoEntityMaidRenderer extends GeoReplacedEntityRenderer<GeckoMaidEntity> {
    private MaidModelInfo mainInfo;
    private GeoModel geoModel;

    public GeckoEntityMaidRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GeckoMaidModel(), new GeckoMaidEntity());
        addLayer(new GeckoLayerMaidHeld<>(this, renderManager.getItemInHandRenderer()));
        addLayer(new GeckoLayerMaidBipedHead<>(this, renderManager.getModelSet()));
        addLayer(new GeckoLayerMaidBackpack<>(this, renderManager.getModelSet()));
        addLayer(new GeckoLayerMaidBackItem<>(this));
        addLayer(new GeckoLayerMaidBanner<>(this, renderManager.getModelSet()));
    }

    @Override
    public void render(Entity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (!(entity instanceof Mob mob)) {
            return;
        }
        IMaid maid = IMaid.convert(mob);
        if (maid == null) {
            return;
        }
        if (this.animatable != null) {
            this.animatable.setMaid(maid, mainInfo);
        }
        ResourceLocation location = this.modelProvider.getModelLocation(animatable);
        GeoModel geoModel = GeckoLibCache.getInstance().getGeoModels().get(location);
        if (geoModel != null) {
            this.geoModel = geoModel;
            super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        }
    }

    public MaidModelInfo getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(MaidModelInfo mainInfo) {
        this.mainInfo = mainInfo;
    }

    @Override
    public float getHeightScale(Object entity) {
        return mainInfo.getRenderEntityScale();
    }

    @Override
    public float getWidthScale(Object animatable) {
        return mainInfo.getRenderEntityScale();
    }

    @Override
    public int getInstanceId(Object animatable) {
        if (animatable instanceof Mob maid) {
            return maid.getId();
        }
        return super.getInstanceId(22943);
    }

    @Nullable
    @Override
    public GeoModel getGeoModel() {
        return geoModel;
    }
}
