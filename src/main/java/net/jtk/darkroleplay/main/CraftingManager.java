package net.jtk.darkroleplay.main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import net.jtk.darkroleplay.blocks.Barrels.BarrelEmpty;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;

public class CraftingManager {

	public static HashMap Recipes = new HashMap<Block,ArrayList<List>>();
	
	public static void registerRecipe(ItemStack stack1, ItemStack stack2,ItemStack stack3,ItemStack stack4,ItemStack stack5,ItemStack stack6, ItemStack output, Block craftingStation){

		ArrayList RecipeMain;
		
		if(craftingStation == null){
			craftingStation = Blocks.air;
		}
		
		if(Recipes.containsKey(craftingStation)){
			RecipeMain = (ArrayList) Recipes.get(craftingStation);
		}else{
			RecipeMain = new ArrayList<ArrayList>();
		}
		ArrayList Recipe = new ArrayList<ItemStack>();
		
		Recipe.add(output);
		Recipe.add(stack1);
		Recipe.add(stack2);
		Recipe.add(stack3);
		Recipe.add(stack4);
		Recipe.add(stack5);
		Recipe.add(stack6);
		
		Boolean enabled;
		
		Configuration config = new Configuration(new File("config/DarkRoleplay/CraftingConfig.cfg"));
		config.load();
		if(craftingStation != Blocks.air){
			enabled = config.get("Crafting Station: " + craftingStation.getUnlocalizedName().toString().substring(craftingStation.getUnlocalizedName().toString().indexOf(".") +1,craftingStation.getUnlocalizedName().toString().length()), output.getUnlocalizedName().toString().substring(output.getUnlocalizedName().toString().indexOf(".") +1,output.getUnlocalizedName().toString().length()), true).getBoolean();
		}else{
			enabled = config.get("Can be crafted in Hand", output.getUnlocalizedName().toString().substring(output.getUnlocalizedName().toString().indexOf(".") +1,output.getUnlocalizedName().toString().length()), true).getBoolean();
		}
		config.save();
		
		Recipe.add(enabled);
		
		RecipeMain.add(Recipe);
		
		if(Recipes.containsKey(craftingStation)){
			Recipes.replace(craftingStation, RecipeMain);
		}else{
			Recipes.put(craftingStation, RecipeMain);
		}
		
		
	}
	
	public static List getRecipe(Block craftingStation, int Output){

		if(Recipes.containsKey(craftingStation)){
			ArrayList RecipeStation = (ArrayList) Recipes.get(craftingStation);
			if(RecipeStation.size() > Output){
			ArrayList Recipe = (ArrayList) RecipeStation.get(Output);
			return Recipe;
			}else{
				return null;
			}
		}else{
			return null;
		}
		//ItemStack,ItemStack,ItemStack,ItemStack,ItemStack,ItemStack, Output, enabled
		
	}

