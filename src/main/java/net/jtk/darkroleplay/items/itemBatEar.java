package net.jtk.darkroleplay.items;

import net.jtk.darkroleplay.DarkRoleplayTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class itemBatEar {
public static Item itemBatEar;
	
	public static void Init(FMLInitializationEvent event){
	}
	public static void serverLoad(FMLServerStartingEvent event){}
	public static void preInit(FMLPreInitializationEvent event){
		GameRegistry.registerItem(itemBatEar, "itemBatEar");
	}
	
	static{
		itemBatEar = new Item()
		.setUnlocalizedName("itemBatEar")
		.setCreativeTab(DarkRoleplayTabs.drMiscTab);
	}
	
	public static Object instance;
}

