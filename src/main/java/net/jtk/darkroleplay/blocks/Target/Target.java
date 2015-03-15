package net.jtk.darkroleplay.blocks.Target;

import net.jtk.darkroleplay.DarkRoleplayTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockSlab;
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
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Target extends BlockContainer {
	
	public static Block blockTarget;
	public static Object instance;

	public static PropertyInteger DIR = PropertyInteger.create("dir", 0, 3);
	
	public Target() {
		super(Material.wood);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DIR, Integer.valueOf(0)));
	}
	
	static {

		blockTarget = new Target().setHardness(2.0F)
				.setResistance(10.0F).setLightLevel(0.0F)
				.setUnlocalizedName("blockTarget")
				.setStepSound(Block.soundTypeWood)
				.setCreativeTab(DarkRoleplayTabs.drBlocksTab);
		blockTarget.setBlockBounds(1.0F / 16F * 0F, 0.0F, 1.0F / 16F * 0F,
				1.0F / 16F * 16F, 1.0F / 16F * 16F, 1.0F / 16F * 16F);
	}
	
	public static void Init(FMLInitializationEvent event){
		
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
			return new TileEntityCustomTarget();
		}
		
		public static void preInit(FMLPreInitializationEvent event) {
			GameRegistry.registerBlock(blockTarget, "blockTarget");
			GameRegistry.registerTileEntity(TileEntityCustomTarget.class, "TileEntityCustomTarget");
		}
}
