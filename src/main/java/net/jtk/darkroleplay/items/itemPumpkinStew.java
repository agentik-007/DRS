package net.jtk.darkroleplay.items;

import net.jtk.darkroleplay.main.DarkRoleplayTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

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
}
