package net.jtk.darkroleplay.main.network;

import io.netty.buffer.ByteBuf;
import net.jtk.darkroleplay.guis.GuiHandler;
import net.jtk.darkroleplay.main.DarkRoleplay;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketOpenDRPInventory implements IMessage, IMessageHandler<PacketOpenDRPInventory, IMessage>
{
	public PacketOpenDRPInventory(){
		
	}
	
	
	@Override
	public IMessage onMessage(PacketOpenDRPInventory message, MessageContext ctx) {
		//ctx.getServerHandler().playerEntity.openGui(DarkRoleplay.instance, GuiHandler.GUI_INVENTORY, ctx.getServerHandler().playerEntity.worldObj, (int)ctx.getServerHandler().playerEntity.getPosition().getX(), (int)ctx.getServerHandler().playerEntity.getPosition().getY(), (int)ctx.getServerHandler().playerEntity.getPosition().getZ());
		return null;
	}

	@Override
	public void fromBytes(ByteBuf buf) {	
	}

	@Override
	public void toBytes(ByteBuf buf) {	
	}

}
