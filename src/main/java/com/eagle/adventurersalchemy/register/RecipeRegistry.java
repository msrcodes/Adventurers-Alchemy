package com.eagle.adventurersalchemy.register;

import cpw.mods.fml.common.registry.GameRegistry;
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
    public static void load()
    {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemRegistry.mortar), " XX", " YX", "Y  ", 'X', "stone", 'Y', "cobblestone"));
    }
}
