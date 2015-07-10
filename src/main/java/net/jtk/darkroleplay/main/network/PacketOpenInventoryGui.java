package net.jtk.darkroleplay.main.network;

import io.netty.buffer.ByteBuf;
import net.jtk.darkroleplay.guis.GuiHandler;
import net.jtk.darkroleplay.main.DarkRoleplay;
import net.minecraft.entity.player.EntityPlayer;

public class PacketOpenInventoryGui extends PacketBase<PacketOpenInventoryGui>{

	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleClientSide(PacketOpenInventoryGui message,EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleServerSide(PacketOpenInventoryGui message,EntityPlayer player) {
		player.openGui(DarkRoleplay.instance, GuiHandler.GUI_INVENTORY, player.worldObj, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
		
	}

}