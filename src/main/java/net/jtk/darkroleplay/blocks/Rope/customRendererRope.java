package net.jtk.darkroleplay.blocks.Rope;

import net.jtk.darkroleplay.main.DarkRoleplay;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class customRendererRope extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockRope.png");

	private ModelRope model;

	public customRendererRope() {
		this.model = new ModelRope();
	}
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f, int i) {
		if(tileentity.getWorld().getBlockState(tileentity.getPos()).getBlock().equals(Rope.blockRope)){
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			GL11.glRotatef(180, 0F, 0F, 1F);
			GL11.glRotatef(tileentity.getBlockMetadata() * 90, 0.0F, 1.0F, 0.0F);
			this.bindTexture(texture);
	
			this.model.renderModel(0.0625F);
	
			GL11.glPopMatrix();
		}
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

