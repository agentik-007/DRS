package net.jtk.darkroleplay.main;

import net.jtk.darkroleplay.blocks.blockPlaceholder;
import net.jtk.darkroleplay.blocks.Buckets.BucketFlowerOne;
import net.jtk.darkroleplay.items.itemDough;
import net.jtk.darkroleplay.items.itemFurWolf;
import net.jtk.darkroleplay.items.itemPear;
import net.jtk.darkroleplay.items.itemPurse;
import net.jtk.darkroleplay.items.itemVegieStew;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DarkRoleplayTabs {

	public static CreativeTabs drBlocksTab = new CreativeTabs("DRBlocksTab") {
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem(){
                return Item.getItemFromBlock(BucketFlowerOne.blockBucketFlowerOne);
        }
	};
	public static CreativeTabs drFoodTab = new CreativeTabs("DRFoodTab") {
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem(){
                return itemVegieStew.itemVegieStew;
        }
	};
	public static CreativeTabs drMiscTab = new CreativeTabs("DRMiscTab") {
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem(){
                return itemFurWolf.itemFurWolf;
        }
	};
	public static CreativeTabs drEquipTab = new CreativeTabs("DREquipTab"){
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return itemPurse.itemPurse;
		}
	};
}
