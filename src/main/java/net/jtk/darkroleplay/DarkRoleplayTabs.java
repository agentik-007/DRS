package net.jtk.darkroleplay;

import net.jtk.darkroleplay.items.DarkRoleplayFood;
import net.jtk.darkroleplay.items.itemDough;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DarkRoleplayTabs {
	public static Object instance;
	public static void serverLoad(FMLServerStartingEvent event){}
	public static void preInit(FMLPreInitializationEvent event){}
	
	public static CreativeTabs drBlocksTab = new CreativeTabs("DRBlocksTab") {
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem(){
                return Item.getItemFromBlock(blockPlaceholder.blockPlaceholder);
        }
	};
	public static CreativeTabs drFoodTab = new CreativeTabs("DRFoodTab") {
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem(){
                return DarkRoleplayFood.itemPear;
        }
	};
	public static CreativeTabs drMiscTab = new CreativeTabs("DRMiscTab") {
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem(){
                return itemDough.itemDough;
        }
	};
}
