package com.eagle.adventurersalchemy.register;

import com.eagle.adventurersalchemy.api.AdventurersAlchemyAPI;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Adventurer's Alchemy mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Adventurer's Alchemy is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 07/06/2015, 16:20 GMT.
 */
public class RecipeRegistry
{
    public static void loadCraftingRecipes()
    {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.mortar), " XX", " YX", "Y  ", 'X', "stone", 'Y', "cobblestone"));
    }

    public static void loadMortarRecipes()
    {
        AdventurersAlchemyAPI.registerMortarRecipe(new ItemStack(Items.coal, 1, 1), new ItemStack(ItemRegistry.alchemicalDust, 1, 0));
        AdventurersAlchemyAPI.registerMortarRecipe(new ItemStack(Items.reeds), new ItemStack(Items.sugar, 2));
        AdventurersAlchemyAPI.registerMortarRecipe(new ItemStack(Items.skull, 1, 4), new ItemStack(Items.gunpowder, 6));
        AdventurersAlchemyAPI.registerMortarRecipe(new ItemStack(Items.skull, 1, 0), new ItemStack(Items.bone, 6));
        AdventurersAlchemyAPI.registerMortarRecipe(new ItemStack(Items.skull, 1, 2), new ItemStack(Items.rotten_flesh, 6));
        AdventurersAlchemyAPI.registerMortarRecipe(new ItemStack(Items.bone), new ItemStack(Items.dye, 4, 15));
        AdventurersAlchemyAPI.registerMortarRecipe(new ItemStack(Blocks.pumpkin), new ItemStack(Items.pumpkin_seeds, 6));
        AdventurersAlchemyAPI.registerMortarRecipe(new ItemStack(Items.melon), new ItemStack(Items.melon_seeds, 3));
    }
}
