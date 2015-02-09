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

public class DarkRoleplayBlockMugEmpty extends BlockContainer {

	public static Block blockMugEmpty;

	public static Object instance;
	
	public static PropertyInteger DIR = PropertyInteger.create("dir", 0, 15);

	public DarkRoleplayBlockMugEmpty() {
		super(Material.wood);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DIR, Integer.valueOf(0)));
	}

	static {

		blockMugEmpty = new DarkRoleplayBlockMugEmpty().setHardness(2.0F)
				.setResistance(10.0F).setLightLevel(0.0F)
				.setUnlocalizedName("blockMugEmpty")
				.setStepSound(Block.soundTypeWood)
				.setCreativeTab(DarkRoleplayTabs.drBlocksTab);
		blockMugEmpty.setBlockBounds(1.0F / 16F * 5F, 0.0F, 1.0F / 16F * 5F,1.0F / 16F * 11F, 1.0F / 16F * 7F, 1.0F / 16F * 11F);
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
		if(entity!=null){int i = MathHelper.floor_double((double)(entity.rotationYaw * 8.0F / 360.0F) + 0.5D) & 7;
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
		return new TileEntityCustomMugEmpty();
	}

	public static void serverLoad(FMLServerStartingEvent event) {
	}

	public static void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerBlock(blockMugEmpty, "blockMugEmpty");
		GameRegistry.registerTileEntity(TileEntityCustomMugEmpty.class, "TileEntityMugEmpty");
	}
}

class TileEntityCustomMugEmpty extends TileEntity {
}

class ItemRendererBlockMugEmpty implements IItemRenderer {

	private ModelMugEmpty model;

	public ItemRendererBlockMugEmpty() {
		model = new ModelMugEmpty();
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
		TileEntityRendererDispatcher.instance.renderTileEntityAt(
				new TileEntityCustomMugEmpty(), 0.0D, 0.0D, 0.0D, 0.0F);
	}

}

