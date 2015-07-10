package net.jtk.darkroleplay.entitys.inventory;

import org.lwjgl.opengl.GL11;

import ibxm.Player;
import net.jtk.darkroleplay.entitys.ExtendedPlayer;
import net.jtk.darkroleplay.main.DarkRoleplay;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GUIPlayerCustomInv  extends GuiContainer{

private float xSize_lo;
private float ySize_lo;

private int xSize = 216;
private int ySize = 180;

private static final ResourceLocation BACKGROUND = new ResourceLocation(DarkRoleplay.MODID+ ":textures/guis/GuiInventory.png");

private final InventoryCustom inventory;

private final EntityPlayer player;
	
public GUIPlayerCustomInv(EntityPlayer player, InventoryPlayer inventoryPlayer, AbstractInventory inventoryCustom){
	super(new ContainerCustomPlayer(player, inventoryPlayer, inventoryCustom));
	this.inventory = inventoryCustom;
	// if you need the player for something later on, store it in a local variable here as well
	this.player = player;
}

/**
* Draws the screen and all the components in it.
*/

public void drawScreen(int par1, int par2, float par3){
	super.drawScreen(par1, par2, par3);
	this.xSize_lo = (float)par1;
	this.ySize_lo = (float)par2;
}

/**
* Draw the foreground layer for the GuiContainer (everything in front of the items)
*/
protected void drawGuiContainerForegroundLayer(int par1, int par2){}

/**
 * Draw the background layer for the GuiContainer (everything behind the items)
 */

protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3){

	mc.renderEngine.bindTexture(BACKGROUND);
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	int k = (this.width - this.xSize) / 2;
	int l = (this.height - this.ySize) / 2;
	this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	//Helm
	if(player.inventory.getStackInSlot(39) == null){
		this.drawTexturedModalRect(k+65,l+6,217,0,16,16);
	}
	//Chestplate
	if(player.inventory.getStackInSlot(38) == null){
		this.drawTexturedModalRect(k+65,l+24,217,16,16,16);
	}
	//Pants
	if(player.inventory.getStackInSlot(37) == null){
		this.drawTexturedModalRect(k+65,l+42,217,32,16,16);
	}
	//Shoews
	if(player.inventory.getStackInSlot(36) == null){
		this.drawTexturedModalRect(k+65,l+60,217,48,16,16);
	}
	
	//Necklace
	if(ExtendedPlayer.get(player).inventory.getStackInSlot(0) == null){
		this.drawTexturedModalRect(k+137, l+6, 233, 0, 16,16);
	}
	//Ring1
	if(ExtendedPlayer.get(player).inventory.getStackInSlot(1) == null){
		this.drawTexturedModalRect(k+137, l+24, 233, 16, 16,16);
	}
	//Ring2
	if(ExtendedPlayer.get(player).inventory.getStackInSlot(2) == null){
		this.drawTexturedModalRect(k+137, l+42, 233, 16, 16,16);
	}
	//Belt
	if(ExtendedPlayer.get(player).inventory.getStackInSlot(3) == null){
		this.drawTexturedModalRect(k+137, l+60, 233, 32, 16,16);
	}
	//Purse
	if(ExtendedPlayer.get(player).inventory.getStackInSlot(4) == null){
		this.drawTexturedModalRect(k+137, l+78, 233, 48, 16,16);
	}
	//Pouch
	if(ExtendedPlayer.get(player).inventory.getStackInSlot(5) == null){
		this.drawTexturedModalRect(k+65, l+78, 217, 64, 16,16);
		int a = 0;
		int b = 0;
		for(a = 0; a < 3; a++){
			for(b = 0; b < 5; b ++){
				this.drawTexturedModalRect(k+7 + (a * 18), l+6+ (b*18), 217,112, 16, 16);
			}
		}
	}
	
	int i1;
	GuiInventory.drawEntityOnScreen(k + 108, l + 70, 30, (float)(k + 51) - this.xSize_lo, (float)(l + 75 - 50) - this.ySize_lo, this.mc.thePlayer);
}
}
