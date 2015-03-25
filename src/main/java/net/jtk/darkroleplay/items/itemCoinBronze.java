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

public class itemCoinBronze extends Item{
public static Item itemCoinBronze;
	
	static{
		itemCoinBronze = new itemCoinBronze()
		.setUnlocalizedName("itemCoinBronze")
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
							int SilverCoins = nbt.getInteger("CoinsSilver");
							int BronzeCoins = nbt.getInteger("CoinsBronze");
							if(BronzeCoins < 99){
								nbt.setInteger("CoinsBronze", BronzeCoins +1);
								stack.stackSize --;
							}else{
								if(SilverCoins <99){
									nbt.setInteger("CoinsSilver", SilverCoins + 1);
									nbt.setInteger("CoinsBronze", 0);
									stack.stackSize --;
								}else{
									nbt.setInteger("CoinsGold", GoldCoins + 1);
									nbt.setInteger("CoinsSilver", 0);
									nbt.setInteger("CoinsBronze", 0);
									stack.stackSize --;
								}
							}
						}
					}
				}
			}
		}
		return stack;
		
    }
}
