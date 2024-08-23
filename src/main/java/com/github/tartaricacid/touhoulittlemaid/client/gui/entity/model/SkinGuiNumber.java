package com.github.tartaricacid.touhoulittlemaid.client.gui.entity.model;

import com.github.tartaricacid.touhoulittlemaid.client.resource.pojo.CustomModelPack;
import com.github.tartaricacid.touhoulittlemaid.client.resource.pojo.IModelInfo;
import java.util.List;
import net.minecraft.util.Mth;

public class SkinGuiNumber<T extends IModelInfo> {
    private static final int PACK_INTERVAL = 7;
    private static final int MODEL_PER_ROW = 11;
    private static final int MODEL_TOTAL_ROW = 5;

    private final List<CustomModelPack<T>> modelPackList;

    public SkinGuiNumber(List<CustomModelPack<T>> modelPackList) {
        this.modelPackList = modelPackList;
    }

    public int getPackSize() {
        return this.modelPackList.size();
    }

    public int getModelSize(int packIndex) {
        packIndex = Mth.clamp(packIndex, 0, this.modelPackList.size() - 1);
        return this.modelPackList.get(packIndex).getModelList().size();
    }

    public int getPageSize() {
        return (this.modelPackList.size() - 1) / PACK_INTERVAL + 1;
    }

    public int getTabIndex(int packIndex) {
        return packIndex % PACK_INTERVAL;
    }

    public int getTabSize(int packIndex) {
        if (packIndex < (getPageSize() - 1) * PACK_INTERVAL) {
            return PACK_INTERVAL;
        } else {
            return (getPackSize() - 1) % PACK_INTERVAL + 1;
        }
    }

    public int tabToPackIndex(int tabIndex, int pageIndex) {
        return Mth.clamp(pageIndex * PACK_INTERVAL + tabIndex, 0, getPackSize() - 1);
    }

    public int modelFromIndex(int rowIndex) {
        return MODEL_PER_ROW * rowIndex;
    }

    public int modelToIndex(int packIndex, int rowIndex) {
        return Math.min(MODEL_PER_ROW * (rowIndex + MODEL_TOTAL_ROW), getModelSize(packIndex));
    }

    public int getRowSize(int packIndex) {
        int row = (getModelSize(packIndex) - 1) / MODEL_PER_ROW + 1;
        return Math.max(row - MODEL_TOTAL_ROW, 0);
    }

    public boolean canScroll(int packIndex, int rowIndex) {
        int modelSize = getModelSize(packIndex) - MODEL_PER_ROW * rowIndex;
        return modelSize > MODEL_TOTAL_ROW * MODEL_PER_ROW;
    }

    public float getCurrentScroll(int packIndex, int rowIndex) {
        return Mth.clamp((float) (rowIndex * (1.0 / ((getModelSize(packIndex) - 1) / MODEL_PER_ROW - 4))), 0, 1);
    }
}
