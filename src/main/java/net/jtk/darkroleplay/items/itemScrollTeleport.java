package net.jtk.darkroleplay.items;

import java.util.List;

import net.jtk.darkroleplay.DarkRoleplayTabs;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
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

public class itemScrollTeleport extends Item{

	public static Item itemScrollTeleport;

	public static void Init(FMLInitializationEvent event) {
	}

	public static void serverLoad(FMLServerStartingEvent event) {
	}

	public static void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerItem(itemScrollTeleport, "itemScrollTeleport");
	}

	static {
		itemScrollTeleport = new itemScrollTeleport()
				.setUnlocalizedName("itemScrollTeleport")
				.setCreativeTab(DarkRoleplayTabs.drMiscTab);
	}
	public static Object instance;
	
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
		if(!(player.isSneaking())){
			if(stack.getTagCompound() == null){
				stack.setTagCompound(new NBTTagCompound());
			}else{
				if(stack.getTagCompound().hasKey("coordinates")){
					
				NBTTagCompound nbt_two = (NBTTagCompound) stack.getTagCompound().getTag("coordinates");
				int dimension = nbt_two.getInteger("Dim");
				int posX = nbt_two.getInteger("posX");
				int posY = nbt_two.getInteger("posY");
				int posZ = nbt_two.getInteger("posZ");
				float yaw = nbt_two.getFloat("yaw");
				float pitch = nbt_two.getFloat("pitch");
				
				player.setPositionAndRotation(posX, posY, posZ, yaw, pitch);
				stack.stackSize --;
				}else{
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
					
					player.addChatMessage(new ChatComponentTranslation("�5Bound to: "));
					player.addChatMessage(new ChatComponentTranslation("�5PosX: " + posX));
					player.addChatMessage(new ChatComponentTranslation("�5PosY: " + posY));
					player.addChatMessage(new ChatComponentTranslation("�5PosZ: " + posZ));
					
				}
			}
		}else{
			if(stack.getTagCompound() != null){
				stack.getTagCompound().removeTag("coordinates");
				player.addChatMessage(new ChatComponentTranslation("�4Position cleared!"));
			}
		}
        return stack;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		if(stack.getTagCompound() != null){
			if(stack.getTagCompound().hasKey("coordinates")){
		
			NBTTagCompound nbt_two = (NBTTagCompound) stack.getTagCompound().getTag("coordinates");
			int dimension = nbt_two.getInteger("Dim");
			int posX = nbt_two.getInteger("posX");
			int posY = nbt_two.getInteger("posY");
			int posZ = nbt_two.getInteger("posZ");
		
			tooltip.add("�5Bound to:");
			tooltip.add("�5Pos X: " + posX);
			tooltip.add("�5Pos Y: " + posY);
			tooltip.add("�5Pos Z: " + posZ);
			}else{
				tooltip.add("�5This Teleport Scroll isn't Bound!");
			}
		}
	}
	@Override
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
		if(stack.getTagCompound() != null)
		{
			return stack.getTagCompound().hasKey("coordinates");
		}
		
        return false;
    }

}