package net.jtk.darkroleplay.entitys.inventory;

import net.jtk.darkroleplay.items.itemPurse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class AbstractInventory extends InventoryCustom{

	private final String name = "DRPInventory";
	
	private static final String SAVE_KEY = "DRPInvTag";
	
	public static final int INV_SIZE = 9,SLOT_AMULLET = 0, SLOT_RING_LEFT = 1, SLOT_RING_RIGHT = 2, SLOT_BELT = 3, SLOT_PURSE = 4, SLOT_BACKPACK = 5, SLOT_QUICKCAST_1 = 6, SLOT_QUICKCAST_2 = 7, SLOT_QUICKCAST_3 = 8;
	
	public AbstractInventory(){
		this.inventory = new ItemStack[INV_SIZE];
	}

	@Override
	public String getName(){
		return name;
	}
	
	@Override
	public boolean hasCustomName(){
		return true;
	}
	
	@Override
	public int getInventoryStackLimit(){
		return 1;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player){
		return true;
	}
	
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack){
		if(slot == SLOT_PURSE && stack.getItem().equals(itemPurse.itemPurse)){
			return true;
		}
		return false;
	}
	
	@Override
	protected String getNbtKey(){
		return SAVE_KEY;
	}
	
	public void copy(InventoryCustom inv){
		for (int i = 0; i < inv.getSizeInventory(); ++ i){
			ItemStack stack = inv.getStackInSlot(i);
			inventory[i] = (stack == null ? null: stack.copy());
		}
		markDirty();
	}
}
