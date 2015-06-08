package com.eagle.adventurersalchemy.item;

import com.eagle.adventurersalchemy.Dictionary;
import com.eagle.adventurersalchemy.register.BlockRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import org.lwjgl.input.Keyboard;

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

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean useInfo)
    {
        if (itemStack.getItemDamage() != 0 && !Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) &&
                !Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
        {
            list.add("§o" + StatCollector.translateToLocal("item.tooltip.latin." +
                    Dictionary.UNLOCALIZED_ALCHEMICAL_DUST_TYPES[itemStack.getItemDamage()].toLowerCase()));
        }
        else if (itemStack.getItemDamage() != 0 &&
                (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)))
        {
            list.add("§o" + StatCollector.translateToLocal("item.tooltip.normal." +
                    Dictionary.UNLOCALIZED_ALCHEMICAL_DUST_TYPES[itemStack.getItemDamage()].toLowerCase()));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        if (itemStack.getItemDamage() == 0)
        {
            return String.format("item.%s%s", Dictionary.UNLOCALIZED_ALCHEMICAL_DUST, Dictionary.UNLOCALIZED_ALCHEMICAL_DUST_TYPES[itemStack.getItemDamage()]);
        }
        else
        {
            return "item." + Dictionary.UNLOCALIZED_ALCHEMICAL_DUST;
        }
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

    @Override
    public boolean onEntityItemUpdate(EntityItem entityItem)
    {
        if (entityItem.getEntityItem().stackSize == 8 && entityItem.getEntityItem().getItemDamage() == 0)
        {
            if (entityItem.worldObj.getBlock((int) entityItem.posX, (int) entityItem.posY, (int) entityItem.posZ) ==
                    Blocks.fire)
            {
                entityItem.worldObj.setBlock((int) entityItem.posX, (int) entityItem.posY, (int) entityItem.posZ, BlockRegistry.alchemicalFire);
                entityItem.worldObj.spawnParticle("largeexplode", entityItem.posX, entityItem.posY, entityItem.posZ, 0.0D, 0.0D, 0.0D);
                entityItem.worldObj.playSoundEffect(entityItem.posX, entityItem.posY, entityItem.posZ, "random.levelup", 2.0F, 1.0F);
                entityItem.setDead();
            }
        }
        return false;
    }
}
