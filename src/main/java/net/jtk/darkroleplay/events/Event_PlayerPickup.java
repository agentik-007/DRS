package net.jtk.darkroleplay.events;

import net.jtk.darkroleplay.items.itemCoinBronze;
import net.jtk.darkroleplay.items.itemCoinGold;
import net.jtk.darkroleplay.items.itemCoinSilver;
import net.jtk.darkroleplay.items.itemPurse;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Event_PlayerPickup {
	@SubscribeEvent
	public void playerPickup(EntityItemPickupEvent e) {
		if(e.entityPlayer.isSneaking() == false){
			if (e.item.getEntityItem().getItem().equals(itemCoinBronze.itemCoinBronze)|| e.item.getEntityItem().getItem().equals(itemCoinSilver.itemCoinSilver)|| e.item.getEntityItem().getItem().equals(itemCoinGold.itemCoinGold)) {
				if (e.entityPlayer.inventory.hasItem(itemPurse.itemPurse)) {ItemStack stack_purse = e.entityPlayer.inventory.getStackInSlot(17);
					if (stack_purse != null) {
						if (stack_purse.getItem().equals(itemPurse.itemPurse)) {
							if (stack_purse.getTagCompound() != null) {
								if (stack_purse.getTagCompound().hasKey("coins")) {

									if (e.item.getEntityItem().getItem().equals(itemCoinBronze.itemCoinBronze)) {
										Integer Amount = e.item.getEntityItem().stackSize;
										NBTTagCompound nbt = (NBTTagCompound) stack_purse.getTagCompound().getTag("coins");
										int GoldCoins = nbt.getInteger("CoinsGold");
										int SilverCoins = nbt.getInteger("CoinsSilver");
										int BronzeCoins = nbt.getInteger("CoinsBronze");			
										if(BronzeCoins + Amount < 99){
											nbt.setInteger("CoinsBronze", BronzeCoins + Amount);
											e.setCanceled(true);
											e.item.setDead();
										}else if(BronzeCoins + Amount >= 100){
											BronzeCoins = BronzeCoins + Amount;
											BronzeCoins = BronzeCoins - 100;
											nbt.setInteger("CoinsBronze", BronzeCoins);
											if(SilverCoins <99){
												nbt.setInteger("CoinsSilver", SilverCoins + 1);
												e.setCanceled(true);
												e.item.setDead();
											}
											else{
												nbt.setInteger("CoinsGold", GoldCoins + 1);
												nbt.setInteger("CoinsSilver", 0);
												e.setCanceled(true);
												e.item.setDead();
											}
										}
									}else if (e.item.getEntityItem().getItem().equals(itemCoinSilver.itemCoinSilver)) {
										Integer Amount = e.item.getEntityItem().stackSize;
										NBTTagCompound nbt = (NBTTagCompound) stack_purse.getTagCompound().getTag("coins");
										int GoldCoins = nbt.getInteger("CoinsGold");
										int SilverCoins = nbt.getInteger("CoinsSilver");			
										if(SilverCoins + Amount < 99){
											nbt.setInteger("CoinsSilver", SilverCoins + Amount);
											e.setCanceled(true);
											e.item.setDead();
										}else if(SilverCoins + Amount >= 100){
											SilverCoins = SilverCoins + Amount;
											SilverCoins = SilverCoins - 100;		
											nbt.setInteger("CoinsSilver", SilverCoins);											
											nbt.setInteger("CoinsGold", GoldCoins + 1);
											e.setCanceled(true);
											e.item.setDead();
										}
									}else if (e.item.getEntityItem().getItem().equals(itemCoinGold.itemCoinGold)) {
										Integer Amount = e.item.getEntityItem().stackSize;
										NBTTagCompound nbt = (NBTTagCompound) stack_purse.getTagCompound().getTag("coins");
										int GoldCoins = nbt.getInteger("CoinsGold");
										nbt.setInteger("CoinsGold", GoldCoins + Amount);
										e.setCanceled(true);
										e.item.setDead();
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
