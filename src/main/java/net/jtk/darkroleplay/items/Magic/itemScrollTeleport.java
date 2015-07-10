package net.jtk.darkroleplay.items.Magic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.jtk.darkroleplay.entitys.ExtendedPlayer;
import net.jtk.darkroleplay.main.DarkRoleplayTabs;
import net.jtk.darkroleplay.main.loadConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class itemScrollTeleport extends MagicItemBase{

	public static Item itemScrollTeleport;
		
	static {
		itemScrollTeleport = new itemScrollTeleport()
				.setManaUsage(0)
				.setUnlocalizedName("itemScrollTeleport")
				.setMaxDamage(2)
			    .setMaxStackSize(1)
				.setNoRepair()
				.setCreativeTab(DarkRoleplayTabs.drMiscTab);
	}
	
	@Override
	public ItemStack spellFinish(ItemStack stack, World world, EntityPlayer player){
		if(loadConfig.enableTeleportScroll)
		{
			if(!(player.isSneaking()))
			{
				if(stack.getTagCompound() == null)
				{
					stack.setTagCompound(new NBTTagCompound());
					NBTTagCompound nbt = new NBTTagCompound();
					nbt.setInteger("Dim", player.dimension);
					nbt.setInteger("posX", player.getPosition().getX());
					nbt.setInteger("posY", player.getPosition().getY());
					nbt.setInteger("posZ", player.getPosition().getZ());
					nbt.setFloat("yaw", player.rotationYaw);
					nbt.setFloat("pitch", player.rotationPitch);
					stack.getTagCompound().setTag("coordinates", nbt);
						
						
					NBTTagCompound nbt_two = (NBTTagCompound) stack.getTagCompound().getTag("coordinates");
					int dimension = nbt_two.getInteger("Dim");
					int posX = nbt_two.getInteger("posX");
					int posY = nbt_two.getInteger("posY");
					int posZ = nbt_two.getInteger("posZ");
					
					if(!world.isRemote){
						player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_PURPLE +"Bound to: "));
						player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_PURPLE +"PosX: " + posX));
						player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_PURPLE +"PosY: " + posY));
						player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_PURPLE +"PosZ: " + posZ));
					}	
				}
				else
				{
					ExtendedPlayer props = ExtendedPlayer.get(player);
					if(stack.getTagCompound().hasKey("coordinates")){			
						if( props.getCurrentMana() >= 5){
							NBTTagCompound nbt_two = (NBTTagCompound) stack.getTagCompound().getTag("coordinates");
							int dimension = nbt_two.getInteger("Dim");
							int posX = nbt_two.getInteger("posX");
							int posY = nbt_two.getInteger("posY");
							int posZ = nbt_two.getInteger("posZ");
							float yaw = nbt_two.getFloat("yaw");
							float pitch = nbt_two.getFloat("pitch");
							
							player.setPositionAndRotation(posX, posY, posZ, yaw, pitch);
							player.setCustomNameTag("Test");
							player.setWorld(world);
							stack.damageItem(1, player);
							props.consumeMana(5);
						}else{
							player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.RED +"You need more Mana!"));
						}
					}
					else
					{
						NBTTagCompound nbt = new NBTTagCompound();
						nbt.setInteger("Dim", player.dimension);
						nbt.setInteger("posX", player.getPosition().getX());
						nbt.setInteger("posY", player.getPosition().getY());
						nbt.setInteger("posZ", player.getPosition().getZ());
						nbt.setFloat("yaw", player.rotationYaw);
						nbt.setFloat("pitch", player.rotationPitch);
						stack.getTagCompound().setTag("coordinates", nbt);
							
						NBTTagCompound nbt_two = (NBTTagCompound) stack.getTagCompound().getTag("coordinates");
						int dimension = nbt_two.getInteger("Dim");
						int posX = nbt_two.getInteger("posX");
						int posY = nbt_two.getInteger("posY");
						int posZ = nbt_two.getInteger("posZ");
						if(!world.isRemote){
							player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_PURPLE +"Bound to: "));
							player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_PURPLE +"PosX: " + posX));
							player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_PURPLE +"PosY: " + posY));
							player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_PURPLE +"PosZ: " + posZ));
						}
					}
				}
			}
			else
			{
				if(stack.getTagCompound() != null){
					stack.getTagCompound().removeTag("coordinates");
					if(!world.isRemote){
						player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.DARK_RED +"Position cleared!"));
					}
				}
			}
		}
		return stack;
    }

	
	@Override
	public int getMaxItemUseDuration(ItemStack stack){
		if(stack.getTagCompound() == null)
		{
			return 32;
		}else{
			if(stack.getTagCompound().hasKey("coordinates")){
				return 64;
			}else{
				return 32;
			}
		}
    }
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack){
        return EnumAction.BLOCK;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void itemDescription(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced){	
		if(stack.getTagCompound() != null){
			if(stack.getTagCompound().hasKey("coordinates")){
		
			NBTTagCompound nbt_two = (NBTTagCompound) stack.getTagCompound().getTag("coordinates");
			int dimension = nbt_two.getInteger("Dim");
			int posX = nbt_two.getInteger("posX");
			int posY = nbt_two.getInteger("posY");
			int posZ = nbt_two.getInteger("posZ");
		
			tooltip.add(EnumChatFormatting.DARK_PURPLE +"Bound to:");
			tooltip.add(EnumChatFormatting.DARK_PURPLE +"Pos X: " + posX);
			tooltip.add(EnumChatFormatting.DARK_PURPLE +"Pos Y: " + posY);
			tooltip.add(EnumChatFormatting.DARK_PURPLE +"Pos Z: " + posZ);
			}else{
				tooltip.add(EnumChatFormatting.DARK_PURPLE +"This Teleport Scroll isn't Bound!");
			}
		}else{
			tooltip.add(EnumChatFormatting.DARK_PURPLE +"This Teleport Scroll isn't Bound!");
		}
	}
	@Override
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack){
		if(stack.getTagCompound() != null){
			return stack.getTagCompound().hasKey("coordinates");
		}
        return false;
    }

}
