package com.eagle.adventurersalchemy.tile;

import com.eagle.adventurersalchemy.networking.ISynchronizedTile;
import com.eagle.adventurersalchemy.networking.MessageByteBuff;
import com.eagle.adventurersalchemy.networking.PacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by AEnterprise
 */
public abstract class TileEntityBase extends TileEntity implements ISynchronizedTile {
	protected static final int NETWORK_RANGE = 15;

	public void sync() {
		PacketHandler.instance.sendToAllAround(new MessageByteBuff(this), new NetworkRegistry.TargetPoint(worldObj.provider.dimensionId, xCoord, yCoord, zCoord, NETWORK_RANGE));
	}

	@Override
	public int getX() {
		return xCoord;
	}

	@Override
	public int getY() {
		return yCoord;
	}

	@Override
	public int getZ() {
		return zCoord;
	}
}
