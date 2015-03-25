package net.jtk.darkroleplay.items;

import net.jtk.darkroleplay.main.DarkRoleplayTabs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class itemFlour {
	public static Item itemFlour;
	
	static{
		itemFlour = new Item()
		.setUnlocalizedName("itemFlour")
		.setCreativeTab(DarkRoleplayTabs.drMiscTab);
	}
	
	public static Object instance;
	public void load(){}
}
