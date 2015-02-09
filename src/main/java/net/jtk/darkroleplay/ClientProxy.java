package net.jtk.darkroleplay;

import net.jtk.darkroleplay.blocks.AppleGreen.AppleHangingGreen;
import net.jtk.darkroleplay.blocks.AppleGreen.AppleStandingGreen;
import net.jtk.darkroleplay.blocks.AppleGreen.TileEntityCustomAppleHangingGreen;
import net.jtk.darkroleplay.blocks.AppleGreen.TileEntityCustomAppleStandingGreen;
import net.jtk.darkroleplay.blocks.AppleGreen.customRendererAppleHangingGreen;
import net.jtk.darkroleplay.blocks.AppleGreen.customRendererAppleStandingGreen;
import net.jtk.darkroleplay.blocks.AppleRed.AppleHangingRed;
import net.jtk.darkroleplay.blocks.AppleRed.AppleStandingRed;
import net.jtk.darkroleplay.blocks.AppleRed.TileEntityCustomAppleHangingRed;
import net.jtk.darkroleplay.blocks.AppleRed.TileEntityCustomAppleStandingRed;
import net.jtk.darkroleplay.blocks.AppleRed.customRendererAppleHangingRed;
import net.jtk.darkroleplay.blocks.AppleRed.customRendererAppleStandingRed;
import net.jtk.darkroleplay.blocks.AppleYellow.AppleHangingYellow;
import net.jtk.darkroleplay.blocks.AppleYellow.AppleStandingYellow;
import net.jtk.darkroleplay.blocks.AppleYellow.TileEntityCustomAppleHangingYellow;
import net.jtk.darkroleplay.blocks.AppleYellow.TileEntityCustomAppleStandingYellow;
import net.jtk.darkroleplay.blocks.AppleYellow.customRendererAppleHangingYellow;
import net.jtk.darkroleplay.blocks.AppleYellow.customRendererAppleStandingYellow;
import net.jtk.darkroleplay.blocks.HangingBridge.DarkRoleplayBlockHangingBridgeOne;
import net.jtk.darkroleplay.blocks.HangingBridge.DarkRoleplayBlockHangingBridgeTwo;
import net.jtk.darkroleplay.blocks.HangingBridge.RenderItemHangingBridgeOne;
import net.jtk.darkroleplay.blocks.HangingBridge.TileEntityCustomHangingBridgeOne;
import net.jtk.darkroleplay.blocks.HangingBridge.TileEntityCustomHangingBridgeTwo;
import net.jtk.darkroleplay.blocks.HangingBridge.customRendererHangingBridgeOne;
import net.jtk.darkroleplay.blocks.HangingBridge.customRendererHangingBridgeTwo;
import net.jtk.darkroleplay.guis.ManaBar;
import net.jtk.darkroleplay.items.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;


public class ClientProxy extends CommonProxy{
	
