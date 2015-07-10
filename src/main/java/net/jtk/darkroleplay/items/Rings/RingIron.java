package net.jtk.darkroleplay.items.Rings;

import net.jtk.darkroleplay.main.DarkRoleplayTabs;
import net.minecraft.item.Item;

public class RingIron extends RingBase{
	public static RingBase RingIron;
	
	static{
		RingIron = (RingBase) new RingIron()
		.setUnlocalizedName("RingIron")
		.setCreativeTab(DarkRoleplayTabs.drMiscTab);
	}
}
