package com.eagle.adventurersalchemy.api;

import com.eagle.adventurersalchemy.api.recipe.RecipeMortar;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Adventurer's Alchemy mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Adventurer's Alchemy is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 21/06/2015, 09:55 GMT.
 */
public final class AdventurersAlchemyAPI
{
    public static List<RecipeMortar> mortarRecipes = new ArrayList<RecipeMortar>();

    /**
     * Registers a Mortar Recipe.
     *
     * @param input  The input.
     * @param output The output.
     * @return The recipe created.
     */
    public static RecipeMortar registerMortarRecipe(ItemStack input, ItemStack output)
    {
        RecipeMortar recipe = new RecipeMortar(input, output);
        mortarRecipes.add(recipe);
        return recipe;
    }
}
