package com.eagle.adventurersalchemy.register;

import com.eagle.adventurersalchemy.Dictionary;
import com.eagle.adventurersalchemy.item.ItemAAl;
import com.eagle.adventurersalchemy.item.ItemAlchemicalDust;
import com.eagle.adventurersalchemy.item.ItemMortar;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Adventurer's Alchemy mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Adventurer's Alchemy is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 06/06/2015, 17:20 GMT.
 */
public class ItemRegistry
{
    public static final ItemAAl alchemicalDust = new ItemAlchemicalDust();
    public static final ItemAAl mortar = new ItemMortar();

    public static void load()
    {
        GameRegistry.registerItem(alchemicalDust, Dictionary.UNLOCALIZED_ALCHEMICAL_DUST);
        GameRegistry.registerItem(mortar, Dictionary.UNLOCALIZED_MORTAR);
    }
}
