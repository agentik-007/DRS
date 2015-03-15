package net.jtk.darkroleplay;

import java.util.EnumMap;

import net.jtk.darkroleplay.achievements.AchievementPages;
import net.jtk.darkroleplay.blocks.AppleGreen.AppleHangingGreen;
import net.jtk.darkroleplay.blocks.AppleGreen.AppleStandingGreen;
import net.jtk.darkroleplay.blocks.AppleRed.AppleHangingRed;
import net.jtk.darkroleplay.blocks.AppleRed.AppleStandingRed;
import net.jtk.darkroleplay.blocks.AppleYellow.AppleHangingYellow;
import net.jtk.darkroleplay.blocks.AppleYellow.AppleStandingYellow;
import net.jtk.darkroleplay.blocks.Barrels.BarrelGunPowder;
import net.jtk.darkroleplay.blocks.Barrels.BarrelClosed;
import net.jtk.darkroleplay.blocks.Barrels.BarrelEmpty;
import net.jtk.darkroleplay.blocks.Buckets.BucketWater;
import net.jtk.darkroleplay.blocks.Buckets.BucketDirt;
import net.jtk.darkroleplay.blocks.Buckets.BucketEmpty;
import net.jtk.darkroleplay.blocks.Buckets.BucketFlowerOne;
import net.jtk.darkroleplay.blocks.HangingBridge.HangingBridgeOne;
import net.jtk.darkroleplay.blocks.HangingBridge.HangingBridgeTwo;
import net.jtk.darkroleplay.blocks.KeyHanging.KeyHanging;
import net.jtk.darkroleplay.blocks.ShipSteeringWheel.ShipSteeringWheel;
import net.jtk.darkroleplay.blocks.Target.Target;
import net.jtk.darkroleplay.events.DarkRoleplayEventHandler;
import net.jtk.darkroleplay.events.Event_PlayerInteract;
import net.jtk.darkroleplay.events.Event_PlayerPickup;
import net.jtk.darkroleplay.handler.DarkRoleplayDropHandler;
import net.jtk.darkroleplay.items.DarkRoleplayFood;
import net.jtk.darkroleplay.items.itemBatEar;
import net.jtk.darkroleplay.items.itemCoinBronze;
import net.jtk.darkroleplay.items.itemCoinGold;
import net.jtk.darkroleplay.items.itemCoinSilver;
import net.jtk.darkroleplay.items.itemDough;
import net.jtk.darkroleplay.items.itemFirewood;
import net.jtk.darkroleplay.items.itemFlour;
import net.jtk.darkroleplay.items.itemFurWolf;
import net.jtk.darkroleplay.items.itemPurse;
import net.jtk.darkroleplay.items.itemScrollTeleport;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.InstanceFactory;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.FMLEmbeddedChannel;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = DarkRoleplay.MODID, version = DarkRoleplay.VERSION)
public class DarkRoleplay {
    public static final String MODID = "darkroleplay";
    public static final String VERSION = "0.1.8";
    
    @net.minecraftforge.fml.common.Mod.Instance(MODID)
    public static DarkRoleplay instance;
    
