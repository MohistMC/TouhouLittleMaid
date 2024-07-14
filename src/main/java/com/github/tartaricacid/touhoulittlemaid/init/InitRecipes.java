package com.github.tartaricacid.touhoulittlemaid.init;

import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import com.github.tartaricacid.touhoulittlemaid.crafting.AltarRecipe;
import com.github.tartaricacid.touhoulittlemaid.crafting.AltarRecipeSerializer;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public final class InitRecipes {
    public static final LazyRegistrar<RecipeSerializer<?>> RECIPE_SERIALIZERS = LazyRegistrar.create(BuiltInRegistries.RECIPE_SERIALIZER, TouhouLittleMaid.MOD_ID);

    public static RegistryObject<RecipeSerializer<?>> ALTAR_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("altar_crafting", AltarRecipeSerializer::new);
    public static RecipeType<AltarRecipe> ALTAR_CRAFTING;

    @SubscribeEvent
    public static void register(RegisterEvent evt) {
        if (evt.getRegistryKey().equals(Registries.RECIPE_SERIALIZER)) {
            ALTAR_CRAFTING = RecipeType.simple(new ResourceLocation(TouhouLittleMaid.MOD_ID, "altar_crafting"));
        }
    }
}
