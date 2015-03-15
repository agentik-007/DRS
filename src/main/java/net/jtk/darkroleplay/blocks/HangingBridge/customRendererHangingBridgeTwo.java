package net.jtk.darkroleplay.blocks.HangingBridge;

import net.jtk.darkroleplay.DarkRoleplay;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class customRendererHangingBridgeTwo extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockHangingBridgeTwo.png");

	private ModelHangingBridgeTwo model;

	public customRendererHangingBridgeTwo() {
		this.model = new ModelHangingBridgeTwo();
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
		GL11.glRotatef((facing-1) * 90, 0.0F, 1.0F, 0.0F); 
		this.bindTexture(texture);

		this.model.renderModel(0.0625F);

		GL11.glPopMatrix();
	}

}

class ModelHangingBridgeTwo extends ModelBase {

	  //fields
	    ModelRenderer HangingBridge1;
	    ModelRenderer HangingBridge13;
	    ModelRenderer HangingBridge12;
	    ModelRenderer HangingBridge11;
	    ModelRenderer HangingBridge10;
	    ModelRenderer HangingBridge2;
	    ModelRenderer HangingBridge17;
	    ModelRenderer HangingBridge3;
	    ModelRenderer HangingBridge4;
	    ModelRenderer HangingBridge6;
	    ModelRenderer HangingBridge8;
	    ModelRenderer HangingBridge14;
	    ModelRenderer HangingBridge5;
	    ModelRenderer HangingBridge7;
	    ModelRenderer HangingBridge9;
	    ModelRenderer HangingBridge15;
	    ModelRenderer HangingBridge16;
	    ModelRenderer Rope2;
	    ModelRenderer Rope1;
	    ModelRenderer Log2;
	    ModelRenderer Log3;
	    ModelRenderer Log4;
	    ModelRenderer Rope4;
	    ModelRenderer Rope3;
	    ModelRenderer Log1;
	  
