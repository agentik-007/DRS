package net.jtk.darkroleplay.guis;

import net.jtk.darkroleplay.main.DarkRoleplay;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiCrate extends GuiContainer{
public static final ResourceLocation BACKGROUND = new ResourceLocation(DarkRoleplay.MODID+ ":textures/guis/GuiCrate.png");
	
	public GuiCrate(Container container_) {
		super(container_);
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks,int mouseX, int mouseY) {

		mc.renderEngine.bindTexture(BACKGROUND);
		
		int k = (this.width - this.xSize)/2;
		int l = (this.height - this.ySize)/2;
		drawTexturedModalRect(k,l,0,0,xSize,ySize);
		
	}
}
