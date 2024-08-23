package com.github.tartaricacid.touhoulittlemaid.init;

import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import com.github.tartaricacid.touhoulittlemaid.block.BlockGarageKit;
import com.github.tartaricacid.touhoulittlemaid.item.ItemChair;
import com.github.tartaricacid.touhoulittlemaid.item.ItemEntityPlaceholder;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;


import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.BOOKSHELF;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.BROOM;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.CAMERA;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.CHAIR_SHOW;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.CHISEL;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.COMPUTER;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.CRAFTING_TABLE_BACKPACK;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.DROWN_PROTECT_BAUBLE;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.ENDER_CHEST_BACKPACK;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.EXPLOSION_PROTECT_BAUBLE;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.EXTINGUISHER;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.FAIRY_SPAWN_EGG;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.FALL_PROTECT_BAUBLE;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.FAVORABILITY_TOOL_ADD;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.FAVORABILITY_TOOL_FULL;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.FAVORABILITY_TOOL_REDUCE;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.FILM;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.FIRE_PROTECT_BAUBLE;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.FURNACE_BACKPACK;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.GOMOKU;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.HAKUREI_GOHEI;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.ITEM_MAGNET_BAUBLE;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.KAPPA_COMPASS;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.KEYBOARD;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.MAGIC_PROTECT_BAUBLE;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.MAID_BACKPACK_BIG;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.MAID_BACKPACK_MIDDLE;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.MAID_BACKPACK_SMALL;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.MAID_BEACON;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.MAID_BED;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.MAID_SPAWN_EGG;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.MODEL_SWITCHER;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.MUTE_BAUBLE;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.NIMBLE_FABRIC;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.PHOTO;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.PICNIC_BASKET;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.POWER_POINT;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.PROJECTILE_PROTECT_BAUBLE;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.RED_FOX_SCROLL;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.SANAE_GOHEI;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.SHRINE;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.SMART_SLAB_EMPTY;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.SMART_SLAB_INIT;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.SUBSTITUTE_JIZO;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.TANK_BACKPACK;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.TRUMPET;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.ULTRAMARINE_ORB_ELIXIR;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.WHITE_FOX_SCROLL;
import static com.github.tartaricacid.touhoulittlemaid.init.InitItems.WIRELESS_IO;

public class InitCreativeTabs {
    public static final LazyRegistrar<CreativeModeTab> TABS = LazyRegistrar.create(Registries.CREATIVE_MODE_TAB, TouhouLittleMaid.MOD_ID);

    public static RegistryObject<CreativeModeTab> MAIN_TAB = TABS.register("main", () -> CreativeModeTab.builder()
            .title(Component.translatable("item_group.touhou_little_maid.main"))
            .icon(() -> InitItems.HAKUREI_GOHEI.get().getDefaultInstance())
            .displayItems((par, output) -> {
                if (ModList.get().isLoaded("patchouli")) {
                    output.accept(ItemModBook.forBook(new ResourceLocation(TouhouLittleMaid.MOD_ID, "memorizable_gensokyo")));
                }
                output.accept(MAID_SPAWN_EGG.get());
                output.accept(FAIRY_SPAWN_EGG.get());
                output.accept(HAKUREI_GOHEI.get());
                output.accept(SANAE_GOHEI.get());
                output.accept(POWER_POINT.get());
                output.accept(SMART_SLAB_EMPTY.get());
                output.accept(SMART_SLAB_INIT.get());
                output.accept(MAID_BACKPACK_SMALL.get());
                output.accept(MAID_BACKPACK_MIDDLE.get());
                output.accept(MAID_BACKPACK_BIG.get());
                output.accept(CRAFTING_TABLE_BACKPACK.get());
                output.accept(ENDER_CHEST_BACKPACK.get());
                output.accept(FURNACE_BACKPACK.get());
                output.accept(TANK_BACKPACK.get());
                output.accept(SUBSTITUTE_JIZO.get());
                output.accept(ULTRAMARINE_ORB_ELIXIR.get());
                output.accept(EXPLOSION_PROTECT_BAUBLE.get());
                output.accept(FIRE_PROTECT_BAUBLE.get());
                output.accept(PROJECTILE_PROTECT_BAUBLE.get());
                output.accept(MAGIC_PROTECT_BAUBLE.get());
                output.accept(FALL_PROTECT_BAUBLE.get());
                output.accept(DROWN_PROTECT_BAUBLE.get());
                output.accept(NIMBLE_FABRIC.get());
                output.accept(ITEM_MAGNET_BAUBLE.get());
                output.accept(MUTE_BAUBLE.get());
                output.accept(WIRELESS_IO.get());
                output.accept(TRUMPET.get());
                output.accept(RED_FOX_SCROLL.get());
                output.accept(WHITE_FOX_SCROLL.get());
                output.accept(KAPPA_COMPASS.get());
                output.accept(EXTINGUISHER.get());
                output.accept(GOMOKU.get());
                output.accept(KEYBOARD.get());
                output.accept(BOOKSHELF.get());
                output.accept(COMPUTER.get());
                output.accept(FAVORABILITY_TOOL_ADD.get());
                output.accept(FAVORABILITY_TOOL_REDUCE.get());
                output.accept(FAVORABILITY_TOOL_FULL.get());
                output.accept(CAMERA.get());
                output.accept(PHOTO.get());
                output.accept(FILM.get());
                output.accept(CHISEL.get());
                output.accept(MAID_BED.get());
                output.accept(PICNIC_BASKET.get());
                output.accept(MAID_BEACON.get());
                output.accept(SHRINE.get());
                output.accept(MODEL_SWITCHER.get());
                output.accept(CHAIR_SHOW.get());
                output.accept(BROOM.get());
                if (FMLEnvironment.dist == Dist.CLIENT) {
                    ItemEntityPlaceholder.fillItemCategory(output);
                }
                output.accept(getEnchantmentBook(InitEnchantments.IMPEDING));
                output.accept(getEnchantmentBook(InitEnchantments.SPEEDY));
                output.accept(getEnchantmentBook(InitEnchantments.ENDERS_ENDER));
            }).build());

    public static RegistryObject<CreativeModeTab> GARAGE_KIT_TAB = TABS.register("chair", () -> CreativeModeTab.builder()
            .title(Component.translatable("item_group.touhou_little_maid.chair"))
            .icon(() -> InitItems.CHAIR.get().getDefaultInstance())
            .displayItems((par, output) -> {
                ItemChair.fillItemCategory(output);
            }).build());

    public static RegistryObject<CreativeModeTab> CHAIR_TAB = TABS.register("garage_kit", () -> CreativeModeTab.builder()
            .title(Component.translatable("item_group.touhou_little_maid.garage_kit"))
            .icon(() -> InitItems.GARAGE_KIT.get().getDefaultInstance())
            .displayItems((par, output) -> {
                BlockGarageKit.fillItemCategory(output);
            }).build());

    private static ItemStack getEnchantmentBook(RegistryObject<Enchantment> registryObject) {
        Enchantment enchantment = registryObject.get();
        EnchantmentInstance instance = new EnchantmentInstance(enchantment, enchantment.getMaxLevel());
        return EnchantedBookItem.createForEnchantment(instance);
    }
}
