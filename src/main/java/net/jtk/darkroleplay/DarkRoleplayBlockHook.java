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

public class DarkRoleplayBlockHook extends BlockContainer {

	public static Block blockHook;

	public static Object instance;

	public static PropertyInteger DIR = PropertyInteger.create("dir", 0, 15);
	
	public DarkRoleplayBlockHook() {
		super(Material.wood);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DIR, Integer.valueOf(0)));
	}

	static {

		blockHook = new DarkRoleplayBlockHook().setHardness(2.0F)
				.setResistance(10.0F).setLightLevel(0.0F)
				.setUnlocalizedName("blockHook")
				.setStepSound(Block.soundTypeMetal)
				.setCreativeTab(DarkRoleplayTabs.drBlocksTab);
		blockHook.setBlockBounds(1.0F / 16F * 5F, 1.0F/16F * 5F, 1.0F / 16F * 5F,1.0F / 16F * 11F, 1.0F / 16F * 16F, 1.0F / 16F * 11F);
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
		return new TileEntityCustomHook();
	}

	public static void serverLoad(FMLServerStartingEvent event) {
	}

	public static void Init(FMLInitializationEvent event){
		GameRegistry.addRecipe(new ItemStack(DarkRoleplayBlockHook.blockHook, 1), "   ", " X ", " Z ", 'X', Items.iron_ingot, 'Z', Blocks.tripwire_hook);
	}
	
	public static void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerBlock(blockHook, "blockHook");
		GameRegistry.registerTileEntity(TileEntityCustomHook.class, "TileEntityHook");
	}
}

class TileEntityCustomHook extends TileEntity {
}


class customRendererHook extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockHook.png");

	private ModelHook model;

	public customRendererHook() {
		this.model = new ModelHook();
	}
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f, int i) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 0.3F, (float) z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		PropertyInteger DIR = PropertyInteger.create("dir", 0, 15);
		IBlockState state = tileentity.getWorld().getBlockState(tileentity.getPos());
		int facing = (((Integer) state.getValue(DIR)).intValue());
		GL11.glRotatef((facing+1) * 90, 0.0F, 1.0F, 0.0F);
		this.bindTexture(texture);

		this.model.renderModel(0.0625F);

		GL11.glPopMatrix();
	}

}

class ModelHook extends ModelBase {
	  //fields
    ModelRenderer Hook1;
    ModelRenderer Hook3;
    ModelRenderer Hook4;
    ModelRenderer Hook5;
    ModelRenderer Hook6;
    ModelRenderer Hook7;
    ModelRenderer Hook8;
    ModelRenderer Hook9;
    ModelRenderer Hook10;
    ModelRenderer Hook11;
    ModelRenderer Chain1;
    ModelRenderer Chain2;
  
