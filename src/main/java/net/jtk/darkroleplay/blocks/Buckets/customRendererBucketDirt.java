package net.jtk.darkroleplay.blocks.Buckets;

import org.lwjgl.opengl.GL11;

import net.jtk.darkroleplay.DarkRoleplay;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class customRendererBucketDirt  extends TileEntitySpecialRenderer{

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockBucketDirt.png");

	private ModelBucketDirt model;

	public customRendererBucketDirt() {
		this.model = new ModelBucketDirt();
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
class ModelBucketDirt extends ModelBase {
	//fields
    ModelRenderer Shape11;
    ModelRenderer Shape10;
    ModelRenderer Shape1;
    ModelRenderer Shape13;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape9;
    ModelRenderer Shape5;
    ModelRenderer Shape8;
    ModelRenderer Shape14;
    ModelRenderer Shape15;
    ModelRenderer Shape7;
    ModelRenderer Shape6;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
    ModelRenderer Shape18;
    ModelRenderer Shape4;
    ModelRenderer Shape12;
  
  public ModelBucketDirt()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Shape11 = new ModelRenderer(this, 0, 9);
      Shape11.addBox(-2F, -8F, 0F, 4, 8, 1);
      Shape11.setRotationPoint(-2.4F, 24F, 2.4F);
      Shape11.setTextureSize(64, 64);
      Shape11.mirror = true;
      setRotation(Shape11, -0.148353F, -0.7853982F, 0F);
      Shape10 = new ModelRenderer(this, 0, 9);
      Shape10.addBox(-2F, -8F, -1F, 4, 8, 1);
      Shape10.setRotationPoint(-2.4F, 24F, -2.4F);
      Shape10.setTextureSize(64, 64);
      Shape10.mirror = true;
      setRotation(Shape10, 0.1570796F, 0.7853982F, 0F);
      Shape1 = new ModelRenderer(this, 8, 44);
      Shape1.addBox(0F, 0F, 0F, 6, 1, 6);
      Shape1.setRotationPoint(-3F, 22F, -3F);
      Shape1.setTextureSize(64, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape13 = new ModelRenderer(this, 0, 9);
      Shape13.addBox(-2F, -8F, 0F, 4, 8, 1);
      Shape13.setRotationPoint(3.1F, 24.1F, -3.1F);
      Shape13.setTextureSize(64, 64);
      Shape13.mirror = true;
      setRotation(Shape13, 0.1570796F, -0.7853982F, 0F);
      Shape2 = new ModelRenderer(this, 0, 50);
      Shape2.addBox(0F, 0F, 0F, 1, 1, 4);
      Shape2.setRotationPoint(-4F, 22F, -2F);
      Shape2.setTextureSize(64, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 19);
      Shape3.addBox(-2F, -8F, -1F, 4, 8, 1);
      Shape3.setRotationPoint(0F, 24F, -3.5F);
      Shape3.setTextureSize(64, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0.1396263F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 0, 45);
      Shape9.addBox(0F, 0F, 0F, 4, 1, 1);
      Shape9.setRotationPoint(-2F, 22F, -4F);
      Shape9.setTextureSize(64, 64);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 19);
      Shape5.addBox(-2F, -7F, 0F, 4, 8, 1);
      Shape5.setRotationPoint(0F, 23F, 3.5F);
      Shape5.setTextureSize(64, 64);
      Shape5.mirror = true;
      setRotation(Shape5, -0.1396263F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 45);
      Shape8.addBox(0F, 0F, 0F, 4, 1, 1);
      Shape8.setRotationPoint(-2F, 22F, 3F);
      Shape8.setTextureSize(64, 64);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape14 = new ModelRenderer(this, 12, 20);
      Shape14.addBox(0F, 0F, 0F, 6, 1, 6);
      Shape14.setRotationPoint(-3F, 18F, -3F);
      Shape14.setTextureSize(64, 64);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, 0F, 0F);
      Shape15 = new ModelRenderer(this, 15, 30);
      Shape15.addBox(0F, 0F, 0F, 6, 1, 1);
      Shape15.setRotationPoint(3F, 18F, 3F);
      Shape15.setTextureSize(64, 64);
      Shape15.mirror = true;
      setRotation(Shape15, 0F, 1.570796F, 0F);
      Shape7 = new ModelRenderer(this, 0, 30);
      Shape7.addBox(0F, -8F, -2F, 1, 8, 4);
      Shape7.setRotationPoint(3.5F, 24F, 0F);
      Shape7.setTextureSize(64, 64);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0.1396263F);
      Shape6 = new ModelRenderer(this, 0, 50);
      Shape6.addBox(0F, 0F, 0F, 1, 1, 4);
      Shape6.setRotationPoint(3F, 22F, -2F);
      Shape6.setTextureSize(64, 64);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape16 = new ModelRenderer(this, 15, 30);
      Shape16.addBox(0F, 0F, 0F, 6, 1, 1);
      Shape16.setRotationPoint(-3F, 18F, -4F);
      Shape16.setTextureSize(64, 64);
      Shape16.mirror = true;
      setRotation(Shape16, 0F, 0F, 0F);
      Shape17 = new ModelRenderer(this, 15, 30);
      Shape17.addBox(0F, 0F, 0F, 6, 1, 1);
      Shape17.setRotationPoint(-3F, 18F, 3F);
      Shape17.setTextureSize(64, 64);
      Shape17.mirror = true;
      setRotation(Shape17, 0F, 0F, 0F);
      Shape18 = new ModelRenderer(this, 15, 30);
      Shape18.addBox(0F, 0F, 0F, 6, 1, 1);
      Shape18.setRotationPoint(-4F, 18F, 3F);
      Shape18.setTextureSize(64, 64);
      Shape18.mirror = true;
      setRotation(Shape18, 0F, 1.570796F, 0F);
      Shape4 = new ModelRenderer(this, 0, 30);
      Shape4.addBox(-1F, -8F, -2F, 1, 8, 4);
      Shape4.setRotationPoint(-3.5F, 24F, 0F);
      Shape4.setTextureSize(64, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, -0.1396263F);
      Shape12 = new ModelRenderer(this, 0, 9);
      Shape12.addBox(-2F, -8F, -1F, 4, 8, 1);
      Shape12.setRotationPoint(3F, 24.2F, 3F);
      Shape12.setTextureSize(64, 64);
      Shape12.mirror = true;
      setRotation(Shape12, -0.1570796F, 0.7853982F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    Shape11.render(f5);
    Shape10.render(f5);
    Shape1.render(f5);
    Shape13.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape9.render(f5);
    Shape5.render(f5);
    Shape8.render(f5);
    Shape14.render(f5);
    Shape15.render(f5);
    Shape7.render(f5);
    Shape6.render(f5);
    Shape16.render(f5);
    Shape17.render(f5);
    Shape18.render(f5);
    Shape4.render(f5);
    Shape12.render(f5);
  }
  public void renderModel(float f5) {
	  Shape11.render(f5);
	    Shape10.render(f5);
	    Shape1.render(f5);
	    Shape13.render(f5);
	    Shape2.render(f5);
	    Shape3.render(f5);
	    Shape9.render(f5);
	    Shape5.render(f5);
	    Shape8.render(f5);
	    Shape14.render(f5);
	    Shape15.render(f5);
	    Shape7.render(f5);
	    Shape6.render(f5);
	    Shape16.render(f5);
	    Shape17.render(f5);
	    Shape18.render(f5);
	    Shape4.render(f5);
	    Shape12.render(f5);
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
