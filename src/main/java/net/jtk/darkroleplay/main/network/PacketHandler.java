package net.jtk.darkroleplay.main.network;

import net.jtk.darkroleplay.main.DarkRoleplay;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("DarkRoleplay".toLowerCase());
		
	public static void init()
	{
		//INSTANCE.registerMessage(/*PacketClass.class,PacketClass.class, ID, Side.Client bzw Side.server*/);
		
		INSTANCE.registerMessage(PacketCraft.class,PacketCraft.class, 0,Side.SERVER);
		INSTANCE.registerMessage(PacketOpenCraftingGui.class,PacketOpenCraftingGui.class, 1,Side.SERVER);
		INSTANCE.registerMessage(PacketOpenInventoryGui.class, PacketOpenInventoryGui.class,2, Side.SERVER);
	}
	
    public static void sendToServer(IMessage message){
    	INSTANCE.sendToServer(message);
    }
	
}

