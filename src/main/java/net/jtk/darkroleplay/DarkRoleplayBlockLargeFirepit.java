package net.jtk.darkroleplay;

import java.util.Random;

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
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DarkRoleplayBlockLargeFirepit extends BlockContainer {

	public static Block blockLargeFirepit;

	public static Object instance;
	
	public static PropertyInteger DIR = PropertyInteger.create("dir", 0, 15);

	public DarkRoleplayBlockLargeFirepit() {
		super(Material.wood);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DIR, Integer.valueOf(0)));
	}

	static {

		blockLargeFirepit = new DarkRoleplayBlockLargeFirepit()
				.setHardness(2.0F).setResistance(10.0F).setLightLevel(0.0F)
				.setUnlocalizedName("blockLargeFirepit")
				.setStepSound(Block.soundTypeWood)
				.setLightLevel(1F / 15F * 14F)
				.setCreativeTab(DarkRoleplayTabs.drBlocksTab);
		blockLargeFirepit.setBlockBounds(1.0F / 16F * 0F, 0.0F,
				1.0F / 16F * 0F, 1.0F / 16F * 16F, 1.0F / 16F * 14F,
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
    		playerIn.addChatMessage(new ChatComponentTranslation("This Block doesn't has currently any Functions!"));
   			playerIn.addChatMessage(new ChatComponentTranslation("But it is Work in Progress"));
   			return true;
    	}
    }
	
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
    	float f1 = pos.getX() + 0.5F;
    	float f2 = pos.getY() + 0.5F;
    	float f3 = pos.getZ() + 0.5F;
    	float f4 = rand.nextFloat() * 0.6F - 0.3F;
    	float f5 = rand.nextFloat() * -0.6F - -0.3F;
    	float f6 = rand.nextFloat() * 0.6F -0.1F;
    	worldIn.spawnParticle(EnumParticleTypes.FLAME, (double)(f1+f4), (double)(f2+f6), (double)(f3+f5), 0.0D, 0.0D, 0.0D, new int[20]);
    	worldIn.spawnParticle(EnumParticleTypes.FLAME, (double)(f1+f4), (double)(f2+f6), (double)(f3+f5), 0.0D, 0.0D, 0.0D, new int[20]);
    	worldIn.spawnParticle(EnumParticleTypes.FLAME, (double)(f1+f4), (double)(f2+f6), (double)(f3+f5), 0.0D, 0.0D, 0.0D, new int[20]);
    	worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, (double)(f1+f4), (double)f2, (double)(f3+f5), 0.0D, 0.0D, 0.0D, new int[10]);
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
		return new TileEntityCustomLargeFirepit();
	}

	public static void serverLoad(FMLServerStartingEvent event) {
	}

	public static void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerBlock(blockLargeFirepit, "blockLargeFirepit");
		GameRegistry.registerTileEntity(TileEntityCustomLargeFirepit.class, "TileEntityLargeFirepit");
	}
}

class TileEntityCustomLargeFirepit extends TileEntity {
}

class customRendererLargeFirepit extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockLargeFirepit.png");

	private ModelLargeFirepit model;

	public customRendererLargeFirepit() {
		this.model = new ModelLargeFirepit();
	}
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f, int i) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.25F, (float) z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		PropertyInteger DIR = PropertyInteger.create("dir", 0, 15);
		IBlockState state = tileentity.getWorld().getBlockState(tileentity.getPos());
		int facing = (((Integer) state.getValue(DIR)).intValue());
		GL11.glRotatef(facing * 90, 0.0F, 1.0F, 0.0F); 
		this.bindTexture(texture);

		this.model.renderModel(0.05F);

		GL11.glPopMatrix();
	}

}

class ModelLargeFirepit extends ModelBase {
	// fields
	ModelRenderer Stone1;
	ModelRenderer Stone2;
	ModelRenderer Stone3;
	ModelRenderer Stone4;
	ModelRenderer Stone5;
	ModelRenderer Stone6;
	ModelRenderer Stone7;
	ModelRenderer Stone8;
	ModelRenderer Stone9;
	ModelRenderer Stone10;
	ModelRenderer Stone11;
	ModelRenderer Stone12;
	ModelRenderer Stone13;
	ModelRenderer Stone14;
	ModelRenderer Stone15;
	ModelRenderer Stone16;
	ModelRenderer Stone17;
	ModelRenderer Stone18;
	ModelRenderer Stone19;
	ModelRenderer Stone20;
	ModelRenderer Stone21;
	ModelRenderer Stone22;
	ModelRenderer Stone23;
	ModelRenderer Stone24;
	ModelRenderer Stone25;
	ModelRenderer Stone26;
	ModelRenderer Stone27;
	ModelRenderer Stone28;
	ModelRenderer Stone29;
	ModelRenderer Stone30;
	ModelRenderer Stone31;
	ModelRenderer Stone32;
	ModelRenderer Stone33;
	ModelRenderer Stone34;
	ModelRenderer Stone35;
	ModelRenderer Stone36;
	ModelRenderer Stone37;
	ModelRenderer Stone38;
	ModelRenderer Stone39;
	ModelRenderer Stone40;
	ModelRenderer Stone41;
	ModelRenderer Stone42;
	ModelRenderer Stone43;
	ModelRenderer Stone44;
	ModelRenderer Stone45;
	ModelRenderer Stone46;
	ModelRenderer Stone47;
	ModelRenderer Stone48;
	ModelRenderer Stone49;
	ModelRenderer Stone50;
	ModelRenderer Stone51;
	ModelRenderer Stone52;
	ModelRenderer Stone53;
	ModelRenderer Stone54;
	ModelRenderer Stone55;
	ModelRenderer Stone56;
	ModelRenderer Stone57;
	ModelRenderer Stone58;
	ModelRenderer Stone59;
	ModelRenderer Stone69;
	ModelRenderer Stone70;
	ModelRenderer Stone71;
	ModelRenderer Stone72;
	ModelRenderer Stone60;
	ModelRenderer Stone61;
	ModelRenderer Stone62;
	ModelRenderer Stone63;
	ModelRenderer Stone64;
	ModelRenderer Stone65;
	ModelRenderer Stone66;
	ModelRenderer Stone67;
	ModelRenderer Stone68;
	ModelRenderer Wood1;
	ModelRenderer Wood2;
	ModelRenderer Wood3;
	ModelRenderer Wood4;
	ModelRenderer Wood5;
	ModelRenderer Wood6;
	ModelRenderer Wood7;
	ModelRenderer Wood8;
	ModelRenderer Wood9;
	ModelRenderer Wood10;
	ModelRenderer Wood11;
	ModelRenderer Wood12;
	ModelRenderer Wood13;

