package net.jtk.darkroleplay.items;

import net.jtk.darkroleplay.DarkRoleplayTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class itemFurWolf {
public static Item itemFurWolf;
	
	public static void Init(FMLInitializationEvent event){
	}
	public static void serverLoad(FMLServerStartingEvent event){}
	public static void preInit(FMLPreInitializationEvent event){
		GameRegistry.registerItem(itemFurWolf, "itemFurWolf");
	}
	
	static{
		itemFurWolf = new Item()
		.setUnlocalizedName("itemFurWolf")
		.setCreativeTab(DarkRoleplayTabs.drMiscTab);
	}
	
	public static Object instance;
	public void load(){}
}
