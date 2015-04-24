package net.jtk.darkroleplay.items;

import java.util.List;

import net.jtk.darkroleplay.main.DarkRoleplayTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class itemPurse extends Item{

	public static Object instance;
	public static Item itemPurse;
	
	static{
		itemPurse = new itemPurse()
		.setUnlocalizedName("itemPurse")
		.setMaxStackSize(1)
		.setCreativeTab(DarkRoleplayTabs.drMiscTab);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		
		if(stack.getTagCompound() != null){
			if(stack.getTagCompound().hasKey("coins"));
		
		NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag("coins");
		String player = nbt.getString("Player");
		int CoinsGold = nbt.getInteger("CoinsGold");
		int CoinsSilver = nbt.getInteger("CoinsSilver");
		int CoinsBronze = nbt.getInteger("CoinsBronze");
		
		tooltip.add(EnumChatFormatting.DARK_PURPLE +"Bound to      : " + player);
		tooltip.add(EnumChatFormatting.DARK_PURPLE +"Gold Coins    : " + CoinsGold);
		tooltip.add(EnumChatFormatting.DARK_PURPLE +"Silver Coins  : " + CoinsSilver);
		tooltip.add(EnumChatFormatting.DARK_PURPLE +"Bronze Coins: " + CoinsBronze);
		}else{
			tooltip.add(EnumChatFormatting.DARK_RED +"This purse isn't bound!");
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
		
		if(stack.getTagCompound() == null){
			stack.setTagCompound(new NBTTagCompound());
			
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setInteger("CoinsGold", 0);
			nbt.setInteger("CoinsSilver", 0);
			nbt.setInteger("CoinsBronze", 0);
			nbt.setString("Player", player.getDisplayNameString());
			stack.getTagCompound().setTag("coins", nbt);
			
			stack.getTagCompound();
		}else{
			if(stack.getTagCompound().hasKey("coins")){
				if(!world.isRemote){
					player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED +"This purse is already bound!"));
				}
			}
		}
		
		return stack;
    }
	
}
