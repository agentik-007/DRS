package net.jtk.darkroleplay.guis;

import java.io.IOException;

import net.jtk.darkroleplay.events.DarkRoleplayEventHandler;
import net.jtk.darkroleplay.handler.UpdateHandler;
import net.jtk.darkroleplay.main.DarkRoleplay;
import net.jtk.darkroleplay.main.loadConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DRPGuiVersion extends GuiScreen{
	
	private Minecraft mc;
	
	public DRPGuiVersion(Minecraft mc)
	{
		super();
		this.mc = mc;
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void GuiRender(RenderGameOverlayEvent event)
	{
		//if(loadConfig.UpdateCheck == true){
			//if(event.type == event.type.EXPERIENCE){
		
				int posX = event.resolution.getScaledWidth()/2;
				int posY = event.resolution.getScaledHeight();
				String MessageOne = "The Dark Roleplay Version you use is Outdated!";
		
				if(!DarkRoleplay.Version.equals(UpdateHandler.Version)){
					this.mc.fontRendererObj.drawStringWithShadow(MessageOne, posX-5, posY+10, 0xffFFFFFF);
				}
			//}
		//}
		this.mc.getTextureManager().bindTexture(new ResourceLocation("textures/gui/icons.png"));
	}
	
}
