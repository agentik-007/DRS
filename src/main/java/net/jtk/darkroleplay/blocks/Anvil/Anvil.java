package net.jtk.darkroleplay.blocks.Anvil;

import java.util.Random;

import net.jtk.darkroleplay.blocks.Barrels.BarrelClosed;
import net.jtk.darkroleplay.blocks.Barrels.TileEntityCustomBarrelClosed;
import net.jtk.darkroleplay.blocks.Cauldrons.Cauldron;
import net.jtk.darkroleplay.blocks.Cauldrons.TileEntityCustomCauldron;
import net.jtk.darkroleplay.guis.GuiHandler;
import net.jtk.darkroleplay.main.DarkRoleplay;
import net.jtk.darkroleplay.main.DarkRoleplayTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Anvil extends BlockContainer {

	public static Block blockAnvil;

	public static Object instance;

	public static PropertyInteger DIR = PropertyInteger.create("dir", 0, 15);
	
	public Anvil() {
		super(Material.wood);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DIR, Integer.valueOf(0)));
	}

	@Override
	public boolean isFullCube()
    {
        return false;
    }
	
	static {

		blockAnvil = new Anvil().setHardness(2.0F)
				.setResistance(10.0F).setLightLevel(0.0F)
				.setUnlocalizedName("blockAnvil")
				.setStepSound(Block.soundTypeMetal)
				.setCreativeTab(DarkRoleplayTabs.drBlocksTab);
		blockAnvil.setBlockBounds(1.0F / 16F * 0F, 1.0F / 16F * 0F, 1.0F / 16F * 0F,
				1.0F / 16F * 16F, 1.0F / 16F * 15F, 1.0F / 16F * 16F);
	}

	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
    {    	
    	if (!worldIn.isRemote){}
    	else
    	{
    		player.addChatMessage(new ChatComponentTranslation("This function is Work in Progress, sorry"));
    		
    	}
    	return true;
    }
	
	
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(DIR, Integer.valueOf(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(DIR)).intValue();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {DIR});
    }
    
    @Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
    	EntityPlayer entity =  (EntityPlayer) placer;
		if(entity!=null){int i = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		world.setBlockState(pos, state.withProperty(DIR, Integer.valueOf(i)), 3);
		}
		world.markBlockForUpdate(pos);
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
		return new TileEntityCustomAnvil();
	}
}
