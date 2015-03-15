package net.jtk.darkroleplay;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DarkRoleplayBlockCauldronCookingOne extends BlockContainer {

	public static Block blockCauldronCookingOne;

	public static Object instance;

	public DarkRoleplayBlockCauldronCookingOne() {
		super(Material.wood);
	}

	static {

		blockCauldronCookingOne = new DarkRoleplayBlockCauldronCookingOne().setHardness(2.0F)
				.setResistance(10.0F).setLightLevel(0.0F)
				.setUnlocalizedName("blockCauldronCookingOne")
				.setStepSound(Block.soundTypeStone)
				.setCreativeTab(DarkRoleplayTabs.drBlocksTab);
				blockCauldronCookingOne.setBlockBounds(1.0F / 16F * 0F, 0.0F, 1.0F / 16F * 0F,1.0F / 16F * 16F, 1.0F / 16F * 16F, 1.0F / 16F * 16F);
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
	    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	    {
	    	if (worldIn.isRemote)
	        {
	    		return true;
	        }
	    	else
	    	{
	    		playerIn.addChatMessage(new ChatComponentTranslation("This Block doesn't has currently any Functions!"));
	   			playerIn.addChatMessage(new ChatComponentTranslation("But it is Work in Progress"));
	   			return true;
	    	}
	    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityCustomCauldronCookingOne();
	}

	public static void serverLoad(FMLServerStartingEvent event) {
	}

	public static void Init(FMLInitializationEvent event){
		GameRegistry.addRecipe(new ItemStack(DarkRoleplayBlockCauldronCookingOne.blockCauldronCookingOne , 1), "   ", " Z ", "BXB", 'X', DarkRoleplayBlockSmallFirepit.blockSmallFirepit, 'Z', DarkRoleplayBlockCauldron.blockCauldron, 'B', Items.iron_ingot);
	}
	
	public static void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerBlock(blockCauldronCookingOne, "blockCauldronCookingOne");
		GameRegistry.registerTileEntity(TileEntityCustomCauldronCookingOne.class, "TileEntityCauldronCookingOne");
	}
}

class TileEntityCustomCauldronCookingOne extends TileEntity {
}


class customRendererCauldronCookingOne extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockCauldronCookingOne.png");

	private ModelCauldronCookingOne model;

	public customRendererCauldronCookingOne() {
		this.model = new ModelCauldronCookingOne();
	}
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f, int i) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		GL11.glRotatef(tileentity.getBlockMetadata() * 90, 0.0F, 1.0F, 0.0F);
		this.bindTexture(texture);

		this.model.renderModel(0.0625F);

		GL11.glPopMatrix();
	}

}

class ModelCauldronCookingOne extends ModelBase {
	//fields
    ModelRenderer Cauldron1;
    ModelRenderer Cauldron2;
    ModelRenderer Cauldron3;
    ModelRenderer Cauldron4;
    ModelRenderer tripod1;
    ModelRenderer Cauldron6;
    ModelRenderer Cauldron7;
    ModelRenderer Cauldron8;
    ModelRenderer Cauldron9;
    ModelRenderer Ingerdient1;
    ModelRenderer Cauldron11;
    ModelRenderer Cauldron13;
    ModelRenderer Cauldron15;
    ModelRenderer Cauldron21;
    ModelRenderer Cauldron27;
    ModelRenderer Cauldron29;
    ModelRenderer Cauldron30;
    ModelRenderer Cauldron31;
    ModelRenderer Cauldron32;
    ModelRenderer Cauldron33;
    ModelRenderer Cauldron34;
    ModelRenderer Cauldron35;
    ModelRenderer Cauldron36;
    ModelRenderer Cauldron37;
    ModelRenderer Cauldron38;
    ModelRenderer Cauldron39;
    ModelRenderer Cauldron5;
    ModelRenderer tripod11;
    ModelRenderer tripod6;
    ModelRenderer tripod2;
    ModelRenderer tripod3;
    ModelRenderer tripod4;
    ModelRenderer tripod5;
    ModelRenderer tripod12;
    ModelRenderer tripod7;
    ModelRenderer tripod8;
    ModelRenderer tripod9;
    ModelRenderer tripod10;
    ModelRenderer Wood2;
    ModelRenderer Wood3;
    ModelRenderer Wood4;
    ModelRenderer Wood5;
    ModelRenderer Wood1;
    ModelRenderer Cauldron10;
    ModelRenderer Water;
    ModelRenderer Ingerdient2;
    ModelRenderer Ingerdient3;
    ModelRenderer Ingerdient4;
    ModelRenderer Ingerdient5;
  
