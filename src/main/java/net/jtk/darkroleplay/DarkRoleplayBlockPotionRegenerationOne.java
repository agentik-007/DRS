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


public class DarkRoleplayBlockPotionRegenerationOne extends BlockContainer {

	public static Block blockPotionRegenerationOne;

	public static Object instance;

	public static PropertyInteger DIR = PropertyInteger.create("dir", 0, 15);
	
	public DarkRoleplayBlockPotionRegenerationOne() {
		super(Material.wood);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DIR, Integer.valueOf(0)));
	}

	static {

		blockPotionRegenerationOne = new DarkRoleplayBlockPotionRegenerationOne().setHardness(2.0F)
				.setResistance(10.0F).setLightLevel(0.0F)
				.setUnlocalizedName("blockPotionRegenerationOne")
				.setStepSound(Block.soundTypeGlass)
				.setCreativeTab(DarkRoleplayTabs.drBlocksTab);
				blockPotionRegenerationOne.setBlockBounds(1.0F / 16F * 5F, 0.0F, 1.0F / 16F * 5F,1.0F / 16F * 11F, 1.0F / 16F * 9F, 1.0F / 16F * 11F);
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
		return new TileEntityCustomPotionRegenerationOne();
	}

	public static void serverLoad(FMLServerStartingEvent event) {
	}

	public static void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerBlock(blockPotionRegenerationOne, "blockPotionRegenerationOne");
		GameRegistry.registerTileEntity(TileEntityCustomPotionRegenerationOne.class, "TileEntityPotionRegenerationOne");
	}
}

class TileEntityCustomPotionRegenerationOne extends TileEntity {
}



class customRendererPotionRegenerationOne extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockPotionRegenerationOne.png");

	private ModelPotionRegenerationOne model;

	public customRendererPotionRegenerationOne() {
		this.model = new ModelPotionRegenerationOne();
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
		GL11.glRotatef(facing * 45, 0.0F, 1.0F, 0.0F); 
		this.bindTexture(texture);

		GL11.glEnable(GL11.GL_BLEND);
		this.model.renderModel(0.0625F);

		GL11.glPopMatrix();
	}

}

class ModelPotionRegenerationOne extends ModelBase {
	 //fields
    ModelRenderer Potion5;
    ModelRenderer Potion6;
    ModelRenderer Potion4;
    ModelRenderer Potion3;
    ModelRenderer Potion1;
    ModelRenderer Potion2;
  
  public ModelPotionRegenerationOne()
  {
    textureWidth = 32;
    textureHeight = 32;
      Potion5 = new ModelRenderer(this, 0, 0);
      Potion5.addBox(0F, 0F, 0F, 5, 5, 5);
      Potion5.setRotationPoint(-2.5F, 19F, -2.5F);
      Potion5.setTextureSize(32, 32);
      Potion5.mirror = true;
      setRotation(Potion5, 0F, 0F, 0F);
      Potion6 = new ModelRenderer(this, 0, 24);
      Potion6.addBox(0F, 0F, 0F, 4, 4, 4);
      Potion6.setRotationPoint(-2F, 19.5F, -2F);
      Potion6.setTextureSize(32, 32);
      Potion6.mirror = true;
      setRotation(Potion6, 0F, 0F, 0F);
      Potion4 = new ModelRenderer(this, 0, 10);
      Potion4.addBox(0F, 0F, 0F, 3, 1, 3);
      Potion4.setRotationPoint(-1.5F, 18.5F, -1.5F);
      Potion4.setTextureSize(32, 32);
      Potion4.mirror = true;
      setRotation(Potion4, 0F, 0F, 0F);
      Potion3 = new ModelRenderer(this, 0, 22);
      Potion3.addBox(0F, 0F, 0F, 1, 2, 1);
      Potion3.setRotationPoint(-0.5F, 15F, -0.5F);
      Potion3.setTextureSize(32, 32);
      Potion3.mirror = true;
      setRotation(Potion3, 0F, 0F, 0F);
      Potion1 = new ModelRenderer(this, 0, 14);
      Potion1.addBox(0F, 0F, 0F, 3, 1, 3);
      Potion1.setRotationPoint(-1.5F, 15.5F, -1.5F);
      Potion1.setTextureSize(32, 32);
      Potion1.mirror = true;
      setRotation(Potion1, 0F, 0F, 0F);
      Potion2 = new ModelRenderer(this, 0, 18);
      Potion2.addBox(0F, 0F, 0F, 2, 2, 2);
      Potion2.setRotationPoint(-1F, 16.5F, -1F);
      Potion2.setTextureSize(32, 32);
      Potion2.mirror = true;
      setRotation(Potion2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    Potion5.render(f5);
    Potion6.render(f5);
    Potion4.render(f5);
    Potion3.render(f5);
    Potion1.render(f5);
    Potion2.render(f5);
  }
  
  public void renderModel(float f5){
	  Potion5.render(f5);
	    Potion6.render(f5);
	    Potion4.render(f5);
	    Potion3.render(f5);
	    Potion1.render(f5);
	    Potion2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
