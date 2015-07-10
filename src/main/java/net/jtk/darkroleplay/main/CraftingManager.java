package net.jtk.darkroleplay.main;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class CraftingManager {

	public static ArrayList<List> Recipes = new ArrayList<List>();
	
	//public static ArrayList<> = new ArrayList<>();
	
	public static void registerRecipe(Boolean enabled,ItemStack stack1, ItemStack stack2,ItemStack stack3,ItemStack stack4,ItemStack stack5,ItemStack stack6, Integer time, ItemStack output, Block craftingStation){
		//if(enabled){
		List RecipeList = new ArrayList();
		RecipeList.add(stack1);
		RecipeList.add(stack2);
		RecipeList.add(stack3);
		RecipeList.add(stack4);
		RecipeList.add(stack5);
		RecipeList.add(stack6);
		RecipeList.add(time);
		RecipeList.add(output);
		RecipeList.add(craftingStation);
		
		Recipes.add(RecipeList);
		//}
	}
	
	public static List getRecipe(Integer ID){
		ArrayList<List> Recipe = new ArrayList<List>();
		
		if(Recipes.size()>= ID + 1){
		
			List RecipeList = Recipes.get(ID);
			return RecipeList;
		}else{
			return null;
		}
		//ItemStack,ItemStack,ItemStack,ItemStack,ItemStack,ItemStack, Integer, ItemStack, Block
		
	}
	
	public static boolean isInRangeOf(World world,EntityPlayer player, Block craftingStation){

		
		//Block block = null;
		int x = player.getPosition().getX() -5;
		int y = player.getPosition().getY() -5;
		int z = player.getPosition().getZ() -5;
		
		int currentX = player.getPosition().getX() -5;
		int currentY = player.getPosition().getY() -5;
		int currentZ = player.getPosition().getZ() -5;
		
		int targetX = player.getPosition().getX() +5;
		int targetY = player.getPosition().getY() +5;
		int targetZ = player.getPosition().getZ() +5;
		
		for(Block block = null;block != craftingStation; block = world.getBlockState(new BlockPos(currentX,currentY,currentZ)).getBlock()){
			
			BlockPos pos = new BlockPos(x,y,z);
			if(world.getBlockState(pos).getBlock() != craftingStation){
				
				if(currentX != targetX){
					currentX = currentX +1;
				}else{
					if(currentZ != targetZ){
						currentZ = currentZ+1;
					}else{
						if(currentY != targetY){
							currentY = currentY +1;
						}else{
							return false;
						}
						currentZ = z;
					}
					currentX = x;
				}
				
				block = world.getBlockState(pos).getBlock();
				
			}else{
				return true;
			}
				
		}
		
		return true;
	}


	public void craftItem(Integer id, EntityPlayer player){
		List Recipe = CraftingManager.getRecipe(id);
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
			}else if(!CraftingManager.isInRangeOf(player.worldObj, player, Station)){
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
			playerInv.addItemStackToInventory(new ItemStack(Output.getItem(), Output.stackSize));
			
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
