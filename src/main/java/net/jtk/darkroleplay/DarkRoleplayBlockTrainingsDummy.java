package net.jtk.darkroleplay;

import java.util.List;

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

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
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

public class DarkRoleplayBlockTrainingsDummy extends BlockContainer {

	public static Block blockTrainingsDummy;

	public static Object instance;

	public static PropertyInteger DIR = PropertyInteger.create("dir", 0, 15);
	
	public DarkRoleplayBlockTrainingsDummy() {
		super(Material.wood);
		this.setBlockBounds(1.0F / 16F * 0F, 0.0F, 1.0F / 16F * 0F,1.0F / 16F * 16F, 1.0F / 16F * 32F, 1.0F / 16F * 16F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DIR, Integer.valueOf(0)));
	}

	static {

		blockTrainingsDummy = new DarkRoleplayBlockTrainingsDummy().setHardness(2.0F)
				.setResistance(10.0F).setLightLevel(0.0F)
				.setUnlocalizedName("blockTrainingsDummy")
				.setStepSound(Block.soundTypeCloth)
				.setCreativeTab(DarkRoleplayTabs.drBlocksTab);
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
  
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
		EntityPlayer entity =  (EntityPlayer) placer;
		if(entity!=null){int i = MathHelper.floor_double((double)(entity.rotationYaw * 16.0F / 360.0F) + 0.5D) & 15;
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
		return new TileEntityCustomTrainingsDummy();
	}

	public static void serverLoad(FMLServerStartingEvent event) {
	}

	public static void Init(FMLInitializationEvent event){
		GameRegistry.addRecipe(new ItemStack(DarkRoleplayBlockTrainingsDummy.blockTrainingsDummy, 1), " X ", "ZXZ", " Z ", 'X', Blocks.hay_block, 'Z', Items.stick);
	}
	
	public static void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerBlock(blockTrainingsDummy, "blockTrainingsDummy");
		GameRegistry.registerTileEntity(TileEntityCustomTrainingsDummy.class, "TileEntityTrainingsDummy");
	}
}

class TileEntityCustomTrainingsDummy extends TileEntity {
}

class customRendererTrainingsDummy extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockTrainingsDummy.png");

	private ModelTrainingsDummy model;

	public customRendererTrainingsDummy() {
		this.model = new ModelTrainingsDummy();
	}
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f, int i) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		PropertyInteger DIR = PropertyInteger.create("dir", 0, 15);
		IBlockState state = tileentity.getWorld().getBlockState(tileentity.getPos());
		int facing = (((Integer) state.getValue(DIR)).intValue());
		GL11.glRotatef((facing -4)* 22.5F, 0.0F, 1.0F, 0.0F); 
		this.bindTexture(texture);
		
		this.model.renderModel(0.0625F);

		GL11.glPopMatrix();
	}

}

class ModelTrainingsDummy extends ModelBase {
	 //fields
    ModelRenderer Head;
    ModelRenderer Leg;
    ModelRenderer Body7;
    ModelRenderer Head2;
    ModelRenderer Body20;
    ModelRenderer Arms;
    ModelRenderer Body12;
    ModelRenderer Body2;
    ModelRenderer Body9;
    ModelRenderer Body4;
    ModelRenderer Body1;
    ModelRenderer Body10;
    ModelRenderer Body6;
    ModelRenderer Body3;
    ModelRenderer Body8;
    ModelRenderer Head4;
    ModelRenderer Head3;
    ModelRenderer Head1;
    ModelRenderer Head6;
    ModelRenderer Head5;
    ModelRenderer Body11;
    ModelRenderer Body;
  
