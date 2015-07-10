package net.jtk.darkroleplay.main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class loadConfig {
	//General
	public static boolean UpdateCheck;
	
	//Guis
	public static boolean DRPGui;
	public static int customCrosshair;

	public static List HealthBar = new ArrayList();
	public static List FoodBar = new ArrayList();
	
	public static HashMap<String, Integer> FoodBar2 = new HashMap<String,Integer>();
	//Spells Scrolls
	public static boolean enableTeleportScroll;
	public static boolean enableTeleportRune;
	
	public static boolean enableHealScroll;
	public static boolean enableHealRune;
	
	
	@EventHandler
    public static void loadConfiguration(FMLPreInitializationEvent event){ 	
		
		
	    Configuration config = new Configuration(new File("config/DarkRoleplay/GeneralConfig.cfg"));
	    Configuration configGui = new Configuration(new File("config/DarkRoleplay/GuiConfig.cfg"));
	    Configuration configCraft = new Configuration(new File("config/DarkRoleplay/CraftingConfig.cfg"));
	    Configuration configSpells = new Configuration(new File("config/DarkRoleplay/SpellConfig.cfg"));
	    
	    config.load();
	    
	    	UpdateCheck = config.get("General", "Check for Updates", false, "Disable this if you don't wan't that the Mod checks automatic for Updates").getBoolean();
	    
	    	customCrosshair = config.get("GUIS", "CustomCrosshairNumber", 0, "0 = Default Crosshair, 1 = Custom Crosshair, Dark Roleplay Crosshair (To be Added)").getInt();
	    
	   
	    config.save();
	    
	    configGui.load();
	    	/**
	    	 * A separated Config file for the GUI/HUD settings
	    	 * DRPGui just saves if the HUD should be activated or not
	    	 */
	    
	    	DRPGui = configGui.get("GUIS", "ActivadeDarkRoleplayGui", true, "Set this to False to disable all Dark Roleplay Gui Elements (Will make this config file pointless)").getBoolean();
	    	
	    	
	    	/**
	    	 * This is the place where all setting for the Health bar are loaded and saved for other methods.
	    	 */
	    	//The HealtBar Type: (Default Dark Roleplay style and possibly a few other in the Future for example skyrim?)
	    	HealthBar.add(configGui.get("HealthBar", "HealtbarType", 0, "0 = Default Dark Roleplay Gui, 1 = to be added").getInt());
	    
	    	//This code line gets the Alignment the Player has set in the Config
	    	int HealthAlignment = configGui.get("HealthBar", "HealthbarAlignment", 0, "Only for Adavnced Users! Available values: 0-8 in the following order BOTTOM,LEFT,RIGHT,TOP,CENTER,TOPLEFT,TOPRIGHT,BOTTOMLEFT,BOTTOMRIGHT").getInt();
	    	//This switch parses the integer into a Enum
	    	switch(HealthAlignment){
	    		case 0:
	    			HealthBar.add(Enums.Enum_GuiAlignment.BOTTOM);
	    			break;
	    		case 1:
	    			HealthBar.add(Enums.Enum_GuiAlignment.LEFT);
	    			break;
	    		case 2:
	    			HealthBar.add(Enums.Enum_GuiAlignment.RIGHT);
	    			break;
	    		case 3:
	    			HealthBar.add(Enums.Enum_GuiAlignment.TOP);
	    			break;
	    		case 4:
	    			HealthBar.add(Enums.Enum_GuiAlignment.CENTER);
	    			break;
	    		case 5:
	    			HealthBar.add(Enums.Enum_GuiAlignment.TOPLEFT);
	    			break;
	    		case 6:
	    			HealthBar.add(Enums.Enum_GuiAlignment.TOPRIGHT);
	    			break;
	    		case 7:
	    			HealthBar.add(Enums.Enum_GuiAlignment.BOTTOMLEFT);
	    			break;
	    		case 8:
	    			HealthBar.add(Enums.Enum_GuiAlignment.BOTTOMRIGHT);
	    			break;
	    		default:
	    			HealthBar.add(Enums.Enum_GuiAlignment.BOTTOM);
	    			break;
	    	}
	    	
	    	/**
	    	 * The following 2 lines are getting the X and Y coordinates for the Health bar.
	    	 */
	    	HealthBar.add(configGui.get("HealthBar", "HealthbarX", -51, "Only for advanced Users! Default for Bottom Alignment: -51").getInt());
	    	
	    	HealthBar.add(configGui.get("HealthBar", "HealthbarY", -30, "Only for advanced Users! Default for Bottom Alignment: -30").getInt());
	    	
	    	HealthBar.add(configGui.get("HealthBar", "NumericHealth", true,"Set this to false if you don't want the numveric display of your current Health").getBoolean());	    	
	    
	    	//Food Bar
	    	FoodBar.add(configGui.get("FoodBar", "FoodbarType", 0, "0 = Default Dark Roleplay Gui, 1 = to be added").getInt());
	    	
	    	int FoodAlignment = configGui.get("FoodBar", "FoodbarAlignment", 0, "Only for Adavnced Users! Available values: 0-8 in the following order BOTTOM,LEFT,RIGHT,TOP,CENTER,TOPLEFT,TOPRIGHT,BOTTOMLEFT,BOTTOMRIGHT").getInt();
	    	
	    	switch(FoodAlignment){
    		case 0:
    			FoodBar.add(Enums.Enum_GuiAlignment.BOTTOM);
    			break;
    		case 1:
    			FoodBar.add(Enums.Enum_GuiAlignment.LEFT);
    			break;
    		case 2:
    			FoodBar.add(Enums.Enum_GuiAlignment.RIGHT);
    			break;
    		case 3:
    			FoodBar.add(Enums.Enum_GuiAlignment.TOP);
    			break;
    		case 4:
    			FoodBar.add(Enums.Enum_GuiAlignment.CENTER);
    			break;
    		case 5:
    			FoodBar.add(Enums.Enum_GuiAlignment.TOPLEFT);
    			break;
    		case 6:
    			FoodBar.add(Enums.Enum_GuiAlignment.TOPRIGHT);
    			break;
    		case 7:
    			FoodBar.add(Enums.Enum_GuiAlignment.BOTTOMLEFT);
    			break;
    		case 8:
    			FoodBar.add(Enums.Enum_GuiAlignment.BOTTOMRIGHT);
    			break;
    		default:
    			FoodBar.add(Enums.Enum_GuiAlignment.BOTTOM);
    			break;	
    	}
	    	
	    	FoodBar.add(configGui.get("FoodBar", "FoodbarX", 50, "Only for advanced Users! Default for Bottom Alignment: 50").getInt());
	    	
	    	FoodBar.add(configGui.get("FoodBar", "FoodbarY", -30, "Only for advanced Users! Default for Bottom Alignment: -30").getInt());
	    	
	    	FoodBar.add(configGui.get("FoodBar", "NumericFood", true,"Set this to false if you don't want the numveric display of your current Food level").getBoolean());
	    	
	    configGui.save();
	    
	    configSpells.load();
	    
	    	enableTeleportScroll = configSpells.get("Scrolls","TeleportScroll", true, "Set this on true/false to enable/disable the Teleport Scroll").getBoolean();	
	    	//enableTeleportRune = configSpells.get("Runes","TeleportRune", true, "Set this on true/false to enable/disable the Teleport Rune").getBoolean();   
	    	
	    	//enableHealScroll = configSpells.get("Scrolls", "HealScroll", true, "Set this on true/false to enable/disable the Heal Scroll").getBoolean();
	    	//enableHealRune = configSpells.get("Scrolls", "HealRune", true, "Set this on true/false to enable/disable the Heal Rune").getBoolean();
	   
	    configSpells.save();
	}
}
