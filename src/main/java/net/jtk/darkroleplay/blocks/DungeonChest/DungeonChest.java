package net.jtk.darkroleplay.blocks.DungeonChest;

import org.lwjgl.opengl.GL11;

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
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DungeonChest extends BlockContainer {
	
	public static Block blockDungeonChest;

	public static Object instance;
	
	public static PropertyInteger DIR = PropertyInteger.create("dir", 0, 15);
	
	public DungeonChest() {
		super(Material.wood);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DIR, Integer.valueOf(0)));
	}
	
	static {

		blockDungeonChest = new DungeonChest()
				.setHardness(2.0F).setResistance(10.0F).setLightLevel(0.0F)
				.setUnlocalizedName("blockDungeonChest")
				.setStepSound(Block.soundTypeWood)
				.setCreativeTab(DarkRoleplayTabs.drBlocksTab);
		blockDungeonChest.setBlockBounds(1.0F / 16F * 1F, 0.0F,
				1.0F / 16F * 1F, 1.0F / 16F * 15F, 1.0F / 16F * 12F,
				1.0F / 16F * 15F);
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
		//world.markBlockForUpdate(pos);
    }
	
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
    	if (!worldIn.isRemote)
        {
    		TileEntity tileentity = worldIn.getTileEntity(pos);
    		if(tileentity instanceof TileEntityCustomDungeonChest){
    			playerIn.openGui(DarkRoleplay.instance, GuiHandler.GUI_DUNGEONCHEST, worldIn, pos.getX(), pos.getY(), pos.getZ());
    		}
        }
    	return true;
    }
    
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state){
    	TileEntity tileEntity = worldIn.getTileEntity(pos);
    	
    	if(tileEntity instanceof TileEntityCustomDungeonChest){
    		TileEntityCustomDungeonChest tileentityChest = (TileEntityCustomDungeonChest) tileEntity;
    		InventoryHelper.dropInventoryItems(worldIn, pos, tileentityChest.inventory);
    	}
    	
    	super.breakBlock(worldIn, pos, state);
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
	public boolean isFullCube()
    {
        return false;
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityCustomDungeonChest();
	}
}





