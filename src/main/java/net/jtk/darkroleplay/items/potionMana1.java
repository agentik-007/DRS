package net.jtk.darkroleplay.items;

import net.jtk.darkroleplay.entitys.ExtendedPlayer;
import net.jtk.darkroleplay.main.DarkRoleplayTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class potionMana1 extends Item{

	public static Object instance;
	
	public static Item potionMana1;
	
	static {
		potionMana1 = new potionMana1()
				.setUnlocalizedName("potionMana1")
			    .setMaxStackSize(1)
				.setNoRepair()
				.setCreativeTab(DarkRoleplayTabs.drMiscTab);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {		
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));	
        return stack; 
    }
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
    {
		return 32;
    }
	
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (!player.capabilities.isCreativeMode)
        {
            --stack.stackSize;
        }
        
        ExtendedPlayer props = ExtendedPlayer.get(player);
        
        if(props.getCurrentMana() + 5 > props.getMaxMana()){
        	props.refillMana();
        }else{
        	props.addMana(5);
        }
        
		return stack;
    }
	
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
    }
}
