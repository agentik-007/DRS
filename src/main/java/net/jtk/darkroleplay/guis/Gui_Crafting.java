package net.jtk.darkroleplay.guis;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import net.jtk.darkroleplay.main.DarkRoleplay;
import net.jtk.darkroleplay.main.CraftingManager;
import net.jtk.darkroleplay.main.network.PacketCraft;
import net.jtk.darkroleplay.main.network.PacketHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMerchant;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class Gui_Crafting extends GuiContainer{
	public static final ResourceLocation BACKGROUND = new ResourceLocation(DarkRoleplay.MODID+ ":textures/guis/GuiCrafting.png");
	
	CraftingManager cm = new CraftingManager();
	
	EntityPlayer player = null;
	
	private Integer Page = 0;
	private int maxPages = cm.Recipes.size()/3;
	
	private int xSize = 210;
	private int ySize = 212;

	GuiButton craftingButton1; 
    GuiButton craftingButton2; 
    GuiButton craftingButton3;
    GuiButton prevButton;
    GuiButton nextButton;
	
	@Override
	public void initGui(){
		super.initGui();
        //this.mc.thePlayer.openContainer = this.inventorySlots;
		int k = (this.width - this.xSize)/2;
		int l = (this.height - this.ySize)/2;
		this.guiLeft = k + 5;
        this.guiTop = l+22;
        
        craftingButton1 = new GuiButtons.CraftingButton(0, (this.width - this.xSize)/2 + 178, (this.height - this.ySize)/2+14);   
        craftingButton2 = new GuiButtons.CraftingButton(1, (this.width - this.xSize)/2 + 178, (this.height - this.ySize)/2+49);
        craftingButton3 = new GuiButtons.CraftingButton(2, (this.width - this.xSize)/2 + 178, (this.height - this.ySize)/2+84);
        
        prevButton = new GuiButtons.PageButton(3,(this.width - this.xSize)/2 + 78,(this.height - this.ySize)/2+113 , true);
        nextButton = new GuiButtons.PageButton(4,(this.width - this.xSize)/2 + 122,(this.height - this.ySize)/2+113 , false); 
        
		buttonList.add(craftingButton1);
		buttonList.add(craftingButton2);
		buttonList.add(craftingButton3);
		buttonList.add(prevButton);
		buttonList.add(nextButton);
		craftingButton1.enabled = false;
		craftingButton2.enabled = false;
		craftingButton3.enabled = false;
		prevButton.enabled = false;
		
	}
	
	public Gui_Crafting(Container container,EntityPlayer player1) {
		super(container);
		this.player = player1;
	
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks,int mouseX, int mouseY) {

		mc.renderEngine.bindTexture(BACKGROUND);
		
		int k = (this.width - this.xSize)/2;
		int l = (this.height - this.ySize)/2;
		drawTexturedModalRect(k,l,0,0,xSize,ySize);
		
		Integer DisplayPage = this.Page +1;
		Integer maxDisplayPages = this.maxPages +1;
		String pageDisplay = DisplayPage.toString()+ "/" + maxDisplayPages.toString();
		
		this.mc.fontRendererObj.drawStringWithShadow(pageDisplay, k + 100 - ((pageDisplay.length()*3)/2), l + 116, 0xffFFFFFF);
		
		drawCrafting1(partialTicks, k, l);
		drawCrafting2(partialTicks, k, l);
		drawCrafting3(partialTicks,k,l);
		
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException{
		switch(button.id){
		case 0: 
			PacketHandler.sendToServer(new PacketCraft(Page*3));
	    	//return true;
			cm.craftItem(Page*3, player);
			break;
		case 1:
			PacketHandler.sendToServer(new PacketCraft(Page*3+1));
			cm.craftItem(Page*3+1,player);
			break;
		case 2:
			PacketHandler.sendToServer(new PacketCraft(Page*3+2));
			cm.craftItem(Page*3+2, player);
			break;
		case 3:
			if(this.Page > 0){
				this.Page -= 1;
				nextButton.enabled = true;
			}
			if(this.Page == 0){
				prevButton.enabled = false;
			}
			break;
		case 4:
			if(this.Page < this.maxPages){
				prevButton.enabled = true;
				this.Page += 1;
			}
			if(this.Page == this.maxPages){
				nextButton.enabled = false;
			}
			break;
		}
	}
 	
	private void drawCrafting1(float partialTicks,int posX, int posY){
		List Recipe = CraftingManager.getRecipe(Page * 3);
		if(Recipe != null){
				
			ItemStack stack1 = (ItemStack) Recipe.get(0);
			ItemStack stack2 = (ItemStack) Recipe.get(1);
			ItemStack stack3 = (ItemStack) Recipe.get(2);
			ItemStack stack4 = (ItemStack) Recipe.get(3);
			ItemStack stack5 = (ItemStack) Recipe.get(4);
				ItemStack stack6 = (ItemStack) Recipe.get(5);
			Integer time = (Integer) Recipe.get(6);
			ItemStack Output = (ItemStack) Recipe.get(7);
			
			if(canCraft(stack1,stack2,stack3,stack4,stack5,stack6)){
				craftingButton1.enabled = true;
			}else{
				craftingButton1.enabled = false;
			}	
		
			if(stack1 != null){
				this.drawItemStack(stack1, posX + 11, posY +16,hasItemStack(stack1));
			}
			if(stack2 != null){
				this.drawItemStack(stack2, posX + 30, posY +16,hasItemStack(stack2));		
			}
			if(stack3 != null){
				this.drawItemStack(stack3, posX + 49, posY +16,hasItemStack(stack3));
			}
			if(stack4 != null){
				this.drawItemStack(stack4, posX + 68, posY +16,hasItemStack(stack3));
			}
			if(stack5 != null){
				this.drawItemStack(stack5, posX + 87, posY +16,hasItemStack(stack5));
			}
			if(stack6 != null){
				this.drawItemStack(stack6, posX + 106,posY +16,hasItemStack(stack6));
			}
			if(Output != null){
				this.drawItemStack(Output, posX + 153,posY +16,true);
			}
			
			if(time != null){
				GlStateManager.disableLighting();
            	GlStateManager.disableDepth();
				// this.mc.fontRendererObj.drawStringWithShadow(time.toString() + "s", posX + 128, posY + 26, 0xffFFFFFF);
				GlStateManager.enableLighting();
            	GlStateManager.enableDepth();
			}
		}
	}

	private void drawCrafting2(float partialTicks,int posX, int posY){
		List Recipe = CraftingManager.getRecipe(Page * 3 + 1);
		if(Recipe != null){
				ItemStack stack1 = (ItemStack) Recipe.get(0);
				ItemStack stack2 = (ItemStack) Recipe.get(1);
				ItemStack stack3 = (ItemStack) Recipe.get(2);
				ItemStack stack4 = (ItemStack) Recipe.get(3);
				ItemStack stack5 = (ItemStack) Recipe.get(4);
				ItemStack stack6 = (ItemStack) Recipe.get(5);
				Integer time = (Integer) Recipe.get(6);
				ItemStack Output = (ItemStack) Recipe.get(7);	
		
				if(canCraft(stack1,stack2,stack3,stack4,stack5,stack6)){
					craftingButton2.enabled = true;
				}else{
					craftingButton2.enabled = false;
				}	
				
				if(stack1 != null){
						this.drawItemStack(stack1, posX + 11, posY + 51,hasItemStack(stack1));
				}
				if(stack2 != null){
					this.drawItemStack(stack2, posX + 30, posY + 51,hasItemStack(stack2));		
				}
				if(stack3 != null){
					this.drawItemStack(stack3, posX + 49, posY + 51,hasItemStack(stack3));
				}
				if(stack4 != null){
					this.drawItemStack(stack4, posX + 68, posY + 51,hasItemStack(stack4));
				}
				if(stack5 != null){
					this.drawItemStack(stack5, posX + 87, posY + 51,hasItemStack(stack5));
				}
				if(stack6 != null){
					this.drawItemStack(stack6, posX + 106,posY + 51,hasItemStack(stack6));
				}
				if(Output != null){
					this.drawItemStack(Output, posX + 153,posY + 51,true);
				}
				
				if(time != null){
					GlStateManager.disableLighting();
		        	GlStateManager.disableDepth();
					//this.mc.fontRendererObj.drawStringWithShadow(time.toString() + "s", posX + 128, posY + 61, 0xffFFFFFF);
					GlStateManager.enableLighting();
		        	GlStateManager.enableDepth();
				}
			}
		}
	private void drawCrafting3(float partialTicks,int posX, int posY){
		List Recipe = CraftingManager.getRecipe(Page * 3 + 2);
		if(Recipe != null){
				ItemStack stack1 = (ItemStack) Recipe.get(0);
				ItemStack stack2 = (ItemStack) Recipe.get(1);
				ItemStack stack3 = (ItemStack) Recipe.get(2);
				ItemStack stack4 = (ItemStack) Recipe.get(3);
				ItemStack stack5 = (ItemStack) Recipe.get(4);
				ItemStack stack6 = (ItemStack) Recipe.get(5);
				Integer time = (Integer) Recipe.get(6);
				ItemStack Output = (ItemStack) Recipe.get(7);	
		
				if(canCraft(stack1,stack2,stack3,stack4,stack5,stack6)){
					craftingButton3.enabled = true;
				}else{
					craftingButton3.enabled = false;
				}	
				
				if(stack1 != null){
						this.drawItemStack(stack1, posX + 11, posY + 86,hasItemStack(stack1));
				}
				if(stack2 != null){
					this.drawItemStack(stack2, posX + 30, posY + 86,hasItemStack(stack2));		
				}
				if(stack3 != null){
					this.drawItemStack(stack3, posX + 49, posY + 86,hasItemStack(stack3));
				}
				if(stack4 != null){
					this.drawItemStack(stack4, posX + 68, posY + 86,hasItemStack(stack4));
				}
				if(stack5 != null){
					this.drawItemStack(stack5, posX + 87, posY + 86,hasItemStack(stack5));
				}
				if(stack6 != null){
					this.drawItemStack(stack6, posX + 106,posY + 86,hasItemStack(stack6));
				}
				if(Output != null){
					this.drawItemStack(Output, posX + 153,posY + 86,true);
				}
				
				if(time != null){
					GlStateManager.disableLighting();
		        	GlStateManager.disableDepth();
					//this.mc.fontRendererObj.drawStringWithShadow(time.toString() + "s", posX + 128, posY + 61, 0xffFFFFFF);
					GlStateManager.enableLighting();
		        	GlStateManager.enableDepth();
				}
			}
		}
	
	private void drawItemStack(ItemStack stack, int x, int y, Boolean hasItem)
    {
		RenderHelper.enableGUIStandardItemLighting();
		Integer stackSize = stack.stackSize;
		String stackSizeString = stackSize.toString();
        GlStateManager.translate(0.0F, 0.0F, 32.0F);
        this.zLevel = 200.0F;
        this.itemRender.zLevel = 200.0F;
        FontRenderer font = null;
        if (stack != null) font = stack.getItem().getFontRenderer(stack);
        if (font == null) font = fontRendererObj;
        this.itemRender.renderItemAndEffectIntoGUI(stack, x, y);
        if(hasItem){
        	this.itemRender.renderItemOverlayIntoGUI(font, stack, x, y, stackSizeString);
        }else{
        	this.itemRender.renderItemOverlayIntoGUI(font, stack, x, y, EnumChatFormatting.RED + stackSizeString);
        }
        this.zLevel = 0.0F;
        this.itemRender.zLevel = 0.0F;
        RenderHelper.disableStandardItemLighting();
    }
	
	private boolean hasItemStack(ItemStack stack){
		int i;
		
		InventoryPlayer mainInventory = this.player.inventory;
		
		for (i = 0; i < mainInventory.getSizeInventory(); ++i)
        {
            if (mainInventory.getStackInSlot(i) != null && mainInventory.getStackInSlot(i).isItemEqual(stack))
            {
            	if(mainInventory.getStackInSlot(i).stackSize >= stack.stackSize){
            		return true;
            	}
            }
        }
		return false;
	}

	private boolean canCraft(ItemStack stack1, ItemStack stack2, ItemStack stack3, ItemStack stack4, ItemStack stack5, ItemStack stack6){
		InventoryPlayer mainInventory = this.player.inventory;
		
		if(stack1 != null){
			if(!hasItemStack(stack1))return false;
		}
		if(stack2 != null){
			if(!hasItemStack(stack2))return false;		
		}
		if(stack3 != null){
			if(!hasItemStack(stack3))return false;
		}
		if(stack4 != null){
			if(!hasItemStack(stack4))return false;
		}
		if(stack5 != null){
			if(!hasItemStack(stack5))return false;
		}
		if(stack6 != null){
			if(!hasItemStack(stack6))return false;
		}
		
		return true;
	}
	
	
	
}	
