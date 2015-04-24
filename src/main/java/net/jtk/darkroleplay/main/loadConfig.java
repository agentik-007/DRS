package net.jtk.darkroleplay.main;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class loadConfig {
	//General
	public static boolean UpdateCheck;
	
	//Guis
	public static boolean DRPGui;
	public static int customCrosshair;
		
	//Spells Scrolls
	public static boolean enableTeleportScroll;
	
	
	@EventHandler
    public static void loadConfiguration(FMLPreInitializationEvent event){ 	
		
		
	    Configuration config = new Configuration(new File("config/DarkRoleplay/GeneralConfig.cfg"));
	    Configuration configCraft = new Configuration(new File("config/DarkRoleplay/CraftingConfig.cfg"));
	    Configuration configSpells = new Configuration(new File("config/DarkRoleplay/SpellConfig.cfg"));
	    
	    config.load();
	    
	    	UpdateCheck = config.get("General", "Check for Updates", false, "Disable this if you don't wan't that the Mod checks automatic for Updates").getBoolean();
	    
	    	DRPGui = config.get("GUIS", "ActivadeDarkRoleplayGui", false, "Changes the Default Gui look to the Dark Roleplay Gui look").getBoolean();   
	    
	    	customCrosshair = config.get("GUIS", "CustomCrosshairNumber", 0, "0 = Default Crosshair, 1 = Custom Crosshair, Dark Roleplay Crosshair (To be Added)").getInt();
	    
	   
	    config.save();
	    
	    configSpells.load();
	    
	    	enableTeleportScroll = configSpells.get("Scrolls","EnableTeleportScroll", false, "Set this on true/false to enable/disable the Teleport Scroll").getBoolean();
	    
	    configSpells.save();
	}
}
