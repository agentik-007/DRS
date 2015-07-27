package net.jtk.darkroleplay.blocks.AppleGreen;

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

public class customRendererAppleHangingGreen extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockAppleHangingGreen.png");

	private ModelAppleHangingGreen model;

	public customRendererAppleHangingGreen() {
		this.model = new ModelAppleHangingGreen();
	}
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f, int i) {
		if(tileentity.getWorld().getBlockState(tileentity.getPos()).getBlock().equals(AppleHangingGreen.blockAppleHangingGreen)){
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 2.1F, (float) z + 0.5F);
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

class ModelAppleHangingGreen extends ModelBase {
	 //fields
    ModelRenderer Apple1;
    ModelRenderer Apple2;
    ModelRenderer Apple3;
    ModelRenderer Apple4;
    ModelRenderer Apple5;
    ModelRenderer Apple6;
    ModelRenderer Apple7;
    ModelRenderer Apple8;
    ModelRenderer Apple9;
    ModelRenderer Apple10;
    ModelRenderer Apple11;
    ModelRenderer Apple12;
    ModelRenderer Apple13;
    ModelRenderer Apple14;
    ModelRenderer Apple15;
    ModelRenderer Apple16;
    ModelRenderer Apple17;
    ModelRenderer Apple18;
    ModelRenderer Apple19;
    ModelRenderer Apple20;
  
  public ModelAppleHangingGreen()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      Apple1 = new ModelRenderer(this, 20, 26);
      Apple1.addBox(0F, 0F, 0F, 3, 3, 3);
      Apple1.setRotationPoint(-1F, 20F, -2F);
      Apple1.setTextureSize(32, 32);
      Apple1.mirror = true;
      setRotation(Apple1, 0F, 0F, 0F);
      Apple2 = new ModelRenderer(this, 0, 28);
      Apple2.addBox(0F, 0F, 0F, 3, 3, 1);
      Apple2.setRotationPoint(-1F, 20F, 1F);
      Apple2.setTextureSize(32, 32);
      Apple2.mirror = true;
      setRotation(Apple2, 0F, 0F, 0F);
      Apple3 = new ModelRenderer(this, 0, 24);
      Apple3.addBox(0F, 0F, 0F, 3, 3, 1);
      Apple3.setRotationPoint(-1F, 20F, -3F);
      Apple3.setTextureSize(32, 32);
      Apple3.mirror = true;
      setRotation(Apple3, 0F, 0F, 0F);
      Apple4 = new ModelRenderer(this, 8, 26);
      Apple4.addBox(0F, 0F, 0F, 1, 3, 3);
      Apple4.setRotationPoint(-2F, 20F, -2F);
      Apple4.setTextureSize(32, 32);
      Apple4.mirror = true;
      setRotation(Apple4, 0F, 0F, 0F);
      Apple5 = new ModelRenderer(this, 8, 20);
      Apple5.addBox(0F, 0F, 0F, 1, 3, 3);
      Apple5.setRotationPoint(2F, 20F, -2F);
      Apple5.setTextureSize(32, 32);
      Apple5.mirror = true;
      setRotation(Apple5, 0F, 0F, 0F);
      Apple6 = new ModelRenderer(this, 20, 22);
      Apple6.addBox(0F, 0F, 0F, 3, 1, 3);
      Apple6.setRotationPoint(-1F, 23F, -2F);
      Apple6.setTextureSize(32, 32);
      Apple6.mirror = true;
      setRotation(Apple6, 0F, 0F, 0F);
      Apple7 = new ModelRenderer(this, 8, 18);
      Apple7.addBox(0F, 0F, 0F, 3, 1, 1);
      Apple7.setRotationPoint(-1F, 23.2F, 0.5F);
      Apple7.setTextureSize(32, 32);
      Apple7.mirror = true;
      setRotation(Apple7, 0.7853982F, 0F, 0F);
      Apple8 = new ModelRenderer(this, 28, 9);
      Apple8.addBox(0F, 0F, 0F, 1, 2, 1);
      Apple8.setRotationPoint(0F, 17.8F, -1.7F);
      Apple8.setTextureSize(32, 32);
      Apple8.mirror = true;
      setRotation(Apple8, 0.5585054F, 0F, 0F);
      Apple9 = new ModelRenderer(this, 20, 18);
      Apple9.addBox(0F, 0F, 0F, 3, 1, 3);
      Apple9.setRotationPoint(-1F, 19F, -2F);
      Apple9.setTextureSize(32, 32);
      Apple9.mirror = true;
      setRotation(Apple9, 0F, 0F, 0F);
      Apple10 = new ModelRenderer(this, 8, 12);
      Apple10.addBox(0F, 0F, 0F, 3, 1, 1);
      Apple10.setRotationPoint(-1F, 23.2F, -2.9F);
      Apple10.setTextureSize(32, 32);
      Apple10.mirror = true;
      setRotation(Apple10, 0.7853982F, 0F, 0F);
      Apple11 = new ModelRenderer(this, 8, 16);
      Apple11.addBox(0F, 0F, 0F, 3, 1, 1);
      Apple11.setRotationPoint(-1F, 19.8F, 0.5F);
      Apple11.setTextureSize(32, 32);
      Apple11.mirror = true;
      setRotation(Apple11, 0.7853982F, 0F, 0F);
      Apple12 = new ModelRenderer(this, 0, 4);
      Apple12.addBox(0F, 0F, 0F, 1, 3, 1);
      Apple12.setRotationPoint(-1.9F, 20F, 1.2F);
      Apple12.setTextureSize(32, 32);
      Apple12.mirror = true;
      setRotation(Apple12, 0F, 0.7853982F, 0F);
      Apple13 = new ModelRenderer(this, 8, 14);
      Apple13.addBox(0F, 0F, 0F, 3, 1, 1);
      Apple13.setRotationPoint(-1F, 19.8F, -2.9F);
      Apple13.setTextureSize(32, 32);
      Apple13.mirror = true;
      setRotation(Apple13, 0.7853982F, 0F, 0F);
      Apple14 = new ModelRenderer(this, 0, 0);
      Apple14.addBox(0F, 0F, 0F, 1, 3, 1);
      Apple14.setRotationPoint(1.5F, 20F, -2.2F);
      Apple14.setTextureSize(32, 32);
      Apple14.mirror = true;
      setRotation(Apple14, 0F, 0.7853982F, 0F);
      Apple15 = new ModelRenderer(this, 0, 20);
      Apple15.addBox(0F, 0F, 0F, 1, 1, 3);
      Apple15.setRotationPoint(-1.2F, 19.1F, -2F);
      Apple15.setTextureSize(32, 32);
      Apple15.mirror = true;
      setRotation(Apple15, 0F, 0F, 0.7853982F);
      Apple16 = new ModelRenderer(this, 0, 12);
      Apple16.addBox(0F, 0F, 0F, 1, 1, 3);
      Apple16.setRotationPoint(2.2F, 22.5F, -2F);
      Apple16.setTextureSize(32, 32);
      Apple16.mirror = true;
      setRotation(Apple16, 0F, 0F, 0.7853982F);
      Apple17 = new ModelRenderer(this, 0, 8);
      Apple17.addBox(0F, 0F, 0F, 1, 1, 3);
      Apple17.setRotationPoint(-1.2F, 22.5F, -2F);
      Apple17.setTextureSize(32, 32);
      Apple17.mirror = true;
      setRotation(Apple17, 0F, 0F, 0.7853982F);
      Apple18 = new ModelRenderer(this, 0, 16);
      Apple18.addBox(0F, 0F, 0F, 1, 1, 3);
      Apple18.setRotationPoint(2.2F, 19.1F, -2F);
      Apple18.setTextureSize(32, 32);
      Apple18.mirror = true;
      setRotation(Apple18, 0F, 0F, 0.7853982F);
      Apple19 = new ModelRenderer(this, 4, 4);
      Apple19.addBox(0F, 0F, 0F, 1, 3, 1);
      Apple19.setRotationPoint(1.5F, 20F, 1.2F);
      Apple19.setTextureSize(32, 32);
      Apple19.mirror = true;
      setRotation(Apple19, 0F, 0.7853982F, 0F);
      Apple20 = new ModelRenderer(this, 4, 0);
      Apple20.addBox(0F, 0F, 0F, 1, 3, 1);
      Apple20.setRotationPoint(-1.9F, 20F, -2.2F);
      Apple20.setTextureSize(32, 32);
      Apple20.mirror = true;
      setRotation(Apple20, 0F, 0.7853982F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    Apple1.render(f5);
    Apple2.render(f5);
    Apple3.render(f5);
    Apple4.render(f5);
    Apple5.render(f5);
    Apple6.render(f5);
    Apple7.render(f5);
    Apple8.render(f5);
    Apple9.render(f5);
    Apple10.render(f5);
    Apple11.render(f5);
    Apple12.render(f5);
    Apple13.render(f5);
    Apple14.render(f5);
    Apple15.render(f5);
    Apple16.render(f5);
    Apple17.render(f5);
    Apple18.render(f5);
    Apple19.render(f5);
    Apple20.render(f5);
  }
  
	public void renderModel(float f5) {
		Apple1.render(f5);
	    Apple2.render(f5);
	    Apple3.render(f5);
	    Apple4.render(f5);
	    Apple5.render(f5);
	    Apple6.render(f5);
	    Apple7.render(f5);
	    Apple8.render(f5);
	    Apple9.render(f5);
	    Apple10.render(f5);
	    Apple11.render(f5);
	    Apple12.render(f5);
	    Apple13.render(f5);
	    Apple14.render(f5);
	    Apple15.render(f5);
	    Apple16.render(f5);
	    Apple17.render(f5);
	    Apple18.render(f5);
	    Apple19.render(f5);
	    Apple20.render(f5);
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
