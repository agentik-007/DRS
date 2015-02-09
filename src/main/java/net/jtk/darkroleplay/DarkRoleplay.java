package net.jtk.darkroleplay;

import net.jtk.darkroleplay.blocks.AppleGreen.AppleHangingGreen;
import net.jtk.darkroleplay.blocks.AppleGreen.AppleStandingGreen;
import net.jtk.darkroleplay.blocks.AppleRed.AppleHangingRed;
import net.jtk.darkroleplay.blocks.AppleRed.AppleStandingRed;
import net.jtk.darkroleplay.blocks.AppleYellow.AppleHangingYellow;
import net.jtk.darkroleplay.blocks.AppleYellow.AppleStandingYellow;
import net.jtk.darkroleplay.blocks.HangingBridge.DarkRoleplayBlockHangingBridgeOne;
import net.jtk.darkroleplay.blocks.HangingBridge.DarkRoleplayBlockHangingBridgeTwo;
import net.jtk.darkroleplay.handler.DarkRoleplayDropHandler;
import net.jtk.darkroleplay.handler.DarkRoleplayEventHandler;
import net.jtk.darkroleplay.items.DarkRoleplayFood;
import net.jtk.darkroleplay.items.itemBatEar;
import net.jtk.darkroleplay.items.itemDough;
import net.jtk.darkroleplay.items.itemFirewood;
import net.jtk.darkroleplay.items.itemFlour;
import net.jtk.darkroleplay.items.itemFurWolf;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.InstanceFactory;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = DarkRoleplay.MODID, version = DarkRoleplay.VERSION)
public class DarkRoleplay {
    public static final String MODID = "darkroleplay";
    public static final String VERSION = "0.1.3";
    
    @net.minecraftforge.fml.common.Mod.Instance(MODID)
    public static DarkRoleplay instance;
    
