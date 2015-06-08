package com.eagle.adventurersalchemy.block;

import com.eagle.adventurersalchemy.Dictionary;
import com.eagle.adventurersalchemy.creativeTab.CreativeTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Adventurer's Alchemy mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Adventurer's Alchemy is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 07/06/2015, 17:07 GMT.
 */
public class BlockAAl extends Block
{
    protected BlockAAl()
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTab.INSTANCE);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(Dictionary.MOD_ID + ":" + this.getUnlocalizedName());
    }
}
