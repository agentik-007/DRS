package net.jtk.darkroleplay.blocks.KeyHanging;

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
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class KeyHanging extends BlockContainer{

		public static Block blockKeyHanging;
		public static Object instance;

		public static PropertyInteger DIR = PropertyInteger.create("dir", 0, 3);
		
		public KeyHanging() {
			super(Material.iron);
			this.setDefaultState(this.blockState.getBaseState().withProperty(DIR, Integer.valueOf(0)));
		}
		
		static {

			blockKeyHanging = new KeyHanging().setHardness(1.0F)
					.setResistance(10.0F).setLightLevel(0.0F)
					.setUnlocalizedName("blockKeyHanging")
					.setStepSound(Block.soundTypeMetal)
					.setCreativeTab(DarkRoleplayTabs.drBlocksTab);
			blockKeyHanging.setBlockBounds(1.0F / 16F * 0F, 0.0F, 1.0F / 16F * 0F,
					1.0F / 16F * 16F, 1.0F / 16F * 2F, 1.0F / 16F * 16F);
		}
		
		public static void Init(FMLInitializationEvent event){
			
		}
		
		public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos){
			 IBlockState iblockstate = worldIn.getBlockState(pos);
			 if (iblockstate.getBlock() == this){
				 if (iblockstate.getValue(DIR).equals(1))
	             {
	                 this.setBlockBounds(0.0F, 0.2F, 0.375F, 0.25F, 0.8F, 0.625F);
	             }
				 else if(iblockstate.getValue(DIR).equals(2))
				 {
					 this.setBlockBounds(0.375F, 0.2F, 0.0F,0.625F, 0.8F, 0.25F);
				 }
				 else if(iblockstate.getValue(DIR).equals(3))
				 {
					 this.setBlockBounds(0.75F, 0.2F, 0.375F, 1.0F, 0.8F, 0.625F);
				 }
	             else
	             {
	                 this.setBlockBounds(0.375F, 0.2F, 0.75F,  0.625F, 0.8F, 1.0F);
	             }
			 }
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
		 	 public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
		    {
		 		switch (facing){
		 			case NORTH:
		 				return this.getDefaultState().withProperty(DIR, 0);
		 			case SOUTH:
		 				return this.getDefaultState().withProperty(DIR, 2);
		 			case EAST:
		 				return this.getDefaultState().withProperty(DIR, 1);
		 			case WEST:
		 				return this.getDefaultState().withProperty(DIR, 3);
		 			default:
		 				return this.getDefaultState();
		 		}
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
				return new TileEntityCustomKeyHanging();
			}
			@Override
			public boolean isFullCube()
		    {
		        return false;
		    }
			
			public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
		    {
		    	if(!canBlockStay(worldIn, pos,state)){
		    		this.dropBlockAsItem(worldIn, pos, state, 0);
		    		worldIn.setBlockState(pos, Blocks.air.getDefaultState());
		    		return;
		    	}
		    }
			
			 public boolean canBlockStay(World world, BlockPos pos, IBlockState state){
				    
			    	EnumFacing Facing = EnumFacing.SOUTH;
			    	switch((Integer)state.getValue(DIR)){
			    		case 0: Facing = EnumFacing.NORTH;
			    		return world.isSideSolid(pos.south(), EnumFacing.NORTH);
			    		case 1: Facing = EnumFacing.EAST;
			    		return world.isSideSolid(pos.west(), EnumFacing.EAST);
			    		case 2: Facing = EnumFacing.SOUTH;
			    		return world.isSideSolid(pos.north(), EnumFacing.SOUTH);
			    		case 3: Facing = EnumFacing.WEST;
			    		return world.isSideSolid(pos.east(), EnumFacing.WEST);
			    		default:
			    			break;
			    	}
			    	
			    	return true;
			    }
			
	}
