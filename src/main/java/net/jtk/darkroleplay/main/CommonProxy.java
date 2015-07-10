package net.jtk.darkroleplay.main;

import net.jtk.darkroleplay.blocks.AppleGreen.AppleHangingGreen;
import net.jtk.darkroleplay.blocks.AppleGreen.AppleStandingGreen;
import net.jtk.darkroleplay.blocks.AppleGreen.TileEntityCustomAppleHangingGreen;
import net.jtk.darkroleplay.blocks.AppleGreen.TileEntityCustomAppleStandingGreen;
import net.jtk.darkroleplay.blocks.AppleRed.AppleHangingRed;
import net.jtk.darkroleplay.blocks.AppleRed.AppleStandingRed;
import net.jtk.darkroleplay.blocks.AppleRed.TileEntityCustomAppleHangingRed;
import net.jtk.darkroleplay.blocks.AppleRed.TileEntityCustomAppleStandingRed;
import net.jtk.darkroleplay.blocks.AppleYellow.AppleHangingYellow;
import net.jtk.darkroleplay.blocks.AppleYellow.AppleStandingYellow;
import net.jtk.darkroleplay.blocks.AppleYellow.TileEntityCustomAppleHangingYellow;
import net.jtk.darkroleplay.blocks.AppleYellow.TileEntityCustomAppleStandingYellow;
import net.jtk.darkroleplay.blocks.Barrels.BarrelClosed;
import net.jtk.darkroleplay.blocks.Barrels.BarrelEmpty;
import net.jtk.darkroleplay.blocks.Barrels.BarrelGunPowder;
import net.jtk.darkroleplay.blocks.Barrels.TileEntityCustomBarrelClosed;
import net.jtk.darkroleplay.blocks.Barrels.TileEntityCustomBarrelEmpty;
import net.jtk.darkroleplay.blocks.Barrels.TileEntityCustomBarrelGunPowder;
import net.jtk.darkroleplay.blocks.Books.BookOne;
import net.jtk.darkroleplay.blocks.Books.TileEntityCustomBookOne;
import net.jtk.darkroleplay.blocks.Buckets.BucketDirt;
import net.jtk.darkroleplay.blocks.Buckets.BucketEmpty;
import net.jtk.darkroleplay.blocks.Buckets.BucketFlowerOne;
import net.jtk.darkroleplay.blocks.Buckets.BucketWater;
import net.jtk.darkroleplay.blocks.Buckets.TileEntityCustomBucketDirt;
import net.jtk.darkroleplay.blocks.Buckets.TileEntityCustomBucketEmpty;
import net.jtk.darkroleplay.blocks.Buckets.TileEntityCustomBucketFlowerOne;
import net.jtk.darkroleplay.blocks.Buckets.TileEntityCustomBucketWater;
import net.jtk.darkroleplay.blocks.Cauldrons.Cauldron;
import net.jtk.darkroleplay.blocks.Cauldrons.CauldronCookingOne;
import net.jtk.darkroleplay.blocks.Cauldrons.TileEntityCustomCauldron;
import net.jtk.darkroleplay.blocks.Cauldrons.TileEntityCustomCauldronCookingOne;
import net.jtk.darkroleplay.blocks.Chain.Chain;
import net.jtk.darkroleplay.blocks.ChoppingBlock.ChoppingBlock;
import net.jtk.darkroleplay.blocks.Crate.Crate;
import net.jtk.darkroleplay.blocks.Firepits.LargeFirepit;
import net.jtk.darkroleplay.blocks.Firepits.SmallFirepit;
import net.jtk.darkroleplay.blocks.Firepits.TileEntityCustomLargeFirepit;
import net.jtk.darkroleplay.blocks.Firepits.TileEntityCustomSmallFirepit;
import net.jtk.darkroleplay.blocks.HangingBridge.HangingBridgeOne;
import net.jtk.darkroleplay.blocks.HangingBridge.HangingBridgeTwo;
import net.jtk.darkroleplay.blocks.HangingBridge.TileEntityCustomHangingBridgeOne;
import net.jtk.darkroleplay.blocks.HangingBridge.TileEntityCustomHangingBridgeTwo;
import net.jtk.darkroleplay.blocks.Hook.Hook;
import net.jtk.darkroleplay.blocks.KeyHanging.KeyHanging;
import net.jtk.darkroleplay.blocks.KeyHanging.TileEntityCustomKeyHanging;
import net.jtk.darkroleplay.blocks.Mushrooms.MushroomBrown;
import net.jtk.darkroleplay.blocks.Mushrooms.MushroomRed;
import net.jtk.darkroleplay.blocks.Mushrooms.TileEntityCustomMushroomBrown;
import net.jtk.darkroleplay.blocks.Mushrooms.TileEntityCustomMushroomRed;
import net.jtk.darkroleplay.blocks.PearYellow.PearHangingYellow;
import net.jtk.darkroleplay.blocks.PearYellow.PearStandingYellow;
import net.jtk.darkroleplay.blocks.PearYellow.TileEntityCustomPearHangingYellow;
import net.jtk.darkroleplay.blocks.Rope.Rope;
import net.jtk.darkroleplay.blocks.ShipSteeringWheel.ShipSteeringWheel;
import net.jtk.darkroleplay.blocks.ShipSteeringWheel.TileEntityCustomShipSteeringWheel;
import net.jtk.darkroleplay.blocks.Target.Target;
import net.jtk.darkroleplay.blocks.Target.TileEntityCustomTarget;
import net.jtk.darkroleplay.blocks.TrainingsDummy.TrainingsDummy;
import net.jtk.darkroleplay.events.Event_PlayerInteract;
import net.jtk.darkroleplay.events.Event_PlayerPickup;
import net.jtk.darkroleplay.handler.DarkRoleplayDropHandler;
import net.jtk.darkroleplay.items.itemAppleGreen;
import net.jtk.darkroleplay.items.itemAppleYellow;
import net.jtk.darkroleplay.items.itemBatEar;
import net.jtk.darkroleplay.items.itemCoinBronze;
import net.jtk.darkroleplay.items.itemCoinGold;
import net.jtk.darkroleplay.items.itemCoinSilver;
import net.jtk.darkroleplay.items.itemDough;
import net.jtk.darkroleplay.items.itemFirewood;
import net.jtk.darkroleplay.items.itemFlour;
import net.jtk.darkroleplay.items.itemPear;
import net.jtk.darkroleplay.items.itemPumpkinStew;
import net.jtk.darkroleplay.items.itemVegieStew;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
//import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;



public class CommonProxy {
	
	
	
	public void registerEvents(){
		

    	
	}
	
	public void bindTileEntity(){
		
	}
	
	public void registerRenders(){
		
	}
	
	public void registerTileEntity(){
		
		
	}

	public World getClientWorld(){
	//	return FMLClientHandler.instance().getClient().theWorld;
		return null;
	}
	
}

class DarkRoleplayFuelHandler implements IFuelHandler {
	@Override
	public int getBurnTime(ItemStack fuel) {
		// TODO Auto-generated method stub
		Item item = fuel.getItem();
		
		if(item.equals(itemFirewood.itemFirewood)){
			return 800;
		}
		
		return 0;
	}
}