	public ModelLargeFirepit() {
		textureWidth = 128;
		textureHeight = 128;

		Stone1 = new ModelRenderer(this, 0, 0);
		Stone1.addBox(0F, 0F, 0F, 5, 3, 1);
		Stone1.setRotationPoint(-5F, 22.5F, -22F);
		Stone1.setTextureSize(128, 128);
		Stone1.mirror = true;
		setRotation(Stone1, 0F, 0F, 0F);
		Stone2 = new ModelRenderer(this, 0, 0);
		Stone2.addBox(0F, 0F, 0F, 1, 3, 2);
		Stone2.setRotationPoint(-3.5F, 22F, 18.5F);
		Stone2.setTextureSize(128, 128);
		Stone2.mirror = true;
		setRotation(Stone2, 0F, 0F, 0F);
		Stone3 = new ModelRenderer(this, 0, 0);
		Stone3.addBox(0F, 0F, 0F, 3, 2, 3);
		Stone3.setRotationPoint(-1.5F, 22F, -20F);
		Stone3.setTextureSize(128, 128);
		Stone3.mirror = true;
		setRotation(Stone3, 0F, 0F, 0F);
		Stone4 = new ModelRenderer(this, 0, 0);
		Stone4.addBox(0F, 0F, 0F, 1, 3, 3);
		Stone4.setRotationPoint(-6.5F, 22F, -20F);
		Stone4.setTextureSize(128, 128);
		Stone4.mirror = true;
		setRotation(Stone4, 0F, 0F, 0F);
		Stone5 = new ModelRenderer(this, 0, 0);
		Stone5.addBox(0F, 0F, 0F, 5, 1, 3);
		Stone5.setRotationPoint(-5F, 21F, -20F);
		Stone5.setTextureSize(128, 128);
		Stone5.mirror = true;
		setRotation(Stone5, 0F, 0F, 0F);
		Stone6 = new ModelRenderer(this, 0, 0);
		Stone6.addBox(0F, 0F, 0F, 6, 3, 4);
		Stone6.setRotationPoint(-4F, 21F, 15F);
		Stone6.setTextureSize(128, 128);
		Stone6.mirror = true;
		setRotation(Stone6, 0F, 0F, 0F);
		Stone7 = new ModelRenderer(this, 0, 0);
		Stone7.addBox(0F, 0F, 0F, 2, 3, 4);
		Stone7.setRotationPoint(-7F, 23F, -21.5F);
		Stone7.setTextureSize(128, 128);
		Stone7.mirror = true;
		setRotation(Stone7, 0F, 0F, 0F);
		Stone8 = new ModelRenderer(this, 0, 0);
		Stone8.addBox(0F, 0F, 0F, 7, 3, 5);
		Stone8.setRotationPoint(-6F, 21.5F, -21F);
		Stone8.setTextureSize(128, 128);
		Stone8.mirror = true;
		setRotation(Stone8, 0F, 0F, 0F);
		Stone9 = new ModelRenderer(this, 0, 0);
		Stone9.addBox(0F, 0F, 0F, 1, 2, 1);
		Stone9.setRotationPoint(20.5F, 22F, -0.5F);
		Stone9.setTextureSize(128, 128);
		Stone9.mirror = true;
		setRotation(Stone9, 0F, 0F, 0F);
		Stone10 = new ModelRenderer(this, 0, 0);
		Stone10.addBox(0F, 0F, 0F, 5, 1, 3);
		Stone10.setRotationPoint(-2F, 20F, 17F);
		Stone10.setTextureSize(128, 128);
		Stone10.mirror = true;
		setRotation(Stone10, 0F, 0F, 0F);
		Stone11 = new ModelRenderer(this, 0, 0);
		Stone11.addBox(0F, 0F, 0F, 1, 2, 2);
		Stone11.setRotationPoint(3.5F, 22.5F, 17F);
		Stone11.setTextureSize(128, 128);
		Stone11.mirror = true;
		setRotation(Stone11, 0F, 0F, 0F);
		Stone12 = new ModelRenderer(this, 0, 0);
		Stone12.addBox(0F, 0F, 0F, 6, 2, 3);
		Stone12.setRotationPoint(-4F, 22.5F, -18F);
		Stone12.setTextureSize(128, 128);
		Stone12.mirror = true;
		setRotation(Stone12, 0F, 0F, 0F);
		Stone13 = new ModelRenderer(this, 0, 0);
		Stone13.addBox(0F, 0F, 0F, 6, 3, 2);
		Stone13.setRotationPoint(-3F, 22F, 14.5F);
		Stone13.setTextureSize(128, 128);
		Stone13.mirror = true;
		setRotation(Stone13, 0F, 0F, 0F);
		Stone14 = new ModelRenderer(this, 0, 0);
		Stone14.addBox(0F, 0F, 0F, 4, 2, 1);
		Stone14.setRotationPoint(0F, 22.5F, 21.5F);
		Stone14.setTextureSize(128, 128);
		Stone14.mirror = true;
		setRotation(Stone14, 0F, 0F, 0F);
		Stone15 = new ModelRenderer(this, 0, 0);
		Stone15.addBox(0F, 0F, 0F, 6, 2, 4);
		Stone15.setRotationPoint(-1F, 22F, 18F);
		Stone15.setTextureSize(128, 128);
		Stone15.mirror = true;
		setRotation(Stone15, 0F, 0F, 0F);
		Stone16 = new ModelRenderer(this, 0, 0);
		Stone16.addBox(0F, 0F, 0F, 4, 3, 1);
		Stone16.setRotationPoint(-2F, 21F, 20.5F);
		Stone16.setTextureSize(128, 128);
		Stone16.mirror = true;
		setRotation(Stone16, 0F, 0F, 0F);
		Stone17 = new ModelRenderer(this, 0, 0);
		Stone17.addBox(0F, 0F, 0F, 7, 4, 5);
		Stone17.setRotationPoint(-3F, 20.5F, 16F);
		Stone17.setTextureSize(128, 128);
		Stone17.mirror = true;
		setRotation(Stone17, 0F, 0F, 0F);
		Stone18 = new ModelRenderer(this, 0, 0);
		Stone18.addBox(0F, 0F, 0F, 5, 4, 3);
		Stone18.setRotationPoint(-16F, 20F, -12F);
		Stone18.setTextureSize(128, 128);
		Stone18.mirror = true;
		setRotation(Stone18, 0F, 0.7853982F, 0F);
		Stone19 = new ModelRenderer(this, 0, 0);
		Stone19.addBox(0F, 0F, 0F, 5, 3, 3);
		Stone19.setRotationPoint(-17F, 21.5F, -13F);
		Stone19.setTextureSize(128, 128);
		Stone19.mirror = true;
		setRotation(Stone19, 0F, 0.7853982F, 0F);
		Stone20 = new ModelRenderer(this, 0, 0);
		Stone20.addBox(0F, 0F, 0F, 5, 4, 3);
		Stone20.setRotationPoint(-16F, 20.5F, -13F);
		Stone20.setTextureSize(128, 128);
		Stone20.mirror = true;
		setRotation(Stone20, 0F, 0.7853982F, 0F);
		Stone21 = new ModelRenderer(this, 0, 0);
		Stone21.addBox(0F, 0F, 0F, 2, 3, 3);
		Stone21.setRotationPoint(-17.5F, 22.5F, -11.5F);
		Stone21.setTextureSize(128, 128);
		Stone21.mirror = true;
		setRotation(Stone21, 0F, 0.7853982F, 0F);
		Stone22 = new ModelRenderer(this, 0, 0);
		Stone22.addBox(0F, 0F, 0F, 5, 2, 3);
		Stone22.setRotationPoint(-17F, 22F, -10.4F);
		Stone22.setTextureSize(128, 128);
		Stone22.mirror = true;
		setRotation(Stone22, 0F, 0.7853982F, 0F);
		Stone23 = new ModelRenderer(this, 0, 0);
		Stone23.addBox(0F, 0F, 0F, 2, 3, 3);
		Stone23.setRotationPoint(-13F, 21.5F, -15F);
		Stone23.setTextureSize(128, 128);
		Stone23.mirror = true;
		setRotation(Stone23, 0F, 0.7853982F, 0F);
		Stone24 = new ModelRenderer(this, 0, 0);
		Stone24.addBox(0F, 0F, 0F, 2, 2, 2);
		Stone24.setRotationPoint(-21.5F, 22.5F, -3F);
		Stone24.setTextureSize(128, 128);
		Stone24.mirror = true;
		setRotation(Stone24, 0F, 0F, 0F);
		Stone25 = new ModelRenderer(this, 0, 0);
		Stone25.addBox(0F, 0F, 0F, 4, 4, 6);
		Stone25.setRotationPoint(-21F, 20F, -2F);
		Stone25.setTextureSize(128, 128);
		Stone25.mirror = true;
		setRotation(Stone25, 0F, 0F, 0F);
		Stone26 = new ModelRenderer(this, 0, 0);
		Stone26.addBox(0F, 0F, 0F, 2, 2, 6);
		Stone26.setRotationPoint(-17F, 22F, -2F);
		Stone26.setTextureSize(128, 128);
		Stone26.mirror = true;
		setRotation(Stone26, 0F, 0F, 0F);
		Stone27 = new ModelRenderer(this, 0, 0);
		Stone27.addBox(0F, 0F, 0F, 4, 3, 4);
		Stone27.setRotationPoint(-20.5F, 21.5F, 1.5F);
		Stone27.setTextureSize(128, 128);
		Stone27.mirror = true;
		setRotation(Stone27, 0F, 0F, 0F);
		Stone28 = new ModelRenderer(this, 0, 0);
		Stone28.addBox(0F, 0F, 0F, 4, 3, 6);
		Stone28.setRotationPoint(-20F, 21F, -4F);
		Stone28.setTextureSize(128, 128);
		Stone28.mirror = true;
		setRotation(Stone28, 0F, 0F, 0F);
		Stone29 = new ModelRenderer(this, 0, 0);
		Stone29.addBox(0F, 0F, 0F, 4, 4, 4);
		Stone29.setRotationPoint(-22.5F, 20.5F, 0.5F);
		Stone29.setTextureSize(128, 128);
		Stone29.mirror = true;
		setRotation(Stone29, 0F, 0F, 0F);
		Stone30 = new ModelRenderer(this, 0, 0);
		Stone30.addBox(0F, 0F, 0F, 2, 2, 4);
		Stone30.setRotationPoint(-23F, 22.5F, -0.5F);
		Stone30.setTextureSize(128, 128);
		Stone30.mirror = true;
		setRotation(Stone30, 0F, 0F, 0F);
		Stone31 = new ModelRenderer(this, 0, 0);
		Stone31.addBox(0F, 0F, 0F, 1, 2, 2);
		Stone31.setRotationPoint(-22F, 22F, -1F);
		Stone31.setTextureSize(128, 128);
		Stone31.mirror = true;
		setRotation(Stone31, 0F, 0F, 0F);
		Stone32 = new ModelRenderer(this, 0, 0);
		Stone32.addBox(0F, 0F, 0F, 4, 3, 6);
		Stone32.setRotationPoint(17F, 21F, -5F);
		Stone32.setTextureSize(128, 128);
		Stone32.mirror = true;
		setRotation(Stone32, 0F, 0F, 0F);
		Stone33 = new ModelRenderer(this, 0, 0);
		Stone33.addBox(0F, 0F, 0F, 4, 3, 6);
		Stone33.setRotationPoint(16F, 21.5F, -6.5F);
		Stone33.setTextureSize(128, 128);
		Stone33.mirror = true;
		setRotation(Stone33, 0F, 0F, 0F);
		Stone34 = new ModelRenderer(this, 0, 0);
		Stone34.addBox(0F, 0F, 0F, 2, 2, 4);
		Stone34.setRotationPoint(21F, 23F, -3.5F);
		Stone34.setTextureSize(128, 128);
		Stone34.mirror = true;
		setRotation(Stone34, 0F, 0F, 0F);
		Stone35 = new ModelRenderer(this, 0, 0);
		Stone35.addBox(0F, 0F, 0F, 2, 2, 1);
		Stone35.setRotationPoint(-11.8F, 22F, -12.8F);
		Stone35.setTextureSize(128, 128);
		Stone35.mirror = true;
		setRotation(Stone35, 0F, 0.7853982F, 0F);
		Stone36 = new ModelRenderer(this, 0, 0);
		Stone36.addBox(0F, 0F, 0F, 5, 3, 3);
		Stone36.setRotationPoint(-16F, 21F, -11F);
		Stone36.setTextureSize(128, 128);
		Stone36.mirror = true;
		setRotation(Stone36, 0F, 0.7853982F, 0F);
		Stone37 = new ModelRenderer(this, 0, 0);
		Stone37.addBox(0F, 0F, 0F, 2, 2, 5);
		Stone37.setRotationPoint(19.5F, 22.5F, -6F);
		Stone37.setTextureSize(128, 128);
		Stone37.mirror = true;
		setRotation(Stone37, 0F, 0F, 0F);
		Stone38 = new ModelRenderer(this, 0, 0);
		Stone38.addBox(0F, 0F, 0F, 1, 3, 3);
		Stone38.setRotationPoint(21F, 21.5F, -3F);
		Stone38.setTextureSize(128, 128);
		Stone38.mirror = true;
		setRotation(Stone38, 0F, 0F, 0F);
		Stone39 = new ModelRenderer(this, 0, 0);
		Stone39.addBox(0F, 0F, 0F, 2, 2, 5);
		Stone39.setRotationPoint(15.5F, 22.5F, -5F);
		Stone39.setTextureSize(128, 128);
		Stone39.mirror = true;
		setRotation(Stone39, 0F, 0F, 0F);
		Stone40 = new ModelRenderer(this, 0, 0);
		Stone40.addBox(0F, 0F, 0F, 3, 2, 1);
		Stone40.setRotationPoint(17.5F, 22.5F, 1F);
		Stone40.setTextureSize(128, 128);
		Stone40.mirror = true;
		setRotation(Stone40, 0F, 0F, 0F);
		Stone41 = new ModelRenderer(this, 0, 0);
		Stone41.addBox(0F, 0F, 0F, 2, 2, 1);
		Stone41.setRotationPoint(18F, 22F, 0.5F);
		Stone41.setTextureSize(128, 128);
		Stone41.mirror = true;
		setRotation(Stone41, 0F, 0F, 0F);
		Stone42 = new ModelRenderer(this, 0, 0);
		Stone42.addBox(0F, 0F, 0F, 1, 1, 1);
		Stone42.setRotationPoint(21.5F, 23F, 0F);
		Stone42.setTextureSize(128, 128);
		Stone42.mirror = true;
		setRotation(Stone42, 0F, 0F, 0F);
		Stone43 = new ModelRenderer(this, 0, 0);
		Stone43.addBox(0F, 0F, 0F, 1, 1, 1);
		Stone43.setRotationPoint(20.5F, 23F, 0.5F);
		Stone43.setTextureSize(128, 128);
		Stone43.mirror = true;
		setRotation(Stone43, 0F, 0F, 0F);
		Stone44 = new ModelRenderer(this, 0, 0);
		Stone44.addBox(0F, 0F, 0F, 3, 2, 4);
		Stone44.setRotationPoint(10F, 19.5F, -15F);
		Stone44.setTextureSize(128, 128);
		Stone44.mirror = true;
		setRotation(Stone44, 0F, 0.7853982F, 0F);
		Stone45 = new ModelRenderer(this, 0, 0);
		Stone45.addBox(0F, 0F, 0F, 2, 2, 1);
		Stone45.setRotationPoint(-11.8F, 22F, -12.8F);
		Stone45.setTextureSize(128, 128);
		Stone45.mirror = true;
		setRotation(Stone45, 0F, 0.7853982F, 0F);
		Stone46 = new ModelRenderer(this, 0, 0);
		Stone46.addBox(0F, 0F, 0F, 2, 2, 1);
		Stone46.setRotationPoint(-11.8F, 22F, -12.8F);
		Stone46.setTextureSize(128, 128);
		Stone46.mirror = true;
		setRotation(Stone46, 0F, 0.7853982F, 0F);
		Stone47 = new ModelRenderer(this, 0, 0);
		Stone47.addBox(0F, 0F, 0F, 3, 3, 2);
		Stone47.setRotationPoint(7F, 22F, -14.5F);
		Stone47.setTextureSize(128, 128);
		Stone47.mirror = true;
		setRotation(Stone47, 0F, 0.7853982F, 0F);
		Stone48 = new ModelRenderer(this, 0, 0);
		Stone48.addBox(0F, 0F, 0F, 3, 4, 6);
		Stone48.setRotationPoint(8F, 22F, -12F);
		Stone48.setTextureSize(128, 128);
		Stone48.mirror = true;
		setRotation(Stone48, 0F, 0.7853982F, 0F);
		Stone49 = new ModelRenderer(this, 0, 0);
		Stone49.addBox(0F, 0F, 0F, 5, 3, 3);
		Stone49.setRotationPoint(12F, 21.5F, -10F);
		Stone49.setTextureSize(128, 128);
		Stone49.mirror = true;
		setRotation(Stone49, 0F, 0.7853982F, 0F);
		Stone50 = new ModelRenderer(this, 0, 0);
		Stone50.addBox(0F, 0F, 0F, 3, 4, 6);
		Stone50.setRotationPoint(8F, 20.5F, -13F);
		Stone50.setTextureSize(128, 128);
		Stone50.mirror = true;
		setRotation(Stone50, 0F, 0.7853982F, 0F);
		Stone51 = new ModelRenderer(this, 0, 0);
		Stone51.addBox(0F, 0F, 0F, 5, 4, 7);
		Stone51.setRotationPoint(8F, 20F, -15F);
		Stone51.setTextureSize(128, 128);
		Stone51.mirror = true;
		setRotation(Stone51, 0F, 0.7853982F, 0F);
		Stone52 = new ModelRenderer(this, 0, 0);
		Stone52.addBox(0F, 0F, 0F, 2, 2, 3);
		Stone52.setRotationPoint(11.5F, 22F, -18.5F);
		Stone52.setTextureSize(128, 128);
		Stone52.mirror = true;
		setRotation(Stone52, 0F, 0.7853982F, 0F);
		Stone53 = new ModelRenderer(this, 0, 0);
		Stone53.addBox(0F, 0F, 0F, 4, 3, 5);
		Stone53.setRotationPoint(7F, 21.5F, -15.5F);
		Stone53.setTextureSize(128, 128);
		Stone53.mirror = true;
		setRotation(Stone53, 0F, 0.7853982F, 0F);
		Stone54 = new ModelRenderer(this, 0, 0);
		Stone54.addBox(0F, 0F, 0F, 4, 3, 5);
		Stone54.setRotationPoint(9F, 21F, -17F);
		Stone54.setTextureSize(128, 128);
		Stone54.mirror = true;
		setRotation(Stone54, 0F, 0.7853982F, 0F);
		Stone55 = new ModelRenderer(this, 0, 0);
		Stone55.addBox(0F, 0F, 0F, 3, 2, 3);
		Stone55.setRotationPoint(12F, 22F, -15F);
		Stone55.setTextureSize(128, 128);
		Stone55.mirror = true;
		setRotation(Stone55, 0F, 0.7853982F, 0F);
		Stone56 = new ModelRenderer(this, 0, 0);
		Stone56.addBox(0F, 0F, 0F, 3, 3, 2);
		Stone56.setRotationPoint(13F, 21F, -11F);
		Stone56.setTextureSize(128, 128);
		Stone56.mirror = true;
		setRotation(Stone56, 0F, 0.7853982F, 0F);
		Stone57 = new ModelRenderer(this, 0, 0);
		Stone57.addBox(0F, 0F, 0F, 6, 1, 3);
		Stone57.setRotationPoint(11F, 20.5F, 13.66667F);
		Stone57.setTextureSize(128, 128);
		Stone57.mirror = true;
		setRotation(Stone57, 0F, 0.7853982F, 0F);
		Stone58 = new ModelRenderer(this, 0, 0);
		Stone58.addBox(0F, 0F, 0F, 8, 3, 4);
		Stone58.setRotationPoint(10F, 21F, 14F);
		Stone58.setTextureSize(128, 128);
		Stone58.mirror = true;
		setRotation(Stone58, 0F, 0.7853982F, 0F);
		Stone59 = new ModelRenderer(this, 0, 0);
		Stone59.addBox(0F, 0F, 0F, 5, 3, 2);
		Stone59.setRotationPoint(14.5F, 23F, 15.5F);
		Stone59.setTextureSize(128, 128);
		Stone59.mirror = true;
		setRotation(Stone59, 0F, 0.7853982F, 0F);
		Stone69 = new ModelRenderer(this, 0, 0);
		Stone69.addBox(0F, 0F, 0F, 8, 3, 4);
		Stone69.setRotationPoint(11F, 22F, 14F);
		Stone69.setTextureSize(128, 128);
		Stone69.mirror = true;
		setRotation(Stone69, 0F, 0.7853982F, 0F);
		Stone70 = new ModelRenderer(this, 0, 0);
		Stone70.addBox(0F, 0F, 0F, 8, 3, 4);
		Stone70.setRotationPoint(11F, 22F, 14F);
		Stone70.setTextureSize(128, 128);
		Stone70.mirror = true;
		setRotation(Stone70, 0F, 0.7853982F, 0F);
		Stone71 = new ModelRenderer(this, 0, 0);
		Stone71.addBox(0F, 0F, 0F, 8, 3, 4);
		Stone71.setRotationPoint(11F, 22F, 14F);
		Stone71.setTextureSize(128, 128);
		Stone71.mirror = true;
		setRotation(Stone71, 0F, 0.7853982F, 0F);
		Stone72 = new ModelRenderer(this, 0, 0);
		Stone72.addBox(0F, 0F, 0F, 6, 3, 4);
		Stone72.setRotationPoint(10.5F, 22.5F, 15.5F);
		Stone72.setTextureSize(128, 128);
		Stone72.mirror = true;
		setRotation(Stone72, 0F, 0.7853982F, 0F);
		Stone60 = new ModelRenderer(this, 0, 0);
		Stone60.addBox(0F, 0F, 0F, 8, 3, 4);
		Stone60.setRotationPoint(10F, 22F, 12F);
		Stone60.setTextureSize(128, 128);
		Stone60.mirror = true;
		setRotation(Stone60, 0F, 0.7853982F, 0F);
		Stone61 = new ModelRenderer(this, 0, 0);
		Stone61.addBox(0F, 0F, 0F, 3, 3, 7);
		Stone61.setRotationPoint(-19F, 21F, 13.8F);
		Stone61.setTextureSize(128, 128);
		Stone61.mirror = true;
		setRotation(Stone61, 0F, 0.7853982F, 0F);
		Stone62 = new ModelRenderer(this, 0, 0);
		Stone62.addBox(0F, 0F, 0F, 3, 3, 6);
		Stone62.setRotationPoint(-18F, 21.5F, 13.8F);
		Stone62.setTextureSize(128, 128);
		Stone62.mirror = true;
		setRotation(Stone62, 0F, 0.7853982F, 0F);
		Stone63 = new ModelRenderer(this, 0, 0);
		Stone63.addBox(0F, 0F, 0F, 3, 3, 6);
		Stone63.setRotationPoint(-17.6F, 23F, 12.33333F);
		Stone63.setTextureSize(128, 128);
		Stone63.mirror = true;
		setRotation(Stone63, 0F, 0.7853982F, 0F);
		Stone64 = new ModelRenderer(this, 0, 0);
		Stone64.addBox(0F, 0F, 0F, 2, 3, 3);
		Stone64.setRotationPoint(-20F, 22F, 13.33333F);
		Stone64.setTextureSize(128, 128);
		Stone64.mirror = true;
		setRotation(Stone64, 0F, 0.7853982F, 0F);
		Stone65 = new ModelRenderer(this, 0, 0);
		Stone65.addBox(0F, 0F, 0F, 2, 3, 4);
		Stone65.setRotationPoint(-20F, 22F, 14.33333F);
		Stone65.setTextureSize(128, 128);
		Stone65.mirror = true;
		setRotation(Stone65, 0F, 0.7853982F, 0F);
		Stone66 = new ModelRenderer(this, 0, 0);
		Stone66.addBox(0F, 0F, 0F, 2, 3, 4);
		Stone66.setRotationPoint(-19F, 21.5F, 16.33333F);
		Stone66.setTextureSize(128, 128);
		Stone66.mirror = true;
		setRotation(Stone66, 0F, 0.7853982F, 0F);
		Stone67 = new ModelRenderer(this, 0, 0);
		Stone67.addBox(0F, 0F, 0F, 3, 2, 4);
		Stone67.setRotationPoint(-19F, 22.5F, 17.33333F);
		Stone67.setTextureSize(128, 128);
		Stone67.mirror = true;
		setRotation(Stone67, 0F, 0.7853982F, 0F);
		Stone68 = new ModelRenderer(this, 0, 0);
		Stone68.addBox(0F, 0F, 0F, 3, 3, 6);
		Stone68.setRotationPoint(-18.6F, 22F, 12.33333F);
		Stone68.setTextureSize(128, 128);
		Stone68.mirror = true;
		setRotation(Stone68, 0F, 0.7853982F, 0F);
		Wood1 = new ModelRenderer(this, 0, 68);
		Wood1.addBox(0F, 0F, 0F, 3, 18, 3);
		Wood1.setRotationPoint(4F, 8F, 3F);
		Wood1.setTextureSize(128, 128);
		Wood1.mirror = true;
		setRotation(Wood1, -0.5948578F, -2.157255F, 0F);
		Wood2 = new ModelRenderer(this, 0, 68);
		Wood2.addBox(0F, 0F, 0F, 3, 12, 3);
		Wood2.setRotationPoint(-1F, 14F, 0F);
		Wood2.setTextureSize(128, 128);
		Wood2.mirror = true;
		setRotation(Wood2, 0F, 0F, 0F);
		Wood3 = new ModelRenderer(this, 0, 68);
		Wood3.addBox(0F, 0F, 0F, 3, 12, 3);
		Wood3.setRotationPoint(0F, 14F, -1F);
		Wood3.setTextureSize(128, 128);
		Wood3.mirror = true;
		setRotation(Wood3, 0.5205006F, -2.174949F, 0F);
		Wood4 = new ModelRenderer(this, 0, 68);
		Wood4.addBox(0F, 0F, 0F, 3, 12, 3);
		Wood4.setRotationPoint(-2F, 14F, 2F);
		Wood4.setTextureSize(128, 128);
		Wood4.mirror = true;
		setRotation(Wood4, 0.5205006F, -0.8736974F, 0F);
		Wood5 = new ModelRenderer(this, 0, 68);
		Wood5.addBox(0F, 0F, 0F, 3, 12, 3);
		Wood5.setRotationPoint(3F, 14F, 1F);
		Wood5.setTextureSize(128, 128);
		Wood5.mirror = true;
		setRotation(Wood5, 0.5205006F, 2.806985F, 0F);
		Wood6 = new ModelRenderer(this, 0, 68);
		Wood6.addBox(0F, 0F, 0F, 3, 12, 3);
		Wood6.setRotationPoint(2F, 14F, 3F);
		Wood6.setTextureSize(128, 128);
		Wood6.mirror = true;
		setRotation(Wood6, 0.5205006F, 1.580091F, 0F);
		Wood7 = new ModelRenderer(this, 0, 68);
		Wood7.addBox(0F, 0F, 0F, 3, 18, 3);
		Wood7.setRotationPoint(-7F, 8F, 3F);
		Wood7.setTextureSize(128, 128);
		Wood7.mirror = true;
		setRotation(Wood7, -0.5948578F, 1.337534F, 0F);
		Wood8 = new ModelRenderer(this, 0, 68);
		Wood8.addBox(0F, 0F, 0F, 3, 18, 3);
		Wood8.setRotationPoint(-4F, 8F, 0F);
		Wood8.setTextureSize(128, 128);
		Wood8.mirror = true;
		setRotation(Wood8, -0.5948578F, 0.5939619F, 0F);
		Wood9 = new ModelRenderer(this, 0, 68);
		Wood9.addBox(0F, 0F, 0F, 3, 18, 3);
		Wood9.setRotationPoint(1F, 8F, 7F);
		Wood9.setTextureSize(128, 128);
		Wood9.mirror = true;
		setRotation(Wood9, -0.5948578F, 2.713143F, 0F);
		Wood10 = new ModelRenderer(this, 0, 68);
		Wood10.addBox(0F, 0F, 0F, 3, 18, 3);
		Wood10.setRotationPoint(0F, 8F, -3F);
		Wood10.setTextureSize(128, 128);
		Wood10.mirror = true;
		setRotation(Wood10, -0.5948578F, -0.0752531F, 0F);
		Wood11 = new ModelRenderer(this, 0, 68);
		Wood11.addBox(0F, 0F, 0F, 3, 18, 3);
		Wood11.setRotationPoint(-4F, 8F, 5F);
		Wood11.setTextureSize(128, 128);
		Wood11.mirror = true;
		setRotation(Wood11, -0.5948578F, 1.783677F, 0F);
		Wood12 = new ModelRenderer(this, 0, 68);
		Wood12.addBox(0F, 0F, 0F, 3, 18, 3);
		Wood12.setRotationPoint(5F, 8F, -1F);
		Wood12.setTextureSize(128, 128);
		Wood12.mirror = true;
		setRotation(Wood12, -0.5948578F, -1.339326F, 0F);
		Wood13 = new ModelRenderer(this, 0, 68);
		Wood13.addBox(0F, 0F, 0F, 3, 12, 3);
		Wood13.setRotationPoint(0F, 14F, 3F);
		Wood13.setTextureSize(128, 128);
		Wood13.mirror = true;
		setRotation(Wood13, 0.5205006F, 0.3160182F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Stone1.render(f5);
		Stone2.render(f5);
		Stone3.render(f5);
		Stone4.render(f5);
		Stone5.render(f5);
		Stone6.render(f5);
		Stone7.render(f5);
		Stone8.render(f5);
		Stone9.render(f5);
		Stone10.render(f5);
		Stone11.render(f5);
		Stone12.render(f5);
		Stone13.render(f5);
		Stone14.render(f5);
		Stone15.render(f5);
		Stone16.render(f5);
		Stone17.render(f5);
		Stone18.render(f5);
		Stone19.render(f5);
		Stone20.render(f5);
		Stone21.render(f5);
		Stone22.render(f5);
		Stone23.render(f5);
		Stone24.render(f5);
		Stone25.render(f5);
		Stone26.render(f5);
		Stone27.render(f5);
		Stone28.render(f5);
		Stone29.render(f5);
		Stone30.render(f5);
		Stone31.render(f5);
		Stone32.render(f5);
		Stone33.render(f5);
		Stone34.render(f5);
		Stone35.render(f5);
		Stone36.render(f5);
		Stone37.render(f5);
		Stone38.render(f5);
		Stone39.render(f5);
		Stone40.render(f5);
		Stone41.render(f5);
		Stone42.render(f5);
		Stone43.render(f5);
		Stone44.render(f5);
		Stone45.render(f5);
		Stone46.render(f5);
		Stone47.render(f5);
		Stone48.render(f5);
		Stone49.render(f5);
		Stone50.render(f5);
		Stone51.render(f5);
		Stone52.render(f5);
		Stone53.render(f5);
		Stone54.render(f5);
		Stone55.render(f5);
		Stone56.render(f5);
		Stone57.render(f5);
		Stone58.render(f5);
		Stone59.render(f5);
		Stone69.render(f5);
		Stone70.render(f5);
		Stone71.render(f5);
		Stone72.render(f5);
		Stone60.render(f5);
		Stone61.render(f5);
		Stone62.render(f5);
		Stone63.render(f5);
		Stone64.render(f5);
		Stone65.render(f5);
		Stone66.render(f5);
		Stone67.render(f5);
		Stone68.render(f5);
		Wood1.render(f5);
		Wood2.render(f5);
		Wood3.render(f5);
		Wood4.render(f5);
		Wood5.render(f5);
		Wood6.render(f5);
		Wood7.render(f5);
		Wood8.render(f5);
		Wood9.render(f5);
		Wood10.render(f5);
		Wood11.render(f5);
		Wood12.render(f5);
		Wood13.render(f5);
	}

	public void renderModel(float f) {
		Stone1.render(f);
		Stone2.render(f);
		Stone3.render(f);
		Stone4.render(f);
		Stone5.render(f);
		Stone6.render(f);
		Stone7.render(f);
		Stone8.render(f);
		Stone9.render(f);
		Stone10.render(f);
		Stone11.render(f);
		Stone12.render(f);
		Stone13.render(f);
		Stone14.render(f);
		Stone15.render(f);
		Stone16.render(f);
		Stone17.render(f);
		Stone18.render(f);
		Stone19.render(f);
		Stone20.render(f);
		Stone21.render(f);
		Stone22.render(f);
		Stone23.render(f);
		Stone24.render(f);
		Stone25.render(f);
		Stone26.render(f);
		Stone27.render(f);
		Stone28.render(f);
		Stone29.render(f);
		Stone30.render(f);
		Stone31.render(f);
		Stone32.render(f);
		Stone33.render(f);
		Stone34.render(f);
		Stone35.render(f);
		Stone36.render(f);
		Stone37.render(f);
		Stone38.render(f);
		Stone39.render(f);
		Stone40.render(f);
		Stone41.render(f);
		Stone42.render(f);
		Stone43.render(f);
		Stone44.render(f);
		Stone45.render(f);
		Stone46.render(f);
		Stone47.render(f);
		Stone48.render(f);
		Stone49.render(f);
		Stone50.render(f);
		Stone51.render(f);
		Stone52.render(f);
		Stone53.render(f);
		Stone54.render(f);
		Stone55.render(f);
		Stone56.render(f);
		Stone57.render(f);
		Stone58.render(f);
		Stone59.render(f);
		Stone69.render(f);
		Stone70.render(f);
		Stone71.render(f);
		Stone72.render(f);
		Stone60.render(f);
		Stone61.render(f);
		Stone62.render(f);
		Stone63.render(f);
		Stone64.render(f);
		Stone65.render(f);
		Stone66.render(f);
		Stone67.render(f);
		Stone68.render(f);
		Wood1.render(f);
		Wood2.render(f);
		Wood3.render(f);
		Wood4.render(f);
		Wood5.render(f);
		Wood6.render(f);
		Wood7.render(f);
		Wood8.render(f);
		Wood9.render(f);
		Wood10.render(f);
		Wood11.render(f);
		Wood12.render(f);
		Wood13.render(f);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