	  public ModelHangingBridgeTwo()
	  {
	    textureWidth = 128;
	    textureHeight = 64;
	    
	      HangingBridge1 = new ModelRenderer(this, 32, 9);
	      HangingBridge1.addBox(-0.5F, -1F, 0F, 1, 1, 14);
	      HangingBridge1.setRotationPoint(5.5F, 9F, 10.5F);
	      HangingBridge1.setTextureSize(128, 64);
	      HangingBridge1.mirror = true;
	      setRotation(HangingBridge1, -1.745329F, 0F, 0F);
	      HangingBridge13 = new ModelRenderer(this, 0, 42);
	      HangingBridge13.addBox(0F, 0F, 0F, 4, 2, 20);
	      HangingBridge13.setRotationPoint(3.5F, 22F, -10F);
	      HangingBridge13.setTextureSize(128, 64);
	      HangingBridge13.mirror = true;
	      setRotation(HangingBridge13, 0F, 0F, 0F);
	      HangingBridge12 = new ModelRenderer(this, 0, 42);
	      HangingBridge12.addBox(0F, 0F, 0F, 4, 2, 20);
	      HangingBridge12.setRotationPoint(-7.5F, 22F, -10F);
	      HangingBridge12.setTextureSize(128, 64);
	      HangingBridge12.mirror = true;
	      setRotation(HangingBridge12, 0F, 0F, 0F);
	      HangingBridge11 = new ModelRenderer(this, 32, 45);
	      HangingBridge11.addBox(-0.5F, -1F, 0F, 1, 1, 14);
	      HangingBridge11.setRotationPoint(-5.5F, 9F, 10.5F);
	      HangingBridge11.setTextureSize(128, 64);
	      HangingBridge11.mirror = true;
	      setRotation(HangingBridge11, -1.745329F, 0F, 0F);
	      HangingBridge10 = new ModelRenderer(this, 0, 10);
	      HangingBridge10.addBox(0F, 0F, 0F, 16, 1, 1);
	      HangingBridge10.setRotationPoint(-8F, 22.5F, -7F);
	      HangingBridge10.setTextureSize(128, 64);
	      HangingBridge10.mirror = true;
	      setRotation(HangingBridge10, 0F, 0F, 0F);
	      HangingBridge2 = new ModelRenderer(this, 32, 9);
	      HangingBridge2.addBox(-0.5F, 0F, 0F, 1, 1, 14);
	      HangingBridge2.setRotationPoint(5.5F, 9F, -10.5F);
	      HangingBridge2.setTextureSize(128, 64);
	      HangingBridge2.mirror = true;
	      setRotation(HangingBridge2, -1.396263F, 0F, 0F);
	      HangingBridge17 = new ModelRenderer(this, 78, 46);
	      HangingBridge17.addBox(0F, 0F, 0F, 6, 3, 6);
	      HangingBridge17.setRotationPoint(-15F, 7.3F, 8F);
	      HangingBridge17.setTextureSize(128, 64);
	      HangingBridge17.mirror = true;
	      setRotation(HangingBridge17, 0F, 0F, 0F);
	      HangingBridge3 = new ModelRenderer(this, 32, 24);
	      HangingBridge3.addBox(-0.5F, 0F, 0F, 1, 1, 14);
	      HangingBridge3.setRotationPoint(0F, 9F, -10.5F);
	      HangingBridge3.setTextureSize(128, 64);
	      HangingBridge3.mirror = true;
	      setRotation(HangingBridge3, -1.396263F, 0F, 0F);
	      HangingBridge4 = new ModelRenderer(this, 32, 24);
	      HangingBridge4.addBox(-0.5F, -1F, 0F, 1, 1, 14);
	      HangingBridge4.setRotationPoint(0F, 9F, 10.5F);
	      HangingBridge4.setTextureSize(128, 64);
	      HangingBridge4.mirror = true;
	      setRotation(HangingBridge4, -1.745329F, 0F, 0F);
	      HangingBridge6 = new ModelRenderer(this, 0, 20);
	      HangingBridge6.addBox(0F, 0F, 0F, 4, 2, 20);
	      HangingBridge6.setRotationPoint(-2F, 22F, -10F);
	      HangingBridge6.setTextureSize(128, 64);
	      HangingBridge6.mirror = true;
	      setRotation(HangingBridge6, 0F, 0F, 0F);
	      HangingBridge8 = new ModelRenderer(this, 0, 8);
	      HangingBridge8.addBox(0F, 0F, 0F, 16, 1, 1);
	      HangingBridge8.setRotationPoint(-8F, 22.5F, 6F);
	      HangingBridge8.setTextureSize(128, 64);
	      HangingBridge8.mirror = true;
	      setRotation(HangingBridge8, 0F, 0F, 0F);
	      HangingBridge14 = new ModelRenderer(this, 0, 12);
	      HangingBridge14.addBox(0F, 0F, -2F, 2, 2, 2);
	      HangingBridge14.setRotationPoint(-10F, 8F, 12F);
	      HangingBridge14.setTextureSize(128, 64);
	      HangingBridge14.mirror = true;
	      setRotation(HangingBridge14, -0.1919862F, 0F, 0F);
	      HangingBridge5 = new ModelRenderer(this, 32, 45);
	      HangingBridge5.addBox(-0.5F, 0F, 0F, 1, 1, 14);
	      HangingBridge5.setRotationPoint(-5.5F, 9F, -10.5F);
	      HangingBridge5.setTextureSize(128, 64);
	      HangingBridge5.mirror = true;
	      setRotation(HangingBridge5, -1.396263F, 0F, 0F);
	      HangingBridge7 = new ModelRenderer(this, 0, 12);
	      HangingBridge7.addBox(0F, 0F, -2F, 16, 2, 2);
	      HangingBridge7.setRotationPoint(-8F, 8F, 12F);
	      HangingBridge7.setTextureSize(128, 64);
	      HangingBridge7.mirror = true;
	      setRotation(HangingBridge7, -0.1919862F, 0F, 0F);
	      HangingBridge9 = new ModelRenderer(this, 0, 16);
	      HangingBridge9.addBox(0F, 0F, 0F, 16, 2, 2);
	      HangingBridge9.setRotationPoint(-8F, 8F, -12F);
	      HangingBridge9.setTextureSize(128, 64);
	      HangingBridge9.mirror = true;
	      setRotation(HangingBridge9, 0.1919862F, 0F, 0F);
	      HangingBridge15 = new ModelRenderer(this, 0, 16);
	      HangingBridge15.addBox(0F, 0F, 0F, 2, 2, 2);
	      HangingBridge15.setRotationPoint(-10F, 8F, -12F);
	      HangingBridge15.setTextureSize(128, 64);
	      HangingBridge15.mirror = true;
	      setRotation(HangingBridge15, 0.1919862F, 0F, 0F);
	      HangingBridge16 = new ModelRenderer(this, 78, 55);
	      HangingBridge16.addBox(0F, 0F, 0F, 6, 3, 6);
	      HangingBridge16.setRotationPoint(-15F, 7.3F, -14F);
	      HangingBridge16.setTextureSize(128, 64);
	      HangingBridge16.mirror = true;
	      setRotation(HangingBridge16, 0F, 0F, 0F);
	      Rope2 = new ModelRenderer(this, 78, 34);
	      Rope2.addBox(0F, 0F, 0F, 4, 2, 4);
	      Rope2.setRotationPoint(-27.5F, 20F, -13F);
	      Rope2.setTextureSize(128, 64);
	      Rope2.mirror = true;
	      setRotation(Rope2, 0F, 0F, 0F);
	      Rope1 = new ModelRenderer(this, 78, 40);
	      Rope1.addBox(0F, 0F, 0F, 4, 2, 4);
	      Rope1.setRotationPoint(-27.5F, 20F, 9F);
	      Rope1.setTextureSize(128, 64);
	      Rope1.mirror = true;
	      setRotation(Rope1, 0F, 0F, 0F);
	      Log2 = new ModelRenderer(this, 62, 20);
	      Log2.addBox(0F, 0F, 0F, 4, 18, 4);
	      Log2.setRotationPoint(-14F, 6F, -13F);
	      Log2.setTextureSize(128, 64);
	      Log2.mirror = true;
	      setRotation(Log2, 0F, 0F, 0F);
	      Log3 = new ModelRenderer(this, 62, 12);
	      Log3.addBox(0F, 0F, 0F, 3, 5, 3);
	      Log3.setRotationPoint(-27F, 19F, -12.5F);
	      Log3.setTextureSize(128, 64);
	      Log3.mirror = true;
	      setRotation(Log3, 0F, 0F, 0F);
	      Log4 = new ModelRenderer(this, 62, 4);
	      Log4.addBox(0F, 0F, 0F, 3, 5, 3);
	      Log4.setRotationPoint(-27F, 19F, 9.5F);
	      Log4.setTextureSize(128, 64);
	      Log4.mirror = true;
	      setRotation(Log4, 0F, 0F, 0F);
	      Rope4 = new ModelRenderer(this, 106, 47);
	      Rope4.addBox(0F, 0F, 0F, 1, 16, 1);
	      Rope4.setRotationPoint(-15F, 8F, -11.5F);
	      Rope4.setTextureSize(128, 64);
	      Rope4.mirror = true;
	      setRotation(Rope4, 0F, 0F, 0.6108652F);
	      Rope3 = new ModelRenderer(this, 102, 47);
	      Rope3.addBox(0F, 0F, 0F, 1, 16, 1);
	      Rope3.setRotationPoint(-15F, 8F, 10.5F);
	      Rope3.setTextureSize(128, 64);
	      Rope3.mirror = true;
	      setRotation(Rope3, 0F, 0F, 0.6108652F);
	      Log1 = new ModelRenderer(this, 62, 42);
	      Log1.addBox(0F, 0F, 0F, 4, 18, 4);
	      Log1.setRotationPoint(-14F, 6F, 9F);
	      Log1.setTextureSize(128, 64);
	      Log1.mirror = true;
	      setRotation(Log1, 0F, 0F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
	    HangingBridge1.render(f5);
	    HangingBridge13.render(f5);
	    HangingBridge12.render(f5);
	    HangingBridge11.render(f5);
	    HangingBridge10.render(f5);
	    HangingBridge2.render(f5);
	    HangingBridge17.render(f5);
	    HangingBridge3.render(f5);
	    HangingBridge4.render(f5);
	    HangingBridge6.render(f5);
	    HangingBridge8.render(f5);
	    HangingBridge14.render(f5);
	    HangingBridge5.render(f5);
	    HangingBridge7.render(f5);
	    HangingBridge9.render(f5);
	    HangingBridge15.render(f5);
	    HangingBridge16.render(f5);
	    Rope2.render(f5);
	    Rope1.render(f5);
	    Log2.render(f5);
	    Log3.render(f5);
	    Log4.render(f5);
	    Rope4.render(f5);
	    Rope3.render(f5);
	    Log1.render(f5);
	  }
	  
	  public void renderModel(float f5) {
		  HangingBridge1.render(f5);
		    HangingBridge13.render(f5);
		    HangingBridge12.render(f5);
		    HangingBridge11.render(f5);
		    HangingBridge10.render(f5);
		    HangingBridge2.render(f5);
		    HangingBridge17.render(f5);
		    HangingBridge3.render(f5);
		    HangingBridge4.render(f5);
		    HangingBridge6.render(f5);
		    HangingBridge8.render(f5);
		    HangingBridge14.render(f5);
		    HangingBridge5.render(f5);
		    HangingBridge7.render(f5);
		    HangingBridge9.render(f5);
		    HangingBridge15.render(f5);
		    HangingBridge16.render(f5);
		    Rope2.render(f5);
		    Rope1.render(f5);
		    Log2.render(f5);
		    Log3.render(f5);
		    Log4.render(f5);
		    Rope4.render(f5);
		    Rope3.render(f5);
		    Log1.render(f5); 
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
