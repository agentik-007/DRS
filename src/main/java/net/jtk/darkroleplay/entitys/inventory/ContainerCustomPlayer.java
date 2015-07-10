package net.jtk.darkroleplay.entitys.inventory;

import net.jtk.darkroleplay.items.itemPurse;
import net.jtk.darkroleplay.items.Magic.MagicItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class ContainerCustomPlayer extends Container{
	
	private final InventoryCustom inventory2;
	
	private static final int ARMOR_START = AbstractInventory.INV_SIZE, ARMOR_END = ARMOR_START+3,INV_START = ARMOR_END+1, INV_END = INV_START+26, HOTBAR_START = INV_END+1,HOTBAR_END = HOTBAR_START+8;

	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 2, 2);
    public IInventory craftResult = new InventoryCraftResult();

public ContainerCustomPlayer(EntityPlayer player, InventoryPlayer inventoryPlayer, AbstractInventory inventoryCustom){
	int i;

	//custom Slots
	addSlotToContainer(new SLOT_AMULET(inventoryCustom, 0, 116, -1));
	addSlotToContainer(new SLOT_RING(inventoryCustom, 1, 116, 17));
	addSlotToContainer(new SLOT_RING(inventoryCustom, 2, 116, 35));
	addSlotToContainer(new SLOT_BELT(inventoryCustom, 3, 116, 53));
	addSlotToContainer(new SLOT_PURSE(inventoryCustom, 4, 116, 71));
	addSlotToContainer(new SLOT_POUCH(inventoryCustom, 5, 44, 71));
	
	// Add vanilla PLAYER INVENTORY - just copied/pasted from vanilla classes
	for (i = 0; i < 3; ++i){
		for (int j = 0; j < 9; ++j){
			this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 91 + i * 18));
		}
	}
	
	// Armor Slots
		for (i = 0; i < 4; ++i){
			this.addSlotToContainer(new SLOT_ARMOR(player, inventoryPlayer, inventoryPlayer.getSizeInventory() - 1 - i, 44, -1 + i * 18, i));
		}
	
	//Hotbar
	for (i = 0; i < 9; ++i){
		this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 149));
	}
	
	inventory2 = inventoryCustom;
}

@Override
public boolean canInteractWith(EntityPlayer player){
	return true;
}

/**
* Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
* Basically the same as every other container I make, since I define the same constant indices for all of them 
*/

public ItemStack transferStackInSlot(EntityPlayer player, int par2){
	ItemStack itemstack = null;
	Slot slot = (Slot) this.inventorySlots.get(par2);
	if (slot != null && slot.getHasStack()){
		ItemStack itemstack1 = slot.getStack();
		itemstack = itemstack1.copy();
		// Either armor slot or custom item slot was clicked
		if (par2 < INV_START){
			// try to place in player inventory / action bar
			if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END + 1, true)){
				return null;
			}
			slot.onSlotChange(itemstack1, itemstack);
		}
		// Item is in inventory / hotbar, try to place either in custom or armor slots
		else{
			// if item is our custom item
			if (itemstack1.getItem().equals(itemPurse.itemPurse)){
				if (!this.mergeItemStack(itemstack1, 4, AbstractInventory.INV_SIZE, false)){
					return null;
				}
			}
			// if item is armor
			else if (itemstack1.getItem() instanceof ItemArmor){
				int type = ((ItemArmor) itemstack1.getItem()).armorType;
				if (!this.mergeItemStack(itemstack1, ARMOR_START + type, ARMOR_START + type +1, false)){
					return null;
				}
			}
			// item in player's inventory, but not in action bar
			else if (par2 >= INV_START && par2 < HOTBAR_START){
				// place in action bar
				if (!this.mergeItemStack(itemstack1, HOTBAR_START, HOTBAR_START + 1, false)){
					return null;
				}
			}
			// item in action bar - place in player inventory
			else if (par2 >= HOTBAR_START && par2 < HOTBAR_END + 1){
				if (!this.mergeItemStack(itemstack1, INV_START, INV_END + 1, false)){
					return null;
				}
			}
		}
		if (itemstack1.stackSize == 0){
			slot.putStack((ItemStack) null);
		}
		else{
			slot.onSlotChanged();
		}
		if (itemstack1.stackSize == itemstack.stackSize){
			return null;
		}
		slot.onPickupFromSlot(player, itemstack1);
	}
	return itemstack;
	}

	//IMPORTANT to override the mergeItemStack method if your inventory stack size limit is 1
	
	/**
	 * Vanilla method fails to account for stack size limits of one, resulting in only one
	 * item getting placed in the slot and the rest disappearing into thin air; vanilla
	 * method also fails to check whether stack is valid for slot
	 */
	@Override
	protected boolean mergeItemStack(ItemStack stack, int start, int end, boolean backwards)
	{
		boolean flag1 = false;
		int k = (backwards ? end - 1 : start);
		Slot slot;
		ItemStack itemstack1;

		if (stack.isStackable())
		{
			while (stack.stackSize > 0 && (!backwards && k < end || backwards && k >= start))
			{
				slot = (Slot) inventorySlots.get(k);
				itemstack1 = slot.getStack();

				if (!slot.isItemValid(stack)) {
					k += (backwards ? -1 : 1);
					continue;
				}

				if (itemstack1 != null && itemstack1.getItem() == stack.getItem() &&
						(!stack.getHasSubtypes() || stack.getItemDamage() == itemstack1.getItemDamage()) &&
						ItemStack.areItemStackTagsEqual(stack, itemstack1))
				{
					int l = itemstack1.stackSize + stack.stackSize;

					if (l <= stack.getMaxStackSize() && l <= slot.getSlotStackLimit()) {
						stack.stackSize = 0;
						itemstack1.stackSize = l;
						inventory2.markDirty();
						flag1 = true;
					} else if (itemstack1.stackSize < stack.getMaxStackSize() && l < slot.getSlotStackLimit()) {
						stack.stackSize -= stack.getMaxStackSize() - itemstack1.stackSize;
						itemstack1.stackSize = stack.getMaxStackSize();
						inventory2.markDirty();
						flag1 = true;
					}
				}

				k += (backwards ? -1 : 1);
			}
		}

		if (stack.stackSize > 0)
		{
			k = (backwards ? end - 1 : start);

			while (!backwards && k < end || backwards && k >= start) {
				slot = (Slot) inventorySlots.get(k);
				itemstack1 = slot.getStack();

				if (!slot.isItemValid(stack)) {
					k += (backwards ? -1 : 1);
					continue;
				}

				if (itemstack1 == null) {
					int l = stack.stackSize;

					if (l <= slot.getSlotStackLimit()) {
						slot.putStack(stack.copy());
						stack.stackSize = 0;
						inventory2.markDirty();
						flag1 = true;
						break;
					} else {
						putStackInSlot(k, new ItemStack(stack.getItem(), slot.getSlotStackLimit(), stack.getItemDamage()));
						stack.stackSize -= slot.getSlotStackLimit();
						inventory2.markDirty();
						flag1 = true;
					}
				}

				k += (backwards ? -1 : 1);
			}
		}

		return flag1;
	}

}
