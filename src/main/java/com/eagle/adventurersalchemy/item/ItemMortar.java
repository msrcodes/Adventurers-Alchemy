package com.eagle.adventurersalchemy.item;

import com.eagle.adventurersalchemy.Dictionary;
import com.eagle.adventurersalchemy.register.ItemRegistry;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Adventurer's Alchemy mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Adventurer's Alchemy is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 07/06/2015, 10:32 GMT.
 */
public class ItemMortar extends ItemAAl
{
    public ItemMortar()
    {
        super();
        this.setMaxStackSize(1);
        this.setMaxDamage(32);
        this.setNoRepair();
        this.setFull3D();
        this.setUnlocalizedName(Dictionary.UNLOCALIZED_MORTAR);
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if (world.getBlock(x, y, z) == Blocks.stone && side == 1)
        {
            List entityItems = world.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox(x, y, z,
                    x + 1.0D, y + 2.0D, z + 1.0D));
            for (Object obj : entityItems)
            {
                if (obj instanceof EntityItem)
                {
                    EntityItem entityItem = (EntityItem) obj;
                    if (entityItem.getEntityItem().getItem() == new ItemStack(Items.coal, 1, 1).getItem() &&
                            entityItem.getEntityItem().stackSize == 1)
                    {
                        world.spawnParticle("smoke", entityItem.posX, entityItem.posY, entityItem.posZ, 0.0D, 0.0D, 0.0D);
                        //world.playSoundAtEntity(player, "adventurersalchemy:item.mortar.use", 2.0F, 1.0F);
                        world.playSoundEffect(x, y, z, "adventurersalchemy:item.mortar.use", 2.0F, 1.0F);
                        if (!world.isRemote)
                        {
                            entityItem.setEntityItemStack(new ItemStack(ItemRegistry.alchemicalDust));
                            itemStack.damageItem(1, player);
                        }
                    }
                }
            }
        }
        return true;
    }

}
