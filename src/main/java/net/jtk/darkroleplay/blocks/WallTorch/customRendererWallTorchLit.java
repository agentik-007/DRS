package net.jtk.darkroleplay.blocks.WallTorch;

import net.jtk.darkroleplay.main.DarkRoleplay;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class customRendererWallTorchLit extends TileEntitySpecialRenderer {
	private static final ResourceLocation texture = new ResourceLocation(DarkRoleplay.MODID, "textures/blockWallTorchLit.png");

	private ModelWallTorchLit model;
	private ModelWallTorchLitActive modelActive;

	public customRendererWallTorchLit() {
		this.model = new ModelWallTorchLit();
		this.modelActive = new ModelWallTorchLitActive();
	}
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f, int i) {
		if(tileentity.getWorld().getBlockState(tileentity.getPos()).getBlock().equals(WallTorchLit.blockWallTorchLit)){
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + 0.75F, (float) z + 0.5F);
			GL11.glRotatef(180, 0F, 0F, 1F);
			PropertyInteger DIR = PropertyInteger.create("dir", 0, 3);
			PropertyBool POWERED = PropertyBool.create("powered");
			IBlockState state = tileentity.getWorld().getBlockState(tileentity.getPos());
			int facing = (((Integer) state.getValue(DIR)).intValue());
			Boolean activated = ((Boolean) state.getValue(POWERED)).booleanValue();
			GL11.glRotatef((facing) * 90, 0.0F, 1.0F, 0.0F); 
			this.bindTexture(texture);
			
			if(activated)
			{
				this.modelActive.renderModel(0.031255F);
			}else{
				this.model.renderModel(0.031255F);
			}
	
			GL11.glPopMatrix();
		}
	}

}
class ModelWallTorchLit extends ModelBase
{
  //fields
    ModelRenderer Holder3;
    ModelRenderer Holder2;
    ModelRenderer Holder1;
    ModelRenderer TorchHandle;
  public ModelWallTorchLit()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      Holder3 = new ModelRenderer(this, 16, 27);
      Holder3.addBox(-1F, -13.9F, -2.2F, 2, 2, 3);
      Holder3.setRotationPoint(0F, 18F, 16F);
      Holder3.setTextureSize(32, 32);
      Holder3.mirror = true;
      setRotation(Holder3, 0.0349066F, 0F, 0F);
      Holder2 = new ModelRenderer(this, 0, 0);
      Holder2.addBox(-3F, -14F, -5F, 6, 2, 6);
      Holder2.setRotationPoint(0F, 18F, 16F);
      Holder2.setTextureSize(32, 32);
      Holder2.mirror = true;
      setRotation(Holder2, 0.2617994F, 0F, 0F);
      Holder1 = new ModelRenderer(this, 0, 0);
      Holder1.addBox(-3F, -4F, -5F, 6, 2, 6);
      Holder1.setRotationPoint(0F, 18F, 16F);
      Holder1.setTextureSize(32, 32);
      Holder1.mirror = true;
      setRotation(Holder1, 0.2617994F, 0F, 0F);
      TorchHandle = new ModelRenderer(this, 0, 8);
      TorchHandle.addBox(-2F, -20F, -4F, 4, 20, 4);
      TorchHandle.setRotationPoint(0F, 18F, 16F);
      TorchHandle.setTextureSize(32, 32);
      TorchHandle.mirror = true;
      setRotation(TorchHandle, 0.2617994F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    Holder3.render(f5);
    Holder2.render(f5);
    Holder1.render(f5);
    TorchHandle.render(f5);
  }
  
  public void renderModel(float f5)
  {
	  Holder3.render(f5);
	  Holder2.render(f5);
	  Holder1.render(f5);
	  TorchHandle.render(f5);
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

class ModelWallTorchLitActive extends ModelBase
{
  //fields
    ModelRenderer Holder1;
    ModelRenderer Holder2;
    ModelRenderer Holder3;
    ModelRenderer TorchHandle;
    ModelRenderer Holder4;
  
  public ModelWallTorchLitActive()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      Holder1 = new ModelRenderer(this, 16, 21);
      Holder1.addBox(-1F, -13.7F, -2.2F, 2, 2, 4);
      Holder1.setRotationPoint(0F, 18F, 16F);
      Holder1.setTextureSize(32, 32);
      Holder1.mirror = true;
      setRotation(Holder1, 0.0872665F, 0F, 0F);
      Holder2 = new ModelRenderer(this, 0, 0);
      Holder2.addBox(-3F, -14F, -5F, 6, 2, 6);
      Holder2.setRotationPoint(0F, 18F, 16F);
      Holder2.setTextureSize(32, 32);
      Holder2.mirror = true;
      setRotation(Holder2, 0.5235988F, 0F, 0F);
      Holder3 = new ModelRenderer(this, 0, 0);
      Holder3.addBox(-3F, -4F, -5F, 6, 2, 6);
      Holder3.setRotationPoint(0F, 18F, 16F);
      Holder3.setTextureSize(32, 32);
      Holder3.mirror = true;
      setRotation(Holder3, 0.5235988F, 0F, 0F);
      TorchHandle = new ModelRenderer(this, 0, 8);
      TorchHandle.addBox(-2F, -20F, -4F, 4, 20, 4);
      TorchHandle.setRotationPoint(0F, 18F, 16F);
      TorchHandle.setTextureSize(32, 32);
      TorchHandle.mirror = true;
      setRotation(TorchHandle, 0.5235988F, 0F, 0F);
      Holder4 = new ModelRenderer(this, 16, 27);
      Holder4.addBox(-1F, -13.9F, -2.2F, 2, 2, 3);
      Holder4.setRotationPoint(0F, 18F, 16F);
      Holder4.setTextureSize(32, 32);
      Holder4.mirror = true;
      setRotation(Holder4, 0.296706F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    Holder1.render(f5);
    Holder2.render(f5);
    Holder3.render(f5);
    TorchHandle.render(f5);
    Holder4.render(f5);
  }
  
  public void renderModel(float f5)
  {
	  Holder1.render(f5);
	  Holder2.render(f5);
	  Holder3.render(f5);
	  TorchHandle.render(f5);
	  Holder4.render(f5);
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

