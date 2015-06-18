package com.eagle.adventurersalchemy.block;

import com.eagle.adventurersalchemy.Dictionary;
import com.eagle.adventurersalchemy.register.ItemRegistry;
import com.eagle.adventurersalchemy.tile.TileEntityAlchemicalFire;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

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
        super(Material.ground);
        this.setHardness(1.0F);
        this.setBlockName(Dictionary.UNLOCALIZED_ALCHEMICAL_FIRE);
        this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.05F, 0.9375F);
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

    @Override
    public Item getItemDropped(int a, Random rand, int b)
    {
        return ItemRegistry.alchemicalDust;
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        if (world.getBlock(x, y - 1, z).isAir(world, x, y, z))
        {
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockToAir(x, y, z);
        }
    }

}
