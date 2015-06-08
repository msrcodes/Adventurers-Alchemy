package com.eagle.adventurersalchemy.block;

import com.eagle.adventurersalchemy.Dictionary;
import com.eagle.adventurersalchemy.creativeTab.CreativeTab;
import com.eagle.adventurersalchemy.tile.TileEntityAlchemicalFire;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Adventurer's Alchemy mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Adventurer's Alchemy is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 07/06/2015, 17:12 GMT.
 */
public class BlockAlchemicalFire extends BlockContainerAAl
{
    public int color = 0x3fbd2c;

    public BlockAlchemicalFire()
    {
        super(Material.fire);
        this.setCreativeTab(CreativeTab.INSTANCE);
        this.setBlockName(Dictionary.UNLOCALIZED_ALCHEMICAL_FIRE);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityAlchemicalFire();
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }
}
