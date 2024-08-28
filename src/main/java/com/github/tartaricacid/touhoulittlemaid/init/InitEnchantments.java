package com.github.tartaricacid.touhoulittlemaid.init;

import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import com.github.tartaricacid.touhoulittlemaid.item.ItemHakureiGohei;
import com.github.tartaricacid.touhoulittlemaid.item.enchantment.EndersEnderEnchantment;
import com.github.tartaricacid.touhoulittlemaid.item.enchantment.ImpedingEnchantment;
import com.github.tartaricacid.touhoulittlemaid.item.enchantment.SpeedyEnchantment;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class InitEnchantments {
    public static final LazyRegistrar<Enchantment> ENCHANTMENTS = LazyRegistrar.create(BuiltInRegistries.ENCHANTMENT, TouhouLittleMaid.MOD_ID);

    public static final RegistryObject<Enchantment> IMPEDING = ENCHANTMENTS.register("impeding", ImpedingEnchantment::new);
    public static final RegistryObject<Enchantment> SPEEDY = ENCHANTMENTS.register("speedy", SpeedyEnchantment::new);
    public static final RegistryObject<Enchantment> ENDERS_ENDER = ENCHANTMENTS.register("enders_ender", EndersEnderEnchantment::new);

    public static final EnchantmentCategory GOHEI = new EnchantmentCategory(){
        @Override
        public boolean canEnchant(Item item) {
            return item instanceof ItemHakureiGohei;
        }
    };
}
