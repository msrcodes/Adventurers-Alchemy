package com.eagle.adventurersalchemy.tile;

import com.eagle.adventurersalchemy.item.ItemAlchemicalDust;
import com.eagle.adventurersalchemy.register.ItemRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

import java.util.List;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Adventurer's Alchemy mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Adventurer's Alchemy is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 07/06/2015, 17:23 GMT.
 */
public class TileEntityAlchemicalFire extends TileEntity implements IInventory
{
    private ItemStack[] inventoryContents = new ItemStack[2];
    private int cooldown = 0;

    @Override
    public void updateEntity()
    {
        List entityItems =
                worldObj.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord,
                        xCoord + 1.0D, yCoord + 1.0D, zCoord + 1.0D));
        List entityLivingBases =
                worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord,
                        xCoord + 1.0D, yCoord + 0.2D, zCoord + 1.0D));

        if (cooldown > 0)
        {
            cooldown--;
        }

        for (Object obj : entityLivingBases)
        {
            EntityLivingBase entityLivingBase = (EntityLivingBase) obj;
            entityLivingBase.setFire(1 + worldObj.rand.nextInt(5));
        }

        if (cooldown == 0)
        {
            for (Object obj : entityItems)
            {
                if (obj instanceof EntityItem)
                {
                    EntityItem item = (EntityItem) obj;
                    ItemStack itemStack = item.getEntityItem();
                    if (itemStack.stackSize == 1)
                    {
                        if (this.getStackInSlot(0) == null && this.isItemValidForSlot(0, itemStack))
                        {
                            this.setInventorySlotContents(0, itemStack);
                            item.setFire(3);
                            item.setDead();
                            markDirty();
                        }
                        else if (this.getStackInSlot(1) == null && this.isItemValidForSlot(1, itemStack))
                        {
                            this.setInventorySlotContents(1, itemStack);
                            item.setFire(3);
                            item.setDead();
                            markDirty();
                        }
                        else if (!this.isItemValidForSlot(0, itemStack))
                        {
                            item.setFire(3);
                            item.setDead();
                        }
                    }
                }
            }

            if (this.getStackInSlot(0) != null && this.getStackInSlot(1) != null)
            {
                worldObj.playSoundEffect(xCoord, yCoord, zCoord, "random.fizz", 0.2F, 1.0F);
                inventoryContents[0] = null;
                inventoryContents[1] = null;
                cooldown = 20;
                this.markDirty();

                if (!worldObj.isRemote)
                {
                    worldObj.spawnEntityInWorld(new EntityItem(worldObj,
                            xCoord + 0.5F,
                            yCoord + 0.5F, zCoord + 0.5F, new ItemStack(ItemRegistry.alchemicalDust, 1, 13)));
                }
            }
        }
    }

    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);
        NBTTagList nbttaglist = nbtTagCompound.getTagList("Items", 10);
        this.inventoryContents = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 255;

            if (j >= 0 && j < this.inventoryContents.length)
            {
                this.inventoryContents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
    }

    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.inventoryContents.length; ++i)
        {
            if (this.inventoryContents[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte) i);
                this.inventoryContents[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        nbtTagCompound.setTag("Items", nbttaglist);
    }

    public int getSizeInventory()
    {
        return 2;
    }

    public ItemStack getStackInSlot(int slot)
    {
        return this.inventoryContents[slot];
    }

    public ItemStack decrStackSize(int slot, int amount)
    {
        this.setInventorySlotContents(slot, null);
        this.markDirty();
        return this.inventoryContents[slot];
    }

    public ItemStack getStackInSlotOnClosing(int slot)
    {
        return this.inventoryContents[slot];
    }

    public void setInventorySlotContents(int slot, ItemStack itemStack)
    {
        if (this.isItemValidForSlot(slot, itemStack))
        {
            this.inventoryContents[slot] = itemStack;
            this.markDirty();
        }
    }

    public String getInventoryName()
    {
        return "container.alchemicalFire";
    }

    public boolean hasCustomInventoryName()
    {
        return true;
    }

    public int getInventoryStackLimit()
    {
        return 1;
    }

    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return false;
    }

    public void openInventory() {}

    public void closeInventory() {}

    public boolean isItemValidForSlot(int slot, ItemStack itemStack)
    {
        return itemStack != null && itemStack.getItem() instanceof ItemAlchemicalDust;
    }
}
