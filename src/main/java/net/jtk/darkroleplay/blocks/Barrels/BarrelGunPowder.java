package net.jtk.darkroleplay.blocks.Barrels;

import org.lwjgl.opengl.GL11;

import net.jtk.darkroleplay.DarkRoleplay;
import net.jtk.darkroleplay.DarkRoleplayBlockRope;
import net.jtk.darkroleplay.DarkRoleplayTabs;
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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BarrelGunPowder extends BlockContainer {
	public static Block blockBarrelGunPowder;

	public static Object instance;

	public static PropertyInteger DIR = PropertyInteger.create("dir", 0, 15);
	
	public BarrelGunPowder() {
		super(Material.wood);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DIR, Integer.valueOf(0)));
	}
	
	static {

		blockBarrelGunPowder = new BarrelGunPowder().setHardness(2.0F)
				.setResistance(10.0F).setLightLevel(0.0F)
				.setUnlocalizedName("blockBarrelGunPowder")
				.setStepSound(Block.soundTypeWood)
				.setCreativeTab(DarkRoleplayTabs.drBlocksTab);
		blockBarrelGunPowder.setBlockBounds(1.0F / 16F * 0F, 0.0F, 1.0F / 16F * 0F,
				1.0F / 16F * 16F, 1.0F / 16F * 16F, 1.0F / 16F * 16F);
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
		return new TileEntityCustomBarrelGunPowder();
	}

	public static void serverLoad(FMLServerStartingEvent event) {
	}

	public static void Init(FMLInitializationEvent event){
		GameRegistry.addRecipe(new ItemStack(BarrelGunPowder.blockBarrelGunPowder, 1), "Y Y", "Z Z", "XXX", 'X', Blocks.wooden_slab, 'Z', Items.string,'Y', DarkRoleplayBlockRope.blockRope);
	}
	public static void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerBlock(blockBarrelGunPowder, "blockBarrelGunPowder");
		GameRegistry.registerTileEntity(TileEntityCustomBarrelGunPowder.class, "TileEntityBarrelGunPowder");
	}
}