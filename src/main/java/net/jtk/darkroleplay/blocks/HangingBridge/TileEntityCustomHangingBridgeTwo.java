package net.jtk.darkroleplay.blocks.HangingBridge;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityCustomHangingBridgeTwo extends TileEntity {
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
			return AxisAlignedBB.fromBounds(getPos().getX() - 1, getPos().getY(), getPos().getZ() - 1, getPos().getX() + 2, getPos().getY() + 2, getPos().getZ() + 2);
	}
}
