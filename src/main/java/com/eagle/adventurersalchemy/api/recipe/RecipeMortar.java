package com.eagle.adventurersalchemy.api.recipe;

import net.minecraft.item.ItemStack;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Adventurer's Alchemy mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Adventurer's Alchemy is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 21/06/2015, 09:57 GMT.
 */
public class RecipeMortar
{
    ItemStack input;
    ItemStack output;

    public RecipeMortar(ItemStack input, ItemStack output)
    {
        this.input = input;
        this.output = output;
    }

    public ItemStack getInput()
    {
        return input;
    }

    public ItemStack getOutput()
    {
        return output;
    }
}
