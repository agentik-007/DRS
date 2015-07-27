package net.jtk.darkroleplay.blocks.Mushrooms;

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

public class customRendererMushroomBrown extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockMushroomBrown.png");

	private ModelMushroomBrown model;

	public customRendererMushroomBrown() {
		this.model = new ModelMushroomBrown();
	}
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f, int i) {
		if(tileentity.getWorld().getBlockState(tileentity.getPos()).getBlock().equals(MushroomBrown.blockMushroomBrown)){
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

class ModelMushroomBrown extends ModelBase {
	 //fields
    ModelRenderer Shape14;
    ModelRenderer Shape9;
    ModelRenderer Shape11;
    ModelRenderer Shape8;
    ModelRenderer Shape10;
    ModelRenderer Shape12;
    ModelRenderer Shape15;
    ModelRenderer Shape13;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape18;
    ModelRenderer Shape1;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
  
  public ModelMushroomBrown()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape14 = new ModelRenderer(this, 46, 20);
      Shape14.addBox(0F, 0F, 0F, 1, 1, 3);
      Shape14.setRotationPoint(2F, 20F, -5F);
      Shape14.setTextureSize(64, 32);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 12, 14);
      Shape9.addBox(0F, 0F, 0F, 1, 1, 5);
      Shape9.setRotationPoint(4F, 17F, 1F);
      Shape9.setTextureSize(64, 32);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 46, 28);
      Shape11.addBox(0F, 0F, 0F, 1, 1, 3);
      Shape11.setRotationPoint(6F, 20F, -5F);
      Shape11.setTextureSize(64, 32);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 12, 26);
      Shape8.addBox(0F, 0F, 0F, 1, 1, 5);
      Shape8.setRotationPoint(-2F, 17F, 1F);
      Shape8.setTextureSize(64, 32);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 12, 10);
      Shape10.addBox(0F, 0F, 0F, 5, 1, 1);
      Shape10.setRotationPoint(-1F, 17F, 0F);
      Shape10.setTextureSize(64, 32);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 46, 18);
      Shape12.addBox(0F, 0F, 0F, 3, 1, 1);
      Shape12.setRotationPoint(3F, 20F, -6F);
      Shape12.setTextureSize(64, 32);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0F);
      Shape15 = new ModelRenderer(this, 31, 13);
      Shape15.addBox(0F, 0F, 0F, 4, 1, 1);
      Shape15.setRotationPoint(-6F, 19F, -1F);
      Shape15.setTextureSize(64, 32);
      Shape15.mirror = true;
      setRotation(Shape15, 0F, 0F, 0F);
      Shape13 = new ModelRenderer(this, 44, 24);
      Shape13.addBox(0F, 0F, 0F, 3, 1, 3);
      Shape13.setRotationPoint(3F, 20F, -5F);
      Shape13.setTextureSize(64, 32);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 31, 17);
      Shape6.addBox(0F, 0F, 0F, 1, 1, 4);
      Shape6.setRotationPoint(-2F, 19F, -5F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 8, 20);
      Shape7.addBox(0F, 0F, 0F, 5, 1, 5);
      Shape7.setRotationPoint(-1F, 17F, 1F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 46, 16);
      Shape4.addBox(0F, 0F, 0F, 3, 1, 1);
      Shape4.setRotationPoint(3F, 20F, -2F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 20);
      Shape5.addBox(0F, 0F, 0F, 1, 4, 1);
      Shape5.setRotationPoint(-4.5F, 20F, -3.5F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 12, 12);
      Shape2.addBox(0F, 0F, 0F, 5, 1, 1);
      Shape2.setRotationPoint(-1F, 17F, 6F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 16);
      Shape3.addBox(0F, 0F, 0F, 1, 3, 1);
      Shape3.setRotationPoint(4F, 21F, -4F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape18 = new ModelRenderer(this, 31, 15);
      Shape18.addBox(0F, 0F, 0F, 4, 1, 1);
      Shape18.setRotationPoint(-6F, 19F, -6F);
      Shape18.setTextureSize(64, 32);
      Shape18.mirror = true;
      setRotation(Shape18, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 0, 25);
      Shape1.addBox(0F, 0F, 0F, 1, 6, 1);
      Shape1.setRotationPoint(1F, 18F, 3F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape16 = new ModelRenderer(this, 31, 27);
      Shape16.addBox(0F, 0F, 0F, 1, 1, 4);
      Shape16.setRotationPoint(-7F, 19F, -5F);
      Shape16.setTextureSize(64, 32);
      Shape16.mirror = true;
      setRotation(Shape16, 0F, 0F, 0F);
      Shape17 = new ModelRenderer(this, 28, 22);
      Shape17.addBox(0F, 0F, 0F, 4, 1, 4);
      Shape17.setRotationPoint(-6F, 19F, -5F);
      Shape17.setTextureSize(64, 32);
      Shape17.mirror = true;
      setRotation(Shape17, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    Shape14.render(f5);
    Shape9.render(f5);
    Shape11.render(f5);
    Shape8.render(f5);
    Shape10.render(f5);
    Shape12.render(f5);
    Shape15.render(f5);
    Shape13.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape18.render(f5);
    Shape1.render(f5);
    Shape16.render(f5);
    Shape17.render(f5);
  }
  
  public void renderModel(float f5){
	  Shape14.render(f5);
	    Shape9.render(f5);
	    Shape11.render(f5);
	    Shape8.render(f5);
	    Shape10.render(f5);
	    Shape12.render(f5);
	    Shape15.render(f5);
	    Shape13.render(f5);
	    Shape6.render(f5);
	    Shape7.render(f5);
	    Shape4.render(f5);
	    Shape5.render(f5);
	    Shape2.render(f5);
	    Shape3.render(f5);
	    Shape18.render(f5);
	    Shape1.render(f5);
	    Shape16.render(f5);
	    Shape17.render(f5);
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

