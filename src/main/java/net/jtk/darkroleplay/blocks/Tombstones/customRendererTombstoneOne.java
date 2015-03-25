package net.jtk.darkroleplay.blocks.Tombstones;

import net.jtk.darkroleplay.main.DarkRoleplay;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class customRendererTombstoneOne extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockTombstoneOne.png");

	private ModelTombstoneOne model;

	public customRendererTombstoneOne() {
		this.model = new ModelTombstoneOne();
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
		GL11.glRotatef((facing+3)* 90, 0.0F, 1.0F, 0.0F); 
		this.bindTexture(texture);

		this.model.renderModel(0.0625F);

		GL11.glPopMatrix();
	}

}

class ModelTombstoneOne extends ModelBase {

	// fields
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;

	public ModelTombstoneOne() {
		textureWidth = 32;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 0, 16);
		Shape1.addBox(0F, -2F, 0F, 2, 2, 14);
		Shape1.setRotationPoint(0F, 13F, -5.2F);
		Shape1.setTextureSize(32, 32);
		Shape1.mirror = true;
		setRotation(Shape1, -0.1858931F, -0.3490659F, 0F);
		Shape2 = new ModelRenderer(this, 0, 11);
		Shape2.addBox(0F, -16F, 0F, 2, 17, 2);
		Shape2.setRotationPoint(-1F, 23F, -1F);
		Shape2.setTextureSize(32, 32);
		Shape2.mirror = true;
		setRotation(Shape2, -0.1858931F, -0.3490659F, 0F);
		Shape3 = new ModelRenderer(this, 16, 0);
		Shape3.addBox(0F, 0F, 0F, 3, 1, 5);
		Shape3.setRotationPoint(-3.4F, 12.5F, 3.5F);
		Shape3.setTextureSize(32, 32);
		Shape3.mirror = true;
		setRotation(Shape3, -2.530727F, -0.3490659F, 0F);
		Shape4 = new ModelRenderer(this, 0, 0);
		Shape4.addBox(0F, 0F, 0F, 3, 1, 5);
		Shape4.setRotationPoint(-2.3F, 11.1F, 0.3F);
		Shape4.setTextureSize(32, 32);
		Shape4.mirror = true;
		setRotation(Shape4, -0.9599311F, -0.3490659F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5,entity);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
	}

	public void renderModel(float f5) {
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
	}

}
