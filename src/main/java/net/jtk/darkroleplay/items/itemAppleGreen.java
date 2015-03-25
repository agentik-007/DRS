package net.jtk.darkroleplay.items;

import net.jtk.darkroleplay.main.DarkRoleplayTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class itemAppleGreen extends ItemFood{

public static Item itemAppleGreen;
	
	public itemAppleGreen(){
		super(4, 0.3F, false);
		setCreativeTab(DarkRoleplayTabs.drFoodTab);
		setUnlocalizedName("itemPear");
		setMaxStackSize(64);
	}
	
	static{
		itemAppleGreen = new itemAppleGreen()
		.setMaxStackSize(64)
		.setUnlocalizedName("itemAppleGreen");
	}
	
}
