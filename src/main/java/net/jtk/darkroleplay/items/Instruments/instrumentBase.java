package net.jtk.darkroleplay.items.Instruments;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class instrumentBase extends Item{

	public enum instrumentType{
		HARP;
	}
	
	public instrumentType instrument;
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
		if(stack.getTagCompound() == null){
			stack.setTagCompound(new NBTTagCompound());
			
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setInteger("CurrentSong", 0);
			nbt.setInteger("CurrentNote", 0);
			nbt.setString("Player", player.getDisplayNameString());
			stack.getTagCompound().setTag("music", nbt);
			
			stack.getTagCompound();
		}else{
			if(stack.getTagCompound().hasKey("music")){
					
				NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag("music");
				String playerName = nbt.getString("Player");

				if(playerName.equals(player.getName())){
					int currentNote = nbt.getInteger("CurrentNote");
				}
				
			}
		}
		return stack;
    }
}