    @SidedProxy(clientSide ="net.jtk.darkroleplay.ClientProxy", serverSide ="net.jtk.darkroleplay.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {		
    	
    	AchievementPages.Load(event);
    	
    	//Item Meshing Blocks´
    	MinecraftForge.EVENT_BUS.register(new Event_PlayerPickup());
    	MinecraftForge.EVENT_BUS.register(new DarkRoleplayDropHandler());
    	MinecraftForge.EVENT_BUS.register(new DarkRoleplayEventHandler());
    	MinecraftForge.EVENT_BUS.register(new Event_PlayerInteract());
    	blockPlaceholder.Init(event);
    	DarkRoleplayBlockPearStandingYellow.Init(event);
    	DarkRoleplayBlockPearHangingYellow.Init(event);
    	AppleStandingRed.Init(event);
    	AppleHangingRed.Init(event);
    	DarkRoleplayBlockCauldronCookingOne.Init(event);
    	DarkRoleplayBlockCrate.Init(event);
    	BucketEmpty.Init(event);
    	DarkRoleplayBlockChain.Init(event);
    	DarkRoleplayBlockRope.Init(event);
    	DarkRoleplayBlockChoppingBlock.Init(event);
    	BarrelEmpty.Init(event);
    	BarrelClosed.Init(event);
    	HangingBridgeOne.Init(event);
    	HangingBridgeTwo.Init(event);
    	DarkRoleplayBlockBookOne.Init(event);
    	DarkRoleplayBlockCauldron.Init(event);
    	DarkRoleplayBlockHook.Init(event);
    	DarkRoleplayBlockTrainingsDummy.Init(event);
    	ShipSteeringWheel.Init(event);
    	Target.Init(event);
    	GameRegistry.addRecipe(new ItemStack(BucketDirt.blockBucketDirt, 1), "   ", " X ", " Z ", 'X', Blocks.dirt, 'Z', BucketEmpty.blockBucketEmpty);
    	GameRegistry.addRecipe(new ItemStack(BucketFlowerOne.blockBucketFlowerOne, 1), "   ", "XX ", " Z ", 'X', new ItemStack(Blocks.red_flower, 1, 3), 'Z', BucketDirt.blockBucketDirt);
    	GameRegistry.addSmelting(new ItemStack(itemDough.itemDough, 1), new ItemStack(Items.bread, 1), 0.1F);
    	GameRegistry.registerFuelHandler(new DarkRoleplayFuelHandler());
    	
    	//Item Meshing Items
    	itemFlour.Init(event);
    	itemDough.Init(event);
    	itemFirewood.Init(event);
    	itemBatEar.Init(event);
    	
    	//food Meshing
    	DarkRoleplayFood.Init(event);
    	
        proxy.registerInitStuff();
        
        System.out.println("Dark Roleplay (version: " + DarkRoleplay.VERSION + ")loaded");  
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){ 
    	
    	//EnumMap<Side, FMLEmbeddedChannel> channels = NetworkRegistry.INSTANCE.newChannel(channel, new DarkRoleplayChannelHandler());
 
    	DarkRoleplayTabs.instance = DarkRoleplay.instance;
	    DarkRoleplayTabs.preInit(event);
	    
	    //Normal Blocks
	    blockPlaceholder.instance = DarkRoleplay.instance;
	    blockPlaceholder.preInit(event);
	    
	    //Normal Items
	    itemFlour.instance = DarkRoleplay.instance;
	    itemFlour.preInit(event);
	    
	    itemDough.instance = DarkRoleplay.instance;
	    itemDough.preInit(event);
	    
	    itemFirewood.instance = DarkRoleplay.instance;
	    itemFirewood.preInit(event);
	    
	    itemBatEar.instance = DarkRoleplay.instance;
	    itemBatEar.preInit(event);
	    
	    itemFurWolf.instance = DarkRoleplay.instance;
	    itemFurWolf.preInit(event);
	    
	    itemCoinBronze.instance = DarkRoleplay.instance;
	    itemCoinBronze.preInit(event);
	    
	    itemCoinSilver.instance = DarkRoleplay.instance;
	    itemCoinSilver.preInit(event);
	    
	    itemCoinGold.instance = DarkRoleplay.instance;
	    itemCoinGold.preInit(event);
	    
	    itemScrollTeleport.instance = DarkRoleplay.instance;
	    itemScrollTeleport.preInit(event);
	    
	    itemPurse.instance = DarkRoleplay.instance;
	    itemPurse.preInit(event);
	    
	    DarkRoleplayFood.instance = DarkRoleplay.instance;
	    DarkRoleplayFood.preInit(event);
	    //Food
	    
	    //Custom Blocks
	    DarkRoleplayBlockDungeonChest.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockDungeonChest.preInit(event);
	    
	    DarkRoleplayBlockCrate.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockCrate.preInit(event);
	    
	    DarkRoleplayBlockSmallFirepit.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockSmallFirepit.preInit(event);
	    
	    DarkRoleplayBlockLargeFirepit.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockLargeFirepit.preInit(event);

	    BucketEmpty.instance = DarkRoleplay.instance;
	    BucketEmpty.preInit(event);
	    
	    BucketDirt.instance = DarkRoleplay.instance;
	    BucketDirt.preInit(event);
	    
	    BucketFlowerOne.instance = DarkRoleplay.instance;
	    BucketFlowerOne.preInit(event);
	    
	    BarrelEmpty.instance = DarkRoleplay.instance;
	    BarrelEmpty.preInit(event);
	    
	    BarrelClosed.instance = DarkRoleplay.instance;
	    BarrelClosed.preInit(event);
	    
	    DarkRoleplayBlockChoppingBlock.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockChoppingBlock.preInit(event);
	    
	    DarkRoleplayBlockRope.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockRope.preInit(event);
	    
	    DarkRoleplayBlockCauldron.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockCauldron.preInit(event);
	    
	    DarkRoleplayBlockChain.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockChain.preInit(event);
	    
	    DarkRoleplayBlockGrindstone.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockGrindstone.preInit(event);
	    
	   HangingBridgeOne.instance = DarkRoleplay.instance;
	   HangingBridgeOne.preInit(event);
	    
	    HangingBridgeTwo.instance = DarkRoleplay.instance;
	    HangingBridgeTwo.preInit(event);
	    
	    DarkRoleplayBlockTombstoneOne.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockTombstoneOne.preInit(event);
	    
	    DarkRoleplayBlockBookOne.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockBookOne.preInit(event);
	   
	    DarkRoleplayBlockCauldronCookingOne.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockCauldronCookingOne.preInit(event);
	    
	    DarkRoleplayBlockCauldronCookingTwo.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockCauldronCookingTwo.preInit(event);
	    
	    DarkRoleplayBlockHook.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockHook.preInit(event);
	    
	    AppleHangingRed.instance = DarkRoleplay.instance;
	    AppleHangingRed.preInit(event);
	    
	    AppleStandingRed.instance = DarkRoleplay.instance;
	    AppleStandingRed.preInit(event);
	    
	    DarkRoleplayBlockPearHangingYellow.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockPearHangingYellow.preInit(event);
	    
	    DarkRoleplayBlockPearStandingYellow.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockPearStandingYellow.preInit(event);
	    
	    DarkRoleplayBlockMugEmpty.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockMugEmpty.preInit(event);
	    
	    DarkRoleplayBlockMugBeer.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockMugBeer.preInit(event);
	    
	    DarkRoleplayBlockMushroomBrown.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockMushroomBrown.preInit(event);
	    
	    DarkRoleplayBlockMushroomRed.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockMushroomRed.preInit(event);
	    		
	    DarkRoleplayBlockTrainingsDummy.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockTrainingsDummy.preInit(event);
	    
	    DarkRoleplayBlockPotionEmpty.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockPotionEmpty.preInit(event);
	    
	    DarkRoleplayBlockPotionRegenerationOne.instance = DarkRoleplay.instance;
	    DarkRoleplayBlockPotionRegenerationOne.preInit(event);
	    
	    AppleHangingGreen.instance = DarkRoleplay.instance;
	    AppleHangingGreen.preInit(event);
	    
	    AppleStandingGreen.instance = DarkRoleplay.instance;
	    AppleStandingGreen.preInit(event);
	    
	    AppleStandingYellow.instance = DarkRoleplay.instance;
	    AppleStandingYellow.preInit(event);
	    
	    AppleHangingYellow.instance = DarkRoleplay.instance;
	    AppleHangingYellow.preInit(event);
	     
	    ShipSteeringWheel.instance = DarkRoleplay.instance;
	    ShipSteeringWheel.preInit(event);
	    
	    KeyHanging.instance = DarkRoleplay.instance;
	    KeyHanging.preInit(event);
	    
	    BarrelGunPowder.instance = DarkRoleplay.instance;
	    BarrelGunPowder.preInit(event);
	    
	    BucketWater.instance = DarkRoleplay.instance;
	    BucketWater.preInit(event);
	    
	    Target.instance = DarkRoleplay.instance;
	    Target.preInit(event);
    proxy.registerRandomStuff();
    }
}
