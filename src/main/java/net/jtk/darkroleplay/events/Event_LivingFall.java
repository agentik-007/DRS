package net.jtk.darkroleplay.events;

import java.util.Iterator;
import java.util.List;

import net.jtk.darkroleplay.entitys.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Event_LivingFall {

	@SubscribeEvent
	public void onLivingFallEvent(LivingFallEvent event){
		//if (event.entity instanceof EntityPlayer){
		//	ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer) event.entity);	
		//	event.entity.addChatMessage(new ChatComponentTranslation("Your Current Mana: " + props.getCurrentMana()));
		//}
	}	
}
