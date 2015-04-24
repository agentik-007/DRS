package net.jtk.darkroleplay.events;

import java.util.ArrayList;

import ibxm.Player;
import net.jtk.darkroleplay.guis.DRPGuiVersion;
import net.jtk.darkroleplay.handler.DarkRPExtendedPlayer;
import net.jtk.darkroleplay.handler.UpdateHandler;
import net.jtk.darkroleplay.main.DarkRoleplay;
import net.jtk.darkroleplay.main.loadConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;



public class DarkRoleplayEventHandler{
	//private Minecraft mc;
	private Boolean isOpened = false;
	
	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event){
		System.out.println("1");
		
	}
	
	@SubscribeEvent
	public void onGuiOpened(GuiOpenEvent event){
		if(event.gui instanceof GuiMainMenu){
			if(this.isOpened == false){
				if(loadConfig.UpdateCheck == true){
					if(UpdateHandler.Version != DarkRoleplay.Version){
					//	event.gui = new NewVersion((GuiMainMenu)event.gui);
						this.isOpened = true;
					}
				}
			}
		}
	}
	
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
		if (event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entity;
			
			
		}
	
	//DarkRPExtendedPlayer.register((EntityPlayer) event.entity);
	//if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(DarkRPExtendedPlayer.EXT_MONEY) == null)
	//event.entity.registerExtendedProperties(DarkRPExtendedPlayer.EXT_MONEY, new DarkRPExtendedPlayer((EntityPlayer) event.entity));
	//}
	
	}
}
