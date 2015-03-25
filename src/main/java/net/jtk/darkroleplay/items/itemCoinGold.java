package net.jtk.darkroleplay.items;

import net.jtk.darkroleplay.main.DarkRoleplayTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class itemCoinGold extends Item{
public static Item itemCoinGold;
	
	static{
		itemCoinGold = new itemCoinGold()
		.setUnlocalizedName("itemCoinGold")
		.setCreativeTab(DarkRoleplayTabs.drMiscTab);
	}
	
	public static Object instance;
	
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
		if(player.inventory.hasItem(itemPurse.itemPurse)){
			InventoryPlayer inv = player.inventory;
			ItemStack stack_purse = inv.getStackInSlot(17);
			if(stack_purse != null){
				if(stack_purse.getItem().equals(itemPurse.itemPurse)){
					if(stack_purse.getTagCompound() != null){
						if(stack_purse.getTagCompound().hasKey("coins")){
							NBTTagCompound nbt = (NBTTagCompound) stack_purse.getTagCompound().getTag("coins");
							int GoldCoins = nbt.getInteger("CoinsGold");
							nbt.setInteger("CoinsGold", GoldCoins + 1);
							stack.stackSize --;
						}
					}
				}
			}
		}
		return stack;
		
    }
}
