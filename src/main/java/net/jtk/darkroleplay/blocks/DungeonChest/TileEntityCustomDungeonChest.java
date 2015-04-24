package net.jtk.darkroleplay.blocks.DungeonChest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCustomDungeonChest extends TileEntity {

	public InventoryBasic inventory;
	
	public TileEntityCustomDungeonChest(){
		inventory = new InventoryBasic("DungeonChestInventory", false, 15);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		
		NBTTagList list = new NBTTagList();
		
		for(int i = 0;i < inventory.getSizeInventory();i++){
			if(inventory.getStackInSlot(i) != null){
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte)i);
				inventory.getStackInSlot(i).writeToNBT(tag);
				list.appendTag(tag);
			}
		}
		
		compound.setTag("ItemStacks", list);
		
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		
		NBTTagList list = compound.getTagList("ItemStacks", 10);
		this.inventory = new InventoryBasic("DungeonChestInventory",false,15);
		for(int i = 0; i < list.tagCount(); i++){
			NBTTagCompound tag = list.getCompoundTagAt(i);
			byte b = tag.getByte("Slot");
			
			if(b >= 0 && b < inventory.getSizeInventory()){
				inventory.setInventorySlotContents(b, ItemStack.loadItemStackFromNBT(tag));
			}
		}
	}
}
