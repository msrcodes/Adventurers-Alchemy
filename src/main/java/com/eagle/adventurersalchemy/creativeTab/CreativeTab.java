package com.eagle.adventurersalchemy.creativeTab;

import com.eagle.adventurersalchemy.Dictionary;
import com.eagle.adventurersalchemy.register.ItemRegistry;
import net.minecraft.block.Block;
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
 * File created @ 06/06/2015, 16:48 GMT.
 */
public class CreativeTab extends CreativeTabs
{
    public static CreativeTab INSTANCE = new CreativeTab();
    List list;

    public CreativeTab()
    {
        super(Dictionary.MOD_ID);
    }

    @Override
    public Item getTabIconItem()
    {
        return ItemRegistry.alchemicalDust;
    }

    @Override
    public void displayAllReleventItems(List list)
    {
        this.list = list;

        addItem(ItemRegistry.alchemicalDust);
    }

    private void addItem(Item item)
    {
        item.getSubItems(item, this, list);
    }

    private void addBlock(Block block)
    {
        ItemStack itemStack = new ItemStack(block);
        block.getSubBlocks(itemStack.getItem(), this, list);
    }
}