    @SidedProxy(clientSide ="net.jtk.darkroleplay.ClientProxy", serverSide ="net.jtk.darkroleplay.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	//Item Meshing Blocks´
    	MinecraftForge.EVENT_BUS.register(new DarkRoleplayDropHandler());
    	MinecraftForge.EVENT_BUS.register(new DarkRoleplayEventHandler());
    	blockPlaceholder.Init(event);
    	DarkRoleplayBlockPearStandingYellow.Init(event);
    	DarkRoleplayBlockPearHangingYellow.Init(event);
    	AppleStandingRed.Init(event);
    	AppleHangingRed.Init(event);
    	DarkRoleplayBlockCauldronCookingOne.Init(event);
    	DarkRoleplayBlockCrate.Init(event);
    	DarkRoleplayBlockBucketEmpty.Init(event);
    	DarkRoleplayBlockChain.Init(event);
    	DarkRoleplayBlockRope.Init(event);
    	DarkRoleplayBlockChoppingBlock.Init(event);
    	DarkRoleplayBlockBarrelEmpty.Init(event);
    	DarkRoleplayBlockBarrelClosed.Init(event);
    	DarkRoleplayBlockHangingBridgeOne.Init(event);
    	DarkRoleplayBlockHangingBridgeTwo.Init(event);
    	DarkRoleplayBlockBookOne.Init(event);
    	DarkRoleplayBlockCauldron.Init(event);
    	DarkRoleplayBlockHook.Init(event);
    	DarkRoleplayBlockTrainingsDummy.Init(event);
    	GameRegistry.addRecipe(new ItemStack(DarkRoleplayBlockBucketDirt.blockBucketDirt, 1), "   ", " X ", " Z ", 'X', Blocks.dirt, 'Z', DarkRoleplayBlockBucketEmpty.blockBucketEmpty);
    	GameRegistry.addRecipe(new ItemStack(DarkRoleplayBlockBucketFlowerOne.blockBucketFlowerOne, 1), "   ", "XX ", " Z ", 'X', new ItemStack(Blocks.red_flower, 1, 3), 'Z', DarkRoleplayBlockBucketDirt.blockBucketDirt);
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
    public void serverLoad(FMLServerStartingEvent event){
    DarkRoleplayTabs.serverLoad(event);
    
    blockPlaceholder.serverLoad(event);
    
    itemFlour.serverLoad(event);
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    DarkRoleplayTabs.instance = this.instance;
    DarkRoleplayTabs.preInit(event);
    
    //Normal Blocks
    blockPlaceholder.instance = this.instance;
    blockPlaceholder.preInit(event);
    
    //Normal Items
    itemFlour.instance = this.instance;
    itemFlour.preInit(event);
    
    itemDough.instance = this.instance;
    itemDough.preInit(event);
    
    itemFirewood.instance = this.instance;
    itemFirewood.preInit(event);
    
    itemBatEar.instance = this.instance;
    itemBatEar.preInit(event);
    
    itemFurWolf.instance = this.instance;
    itemFurWolf.preInit(event);
    
    DarkRoleplayFood.instance = this.instance;
    DarkRoleplayFood.preInit(event);
    //Food
    
    //Custom Blocks
    DarkRoleplayBlockDungeonChest.instance = this.instance;
    DarkRoleplayBlockDungeonChest.preInit(event);
    
    DarkRoleplayBlockCrate.instance = this.instance;
    DarkRoleplayBlockCrate.preInit(event);
    
    DarkRoleplayBlockSmallFirepit.instance = this.instance;
    DarkRoleplayBlockSmallFirepit.preInit(event);
    
    DarkRoleplayBlockLargeFirepit.instance = this.instance;
    DarkRoleplayBlockLargeFirepit.preInit(event);

    DarkRoleplayBlockBucketEmpty.instance = this.instance;
    DarkRoleplayBlockBucketEmpty.preInit(event);
    
    DarkRoleplayBlockBucketDirt.instance = this.instance;
    DarkRoleplayBlockBucketDirt.preInit(event);
    
    DarkRoleplayBlockBucketFlowerOne.instance = this.instance;
    DarkRoleplayBlockBucketFlowerOne.preInit(event);
    
    DarkRoleplayBlockBarrelEmpty.instance = this.instance;
    DarkRoleplayBlockBarrelEmpty.preInit(event);
    
    DarkRoleplayBlockBarrelClosed.instance = this.instance;
    DarkRoleplayBlockBarrelClosed.preInit(event);
    
    DarkRoleplayBlockChoppingBlock.instance = this.instance;
    DarkRoleplayBlockChoppingBlock.preInit(event);
    
    DarkRoleplayBlockRope.instance = this.instance;
    DarkRoleplayBlockRope.preInit(event);
    
    DarkRoleplayBlockCauldron.instance = this.instance;
    DarkRoleplayBlockCauldron.preInit(event);
    
    DarkRoleplayBlockChain.instance = this.instance;
    DarkRoleplayBlockChain.preInit(event);
    
    DarkRoleplayBlockGrindstone.instance = this.instance;
    DarkRoleplayBlockGrindstone.preInit(event);
    
   DarkRoleplayBlockHangingBridgeOne.instance = this.instance;
   DarkRoleplayBlockHangingBridgeOne.preInit(event);
    
    DarkRoleplayBlockHangingBridgeTwo.instance = this.instance;
    DarkRoleplayBlockHangingBridgeTwo.preInit(event);
    
    DarkRoleplayBlockTombstoneOne.instance = this.instance;
    DarkRoleplayBlockTombstoneOne.preInit(event);
    
    DarkRoleplayBlockBookOne.instance = this.instance;
    DarkRoleplayBlockBookOne.preInit(event);
   
    DarkRoleplayBlockCauldronCookingOne.instance = this.instance;
    DarkRoleplayBlockCauldronCookingOne.preInit(event);
    
    DarkRoleplayBlockCauldronCookingTwo.instance = this.instance;
    DarkRoleplayBlockCauldronCookingTwo.preInit(event);
    
    DarkRoleplayBlockHook.instance = this.instance;
    DarkRoleplayBlockHook.preInit(event);
    
    AppleHangingRed.instance = this.instance;
    AppleHangingRed.preInit(event);
    
    AppleStandingRed.instance = this.instance;
    AppleStandingRed.preInit(event);
    
    DarkRoleplayBlockPearHangingYellow.instance = this.instance;
    DarkRoleplayBlockPearHangingYellow.preInit(event);
    
    DarkRoleplayBlockPearStandingYellow.instance = this.instance;
    DarkRoleplayBlockPearStandingYellow.preInit(event);
    
    DarkRoleplayBlockMugEmpty.instance = this.instance;
    DarkRoleplayBlockMugEmpty.preInit(event);
    
    DarkRoleplayBlockMugBeer.instance = this.instance;
    DarkRoleplayBlockMugBeer.preInit(event);
    
    DarkRoleplayBlockMushroomBrown.instance = this.instance;
    DarkRoleplayBlockMushroomBrown.preInit(event);
    
    DarkRoleplayBlockMushroomRed.instance = this.instance;
    DarkRoleplayBlockMushroomRed.preInit(event);
    		
    DarkRoleplayBlockTrainingsDummy.instance = this.instance;
    DarkRoleplayBlockTrainingsDummy.preInit(event);
    
    DarkRoleplayBlockPotionEmpty.instance = this.instance;
    DarkRoleplayBlockPotionEmpty.preInit(event);
    
    DarkRoleplayBlockPotionRegenerationOne.instance = this.instance;
    DarkRoleplayBlockPotionRegenerationOne.preInit(event);
    
    AppleHangingGreen.instance = this.instance;
    AppleHangingGreen.preInit(event);
    
    AppleStandingGreen.instance = this.instance;
    AppleStandingGreen.preInit(event);
    
    AppleStandingYellow.instance = this.instance;
    AppleStandingYellow.preInit(event);
    
    AppleHangingYellow.instance = this.instance;
    AppleHangingYellow.preInit(event);
    
    proxy.registerRandomStuff();
    }
}
