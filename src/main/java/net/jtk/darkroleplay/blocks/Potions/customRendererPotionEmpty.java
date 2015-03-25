package net.jtk.darkroleplay.blocks.Potions;

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

public class customRendererPotionEmpty extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockPotionEmpty.png");

	private ModelPotionEmpty model;

	public customRendererPotionEmpty() {
		this.model = new ModelPotionEmpty();
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
		GL11.glRotatef(facing * 45, 0.0F, 1.0F, 0.0F); 
		GL11.glEnable(GL11.GL_BLEND);
		this.bindTexture(texture);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		this.model.renderModel(0.0625F);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}

}

class ModelPotionEmpty extends ModelBase {
	 //fields
    ModelRenderer Potion5;
    ModelRenderer Potion6;
    ModelRenderer Potion4;
    ModelRenderer Potion3;
    ModelRenderer Potion1;
    ModelRenderer Potion2;
  
  public ModelPotionEmpty()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      Potion5 = new ModelRenderer(this, 0, 0);
      Potion5.addBox(0F, 0F, 0F, 5, 5, 5);
      Potion5.setRotationPoint(-2.5F, 19F, -2.5F);
      Potion5.setTextureSize(32, 32);
      Potion5.mirror = true;
      setRotation(Potion5, 0F, 0F, 0F);
      Potion6 = new ModelRenderer(this, 0, 26);
      Potion6.addBox(0F, 0F, 0F, 3, 3, 3);
      Potion6.setRotationPoint(-1.5F, 20F, -1.5F);
      Potion6.setTextureSize(32, 32);
      Potion6.mirror = true;
      setRotation(Potion6, 0F, 0F, 0F);
      Potion4 = new ModelRenderer(this, 0, 10);
      Potion4.addBox(0F, 0F, 0F, 3, 1, 3);
      Potion4.setRotationPoint(-1.5F, 18.5F, -1.5F);
      Potion4.setTextureSize(32, 32);
      Potion4.mirror = true;
      setRotation(Potion4, 0F, 0F, 0F);
      Potion3 = new ModelRenderer(this, 0, 22);
      Potion3.addBox(0F, 0F, 0F, 1, 2, 1);
      Potion3.setRotationPoint(-0.5F, 15F, -0.5F);
      Potion3.setTextureSize(32, 32);
      Potion3.mirror = true;
      setRotation(Potion3, 0F, 0F, 0F);
      Potion1 = new ModelRenderer(this, 0, 14);
      Potion1.addBox(0F, 0F, 0F, 3, 1, 3);
      Potion1.setRotationPoint(-1.5F, 15.5F, -1.5F);
      Potion1.setTextureSize(32, 32);
      Potion1.mirror = true;
      setRotation(Potion1, 0F, 0F, 0F);
      Potion2 = new ModelRenderer(this, 0, 18);
      Potion2.addBox(0F, 0F, 0F, 2, 2, 2);
      Potion2.setRotationPoint(-1F, 16.5F, -1F);
      Potion2.setTextureSize(32, 32);
      Potion2.mirror = true;
      setRotation(Potion2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    Potion5.render(f5);
    Potion6.render(f5);
    Potion4.render(f5);
    Potion3.render(f5);
    Potion1.render(f5);
    Potion2.render(f5);
  }
  
  public void renderModel(float f5){
	  Potion5.render(f5);
	    Potion6.render(f5);
	    Potion4.render(f5);
	    Potion3.render(f5);
	    Potion1.render(f5);
	    Potion2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
