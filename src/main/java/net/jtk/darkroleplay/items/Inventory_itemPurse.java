package net.jtk.darkroleplay.items;

import net.jtk.darkroleplay.entitys.ExtendedPlayer;
import net.jtk.darkroleplay.entitys.inventory.InventoryCustom;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Inventory_itemPurse extends InventoryCustom{
	private String name = "Purse";

	/** The key used to store and retrieve the inventory from NBT */
	private static final String SAVE_KEY = "PurseInv";

	/** Defining your inventory size this way is handy */
	public static final int INV_SIZE = 3;

	/** Provides NBT Tag Compound to reference */
	private final ItemStack invStack;

	public Inventory_itemPurse(ItemStack stack) {
		inventory = new ItemStack[INV_SIZE];
		this.invStack = stack;
		if (!invStack.hasTagCompound()) {
			invStack.setTagCompound(new NBTTagCompound());
		}
		readFromNBT(invStack.getTagCompound());
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean hasCustomName() {
		return name.length() > 0;
	}

	@Override
	public int getInventoryStackLimit() {
		return 100;
	}

	/**
	 * For inventories stored in ItemStacks, it is critical to implement this method
	 * in order to write the inventory to the ItemStack's NBT whenever it changes.
	 */
	@Override
	public void markDirty() {
		for (int i = 0; i < getSizeInventory(); ++i) {
			if (getStackInSlot(i) != null && getStackInSlot(i).stackSize == 0)
				inventory[i] = null;
		}
		writeToNBT(invStack.getTagCompound());
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		// this will close the inventory if the player tries to move
		// the item that opened it, but you need to return this method
		// from the Container's canInteractWith method
		// an alternative would be to override the slotClick method and
		// prevent the current item slot from being clicked
		
		return ExtendedPlayer.get(player).inventory.getStackInSlot(4).getItem().equals(itemPurse.itemPurse);
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return (stack.getItem().equals(itemCoinGold.itemCoinGold) || stack.getItem().equals(itemCoinSilver.itemCoinSilver) || stack.getItem().equals(itemCoinBronze.itemCoinBronze));
	}

	@Override
	protected String getNbtKey() {
		return SAVE_KEY;
	}
}
