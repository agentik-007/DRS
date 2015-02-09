package net.jtk.darkroleplay.items;

import net.jtk.darkroleplay.DarkRoleplayTabs;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class itemDough {
	public static Item itemDough;
	
	public static void Init(FMLInitializationEvent event){
		GameRegistry.addShapelessRecipe(new ItemStack(itemDough),itemFlour.itemFlour,itemFlour.itemFlour, Items.water_bucket);
	}
	public static void serverLoad(FMLServerStartingEvent event){}
	public static void preInit(FMLPreInitializationEvent event){
		GameRegistry.registerItem(itemDough, "itemDough");
	}
	
	static{
		itemDough = new Item()
		.setUnlocalizedName("itemDough")
		.setCreativeTab(DarkRoleplayTabs.drMiscTab);
	}
	
	public static Object instance;
}
