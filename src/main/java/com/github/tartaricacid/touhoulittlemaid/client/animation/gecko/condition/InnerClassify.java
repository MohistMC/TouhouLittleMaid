package com.github.tartaricacid.touhoulittlemaid.client.animation.gecko.condition;

import com.github.tartaricacid.touhoulittlemaid.api.entity.IMaid;
import com.github.tartaricacid.touhoulittlemaid.item.ItemHakureiGohei;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ThrowablePotionItem;

public class InnerClassify {
    private static final String EMPTY = "";

	public static String doClassifyTest(String extraPre, IMaid maid, InteractionHand hand) {
		ItemStack itemInHand = maid.asEntity().getItemInHand(hand);
        Item item = itemInHand.getItem();
        if (item instanceof ItemHakureiGohei) {
            return extraPre + "gohei";
        }
        if (item instanceof SwordItem) {
            return extraPre + "sword";
        }
        if (item instanceof AxeItem) {
            return extraPre + "axe";
        }
        if (item instanceof PickaxeItem) {
            return extraPre + "pickaxe";
        }
        if (item instanceof ShovelItem) {
            return extraPre + "shovel";
        }
        if (item instanceof HoeItem) {
            return extraPre + "hoe";
        }
        if (item instanceof ShieldItem) {
            return extraPre + "shield";
        }
        if (item instanceof ThrowablePotionItem) {
            return extraPre + "throwable_potion";
        }
        return EMPTY;
    }
}
