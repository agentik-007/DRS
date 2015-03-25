package net.jtk.darkroleplay.main;

import java.util.EnumMap;

import net.jtk.darkroleplay.achievements.AchievementPages;
import net.jtk.darkroleplay.blocks.blockPlaceholder;
import net.jtk.darkroleplay.blocks.AppleGreen.AppleHangingGreen;
import net.jtk.darkroleplay.blocks.AppleGreen.AppleStandingGreen;
import net.jtk.darkroleplay.blocks.AppleRed.AppleHangingRed;
import net.jtk.darkroleplay.blocks.AppleRed.AppleStandingRed;
import net.jtk.darkroleplay.blocks.AppleYellow.AppleHangingYellow;
import net.jtk.darkroleplay.blocks.AppleYellow.AppleStandingYellow;
import net.jtk.darkroleplay.blocks.Barrels.BarrelGunPowder;
import net.jtk.darkroleplay.blocks.Barrels.BarrelClosed;
import net.jtk.darkroleplay.blocks.Barrels.BarrelEmpty;
import net.jtk.darkroleplay.blocks.Books.BookOne;
import net.jtk.darkroleplay.blocks.Buckets.BucketWater;
import net.jtk.darkroleplay.blocks.Buckets.BucketDirt;
import net.jtk.darkroleplay.blocks.Buckets.BucketEmpty;
import net.jtk.darkroleplay.blocks.Buckets.BucketFlowerOne;
import net.jtk.darkroleplay.blocks.Cauldrons.Cauldron;
import net.jtk.darkroleplay.blocks.Cauldrons.CauldronCookingOne;
import net.jtk.darkroleplay.blocks.Cauldrons.CauldronCookingTwo;
import net.jtk.darkroleplay.blocks.Chain.Chain;
import net.jtk.darkroleplay.blocks.ChoppingBlock.ChoppingBlock;
import net.jtk.darkroleplay.blocks.Crate.BlockCrate;
import net.jtk.darkroleplay.blocks.DungeonChest.DungeonChest;
import net.jtk.darkroleplay.blocks.DungeonChest.TileEntityCustomDungeonChest;
import net.jtk.darkroleplay.blocks.Firepits.LargeFirepit;
import net.jtk.darkroleplay.blocks.Firepits.SmallFirepit;
import net.jtk.darkroleplay.blocks.Grindstone.Grindstone;
import net.jtk.darkroleplay.blocks.HangingBridge.HangingBridgeOne;
import net.jtk.darkroleplay.blocks.HangingBridge.HangingBridgeTwo;
import net.jtk.darkroleplay.blocks.Hook.Hook;
import net.jtk.darkroleplay.blocks.KeyHanging.KeyHanging;
import net.jtk.darkroleplay.blocks.Mugs.MugBeer;
import net.jtk.darkroleplay.blocks.Mugs.MugEmpty;
import net.jtk.darkroleplay.blocks.Mushrooms.MushroomBrown;
import net.jtk.darkroleplay.blocks.Mushrooms.MushroomRed;
import net.jtk.darkroleplay.blocks.PearYellow.PearHangingYellow;
import net.jtk.darkroleplay.blocks.PearYellow.PearStandingYellow;
import net.jtk.darkroleplay.blocks.Potions.PotionEmpty;
import net.jtk.darkroleplay.blocks.Potions.PotionRegenerationOne;
import net.jtk.darkroleplay.blocks.Rope.BlockRope;
import net.jtk.darkroleplay.blocks.ShipSteeringWheel.ShipSteeringWheel;
import net.jtk.darkroleplay.blocks.Target.Target;
import net.jtk.darkroleplay.blocks.Tombstones.TombstoneOne;
import net.jtk.darkroleplay.blocks.TrainingsDummy.TrainingsDummy;
import net.jtk.darkroleplay.events.DarkRoleplayEventHandler;
import net.jtk.darkroleplay.events.Event_PlayerInteract;
import net.jtk.darkroleplay.events.Event_PlayerPickup;
import net.jtk.darkroleplay.guis.GuiHandler;
import net.jtk.darkroleplay.handler.DarkRoleplayDropHandler;
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
    
    @SidedProxy(clientSide ="net.jtk.darkroleplay.main.ClientProxy", serverSide ="net.jtk.darkroleplay.main.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {		
    	
    	
    	AchievementPages.Load(event);
    	
    	GameRegistry.registerFuelHandler(new DarkRoleplayFuelHandler());
    	

    	MainProxy.registerCrafting(event);
    	proxy.registerEvents();	
    	proxy.bindTileEntity();
    	proxy.registerRenders();
    	
    	
    	NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
    	
        System.out.println("Dark Roleplay (version: " + DarkRoleplay.VERSION + ")loaded");  
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){ 
    	MainProxy.registerBlocks(event);
    	MainProxy.registerItems(event);
    	MainProxy.registerFood(event);
    	MainProxy.registerTileEntity(event);
    	//System.out.println(event.getSuggestedConfigurationFile()); 
	    
    }
}
