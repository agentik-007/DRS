package net.jtk.darkroleplay.blocks.Crate;

import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;


public class TileEntityCustomCrate extends TileEntity{
	public InventoryBasic inventory;
	
	public TileEntityCustomCrate(){
		inventory = new InventoryBasic("CrateInventory", false, 9);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		
		NBTTagList list = new NBTTagList();
		
		for(int i = 0;i < inventory.getSizeInventory();i++){
			if(inventory.getStackInSlot(i) != null){
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte)i);
				inventory.getStackInSlot(i).writeToNBT(tag);
				list.appendTag(tag);
			}
		}
		
		nbt.setTag("ItemStacks", list);
		
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		
		NBTTagList list = nbt.getTagList("ItemStacks", 10);
		this.inventory = new InventoryBasic("CrateInventory",false,9);
		for(int i = 0; i < list.tagCount(); i++){
			NBTTagCompound tag = list.getCompoundTagAt(i);
			byte b = tag.getByte("Slot");
			
			if(b >= 0 && b < inventory.getSizeInventory()){
				inventory.setInventorySlotContents(b, ItemStack.loadItemStackFromNBT(tag));
			}
		}
	}
	
	
}