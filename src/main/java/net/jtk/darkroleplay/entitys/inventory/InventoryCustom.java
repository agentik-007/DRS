package net.jtk.darkroleplay.entitys.inventory;

import net.jtk.darkroleplay.items.itemPurse;
import net.jtk.darkroleplay.items.Magic.MagicItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

public abstract class InventoryCustom implements IInventory{	
	
	protected ItemStack[] inventory;
	
	@Override
	public int getSizeInventory(){
		return inventory.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int slot){
		return inventory[slot];
	}
	
	@Override
	public ItemStack decrStackSize(int slot, int amount){
		ItemStack stack = getStackInSlot(slot);
		if (stack != null){
			if (stack.stackSize > amount){
				stack = stack.splitStack(amount);
			}else{
				setInventorySlotContents(slot, null);
			}
			this.markDirty();
		}
		return stack;
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int slot){
		ItemStack stack = getStackInSlot(slot);
		if (stack != null){
			setInventorySlotContents(slot, null);
		}
		return stack;
	}
	
	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack){
		inventory[slot] = itemstack;
		if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()){
			itemstack.stackSize = getInventoryStackLimit();
		}
		markDirty();
	}
	
	@Override
	public void markDirty(){}
	
	@Override
	public void openInventory(EntityPlayer player) {}

	@Override
	public void closeInventory(EntityPlayer player) {}
	
	@Override
	public int getField(int id) {
		return 0;
	}
	
	@Override
	public void setField(int id, int value) {}
	
	@Override
	public int getFieldCount() {
		return 0;
	}
	
	@Override
	public void clear() {
		for (int i = 0; i < inventory.length; ++i) {
			inventory[i] = null;
		}
	}
	
	@Override
	public String getName() {
		return "";
	}
	
	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public IChatComponent getDisplayName() {
		return (IChatComponent)(hasCustomName() ? new ChatComponentText(getName()) : new ChatComponentTranslation(getName()));
	}

	protected abstract String getNbtKey();
	
	public void writeToNBT(NBTTagCompound compound) {
		String key = getNbtKey();
		if (key == null || key.equals("")) {
			return;
		}
		NBTTagList items = new NBTTagList();
		for (int i = 0; i < getSizeInventory(); ++i) {
			if (getStackInSlot(i) != null) {
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte) i);
				getStackInSlot(i).writeToNBT(item);
				items.appendTag(item);
			}
		}
		compound.setTag(key, items);
	}
	
	public void readFromNBT(NBTTagCompound compound) {
		String key = getNbtKey();
		if (key == null || key.equals("")) {
			return;
		}
		NBTTagList items = compound.getTagList(key, compound.getId());
		for (int i = 0; i < items.tagCount(); ++i) {
			NBTTagCompound item = items.getCompoundTagAt(i);
			byte slot = item.getByte("Slot");
			if (slot >= 0 && slot < getSizeInventory()) {
				inventory[slot] = ItemStack.loadItemStackFromNBT(item);
			}
		}
	}
}
