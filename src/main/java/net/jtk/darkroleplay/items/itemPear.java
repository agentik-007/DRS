package net.jtk.darkroleplay.items;


import net.jtk.darkroleplay.main.DarkRoleplayTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class itemPear extends ItemFood{
	
	public static Item itemPear;
	
	public itemPear(){
		super(4, 0.3F, false);
		setCreativeTab(DarkRoleplayTabs.drFoodTab);
		setUnlocalizedName("itemPear");
		setMaxStackSize(64);
	}
	
	static{
		itemPear = new itemPear()
		.setMaxStackSize(64)
		.setUnlocalizedName("itemPear");
	}
}
