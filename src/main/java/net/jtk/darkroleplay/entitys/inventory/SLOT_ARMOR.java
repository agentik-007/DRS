package net.jtk.darkroleplay.entitys.inventory;

import javax.swing.Icon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SLOT_ARMOR extends Slot{
final int armorType;
	
	final EntityPlayer player;
	
	SLOT_ARMOR(EntityPlayer player, IInventory inventory, int par3, int par4, int par5, int par6){
		super(inventory, par3, par4, par5);
		this.player = player;
		this.armorType = par6;
	}
	
	public int getSlotStackLimit(){
		return 1;
	}
	
	public boolean isItemValid(ItemStack itemstack){
		Item item = (itemstack == null ? null : itemstack.getItem());
		return item != null && item.isValidArmor(itemstack, armorType, player);
	}

}