  public ModelHook()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      Hook1 = new ModelRenderer(this, 4, 30);
      Hook1.addBox(0F, 0F, 0F, 2, 1, 1);
      Hook1.setRotationPoint(-0.5F, -1.5F, -0.5F);
      Hook1.setTextureSize(64, 32);
      Hook1.mirror = true;
      setRotation(Hook1, 0F, 0F, 0F);
      Hook3 = new ModelRenderer(this, 0, 28);
      Hook3.addBox(0F, 0F, 0F, 1, 1, 1);
      Hook3.setRotationPoint(1.5F, -2.5F, -0.5F);
      Hook3.setTextureSize(64, 32);
      Hook3.mirror = true;
      setRotation(Hook3, 0F, 0F, 0F);
      Hook4 = new ModelRenderer(this, 0, 30);
      Hook4.addBox(0F, 0F, 0F, 1, 1, 1);
      Hook4.setRotationPoint(1.7F, -2F, -0.5F);
      Hook4.setTextureSize(64, 32);
      Hook4.mirror = true;
      setRotation(Hook4, 0F, 0F, 0.7853982F);
      Hook5 = new ModelRenderer(this, 10, 26);
      Hook5.addBox(0F, 0F, 0F, 1, 3, 1);
      Hook5.setRotationPoint(-1.5F, -4.5F, -0.5F);
      Hook5.setTextureSize(64, 32);
      Hook5.mirror = true;
      setRotation(Hook5, 0F, 0F, 0F);
      Hook6 = new ModelRenderer(this, 6, 18);
      Hook6.addBox(0F, 0F, 0F, 2, 1, 2);
      Hook6.setRotationPoint(-0.8F, -8.6F, -1F);
      Hook6.setTextureSize(64, 32);
      Hook6.mirror = true;
      setRotation(Hook6, 0F, 0F, 0F);
      Hook7 = new ModelRenderer(this, 8, 21);
      Hook7.addBox(0F, 0F, 0F, 1, 2, 1);
      Hook7.setRotationPoint(-0.2F, -7.6F, -0.5F);
      Hook7.setTextureSize(64, 32);
      Hook7.mirror = true;
      setRotation(Hook7, 0F, 0F, 0F);
      Hook8 = new ModelRenderer(this, 8, 24);
      Hook8.addBox(0F, 0F, 0F, 2, 1, 1);
      Hook8.setRotationPoint(-1.4F, -4.7F, -0.5F);
      Hook8.setTextureSize(64, 32);
      Hook8.mirror = true;
      setRotation(Hook8, 0F, 0F, -0.7853982F);
      Hook9 = new ModelRenderer(this, 10, 30);
      Hook9.addBox(0F, 0F, 0F, 1, 1, 1);
      Hook9.setRotationPoint(-0.7F, -2F, -0.5F);
      Hook9.setTextureSize(64, 32);
      Hook9.mirror = true;
      setRotation(Hook9, 0F, 0F, 0.7853982F);
      Hook10 = new ModelRenderer(this, 0, 6);
      Hook10.addBox(0F, 0F, 0F, 5, 1, 5);
      Hook10.setRotationPoint(-2.4F, -9.6F, -2.5F);
      Hook10.setTextureSize(64, 32);
      Hook10.mirror = true;
      setRotation(Hook10, 0F, 0F, 0F);
      Hook11 = new ModelRenderer(this, 2, 12);
      Hook11.addBox(0F, 0F, 0F, 4, 2, 4);
      Hook11.setRotationPoint(-1.8F, -10.1F, -2F);
      Hook11.setTextureSize(64, 32);
      Hook11.mirror = true;
      setRotation(Hook11, 0F, 0F, 0F);
      Chain1 = new ModelRenderer(this, 5, 4);
      Chain1.addBox(0F, 0F, 0F, 1, 1, 1);
      Chain1.setRotationPoint(0.8F, -10.6F, 0F);
      Chain1.setTextureSize(64, 32);
      Chain1.mirror = true;
      setRotation(Chain1, 0F, 0.7853982F, 0F);
      Chain2 = new ModelRenderer(this, 11, 4);
      Chain2.addBox(0F, 0F, 0F, 1, 1, 1);
      Chain2.setRotationPoint(-2.2F, -10.6F, 0F);
      Chain2.setTextureSize(64, 32);
      Chain2.mirror = true;
      setRotation(Chain2, 0F, 0.7853982F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Hook1.render(f5);
    Hook3.render(f5);
    Hook4.render(f5);
    Hook5.render(f5);
    Hook6.render(f5);
    Hook7.render(f5);
    Hook8.render(f5);
    Hook9.render(f5);
    Hook10.render(f5);
    Hook11.render(f5);
    Chain1.render(f5);
    Chain2.render(f5);
  }
  
  public void renderModel(float f5) {
	  Hook1.render(f5);
	    Hook3.render(f5);
	    Hook4.render(f5);
	    Hook5.render(f5);
	    Hook6.render(f5);
	    Hook7.render(f5);
	    Hook8.render(f5);
	    Hook9.render(f5);
	    Hook10.render(f5);
	    Hook11.render(f5);
	    Chain1.render(f5);
	    Chain2.render(f5);
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
