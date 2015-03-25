package net.jtk.darkroleplay.items;

import net.jtk.darkroleplay.main.DarkRoleplayTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

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
}
	