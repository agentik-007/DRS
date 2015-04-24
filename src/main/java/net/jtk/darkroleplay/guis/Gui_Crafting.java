package net.jtk.darkroleplay.guis;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import net.jtk.darkroleplay.main.DarkRoleplay;
import net.jtk.darkroleplay.main.CraftingManager;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
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
	
	private int Page = 0;
	private int maxPages = 5;
	
	private int xSize = 210;
	private int ySize = 211;

	@Override
	public void initGui(){
		super.initGui();
        //this.mc.thePlayer.openContainer = this.inventorySlots;
		int k = (this.width - this.xSize)/2;
		int l = (this.height - this.ySize)/2;
		this.guiLeft = k + 5;
        this.guiTop = l+22;
		buttonList.add(new GuiButton(0, (this.width - this.xSize)/2 + 178, (this.height - this.ySize)/2+14, 20, 20, null));
		buttonList.add(new GuiButton(1, (this.width - this.xSize)/2 + 178, (this.height - this.ySize)/2+49, 20, 20, null));
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
		
		drawCrafting1(partialTicks, k, l);
		drawCrafting2(partialTicks, k, l);
		
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException{
		switch(button.id){
		case 0: 
			cm.craftItem(Page*3, player);
			break;
		case 1:
			cm.craftItem(Page*3 + 1, player);
		case 2:
			//craftItem(Page*3+2);
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
			Block Station = (Block) Recipe.get(8);
		
		
		
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
				this.drawItemStack(stack4, posX + 68, posY +16,hasItemStack(stack4));
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
		
			if(Station != null){
				this.drawStation(Station,posX + 128, posY +16);
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
				Block Station = (Block) Recipe.get(8);
		
		
		
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
		
			if(Station != null){
				this.drawStation(Station,posX + 128, posY + 51);
			}
		}
	}
	private void drawCrafting3(float partialTicks,int posX, int posY){
		List RecipeOne = CraftingManager.getRecipe(0);
		ItemStack stack1 = (ItemStack) RecipeOne.get(0);
		ItemStack stack2 = (ItemStack) RecipeOne.get(1);
		ItemStack stack3 = (ItemStack) RecipeOne.get(2);
		ItemStack stack4 = (ItemStack) RecipeOne.get(3);
		ItemStack stack5 = (ItemStack) RecipeOne.get(4);
		ItemStack stack6 = (ItemStack) RecipeOne.get(5);
		Integer time = (Integer) RecipeOne.get(6);
		ItemStack Output = (ItemStack) RecipeOne.get(7);
		Block Station = (Block) RecipeOne.get(8);
		
		
		
		if(stack1 != null){
		this.drawItemStack(stack1, posX + 11, posY +16,true);
		}
		if(stack2 != null){
		this.drawItemStack(stack2, posX + 30, posY +16,false);
		}
		if(stack3 != null){
		this.drawItemStack(stack3, posX + 49, posY +16,true);
		}
		if(stack4 != null){
		this.drawItemStack(stack4, posX + 68, posY +16,true);
		}
		if(stack5 != null){
		this.drawItemStack(stack5, posX + 87, posY +16,true);
		}
		if(stack6 != null){
		this.drawItemStack(stack6, posX + 106,posY +16,true);
		}
		if(Output != null){
		this.drawItemStack(Output, posX + 153,posY +16,true);
		}
		
		if(Station != null){
			this.drawStation(Station,posX + 128, posY +10);
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
	private void drawStation(Block block, int x, int y)
    {
		RenderHelper.enableGUIStandardItemLighting();
		ItemStack stack = new ItemStack(block,1);
		GlStateManager.translate(0.0F, 0.0F, 32.0F);
        this.zLevel = 200.0F;
        this.itemRender.zLevel = 200.0F;
        FontRenderer font = null;
        if (stack != null) font = stack.getItem().getFontRenderer(stack);
        if (font == null) font = fontRendererObj;
        this.itemRender.renderItemAndEffectIntoGUI(stack, x, y);
       if(CraftingManager.isInRangeOf(player.worldObj, player, block)){
        	this.itemRender.renderItemOverlayIntoGUI(font, stack, x, y, "");
       }else{
       		this.itemRender.renderItemOverlayIntoGUI(font, stack, x, y, EnumChatFormatting.RED + "X");
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
	
}