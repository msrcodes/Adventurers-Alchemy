package com.eagle.adventurersalchemy.render;

import com.eagle.adventurersalchemy.tile.TileEntityAlchemicalFire;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

/**
 * Created by AEnterprise
 */
public class AlchemicalFireBlockRender implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		renderer.renderBlockAsItem(block, 0, 1.0F);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess blockAccess, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		GL11.glPushMatrix();
		TileEntity entity = blockAccess.getTileEntity(x, y, z);
		if (entity instanceof TileEntityAlchemicalFire) {
			TileEntityAlchemicalFire alchemicalFire = (TileEntityAlchemicalFire) entity;
			if (alchemicalFire.getFireIcon() != -1) {
				renderer.renderBlockFire(new DummyFire().setID(alchemicalFire.getFireIcon()), x, y, z);
			}
		}
		GL11.glPopMatrix();
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return RenderID.ALCHEMICAL_FIRE;
	}

	public static class DummyFire extends BlockFire {
		public static IIcon[] icons;
		public int iconID;

		public DummyFire setID(int id) {
			this.iconID = id;
			return this;
		}

		@Override
		public IIcon getFireIcon(int meta) {
			if (iconID == 0)
				return Blocks.fire.getFireIcon(meta);
			return icons[iconID];
		}
	}
}
