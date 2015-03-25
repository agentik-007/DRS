package net.jtk.darkroleplay.items;

import net.jtk.darkroleplay.main.DarkRoleplayTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class itemAppleYellow extends ItemFood{

public static Item itemAppleYellow;
	
	public itemAppleYellow(){
		super(4, 0.3F, false);
		setCreativeTab(DarkRoleplayTabs.drFoodTab);
		setUnlocalizedName("itemPear");
		setMaxStackSize(64);
	}
	
	static{
		itemAppleYellow = new itemAppleYellow()
		.setMaxStackSize(64)
		.setUnlocalizedName("itemAppleYellow");
	}
	
}
