package com.github.tartaricacid.touhoulittlemaid.item;

import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import com.github.tartaricacid.touhoulittlemaid.init.InitBlocks;
import java.util.Objects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemGarageKit extends BlockItem {
    private static final String ENTITY_INFO = "EntityInfo";
    private static final CompoundTag DEFAULT_DATA = getDefaultData();

    public ItemGarageKit() {
        super(InitBlocks.GARAGE_KIT.get(), (new Item.Properties()).stacksTo(1));
    }

    private static boolean hasMaidData(ItemStack stack) {
        return stack.hasTag() && !Objects.requireNonNull(stack.getTag()).getCompound(ENTITY_INFO).isEmpty();
    }

    public static CompoundTag getMaidData(ItemStack stack) {
        if (hasMaidData(stack)) {
            return Objects.requireNonNull(stack.getTag()).getCompound(ENTITY_INFO);
        }
        return DEFAULT_DATA;
    }

    private static CompoundTag getDefaultData() {
        CompoundTag data = new CompoundTag();
        data.putString("id", "touhou_little_maid:maid");
        data.putString(EntityMaid.MODEL_ID_TAG, "touhou_little_maid:hakurei_reimu");
        return data;
    }

    // TODO forge api
    /*
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                Minecraft minecraft = Minecraft.getInstance();
                return new TileEntityItemStackGarageKitRenderer(minecraft.getBlockEntityRenderDispatcher(), minecraft.getEntityModels());
            }
        });
    }
     */
}
