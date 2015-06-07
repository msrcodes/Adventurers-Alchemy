package com.eagle.adventurersalchemy;

import com.eagle.adventurersalchemy.proxy.CommonProxy;
import com.eagle.adventurersalchemy.register.ItemRegistry;
import com.eagle.adventurersalchemy.register.RecipeRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Adventurer's Alchemy mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Adventurer's Alchemy is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 06/06/2015, 16:16 GMT.
 */
@Mod(modid = Dictionary.MOD_ID, name = Dictionary.NAME, version = Dictionary.VERSION)
public class AdventurersAlchemy
{
    @SidedProxy(clientSide = Dictionary.CLIENT_PROXY, serverSide = Dictionary.COMMON_PROXY)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ItemRegistry.load();
        RecipeRegistry.load();
    }
}
