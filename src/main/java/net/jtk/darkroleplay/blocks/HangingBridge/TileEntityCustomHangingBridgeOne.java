package net.jtk.darkroleplay.blocks.HangingBridge;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityCustomHangingBridgeOne extends TileEntity {
	@Override
		public AxisAlignedBB getRenderBoundingBox() {
			return AxisAlignedBB.fromBounds(getPos().getX(), getPos().getY() - 1, getPos().getZ(), getPos().getX() + 1, getPos().getY() + 2, getPos().getZ() + 1);
		}
}