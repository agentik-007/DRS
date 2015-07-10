package net.jtk.darkroleplay.items.Magic;

import java.util.List;

import net.jtk.darkroleplay.entitys.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MagicItemBase extends Item{

	private int ManaUsage = 0;
	private int UsageTime = 10;
	
	public int getManaUsage(ItemStack stack){
		MagicItemBase item = (MagicItemBase) stack.getItem();
		return item.ManaUsage;
	}
	
	public int getUsageTime(ItemStack stack){
		MagicItemBase item = (MagicItemBase) stack.getItem();
		return item.UsageTime;
	}
	
	public MagicItemBase setManaUsage(int manaUsage){
        this.ManaUsage = manaUsage;
        return this;
    }
	
	public MagicItemBase setUsageTime(int UsageTime){
		this.UsageTime = UsageTime;
		return this;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {		
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));	
        return stack; 
    }
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack){
		return this.UsageTime;
    }

	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean advanced) {
		tooltip.add(EnumChatFormatting.DARK_AQUA + "Mana usage: " + this.ManaUsage);
		itemDescription(stack,player,tooltip,advanced);
	}
	
	@SideOnly(Side.CLIENT)
	public void itemDescription(ItemStack stack,EntityPlayer player, List tooltip, boolean advanced){}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BLOCK;
    }
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, EntityPlayer player)
    {
		ExtendedPlayer props = ExtendedPlayer.get(player);
		MagicItemBase item = (MagicItemBase) stack.getItem();
		props.consumeMana(item.ManaUsage);
		
		spellFinish(stack,world,player);
		return stack;
    }
	
	public ItemStack spellFinish(ItemStack stack, World world, EntityPlayer player){
		return stack;
	}
}
