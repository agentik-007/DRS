package net.jtk.darkroleplay;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
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
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DarkRoleplayBlockDungeonChest extends BlockContainer {
	
	public static Block blockDungeonChest;

	public static Object instance;
	
	public static PropertyInteger DIR = PropertyInteger.create("dir", 0, 15);
	
	public DarkRoleplayBlockDungeonChest() {
		super(Material.wood);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DIR, Integer.valueOf(0)));
	}
	
	static {

		blockDungeonChest = new DarkRoleplayBlockDungeonChest()
				.setHardness(2.0F).setResistance(10.0F).setLightLevel(0.0F)
				.setUnlocalizedName("blockDungeonChest")
				.setStepSound(Block.soundTypeWood)
				.setCreativeTab(DarkRoleplayTabs.drBlocksTab);
		blockDungeonChest.setBlockBounds(1.0F / 16F * 1F, 0.0F,
				1.0F / 16F * 1F, 1.0F / 16F * 15F, 1.0F / 16F * 12F,
				1.0F / 16F * 15F);
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
		return new TileEntityCustomDungeonChest();
	}

	public static void serverLoad(FMLServerStartingEvent event) {
	}

	public static void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerBlock(blockDungeonChest, "blockDungeonChest");
		GameRegistry.registerTileEntity(TileEntityCustomDungeonChest.class, "TileEntityDungeonChest");
	}
}

class TileEntityCustomDungeonChest extends TileEntity {
}

/*class ItemRendererBlockDungeonChest implements IItemRenderer{

	private ModelDungeonChest model;
	
	public ItemRendererBlockDungeonChest(){
		this.model = new ModelDungeonChest();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		
		return false;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		((customRendererDungeonChest) customRendererDungeonChest.instance).renderTileEntityAt(new TileEntityCustomDungeonChest(), 0.0D,0.0D,0.0D, 0.0F, 0);
	}
	
}*/

class customRendererDungeonChest extends TileEntitySpecialRenderer {

	public static Object instance;

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockDungeonChest.png");

	private ModelDungeonChest model;

	public customRendererDungeonChest() {
		this.model = new ModelDungeonChest();
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
		GL11.glRotatef(facing * 90, 0.0F, 1.0F, 0.0F); 
		this.bindTexture(texture);

		this.model.renderModel(0.0625F);

		GL11.glPopMatrix();
	}

}

class ModelDungeonChest extends ModelBase {
	// fields
	ModelRenderer Chest10;
	ModelRenderer Chest9;
	ModelRenderer Chest8;
	ModelRenderer Chest7;
	ModelRenderer Chest6;
	ModelRenderer Chest1;
	ModelRenderer Chest2;
	ModelRenderer Chest3;
	ModelRenderer Chest4;
	ModelRenderer Chest5;

	public ModelDungeonChest() {
		textureWidth = 128;
		textureHeight = 64;

		Chest10 = new ModelRenderer(this, 56, 11);
		Chest10.addBox(-7F, -1F, 0F, 14, 1, 10);
		Chest10.setRotationPoint(0F, 13.5F, -5F);
		Chest10.setTextureSize(128, 64);
		Chest10.mirror = true;
		setRotation(Chest10, 0F, 0F, 0F);
		Chest9 = new ModelRenderer(this, 0, 22);
		Chest9.addBox(-7F, -1F, 0F, 14, 2, 12);
		Chest9.setRotationPoint(0F, 15F, -6F);
		Chest9.setTextureSize(128, 64);
		Chest9.mirror = true;
		setRotation(Chest9, 0F, 0F, 0F);
		Chest8 = new ModelRenderer(this, 0, 10);
		Chest8.addBox(-7F, -1F, 0F, 14, 1, 11);
		Chest8.setRotationPoint(0F, 14F, -5.5F);
		Chest8.setTextureSize(128, 64);
		Chest8.mirror = true;
		setRotation(Chest8, 0F, 0F, 0F);
		Chest7 = new ModelRenderer(this, 0, 0);
		Chest7.addBox(-7F, -1F, 0F, 14, 1, 6);
		Chest7.setRotationPoint(0F, 13F, -3F);
		Chest7.setTextureSize(128, 64);
		Chest7.mirror = true;
		setRotation(Chest7, 0F, 0F, 0F);
		Chest6 = new ModelRenderer(this, 0, 55);
		Chest6.addBox(0F, 0F, 0F, 12, 1, 8);
		Chest6.setRotationPoint(-6F, 23F, -4F);
		Chest6.setTextureSize(128, 64);
		Chest6.mirror = true;
		setRotation(Chest6, 0F, 0F, 0F);
		Chest1 = new ModelRenderer(this, 35, 40);
		Chest1.addBox(0F, 0F, 0F, 1, 8, 12);
		Chest1.setRotationPoint(6F, 16F, -6F);
		Chest1.setTextureSize(128, 64);
		Chest1.mirror = true;
		setRotation(Chest1, 0F, 0F, 0F);
		Chest2 = new ModelRenderer(this, 0, 37);
		Chest2.addBox(-1F, 0F, 0F, 2, 3, 1);
		Chest2.setRotationPoint(0F, 15F, -7F);
		Chest2.setTextureSize(128, 64);
		Chest2.mirror = true;
		setRotation(Chest2, 0F, 0F, 0F);
		Chest3 = new ModelRenderer(this, 0, 44);
		Chest3.addBox(0F, 0F, 0F, 12, 8, 1);
		Chest3.setRotationPoint(-6F, 16F, -6F);
		Chest3.setTextureSize(128, 64);
		Chest3.mirror = true;
		setRotation(Chest3, 0F, 0F, 0F);
		Chest4 = new ModelRenderer(this, 0, 44);
		Chest4.addBox(0F, 0F, 0F, 12, 8, 1);
		Chest4.setRotationPoint(-6F, 16F, 5F);
		Chest4.setTextureSize(128, 64);
		Chest4.mirror = true;
		setRotation(Chest4, 0F, 0F, 0F);
		Chest5 = new ModelRenderer(this, 35, 40);
		Chest5.addBox(0F, 0F, 0F, 1, 8, 12);
		Chest5.setRotationPoint(-7F, 16F, -6F);
		Chest5.setTextureSize(128, 64);
		Chest5.mirror = true;
		setRotation(Chest5, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Chest10.render(f5);
		Chest9.render(f5);
		Chest8.render(f5);
		Chest7.render(f5);
		Chest6.render(f5);
		Chest1.render(f5);
		Chest2.render(f5);
		Chest3.render(f5);
		Chest4.render(f5);
		Chest5.render(f5);
	}

	// must be copy and paste
	public void renderModel(float f) {
		Chest10.render(f);
		Chest9.render(f);
		Chest8.render(f);
		Chest7.render(f);
		Chest6.render(f);
		Chest1.render(f);
		Chest2.render(f);
		Chest3.render(f);
		Chest4.render(f);
		Chest5.render(f);
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
