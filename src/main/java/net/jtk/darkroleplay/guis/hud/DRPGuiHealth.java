package net.jtk.darkroleplay.guis.hud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.lwjgl.opengl.GL11;

import net.jtk.darkroleplay.main.DarkRoleplay;
import net.jtk.darkroleplay.main.Enums;
import net.jtk.darkroleplay.guis.hud.Alignment;
import net.jtk.darkroleplay.main.loadConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DRPGuiHealth extends GuiScreen{
	
	private Minecraft mc;
	/**
	 * Setting the Texture Location so that the mod knows which texturefile should be used for the Healthbar
	 */
	private static final ResourceLocation texturepath = new ResourceLocation(DarkRoleplay.MODID, "textures/guis/DarkRPGuis.png");
	String healthDisplay;

	public DRPGuiHealth(Minecraft mc)
	{
		super();
		this.mc = mc;
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderHealtheBar(RenderGameOverlayEvent event)
	{
		if(loadConfig.DRPGui == true){
			if(event.type == event.type.HEALTH){
				
				/**
				 * Creating all needed Variables
				 */
				
				int currentHealth = (int) (79 * ( mc.thePlayer.getHealth()/mc.thePlayer.getMaxHealth()));
				
				List healthBarStats = loadConfig.HealthBar;
				
				Integer Type = (Integer) healthBarStats.get(0);
				
				Enums.Enum_GuiAlignment getAlignment = (Enums.Enum_GuiAlignment) healthBarStats.get(1);
				
				Integer PosX = (Integer) healthBarStats.get(2);
				
				Integer PosY = (Integer) healthBarStats.get(3);
				
				Boolean NumericHealth = (Boolean) healthBarStats.get(4);
				
				/**
				 * Setting the Main Coordinates for the Alignment
				 */
				ArrayList coords = Alignment.getAlignment(event,getAlignment,81,9);
				
				int posX = (Integer) coords.get(0);
				int posY = (Integer) coords.get(1);
				
				//Adding the user set Coordinates of the Health bar to the Alignment Coordinates
				
				posX = posX + PosX;
				posY = posY + PosY;
				
				
				//Binding the Texture File will be made using a switch in future versions because of different Gui Types
				 
				this.mc.getTextureManager().bindTexture(texturepath);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				
				this.drawTexturedModalRect(posX, posY, 0, 16, 81, 9);
				
				
				
				//Drawing the Health and also a Potion effect that affects the Health if one is existing
				 
				this.drawTexturedModalRect(posX +1, posY +1, 0, 25, currentHealth,7);
				
				if((int)mc.thePlayer.getAbsorptionAmount() != 0){
					this.drawTexturedModalRect(posX+1, posY +1, 0, 32, currentHealth,7);
				}
				if(mc.thePlayer.isPotionActive(Potion.poison)){
					this.drawTexturedModalRect(posX+1, posY +1, 0, 39, currentHealth,7);
				}
				if(mc.thePlayer.isPotionActive(Potion.wither)){
					this.drawTexturedModalRect(posX+1, posY +1, 0, 46, currentHealth,7);
				}
				
				/**
				 * Writing the Health Amount in Numbers to the Health Bar.
				 * The bottom one is used by default the upper one is for the case that the player has additional health.
				 * (For example you get additional health when you eat an Enchanted Golden Apple)
				 */
				if(NumericHealth){
					
					if((int)mc.thePlayer.getAbsorptionAmount() > 0 ){
						healthDisplay = (int)mc.thePlayer.getHealth() + "/" +(int) mc.thePlayer.getMaxHealth() + "+" + (int) mc.thePlayer.getAbsorptionAmount();
					}else{
						healthDisplay = (int)mc.thePlayer.getHealth() + "/" +(int) mc.thePlayer.getMaxHealth();
					}
					
					this.mc.fontRendererObj.drawString(healthDisplay, posX+40 - (healthDisplay.length()*3), posY+1, 0xffFFFFFF);
				}
				/**
				 * Setting the used Texture back to Minecrafts default one (otherwise Breath bar and the other stuff would use the wrong texture File)
				 */
				this.mc.getTextureManager().bindTexture(new ResourceLocation("textures/gui/icons.png"));
				
				/**
				 * Canceling the Event so the default Health bar isn't rendered.
				 */
				event.setCanceled(true);
			}
		}
	}
	
}