  public ModelTrainingsDummy()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Head = new ModelRenderer(this, 0, 0);
      Head.addBox(0F, 0F, 0F, 6, 6, 6);
      Head.setRotationPoint(-3F, -8F, -3F);
      Head.setTextureSize(64, 64);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Leg = new ModelRenderer(this, 0, 37);
      Leg.addBox(0F, 0F, 0F, 2, 25, 2);
      Leg.setRotationPoint(-1F, -1F, -1F);
      Leg.setTextureSize(64, 64);
      Leg.mirror = true;
      setRotation(Leg, 0F, 0F, 0F);
      Body7 = new ModelRenderer(this, 50, 14);
      Body7.addBox(0F, 0F, 0F, 1, 1, 6);
      Body7.setRotationPoint(1.5F, 10.5F, -3F);
      Body7.setTextureSize(64, 64);
      Body7.mirror = true;
      setRotation(Body7, 0F, 0F, 0F);
      Head2 = new ModelRenderer(this, 0, 12);
      Head2.addBox(0F, 0F, 0F, 6, 1, 6);
      Head2.setRotationPoint(-3F, -9F, -3F);
      Head2.setTextureSize(64, 64);
      Head2.mirror = true;
      setRotation(Head2, 0F, 0F, 0F);
      Body20 = new ModelRenderer(this, 14, 46);
      Body20.addBox(0F, 0F, 0F, 1, 10, 6);
      Body20.setRotationPoint(2F, 1F, -3F);
      Body20.setTextureSize(64, 64);
      Body20.mirror = true;
      setRotation(Body20, 0F, 0F, 0F);
      Arms = new ModelRenderer(this, 8, 42);
      Arms.addBox(0F, 0F, 0F, 2, 2, 20);
      Arms.setRotationPoint(-1F, 2F, -10F);
      Arms.setTextureSize(64, 64);
      Arms.mirror = true;
      setRotation(Arms, 0F, 0F, 0F);
      Body12 = new ModelRenderer(this, 52, 53);
      Body12.addBox(0F, 0F, 0F, 3, 10, 1);
      Body12.setRotationPoint(-1.5F, 1F, 3F);
      Body12.setTextureSize(64, 64);
      Body12.mirror = true;
      setRotation(Body12, 0F, 0F, 0F);
      Body2 = new ModelRenderer(this, 44, 51);
      Body2.addBox(0F, 0F, 0F, 1, 10, 1);
      Body2.setRotationPoint(-2.5F, 1F, -3.5F);
      Body2.setTextureSize(64, 64);
      Body2.mirror = true;
      setRotation(Body2, 0F, 0F, 0F);
      Body9 = new ModelRenderer(this, 60, 53);
      Body9.addBox(0F, 0F, 0F, 1, 10, 1);
      Body9.setRotationPoint(1.5F, 1F, -3.5F);
      Body9.setTextureSize(64, 64);
      Body9.mirror = true;
      setRotation(Body9, 0F, 0F, 0F);
      Body4 = new ModelRenderer(this, 50, 28);
      Body4.addBox(0F, 0F, 0F, 1, 1, 6);
      Body4.setRotationPoint(-2.5F, 10.5F, -3F);
      Body4.setTextureSize(64, 64);
      Body4.mirror = true;
      setRotation(Body4, 0F, 0F, 0F);
      Body1 = new ModelRenderer(this, 48, 51);
      Body1.addBox(0F, 0F, 0F, 1, 10, 1);
      Body1.setRotationPoint(-2.5F, 1F, 2.5F);
      Body1.setTextureSize(64, 64);
      Body1.mirror = true;
      setRotation(Body1, 0F, 0F, 0F);
      Body10 = new ModelRenderer(this, 14, 26);
      Body10.addBox(0F, 0F, 0F, 1, 10, 6);
      Body10.setRotationPoint(-3F, 1F, -3F);
      Body10.setTextureSize(64, 64);
      Body10.mirror = true;
      setRotation(Body10, 0F, 0F, 0F);
      Body6 = new ModelRenderer(this, 50, 21);
      Body6.addBox(0F, 0F, 0F, 1, 1, 6);
      Body6.setRotationPoint(1.5F, 0.5F, -3F);
      Body6.setTextureSize(64, 64);
      Body6.mirror = true;
      setRotation(Body6, 0F, 0F, 0F);
      Body3 = new ModelRenderer(this, 50, 35);
      Body3.addBox(0F, 0F, 0F, 1, 1, 6);
      Body3.setRotationPoint(-2.5F, 0.5F, -3F);
      Body3.setTextureSize(64, 64);
      Body3.mirror = true;
      setRotation(Body3, 0F, 0F, 0F);
      Body8 = new ModelRenderer(this, 60, 42);
      Body8.addBox(0F, 0F, 0F, 1, 10, 1);
      Body8.setRotationPoint(1.5F, 1F, 2.5F);
      Body8.setTextureSize(64, 64);
      Body8.mirror = true;
      setRotation(Body8, 0F, 0F, 0F);
      Head4 = new ModelRenderer(this, 14, 19);
      Head4.addBox(0F, 0F, 0F, 6, 6, 1);
      Head4.setRotationPoint(-3F, -8F, 3F);
      Head4.setTextureSize(64, 64);
      Head4.mirror = true;
      setRotation(Head4, 0F, 0F, 0F);
      Head3 = new ModelRenderer(this, 0, 19);
      Head3.addBox(0F, 0F, 0F, 6, 6, 1);
      Head3.setRotationPoint(-3F, -8F, -4F);
      Head3.setTextureSize(64, 64);
      Head3.mirror = true;
      setRotation(Head3, 0F, 0F, 0F);
      Head1 = new ModelRenderer(this, 24, 12);
      Head1.addBox(0F, 0F, 0F, 6, 1, 6);
      Head1.setRotationPoint(-3F, -2F, -3F);
      Head1.setTextureSize(64, 64);
      Head1.mirror = true;
      setRotation(Head1, 0F, 0F, 0F);
      Head6 = new ModelRenderer(this, 24, 0);
      Head6.addBox(0F, 0F, 0F, 1, 6, 6);
      Head6.setRotationPoint(3F, -8F, -3F);
      Head6.setTextureSize(64, 64);
      Head6.mirror = true;
      setRotation(Head6, 0F, 0F, 0F);
      Head5 = new ModelRenderer(this, 50, 0);
      Head5.addBox(0F, 0F, 0F, 1, 6, 6);
      Head5.setRotationPoint(-4F, -8F, -3F);
      Head5.setTextureSize(64, 64);
      Head5.mirror = true;
      setRotation(Head5, 0F, 0F, 0F);
      Body11 = new ModelRenderer(this, 52, 42);
      Body11.addBox(0F, 0F, 0F, 3, 10, 1);
      Body11.setRotationPoint(-1.5F, 1F, -4F);
      Body11.setTextureSize(64, 64);
      Body11.mirror = true;
      setRotation(Body11, 0F, 0F, 0F);
      Body = new ModelRenderer(this, 28, 23);
      Body.addBox(0F, 0F, 0F, 4, 12, 7);
      Body.setRotationPoint(-2F, 0F, -3.5F);
      Body.setTextureSize(64, 64);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    Head.render(f5);
    Leg.render(f5);
    Body7.render(f5);
    Head2.render(f5);
    Body20.render(f5);
    Arms.render(f5);
    Body12.render(f5);
    Body2.render(f5);
    Body9.render(f5);
    Body4.render(f5);
    Body1.render(f5);
    Body10.render(f5);
    Body6.render(f5);
    Body3.render(f5);
    Body8.render(f5);
    Head4.render(f5);
    Head3.render(f5);
    Head1.render(f5);
    Head6.render(f5);
    Head5.render(f5);
    Body11.render(f5);
    Body.render(f5);
  }
  
  public void renderModel(float f5){
	  Head.render(f5);
	    Leg.render(f5);
	    Body7.render(f5);
	    Head2.render(f5);
	    Body20.render(f5);
	    Arms.render(f5);
	    Body12.render(f5);
	    Body2.render(f5);
	    Body9.render(f5);
	    Body4.render(f5);
	    Body1.render(f5);
	    Body10.render(f5);
	    Body6.render(f5);
	    Body3.render(f5);
	    Body8.render(f5);
	    Head4.render(f5);
	    Head3.render(f5);
	    Head1.render(f5);
	    Head6.render(f5);
	    Head5.render(f5);
	    Body11.render(f5);
	    Body.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
  }


}