class customRendererMugEmpty extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockMugEmpty.png");

	private ModelMugEmpty model;

	public customRendererMugEmpty() {
		this.model = new ModelMugEmpty();
	}

	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f, int i) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		PropertyInteger DIR = PropertyInteger.create("dir", 0, 15);
		IBlockState state = tileentity.getWorld().getBlockState(tileentity.getPos());
		int facing = (((Integer) state.getValue(DIR)).intValue());
		GL11.glRotatef((facing +2) * 45, 0.0F, 1.0F, 0.0F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		this.model.renderModel(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}

class ModelMugEmpty extends ModelBase {
	//fields
    ModelRenderer Mug1;
    ModelRenderer Mug2;
    ModelRenderer Mug3;
    ModelRenderer Mug4;
    ModelRenderer Mug5;
    ModelRenderer Mug6;
    ModelRenderer Mug7;
    ModelRenderer Mug8;
    ModelRenderer Mug9;
    ModelRenderer Mug10;
    ModelRenderer Mug11;
    ModelRenderer Mug12;
    ModelRenderer Mug13;
  
  public ModelMugEmpty()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      Mug1 = new ModelRenderer(this, 12, 0);
      Mug1.addBox(0F, 0F, 0F, 1, 7, 3);
      Mug1.setRotationPoint(-3F, 17F, -2F);
      Mug1.setTextureSize(32, 32);
      Mug1.mirror = true;
      setRotation(Mug1, 0F, 0F, 0F);
      Mug2 = new ModelRenderer(this, 0, 23);
      Mug2.addBox(0F, 0F, 0F, 3, 1, 3);
      Mug2.setRotationPoint(-2F, 23F, -2F);
      Mug2.setTextureSize(32, 32);
      Mug2.mirror = true;
      setRotation(Mug2, 0F, 0F, 0F);
      Mug3 = new ModelRenderer(this, 22, 0);
      Mug3.addBox(0F, 0F, 0F, 1, 7, 3);
      Mug3.setRotationPoint(1F, 17F, -2F);
      Mug3.setTextureSize(32, 32);
      Mug3.mirror = true;
      setRotation(Mug3, 0F, 0F, 0F);
      Mug4 = new ModelRenderer(this, 22, 11);
      Mug4.addBox(0F, 0F, 0F, 1, 7, 3);
      Mug4.setRotationPoint(-2F, 17F, -2F);
      Mug4.setTextureSize(32, 32);
      Mug4.mirror = true;
      setRotation(Mug4, 0F, 1.570796F, 0F);
      Mug5 = new ModelRenderer(this, 12, 11);
      Mug5.addBox(0F, 0F, 0F, 1, 7, 3);
      Mug5.setRotationPoint(-2F, 17F, 2F);
      Mug5.setTextureSize(32, 32);
      Mug5.mirror = true;
      setRotation(Mug5, 0F, 1.570796F, 0F);
      Mug6 = new ModelRenderer(this, 12, 24);
      Mug6.addBox(0F, 0F, 0F, 1, 3, 1);
      Mug6.setRotationPoint(-1F, 18.2F, 3F);
      Mug6.setTextureSize(32, 32);
      Mug6.mirror = true;
      setRotation(Mug6, 0.7063936F, 0F, 0F);
      Mug7 = new ModelRenderer(this, 12, 28);
      Mug7.addBox(0F, 0F, 0F, 1, 1, 3);
      Mug7.setRotationPoint(-1F, 18.4F, 1F);
      Mug7.setTextureSize(32, 32);
      Mug7.mirror = true;
      setRotation(Mug7, 0.4461433F, 0F, 0F);
      Mug8 = new ModelRenderer(this, 20, 27);
      Mug8.addBox(0F, 0F, 0F, 1, 1, 4);
      Mug8.setRotationPoint(-1F, 23F, 3F);
      Mug8.setTextureSize(32, 32);
      Mug8.mirror = true;
      setRotation(Mug8, 1.115358F, 0F, 0F);
      Mug9 = new ModelRenderer(this, 0, 7);
      Mug9.addBox(0F, 0F, 0F, 1, 7, 1);
      Mug9.setRotationPoint(0.5F, 17F, -2.2F);
      Mug9.setTextureSize(32, 32);
      Mug9.mirror = true;
      setRotation(Mug9, 0F, 0.7853982F, 0F);
      Mug10 = new ModelRenderer(this, 0, 15);
      Mug10.addBox(0F, 0F, 0F, 1, 7, 1);
      Mug10.setRotationPoint(0.5F, 17F, 1.2F);
      Mug10.setTextureSize(32, 32);
      Mug10.mirror = true;
      setRotation(Mug10, 0F, 0.7853982F, 0F);
      Mug11 = new ModelRenderer(this, 4, 15);
      Mug11.addBox(0F, 0F, 0F, 1, 7, 1);
      Mug11.setRotationPoint(-2.9F, 17F, -2.2F);
      Mug11.setTextureSize(32, 32);
      Mug11.mirror = true;
      setRotation(Mug11, 0F, 0.7853982F, 0F);
      Mug12 = new ModelRenderer(this, 4, 7);
      Mug12.addBox(0F, 0F, 0F, 1, 7, 1);
      Mug12.setRotationPoint(-2.9F, 17F, 1.2F);
      Mug12.setTextureSize(32, 32);
      Mug12.mirror = true;
      setRotation(Mug12, 0F, 0.7853982F, 0F);
      Mug13 = new ModelRenderer(this, 16, 24);
      Mug13.addBox(0F, 0F, 0F, 1, 1, 2);
      Mug13.setRotationPoint(-1F, 22F, 2F);
      Mug13.setTextureSize(32, 32);
      Mug13.mirror = true;
      setRotation(Mug13, -0.2230717F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    Mug1.render(f5);
    Mug2.render(f5);
    Mug3.render(f5);
    Mug4.render(f5);
    Mug5.render(f5);
    Mug6.render(f5);
    Mug7.render(f5);
    Mug8.render(f5);
    Mug9.render(f5);
    Mug10.render(f5);
    Mug11.render(f5);
    Mug12.render(f5);
    Mug13.render(f5);
  }
  
  public void renderModel(float f5){
	  Mug1.render(f5);
	    Mug2.render(f5);
	    Mug3.render(f5);
	    Mug4.render(f5);
	    Mug5.render(f5);
	    Mug6.render(f5);
	    Mug7.render(f5);
	    Mug8.render(f5);
	    Mug9.render(f5);
	    Mug10.render(f5);
	    Mug11.render(f5);
	    Mug12.render(f5);
	    Mug13.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
