package net.jtk.darkroleplay.main;

import net.jtk.darkroleplay.blocks.blockPlaceholder;
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
import net.jtk.darkroleplay.blocks.Cauldrons.CauldronCookingTwo;
import net.jtk.darkroleplay.blocks.Cauldrons.TileEntityCustomCauldron;
import net.jtk.darkroleplay.blocks.Cauldrons.TileEntityCustomCauldronCookingOne;
import net.jtk.darkroleplay.blocks.Cauldrons.TileEntityCustomCauldronCookingTwo;
import net.jtk.darkroleplay.blocks.Chain.Chain;
import net.jtk.darkroleplay.blocks.Chain.TileEntityCustomChain;
import net.jtk.darkroleplay.blocks.ChoppingBlock.ChoppingBlock;
import net.jtk.darkroleplay.blocks.ChoppingBlock.TileEntityCustomChoppingBlock;
import net.jtk.darkroleplay.blocks.Crate.BlockCrate;
import net.jtk.darkroleplay.blocks.Crate.TileEntityCustomCrate;
import net.jtk.darkroleplay.blocks.DungeonChest.DungeonChest;
import net.jtk.darkroleplay.blocks.DungeonChest.TileEntityCustomDungeonChest;
import net.jtk.darkroleplay.blocks.Firepits.LargeFirepit;
import net.jtk.darkroleplay.blocks.Firepits.SmallFirepit;
import net.jtk.darkroleplay.blocks.Firepits.TileEntityCustomLargeFirepit;
import net.jtk.darkroleplay.blocks.Firepits.TileEntityCustomSmallFirepit;
import net.jtk.darkroleplay.blocks.Grindstone.Grindstone;
import net.jtk.darkroleplay.blocks.Grindstone.TileEntityCustomGrindstone;
import net.jtk.darkroleplay.blocks.HangingBridge.HangingBridgeOne;
import net.jtk.darkroleplay.blocks.HangingBridge.HangingBridgeTwo;
import net.jtk.darkroleplay.blocks.HangingBridge.TileEntityCustomHangingBridgeOne;
import net.jtk.darkroleplay.blocks.HangingBridge.TileEntityCustomHangingBridgeTwo;
import net.jtk.darkroleplay.blocks.Hook.Hook;
import net.jtk.darkroleplay.blocks.Hook.TileEntityCustomHook;
import net.jtk.darkroleplay.blocks.KeyHanging.KeyHanging;
import net.jtk.darkroleplay.blocks.KeyHanging.TileEntityCustomKeyHanging;
import net.jtk.darkroleplay.blocks.Mugs.MugBeer;
import net.jtk.darkroleplay.blocks.Mugs.MugEmpty;
import net.jtk.darkroleplay.blocks.Mugs.TileEntityCustomMugBeer;
import net.jtk.darkroleplay.blocks.Mugs.TileEntityCustomMugEmpty;
import net.jtk.darkroleplay.blocks.Mushrooms.MushroomBrown;
import net.jtk.darkroleplay.blocks.Mushrooms.MushroomRed;
import net.jtk.darkroleplay.blocks.Mushrooms.TileEntityCustomMushroomBrown;
import net.jtk.darkroleplay.blocks.Mushrooms.TileEntityCustomMushroomRed;
import net.jtk.darkroleplay.blocks.PearYellow.PearHangingYellow;
import net.jtk.darkroleplay.blocks.PearYellow.PearStandingYellow;
import net.jtk.darkroleplay.blocks.PearYellow.TileEntityCustomPearHangingYellow;
import net.jtk.darkroleplay.blocks.PearYellow.TileEntityCustomPearStandingYellow;
import net.jtk.darkroleplay.blocks.Potions.PotionEmpty;
import net.jtk.darkroleplay.blocks.Potions.PotionRegenerationOne;
import net.jtk.darkroleplay.blocks.Potions.TileEntityCustomPotionEmpty;
import net.jtk.darkroleplay.blocks.Potions.TileEntityCustomPotionRegenerationOne;
import net.jtk.darkroleplay.blocks.Rope.BlockRope;
import net.jtk.darkroleplay.blocks.Rope.TileEntityCustomRope;
import net.jtk.darkroleplay.blocks.ShipSteeringWheel.ShipSteeringWheel;
import net.jtk.darkroleplay.blocks.ShipSteeringWheel.TileEntityCustomShipSteeringWheel;
import net.jtk.darkroleplay.blocks.Target.Target;
import net.jtk.darkroleplay.blocks.Target.TileEntityCustomTarget;
import net.jtk.darkroleplay.blocks.Tombstones.TileEntityCustomTombstoneOne;
import net.jtk.darkroleplay.blocks.Tombstones.TombstoneOne;
import net.jtk.darkroleplay.blocks.TrainingsDummy.TileEntityCustomTrainingsDummy;
import net.jtk.darkroleplay.blocks.TrainingsDummy.TrainingsDummy;
import net.jtk.darkroleplay.items.itemAppleGreen;
import net.jtk.darkroleplay.items.itemAppleYellow;
import net.jtk.darkroleplay.items.itemBatEar;
import net.jtk.darkroleplay.items.itemCoinBronze;
import net.jtk.darkroleplay.items.itemCoinGold;
import net.jtk.darkroleplay.items.itemCoinSilver;
import net.jtk.darkroleplay.items.itemDough;
import net.jtk.darkroleplay.items.itemFirewood;
import net.jtk.darkroleplay.items.itemFlour;
import net.jtk.darkroleplay.items.itemFurWolf;
import net.jtk.darkroleplay.items.itemPear;
import net.jtk.darkroleplay.items.itemPumpkinStew;
import net.jtk.darkroleplay.items.itemPurse;
import net.jtk.darkroleplay.items.itemScrollTeleport;
import net.jtk.darkroleplay.items.itemVegieStew;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MainProxy {
	
	@EventHandler
	public static void registerCrafting(FMLInitializationEvent event){
		
		/**/
		
		/*Item Flour*/GameRegistry.addShapelessRecipe(new ItemStack(itemFlour.itemFlour),Items.wheat);
		/*Item Dough*/GameRegistry.addShapelessRecipe(new ItemStack(itemDough.itemDough,1),itemFlour.itemFlour,itemFlour.itemFlour, Items.water_bucket);
		/*Item Dough*/GameRegistry.addShapelessRecipe(new ItemStack(itemDough.itemDough,2),itemFlour.itemFlour,itemFlour.itemFlour,itemFlour.itemFlour,itemFlour.itemFlour, Items.water_bucket);
		/*Item Dough*/GameRegistry.addShapelessRecipe(new ItemStack(itemDough.itemDough,3),itemFlour.itemFlour,itemFlour.itemFlour,itemFlour.itemFlour,itemFlour.itemFlour,itemFlour.itemFlour,itemFlour.itemFlour, Items.water_bucket);
		/*Item Dough*/GameRegistry.addShapelessRecipe(new ItemStack(itemDough.itemDough,4),itemFlour.itemFlour,itemFlour.itemFlour,itemFlour.itemFlour,itemFlour.itemFlour,itemFlour.itemFlour,itemFlour.itemFlour,itemFlour.itemFlour,itemFlour.itemFlour, Items.water_bucket);
		
		/*Trainings Dummy*/GameRegistry.addRecipe(new ItemStack(TrainingsDummy.blockTrainingsDummy, 1), " X ", "ZXZ", " Z ", 'X', Blocks.hay_block, 'Z', Items.stick);
		/*Crate*/GameRegistry.addRecipe(new ItemStack(BlockCrate.blockCrate , 1), "BXB", "X X", "BXB", 'X',Blocks.planks ,'B', Items.iron_ingot);
		/*Rope*/GameRegistry.addRecipe(new ItemStack(BlockRope.blockRope, 1), " X ", " X ", " X ", 'X', Items.string);
		/*Potion Regeneration One*/
		/*Potion Empty*/
		/*Pear Hanging Yellow*/GameRegistry.addRecipe(new ItemStack(PearHangingYellow.blockPearHangingYellow , 1), " X ", "   ", "   ", 'X', itemPear.itemPear);
		/*Pear Standing Yellow*/GameRegistry.addRecipe(new ItemStack(PearStandingYellow.blockPearStandingYellow , 1), "   ", "   ", " X ", 'X', itemPear.itemPear);
		/*Mug*/
		/*Hook*/GameRegistry.addRecipe(new ItemStack(Hook.blockHook, 1), "   ", " X ", " Z ", 'X', Items.iron_ingot, 'Z', Blocks.tripwire_hook);
		/*Chopping Block*/GameRegistry.addRecipe(new ItemStack(ChoppingBlock.blockChoppingBlock, 1), "   ", " Z ", " X ", 'X', Blocks.log, 'Z', Items.iron_axe);
		/*Chopping Block*/GameRegistry.addRecipe(new ItemStack(ChoppingBlock.blockChoppingBlock, 1), "   ", " Z ", " X ", 'X', Blocks.log2, 'Z', Items.iron_axe);
		/*Chain*/GameRegistry.addRecipe(new ItemStack(Chain.blockChain, 1), " X ", " X ", " X ", 'X', Items.iron_ingot);
		/*Cauldron Cooking One*/GameRegistry.addRecipe(new ItemStack(CauldronCookingOne.blockCauldronCookingOne , 1), "   ", " Z ", "BXB", 'X', SmallFirepit.blockSmallFirepit, 'Z', Cauldron.blockCauldron, 'B', Items.iron_ingot);
		/*Cauldron*/GameRegistry.addRecipe(new ItemStack(Cauldron.blockCauldron, 1), " X ", "X X", " Z ", 'X', Items.iron_ingot, 'Z', Blocks.iron_block);
		/*Mushroom Red*/
		/*Mushroom Brown*/
		/*Book One*/GameRegistry.addRecipe(new ItemStack(BlockRope.blockRope, 1), "   ", " X ", "   ", 'X', Items.book);
		/*Large Firepit*/GameRegistry.addRecipe(new ItemStack(LargeFirepit.blockLargeFirepit, 1), "   ", " Z ", "ZXZ", 'Z', itemFirewood.itemFirewood, 'X', SmallFirepit.blockSmallFirepit);
		/*Small Firepit*/GameRegistry.addRecipe(new ItemStack(SmallFirepit.blockSmallFirepit, 1), " Z ", "ZZZ", "XXX", 'Z', itemFirewood.itemFirewood, 'X', Blocks.cobblestone);
		/*Ship Steering Wheel*/
		/*Key Hanging*/
		/*Hanging Bridge Two*/GameRegistry.addRecipe(new ItemStack(HangingBridgeTwo.blockHangingBridgeTwo, 1), "   ", "   ", " XZ", 'X', HangingBridgeOne.blockHangingBridgeOne, 'Z', Blocks.log);
		/*Hanging Bridge One*/GameRegistry.addRecipe(new ItemStack(HangingBridgeOne.blockHangingBridgeOne, 1), "Y Y", "Z Z", "XXX", 'X', Blocks.wooden_slab, 'Z', Items.string,'Y', BlockRope.blockRope);
		/*Barrel Gun Powder*/GameRegistry.addRecipe(new ItemStack(BarrelGunPowder.blockBarrelGunPowder, 1), "XXX", "XXX", " Z ", 'X', Items.gunpowder, 'Z', BarrelEmpty.blockBarrelEmpty);
		/*Barrel Empty*/GameRegistry.addRecipe(new ItemStack(BarrelEmpty.blockBarrelEmpty, 1), "X X", "X X", "ZXZ", 'X', Blocks.planks, 'Z', Items.iron_ingot);
		/*Barrel Closed*/GameRegistry.addRecipe(new ItemStack(BarrelClosed.blockBarrelClosed, 1), "XYX", "X X", "ZXZ", 'X', Blocks.planks, 'Z', Items.iron_ingot,'Y',Blocks.wooden_slab);
		/*Apple Standing Yellow*/GameRegistry.addRecipe(new ItemStack(AppleStandingYellow.blockAppleStandingYellow , 1), " X ", "   ", "   ", 'X', itemAppleYellow.itemAppleYellow);
		/*Apple Hanging Yellow*/GameRegistry.addRecipe(new ItemStack(AppleHangingYellow.blockAppleHangingYellow , 1), " X ", "   ", "   ", 'X', itemAppleYellow.itemAppleYellow);
		/*Apple Standing Red*/GameRegistry.addRecipe(new ItemStack(AppleStandingRed.blockAppleStandingRed , 1), "   ", "   ", " X ", 'X', Items.apple);
		/*Apple Hanging Red*/GameRegistry.addRecipe(new ItemStack(AppleHangingRed.blockAppleHangingRed , 1), " X ", "   ", "   ", 'X', Items.apple);
		/*Apple Standing Green*/GameRegistry.addRecipe(new ItemStack(AppleStandingGreen.blockAppleStandingGreen , 1), " X ", "   ", "   ", 'X', itemAppleGreen.itemAppleGreen);
		/*Apple Hanging Green*/GameRegistry.addRecipe(new ItemStack(AppleHangingGreen.blockAppleHangingGreen , 1), " X ", "   ", "   ", 'X', itemAppleGreen.itemAppleGreen);
		/*Bucket Empty*/GameRegistry.addRecipe(new ItemStack(BucketEmpty.blockBucketEmpty, 1), "X X", "X X", "XXX", 'X', Blocks.planks);
		/*Bucket Dirt*/GameRegistry.addRecipe(new ItemStack(BucketDirt.blockBucketDirt, 1), "   ", " X ", " Z ", 'X', Blocks.dirt, 'Z', BucketEmpty.blockBucketEmpty);
		/*Bucket Flower One*/GameRegistry.addRecipe(new ItemStack(BucketFlowerOne.blockBucketFlowerOne, 1), "   ", "XX ", " Z ", 'X', new ItemStack(Blocks.red_flower, 1, 3), 'Z', BucketDirt.blockBucketDirt);
		/*Bucket Water*/GameRegistry.addRecipe(new ItemStack(BucketWater.blockBucketWater, 1), "   ", " X ", " Z ", 'Z', BucketEmpty.blockBucketEmpty, 'X', Items.water_bucket);
		
		/*Bread*/GameRegistry.addSmelting(new ItemStack(itemDough.itemDough, 1), new ItemStack(Items.bread, 1), 0.1F);
	
	}
	@EventHandler
	public static void registerBlocks(FMLPreInitializationEvent event){
		GameRegistry.registerBlock(blockPlaceholder.blockPlaceholder, "blockPlaceholder");
	
		GameRegistry.registerBlock(TrainingsDummy.blockTrainingsDummy, "blockTrainingsDummy");
		GameRegistry.registerBlock(TombstoneOne.blockTombstoneOne, "blockTombstoneOne");
		GameRegistry.registerBlock(PotionEmpty.blockPotionEmpty, "blockPotionEmpty");
		GameRegistry.registerBlock(PotionRegenerationOne.blockPotionRegenerationOne, "blockPotionRegenerationOne");
		GameRegistry.registerBlock(PearHangingYellow.blockPearHangingYellow,"blockPearHangingYellow");
		GameRegistry.registerBlock(PearStandingYellow.blockPearStandingYellow,"blockPearStandingYellow");
		GameRegistry.registerBlock(MugBeer.blockMugBeer, "blockMugBeer");
		GameRegistry.registerBlock(MugEmpty.blockMugEmpty, "blockMugEmpty");
		GameRegistry.registerBlock(Hook.blockHook, "blockHook");
		GameRegistry.registerBlock(Grindstone.blockGrindstone, "blockGrindstone");
		GameRegistry.registerBlock(DungeonChest.blockDungeonChest, "blockDungeonChest");
		GameRegistry.registerBlock(ChoppingBlock.blockChoppingBlock, "blockChoppingBlock");
		GameRegistry.registerBlock(Chain.blockChain, "blockChain");
		GameRegistry.registerBlock(CauldronCookingTwo.blockCauldronCookingTwo, "blockCauldronCookingTwo");
		GameRegistry.registerBlock(BlockRope.blockRope, "blockRope");
		GameRegistry.registerBlock(BlockCrate.blockCrate, "blockCrate");
		GameRegistry.registerBlock(CauldronCookingOne.blockCauldronCookingOne, "blockCauldronCookingOne");
		GameRegistry.registerBlock(Cauldron.blockCauldron, "blockCauldron");
		GameRegistry.registerBlock(MushroomRed.blockMushroomRed, "blockMushroomRed");
		GameRegistry.registerBlock(MushroomBrown.blockMushroomBrown, "blockMushroomBrown");
		GameRegistry.registerBlock(BookOne.blockBookOne, "blockBookOne");
		GameRegistry.registerBlock(LargeFirepit.blockLargeFirepit, "blockLargeFirepit");
		GameRegistry.registerBlock(SmallFirepit.blockSmallFirepit, "blockSmallFirepit");
		GameRegistry.registerBlock(Target.blockTarget, "blockTarget");
		GameRegistry.registerBlock(ShipSteeringWheel.blockShipSteeringWheel, "blockShipSteeringWheel");	
		GameRegistry.registerBlock(KeyHanging.blockKeyHanging, "blockKeyHanging");
		GameRegistry.registerBlock(HangingBridgeTwo.blockHangingBridgeTwo, "blockHangingBridgeTwo");
		GameRegistry.registerBlock(HangingBridgeOne.blockHangingBridgeOne, "blockHangingBridgeOne");
		GameRegistry.registerBlock(BucketWater.blockBucketWater, "blockBucketWater");
		GameRegistry.registerBlock(BucketFlowerOne.blockBucketFlowerOne, "blockBucketFlowerOne");
		GameRegistry.registerBlock(BucketEmpty.blockBucketEmpty, "blockBucketEmpty");
		GameRegistry.registerBlock(BucketDirt.blockBucketDirt, "blockBucketDirt");
		GameRegistry.registerBlock(BarrelGunPowder.blockBarrelGunPowder, "blockBarrelGunPowder");
		GameRegistry.registerBlock(BarrelEmpty.blockBarrelEmpty, "blockBarrelEmpty");
		GameRegistry.registerBlock(BarrelClosed.blockBarrelClosed, "blockBarrelClosed");
		GameRegistry.registerBlock(AppleStandingYellow.blockAppleStandingYellow, "blockAppleStandingYellow");
		GameRegistry.registerBlock(AppleHangingYellow.blockAppleHangingYellow, "blockAppleHangingYellow");
		GameRegistry.registerBlock(AppleStandingRed.blockAppleStandingRed, "blockAppleStandingRed");
		GameRegistry.registerBlock(AppleHangingRed.blockAppleHangingRed, "blockAppleHangingRed");
		GameRegistry.registerBlock(AppleStandingGreen.blockAppleStandingGreen, "blockAppleStandingGreen");
		GameRegistry.registerBlock(AppleHangingGreen.blockAppleHangingGreen, "blockAppleHangingGreen");	
		
	}
	@EventHandler
	public static void registerItems(FMLPreInitializationEvent event){
		GameRegistry.registerItem(itemScrollTeleport.itemScrollTeleport, "itemScrollTeleport");
		GameRegistry.registerItem(itemPurse.itemPurse, "itemPurse");
		GameRegistry.registerItem(itemFurWolf.itemFurWolf, "itemFurWolf");
		GameRegistry.registerItem(itemFlour.itemFlour, "itemFlour");
		GameRegistry.registerItem(itemCoinGold.itemCoinGold, "itemCoinGold");
		GameRegistry.registerItem(itemCoinSilver.itemCoinSilver, "itemCoinSilver");
		GameRegistry.registerItem(itemCoinBronze.itemCoinBronze, "itemCoinBronze");
		GameRegistry.registerItem(itemFirewood.itemFirewood, "itemFirewood");
		GameRegistry.registerItem(itemDough.itemDough, "itemDough");
		GameRegistry.registerItem(itemBatEar.itemBatEar, "itemBatEar");
	}
	
	@EventHandler
	public static void registerFood(FMLPreInitializationEvent event){
		GameRegistry.registerItem(itemAppleGreen.itemAppleGreen, "itemAppleGreen");
		GameRegistry.registerItem(itemAppleYellow.itemAppleYellow, "itemAppleYellow");
		GameRegistry.registerItem(itemPumpkinStew.itemPumpkinStew,"itemPumpkinStew");
		GameRegistry.registerItem(itemVegieStew.itemVegieStew,"itemVegieStew");
		GameRegistry.registerItem(itemPear.itemPear,"itemPear");
	}
	
	@EventHandler
	public static void registerTileEntity(FMLPreInitializationEvent event){
		GameRegistry.registerTileEntity(TileEntityCustomTrainingsDummy.class, "TileEntityTrainingsDummy");
		GameRegistry.registerTileEntity(TileEntityCustomCrate.class, "TileEntityCrate");
		GameRegistry.registerTileEntity(TileEntityCustomTombstoneOne.class, "TileEntityTombstoneOne");
		GameRegistry.registerTileEntity(TileEntityCustomRope.class, "TileEntityRope");
		GameRegistry.registerTileEntity(TileEntityCustomPotionEmpty.class, "TileEntityPotionEmpty");
		GameRegistry.registerTileEntity(TileEntityCustomPotionRegenerationOne.class, "TileEntityPotionRegenerationOne");
		GameRegistry.registerTileEntity(TileEntityCustomPearHangingYellow.class, "TileEntityPearHangingYellow");
		GameRegistry.registerTileEntity(TileEntityCustomPearStandingYellow.class, "TileEntityPearStandingYellow");
		GameRegistry.registerTileEntity(TileEntityCustomMugEmpty.class, "TileEntityMugEmpty");
		GameRegistry.registerTileEntity(TileEntityCustomMugBeer.class, "TileEntityMugBeer");
		GameRegistry.registerTileEntity(TileEntityCustomHook.class, "TileEntityHook");
		GameRegistry.registerTileEntity(TileEntityCustomGrindstone.class, "TileEntityGrindstone");
		GameRegistry.registerTileEntity(TileEntityCustomDungeonChest.class, "TileEntityDungeonChest");
		GameRegistry.registerTileEntity(TileEntityCustomChoppingBlock.class, "TileEntityChoppingBlock");
		GameRegistry.registerTileEntity(TileEntityCustomChain.class, "TileEntityChain");
		GameRegistry.registerTileEntity(TileEntityCustomCauldronCookingTwo.class, "TileEntityCauldronCookingTwo");
		GameRegistry.registerTileEntity(TileEntityCustomCauldronCookingOne.class, "TileEntityCauldronCookingOne");
		GameRegistry.registerTileEntity(TileEntityCustomCauldron.class, "TileEntityCauldron");
		GameRegistry.registerTileEntity(TileEntityCustomMushroomRed.class, "TileEntityMushroomRed");
		GameRegistry.registerTileEntity(TileEntityCustomMushroomBrown.class, "TileEntityMushroomBrown");
		GameRegistry.registerTileEntity(TileEntityCustomBookOne.class, "TileEntityBookOne");
		GameRegistry.registerTileEntity(TileEntityCustomLargeFirepit.class, "TileEntityLargeFirepit");
		GameRegistry.registerTileEntity(TileEntityCustomSmallFirepit.class, "TileEntitySmallFirepit");
		GameRegistry.registerTileEntity(TileEntityCustomTarget.class, "TileEntityCustomTarget");
		GameRegistry.registerTileEntity(TileEntityCustomShipSteeringWheel.class, "TileEntityCustomShipSteeringWheel");
		GameRegistry.registerTileEntity(TileEntityCustomKeyHanging.class, "TileEntityCustomKeyHanging");
		GameRegistry.registerTileEntity(TileEntityCustomHangingBridgeTwo.class, "TileEntityHangingBridgeTwo");
		GameRegistry.registerTileEntity(TileEntityCustomHangingBridgeOne.class, "TileEntityHangingBridgeOne");
		GameRegistry.registerTileEntity(TileEntityCustomBucketWater.class, "TileEntityBucketWater");
		GameRegistry.registerTileEntity(TileEntityCustomBucketFlowerOne.class, "TileEntityBucketFlowerOne");
		GameRegistry.registerTileEntity(TileEntityCustomBucketEmpty.class, "TileEntityBucketEmpty");
		GameRegistry.registerTileEntity(TileEntityCustomBucketDirt.class, "TileEntityBucketDirt");
		GameRegistry.registerTileEntity(TileEntityCustomBarrelGunPowder.class, "TileEntityBarrelGunPowder");
		GameRegistry.registerTileEntity(TileEntityCustomBarrelEmpty.class, "TileEntityBarrelEmpty");
		GameRegistry.registerTileEntity(TileEntityCustomBarrelClosed.class, "TileEntityBarrelClosed");
		GameRegistry.registerTileEntity(TileEntityCustomAppleStandingYellow.class, "TileEntityAppleStandingYellow");
		GameRegistry.registerTileEntity(TileEntityCustomAppleHangingYellow.class, "TileEntityAppleHangingYellow");
		GameRegistry.registerTileEntity(TileEntityCustomAppleStandingRed.class, "TileEntityAppleStandingRed");
		GameRegistry.registerTileEntity(TileEntityCustomAppleHangingRed.class, "TileEntityAppleHangingRed");
		GameRegistry.registerTileEntity(TileEntityCustomAppleStandingGreen.class, "TileEntityAppleStandingGreen");
		GameRegistry.registerTileEntity(TileEntityCustomAppleHangingGreen.class, "TileEntityAppleHangingGreen");
	}
}
