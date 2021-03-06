package net.jtk.darkroleplay.guis;

import net.jtk.darkroleplay.blocks.Crate.TileEntityCustomCrate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class Container_Crate extends Container{
	public Container_Crate(IInventory playerInv, TileEntityCustomCrate Crate) {
        int i = -18;
        int j;
        int k;
       
        int index = 0;
        for (j = 0; j < 3; ++j) {
        	for (k = 0; k < 3; ++k) {
        		this.addSlotToContainer(new Slot(Crate.inventory, index++, 62 + k * 18, 17 + j * 18));
        	}
        }

        for (j = 0; j < 3; ++j){
        	for (k = 0; k < 9; ++k) {
        		this.addSlotToContainer(new Slot(playerInv, k + j * 9 + 9, 8 + k * 18, 102 + j * 18 + i));
        	}
        }

        for (j = 0; j < 9; ++j) {
        	this.addSlotToContainer(new Slot(playerInv, j, 8 + j * 18, 160 + i));
        }
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
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
