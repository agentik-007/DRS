package net.jtk.darkroleplay.guis.hud;

import java.util.ArrayList;
import java.util.List;

import net.jtk.darkroleplay.main.DarkRoleplay;
import net.jtk.darkroleplay.main.Enums;
import net.jtk.darkroleplay.main.loadConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.lwjgl.opengl.GL11;

public class DRPGuiFood extends GuiScreen{

	private Minecraft mc;
	/**
	 * Setting the Texture Location so that the mod knows which texturefile should be used for the Healthbar
	 */
	private static final ResourceLocation texturepath = new ResourceLocation(DarkRoleplay.MODID, "textures/guis/DarkRPGuis.png");
	String foodDisplay;
	
	
	public DRPGuiFood(Minecraft mc)
	{
		super();
		this.mc = mc;
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderHealtheBar(RenderGameOverlayEvent event)
	{
		if(loadConfig.DRPGui){
			if(event.type == event.type.FOOD){
		
				int currentFood = (int) (79 * ((float) mc.thePlayer.getFoodStats().getFoodLevel()/20));
				
				List foodBarStats = loadConfig.FoodBar;
				
				Integer Type = (Integer) foodBarStats.get(0);
				
				Enums.Enum_GuiAlignment getAlignment = (Enums.Enum_GuiAlignment) foodBarStats.get(1);
				
				Integer PosX = (Integer) foodBarStats.get(2);
				
				Integer PosY = (Integer) foodBarStats.get(3);
				
				Boolean NumericFood = (Boolean) foodBarStats.get(4);
				
				ArrayList coords = Alignment.getAlignment(event,getAlignment,81,9);
				
				int posX = (Integer) coords.get(0);
				int posY = (Integer) coords.get(1);
				
				posX = posX + PosX;
				posY = posY + PosY;
			
				this.mc.getTextureManager().bindTexture(texturepath);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				
				this.drawTexturedModalRect(posX, posY, 0, 53, 81,9);
			
				Integer FoodLevel = mc.thePlayer.getFoodStats().getFoodLevel();
				int Food = (int) (79* ((float)mc.thePlayer.getFoodStats().getFoodLevel() /20));
				int FoodInverted = (int) (79-Food);
				
				
				
				this.mc.fontRendererObj.drawString("", 0, 0, 0xffFFFFFF);
				
				this.drawTexturedModalRect(posX + (1+FoodInverted), posY +1, FoodInverted ,62, Food, 7);
			
				if(mc.thePlayer.isPotionActive(Potion.hunger)){
					this.drawTexturedModalRect(posX+ (1+FoodInverted), posY +1, FoodInverted, 39, currentFood,7);
				}
				
				
				if(NumericFood){
					foodDisplay = (int)mc.thePlayer.getFoodStats().getFoodLevel() + "/20";
					this.mc.fontRendererObj.drawString(foodDisplay, (posX+41) - (foodDisplay.length()*3), posY+1, 0xffFFFFFF);
				}
			
				event.setCanceled(true);
			}
		}
	}
}
