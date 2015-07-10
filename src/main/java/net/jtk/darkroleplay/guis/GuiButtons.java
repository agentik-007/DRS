package net.jtk.darkroleplay.guis;

import net.jtk.darkroleplay.main.DarkRoleplay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiButtons {
	
	static class PageButton extends GuiButton{
		
		boolean dir;
		
		public PageButton(int buttonID , int x,int y, boolean dir){
			super(buttonID,x,y, "");
			this.dir = dir;
			this.width = 10;
			this.height = 15;
		}
		 public void drawButton(Minecraft mc, int mouseX, int mouseY)
	     {
			 if(this.visible){
				 mc.getTextureManager().bindTexture(new ResourceLocation(DarkRoleplay.MODID+ ":textures/guis/GuiCrafting.png"));
				 GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
				 boolean flag = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + 10 && mouseY < this.yPosition + 15;
				 int k = 60;
				 int l = 210;
				 
				 if(!this.dir){
					 l += 10;
				 }
				 
				 if(!this.enabled){
						 k += 30;
				 }
				 else if(flag)
				 {
						 k += 15;
				 }
				 
				 this.drawTexturedModalRect(this.xPosition, this.yPosition, l, k, 10,15);
			 }
	     }
	}
	
	static class CraftingButton extends GuiButton{
		
		//public final Boolean Clickable;
		
		public CraftingButton(int buttonId, int x, int y) {
			super(buttonId, x, y, "");
			this.width = 20;
			this.height = 20;
		}
			
		 public void drawButton(Minecraft mc, int mouseX, int mouseY)
	     {
	         if(this.visible){
	             mc.getTextureManager().bindTexture(new ResourceLocation(DarkRoleplay.MODID+ ":textures/guis/GuiCrafting.png"));
	             GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	             boolean flag = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + 20 && mouseY < this.yPosition + 20;
	             int k = 0;
	             int l = 210;

	             if (!this.enabled)
	             {
	                 k += 40;
	             }
	             else if (flag)
	             {
	            	 k += 20;
	             }

	             this.drawTexturedModalRect(this.xPosition, this.yPosition, l, k, 20, 20);
	         
	         }
	     }
	}
}