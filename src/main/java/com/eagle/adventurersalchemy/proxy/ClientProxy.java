package com.eagle.adventurersalchemy.proxy;

import com.eagle.adventurersalchemy.register.BlockRegistry;
import com.eagle.adventurersalchemy.render.AlchemicalFireBlockRender;
import com.eagle.adventurersalchemy.render.AlchemicalFireItemRender;
import com.eagle.adventurersalchemy.render.AlchemicalFireRender;
import com.eagle.adventurersalchemy.render.RenderID;
import com.eagle.adventurersalchemy.tile.TileEntityAlchemicalFire;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Adventurer's Alchemy mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Adventurer's Alchemy is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 06/06/2015, 16:28 GMT.
 */
public class ClientProxy extends CommonProxy
{
    public void registerRenderers()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAlchemicalFire.class, new AlchemicalFireRender());
        MinecraftForgeClient.registerItemRenderer(new ItemStack(BlockRegistry.alchemicalFire).getItem(), new AlchemicalFireItemRender());
		RenderID.ALCHEMICAL_FIRE = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new AlchemicalFireBlockRender());
	}
}
