package com.eagle.adventurersalchemy.render;

import com.eagle.adventurersalchemy.Dictionary;
import com.eagle.adventurersalchemy.model.AlchemicalFireModel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Adventurer's Alchemy mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Adventurer's Alchemy is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 08/06/2015, 17:41 GMT.
 */
@SideOnly(Side.CLIENT)
public class AlchemicalFireItemRender implements IItemRenderer
{
    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        switch (type)
        {
            case ENTITY:
                return true;
            case EQUIPPED:
                return true;
            case EQUIPPED_FIRST_PERSON:
                return true;
            case INVENTORY:
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        AlchemicalFireModel model = new AlchemicalFireModel();

        GL11.glPushMatrix();
        if (type == ItemRenderType.EQUIPPED_FIRST_PERSON)
        {
            GL11.glTranslatef(0.5F, 2.0F, 0.5F);
        }
        else if (RenderItem.renderInFrame)
        {
            GL11.glTranslatef(0.0F, 2.4F, 0.0F);
        }
        else if (type == ItemRenderType.EQUIPPED)
        {
            GL11.glTranslatef(0.5F, 1.9F, 0.5F);
            GL11.glEnable(GL11.GL_CULL_FACE);
        }
        else if (type == ItemRenderType.INVENTORY)
        {
            GL11.glTranslatef(0.5F, 1.7F, 0.5F);
        }
        else if (type == ItemRenderType.ENTITY)
        {
            GL11.glTranslatef(0.0F, 1.2F, 0.0F);
        }
        else
        {
            GL11.glTranslatef(0.5F, 1.2F, 0.5F);
        }

        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Dictionary.TEXTURE_ALCHEMICAL_FIRE));

        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

        model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
