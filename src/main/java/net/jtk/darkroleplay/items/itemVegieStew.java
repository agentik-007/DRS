package net.jtk.darkroleplay.items;

import net.jtk.darkroleplay.main.DarkRoleplayTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class itemVegieStew extends ItemFood{

public static Item itemVegieStew;
	
	public itemVegieStew(){
		super(7, 0.5F, false);
		setCreativeTab(DarkRoleplayTabs.drFoodTab);
		setUnlocalizedName("itemPear");
		setMaxStackSize(64);
	}
	
	static{
		itemVegieStew = new itemVegieStew()
		.setMaxStackSize(1)
		.setUnlocalizedName("itemVegieStew");
	}
	
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
		player.inventory.addItemStackToInventory(new ItemStack(Items.bowl,1));
    }
}
	