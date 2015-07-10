package net.jtk.darkroleplay.items;

import net.jtk.darkroleplay.main.DarkRoleplayTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class itemPumpkinStew extends ItemFood{

public static Item itemPumpkinStew;
	
	public itemPumpkinStew(){
		super(7, 0.5F, false);
		setCreativeTab(DarkRoleplayTabs.drFoodTab);
		setUnlocalizedName("itemPear");
		setMaxStackSize(64);
	}
	
	static{
		itemPumpkinStew = new itemPumpkinStew()
		.setMaxStackSize(1)
		.setUnlocalizedName("itemPumpkinStew");
	}
	
	
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
		player.inventory.addItemStackToInventory(new ItemStack(Items.bowl,1));
    }
	
	
}
