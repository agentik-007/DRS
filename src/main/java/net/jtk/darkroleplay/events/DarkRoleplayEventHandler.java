package net.jtk.darkroleplay.events;

import java.util.ArrayList;

import ibxm.Player;
import net.jtk.darkroleplay.handler.DarkRPExtendedPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;



public class DarkRoleplayEventHandler{
	//private Minecraft mc;
	
	@SubscribeEvent
	public void onLivingUpdateEvent(LivingUpdateEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			ItemStack heldItem = player.getHeldItem();
		}
	}
	
	@SubscribeEvent
	public void EntityItemPickupEvent(EntityItemPickupEvent event){
		//DarkRPExtendedPlayer props = DarkRPExtendedPlayer.get(event.entityPlayer);
		//ArrayList<Integer> test = props.getCurrentMoney();
		//props.giveMoney(1, 1, 1);
		//event.entityPlayer.addChatMessage(new ChatComponentTranslation("Gold Coins: "+test.get(0).toString()+" Silver Coins: " +test.get(1).toString()+" Bronze Coins: "+test.get(2).toString()));
	}
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
	
	if (event.entity instanceof EntityPlayer && DarkRPExtendedPlayer.get((EntityPlayer) event.entity) == null)
	
	DarkRPExtendedPlayer.register((EntityPlayer) event.entity);

	if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(DarkRPExtendedPlayer.EXT_MONEY) == null)
	event.entity.registerExtendedProperties(DarkRPExtendedPlayer.EXT_MONEY, new DarkRPExtendedPlayer((EntityPlayer) event.entity));
	}
	
	
}
