package net.jtk.darkroleplay.items;

import net.jtk.darkroleplay.DarkRoleplayTabs;
import net.jtk.darkroleplay.handler.DarkRPExtendedPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;



public class DarkRoleplayFood extends ItemFood{
	public static Object instance;
	
	public static Item itemPear;
	public static Item itemVegieStew;
	public static Item itemPumpkinStew;
	public static Item itemAppleYellow;
	public static Item itemAppleGreen;
	
	public DarkRoleplayFood(int foodAmount, float saturation) {
		super(foodAmount, saturation, false);
		setCreativeTab(DarkRoleplayTabs.drFoodTab);
	}
	
	public static void Init(FMLInitializationEvent event){
	}
	public static void serverLoad(FMLServerStartingEvent event){}
	public static void preInit(FMLPreInitializationEvent event){
		itemPear = new DarkRoleplayFood(4, 0.3F).setUnlocalizedName("itemPear").setMaxStackSize(64);
		GameRegistry.registerItem(itemPear,"itemPear");
		
		itemVegieStew = new DarkRoleplayFood(7,0.5F).setUnlocalizedName("itemVegieStew").setMaxStackSize(1);
		GameRegistry.registerItem(itemVegieStew,"itemVegieStew");
		
		itemPumpkinStew = new DarkRoleplayFood(7, 0.5F).setUnlocalizedName("itemPumpkinStew").setMaxStackSize(1);
		GameRegistry.registerItem(itemPumpkinStew,"itemPumpkinStew");
		
		itemAppleYellow = new DarkRoleplayFood(4, 0.3F).setUnlocalizedName("itemAppleYellow").setMaxStackSize(64);
		GameRegistry.registerItem(itemAppleYellow, "itemAppleYellow");
		
		itemAppleGreen = new DarkRoleplayFood(4,0.3F).setUnlocalizedName("itemAppleGreen").setMaxStackSize(64);
		GameRegistry.registerItem(itemAppleGreen, "itemAppleGreen");
	}
	
	public void load(){
	}
}