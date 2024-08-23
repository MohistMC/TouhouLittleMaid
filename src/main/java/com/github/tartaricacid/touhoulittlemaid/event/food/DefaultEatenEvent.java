package com.github.tartaricacid.touhoulittlemaid.event.food;

import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
public class DefaultEatenEvent {

    /*
    @SubscribeEvent
    public static void onAfterMaidEat(MaidAfterEatEvent event) {
        ItemStack foodAfterEat = event.getFoodAfterEat();
        if (!foodAfterEat.isEmpty()) {
            ItemStack craftingRemainingItem = foodAfterEat.getCraftingRemainingItem();

            if (craftingRemainingItem.isEmpty()) {
                String itemId = ItemsUtil.getItemId(foodAfterEat.getItem());
                for (List<String> strings : MAID_EATEN_RETURN_CONTAINER_LIST.get()) {
                    if (strings.get(0).equals(itemId)) {
                        craftingRemainingItem = getItemStack(strings.get(1));
                        break;
                    }
                }
            }

            if (!craftingRemainingItem.isEmpty()) {
                EntityMaid maid = event.getMaid();
                CombinedInvWrapper availableInv = maid.getAvailableInv(false);
                ItemStack result = ItemHandlerHelper.insertItemStacked(availableInv, craftingRemainingItem, false);
                // 如果女仆背包满了，掉落在地上
                if (!result.isEmpty()) {
                    ItemEntity itemEntity = new ItemEntity(maid.level, maid.getX(), maid.getY(), maid.getZ(), craftingRemainingItem);
                    maid.level.addFreshEntity(itemEntity);
                }
            }
        }
    }
     */

    private static ItemStack getItemStack(String itemId) {
        ResourceLocation resourceLocation = new ResourceLocation(itemId);
        Item value = BuiltInRegistries.ITEM.get(resourceLocation);
        if (value != null) {
            return new ItemStack(value);
        }else {
            TouhouLittleMaid.LOGGER.warn("Can't find item: " + itemId + ", please check your MaidEatenReturnContainerList config entry.");
            return ItemStack.EMPTY;
        }
    }
}
