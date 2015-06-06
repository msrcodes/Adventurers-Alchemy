package com.eagle.adventurersalchemy.item;

import com.eagle.adventurersalchemy.Dictionary;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Adventurer's Alchemy mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Adventurer's Alchemy is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 06/06/2015, 17:02 GMT.
 */
public class ItemAlchemicalDust extends ItemAAl
{
    public ItemAlchemicalDust()
    {
        super();
        this.setHasSubtypes(true);
        this.setUnlocalizedName(Dictionary.UNLOCALIZED_ALCHEMICAL_DUST);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack itemStack, int renderPass)
    {
        return Integer.parseInt(Dictionary.COLOURS[itemStack.getItemDamage()], 16);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(Dictionary.MOD_ID + ":" + Dictionary.UNLOCALIZED_ALCHEMICAL_DUST);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("%s%s", Dictionary.UNLOCALIZED_ALCHEMICAL_DUST, Dictionary.UNLOCALIZED_ALCHEMICAL_DUST_TYPES[itemStack.getItemDamage()]);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTab, List list)
    {
        for (int meta = 0; meta < Dictionary.UNLOCALIZED_ALCHEMICAL_DUST_TYPES.length; meta++)
        {
            list.add(new ItemStack(this, 1, meta));
        }
    }
}
