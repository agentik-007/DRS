package net.jtk.darkroleplay.blocks.ChoppingBlock;

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

public class customRendererChoppingBlock extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockChoppingBlock.png");

	private ModelChoppingBlock model;

	public customRendererChoppingBlock() {
		this.model = new ModelChoppingBlock();
	}
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int i) {
		if(tileentity.getWorld().getBlockState(tileentity.getPos()).getBlock().equals(ChoppingBlock.blockChoppingBlock)){
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

class ModelChoppingBlock extends ModelBase {
	// fields
	ModelRenderer Axt12;
	ModelRenderer Baumstamm1;
	ModelRenderer Axt11;
	ModelRenderer Baumstamm2;
	ModelRenderer Axt10;
	ModelRenderer Baumstamm3;
	ModelRenderer Axt9;
	ModelRenderer Baumstamm4;
	ModelRenderer Axt8;
	ModelRenderer Baumstamm5;
	ModelRenderer Axt7;
	ModelRenderer Baumstamm6;
	ModelRenderer Axt6;
	ModelRenderer Baumstamm7;
	ModelRenderer Axt5;
	ModelRenderer Baumstamm8;
	ModelRenderer Axt4;
	ModelRenderer Baumstamm9;
	ModelRenderer Axt3;
	ModelRenderer Axt1;
	ModelRenderer Axt2;

	public ModelChoppingBlock() {
		textureWidth = 64;
		textureHeight = 128;

		Axt12 = new ModelRenderer(this, 20, 100);
		Axt12.addBox(0F, 0F, 0F, 3, 1, 1);
		Axt12.setRotationPoint(5F, 1F, 0F);
		Axt12.setTextureSize(64, 128);
		Axt12.mirror = true;
		setRotation(Axt12, 0F, 0F, 0F);
		Baumstamm1 = new ModelRenderer(this, 0, 42);
		Baumstamm1.addBox(0F, 0F, 0F, 1, 12, 6);
		Baumstamm1.setRotationPoint(6F, 12F, -3F);
		Baumstamm1.setTextureSize(64, 128);
		Baumstamm1.mirror = true;
		setRotation(Baumstamm1, 0F, 0F, 0F);
		Axt11 = new ModelRenderer(this, 25, 95);
		Axt11.addBox(0F, 0F, 0F, 3, 1, 1);
		Axt11.setRotationPoint(4F, 2F, 0F);
		Axt11.setTextureSize(64, 128);
		Axt11.mirror = true;
		setRotation(Axt11, 0F, 0F, 0F);
		Baumstamm2 = new ModelRenderer(this, 34, 42);
		Baumstamm2.addBox(0F, 0F, 0F, 6, 12, 1);
		Baumstamm2.setRotationPoint(-3F, 12F, 6F);
		Baumstamm2.setTextureSize(64, 128);
		Baumstamm2.mirror = true;
		setRotation(Baumstamm2, 0F, 0F, 0F);
		Axt10 = new ModelRenderer(this, 27, 88);
		Axt10.addBox(0F, 0F, 0F, 2, 1, 1);
		Axt10.setRotationPoint(6F, 0F, 0F);
		Axt10.setTextureSize(64, 128);
		Axt10.mirror = true;
		setRotation(Axt10, 0F, 0F, 0F);
		Baumstamm3 = new ModelRenderer(this, 34, 42);
		Baumstamm3.addBox(0F, 0F, 0F, 6, 12, 1);
		Baumstamm3.setRotationPoint(-3F, 12F, -7F);
		Baumstamm3.setTextureSize(64, 128);
		Baumstamm3.mirror = true;
		setRotation(Baumstamm3, 0F, 0F, 0F);
		Axt9 = new ModelRenderer(this, 25, 95);
		Axt9.addBox(0F, 0F, 0F, 3, 1, 1);
		Axt9.setRotationPoint(2F, 4F, 0F);
		Axt9.setTextureSize(64, 128);
		Axt9.mirror = true;
		setRotation(Axt9, 0F, 0F, 0F);
		Baumstamm4 = new ModelRenderer(this, 0, 26);
		Baumstamm4.addBox(0F, 0F, 0F, 10, 12, 1);
		Baumstamm4.setRotationPoint(-5F, 12F, 5F);
		Baumstamm4.setTextureSize(64, 128);
		Baumstamm4.mirror = true;
		setRotation(Baumstamm4, 0F, 0F, 0F);
		Axt8 = new ModelRenderer(this, 25, 95);
		Axt8.addBox(0F, 0F, 0F, 3, 1, 1);
		Axt8.setRotationPoint(1F, 5F, 0F);
		Axt8.setTextureSize(64, 128);
		Axt8.mirror = true;
		setRotation(Axt8, 0F, 0F, 0F);
		Baumstamm5 = new ModelRenderer(this, 0, 0);
		Baumstamm5.addBox(0F, 0F, 0F, 10, 12, 10);
		Baumstamm5.setRotationPoint(-5F, 12F, -5F);
		Baumstamm5.setTextureSize(64, 128);
		Baumstamm5.mirror = true;
		setRotation(Baumstamm5, 0F, 0F, 0F);
		Axt7 = new ModelRenderer(this, 20, 100);
		Axt7.addBox(0F, 0F, 0F, 3, 1, 1);
		Axt7.setRotationPoint(0F, 6F, 0F);
		Axt7.setTextureSize(64, 128);
		Axt7.mirror = true;
		setRotation(Axt7, 0F, 0F, 0F);
		Baumstamm6 = new ModelRenderer(this, 0, 42);
		Baumstamm6.addBox(0F, 0F, 0F, 1, 12, 6);
		Baumstamm6.setRotationPoint(-7F, 12F, -3F);
		Baumstamm6.setTextureSize(64, 128);
		Baumstamm6.mirror = true;
		setRotation(Baumstamm6, 0F, 0F, 0F);
		Axt6 = new ModelRenderer(this, 8, 101);
		Axt6.addBox(0F, 0F, 0F, 2, 1, 1);
		Axt6.setRotationPoint(-3F, 6F, 0F);
		Axt6.setTextureSize(64, 128);
		Axt6.mirror = true;
		setRotation(Axt6, 0F, 0F, 0F);
		Baumstamm7 = new ModelRenderer(this, 32, 17);
		Baumstamm7.addBox(0F, 0F, 0F, 1, 12, 10);
		Baumstamm7.setRotationPoint(-6F, 12F, -5F);
		Baumstamm7.setTextureSize(64, 128);
		Baumstamm7.mirror = true;
		setRotation(Baumstamm7, 0F, 0F, 0F);
		Axt5 = new ModelRenderer(this, 7, 105);
		Axt5.addBox(0F, 0F, 0F, 6, 1, 1);
		Axt5.setRotationPoint(-4F, 7F, 0F);
		Axt5.setTextureSize(64, 128);
		Axt5.mirror = true;
		setRotation(Axt5, 0F, 0F, 0F);
		Baumstamm8 = new ModelRenderer(this, 0, 26);
		Baumstamm8.addBox(0F, 0F, 0F, 10, 12, 1);
		Baumstamm8.setRotationPoint(-5F, 12F, -6F);
		Baumstamm8.setTextureSize(64, 128);
		Baumstamm8.mirror = true;
		setRotation(Baumstamm8, 0F, 0F, 0F);
		Axt4 = new ModelRenderer(this, 7, 109);
		Axt4.addBox(0F, 0F, 0F, 7, 1, 1);
		Axt4.setRotationPoint(-4F, 8F, 0F);
		Axt4.setTextureSize(64, 128);
		Axt4.mirror = true;
		setRotation(Axt4, 0F, 0F, 0F);
		Baumstamm9 = new ModelRenderer(this, 32, 17);
		Baumstamm9.addBox(0F, 0F, 0F, 1, 12, 10);
		Baumstamm9.setRotationPoint(5F, 12F, -5F);
		Baumstamm9.setTextureSize(64, 128);
		Baumstamm9.mirror = true;
		setRotation(Baumstamm9, 0F, 0F, 0F);
		Axt3 = new ModelRenderer(this, 9, 112);
		Axt3.addBox(0F, 0F, 0F, 7, 2, 1);
		Axt3.setRotationPoint(-3F, 9F, 0F);
		Axt3.setTextureSize(64, 128);
		Axt3.mirror = true;
		setRotation(Axt3, 0F, 0F, 0F);
		Axt1 = new ModelRenderer(this, 20, 100);
		Axt1.addBox(0F, 0F, 0F, 3, 1, 1);
		Axt1.setRotationPoint(3F, 3F, 0F);
		Axt1.setTextureSize(64, 128);
		Axt1.mirror = true;
		setRotation(Axt1, 0F, 0F, 0F);
		Axt2 = new ModelRenderer(this, 11, 116);
		Axt2.addBox(0F, 0F, 0F, 5, 1, 1);
		Axt2.setRotationPoint(-2F, 11F, 0F);
		Axt2.setTextureSize(64, 128);
		Axt2.mirror = true;
		setRotation(Axt2, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Axt12.render(f5);
		Baumstamm1.render(f5);
		Axt11.render(f5);
		Baumstamm2.render(f5);
		Axt10.render(f5);
		Baumstamm3.render(f5);
		Axt9.render(f5);
		Baumstamm4.render(f5);
		Axt8.render(f5);
		Baumstamm5.render(f5);
		Axt7.render(f5);
		Baumstamm6.render(f5);
		Axt6.render(f5);
		Baumstamm7.render(f5);
		Axt5.render(f5);
		Baumstamm8.render(f5);
		Axt4.render(f5);
		Baumstamm9.render(f5);
		Axt3.render(f5);
		Axt1.render(f5);
		Axt2.render(f5);
	}

	public void renderModel(float f5) {
		Axt12.render(f5);
		Baumstamm1.render(f5);
		Axt11.render(f5);
		Baumstamm2.render(f5);
		Axt10.render(f5);
		Baumstamm3.render(f5);
		Axt9.render(f5);
		Baumstamm4.render(f5);
		Axt8.render(f5);
		Baumstamm5.render(f5);
		Axt7.render(f5);
		Baumstamm6.render(f5);
		Axt6.render(f5);
		Baumstamm7.render(f5);
		Axt5.render(f5);
		Baumstamm8.render(f5);
		Axt4.render(f5);
		Baumstamm9.render(f5);
		Axt3.render(f5);
		Axt1.render(f5);
		Axt2.render(f5);
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

