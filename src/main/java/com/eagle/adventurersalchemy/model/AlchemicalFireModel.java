package com.eagle.adventurersalchemy.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Adventurer's Alchemy mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Adventurer's Alchemy is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 08/06/2015, 17:15 GMT.
 */
public class AlchemicalFireModel extends ModelBase
{
    public ModelRenderer pit;
    public ModelRenderer leftBorder;
    public ModelRenderer rightBorder;
    public ModelRenderer frontBorder;
    public ModelRenderer backBorder;

    public AlchemicalFireModel()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.frontBorder = new ModelRenderer(this, 0, 28);
        this.frontBorder.setRotationPoint(-6.0F, 23.2F, -7.0F);
        this.frontBorder.addBox(0.0F, 0.0F, 0.0F, 12, 1, 1, 0.0F);
        this.rightBorder = new ModelRenderer(this, 0, 13);
        this.rightBorder.setRotationPoint(-7.0F, 23.2F, -7.0F);
        this.rightBorder.addBox(0.0F, 0.0F, 0.0F, 1, 1, 14, 0.0F);
        this.backBorder = new ModelRenderer(this, 0, 28);
        this.backBorder.setRotationPoint(-6.0F, 23.2F, 6.0F);
        this.backBorder.addBox(0.0F, 0.0F, 0.0F, 12, 1, 1, 0.0F);
        this.leftBorder = new ModelRenderer(this, 0, 13);
        this.leftBorder.setRotationPoint(6.0F, 23.2F, -7.0F);
        this.leftBorder.addBox(0.0F, 0.0F, 0.0F, 1, 1, 14, 0.0F);
        this.pit = new ModelRenderer(this, 0, 0);
        this.pit.setRotationPoint(-6.0F, 23.5F, -6.0F);
        this.pit.addBox(0.0F, 0.0F, 0.0F, 12, 1, 12, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef(this.frontBorder.offsetX, this.frontBorder.offsetY, this.frontBorder.offsetZ);
        GL11.glTranslatef(
                this.frontBorder.rotationPointX * f5,
                this.frontBorder.rotationPointY * f5, this.frontBorder.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.8D, 1.0D);
        GL11.glTranslatef(-this.frontBorder.offsetX, -this.frontBorder.offsetY, -this.frontBorder.offsetZ);
        GL11.glTranslatef(
                -this.frontBorder.rotationPointX * f5,
                -this.frontBorder.rotationPointY * f5, -this.frontBorder.rotationPointZ * f5);
        this.frontBorder.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.rightBorder.offsetX, this.rightBorder.offsetY, this.rightBorder.offsetZ);
        GL11.glTranslatef(
                this.rightBorder.rotationPointX * f5,
                this.rightBorder.rotationPointY * f5, this.rightBorder.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.8D, 1.0D);
        GL11.glTranslatef(-this.rightBorder.offsetX, -this.rightBorder.offsetY, -this.rightBorder.offsetZ);
        GL11.glTranslatef(
                -this.rightBorder.rotationPointX * f5,
                -this.rightBorder.rotationPointY * f5, -this.rightBorder.rotationPointZ * f5);
        this.rightBorder.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.backBorder.offsetX, this.backBorder.offsetY, this.backBorder.offsetZ);
        GL11.glTranslatef(
                this.backBorder.rotationPointX * f5,
                this.backBorder.rotationPointY * f5, this.backBorder.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.8D, 1.0D);
        GL11.glTranslatef(-this.backBorder.offsetX, -this.backBorder.offsetY, -this.backBorder.offsetZ);
        GL11.glTranslatef(
                -this.backBorder.rotationPointX * f5,
                -this.backBorder.rotationPointY * f5, -this.backBorder.rotationPointZ * f5);
        this.backBorder.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.leftBorder.offsetX, this.leftBorder.offsetY, this.leftBorder.offsetZ);
        GL11.glTranslatef(
                this.leftBorder.rotationPointX * f5,
                this.leftBorder.rotationPointY * f5, this.leftBorder.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.8D, 1.0D);
        GL11.glTranslatef(-this.leftBorder.offsetX, -this.leftBorder.offsetY, -this.leftBorder.offsetZ);
        GL11.glTranslatef(
                -this.leftBorder.rotationPointX * f5,
                -this.leftBorder.rotationPointY * f5, -this.leftBorder.rotationPointZ * f5);
        this.leftBorder.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.pit.offsetX, this.pit.offsetY, this.pit.offsetZ);
        GL11.glTranslatef(this.pit.rotationPointX * f5, this.pit.rotationPointY * f5, this.pit.rotationPointZ * f5);
        GL11.glScaled(1.0D, 0.5D, 1.0D);
        GL11.glTranslatef(-this.pit.offsetX, -this.pit.offsetY, -this.pit.offsetZ);
        GL11.glTranslatef(-this.pit.rotationPointX * f5, -this.pit.rotationPointY * f5, -this.pit.rotationPointZ * f5);
        this.pit.render(f5);
        GL11.glPopMatrix();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
