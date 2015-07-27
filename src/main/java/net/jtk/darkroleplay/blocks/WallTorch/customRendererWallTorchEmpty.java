package net.jtk.darkroleplay.blocks.WallTorch;

import org.lwjgl.opengl.GL11;

import net.jtk.darkroleplay.blocks.WallTorch.ModelWallTorchEmpty;
import net.jtk.darkroleplay.main.DarkRoleplay;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class customRendererWallTorchEmpty  extends TileEntitySpecialRenderer {
	private static final ResourceLocation texture = new ResourceLocation(DarkRoleplay.MODID, "textures/blockWallTorchEmpty.png");

	private ModelWallTorchEmpty model;

	public customRendererWallTorchEmpty() {
		this.model = new ModelWallTorchEmpty();
	}
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f, int i) {
		if(tileentity.getWorld().getBlockState(tileentity.getPos()).getBlock().equals(WallTorchEmpty.blockWallTorchEmpty)){
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 0.75F, (float) z + 0.5F);
			GL11.glRotatef(180, 0F, 0F, 1F);
			PropertyInteger DIR = PropertyInteger.create("dir", 0, 3);
			IBlockState state = tileentity.getWorld().getBlockState(tileentity.getPos());
			int facing = (((Integer) state.getValue(DIR)).intValue());
			GL11.glRotatef((facing) * 90, 0.0F, 1.0F, 0.0F); 
			this.bindTexture(texture);
	
			this.model.renderModel(0.031255F);
	
			GL11.glPopMatrix();
		}
	}

}
class ModelWallTorchEmpty extends ModelBase
{
  //fields
    ModelRenderer Holder1;
    ModelRenderer Holder8;
    ModelRenderer Holder7;
    ModelRenderer Holder6;
    ModelRenderer Holder3;
    ModelRenderer Holder9;
    ModelRenderer Holder2;
    ModelRenderer Holder4;
    ModelRenderer Holder5;
  
  public ModelWallTorchEmpty()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      Holder1 = new ModelRenderer(this, 16, 27);
      Holder1.addBox(-1F, -13.9F, -2.2F, 2, 2, 3);
      Holder1.setRotationPoint(0F, 18F, 16F);
      Holder1.setTextureSize(32, 32);
      Holder1.mirror = true;
      setRotation(Holder1, 0.0349066F, 0F, 0F);
      Holder8 = new ModelRenderer(this, 0, 26);
      Holder8.addBox(-3F, -4F, -5F, 6, 2, 1);
      Holder8.setRotationPoint(0F, 18F, 16F);
      Holder8.setTextureSize(32, 32);
      Holder8.mirror = true;
      setRotation(Holder8, 0.2617994F, 0F, 0F);
      Holder7 = new ModelRenderer(this, 0, 14);
      Holder7.addBox(-3F, -4F, -4F, 1, 2, 4);
      Holder7.setRotationPoint(0F, 18F, 16F);
      Holder7.setTextureSize(32, 32);
      Holder7.mirror = true;
      setRotation(Holder7, 0.2617994F, 0F, 0F);
      Holder6 = new ModelRenderer(this, 0, 29);
      Holder6.addBox(-3F, -4F, 0F, 6, 2, 1);
      Holder6.setRotationPoint(0F, 18F, 16F);
      Holder6.setTextureSize(32, 32);
      Holder6.mirror = true;
      setRotation(Holder6, 0.2617994F, 0F, 0F);
      Holder3 = new ModelRenderer(this, 0, 20);
      Holder3.addBox(-3F, -14F, -4F, 1, 2, 4);
      Holder3.setRotationPoint(0F, 18F, 16F);
      Holder3.setTextureSize(32, 32);
      Holder3.mirror = true;
      setRotation(Holder3, 0.2617994F, 0F, 0F);
      Holder9 = new ModelRenderer(this, 0, 14);
      Holder9.addBox(2F, -4F, -4F, 1, 2, 4);
      Holder9.setRotationPoint(0F, 18F, 16F);
      Holder9.setTextureSize(32, 32);
      Holder9.mirror = true;
      setRotation(Holder9, 0.2617994F, 0F, 0F);
      Holder2 = new ModelRenderer(this, 0, 29);
      Holder2.addBox(-3F, -14F, 0F, 6, 2, 1);
      Holder2.setRotationPoint(0F, 18F, 16F);
      Holder2.setTextureSize(32, 32);
      Holder2.mirror = true;
      setRotation(Holder2, 0.2617994F, 0F, 0F);
      Holder4 = new ModelRenderer(this, 0, 26);
      Holder4.addBox(-3F, -14F, -5F, 6, 2, 1);
      Holder4.setRotationPoint(0F, 18F, 16F);
      Holder4.setTextureSize(32, 32);
      Holder4.mirror = true;
      setRotation(Holder4, 0.2617994F, 0F, 0F);
      Holder5 = new ModelRenderer(this, 0, 14);
      Holder5.addBox(2F, -14F, -4F, 1, 2, 4);
      Holder5.setRotationPoint(0F, 18F, 16F);
      Holder5.setTextureSize(32, 32);
      Holder5.mirror = true;
      setRotation(Holder5, 0.2617994F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    Holder1.render(f5);
    Holder8.render(f5);
    Holder7.render(f5);
    Holder6.render(f5);
    Holder3.render(f5);
    Holder9.render(f5);
    Holder2.render(f5);
    Holder4.render(f5);
    Holder5.render(f5);
  }
  
  public void renderModel(float f5) {
    Holder1.render(f5);
    Holder8.render(f5);
    Holder7.render(f5);
    Holder6.render(f5);
    Holder3.render(f5);
    Holder9.render(f5);
    Holder2.render(f5);
    Holder4.render(f5);
    Holder5.render(f5);
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
