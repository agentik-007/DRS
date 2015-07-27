package net.jtk.darkroleplay.blocks.PearYellow;

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

public class customRendererPearStandingYellow extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockPearStandingYellow.png");

	private ModelPearStandingYellow model;

	public customRendererPearStandingYellow() {
		this.model = new ModelPearStandingYellow();
	}
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f, int i) {
		if(tileentity.getWorld().getBlockState(tileentity.getPos()).getBlock().equals(PearStandingYellow.blockPearStandingYellow)){
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

}

class ModelPearStandingYellow extends ModelBase {
	// fields
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;

	public ModelPearStandingYellow() {
		textureWidth = 32;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 3, 3, 3);
		Shape1.setRotationPoint(-1.5F, 21F, -1.5F);
		Shape1.setTextureSize(32, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 10);
		Shape2.addBox(0F, 0F, 0F, 1, 2, 1);
		Shape2.setRotationPoint(-0.9F, 18F, -0.7F);
		Shape2.setTextureSize(32, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0.4461433F, 0.4461433F, 0F);
		Shape3 = new ModelRenderer(this, 0, 6);
		Shape3.addBox(0F, 0F, 0F, 2, 2, 2);
		Shape3.setRotationPoint(-1F, 19F, -1F);
		Shape3.setTextureSize(32, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5,entity);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
	}

	public void renderModel(float f5) {
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,float f4, float f5,Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
	}

}
