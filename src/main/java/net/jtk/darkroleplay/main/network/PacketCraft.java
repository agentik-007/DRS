package net.jtk.darkroleplay.main.network;

import java.util.HashMap;
import java.util.LinkedHashMap;

import io.netty.buffer.ByteBuf;
import net.jtk.darkroleplay.main.CraftingManager;
import net.jtk.darkroleplay.main.DarkRoleplay;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketCraft extends PacketBase<PacketCraft>{

	private int recipeID;
	private Block craftingStation;
	private int craftingID;
	
	public PacketCraft(){}
	
	public PacketCraft(Block craftingStation, int recipeID){
		this.recipeID = recipeID;
		craftingID = Block.getIdFromBlock(craftingStation);
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		recipeID = buf.readInt();
		craftingID = buf.readInt();
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(recipeID);
		buf.writeInt(craftingID);
	}

	@Override
	public void handleClientSide(PacketCraft message, EntityPlayer player) {
		
	}

	@Override
	public void handleServerSide(PacketCraft message, EntityPlayer player) {
		CraftingManager cm = new CraftingManager();
		cm.craftItem(message.craftingID,message.recipeID, player);
	}

}
