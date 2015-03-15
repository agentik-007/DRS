package net.jtk.darkroleplay.blocks.AppleRed;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.jtk.darkroleplay.DarkRoleplay;
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
import net.minecraft.init.Items;
import net.minecraft.item.Item;
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

public class AppleStandingRed extends BlockContainer {

	public static Block blockAppleStandingRed;

	public static Object instance;
	
	public static PropertyInteger DIR = PropertyInteger.create("dir", 0, 15);

	public AppleStandingRed() {
		super(Material.wood);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DIR, Integer.valueOf(0)));
	}

	static {

		blockAppleStandingRed = new AppleStandingRed().setHardness(0.2F)
				.setResistance(10.0F).setLightLevel(0.0F)
				.setUnlocalizedName("blockAppleStandingRed")
				.setStepSound(Block.soundTypeStone)
				.setCreativeTab(DarkRoleplayTabs.drBlocksTab);
				blockAppleStandingRed.setBlockBounds(1.0F / 16F * 5F, 0.0F, 1.0F / 16F * 5F,1.0F / 16F * 11F, 1.0F / 16F * 6F, 1.0F / 16F * 11F);
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
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.apple;
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
		return new TileEntityCustomAppleStandingRed();
	}

	public static void serverLoad(FMLServerStartingEvent event) {
	}

	public static void Init(FMLInitializationEvent event){
		GameRegistry.addRecipe(new ItemStack(AppleStandingRed.blockAppleStandingRed , 1), "   ", "   ", " X ", 'X', Items.apple);
	}
	
	public static void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerBlock(blockAppleStandingRed, "blockAppleStandingRed");
		GameRegistry.registerTileEntity(TileEntityCustomAppleStandingRed.class, "TileEntityAppleStandingRed");
	}
}