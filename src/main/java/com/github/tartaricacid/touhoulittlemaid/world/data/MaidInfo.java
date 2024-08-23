package com.github.tartaricacid.touhoulittlemaid.world.data;

import java.util.UUID;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;

public final class MaidInfo {
    private final String dimension;
    private final BlockPos chunkPos;
    private final UUID ownerId;
    private final UUID entityId;
    private final long timestamp;
    private final Component name;

    public MaidInfo(String dimension, BlockPos chunkPos, UUID ownerId, UUID entityId, long timestamp, Component name) {
        this.dimension = dimension;
        this.chunkPos = chunkPos;
        this.ownerId = ownerId;
        this.entityId = entityId;
        this.timestamp = timestamp;
        this.name = name;
    }

    public String getDimension() {
        return dimension;
    }

    public BlockPos getChunkPos() {
        return chunkPos;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public UUID getEntityId() {
        return entityId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Component getName() {
        return name;
    }
}