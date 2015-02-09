package net.jtk.darkroleplay;

import org.lwjgl.opengl.GL11;

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
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
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

public class DarkRoleplayBlockBucketFlowerOne extends BlockContainer {

	public static Block blockBucketFlowerOne;

	public static Object instance;
	
	public static PropertyInteger DIR = PropertyInteger.create("dir", 0, 15);

	public DarkRoleplayBlockBucketFlowerOne() {
		super(Material.wood);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DIR, Integer.valueOf(0)));
	}

	static {

		blockBucketFlowerOne = new DarkRoleplayBlockBucketFlowerOne().setHardness(2.0F)
				.setResistance(10.0F).setLightLevel(0.0F)
				.setUnlocalizedName("blockBucketFlowerOne")
				.setStepSound(Block.soundTypeWood)
				.setCreativeTab(DarkRoleplayTabs.drBlocksTab);
		blockBucketFlowerOne.setBlockBounds(1.0F / 16F * 3F, 0.0F, 1.0F / 16F * 3F,
				1.0F / 16F * 13F, 1.0F / 16F * 8F, 1.0F / 16F * 13F);
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
		return new TileEntityCustomBucketFlowerOne();
	}

	public static void serverLoad(FMLServerStartingEvent event) {
	}

	public static void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerBlock(blockBucketFlowerOne, "blockBucketFlowerOne");
		GameRegistry.registerTileEntity(TileEntityCustomBucketFlowerOne.class, "TileEntityBucketFlowerOne");
	}
}

class TileEntityCustomBucketFlowerOne extends TileEntity {
}

class customRendererBucketFlowerOne extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockBucketFlowerOne.png");

	private ModelBucketFlowerOne model;

	public customRendererBucketFlowerOne() {
		this.model = new ModelBucketFlowerOne();
	}

	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f, int i) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
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

class ModelBucketFlowerOne extends ModelBase {
	//fields
    ModelRenderer Shape90;
    ModelRenderer Shape22;
    ModelRenderer Shape29;
    ModelRenderer Shape19;
    ModelRenderer Shape20;
    ModelRenderer Shape48;
    ModelRenderer Shape21;
    ModelRenderer Shape23;
    ModelRenderer Shape25;
    ModelRenderer Shape26;
    ModelRenderer Shape27;
    ModelRenderer Shape24;
    ModelRenderer Shape28;
    ModelRenderer Shape30;
    ModelRenderer Shape32;
    ModelRenderer Shape35;
    ModelRenderer Shape33;
    ModelRenderer Shape31;
    ModelRenderer Shape34;
    ModelRenderer Shape36;
    ModelRenderer Shape39;
    ModelRenderer Shape49;
    ModelRenderer Shape38;
    ModelRenderer Shape40;
    ModelRenderer Shape41;
    ModelRenderer Shape37;
    ModelRenderer Shape42;
    ModelRenderer Shape43;
    ModelRenderer Shape46;
    ModelRenderer Shape45;
    ModelRenderer Shape44;
    ModelRenderer Shape52;
    ModelRenderer Shape47;
    ModelRenderer Shape51;
    ModelRenderer Shape50;
    ModelRenderer Shape59;
    ModelRenderer Shape53;
    ModelRenderer Shape55;
    ModelRenderer Shape56;
    ModelRenderer Shape54;
    ModelRenderer Shape57;
    ModelRenderer Shape58;
    ModelRenderer Shape60;
    ModelRenderer Shape69;
    ModelRenderer Shape61;
    ModelRenderer Shape67;
    ModelRenderer Shape63;
    ModelRenderer Shape65;
    ModelRenderer Shape66;
    ModelRenderer Shape62;
    ModelRenderer Shape68;
    ModelRenderer Shape64;
    ModelRenderer Shape70;
    ModelRenderer Shape71;
    ModelRenderer Shape74;
    ModelRenderer Shape73;
    ModelRenderer Shape75;
    ModelRenderer Shape72;
    ModelRenderer Shape79;
    ModelRenderer Shape77;
    ModelRenderer Shape78;
    ModelRenderer Shape81;
    ModelRenderer Shape80;
    ModelRenderer Shape82;
    ModelRenderer Shape11;
    ModelRenderer Shape10;
    ModelRenderer Shape1;
    ModelRenderer Shape13;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape9;
    ModelRenderer Shape5;
    ModelRenderer Shape8;
    ModelRenderer Shape14;
    ModelRenderer Shape15;
    ModelRenderer Shape7;
    ModelRenderer Shape6;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
    ModelRenderer Shape18;
    ModelRenderer Shape4;
    ModelRenderer Shape12;
    ModelRenderer Shape84;
    ModelRenderer Shape83;
    ModelRenderer Shape76;
  
