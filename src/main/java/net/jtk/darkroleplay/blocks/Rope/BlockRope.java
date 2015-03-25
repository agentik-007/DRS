package net.jtk.darkroleplay.blocks.Rope;

import org.lwjgl.opengl.GL11;

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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRope extends BlockContainer {

	public static Block blockRope;

	public static Object instance;

	public BlockRope() {
		super(Material.wood);
		this.setBlockBounds(1.0F / 16F * 7F, 0.0F, 1.0F / 16F * 7F,1.0F / 16F * 9F, 1.0F / 16F * 16F, 1.0F / 16F * 9F);
	}

	static {

		blockRope = new BlockRope().setHardness(0.3F)
				.setResistance(10.0F).setLightLevel(0.0F)
				.setUnlocalizedName("blockRope")
				.setStepSound(Block.soundTypeCloth)
				.setCreativeTab(DarkRoleplayTabs.drBlocksTab);
				//blockRope.setBlockBounds(1.0F / 16F * 7F, 0.0F, 1.0F / 16F * 7F,1.0F / 16F * 9F, 1.0F / 16F * 16F, 1.0F / 16F * 9F);
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
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityCustomRope();
	}
	
	@Override
	public boolean isFullCube()
    {
        return false;
    }
	
	@Override
	public boolean isLadder(IBlockAccess world, BlockPos pos, EntityLivingBase entity) {
		return true; 
	}
}




