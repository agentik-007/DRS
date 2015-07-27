package net.jtk.darkroleplay.blocks.Cauldrons;

import org.lwjgl.opengl.GL11;

import net.jtk.darkroleplay.guis.GuiHandler;
import net.jtk.darkroleplay.main.DarkRoleplay;
import net.jtk.darkroleplay.main.DarkRoleplayTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CauldronCookingTwo extends BlockContainer {

	public static Block blockCauldronCookingTwo;

	public static Object instance;

	public CauldronCookingTwo() {
		super(Material.wood);
	}

	static {

		blockCauldronCookingTwo = new CauldronCookingTwo().setHardness(2.0F)
				.setResistance(10.0F).setLightLevel(0.0F)
				.setCreativeTab(DarkRoleplayTabs.drBlocksTab)
				.setUnlocalizedName("blockCauldronCookingTwo")
				.setStepSound(Block.soundTypeStone);
				blockCauldronCookingTwo.setBlockBounds(1.0F / 16F * 0F, 0.0F, 1.0F / 16F * 0F,1.0F / 16F * 16F, 1.0F / 16F * 16F, 1.0F / 16F * 16F);
	}

	public int getRenderType() {
		return -1;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	 
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
    {
    	if(!worldIn.isRemote){
    		player.openGui(DarkRoleplay.instance, GuiHandler.GUI_CRAFTING, player.worldObj, pos.getX(), pos.getY(), pos.getZ());
    	}
    	return true;
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityCustomCauldronCookingTwo();
	}
}



