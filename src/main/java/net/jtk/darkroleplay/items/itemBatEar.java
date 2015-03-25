package net.jtk.darkroleplay.items;

import net.jtk.darkroleplay.main.DarkRoleplayTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class itemBatEar {
public static Item itemBatEar;
	
	static{
		itemBatEar = new Item()
		.setUnlocalizedName("itemBatEar")
		.setCreativeTab(DarkRoleplayTabs.drMiscTab);
	}
	
	public static Object instance;
}

