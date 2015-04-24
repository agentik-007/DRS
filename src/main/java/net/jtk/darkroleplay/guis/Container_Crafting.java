package net.jtk.darkroleplay.guis;

import net.jtk.darkroleplay.blocks.Crate.TileEntityCustomCrate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class Container_Crafting extends Container{

	public Container_Crafting(IInventory playerInv) {
        int i = -18;
        int j; //13 128
        int k;
        int h;

        for (j = 0; j < 3; ++j){
        	for (k = 0; k < 9; ++k) {
        		this.addSlotToContainer(new Slot(playerInv, k + j * 9 + 9, 20 + k * 18, 125 + j * 18 + i));
        	}	
        }   
        for (h = 0; h < 9; ++h) {
        	this.addSlotToContainer(new Slot(playerInv, h, 20 + h * 18, 183 + i));
        }
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		
		return true;
	}
	
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
    	ItemStack itemstack = null;
    	Slot slot = (Slot)this.inventorySlots.get(index);

    	if (slot != null && slot.getHasStack()) {
    		ItemStack itemstack1 = slot.getStack();
    		itemstack = itemstack1.copy();
        
    		if (index < 27) {
    			if (!this.mergeItemStack(itemstack1, 27, this.inventorySlots.size(), true)) {
    				return null;
    			}
    		}
    		else if(!this.mergeItemStack(itemstack1, 0, 27, false)) {
    			return null;
    		}

    		if (itemstack1.stackSize == 0) {
    			slot.putStack((ItemStack)null);
    		}
    		else {
    			slot.onSlotChanged();
    		}
    	}

    	return itemstack;
    }

}
