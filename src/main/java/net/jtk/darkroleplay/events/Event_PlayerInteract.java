package net.jtk.darkroleplay.events;

import java.util.ArrayList;
import java.util.List;

import ibxm.Player;
import net.jtk.darkroleplay.items.itemScrollTeleport;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Event_PlayerInteract {
	@Deprecated
	@SubscribeEvent
	public void playerInteract(PlayerInteractEvent e)
	{
		EntityPlayer player = e.entityPlayer;
		ItemStack stack = e.entityPlayer.getHeldItem();
	}
}
