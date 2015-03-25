package net.jtk.darkroleplay.guis;

import java.util.List;
import java.util.Stack;

import net.jtk.darkroleplay.handler.DarkRPExtendedPlayer;
import net.jtk.darkroleplay.items.itemFurWolf;
import net.jtk.darkroleplay.items.itemPurse;
import net.jtk.darkroleplay.main.DarkRoleplay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.lwjgl.opengl.GL11;

public class MoneyGui extends GuiScreen {
	private Minecraft mc;
	private static final ResourceLocation texturepath = new ResourceLocation(DarkRoleplay.MODID, "textures/guis/DarkRPGuis.png");
	
	public MoneyGui(Minecraft mc)
	{
	super();
	this.mc = mc;
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent event)
	{
	if (event.isCancelable() || event.type != event.type.EXPERIENCE)
	{
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
	
	//WIP
	if(player.inventory.hasItem(itemPurse.itemPurse)){
		InventoryPlayer inv = player.inventory;
		ItemStack stack = inv.getStackInSlot(17);
		if(stack != null){
		if(stack.getItem().equals(itemPurse.itemPurse)){
			this.mc.getTextureManager().bindTexture(texturepath);
			
			this.drawTexturedModalRect(xPos, 2, 0, 0, 16, 16);
			this.drawTexturedModalRect(xPos, 16, 16, 0, 16, 16);
			this.drawTexturedModalRect(xPos, 30, 32, 0, 16, 16);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			GL11.glDepthMask(true);
			
			
			if(stack.getTagCompound() != null){
				if(stack.getTagCompound().hasKey("coins")){
					NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag("coins");
					Integer GoldCoins = nbt.getInteger("CoinsGold");
					Integer SilverCoins = nbt.getInteger("CoinsSilver");
					Integer BronzeCoins = nbt.getInteger("CoinsBronze");
					
					this.mc.fontRendererObj.drawStringWithShadow(GoldCoins.toString(), 20, 6, 0xffFFFFFF);
					this.mc.fontRendererObj.drawStringWithShadow(SilverCoins.toString(), 20, 20, 0xffFFFFFF);
					this.mc.fontRendererObj.drawStringWithShadow(BronzeCoins.toString(), 20, 34, 0xffFFFFFF);
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
		//}
	}
	}
}
