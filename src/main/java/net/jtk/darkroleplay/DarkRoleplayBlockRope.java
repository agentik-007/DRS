package net.jtk.darkroleplay;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DarkRoleplayBlockRope extends BlockContainer {

	public static Block blockRope;

	public static Object instance;

	public DarkRoleplayBlockRope() {
		super(Material.wood);
		this.setBlockBounds(1.0F / 16F * 7F, 0.0F, 1.0F / 16F * 7F,1.0F / 16F * 9F, 1.0F / 16F * 16F, 1.0F / 16F * 9F);
	}

	static {

		blockRope = new DarkRoleplayBlockRope().setHardness(0.3F)
				.setResistance(10.0F).setLightLevel(0.0F)
				.setUnlocalizedName("blockRope")
				.setStepSound(Block.soundTypeCloth)
				.setCreativeTab(DarkRoleplayTabs.drBlocksTab);
				//blockRope.setBlockBounds(1.0F / 16F * 7F, 0.0F, 1.0F / 16F * 7F,1.0F / 16F * 9F, 1.0F / 16F * 16F, 1.0F / 16F * 9F);
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
		return new TileEntityCustomRope();
	}

	public static void serverLoad(FMLServerStartingEvent event) {
	}
	
	public static void Init(FMLInitializationEvent event){
		GameRegistry.addRecipe(new ItemStack(DarkRoleplayBlockRope.blockRope, 1), " X ", " X ", " X ", 'X', Items.string);
	}

	public static void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerBlock(blockRope, "blockRope");
		GameRegistry.registerTileEntity(TileEntityCustomRope.class, "TileEntityRope");
	}
}

class TileEntityCustomRope extends TileEntity {
}

class ItemRendererBlockRope implements IItemRenderer {

	private ModelRope model;

	public ItemRendererBlockRope() {
		model = new ModelRope();
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
				new TileEntityCustomRope(), 0.0D, 0.0D, 0.0D, 0.0F);
	}

}

class customRendererRope extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockRope.png");

	private ModelRope model;

	public customRendererRope() {
		this.model = new ModelRope();
	}

	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f, int i) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		GL11.glRotatef(tileentity.getBlockMetadata() * 90, 0.0F, 1.0F, 0.0F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		this.model.renderModel(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}

class ModelRope extends ModelBase {
	// fields
	ModelRenderer Shape1;

	public ModelRope() {
		textureWidth = 32;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 2, 16, 2);
		Shape1.setRotationPoint(-1F, 8F, -1F);
		Shape1.setTextureSize(32, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape1.render(f5);
	}

	public void renderModel(float f5) {
		Shape1.render(f5);
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
