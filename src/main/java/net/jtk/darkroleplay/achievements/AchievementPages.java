package net.jtk.darkroleplay.achievements;

import net.jtk.darkroleplay.items.DarkRoleplayFood;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class AchievementPages {
	public static AchievementPage DarkRoleplay = new AchievementPage("Dark Roleplay");
	//static final Achievement VegieStew = new Achievement(2001, "VegieStew", 1, -2, DarkRoleplayFood.itemVegieStew, null);
	
	public static void Load(FMLInitializationEvent event){
		AchievementPage.registerAchievementPage(DarkRoleplay);
	}
}
