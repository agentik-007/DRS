package net.jtk.darkroleplay;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.jtk.darkroleplay.items.DarkRoleplayFood;
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
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
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

public class DarkRoleplayBlockPearHangingYellow extends BlockContainer {

	public static Block blockPearHangingYellow;

	public static Object instance;

	public static PropertyInteger DIR = PropertyInteger.create("dir", 0, 15);
	
	public DarkRoleplayBlockPearHangingYellow() {
		super(Material.wood);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DIR, Integer.valueOf(0)));
	}

	static {

		blockPearHangingYellow = new DarkRoleplayBlockPearHangingYellow()
				.setHardness(0.2F).setResistance(10.0F).setLightLevel(0.0F)
				.setUnlocalizedName("blockPearHangingYellow")
				.setStepSound(Block.soundTypeStone)
				.setCreativeTab(DarkRoleplayTabs.drBlocksTab);
		blockPearHangingYellow.setBlockBounds(1.0F / 16F * 6F, 1.0F / 16F * 10F,
				1.0F / 16F * 6F, 1.0F / 16F * 10F, 1.0F / 16F * 16F,
				1.0F / 16F * 10F);
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
        return DarkRoleplayFood.itemPear;
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
		return new TileEntityCustomPearHangingYellow();
	}

	public static void serverLoad(FMLServerStartingEvent event) {
	}

	public static void Init(FMLInitializationEvent event){
		GameRegistry.addRecipe(new ItemStack(DarkRoleplayBlockPearHangingYellow.blockPearHangingYellow , 1), " X ", "   ", "   ", 'X', DarkRoleplayFood.itemPear);
	}
	
	public static void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerBlock(blockPearHangingYellow,"blockPearHangingYellow");
		GameRegistry.registerTileEntity(TileEntityCustomPearHangingYellow.class, "TileEntityPearHangingYellow");
	}
}

class TileEntityCustomPearHangingYellow extends TileEntity {
}

class ItemRendererBlockPearHangingYellow implements IItemRenderer {

	private ModelPearHangingYellow model;

	public ItemRendererBlockPearHangingYellow() {
		model = new ModelPearHangingYellow();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {

		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {

		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		TileEntityRendererDispatcher.instance
				.renderTileEntityAt(new TileEntityCustomPearHangingYellow(),
						0.0D, 0.0D, 0.0D, 0.0F);
	}

}

class customRendererPearHangingYellow extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockPearHangingYellow.png");

	private ModelPearHangingYellow model;

	public customRendererPearHangingYellow() {
		this.model = new ModelPearHangingYellow();
	}

	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f, int i) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 2.1F, (float) z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		PropertyInteger DIR = PropertyInteger.create("dir", 0, 15);
		IBlockState state = tileentity.getWorld().getBlockState(tileentity.getPos());
		int facing = (((Integer) state.getValue(DIR)).intValue());
		GL11.glRotatef(facing * 90, 0.0F, 1.0F, 0.0F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		this.model.renderModel(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}

class ModelPearHangingYellow extends ModelBase {
	// fields
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;

	public ModelPearHangingYellow() {
		textureWidth = 32;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 3, 3, 3);
		Shape1.setRotationPoint(-1.5F, 21F, -1.5F);
		Shape1.setTextureSize(32, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 10);
		Shape2.addBox(0F, 0F, 0F, 1, 2, 1);
		Shape2.setRotationPoint(-0.9F, 18F, -0.7F);
		Shape2.setTextureSize(32, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0.4461433F, 0.4461433F, 0F);
		Shape3 = new ModelRenderer(this, 0, 6);
		Shape3.addBox(0F, 0F, 0F, 2, 2, 2);
		Shape3.setRotationPoint(-1F, 19F, -1F);
		Shape3.setTextureSize(32, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5,entity);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
	}

	public void renderModel(float f5) {
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,float f4, float f5,Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
	}

}
