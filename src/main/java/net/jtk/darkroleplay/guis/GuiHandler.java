package net.jtk.darkroleplay.guis;

import net.jtk.darkroleplay.blocks.Crate.TileEntityCustomCrate;
import net.jtk.darkroleplay.blocks.DungeonChest.TileEntityCustomDungeonChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	public static final int GUI_DUNGEONCHEST = 0;
	public static final int GUI_CRATE = 1;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,int x, int y, int z) {
		switch(ID){
			case GUI_DUNGEONCHEST:
				return new ContainerDungeonChest(player.inventory,(TileEntityCustomDungeonChest) world.getTileEntity(new BlockPos(x,y,z)));
			case GUI_CRATE:
				return new ContainerCrate(player.inventory,(TileEntityCustomCrate) world.getTileEntity(new BlockPos(x,y,z)));
			default: 
				return null;
		}	
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		switch(ID){
		case GUI_DUNGEONCHEST:
			return new GuiDungeonChest(new ContainerDungeonChest(player.inventory,(TileEntityCustomDungeonChest) world.getTileEntity(new BlockPos(x,y,z))));
		case GUI_CRATE:
			return new GuiCrate(new ContainerCrate(player.inventory,(TileEntityCustomCrate) world.getTileEntity(new BlockPos(x,y,z))));
		default: 
			return null;
	}
	}

}
