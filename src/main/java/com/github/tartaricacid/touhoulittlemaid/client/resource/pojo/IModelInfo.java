package com.github.tartaricacid.touhoulittlemaid.client.resource.pojo;


import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.resources.ResourceLocation;

public interface IModelInfo {
    ResourceLocation getModelId();

    String getName();

    ResourceLocation getModel();

    boolean isGeckoModel();

    @Nullable
    List<ResourceLocation> getAnimation();

    ResourceLocation getTexture();

    @Nullable
    List<ResourceLocation> getExtraTextures();

    List<String> getDescription();

    float getRenderItemScale();

    <T extends IModelInfo> T decorate();

    <T extends IModelInfo> T extra(ResourceLocation newModelId, ResourceLocation texture);
}
