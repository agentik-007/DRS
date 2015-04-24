package net.jtk.darkroleplay.guis;

import java.io.File;
import java.util.List;
import java.util.Stack;

import net.jtk.darkroleplay.handler.DarkRPExtendedPlayer;
import net.jtk.darkroleplay.handler.UpdateHandler;
import net.jtk.darkroleplay.items.itemFurWolf;
import net.jtk.darkroleplay.items.itemPurse;
import net.jtk.darkroleplay.main.DarkRoleplay;
import net.jtk.darkroleplay.main.loadConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.lwjgl.opengl.GL11;

public class DRPGuiTypeOne extends GuiScreen{
	private Minecraft mc;
	private static final ResourceLocation texturepath = new ResourceLocation(DarkRoleplay.MODID, "textures/guis/DarkRPGuis.png");
	String healthDisplay;
	String foodDisplay;
	
	
	public DRPGuiTypeOne(Minecraft mc)
	{
		super();
		this.mc = mc;
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent event)
	{
		
		
		
		if(loadConfig.DRPGui == true){
			if(event.type == event.type.HEALTH){
				
				int posX = event.resolution.getScaledWidth()/2 -91;
				int posY = event.resolution.getScaledHeight() -39;
				
				this.mc.getTextureManager().bindTexture(texturepath);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				this.drawTexturedModalRect(posX, posY, 0, 16, 81, 9);
				int Health = (int) (79 * ( mc.thePlayer.getHealth()/mc.thePlayer.getMaxHealth()));
				
				this.drawTexturedModalRect(posX +1, posY +1, 0, 25, Health,7);
				
				if((int)mc.thePlayer.getAbsorptionAmount() != 0){
					this.drawTexturedModalRect(posX+1, posY +1, 0, 32, Health,7);
				}
				if(mc.thePlayer.isPotionActive(Potion.poison)){
					this.drawTexturedModalRect(posX+1, posY +1, 0, 39, Health,7);
				}
				if(mc.thePlayer.isPotionActive(Potion.wither)){
					this.drawTexturedModalRect(posX+1, posY +1, 0, 46, Health,7);
				}
				
				 if((int)mc.thePlayer.getAbsorptionAmount() > 0 ){
					 healthDisplay = (int)mc.thePlayer.getHealth() + "/" +(int) mc.thePlayer.getMaxHealth() + "+" + (int) mc.thePlayer.getAbsorptionAmount();
				 }else{
					 healthDisplay = (int)mc.thePlayer.getHealth() + "/" +(int) mc.thePlayer.getMaxHealth();
				 }
				
				this.mc.fontRendererObj.drawString(healthDisplay, posX+40 - (healthDisplay.length()*3), posY+1, 0xffFFFFFF);
				
				this.mc.getTextureManager().bindTexture(new ResourceLocation("textures/gui/icons.png"));
				
				event.setCanceled(true);
			}
			if(event.type == event.type.FOOD){
				// Essen
				int posX = event.resolution.getScaledWidth()/2 +10;
				int posY = event.resolution.getScaledHeight() -39;
				
				this.mc.getTextureManager().bindTexture(texturepath);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				
				this.drawTexturedModalRect(posX, posY, 0, 53, 81,9);
				
				Integer FoodLevel = mc.thePlayer.getFoodStats().getFoodLevel();
				int Food = (int) (79* ((float)mc.thePlayer.getFoodStats().getFoodLevel() /20));
				int FoodInverted = (int) (79-Food);
				
				this.mc.fontRendererObj.drawString("", 0, 0, 0xffFFFFFF);
				
				this.drawTexturedModalRect(posX + (1+FoodInverted), posY +1, FoodInverted ,62, Food, 7);
				
				foodDisplay = (int)mc.thePlayer.getFoodStats().getFoodLevel() + "/20";
				
				this.mc.fontRendererObj.drawString(foodDisplay, (posX+41) - (foodDisplay.length()*3), posY+1, 0xffFFFFFF);
				
				
				event.setCanceled(true);
				//essen
			}
			
			if(event.type == event.type.ARMOR){
				
				int posX = event.resolution.getScaledWidth()/2 -110;
				int posY = event.resolution.getScaledHeight() -45;
				
				this.mc.getTextureManager().bindTexture(texturepath);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				
				this.drawTexturedModalRect(posX, posY, 48, 0, 16, 16);
				
				Integer ArmorValue = mc.thePlayer.getTotalArmorValue();
				
				String ArmorValueDisplay = ArmorValue.toString();
				
				this.mc.fontRendererObj.drawString(ArmorValueDisplay, posX+9 - (ArmorValueDisplay.length() * 3), posY+4, 0xff000000);
				
				this.mc.getTextureManager().bindTexture(new ResourceLocation("textures/gui/icons.png"));
				event.setCanceled(true);
			}
			
			if(event.type == event.type.EXPERIENCE){
				if(!mc.thePlayer.capabilities.isCreativeMode){
					//Mana
					int posX = event.resolution.getScaledWidth()/2 +10;
					int posY = event.resolution.getScaledHeight() -49;
				
					this.mc.getTextureManager().bindTexture(texturepath);
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				
					this.drawTexturedModalRect(posX, posY, 81, 16, 81,9);
					this.drawTexturedModalRect(posX+1,posY+1, 81,25,79,7);
					
					this.mc.fontRendererObj.drawString("W.i.P", posX+32, posY+1, 0xffFFFFFF);
				
					this.mc.getTextureManager().bindTexture(new ResourceLocation("textures/gui/icons.png"));
					//Mana
				}
			}
		}
		
		if(event.type == event.type.CROSSHAIRS){
			if(loadConfig.customCrosshair != 0){
				if(loadConfig.customCrosshair == 1){
					//ResourceLocation baum = new ResourceLocation("config/DarkRoleplay/customCrosshair.png");
					//this.mc.fontRendererObj.drawString(baum.getResourcePath() + " _ "+ texturepath.getResourceDomain() + texturepath.getResourcePath(), 32, 5, 0xffFFFFFF);
					//this.mc.getTextureManager().bindTexture(baum);
				}
				//event.setCanceled(true);
			}
		}
		
		if (event.isCancelable() || event.type != event.type.EXPERIENCE){
			return;
		}
		//DarkRPExtendedPlayer props = DarkRPExtendedPlayer.get()
		EntityPlayer player = this.mc.thePlayer;
	
	
		int xPos = 2;
		int yPos = 2;
	
		GL11.glDisable(GL11.GL_LIGHTING);

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
	
		
		if(player.inventory.hasItem(itemPurse.itemPurse)){
			InventoryPlayer inv = player.inventory;
			ItemStack stack = inv.getStackInSlot(17);
				if(stack != null){
					if(stack.getItem().equals(itemPurse.itemPurse)){
						this.mc.getTextureManager().bindTexture(texturepath);
				
						int posX = event.resolution.getScaledWidth()/2 +93;
						int posY = event.resolution.getScaledHeight() -48;
						
						this.drawTexturedModalRect(posX, posY +3, 0, 0, 16, 16);
						this.drawTexturedModalRect(posX, posY + 17, 16, 0, 16, 16);
						this.drawTexturedModalRect(posX, posY + 31, 32, 0, 16, 16);
						GL11.glEnable(GL11.GL_DEPTH_TEST);
						GL11.glDepthMask(true);
			
						if(stack.getTagCompound() != null){
							if(stack.getTagCompound().hasKey("coins")){
								NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag("coins");
								Integer GoldCoins = nbt.getInteger("CoinsGold");
								Integer SilverCoins = nbt.getInteger("CoinsSilver");
								Integer BronzeCoins = nbt.getInteger("CoinsBronze");

								this.mc.fontRendererObj.drawStringWithShadow(GoldCoins.toString(), posX+15, posY+6, 0xffFFFFFF);
								this.mc.fontRendererObj.drawStringWithShadow(SilverCoins.toString(), posX +15, posY +20, 0xffFFFFFF);
								this.mc.fontRendererObj.drawStringWithShadow(BronzeCoins.toString(), posX +15, posY +34, 0xffFFFFFF);
							}else{
								this.mc.fontRendererObj.drawStringWithShadow("0", 20, 6,  0xffFFFFFF);
								this.mc.fontRendererObj.drawStringWithShadow("0", 20, 20, 0xffFFFFFF);
								this.mc.fontRendererObj.drawStringWithShadow("0", 20, 34, 0xffFFFFFF);
							}
						}else{
							this.mc.fontRendererObj.drawStringWithShadow("0", 20, 6,  0xffFFFFFF);
							this.mc.fontRendererObj.drawStringWithShadow("0", 20, 20, 0xffFFFFFF);
							this.mc.fontRendererObj.drawStringWithShadow("0", 20, 34, 0xffFFFFFF);
						}
					}
				}
			}
		if(!mc.thePlayer.capabilities.isCreativeMode){
			int posX = event.resolution.getScaledWidth()/2 +10;
			int posY = event.resolution.getScaledHeight() -48;
		}
	}
}
