package com.eagle.adventurersalchemy.register;

import com.eagle.adventurersalchemy.Dictionary;
import com.eagle.adventurersalchemy.block.BlockAlchemicalFire;
import com.eagle.adventurersalchemy.block.BlockContainerAAl;
import com.eagle.adventurersalchemy.tile.TileEntityAlchemicalFire;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Adventurer's Alchemy mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Adventurer's Alchemy is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 07/06/2015, 17:22 GMT.
 */
public class BlockRegistry
{
    public static final BlockContainerAAl alchemicalFire = new BlockAlchemicalFire();

    public static void load()
    {
        GameRegistry.registerBlock(alchemicalFire, Dictionary.UNLOCALIZED_ALCHEMICAL_FIRE);
        GameRegistry.registerTileEntity(TileEntityAlchemicalFire.class, Dictionary.UNLOCALIZED_ALCHEMICAL_FIRE);
    }
}
