package net.jtk.darkroleplay.blocks.Firepits;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.jtk.darkroleplay.main.DarkRoleplay;
import net.jtk.darkroleplay.main.DarkRoleplayTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SmallFirepit extends BlockContainer {

	public static Block blockSmallFirepit;

	//public static Object instance;
	
	public static PropertyInteger DIR = PropertyInteger.create("dir", 0, 15);

	public SmallFirepit() {
		super(Material.wood);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DIR, Integer.valueOf(0)));
	}

	static {

		blockSmallFirepit = new SmallFirepit()
				.setHardness(2.0F).setResistance(10.0F).setLightLevel(0.0F)
				.setUnlocalizedName("blockSmallFirepit")
				.setStepSound(Block.soundTypeWood)
				.setLightLevel(1F / 15F * 14F)
				.setCreativeTab(DarkRoleplayTabs.drBlocksTab);
		blockSmallFirepit.setBlockBounds(1.0F / 16F * 0F, 0.0F,
				1.0F / 16F * 0F, 1.0F / 16F * 16F, 1.0F / 16F * 10F,
				1.0F / 16F * 16F);
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

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
    	if (worldIn.isRemote)
        {
    		return true;
        }
    	else
    	{
    		playerIn.addChatMessage(new ChatComponentTranslation("This function is Work in Progress, sorry"));
   			return true;
    	}
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
    	Double x = (double) pos.getX()+0.25D;
    	Double y = (double) pos.getY()+0.1D;
    	Double z = (double) pos.getZ()+0.25D;
    	for(int i = 0; i < 3; i++){
    		worldIn.spawnParticle(EnumParticleTypes.FLAME, x + rand.nextDouble()/2, y + rand.nextDouble()/2, z+ rand.nextDouble()/2, 0.0D, 0.001D, 0.0D);
    		worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x + rand.nextDouble()/2, y + rand.nextDouble()/2, z+ rand.nextDouble()/2, 0.0D, 0.1D, 0.0D);
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
		return new TileEntityCustomSmallFirepit();
	}
}