	public void registerRandomStuff() {
		//MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DarkRoleplayBlockDungeonChest.blockDungeonChest), new ItemRendererBlockDungeonChest());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomDungeonChest.class,new customRendererDungeonChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomCrate.class,new customRendererCrate());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomSmallFirepit.class, new customRendererSmallFirepit());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomLargeFirepit.class, new customRendererLargeFirepit());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomBucketEmpty.class, new customRendererBucketEmpty());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomBucketDirt.class, new customRendererBucketDirt());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomBucketFlowerOne.class, new customRendererBucketFlowerOne());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomBarrelEmpty.class, new customRendererBarrelEmpty());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomBarrelClosed.class, new customRendererBarrelClosed());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomChoppingBlock.class,new customRendererChoppingBlock());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomRope.class, new customRendererRope());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomCauldron.class, new customRendererCauldron());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomChain.class,new customRendererChain());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomGrindstone.class, new customRendererGrindstone());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomHangingBridgeOne.class, new customRendererHangingBridgeOne());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomHangingBridgeTwo.class, new customRendererHangingBridgeTwo());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomTombstoneOne.class, new customRendererTombstoneOne());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomBookOne.class, new customRendererBookOne());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomCauldronCookingOne.class, new customRendererCauldronCookingOne());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomCauldronCookingTwo.class, new customRendererCauldronCookingTwo());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomHook.class, new customRendererHook());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomAppleHangingRed.class, new customRendererAppleHangingRed());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomAppleStandingRed.class, new customRendererAppleStandingRed());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomPearStandingYellow.class, new customRendererPearStandingYellow());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomPearHangingYellow.class, new customRendererPearHangingYellow());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomMugEmpty.class, new customRendererMugEmpty());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomMugBeer.class, new customRendererMugBeer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomMushroomBrown.class, new customRendererMushroomBrown());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomMushroomRed.class, new customRendererMushroomRed());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomTrainingsDummy.class, new customRendererTrainingsDummy());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomPotionEmpty.class, new customRendererPotionEmpty());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomPotionRegenerationOne.class, new customRendererPotionRegenerationOne());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomAppleHangingGreen.class, new customRendererAppleHangingGreen());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomAppleStandingGreen.class, new customRendererAppleStandingGreen());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomAppleHangingYellow.class, new customRendererAppleHangingYellow());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCustomAppleStandingYellow.class, new customRendererAppleStandingYellow());
		//MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(DarkRoleplayBlockHangingBridgeOne.blockHangingBridgeOne), (IItemRenderer)new RenderItemHangingBridgeOne());
	}
	public void registerInitStuff(){
		
		//MinecraftForge.EVENT_BUS.register(new ManaBar(Minecraft.getMinecraft()));
		//Inventory	Texture
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemFlour.itemFlour,0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"itemFlour","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DarkRoleplayFood.itemPear,0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"itemPear","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DarkRoleplayFood.itemVegieStew,0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"itemVegieStew","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DarkRoleplayFood.itemPumpkinStew,0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"itemPumpkinStew","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(blockPlaceholder.blockPlaceholder),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockPlaceholder","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemDough.itemDough,0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"itemDough","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DarkRoleplayFood.itemAppleYellow,0, new ModelResourceLocation(DarkRoleplay.MODID + ":" + "itemAppleYellow","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DarkRoleplayFood.itemAppleGreen,0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"itemAppleGreen","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemFirewood.itemFirewood,0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"itemFirewood","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockChoppingBlock.blockChoppingBlock),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"DarkRoleplayBlockChoppingBlock","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBatEar.itemBatEar,0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"itemBatEar","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemFurWolf.itemFurWolf,0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"itemFurWolf","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockHangingBridgeOne.blockHangingBridgeOne),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockHangingBridgeOne","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockDungeonChest.blockDungeonChest),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockDungeonChest","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockBarrelEmpty.blockBarrelEmpty),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockBarrelEmpty","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockBucketDirt.blockBucketDirt),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockBucketDirt","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockBucketEmpty.blockBucketEmpty),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockBucketEmpty","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockBucketFlowerOne.blockBucketFlowerOne),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockBucketFlowerOne","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockCrate.blockCrate),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockCrate","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockHangingBridgeTwo.blockHangingBridgeTwo),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockHangingBridgeTwo","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockLargeFirepit.blockLargeFirepit),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockLargeFirepit","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockSmallFirepit.blockSmallFirepit),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockSmallFirepit","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockBarrelClosed.blockBarrelClosed),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockBarrelClosed","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockChoppingBlock.blockChoppingBlock),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockChoppingBlock","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockRope.blockRope),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockRope","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockCauldron.blockCauldron),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockCauldron","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockChain.blockChain),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockChain","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockGrindstone.blockGrindstone),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockGrindstone","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockTombstoneOne.blockTombstoneOne),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockTombstoneOne","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockBookOne.blockBookOne),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockBookOne","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockCauldronCookingOne.blockCauldronCookingOne),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockCauldronCookingOne","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockHook.blockHook),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockHook","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(AppleHangingRed.blockAppleHangingRed),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockAppleHangingRed","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(AppleStandingRed.blockAppleStandingRed),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockAppleStandingRed","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockPearHangingYellow.blockPearHangingYellow),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockPearHangingYellow","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockPearStandingYellow.blockPearStandingYellow),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockPearStandingYellow","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockMugEmpty.blockMugEmpty),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockMugEmpty","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockMugBeer.blockMugBeer),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockMugBeer","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockMushroomBrown.blockMushroomBrown),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockMushroomBrown","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockMushroomRed.blockMushroomRed),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockMushroomRed","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockTrainingsDummy.blockTrainingsDummy),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockTrainingsDummy","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockPotionEmpty.blockPotionEmpty),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockPotionEmpty","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(DarkRoleplayBlockPotionRegenerationOne.blockPotionRegenerationOne),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockPotionRegenerationOne","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(AppleHangingGreen.blockAppleHangingGreen),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockAppleHangingGreen","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(AppleStandingGreen.blockAppleStandingGreen),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockAppleStandingGreen","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(AppleHangingYellow.blockAppleHangingYellow),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockAppleHangingYellow","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(AppleStandingYellow.blockAppleStandingYellow),0, new ModelResourceLocation(DarkRoleplay.MODID + ":"+"blockAppleStandingYellow","inventory"));
	}
}
