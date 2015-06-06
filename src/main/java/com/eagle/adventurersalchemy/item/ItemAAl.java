package com.eagle.adventurersalchemy.item;

import com.eagle.adventurersalchemy.Dictionary;
import com.eagle.adventurersalchemy.creativeTab.CreativeTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Adventurer's Alchemy mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Adventurer's Alchemy is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 06/06/2015, 17:00 GMT.
 */
public class ItemAAl extends Item
{
    public ItemAAl()
    {
        super();
        this.setCreativeTab(CreativeTab.INSTANCE);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(Dictionary.MOD_ID + ":" + this.getUnlocalizedName());
    }
}