  public ModelBucketFlowerOne()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Shape90 = new ModelRenderer(this, 47, 23);
      Shape90.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape90.setRotationPoint(2F, 11F, -1F);
      Shape90.setTextureSize(64, 64);
      Shape90.mirror = true;
      setRotation(Shape90, 0F, 0F, 0F);
      Shape22 = new ModelRenderer(this, 42, 0);
      Shape22.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape22.setRotationPoint(-2F, 15F, 0F);
      Shape22.setTextureSize(64, 64);
      Shape22.mirror = true;
      setRotation(Shape22, 0F, 0F, 0F);
      Shape29 = new ModelRenderer(this, 42, 23);
      Shape29.addBox(0F, 0F, 0F, 1, 2, 1);
      Shape29.setRotationPoint(-3F, 8.5F, -2F);
      Shape29.setTextureSize(64, 64);
      Shape29.mirror = true;
      setRotation(Shape29, 0F, 0F, 0F);
      Shape19 = new ModelRenderer(this, 42, 35);
      Shape19.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape19.setRotationPoint(-2.5F, 13.5F, 1.5F);
      Shape19.setTextureSize(64, 64);
      Shape19.mirror = true;
      setRotation(Shape19, 0F, 0F, 0F);
      Shape20 = new ModelRenderer(this, 42, 42);
      Shape20.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape20.setRotationPoint(-0.5F, 9.5F, -1.5F);
      Shape20.setTextureSize(64, 64);
      Shape20.mirror = true;
      setRotation(Shape20, 0F, 0F, 0F);
      Shape48 = new ModelRenderer(this, 42, 0);
      Shape48.addBox(0F, 0F, 0F, 1, 8, 1);
      Shape48.setRotationPoint(-1F, 10F, -2F);
      Shape48.setTextureSize(64, 64);
      Shape48.mirror = true;
      setRotation(Shape48, 0F, 0F, 0F);
      Shape21 = new ModelRenderer(this, 42, 23);
      Shape21.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape21.setRotationPoint(-3F, 9.6F, -3F);
      Shape21.setTextureSize(64, 64);
      Shape21.mirror = true;
      setRotation(Shape21, 0F, 0F, 0F);
      Shape23 = new ModelRenderer(this, 42, 0);
      Shape23.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape23.setRotationPoint(-2F, 14F, 1F);
      Shape23.setTextureSize(64, 64);
      Shape23.mirror = true;
      setRotation(Shape23, 0F, 0F, 0F);
      Shape25 = new ModelRenderer(this, 42, 20);
      Shape25.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape25.setRotationPoint(-3F, 14F, 1F);
      Shape25.setTextureSize(64, 64);
      Shape25.mirror = true;
      setRotation(Shape25, 0F, 0F, 0F);
      Shape26 = new ModelRenderer(this, 42, 20);
      Shape26.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape26.setRotationPoint(-2F, 13F, 1F);
      Shape26.setTextureSize(64, 64);
      Shape26.mirror = true;
      setRotation(Shape26, 0F, 0F, 0F);
      Shape27 = new ModelRenderer(this, 42, 0);
      Shape27.addBox(0F, 0F, 0F, 1, 4, 1);
      Shape27.setRotationPoint(-2F, 13F, -1F);
      Shape27.setTextureSize(64, 64);
      Shape27.mirror = true;
      setRotation(Shape27, 0F, 0F, 0F);
      Shape24 = new ModelRenderer(this, 42, 20);
      Shape24.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape24.setRotationPoint(-2F, 14F, 2F);
      Shape24.setTextureSize(64, 64);
      Shape24.mirror = true;
      setRotation(Shape24, 0F, 0F, 0F);
      Shape28 = new ModelRenderer(this, 42, 0);
      Shape28.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape28.setRotationPoint(-3F, 10F, -2F);
      Shape28.setTextureSize(64, 64);
      Shape28.mirror = true;
      setRotation(Shape28, 0F, 0F, 0F);
      Shape30 = new ModelRenderer(this, 42, 37);
      Shape30.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape30.setRotationPoint(-3.5F, 9.1F, -2.5F);
      Shape30.setTextureSize(64, 64);
      Shape30.mirror = true;
      setRotation(Shape30, 0F, 0F, 0F);
      Shape32 = new ModelRenderer(this, 42, 46);
      Shape32.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape32.setRotationPoint(1.5F, 13.5F, -1.5F);
      Shape32.setTextureSize(64, 64);
      Shape32.mirror = true;
      setRotation(Shape32, 0F, 0F, 0F);
      Shape35 = new ModelRenderer(this, 42, 27);
      Shape35.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape35.setRotationPoint(-1F, 10F, -1F);
      Shape35.setTextureSize(64, 64);
      Shape35.mirror = true;
      setRotation(Shape35, 0F, 0F, 0F);
      Shape33 = new ModelRenderer(this, 42, 27);
      Shape33.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape33.setRotationPoint(-1F, 9F, -2F);
      Shape33.setTextureSize(64, 64);
      Shape33.mirror = true;
      setRotation(Shape33, 0F, 0F, 0F);
      Shape31 = new ModelRenderer(this, 42, 13);
      Shape31.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape31.setRotationPoint(-4F, 10F, -1F);
      Shape31.setTextureSize(64, 64);
      Shape31.mirror = true;
      setRotation(Shape31, 0F, 0F, 0F);
      Shape34 = new ModelRenderer(this, 42, 27);
      Shape34.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape34.setRotationPoint(0F, 10F, -2F);
      Shape34.setTextureSize(64, 64);
      Shape34.mirror = true;
      setRotation(Shape34, 0F, 0F, 0F);
      Shape36 = new ModelRenderer(this, 42, 23);
      Shape36.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape36.setRotationPoint(-4F, 9.6F, -2F);
      Shape36.setTextureSize(64, 64);
      Shape36.mirror = true;
      setRotation(Shape36, 0F, 0F, 0F);
      Shape39 = new ModelRenderer(this, 42, 40);
      Shape39.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape39.setRotationPoint(-4.5F, 9.6F, -0.5F);
      Shape39.setTextureSize(64, 64);
      Shape39.mirror = true;
      setRotation(Shape39, 0F, 0F, 0F);
      Shape49 = new ModelRenderer(this, 42, 0);
      Shape49.addBox(0F, 0F, 0F, 1, 1, 2);
      Shape49.setRotationPoint(-1F, 12F, -4F);
      Shape49.setTextureSize(64, 64);
      Shape49.mirror = true;
      setRotation(Shape49, 0F, 0F, 0F);
      Shape38 = new ModelRenderer(this, 42, 23);
      Shape38.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape38.setRotationPoint(-4F, 9F, -1F);
      Shape38.setTextureSize(64, 64);
      Shape38.mirror = true;
      setRotation(Shape38, 0F, 0F, 0F);
      Shape40 = new ModelRenderer(this, 42, 23);
      Shape40.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape40.setRotationPoint(-5F, 10F, -1F);
      Shape40.setTextureSize(64, 64);
      Shape40.mirror = true;
      setRotation(Shape40, 0F, 0F, 0F);
      Shape41 = new ModelRenderer(this, 47, 36);
      Shape41.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape41.setRotationPoint(-0.5F, 11.5F, -4.5F);
      Shape41.setTextureSize(64, 64);
      Shape41.mirror = true;
      setRotation(Shape41, 0F, 0F, 0F);
      Shape37 = new ModelRenderer(this, 42, 23);
      Shape37.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape37.setRotationPoint(-4F, 10F, 0F);
      Shape37.setTextureSize(64, 64);
      Shape37.mirror = true;
      setRotation(Shape37, 0F, 0F, 0F);
      Shape42 = new ModelRenderer(this, 42, 0);
      Shape42.addBox(0F, 0F, 0F, 2, 1, 1);
      Shape42.setRotationPoint(0F, 14F, -2F);
      Shape42.setTextureSize(64, 64);
      Shape42.mirror = true;
      setRotation(Shape42, 0F, 0F, 0F);
      Shape43 = new ModelRenderer(this, 42, 29);
      Shape43.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape43.setRotationPoint(-1F, 12F, -5F);
      Shape43.setTextureSize(64, 64);
      Shape43.mirror = true;
      setRotation(Shape43, 0F, 0F, 0F);
      Shape46 = new ModelRenderer(this, 42, 31);
      Shape46.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape46.setRotationPoint(1F, 14F, -1F);
      Shape46.setTextureSize(64, 64);
      Shape46.mirror = true;
      setRotation(Shape46, 0F, 0F, 0F);
      Shape45 = new ModelRenderer(this, 42, 31);
      Shape45.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape45.setRotationPoint(6F, 12F, 1F);
      Shape45.setTextureSize(64, 64);
      Shape45.mirror = true;
      setRotation(Shape45, 0F, 0F, 0F);
      Shape44 = new ModelRenderer(this, 42, 31);
      Shape44.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape44.setRotationPoint(2F, 14F, -2F);
      Shape44.setTextureSize(64, 64);
      Shape44.mirror = true;
      setRotation(Shape44, 0F, 0F, 0F);
      Shape52 = new ModelRenderer(this, 47, 23);
      Shape52.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape52.setRotationPoint(-1F, 11F, -4F);
      Shape52.setTextureSize(64, 64);
      Shape52.mirror = true;
      setRotation(Shape52, 0F, 0F, 0F);
      Shape47 = new ModelRenderer(this, 42, 31);
      Shape47.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape47.setRotationPoint(1F, 13F, -2F);
      Shape47.setTextureSize(64, 64);
      Shape47.mirror = true;
      setRotation(Shape47, 0F, 0F, 0F);
      Shape51 = new ModelRenderer(this, 47, 23);
      Shape51.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape51.setRotationPoint(0F, 12F, -4F);
      Shape51.setTextureSize(64, 64);
      Shape51.mirror = true;
      setRotation(Shape51, 0F, 0F, 0F);
      Shape50 = new ModelRenderer(this, 47, 23);
      Shape50.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape50.setRotationPoint(2F, 12F, -2F);
      Shape50.setTextureSize(64, 64);
      Shape50.mirror = true;
      setRotation(Shape50, 0F, 0F, 0F);
      Shape59 = new ModelRenderer(this, 42, 0);
      Shape59.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape59.setRotationPoint(1F, 14F, 4F);
      Shape59.setTextureSize(64, 64);
      Shape59.mirror = true;
      setRotation(Shape59, 0F, 0F, 0F);
      Shape53 = new ModelRenderer(this, 42, 0);
      Shape53.addBox(0F, 0F, 0F, 1, 8, 1);
      Shape53.setRotationPoint(2F, 10F, 1F);
      Shape53.setTextureSize(64, 64);
      Shape53.mirror = true;
      setRotation(Shape53, 0F, 0F, 0F);
      Shape55 = new ModelRenderer(this, 42, 0);
      Shape55.addBox(0F, 0F, 0F, 1, 4, 1);
      Shape55.setRotationPoint(1F, 13F, 2F);
      Shape55.setTextureSize(64, 64);
      Shape55.mirror = true;
      setRotation(Shape55, 0F, 0F, 0F);
      Shape56 = new ModelRenderer(this, 42, 0);
      Shape56.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape56.setRotationPoint(0F, 10F, 1F);
      Shape56.setTextureSize(64, 64);
      Shape56.mirror = true;
      setRotation(Shape56, 0F, 0F, 0F);
      Shape54 = new ModelRenderer(this, 42, 0);
      Shape54.addBox(0F, 0F, 0F, 1, 1, 2);
      Shape54.setRotationPoint(2F, 12F, -1F);
      Shape54.setTextureSize(64, 64);
      Shape54.mirror = true;
      setRotation(Shape54, 0F, 0F, 0F);
      Shape57 = new ModelRenderer(this, 42, 13);
      Shape57.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape57.setRotationPoint(-1F, 10F, 2F);
      Shape57.setTextureSize(64, 64);
      Shape57.mirror = true;
      setRotation(Shape57, 0F, 0F, 0F);
      Shape58 = new ModelRenderer(this, 42, 0);
      Shape58.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape58.setRotationPoint(1F, 15F, 3F);
      Shape58.setTextureSize(64, 64);
      Shape58.mirror = true;
      setRotation(Shape58, 0F, 0F, 0F);
      Shape60 = new ModelRenderer(this, 42, 0);
      Shape60.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape60.setRotationPoint(3F, 12F, 1F);
      Shape60.setTextureSize(64, 64);
      Shape60.mirror = true;
      setRotation(Shape60, 0F, 0F, 0F);
      Shape69 = new ModelRenderer(this, 42, 23);
      Shape69.addBox(0F, 0F, 0F, 1, 2, 1);
      Shape69.setRotationPoint(0F, 8.5F, 1F);
      Shape69.setTextureSize(64, 64);
      Shape69.mirror = true;
      setRotation(Shape69, 0F, 0F, 0F);
      Shape61 = new ModelRenderer(this, 42, 0);
      Shape61.addBox(0F, 0F, 0F, 2, 1, 1);
      Shape61.setRotationPoint(3F, 13F, 1F);
      Shape61.setTextureSize(64, 64);
      Shape61.mirror = true;
      setRotation(Shape61, 0F, 0F, 0F);
      Shape67 = new ModelRenderer(this, 42, 23);
      Shape67.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape67.setRotationPoint(-1F, 9.6F, 1F);
      Shape67.setTextureSize(64, 64);
      Shape67.mirror = true;
      setRotation(Shape67, 0F, 0F, 0F);
      Shape63 = new ModelRenderer(this, 42, 23);
      Shape63.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape63.setRotationPoint(-2F, 10F, 2F);
      Shape63.setTextureSize(64, 64);
      Shape63.mirror = true;
      setRotation(Shape63, 0F, 0F, 0F);
      Shape65 = new ModelRenderer(this, 42, 23);
      Shape65.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape65.setRotationPoint(-1F, 9F, 2F);
      Shape65.setTextureSize(64, 64);
      Shape65.mirror = true;
      setRotation(Shape65, 0F, 0F, 0F);
      Shape66 = new ModelRenderer(this, 42, 23);
      Shape66.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape66.setRotationPoint(-1F, 10F, 3F);
      Shape66.setTextureSize(64, 64);
      Shape66.mirror = true;
      setRotation(Shape66, 0F, 0F, 0F);
      Shape62 = new ModelRenderer(this, 42, 0);
      Shape62.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape62.setRotationPoint(5F, 12F, 1F);
      Shape62.setTextureSize(64, 64);
      Shape62.mirror = true;
      setRotation(Shape62, 0F, 0F, 0F);
      Shape68 = new ModelRenderer(this, 42, 37);
      Shape68.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape68.setRotationPoint(-0.5F, 9.1F, 0.5F);
      Shape68.setTextureSize(64, 64);
      Shape68.mirror = true;
      setRotation(Shape68, 0F, 0F, 0F);
      Shape64 = new ModelRenderer(this, 42, 40);
      Shape64.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape64.setRotationPoint(-1.5F, 9.6F, 2.5F);
      Shape64.setTextureSize(64, 64);
      Shape64.mirror = true;
      setRotation(Shape64, 0F, 0F, 0F);
      Shape70 = new ModelRenderer(this, 42, 23);
      Shape70.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape70.setRotationPoint(0F, 9.6F, 0F);
      Shape70.setTextureSize(64, 64);
      Shape70.mirror = true;
      setRotation(Shape70, 0F, 0F, 0F);
      Shape71 = new ModelRenderer(this, 42, 20);
      Shape71.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape71.setRotationPoint(0F, 14F, 4F);
      Shape71.setTextureSize(64, 64);
      Shape71.mirror = true;
      setRotation(Shape71, 0F, 0F, 0F);
      Shape74 = new ModelRenderer(this, 42, 20);
      Shape74.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape74.setRotationPoint(1F, 14F, 5F);
      Shape74.setTextureSize(64, 64);
      Shape74.mirror = true;
      setRotation(Shape74, 0F, 0F, 0F);
      Shape73 = new ModelRenderer(this, 42, 35);
      Shape73.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape73.setRotationPoint(0.5F, 13.5F, 4.5F);
      Shape73.setTextureSize(64, 64);
      Shape73.mirror = true;
      setRotation(Shape73, 0F, 0F, 0F);
      Shape75 = new ModelRenderer(this, 47, 36);
      Shape75.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape75.setRotationPoint(2.5F, 11.5F, -1.5F);
      Shape75.setTextureSize(64, 64);
      Shape75.mirror = true;
      setRotation(Shape75, 0F, 0F, 0F);
      Shape72 = new ModelRenderer(this, 42, 20);
      Shape72.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape72.setRotationPoint(1F, 13F, 4F);
      Shape72.setTextureSize(64, 64);
      Shape72.mirror = true;
      setRotation(Shape72, 0F, 0F, 0F);
      Shape79 = new ModelRenderer(this, 42, 42);
      Shape79.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape79.setRotationPoint(2.5F, 9.5F, 1.5F);
      Shape79.setTextureSize(64, 64);
      Shape79.mirror = true;
      setRotation(Shape79, 0F, 0F, 0F);
      Shape77 = new ModelRenderer(this, 42, 27);
      Shape77.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape77.setRotationPoint(2F, 9F, 1F);
      Shape77.setTextureSize(64, 64);
      Shape77.mirror = true;
      setRotation(Shape77, 0F, 0F, 0F);
      Shape78 = new ModelRenderer(this, 42, 27);
      Shape78.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape78.setRotationPoint(3F, 10F, 1F);
      Shape78.setTextureSize(64, 64);
      Shape78.mirror = true;
      setRotation(Shape78, 0F, 0F, 0F);
      Shape81 = new ModelRenderer(this, 42, 31);
      Shape81.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape81.setRotationPoint(5F, 12F, 2F);
      Shape81.setTextureSize(64, 64);
      Shape81.mirror = true;
      setRotation(Shape81, 0F, 0F, 0F);
      Shape80 = new ModelRenderer(this, 42, 27);
      Shape80.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape80.setRotationPoint(2F, 10F, 2F);
      Shape80.setTextureSize(64, 64);
      Shape80.mirror = true;
      setRotation(Shape80, 0F, 0F, 0F);
      Shape82 = new ModelRenderer(this, 42, 31);
      Shape82.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape82.setRotationPoint(5F, 11F, 1F);
      Shape82.setTextureSize(64, 64);
      Shape82.mirror = true;
      setRotation(Shape82, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 0, 9);
      Shape11.addBox(-2F, -8F, 0F, 4, 8, 1);
      Shape11.setRotationPoint(-2.4F, 24F, 2.4F);
      Shape11.setTextureSize(64, 64);
      Shape11.mirror = true;
      setRotation(Shape11, -0.148353F, -0.7853982F, 0F);
      Shape10 = new ModelRenderer(this, 0, 9);
      Shape10.addBox(-2F, -8F, -1F, 4, 8, 1);
      Shape10.setRotationPoint(-2.4F, 24F, -2.4F);
      Shape10.setTextureSize(64, 64);
      Shape10.mirror = true;
      setRotation(Shape10, 0.1570796F, 0.7853982F, 0F);
      Shape1 = new ModelRenderer(this, 8, 44);
      Shape1.addBox(0F, 0F, 0F, 6, 1, 6);
      Shape1.setRotationPoint(-3F, 22F, -3F);
      Shape1.setTextureSize(64, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape13 = new ModelRenderer(this, 0, 9);
      Shape13.addBox(-2F, -8F, 0F, 4, 8, 1);
      Shape13.setRotationPoint(3.1F, 24.1F, -3.1F);
      Shape13.setTextureSize(64, 64);
      Shape13.mirror = true;
      setRotation(Shape13, 0.1570796F, -0.7853982F, 0F);
      Shape2 = new ModelRenderer(this, 0, 50);
      Shape2.addBox(0F, 0F, 0F, 1, 1, 4);
      Shape2.setRotationPoint(-4F, 22F, -2F);
      Shape2.setTextureSize(64, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 19);
      Shape3.addBox(-2F, -8F, -1F, 4, 8, 1);
      Shape3.setRotationPoint(0F, 24F, -3.5F);
      Shape3.setTextureSize(64, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0.1396263F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 0, 45);
      Shape9.addBox(0F, 0F, 0F, 4, 1, 1);
      Shape9.setRotationPoint(-2F, 22F, -4F);
      Shape9.setTextureSize(64, 64);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 19);
      Shape5.addBox(-2F, -7F, 0F, 4, 8, 1);
      Shape5.setRotationPoint(0F, 23F, 3.5F);
      Shape5.setTextureSize(64, 64);
      Shape5.mirror = true;
      setRotation(Shape5, -0.1396263F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 45);
      Shape8.addBox(0F, 0F, 0F, 4, 1, 1);
      Shape8.setRotationPoint(-2F, 22F, 3F);
      Shape8.setTextureSize(64, 64);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape14 = new ModelRenderer(this, 12, 20);
      Shape14.addBox(0F, 0F, 0F, 6, 1, 6);
      Shape14.setRotationPoint(-3F, 18F, -3F);
      Shape14.setTextureSize(64, 64);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, 0F, 0F);
      Shape15 = new ModelRenderer(this, 15, 30);
      Shape15.addBox(0F, 0F, 0F, 6, 1, 1);
      Shape15.setRotationPoint(3F, 18F, 3F);
      Shape15.setTextureSize(64, 64);
      Shape15.mirror = true;
      setRotation(Shape15, 0F, 1.570796F, 0F);
      Shape7 = new ModelRenderer(this, 0, 30);
      Shape7.addBox(0F, -8F, -2F, 1, 8, 4);
      Shape7.setRotationPoint(3.5F, 24F, 0F);
      Shape7.setTextureSize(64, 64);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0.1396263F);
      Shape6 = new ModelRenderer(this, 0, 50);
      Shape6.addBox(0F, 0F, 0F, 1, 1, 4);
      Shape6.setRotationPoint(3F, 22F, -2F);
      Shape6.setTextureSize(64, 64);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape16 = new ModelRenderer(this, 15, 30);
      Shape16.addBox(0F, 0F, 0F, 6, 1, 1);
      Shape16.setRotationPoint(-3F, 18F, -4F);
      Shape16.setTextureSize(64, 64);
      Shape16.mirror = true;
      setRotation(Shape16, 0F, 0F, 0F);
      Shape17 = new ModelRenderer(this, 15, 30);
      Shape17.addBox(0F, 0F, 0F, 6, 1, 1);
      Shape17.setRotationPoint(-3F, 18F, 3F);
      Shape17.setTextureSize(64, 64);
      Shape17.mirror = true;
      setRotation(Shape17, 0F, 0F, 0F);
      Shape18 = new ModelRenderer(this, 15, 30);
      Shape18.addBox(0F, 0F, 0F, 6, 1, 1);
      Shape18.setRotationPoint(-4F, 18F, 3F);
      Shape18.setTextureSize(64, 64);
      Shape18.mirror = true;
      setRotation(Shape18, 0F, 1.570796F, 0F);
      Shape4 = new ModelRenderer(this, 0, 30);
      Shape4.addBox(-1F, -8F, -2F, 1, 8, 4);
      Shape4.setRotationPoint(-3.5F, 24F, 0F);
      Shape4.setTextureSize(64, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, -0.1396263F);
      Shape12 = new ModelRenderer(this, 0, 9);
      Shape12.addBox(-2F, -8F, -1F, 4, 8, 1);
      Shape12.setRotationPoint(3F, 24.2F, 3F);
      Shape12.setTextureSize(64, 64);
      Shape12.mirror = true;
      setRotation(Shape12, -0.1570796F, 0.7853982F, 0F);
      Shape84 = new ModelRenderer(this, 42, 46);
      Shape84.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape84.setRotationPoint(5.5F, 11.5F, 1.5F);
      Shape84.setTextureSize(64, 64);
      Shape84.mirror = true;
      setRotation(Shape84, 0F, 0F, 0F);
      Shape83 = new ModelRenderer(this, 42, 31);
      Shape83.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape83.setRotationPoint(6F, 12F, 1F);
      Shape83.setTextureSize(64, 64);
      Shape83.mirror = true;
      setRotation(Shape83, 0F, 0F, 0F);
      Shape76 = new ModelRenderer(this, 47, 23);
      Shape76.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape76.setRotationPoint(3F, 12F, -1F);
      Shape76.setTextureSize(64, 64);
      Shape76.mirror = true;
      setRotation(Shape76, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape90.render(f5);
    Shape22.render(f5);
    Shape29.render(f5);
    Shape19.render(f5);
    Shape20.render(f5);
    Shape48.render(f5);
    Shape21.render(f5);
    Shape23.render(f5);
    Shape25.render(f5);
    Shape26.render(f5);
    Shape27.render(f5);
    Shape24.render(f5);
    Shape28.render(f5);
    Shape30.render(f5);
    Shape32.render(f5);
    Shape35.render(f5);
    Shape33.render(f5);
    Shape31.render(f5);
    Shape34.render(f5);
    Shape36.render(f5);
    Shape39.render(f5);
    Shape49.render(f5);
    Shape38.render(f5);
    Shape40.render(f5);
    Shape41.render(f5);
    Shape37.render(f5);
    Shape42.render(f5);
    Shape43.render(f5);
    Shape46.render(f5);
    Shape45.render(f5);
    Shape44.render(f5);
    Shape52.render(f5);
    Shape47.render(f5);
    Shape51.render(f5);
    Shape50.render(f5);
    Shape59.render(f5);
    Shape53.render(f5);
    Shape55.render(f5);
    Shape56.render(f5);
    Shape54.render(f5);
    Shape57.render(f5);
    Shape58.render(f5);
    Shape60.render(f5);
    Shape69.render(f5);
    Shape61.render(f5);
    Shape67.render(f5);
    Shape63.render(f5);
    Shape65.render(f5);
    Shape66.render(f5);
    Shape62.render(f5);
    Shape68.render(f5);
    Shape64.render(f5);
    Shape70.render(f5);
    Shape71.render(f5);
    Shape74.render(f5);
    Shape73.render(f5);
    Shape75.render(f5);
    Shape72.render(f5);
    Shape79.render(f5);
    Shape77.render(f5);
    Shape78.render(f5);
    Shape81.render(f5);
    Shape80.render(f5);
    Shape82.render(f5);
    Shape11.render(f5);
    Shape10.render(f5);
    Shape1.render(f5);
    Shape13.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape9.render(f5);
    Shape5.render(f5);
    Shape8.render(f5);
    Shape14.render(f5);
    Shape15.render(f5);
    Shape7.render(f5);
    Shape6.render(f5);
    Shape16.render(f5);
    Shape17.render(f5);
    Shape18.render(f5);
    Shape4.render(f5);
    Shape12.render(f5);
    Shape84.render(f5);
    Shape83.render(f5);
    Shape76.render(f5);
  }
  
  public void renderModel(float f5) {
	  Shape90.render(f5);
	    Shape22.render(f5);
	    Shape29.render(f5);
	    Shape19.render(f5);
	    Shape20.render(f5);
	    Shape48.render(f5);
	    Shape21.render(f5);
	    Shape23.render(f5);
	    Shape25.render(f5);
	    Shape26.render(f5);
	    Shape27.render(f5);
	    Shape24.render(f5);
	    Shape28.render(f5);
	    Shape30.render(f5);
	    Shape32.render(f5);
	    Shape35.render(f5);
	    Shape33.render(f5);
	    Shape31.render(f5);
	    Shape34.render(f5);
	    Shape36.render(f5);
	    Shape39.render(f5);
	    Shape49.render(f5);
	    Shape38.render(f5);
	    Shape40.render(f5);
	    Shape41.render(f5);
	    Shape37.render(f5);
	    Shape42.render(f5);
	    Shape43.render(f5);
	    Shape46.render(f5);
	    Shape45.render(f5);
	    Shape44.render(f5);
	    Shape52.render(f5);
	    Shape47.render(f5);
	    Shape51.render(f5);
	    Shape50.render(f5);
	    Shape59.render(f5);
	    Shape53.render(f5);
	    Shape55.render(f5);
	    Shape56.render(f5);
	    Shape54.render(f5);
	    Shape57.render(f5);
	    Shape58.render(f5);
	    Shape60.render(f5);
	    Shape69.render(f5);
	    Shape61.render(f5);
	    Shape67.render(f5);
	    Shape63.render(f5);
	    Shape65.render(f5);
	    Shape66.render(f5);
	    Shape62.render(f5);
	    Shape68.render(f5);
	    Shape64.render(f5);
	    Shape70.render(f5);
	    Shape71.render(f5);
	    Shape74.render(f5);
	    Shape73.render(f5);
	    Shape75.render(f5);
	    Shape72.render(f5);
	    Shape79.render(f5);
	    Shape77.render(f5);
	    Shape78.render(f5);
	    Shape81.render(f5);
	    Shape80.render(f5);
	    Shape82.render(f5);
	    Shape11.render(f5);
	    Shape10.render(f5);
	    Shape1.render(f5);
	    Shape13.render(f5);
	    Shape2.render(f5);
	    Shape3.render(f5);
	    Shape9.render(f5);
	    Shape5.render(f5);
	    Shape8.render(f5);
	    Shape14.render(f5);
	    Shape15.render(f5);
	    Shape7.render(f5);
	    Shape6.render(f5);
	    Shape16.render(f5);
	    Shape17.render(f5);
	    Shape18.render(f5);
	    Shape4.render(f5);
	    Shape12.render(f5);
	    Shape84.render(f5);
	    Shape83.render(f5);
	    Shape76.render(f5);
	}
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
  }


}
