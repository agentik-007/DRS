package net.jtk.darkroleplay.blocks.WallTorch;

import java.util.Random;

import net.jtk.darkroleplay.blocks.blockPlaceholder;
import net.jtk.darkroleplay.main.DarkRoleplayTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class WallTorchUnlit extends BlockContainer{
	public static Block blockWallTorchUnlit;
	public static Object instance;

	public static final PropertyInteger DIR = PropertyInteger.create("dir", 0, 3);
	public static final PropertyBool AddonLighter = PropertyBool.create("addonLighter");
	public static final PropertyBool AddonTrap = PropertyBool.create("addonTrap");
	public static final PropertyBool POWERED = PropertyBool.create("powered");
	
	
	public WallTorchUnlit() {
		super(Material.wood);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DIR, Integer.valueOf(0)).withProperty(AddonLighter, Boolean.valueOf(false)).withProperty(AddonTrap, Boolean.valueOf(false)).withProperty(POWERED, Boolean.valueOf(false)));
	}
	
	static {

		blockWallTorchUnlit = new WallTorchUnlit().setHardness(2.0F)
				.setResistance(10.0F).setLightLevel(0.0F)
				.setUnlocalizedName("blockWallTorchUnlit")
				.setStepSound(Block.soundTypeWood)
				.setCreativeTab(DarkRoleplayTabs.drBlocksTab);
		blockWallTorchUnlit.setBlockBounds(1.0F / 16F * 0F, 0.0F, 1.0F / 16F * 0F,
				1.0F / 16F * 16F, 1.0F / 16F * 2F, 1.0F / 16F * 16F);
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
		int i = meta;
		if(i < 4){
			return this.getDefaultState().withProperty(DIR, Integer.valueOf(meta)).withProperty(AddonLighter, false).withProperty(AddonTrap, false).withProperty(POWERED, false);
		}else if(i >= 4 && i < 8){
			return this.getDefaultState().withProperty(DIR, Integer.valueOf(meta-4)).withProperty(AddonLighter, true).withProperty(AddonTrap,false).withProperty(POWERED, false);
		}else if(i >= 8 && i < 12){
			return this.getDefaultState().withProperty(DIR, Integer.valueOf(meta-8)).withProperty(AddonLighter, false).withProperty(AddonTrap,true).withProperty(POWERED, false);
		}else if(i >= 12 && i < 16){
			return this.getDefaultState().withProperty(DIR, Integer.valueOf(meta-12)).withProperty(AddonLighter, false).withProperty(AddonTrap,true).withProperty(POWERED, true);
		}
		
		return this.getDefaultState().withProperty(DIR, Integer.valueOf(meta));
    }
	
	public int getMetaFromState(IBlockState state)
    {
		int i = (Integer) state.getValue(DIR);
		if((Boolean) state.getValue(AddonLighter))
		{
			i = i + 4;
		}else if((Boolean) state.getValue(AddonTrap)){
			i = i + 8;
			if((Boolean) state.getValue(POWERED)){
				i = i +4;
			}
		}
		return i;
    }
	
	 protected BlockState createBlockState()
	    {
	        return new BlockState(this, new IProperty[] {DIR,AddonLighter,AddonTrap,POWERED});
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
	    
	    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	    {
	    	if(!worldIn.isRemote){
	    		if(playerIn.getHeldItem() == null){
	    			if((Boolean)state.getValue(AddonTrap) && !(Boolean)state.getValue(POWERED)){
	    				state = state.cycleProperty(POWERED);
			            worldIn.setBlockState(pos, state, 3);
			            worldIn.scheduleUpdate(pos, this, 60);
			            worldIn.scheduleUpdate(pos, WallTorchLit.blockWallTorchLit, 60);
			            worldIn.playSoundEffect((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, "random.click", 0.3F, ((Boolean)state.getValue(POWERED)).booleanValue() ? 0.6F : 0.5F);
	    			
			            EnumFacing Facing = EnumFacing.SOUTH;
				    	switch((Integer)state.getValue(DIR)){
				    		case 0: Facing = EnumFacing.NORTH;
				    		break;
				    		case 1: Facing = EnumFacing.EAST;
				    		break;
				    		case 2: Facing = EnumFacing.SOUTH;
				    		break;
				    		case 3: Facing = EnumFacing.WEST;
				    		break;
				    		default:
				    			break;
				    	}
				    	worldIn.notifyNeighborsOfStateChange(pos.offset(Facing.getOpposite()) , state.getBlock());
	    			
	    			}
	    		}
	    		else if(playerIn.getHeldItem().getItem().equals(Item.getItemFromBlock(Blocks.tripwire_hook))){
		    			if((Boolean)state.getValue(AddonLighter)){
		    				state = state.cycleProperty(AddonLighter);
		    				state = state.cycleProperty(AddonTrap);
		    				worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.flint,1)));
			    			worldIn.setBlockState(pos,state,3);
			    			playerIn.inventory.consumeInventoryItem(Item.getItemFromBlock(Blocks.tripwire_hook));
		    			}else if((Boolean)state.getValue(AddonTrap)){
		    				
		    			}else{
		    				state = state.cycleProperty(AddonTrap);
			    			worldIn.setBlockState(pos,state,3);
			    			playerIn.inventory.consumeInventoryItem(Item.getItemFromBlock(Blocks.tripwire_hook));
		    			}
		    	}
	    		else if(playerIn.getHeldItem().getItem().equals(Items.flint)){
	    			if((Boolean)state.getValue(AddonTrap)){
	    				worldIn.spawnEntityInWorld(new EntityItem(worldIn,pos.getX(),pos.getY(), pos.getZ(), new ItemStack(Item.getItemFromBlock(Blocks.tripwire_hook),1)));
	    				state = state.cycleProperty(AddonTrap);
	    				state = state.cycleProperty(AddonLighter);
	    				worldIn.setBlockState(pos, state,3);
	    				playerIn.inventory.consumeInventoryItem(Items.flint);
	    			}else if((Boolean)state.getValue(AddonLighter)){
	    				
	    			}else{
	    				state = state.cycleProperty(AddonLighter);
	    				worldIn.setBlockState(pos, state,3);
	    				playerIn.inventory.consumeInventoryItem(Items.flint);
	    			}
	    		}
	    		else if(playerIn.getHeldItem().getItem().equals(Items.flint_and_steel)){
	    			worldIn.setBlockState(pos, WallTorchLit.blockWallTorchLit.getDefaultState().withProperty(DIR, state.getValue(DIR)).withProperty(AddonLighter, state.getValue(AddonLighter)).withProperty(AddonTrap, state.getValue(AddonTrap)).withProperty(POWERED, state.getValue(POWERED)));
	    			playerIn.getHeldItem().attemptDamageItem(1, new Random());
	    		}
	    		else{
	    			if((Boolean)state.getValue(AddonTrap) && !(Boolean)state.getValue(POWERED)){
	    				state = state.cycleProperty(POWERED);
			            worldIn.setBlockState(pos, state, 3);
			            worldIn.scheduleUpdate(pos, this, 60);
			            worldIn.scheduleUpdate(pos, WallTorchLit.blockWallTorchLit, 60);
			            worldIn.playSoundEffect((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, "random.click", 0.3F, ((Boolean)state.getValue(POWERED)).booleanValue() ? 0.6F : 0.5F);
	    			
			            EnumFacing Facing = EnumFacing.SOUTH;
				    	switch((Integer)state.getValue(DIR)){
				    		case 0: Facing = EnumFacing.NORTH;
				    		break;
				    		case 1: Facing = EnumFacing.EAST;
				    		break;
				    		case 2: Facing = EnumFacing.SOUTH;
				    		break;
				    		case 3: Facing = EnumFacing.WEST;
				    		break;
				    		default:
				    			break;
				    	}
				    	worldIn.notifyNeighborsOfStateChange(pos.offset(Facing.getOpposite()) , state.getBlock());
	    			
	    			}
	    		}
		    	return true;
	    	}
	    	return true;
	    }
	    
	    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	    {
	    	
	    	if(worldIn.isRemote)
	    	{
	    		
	    	}
	    	else
	    	{
	    		worldIn.setBlockState(pos, state.withProperty(POWERED, Boolean.valueOf(false)), 3);
	    		worldIn.notifyNeighborsOfStateChange(pos, this);
	    		 worldIn.playSoundEffect((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, "random.click", 0.3F, ((Boolean)state.getValue(POWERED)).booleanValue() ? 0.6F : 0.5F);
	    		 EnumFacing Facing = EnumFacing.SOUTH;
			    	switch((Integer)state.getValue(DIR)){
			    		case 0: Facing = EnumFacing.NORTH;
			    		break;
			    		case 1: Facing = EnumFacing.EAST;
			    		break;
			    		case 2: Facing = EnumFacing.SOUTH;
			    		break;
			    		case 3: Facing = EnumFacing.WEST;
			    		break;
			    		default:
			    			break;
			    	}
			    	worldIn.notifyNeighborsOfStateChange(pos.offset(Facing.getOpposite()) , state.getBlock());
	    	}
	    	
	    }
		
	    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
	    {

	    	if(!canBlockStay(worldIn, pos,state)){
	    		this.dropBlockAsItem(worldIn, pos, state, 0);
	    		worldIn.setBlockState(pos, Blocks.air.getDefaultState());
	    		return;
	    	}
	    	
	    	if((Boolean)state.getValue(AddonLighter)){
	    		 if (!worldIn.isRemote)
	 	        {
	 	            if (worldIn.isBlockPowered(pos))
	 	            {
	 	            	 worldIn.setBlockState(pos, WallTorchLit.blockWallTorchLit.getDefaultState().withProperty(DIR, state.getValue(DIR)).withProperty(AddonLighter, state.getValue(AddonLighter)).withProperty(AddonTrap, state.getValue(AddonTrap)).withProperty(POWERED, state.getValue(POWERED)), 2);
	 	            }
	 	        }
	    	}
	    }
	    
	    public int isProvidingWeakPower(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
	    {
	        return ((Boolean)state.getValue(POWERED)).booleanValue() ? 15 : 0;
	    }

	    public int isProvidingStrongPower(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
	    {
	    	EnumFacing Facing = EnumFacing.SOUTH;
	    	switch((Integer)state.getValue(DIR)){
	    		case 0: Facing = EnumFacing.NORTH;
	    		break;
	    		case 1: Facing = EnumFacing.EAST;
	    		break;
	    		case 2: Facing = EnumFacing.SOUTH;
	    		break;
	    		case 3: Facing = EnumFacing.WEST;
	    		break;
	    		default:
	    			break;
	    	}
	    			
	        return !((Boolean)state.getValue(POWERED)).booleanValue() ? 0 : (Facing == side ? 15 : 0);
	    }
	    
	    public boolean canProvidePower()
	    {
	        return true;
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
			return new TileEntityCustomWallTorchUnlit();
		}
		@Override
		public boolean isFullCube()
	    {
	        return false;
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
		
	 public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	 {
		 return worldIn.isSideSolid(pos.west(), EnumFacing.EAST, true) ||
				 worldIn.isSideSolid(pos.east(), EnumFacing.WEST, true) ||
				 worldIn.isSideSolid(pos.north(), EnumFacing.SOUTH, true) ||
				 worldIn.isSideSolid(pos.south(), EnumFacing.NORTH, true);
	 }
}
