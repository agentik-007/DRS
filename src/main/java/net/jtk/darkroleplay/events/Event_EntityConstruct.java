package net.jtk.darkroleplay.events;

import net.jtk.darkroleplay.entitys.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Event_EntityConstruct {
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event){
		if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null){
		
			ExtendedPlayer.register((EntityPlayer) event.entity);
		}
			
	}
}
