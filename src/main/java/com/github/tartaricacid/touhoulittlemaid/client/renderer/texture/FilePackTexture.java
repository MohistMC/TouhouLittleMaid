package com.github.tartaricacid.touhoulittlemaid.client.renderer.texture;

import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.platform.TextureUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;

public class FilePackTexture extends SizeTexture {
    private final ResourceLocation texturePath;
    private final Path rootPath;
    private int width = 16;
    private int height = 16;

    public FilePackTexture(Path rootPath, ResourceLocation texturePath) {
        this.rootPath = rootPath;
        this.texturePath = texturePath;
    }

    @Override
    public boolean isExist() {
        File textureFile = rootPath.resolve("assets").resolve(texturePath.getNamespace()).resolve(texturePath.getPath()).toFile();
        return textureFile.isFile();
    }

    @Override
    public void load(ResourceManager manager) {
        if (!RenderSystem.isOnRenderThreadOrInit()) {
            RenderSystem.recordRenderCall(this::doLoad);
        } else {
            this.doLoad();
        }
    }

    private void doLoad() {
        File textureFile = rootPath.resolve("assets").resolve(texturePath.getNamespace()).resolve(texturePath.getPath()).toFile();
        if (textureFile.isFile()) {
            try (InputStream stream = Files.newInputStream(textureFile.toPath())) {
                NativeImage imageIn = NativeImage.read(stream);
                width = imageIn.getWidth();
                height = imageIn.getHeight();
                TextureUtil.prepareImage(this.getId(), 0, width, height);
                imageIn.upload(0, 0, 0, 0, 0, width, height, false, false, false, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