  public ModelCauldronCookingOne()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Cauldron1 = new ModelRenderer(this, 80, 56);
      Cauldron1.addBox(0F, 0F, 0F, 8, 1, 1);
      Cauldron1.setRotationPoint(-4F, 7F, -6F);
      Cauldron1.setTextureSize(128, 64);
      Cauldron1.mirror = true;
      setRotation(Cauldron1, 0F, 0F, 0F);
      Cauldron2 = new ModelRenderer(this, 0, 30);
      Cauldron2.addBox(0F, 0F, 0F, 6, 6, 1);
      Cauldron2.setRotationPoint(-3F, 10F, -7F);
      Cauldron2.setTextureSize(128, 64);
      Cauldron2.mirror = true;
      setRotation(Cauldron2, 0F, 0F, 0F);
      Cauldron3 = new ModelRenderer(this, 40, 16);
      Cauldron3.addBox(0F, 0F, 0F, 1, 8, 10);
      Cauldron3.setRotationPoint(-6F, 9F, -5F);
      Cauldron3.setTextureSize(128, 64);
      Cauldron3.mirror = true;
      setRotation(Cauldron3, 0F, 0F, 0F);
      Cauldron4 = new ModelRenderer(this, 40, 4);
      Cauldron4.addBox(0F, 0F, 0F, 1, 6, 6);
      Cauldron4.setRotationPoint(-7F, 10F, -3F);
      Cauldron4.setTextureSize(128, 64);
      Cauldron4.mirror = true;
      setRotation(Cauldron4, 0F, 0F, 0F);
      tripod1 = new ModelRenderer(this, 62, 6);
      tripod1.addBox(0F, 0F, 0F, 1, 1, 10);
      tripod1.setRotationPoint(-6F, 17F, -5F);
      tripod1.setTextureSize(128, 64);
      tripod1.mirror = true;
      setRotation(tripod1, 0F, 0F, 0F);
      Cauldron6 = new ModelRenderer(this, 40, 34);
      Cauldron6.addBox(0F, 0F, 0F, 1, 6, 6);
      Cauldron6.setRotationPoint(6F, 10F, -3F);
      Cauldron6.setTextureSize(128, 64);
      Cauldron6.mirror = true;
      setRotation(Cauldron6, 0F, 0F, 0F);
      Cauldron7 = new ModelRenderer(this, 0, 14);
      Cauldron7.addBox(0F, 0F, 0F, 6, 6, 1);
      Cauldron7.setRotationPoint(-3F, 10F, 6F);
      Cauldron7.setTextureSize(128, 64);
      Cauldron7.mirror = true;
      setRotation(Cauldron7, 0F, 0F, 0F);
      Cauldron8 = new ModelRenderer(this, 40, 46);
      Cauldron8.addBox(0F, 0F, 0F, 1, 8, 10);
      Cauldron8.setRotationPoint(5F, 9F, -5F);
      Cauldron8.setTextureSize(128, 64);
      Cauldron8.mirror = true;
      setRotation(Cauldron8, 0F, 0F, 0F);
      Cauldron9 = new ModelRenderer(this, 32, 8);
      Cauldron9.addBox(0F, 0F, 0F, 1, 1, 1);
      Cauldron9.setRotationPoint(4F, 7F, -5F);
      Cauldron9.setTextureSize(128, 64);
      Cauldron9.mirror = true;
      setRotation(Cauldron9, 0F, 0F, 0F);
      Ingerdient1 = new ModelRenderer(this, 88, 40);
      Ingerdient1.addBox(0F, 0F, 0F, 1, 1, 1);
      Ingerdient1.setRotationPoint(-3F, 9.5F, 2F);
      Ingerdient1.setTextureSize(128, 64);
      Ingerdient1.mirror = true;
      setRotation(Ingerdient1, -1.394198F, -1.189716F, 0F);
      Cauldron11 = new ModelRenderer(this, 36, 8);
      Cauldron11.addBox(0F, 0F, 0F, 1, 1, 1);
      Cauldron11.setRotationPoint(-5F, 7F, -5F);
      Cauldron11.setTextureSize(128, 64);
      Cauldron11.mirror = true;
      setRotation(Cauldron11, 0F, 0F, 0F);
      Cauldron13 = new ModelRenderer(this, 0, 37);
      Cauldron13.addBox(0F, 0F, 0F, 10, 8, 1);
      Cauldron13.setRotationPoint(-5F, 9F, -6F);
      Cauldron13.setTextureSize(128, 64);
      Cauldron13.mirror = true;
      setRotation(Cauldron13, 0F, 0F, 0F);
      Cauldron15 = new ModelRenderer(this, 0, 21);
      Cauldron15.addBox(0F, 0F, 0F, 10, 8, 1);
      Cauldron15.setRotationPoint(-5F, 9F, 5F);
      Cauldron15.setTextureSize(128, 64);
      Cauldron15.mirror = true;
      setRotation(Cauldron15, 0F, 0F, 0F);
      Cauldron21 = new ModelRenderer(this, 62, 46);
      Cauldron21.addBox(0F, 0F, 0F, 1, 1, 8);
      Cauldron21.setRotationPoint(-6F, 7F, -4F);
      Cauldron21.setTextureSize(128, 64);
      Cauldron21.mirror = true;
      setRotation(Cauldron21, 0F, 0F, 0F);
      Cauldron27 = new ModelRenderer(this, 80, 58);
      Cauldron27.addBox(0F, 0F, 0F, 8, 1, 1);
      Cauldron27.setRotationPoint(-4F, 8F, -5F);
      Cauldron27.setTextureSize(128, 64);
      Cauldron27.mirror = true;
      setRotation(Cauldron27, 0F, 0F, 0F);
      Cauldron29 = new ModelRenderer(this, 0, 46);
      Cauldron29.addBox(0F, 0F, 0F, 10, 1, 10);
      Cauldron29.setRotationPoint(-5F, 17F, -5F);
      Cauldron29.setTextureSize(128, 64);
      Cauldron29.mirror = true;
      setRotation(Cauldron29, 0F, 0F, 0F);
      Cauldron30 = new ModelRenderer(this, 28, 10);
      Cauldron30.addBox(0F, 0F, 0F, 1, 1, 1);
      Cauldron30.setRotationPoint(4F, 9F, 4F);
      Cauldron30.setTextureSize(128, 64);
      Cauldron30.mirror = true;
      setRotation(Cauldron30, 0F, 0F, 0F);
      Cauldron31 = new ModelRenderer(this, 24, 8);
      Cauldron31.addBox(0F, 0F, 0F, 1, 1, 1);
      Cauldron31.setRotationPoint(-5F, 7F, 4F);
      Cauldron31.setTextureSize(128, 64);
      Cauldron31.mirror = true;
      setRotation(Cauldron31, 0F, 0F, 0F);
      Cauldron32 = new ModelRenderer(this, 32, 10);
      Cauldron32.addBox(0F, 0F, 0F, 1, 1, 1);
      Cauldron32.setRotationPoint(4F, 9F, -5F);
      Cauldron32.setTextureSize(128, 64);
      Cauldron32.mirror = true;
      setRotation(Cauldron32, 0F, 0F, 0F);
      Cauldron33 = new ModelRenderer(this, 28, 8);
      Cauldron33.addBox(0F, 0F, 0F, 1, 1, 1);
      Cauldron33.setRotationPoint(4F, 7F, 4F);
      Cauldron33.setTextureSize(128, 64);
      Cauldron33.mirror = true;
      setRotation(Cauldron33, 0F, 0F, 0F);
      Cauldron34 = new ModelRenderer(this, 36, 10);
      Cauldron34.addBox(0F, 0F, 0F, 1, 1, 1);
      Cauldron34.setRotationPoint(-5F, 9F, -5F);
      Cauldron34.setTextureSize(128, 64);
      Cauldron34.mirror = true;
      setRotation(Cauldron34, 0F, 0F, 0F);
      Cauldron35 = new ModelRenderer(this, 62, 37);
      Cauldron35.addBox(0F, 0F, 0F, 1, 1, 8);
      Cauldron35.setRotationPoint(4F, 8F, -4F);
      Cauldron35.setTextureSize(128, 64);
      Cauldron35.mirror = true;
      setRotation(Cauldron35, 0F, 0F, 0F);
      Cauldron36 = new ModelRenderer(this, 24, 10);
      Cauldron36.addBox(0F, 0F, 0F, 1, 1, 1);
      Cauldron36.setRotationPoint(-5F, 9F, 4F);
      Cauldron36.setTextureSize(128, 64);
      Cauldron36.mirror = true;
      setRotation(Cauldron36, 0F, 0F, 0F);
      Cauldron37 = new ModelRenderer(this, 62, 28);
      Cauldron37.addBox(0F, 0F, 0F, 1, 1, 8);
      Cauldron37.setRotationPoint(5F, 7F, -4F);
      Cauldron37.setTextureSize(128, 64);
      Cauldron37.mirror = true;
      setRotation(Cauldron37, 0F, 0F, 0F);
      Cauldron38 = new ModelRenderer(this, 80, 60);
      Cauldron38.addBox(0F, 0F, 0F, 8, 1, 1);
      Cauldron38.setRotationPoint(-4F, 7F, 5F);
      Cauldron38.setTextureSize(128, 64);
      Cauldron38.mirror = true;
      setRotation(Cauldron38, 0F, 0F, 0F);
      Cauldron39 = new ModelRenderer(this, 80, 62);
      Cauldron39.addBox(0F, 0F, 0F, 8, 1, 1);
      Cauldron39.setRotationPoint(-4F, 8F, 4F);
      Cauldron39.setTextureSize(128, 64);
      Cauldron39.mirror = true;
      setRotation(Cauldron39, 0F, 0F, 0F);
      Cauldron5 = new ModelRenderer(this, 0, 57);
      Cauldron5.addBox(0F, 0F, 0F, 6, 1, 6);
      Cauldron5.setRotationPoint(-3F, 18F, -3F);
      Cauldron5.setTextureSize(128, 64);
      Cauldron5.mirror = true;
      setRotation(Cauldron5, 0F, 0F, 0F);
      tripod11 = new ModelRenderer(this, 54, 40);
      tripod11.addBox(0F, 0F, 0F, 1, 5, 1);
      tripod11.setRotationPoint(-7F, 19.2F, -6.3F);
      tripod11.setTextureSize(128, 64);
      tripod11.mirror = true;
      setRotation(tripod11, 0F, 0.7853982F, 0F);
      tripod6 = new ModelRenderer(this, 54, 0);
      tripod6.addBox(0F, 0F, 0F, 1, 1, 3);
      tripod6.setRotationPoint(5F, 17.7F, 4.3F);
      tripod6.setTextureSize(128, 64);
      tripod6.mirror = true;
      setRotation(tripod6, -2.356194F, -2.356194F, 0F);
      tripod2 = new ModelRenderer(this, 62, 4);
      tripod2.addBox(0F, 0F, 0F, 10, 1, 1);
      tripod2.setRotationPoint(-5F, 17F, 5F);
      tripod2.setTextureSize(128, 64);
      tripod2.mirror = true;
      setRotation(tripod2, 0F, 0F, 0F);
      tripod3 = new ModelRenderer(this, 54, 4);
      tripod3.addBox(0F, 0F, 0F, 1, 1, 3);
      tripod3.setRotationPoint(-4.3F, 17.7F, 5F);
      tripod3.setTextureSize(128, 64);
      tripod3.mirror = true;
      setRotation(tripod3, -2.356194F, 2.356194F, 0F);
      tripod4 = new ModelRenderer(this, 62, 2);
      tripod4.addBox(0F, 0F, 0F, 10, 1, 1);
      tripod4.setRotationPoint(-5F, 17F, -6F);
      tripod4.setTextureSize(128, 64);
      tripod4.mirror = true;
      setRotation(tripod4, 0F, 0F, 0F);
      tripod5 = new ModelRenderer(this, 62, 17);
      tripod5.addBox(0F, 0F, 0F, 1, 1, 10);
      tripod5.setRotationPoint(5F, 17F, -5F);
      tripod5.setTextureSize(128, 64);
      tripod5.mirror = true;
      setRotation(tripod5, 0F, 0F, 0F);
      tripod12 = new ModelRenderer(this, 54, 34);
      tripod12.addBox(0F, 0F, 0F, 1, 5, 1);
      tripod12.setRotationPoint(-7F, 19.2F, 6.3F);
      tripod12.setTextureSize(128, 64);
      tripod12.mirror = true;
      setRotation(tripod12, 0F, 0.7853982F, 0F);
      tripod7 = new ModelRenderer(this, 54, 8);
      tripod7.addBox(0F, 0F, 0F, 1, 1, 3);
      tripod7.setRotationPoint(-5F, 17.7F, -4.3F);
      tripod7.setTextureSize(128, 64);
      tripod7.mirror = true;
      setRotation(tripod7, -2.356194F, 0.7853982F, 0F);
      tripod8 = new ModelRenderer(this, 54, 12);
      tripod8.addBox(0F, 0F, 0F, 1, 1, 3);
      tripod8.setRotationPoint(4.3F, 17.7F, -5F);
      tripod8.setTextureSize(128, 64);
      tripod8.mirror = true;
      setRotation(tripod8, -2.356194F, -0.7853982F, 0F);
      tripod9 = new ModelRenderer(this, 58, 34);
      tripod9.addBox(0F, 0F, 0F, 1, 5, 1);
      tripod9.setRotationPoint(5.6F, 19.2F, 6.3F);
      tripod9.setTextureSize(128, 64);
      tripod9.mirror = true;
      setRotation(tripod9, 0F, 0.7853982F, 0F);
      tripod10 = new ModelRenderer(this, 58, 40);
      tripod10.addBox(0F, 0F, 0F, 1, 5, 1);
      tripod10.setRotationPoint(5.6F, 19.2F, -6.3F);
      tripod10.setTextureSize(128, 64);
      tripod10.mirror = true;
      setRotation(tripod10, 0F, 0.7853982F, 0F);
      Wood2 = new ModelRenderer(this, 32, 38);
      Wood2.addBox(0F, 0F, 0F, 2, 6, 2);
      Wood2.setRotationPoint(0F, 20F, -1F);
      Wood2.setTextureSize(128, 64);
      Wood2.mirror = true;
      setRotation(Wood2, -1.22173F, -0.5205006F, 0F);
      Wood3 = new ModelRenderer(this, 24, 38);
      Wood3.addBox(0F, 0F, 0F, 2, 6, 2);
      Wood3.setRotationPoint(0F, 20F, -1F);
      Wood3.setTextureSize(128, 64);
      Wood3.mirror = true;
      setRotation(Wood3, -1.22173F, -1.747395F, 0F);
      Wood4 = new ModelRenderer(this, 24, 30);
      Wood4.addBox(0F, 0F, 0F, 2, 6, 2);
      Wood4.setRotationPoint(0F, 20F, -1F);
      Wood4.setTextureSize(128, 64);
      Wood4.mirror = true;
      setRotation(Wood4, -1.22173F, 1.951877F, 0F);
      Wood5 = new ModelRenderer(this, 24, 30);
      Wood5.addBox(0F, 0F, 0F, 2, 6, 2);
      Wood5.setRotationPoint(0F, 20F, -1F);
      Wood5.setTextureSize(128, 64);
      Wood5.mirror = true;
      setRotation(Wood5, -1.22173F, -3.141593F, 0F);
      Wood1 = new ModelRenderer(this, 32, 30);
      Wood1.addBox(0F, 0F, 0F, 2, 6, 2);
      Wood1.setRotationPoint(0F, 20F, -1F);
      Wood1.setTextureSize(128, 64);
      Wood1.mirror = true;
      setRotation(Wood1, -1.22173F, 1.208305F, 0F);
      Cauldron10 = new ModelRenderer(this, 62, 55);
      Cauldron10.addBox(0F, 0F, 0F, 1, 1, 8);
      Cauldron10.setRotationPoint(-5F, 8F, -4F);
      Cauldron10.setTextureSize(128, 64);
      Cauldron10.mirror = true;
      setRotation(Cauldron10, 0F, 0F, 0F);
      Water = new ModelRenderer(this, 88, 40);
      Water.addBox(0F, 0F, 0F, 10, 0, 10);
      Water.setRotationPoint(-5F, 10F, -5F);
      Water.setTextureSize(128, 64);
      Water.mirror = true;
      setRotation(Water, 0F, 0F, 0F);
      Ingerdient2 = new ModelRenderer(this, 88, 42);
      Ingerdient2.addBox(0F, 0F, 0F, 1, 1, 1);
      Ingerdient2.setRotationPoint(3F, 9.5F, -3F);
      Ingerdient2.setTextureSize(128, 64);
      Ingerdient2.mirror = true;
      setRotation(Ingerdient2, -0.3717861F, -2.453788F, 0F);
      Ingerdient3 = new ModelRenderer(this, 88, 40);
      Ingerdient3.addBox(0F, 0F, 0F, 1, 1, 1);
      Ingerdient3.setRotationPoint(0F, 9.5F, -1F);
      Ingerdient3.setTextureSize(128, 64);
      Ingerdient3.mirror = true;
      setRotation(Ingerdient3, -0.1858931F, -0.0371786F, 0F);
      Ingerdient4 = new ModelRenderer(this, 88, 42);
      Ingerdient4.addBox(0F, 0F, 0F, 1, 1, 1);
      Ingerdient4.setRotationPoint(-2F, 9.5F, -3F);
      Ingerdient4.setTextureSize(128, 64);
      Ingerdient4.mirror = true;
      setRotation(Ingerdient4, -0.7435722F, -1.189716F, 0F);
      Ingerdient5 = new ModelRenderer(this, 88, 42);
      Ingerdient5.addBox(0F, 0F, 0F, 1, 1, 1);
      Ingerdient5.setRotationPoint(2F, 9.5F, 3F);
      Ingerdient5.setTextureSize(128, 64);
      Ingerdient5.mirror = true;
      setRotation(Ingerdient5, -0.3717861F, -3.085825F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Cauldron1.render(f5);
    Cauldron2.render(f5);
    Cauldron3.render(f5);
    Cauldron4.render(f5);
    tripod1.render(f5);
    Cauldron6.render(f5);
    Cauldron7.render(f5);
    Cauldron8.render(f5);
    Cauldron9.render(f5);
    Ingerdient1.render(f5);
    Cauldron11.render(f5);
    Cauldron13.render(f5);
    Cauldron15.render(f5);
    Cauldron21.render(f5);
    Cauldron27.render(f5);
    Cauldron29.render(f5);
    Cauldron30.render(f5);
    Cauldron31.render(f5);
    Cauldron32.render(f5);
    Cauldron33.render(f5);
    Cauldron34.render(f5);
    Cauldron35.render(f5);
    Cauldron36.render(f5);
    Cauldron37.render(f5);
    Cauldron38.render(f5);
    Cauldron39.render(f5);
    Cauldron5.render(f5);
    tripod11.render(f5);
    tripod6.render(f5);
    tripod2.render(f5);
    tripod3.render(f5);
    tripod4.render(f5);
    tripod5.render(f5);
    tripod12.render(f5);
    tripod7.render(f5);
    tripod8.render(f5);
    tripod9.render(f5);
    tripod10.render(f5);
    Wood2.render(f5);
    Wood3.render(f5);
    Wood4.render(f5);
    Wood5.render(f5);
    Wood1.render(f5);
    Cauldron10.render(f5);
    Water.render(f5);
    Ingerdient2.render(f5);
    Ingerdient3.render(f5);
    Ingerdient4.render(f5);
    Ingerdient5.render(f5);
  }
  public void renderModel(float f5) {
	  Cauldron1.render(f5);
	    Cauldron2.render(f5);
	    Cauldron3.render(f5);
	    Cauldron4.render(f5);
	    tripod1.render(f5);
	    Cauldron6.render(f5);
	    Cauldron7.render(f5);
	    Cauldron8.render(f5);
	    Cauldron9.render(f5);
	    Ingerdient1.render(f5);
	    Cauldron11.render(f5);
	    Cauldron13.render(f5);
	    Cauldron15.render(f5);
	    Cauldron21.render(f5);
	    Cauldron27.render(f5);
	    Cauldron29.render(f5);
	    Cauldron30.render(f5);
	    Cauldron31.render(f5);
	    Cauldron32.render(f5);
	    Cauldron33.render(f5);
	    Cauldron34.render(f5);
	    Cauldron35.render(f5);
	    Cauldron36.render(f5);
	    Cauldron37.render(f5);
	    Cauldron38.render(f5);
	    Cauldron39.render(f5);
	    Cauldron5.render(f5);
	    tripod11.render(f5);
	    tripod6.render(f5);
	    tripod2.render(f5);
	    tripod3.render(f5);
	    tripod4.render(f5);
	    tripod5.render(f5);
	    tripod12.render(f5);
	    tripod7.render(f5);
	    tripod8.render(f5);
	    tripod9.render(f5);
	    tripod10.render(f5);
	    Wood2.render(f5);
	    Wood3.render(f5);
	    Wood4.render(f5);
	    Wood5.render(f5);
	    Wood1.render(f5);
	    Cauldron10.render(f5);
	    Water.render(f5);
	    Ingerdient2.render(f5);
	    Ingerdient3.render(f5);
	    Ingerdient4.render(f5);
	    Ingerdient5.render(f5);
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
