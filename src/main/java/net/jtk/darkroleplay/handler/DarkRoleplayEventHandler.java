package net.jtk.darkroleplay.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;



public class DarkRoleplayEventHandler {
	@SubscribeEvent
	public void onLivingUpdateEvent(LivingUpdateEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			//DarkRPExtendedPlayer props = DarkRPExtendedPlayer.get(player);
			ItemStack heldItem = player.getHeldItem();
		}
	}
	/*@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
	
	if (event.entity instanceof EntityPlayer && DarkRPExtendedPlayer.get((EntityPlayer) event.entity) == null)
	
	DarkRPExtendedPlayer.register((EntityPlayer) event.entity);

	if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(DarkRPExtendedPlayer.EXT_PROP_NAME) == null)
	event.entity.registerExtendedProperties(DarkRPExtendedPlayer.EXT_PROP_NAME, new DarkRPExtendedPlayer((EntityPlayer) event.entity));
	}*/
	
	
}