	public void craftItem(int stationID, int itemID, EntityPlayer player){	
		Block craftingStation = Block.getBlockById(stationID);
		
		ArrayList itemList = (ArrayList)Recipes.get(craftingStation);
		
		
		List Recipe = (List) itemList.get(itemID);
		
		if(Recipe != null){
			ItemStack Output = (ItemStack) Recipe.get(0);
			ItemStack stack1 = (ItemStack) Recipe.get(1);
			ItemStack stack2 = (ItemStack) Recipe.get(2);
			ItemStack stack3 = (ItemStack) Recipe.get(3);
			ItemStack stack4 = (ItemStack) Recipe.get(4);
			ItemStack stack5 = (ItemStack) Recipe.get(5);
			ItemStack stack6 = (ItemStack) Recipe.get(6);
			Boolean enabled = (Boolean) Recipe.get(7);
				
			if(!enabled){
				player.addChatMessage(new ChatComponentTranslation("This crafting Recipe has been Disabled!"));
				return;
			}
			
			if(stack1 != null && !hasItemStack(stack1, player)){
				return;
			}else if(stack2 != null && !hasItemStack(stack2, player)){
				return;
			}else if(stack3 != null && !hasItemStack(stack3, player)){
				return;
			}else if(stack4 != null && !hasItemStack(stack4, player)){
				return;
			}else if(stack5 != null && !hasItemStack(stack5, player)){
				return;
			}else if(stack6 != null && !hasItemStack(stack6, player)){
				return;
			}
				
			InventoryPlayer playerInv = player.inventory;
				
			int i;
			if(stack1 != null){
				for (i = 0; i < stack1.stackSize; ++i){
					playerInv.consumeInventoryItem(stack1.getItem());
				}
			}
			if(stack2 != null){
				for (i = 0; i < stack2.stackSize; ++i){
					playerInv.consumeInventoryItem(stack2.getItem());
				}
			}
			if(stack3 != null){
				for (i = 0; i < stack3.stackSize; ++i){
					playerInv.consumeInventoryItem(stack3.getItem());
				}
			}
			if(stack4 != null){
				for (i = 0; i < stack4.stackSize; ++i){
					playerInv.consumeInventoryItem(stack4.getItem());
				}
			}
			if(stack5 != null){
				for (i = 0; i < stack5.stackSize; ++i){
					playerInv.consumeInventoryItem(stack5.getItem());
				}
			}
			if(stack6 != null){
				for (i = 0; i < stack6.stackSize; ++i){
					playerInv.consumeInventoryItem(stack6.getItem());
				}
			}
			player.worldObj.spawnEntityInWorld(new EntityItem(player.worldObj, player.posX, player.posY, player.posZ, new ItemStack(Output.getItem(), Output.stackSize)));
		}
	}
	public void craftItemClient(int stationID, int itemID, EntityPlayer player){	
		Block craftingStation = Block.getBlockById(stationID);
		
		ArrayList itemList = (ArrayList)Recipes.get(craftingStation);
		
		
		List Recipe = (List) itemList.get(itemID);
		
		if(Recipe != null){
			ItemStack Output = (ItemStack) Recipe.get(0);
			ItemStack stack1 = (ItemStack) Recipe.get(1);
			ItemStack stack2 = (ItemStack) Recipe.get(2);
			ItemStack stack3 = (ItemStack) Recipe.get(3);
			ItemStack stack4 = (ItemStack) Recipe.get(4);
			ItemStack stack5 = (ItemStack) Recipe.get(5);
			ItemStack stack6 = (ItemStack) Recipe.get(6);
			Boolean enabled = (Boolean) Recipe.get(7);
				
			if(!enabled){
				player.addChatMessage(new ChatComponentTranslation("This crafting Recipe has been Disabled!"));
				return;
			}
			
			if(stack1 != null && !hasItemStack(stack1, player)){
				return;
			}else if(stack2 != null && !hasItemStack(stack2, player)){
				return;
			}else if(stack3 != null && !hasItemStack(stack3, player)){
				return;
			}else if(stack4 != null && !hasItemStack(stack4, player)){
				return;
			}else if(stack5 != null && !hasItemStack(stack5, player)){
				return;
			}else if(stack6 != null && !hasItemStack(stack6, player)){
				return;
			}
				
			InventoryPlayer playerInv = player.inventory;
				
			int i;
			if(stack1 != null){
				for (i = 0; i < stack1.stackSize; ++i){
					playerInv.consumeInventoryItem(stack1.getItem());
				}
			}
			if(stack2 != null){
				for (i = 0; i < stack2.stackSize; ++i){
					playerInv.consumeInventoryItem(stack2.getItem());
				}
			}
			if(stack3 != null){
				for (i = 0; i < stack3.stackSize; ++i){
					playerInv.consumeInventoryItem(stack3.getItem());
				}
			}
			if(stack4 != null){
				for (i = 0; i < stack4.stackSize; ++i){
					playerInv.consumeInventoryItem(stack4.getItem());
				}
			}
			if(stack5 != null){
				for (i = 0; i < stack5.stackSize; ++i){
					playerInv.consumeInventoryItem(stack5.getItem());
				}
			}
			if(stack6 != null){
				for (i = 0; i < stack6.stackSize; ++i){
					playerInv.consumeInventoryItem(stack6.getItem());
				}
			}
		}
	}
	private boolean hasItemStack(ItemStack stack, EntityPlayer player){
		int i;
		
		InventoryPlayer mainInventory = player.inventory;
		
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
