package net.jtk.darkroleplay.guis;

import net.jtk.darkroleplay.blocks.Crate.TileEntityCustomCrate;
import net.jtk.darkroleplay.blocks.DungeonChest.TileEntityCustomDungeonChest;
import net.jtk.darkroleplay.entitys.ExtendedPlayer;
import net.jtk.darkroleplay.entitys.inventory.ContainerCustomPlayer;
import net.jtk.darkroleplay.entitys.inventory.GUIPlayerCustomInv;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	public static final int GUI_INVENTORY = 3;
	public static final int GUI_DUNGEONCHEST = 0;
	public static final int GUI_CRATE = 1;
	public static final int GUI_CRAFTING = 2;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,int x, int y, int z) {
		switch(ID){
			case GUI_DUNGEONCHEST:
				return new Container_DungeonChest(player.inventory,(TileEntityCustomDungeonChest) world.getTileEntity(new BlockPos(x,y,z)));
			case GUI_CRATE:
				return new Container_Crate(player.inventory,(TileEntityCustomCrate) world.getTileEntity(new BlockPos(x,y,z)));
			case GUI_CRAFTING:
				return new Container_Crafting(player.inventory);
			case GUI_INVENTORY:
				return new ContainerCustomPlayer(player,player.inventory,ExtendedPlayer.get(player).inventory);
			default: 
				return null;
		}	
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		switch(ID){
		case GUI_DUNGEONCHEST:
			return new Gui_DungeonChest(new Container_DungeonChest(player.inventory,(TileEntityCustomDungeonChest) world.getTileEntity(new BlockPos(x,y,z))));
		case GUI_CRATE:
			return new Gui_Crate(new Container_Crate(player.inventory,(TileEntityCustomCrate) world.getTileEntity(new BlockPos(x,y,z))));
		case GUI_CRAFTING:
			return new Gui_Crafting(new Container_Crafting(player.inventory), player);
		case GUI_INVENTORY:
			return new GUIPlayerCustomInv(player, player.inventory, ExtendedPlayer.get(player).inventory);
		default: 
			return null;
	}
	}

}
