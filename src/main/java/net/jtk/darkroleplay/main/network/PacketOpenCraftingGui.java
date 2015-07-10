package net.jtk.darkroleplay.main.network;

import io.netty.buffer.ByteBuf;
import net.jtk.darkroleplay.guis.GuiHandler;
import net.jtk.darkroleplay.main.DarkRoleplay;
import net.minecraft.entity.player.EntityPlayer;

public class PacketOpenCraftingGui extends PacketBase<PacketOpenCraftingGui>{

	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleClientSide(PacketOpenCraftingGui message,EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleServerSide(PacketOpenCraftingGui message,EntityPlayer player) {
		player.openGui(DarkRoleplay.instance, GuiHandler.GUI_CRAFTING, player.worldObj, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
		
	}

}
