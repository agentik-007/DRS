package net.jtk.darkroleplay.handler;



import java.util.Random;

import net.jtk.darkroleplay.items.itemBatEar;
import net.jtk.darkroleplay.items.itemFurWolf;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DarkRoleplayDropHandler {
	public static Random random;
	public static int dropped;

	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event)
	{
		
	if(event.entityLiving instanceof EntityBat)
	{
		random = new Random();
		dropped = random.nextInt(2) + 1;
		event.entityLiving.dropItem(itemBatEar.itemBatEar, dropped);
	}
	
	if(event.entityLiving instanceof EntityWolf)	
	{
		//if(event.entityLiving.getLastAttacker().getHeldItem().equals(Items.iron_sword)){
		event.entityLiving.dropItem(itemFurWolf.itemFurWolf, 1);
	//}
	}
	}
}
