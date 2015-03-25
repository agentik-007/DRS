package net.jtk.darkroleplay.blocks.Firepits;

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

public class customRendererSmallFirepit extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockLargeFirepit.png");

	private ModelSmallFirepit model;

	public customRendererSmallFirepit() {
		this.model = new ModelSmallFirepit();
	}
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f, int i) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 0.77F, (float) z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		PropertyInteger DIR = PropertyInteger.create("dir", 0, 15);
		IBlockState state = tileentity.getWorld().getBlockState(tileentity.getPos());
		int facing = (((Integer) state.getValue(DIR)).intValue());
		GL11.glRotatef(facing * 90, 0.0F, 1.0F, 0.0F); 
		this.bindTexture(texture);

		this.model.renderModel(0.03125F);

		GL11.glPopMatrix();
	}

}

class ModelSmallFirepit extends ModelBase {
	// fields
	/*Old
	 * ModelRenderer Stock4; ModelRenderer Stein1; ModelRenderer Stock3;
	 * ModelRenderer Stein2; ModelRenderer Stock2; ModelRenderer Stein3;
	 * ModelRenderer Stock1; ModelRenderer Stein4; ModelRenderer Stein5;
	 * ModelRenderer Stein6; ModelRenderer Stein7; ModelRenderer Stein8;
	 * ModelRenderer Stein9; ModelRenderer Stein10; ModelRenderer Stein11;
	 * ModelRenderer Stein12; ModelRenderer Stein13; ModelRenderer Stein14;
	 * ModelRenderer Stein15; ModelRenderer Stein16; ModelRenderer Stein17;
	 * ModelRenderer Stein18; ModelRenderer Stein19; ModelRenderer Stein20;
	 * ModelRenderer Stein21; ModelRenderer Stein22; ModelRenderer Stein23;
	 * ModelRenderer Stein24; ModelRenderer Stein25; ModelRenderer Stein26;
	 * ModelRenderer Stein27; ModelRenderer Stein28; ModelRenderer Stein29;
	 * ModelRenderer Stein30; ModelRenderer Stein31; ModelRenderer Stein32;
	 * ModelRenderer Stein33; ModelRenderer Stein34; ModelRenderer Stein35;
	 * ModelRenderer Stein36; ModelRenderer Stein37; ModelRenderer Stein38;
	 * ModelRenderer Stein39; ModelRenderer Stein40; ModelRenderer Stein41;
	 * ModelRenderer Stein42; ModelRenderer Stein43; ModelRenderer Stein44;
	 */
	ModelRenderer Stone1;
	ModelRenderer Stone2;
	ModelRenderer Stone3;
	ModelRenderer Stone4;
	ModelRenderer Stone5;
	ModelRenderer Stone6;
	ModelRenderer Stone7;
	ModelRenderer Stone8;
	ModelRenderer Stone9;
	ModelRenderer Stone10;
	ModelRenderer Stone11;
	ModelRenderer Stone12;
	ModelRenderer Stone13;
	ModelRenderer Stone14;
	ModelRenderer Stone15;
	ModelRenderer Stone16;
	ModelRenderer Stone17;
	ModelRenderer Stone18;
	ModelRenderer Stone19;
	ModelRenderer Stone20;
	ModelRenderer Stone21;
	ModelRenderer Stone22;
	ModelRenderer Stone23;
	ModelRenderer Stone24;
	ModelRenderer Stone25;
	ModelRenderer Stone26;
	ModelRenderer Stone27;
	ModelRenderer Stone28;
	ModelRenderer Stone29;
	ModelRenderer Stone30;
	ModelRenderer Stone31;
	ModelRenderer Stone32;
	ModelRenderer Stone33;
	ModelRenderer Stone34;
	ModelRenderer Stone35;
	ModelRenderer Stone36;
	ModelRenderer Stone37;
	ModelRenderer Stone38;
	ModelRenderer Stone39;
	ModelRenderer Stone40;
	ModelRenderer Stone41;
	ModelRenderer Stone42;
	ModelRenderer Stone43;
	ModelRenderer Stone44;
	ModelRenderer Stone45;
	ModelRenderer Stone46;
	ModelRenderer Stone47;
	ModelRenderer Stone48;
	ModelRenderer Stone49;
	ModelRenderer Stone50;
	ModelRenderer Stone51;
	ModelRenderer Stone52;
	ModelRenderer Stone53;
	ModelRenderer Stone54;
	ModelRenderer Stone55;
	ModelRenderer Stone56;
	ModelRenderer Stone57;
	ModelRenderer Stone58;
	ModelRenderer Stone59;
	ModelRenderer Stone69;
	ModelRenderer Stone70;
	ModelRenderer Stone71;
	ModelRenderer Stone72;
	ModelRenderer Stone60;
	ModelRenderer Stone61;
	ModelRenderer Stone62;
	ModelRenderer Stone63;
	ModelRenderer Stone64;
	ModelRenderer Stone65;
	ModelRenderer Stone66;
	ModelRenderer Stone67;
	ModelRenderer Stone68;
	ModelRenderer Wood1;
	ModelRenderer Wood2;
	ModelRenderer Wood3;
	ModelRenderer Wood4;
	ModelRenderer Wood5;
	ModelRenderer Wood6;
	ModelRenderer Wood7;
	ModelRenderer Wood8;
	ModelRenderer Wood9;
	ModelRenderer Wood10;
	ModelRenderer Wood11;
	ModelRenderer Wood12;
	ModelRenderer Wood13;

	public ModelSmallFirepit() {
		textureWidth = 128;
		textureHeight = 128;

		/*Old
		 * Stock4 = new ModelRenderer(this, 48, 0); Stock4.addBox(0F, 0F, 0F, 2,
		 * 8, 2); Stock4.setRotationPoint(-1F, 17F, -1.8F);
		 * Stock4.setTextureSize(64, 64); Stock4.mirror = true;
		 * setRotation(Stock4, -0.3717861F, 0F, 0.1487144F); Stein1 = new
		 * ModelRenderer(this, 0, 20); Stein1.addBox(0F, 0F, 0F, 1, 1, 2);
		 * Stein1.setRotationPoint(5.5F, 23F, 2.5F); Stein1.setTextureSize(64,
		 * 64); Stein1.mirror = true; setRotation(Stein1, 0F, 0F, 0F); Stock3 =
		 * new ModelRenderer(this, 32, 0); Stock3.addBox(-1F, 0F, 0F, 2, 8, 2);
		 * Stock3.setRotationPoint(0F, 18F, 0F); Stock3.setTextureSize(64, 64);
		 * Stock3.mirror = true; setRotation(Stock3, 0.4089647F, 0.4089647F,
		 * 0F); Stein2 = new ModelRenderer(this, 12, 59); Stein2.addBox(0F, 0F,
		 * 0F, 2, 2, 3); Stein2.setRotationPoint(-5F, 23.53333F, -6F);
		 * Stein2.setTextureSize(64, 64); Stein2.mirror = true;
		 * setRotation(Stein2, 0F, 0F, 0F); Stock2 = new ModelRenderer(this, 40,
		 * 0); Stock2.addBox(-1F, 0F, 0F, 2, 8, 2); Stock2.setRotationPoint(0F,
		 * 18F, 0F); Stock2.setTextureSize(64, 64); Stock2.mirror = true;
		 * setRotation(Stock2, 0.3717861F, -1.412787F, 0F); Stein3 = new
		 * ModelRenderer(this, 10, 24); Stein3.addBox(0F, 0F, 0F, 1, 1, 2);
		 * Stein3.setRotationPoint(-6.5F, 23.5F, -4.5F);
		 * Stein3.setTextureSize(64, 64); Stein3.mirror = true;
		 * setRotation(Stein3, 0F, 0F, 0F); Stock1 = new ModelRenderer(this, 56,
		 * 0); Stock1.addBox(0F, 0F, -1F, 2, 8, 2); Stock1.setRotationPoint(1F,
		 * 17F, -1F); Stock1.setTextureSize(64, 64); Stock1.mirror = true;
		 * setRotation(Stock1, -0.4089647F, -0.9666439F, 0F); Stein4 = new
		 * ModelRenderer(this, 10, 24); Stein4.addBox(0F, 0F, 0F, 1, 1, 2);
		 * Stein4.setRotationPoint(-6F, 23F, -5F); Stein4.setTextureSize(64,
		 * 64); Stein4.mirror = true; setRotation(Stein4, 0F, 0F, 0F); Stein5 =
		 * new ModelRenderer(this, 0, 34); Stein5.addBox(0F, 0F, 0F, 2, 1, 2);
		 * Stein5.setRotationPoint(-5F, 22.5F, -5F); Stein5.setTextureSize(64,
		 * 64); Stein5.mirror = true; setRotation(Stein5, 0F, 0F, 0F); Stein6 =
		 * new ModelRenderer(this, 4, 50); Stein6.addBox(0F, 0F, 0F, 1, 1, 1);
		 * Stein6.setRotationPoint(3.5F, 22.5F, -4.5F);
		 * Stein6.setTextureSize(64, 64); Stein6.mirror = true;
		 * setRotation(Stein6, 0F, 0F, 0F); Stein7 = new ModelRenderer(this, 0,
		 * 25); Stein7.addBox(0F, 0F, 0F, 3, 1, 1); Stein7.setRotationPoint(-6F,
		 * 23F, -3F); Stein7.setTextureSize(64, 64); Stein7.mirror = true;
		 * setRotation(Stein7, 0F, 0F, 0F); Stein8 = new ModelRenderer(this, 0,
		 * 20); Stein8.addBox(0F, 0F, 0F, 1, 1, 2);
		 * Stein8.setRotationPoint(-5.5F, 23F, -0.5F); Stein8.setTextureSize(64,
		 * 64); Stein8.mirror = true; setRotation(Stein8, 0F, 0F, 0F); Stein9 =
		 * new ModelRenderer(this, 12, 20); Stein9.addBox(0F, 0F, 0F, 2, 1, 2);
		 * Stein9.setRotationPoint(-1F, 22.5F, 5F); Stein9.setTextureSize(64,
		 * 64); Stein9.mirror = true; setRotation(Stein9, 0F, 0F, 0F); Stein10 =
		 * new ModelRenderer(this, 0, 20); Stein10.addBox(0F, 0F, 0F, 1, 1, 2);
		 * Stein10.setRotationPoint(-6F, 23F, 4F); Stein10.setTextureSize(64,
		 * 64); Stein10.mirror = true; setRotation(Stein10, 0F, 0F, 0F); Stein11
		 * = new ModelRenderer(this, 10, 37); Stein11.addBox(0F, 0F, 0F, 2, 1,
		 * 1); Stein11.setRotationPoint(-5F, 22F, 4F);
		 * Stein11.setTextureSize(64, 64); Stein11.mirror = true;
		 * setRotation(Stein11, 0F, 0F, 0F); Stein12 = new ModelRenderer(this,
		 * 0, 37); Stein12.addBox(0F, 0F, 0F, 1, 1, 1);
		 * Stein12.setRotationPoint(-5F, 22F, 5F); Stein12.setTextureSize(64,
		 * 64); Stein12.mirror = true; setRotation(Stein12, 0F, 0F, 0F); Stein13
		 * = new ModelRenderer(this, 0, 37); Stein13.addBox(0F, 0F, 0F, 1, 1,
		 * 1); Stein13.setRotationPoint(-4F, 23F, 6F);
		 * Stein13.setTextureSize(64, 64); Stein13.mirror = true;
		 * setRotation(Stein13, 0F, 0F, 0F); Stein14 = new ModelRenderer(this,
		 * 0, 27); Stein14.addBox(0F, 0F, 0F, 3, 1, 1);
		 * Stein14.setRotationPoint(3F, 23F, 2.5F); Stein14.setTextureSize(64,
		 * 64); Stein14.mirror = true; setRotation(Stein14, 0F, 0F, 0F); Stein15
		 * = new ModelRenderer(this, 10, 24); Stein15.addBox(0F, 0F, 0F, 1, 2,
		 * 2); Stein15.setRotationPoint(2.5F, 23F, 3F);
		 * Stein15.setTextureSize(64, 64); Stein15.mirror = true;
		 * setRotation(Stein15, 0F, 0F, 0F); Stein16 = new ModelRenderer(this,
		 * 0, 23); Stein16.addBox(0F, 0F, 0F, 1, 1, 1);
		 * Stein16.setRotationPoint(6F, 23.5F, 4F); Stein16.setTextureSize(64,
		 * 64); Stein16.mirror = true; setRotation(Stein16, 0F, 0F, 0F); Stein17
		 * = new ModelRenderer(this, 0, 25); Stein17.addBox(0F, 0F, 0F, 3, 1,
		 * 1); Stein17.setRotationPoint(3F, 23F, 4.5F);
		 * Stein17.setTextureSize(64, 64); Stein17.mirror = true;
		 * setRotation(Stein17, 0F, 0F, 0F); Stein18 = new ModelRenderer(this,
		 * 10, 37); Stein18.addBox(0F, 0F, 0F, 2, 1, 1);
		 * Stein18.setRotationPoint(5F, 23F, 0F); Stein18.setTextureSize(64,
		 * 64); Stein18.mirror = true; setRotation(Stein18, 0F, 0F, 0F); Stein19
		 * = new ModelRenderer(this, 10, 20); Stein19.addBox(0F, 0F, 0F, 3, 2,
		 * 2); Stein19.setRotationPoint(3F, 22.5F, 3F);
		 * Stein19.setTextureSize(64, 64); Stein19.mirror = true;
		 * setRotation(Stein19, 0F, 0F, 0F); Stein20 = new ModelRenderer(this,
		 * 0, 51); Stein20.addBox(0F, 0F, 0F, 1, 1, 1);
		 * Stein20.setRotationPoint(-1F, 23F, -6F); Stein20.setTextureSize(64,
		 * 64); Stein20.mirror = true; setRotation(Stein20, 0F, 0F, 0F); Stein21
		 * = new ModelRenderer(this, 0, 50); Stein21.addBox(0F, 0F, 0F, 1, 1,
		 * 1); Stein21.setRotationPoint(4.5F, 23F, -5F);
		 * Stein21.setTextureSize(64, 64); Stein21.mirror = true;
		 * setRotation(Stein21, 0F, 0F, 0F); Stein22 = new ModelRenderer(this,
		 * 8, 45); Stein22.addBox(0F, 0F, 0F, 2, 1, 1);
		 * Stein22.setRotationPoint(3F, 23.5F, -3.5F);
		 * Stein22.setTextureSize(64, 64); Stein22.mirror = true;
		 * setRotation(Stein22, 0F, 0F, 0F); Stein23 = new ModelRenderer(this,
		 * 0, 48); Stein23.addBox(0F, 0F, 0F, 3, 1, 1);
		 * Stein23.setRotationPoint(3F, 23.5F, -5.5F);
		 * Stein23.setTextureSize(64, 64); Stein23.mirror = true;
		 * setRotation(Stein23, 0F, 0F, 0F); Stein24 = new ModelRenderer(this,
		 * 8, 47); Stein24.addBox(0F, 0F, 0F, 1, 2, 2);
		 * Stein24.setRotationPoint(-3F, 23F, -5F); Stein24.setTextureSize(64,
		 * 64); Stein24.mirror = true; setRotation(Stein24, 0F, 0F, 0F); Stein25
		 * = new ModelRenderer(this, 0, 57); Stein25.addBox(0F, 0F, 0F, 1, 1,
		 * 2); Stein25.setRotationPoint(0F, 22.5F, -6F);
		 * Stein25.setTextureSize(64, 64); Stein25.mirror = true;
		 * setRotation(Stein25, 0F, 0F, 0F); Stein26 = new ModelRenderer(this,
		 * 0, 60); Stein26.addBox(0F, 0F, 0F, 3, 1, 3);
		 * Stein26.setRotationPoint(-1F, 23.5F, -7F); Stein26.setTextureSize(64,
		 * 64); Stein26.mirror = true; setRotation(Stein26, 0F, 0F, 0F); Stein27
		 * = new ModelRenderer(this, 0, 54); Stein27.addBox(0F, 0F, 0F, 2, 1,
		 * 2); Stein27.setRotationPoint(0F, 23F, -7F);
		 * Stein27.setTextureSize(64, 64); Stein27.mirror = true;
		 * setRotation(Stein27, 0F, 0F, 0F); Stein28 = new ModelRenderer(this,
		 * 0, 37); Stein28.addBox(0F, 0F, 0F, 1, 1, 1);
		 * Stein28.setRotationPoint(6.5F, 23F, -1F); Stein28.setTextureSize(64,
		 * 64); Stein28.mirror = true; setRotation(Stein28, 0F, 0F, 0F); Stein29
		 * = new ModelRenderer(this, 0, 34); Stein29.addBox(0F, 0F, 0F, 2, 1,
		 * 2); Stein29.setRotationPoint(4.5F, 23F, -2F);
		 * Stein29.setTextureSize(64, 64); Stein29.mirror = true;
		 * setRotation(Stein29, 0F, 0F, 0F); Stein30 = new ModelRenderer(this,
		 * 8, 33); Stein30.addBox(0F, 0F, 0F, 2, 2, 2);
		 * Stein30.setRotationPoint(5F, 22.5F, -1.5F);
		 * Stein30.setTextureSize(64, 64); Stein30.mirror = true;
		 * setRotation(Stein30, 0F, 0F, 0F); Stein31 = new ModelRenderer(this,
		 * 0, 39); Stein31.addBox(0F, 0F, 0F, 1, 1, 2);
		 * Stein31.setRotationPoint(7F, 23.5F, -1.5F);
		 * Stein31.setTextureSize(64, 64); Stein31.mirror = true;
		 * setRotation(Stein31, 0F, 0F, 0F); Stein32 = new ModelRenderer(this,
		 * 0, 45); Stein32.addBox(0F, 0F, 0F, 2, 1, 2);
		 * Stein32.setRotationPoint(3F, 23F, -5F); Stein32.setTextureSize(64,
		 * 64); Stein32.mirror = true; setRotation(Stein32, 0F, 0F, 0F); Stein33
		 * = new ModelRenderer(this, 0, 52); Stein33.addBox(0F, 0F, 0F, 3, 1,
		 * 1); Stein33.setRotationPoint(2.5F, 23.5F, -4F);
		 * Stein33.setTextureSize(64, 64); Stein33.mirror = true;
		 * setRotation(Stein33, 0F, 0F, 0F); Stein34 = new ModelRenderer(this,
		 * 9, 52); Stein34.addBox(0F, 0F, 0F, 3, 1, 2);
		 * Stein34.setRotationPoint(-5F, 23F, 4F); Stein34.setTextureSize(64,
		 * 64); Stein34.mirror = true; setRotation(Stein34, 0F, 0F, 0F); Stein35
		 * = new ModelRenderer(this, 0, 23); Stein35.addBox(0F, 0F, 0F, 1, 1,
		 * 1); Stein35.setRotationPoint(-2F, 23.5F, 5F);
		 * Stein35.setTextureSize(64, 64); Stein35.mirror = true;
		 * setRotation(Stein35, 0F, 0F, 0F); Stein36 = new ModelRenderer(this,
		 * 9, 52); Stein36.addBox(0F, 0F, 0F, 3, 1, 2);
		 * Stein36.setRotationPoint(-1F, 23F, 5F); Stein36.setTextureSize(64,
		 * 64); Stein36.mirror = true; setRotation(Stein36, 0F, 0F, 0F); Stein37
		 * = new ModelRenderer(this, 12, 20); Stein37.addBox(0F, 0F, 0F, 2, 1,
		 * 2); Stein37.setRotationPoint(-2F, 23F, 6F);
		 * Stein37.setTextureSize(64, 64); Stein37.mirror = true;
		 * setRotation(Stein37, 0F, 0F, 0F); Stein38 = new ModelRenderer(this,
		 * 10, 37); Stein38.addBox(0F, 0F, 0F, 2, 1, 1);
		 * Stein38.setRotationPoint(-5F, 23F, 3F); Stein38.setTextureSize(64,
		 * 64); Stein38.mirror = true; setRotation(Stein38, 0F, 0F, 0F); Stein39
		 * = new ModelRenderer(this, 10, 24); Stein39.addBox(0F, 0F, 0F, 1, 1,
		 * 2); Stein39.setRotationPoint(-6.5F, 22F, -0.5F);
		 * Stein39.setTextureSize(64, 64); Stein39.mirror = true;
		 * setRotation(Stein39, 0F, 0F, 0F); Stein40 = new ModelRenderer(this,
		 * 0, 23); Stein40.addBox(0F, 0F, 0F, 1, 1, 1);
		 * Stein40.setRotationPoint(-6.5F, 23F, 1.5F);
		 * Stein40.setTextureSize(64, 64); Stein40.mirror = true;
		 * setRotation(Stein40, 0F, 0F, 0F); Stein41 = new ModelRenderer(this,
		 * 10, 37); Stein41.addBox(0F, 0F, 0F, 2, 1, 1);
		 * Stein41.setRotationPoint(-7F, 23F, -1.5F); Stein41.setTextureSize(64,
		 * 64); Stein41.mirror = true; setRotation(Stein41, 0F, 0F, 0F); Stein42
		 * = new ModelRenderer(this, 10, 24); Stein42.addBox(0F, 0F, 0F, 1, 1,
		 * 2); Stein42.setRotationPoint(-8F, 23F, -1F);
		 * Stein42.setTextureSize(64, 64); Stein42.mirror = true;
		 * setRotation(Stein42, 0F, 0F, 0F); Stein43 = new ModelRenderer(this,
		 * 12, 59); Stein43.addBox(0F, 0F, 0F, 2, 2, 3);
		 * Stein43.setRotationPoint(-7F, 22.5F, -1F); Stein43.setTextureSize(64,
		 * 64); Stein43.mirror = true; setRotation(Stein43, 0F, 0F, 0F); Stein44
		 * = new ModelRenderer(this, 12, 20); Stein44.addBox(0F, 0F, 0F, 2, 1,
		 * 2); Stein44.setRotationPoint(-1F, 23.5F, 4F);
		 * Stein44.setTextureSize(64, 64); Stein44.mirror = true;
		 * setRotation(Stein44, 0F, 0F, 0F);
		 */
		Stone1 = new ModelRenderer(this, 0, 0);
		Stone1.addBox(0F, 0F, 0F, 5, 3, 1);
		Stone1.setRotationPoint(-5F, 22.5F, -22F);
		Stone1.setTextureSize(128, 128);
		Stone1.mirror = true;
		setRotation(Stone1, 0F, 0F, 0F);
		Stone2 = new ModelRenderer(this, 0, 0);
		Stone2.addBox(0F, 0F, 0F, 1, 3, 2);
		Stone2.setRotationPoint(-3.5F, 22F, 18.5F);
		Stone2.setTextureSize(128, 128);
		Stone2.mirror = true;
		setRotation(Stone2, 0F, 0F, 0F);
		Stone3 = new ModelRenderer(this, 0, 0);
		Stone3.addBox(0F, 0F, 0F, 3, 2, 3);
		Stone3.setRotationPoint(-1.5F, 22F, -20F);
		Stone3.setTextureSize(128, 128);
		Stone3.mirror = true;
		setRotation(Stone3, 0F, 0F, 0F);
		Stone4 = new ModelRenderer(this, 0, 0);
		Stone4.addBox(0F, 0F, 0F, 1, 3, 3);
		Stone4.setRotationPoint(-6.5F, 22F, -20F);
		Stone4.setTextureSize(128, 128);
		Stone4.mirror = true;
		setRotation(Stone4, 0F, 0F, 0F);
		Stone5 = new ModelRenderer(this, 0, 0);
		Stone5.addBox(0F, 0F, 0F, 5, 1, 3);
		Stone5.setRotationPoint(-5F, 21F, -20F);
		Stone5.setTextureSize(128, 128);
		Stone5.mirror = true;
		setRotation(Stone5, 0F, 0F, 0F);
		Stone6 = new ModelRenderer(this, 0, 0);
		Stone6.addBox(0F, 0F, 0F, 6, 3, 4);
		Stone6.setRotationPoint(-4F, 21F, 15F);
		Stone6.setTextureSize(128, 128);
		Stone6.mirror = true;
		setRotation(Stone6, 0F, 0F, 0F);
		Stone7 = new ModelRenderer(this, 0, 0);
		Stone7.addBox(0F, 0F, 0F, 2, 3, 4);
		Stone7.setRotationPoint(-7F, 23F, -21.5F);
		Stone7.setTextureSize(128, 128);
		Stone7.mirror = true;
		setRotation(Stone7, 0F, 0F, 0F);
		Stone8 = new ModelRenderer(this, 0, 0);
		Stone8.addBox(0F, 0F, 0F, 7, 3, 5);
		Stone8.setRotationPoint(-6F, 21.5F, -21F);
		Stone8.setTextureSize(128, 128);
		Stone8.mirror = true;
		setRotation(Stone8, 0F, 0F, 0F);
		Stone9 = new ModelRenderer(this, 0, 0);
		Stone9.addBox(0F, 0F, 0F, 1, 2, 1);
		Stone9.setRotationPoint(20.5F, 22F, -0.5F);
		Stone9.setTextureSize(128, 128);
		Stone9.mirror = true;
		setRotation(Stone9, 0F, 0F, 0F);
		Stone10 = new ModelRenderer(this, 0, 0);
		Stone10.addBox(0F, 0F, 0F, 5, 1, 3);
		Stone10.setRotationPoint(-2F, 20F, 17F);
		Stone10.setTextureSize(128, 128);
		Stone10.mirror = true;
		setRotation(Stone10, 0F, 0F, 0F);
		Stone11 = new ModelRenderer(this, 0, 0);
		Stone11.addBox(0F, 0F, 0F, 1, 2, 2);
		Stone11.setRotationPoint(3.5F, 22.5F, 17F);
		Stone11.setTextureSize(128, 128);
		Stone11.mirror = true;
		setRotation(Stone11, 0F, 0F, 0F);
		Stone12 = new ModelRenderer(this, 0, 0);
		Stone12.addBox(0F, 0F, 0F, 6, 2, 3);
		Stone12.setRotationPoint(-4F, 22.5F, -18F);
		Stone12.setTextureSize(128, 128);
		Stone12.mirror = true;
		setRotation(Stone12, 0F, 0F, 0F);
		Stone13 = new ModelRenderer(this, 0, 0);
		Stone13.addBox(0F, 0F, 0F, 6, 3, 2);
		Stone13.setRotationPoint(-3F, 22F, 14.5F);
		Stone13.setTextureSize(128, 128);
		Stone13.mirror = true;
		setRotation(Stone13, 0F, 0F, 0F);
		Stone14 = new ModelRenderer(this, 0, 0);
		Stone14.addBox(0F, 0F, 0F, 4, 2, 1);
		Stone14.setRotationPoint(0F, 22.5F, 21.5F);
		Stone14.setTextureSize(128, 128);
		Stone14.mirror = true;
		setRotation(Stone14, 0F, 0F, 0F);
		Stone15 = new ModelRenderer(this, 0, 0);
		Stone15.addBox(0F, 0F, 0F, 6, 2, 4);
		Stone15.setRotationPoint(-1F, 22F, 18F);
		Stone15.setTextureSize(128, 128);
		Stone15.mirror = true;
		setRotation(Stone15, 0F, 0F, 0F);
		Stone16 = new ModelRenderer(this, 0, 0);
		Stone16.addBox(0F, 0F, 0F, 4, 3, 1);
		Stone16.setRotationPoint(-2F, 21F, 20.5F);
		Stone16.setTextureSize(128, 128);
		Stone16.mirror = true;
		setRotation(Stone16, 0F, 0F, 0F);
		Stone17 = new ModelRenderer(this, 0, 0);
		Stone17.addBox(0F, 0F, 0F, 7, 4, 5);
		Stone17.setRotationPoint(-3F, 20.5F, 16F);
		Stone17.setTextureSize(128, 128);
		Stone17.mirror = true;
		setRotation(Stone17, 0F, 0F, 0F);
		Stone18 = new ModelRenderer(this, 0, 0);
		Stone18.addBox(0F, 0F, 0F, 5, 4, 3);
		Stone18.setRotationPoint(-16F, 20F, -12F);
		Stone18.setTextureSize(128, 128);
		Stone18.mirror = true;
		setRotation(Stone18, 0F, 0.7853982F, 0F);
		Stone19 = new ModelRenderer(this, 0, 0);
		Stone19.addBox(0F, 0F, 0F, 5, 3, 3);
		Stone19.setRotationPoint(-17F, 21.5F, -13F);
		Stone19.setTextureSize(128, 128);
		Stone19.mirror = true;
		setRotation(Stone19, 0F, 0.7853982F, 0F);
		Stone20 = new ModelRenderer(this, 0, 0);
		Stone20.addBox(0F, 0F, 0F, 5, 4, 3);
		Stone20.setRotationPoint(-16F, 20.5F, -13F);
		Stone20.setTextureSize(128, 128);
		Stone20.mirror = true;
		setRotation(Stone20, 0F, 0.7853982F, 0F);
		Stone21 = new ModelRenderer(this, 0, 0);
		Stone21.addBox(0F, 0F, 0F, 2, 3, 3);
		Stone21.setRotationPoint(-17.5F, 22.5F, -11.5F);
		Stone21.setTextureSize(128, 128);
		Stone21.mirror = true;
		setRotation(Stone21, 0F, 0.7853982F, 0F);
		Stone22 = new ModelRenderer(this, 0, 0);
		Stone22.addBox(0F, 0F, 0F, 5, 2, 3);
		Stone22.setRotationPoint(-17F, 22F, -10.4F);
		Stone22.setTextureSize(128, 128);
		Stone22.mirror = true;
		setRotation(Stone22, 0F, 0.7853982F, 0F);
		Stone23 = new ModelRenderer(this, 0, 0);
		Stone23.addBox(0F, 0F, 0F, 2, 3, 3);
		Stone23.setRotationPoint(-13F, 21.5F, -15F);
		Stone23.setTextureSize(128, 128);
		Stone23.mirror = true;
		setRotation(Stone23, 0F, 0.7853982F, 0F);
		Stone24 = new ModelRenderer(this, 0, 0);
		Stone24.addBox(0F, 0F, 0F, 2, 2, 2);
		Stone24.setRotationPoint(-21.5F, 22.5F, -3F);
		Stone24.setTextureSize(128, 128);
		Stone24.mirror = true;
		setRotation(Stone24, 0F, 0F, 0F);
		Stone25 = new ModelRenderer(this, 0, 0);
		Stone25.addBox(0F, 0F, 0F, 4, 4, 6);
		Stone25.setRotationPoint(-21F, 20F, -2F);
		Stone25.setTextureSize(128, 128);
		Stone25.mirror = true;
		setRotation(Stone25, 0F, 0F, 0F);
		Stone26 = new ModelRenderer(this, 0, 0);
		Stone26.addBox(0F, 0F, 0F, 2, 2, 6);
		Stone26.setRotationPoint(-17F, 22F, -2F);
		Stone26.setTextureSize(128, 128);
		Stone26.mirror = true;
		setRotation(Stone26, 0F, 0F, 0F);
		Stone27 = new ModelRenderer(this, 0, 0);
		Stone27.addBox(0F, 0F, 0F, 4, 3, 4);
		Stone27.setRotationPoint(-20.5F, 21.5F, 1.5F);
		Stone27.setTextureSize(128, 128);
		Stone27.mirror = true;
		setRotation(Stone27, 0F, 0F, 0F);
		Stone28 = new ModelRenderer(this, 0, 0);
		Stone28.addBox(0F, 0F, 0F, 4, 3, 6);
		Stone28.setRotationPoint(-20F, 21F, -4F);
		Stone28.setTextureSize(128, 128);
		Stone28.mirror = true;
		setRotation(Stone28, 0F, 0F, 0F);
		Stone29 = new ModelRenderer(this, 0, 0);
		Stone29.addBox(0F, 0F, 0F, 4, 4, 4);
		Stone29.setRotationPoint(-22.5F, 20.5F, 0.5F);
		Stone29.setTextureSize(128, 128);
		Stone29.mirror = true;
		setRotation(Stone29, 0F, 0F, 0F);
		Stone30 = new ModelRenderer(this, 0, 0);
		Stone30.addBox(0F, 0F, 0F, 2, 2, 4);
		Stone30.setRotationPoint(-23F, 22.5F, -0.5F);
		Stone30.setTextureSize(128, 128);
		Stone30.mirror = true;
		setRotation(Stone30, 0F, 0F, 0F);
		Stone31 = new ModelRenderer(this, 0, 0);
		Stone31.addBox(0F, 0F, 0F, 1, 2, 2);
		Stone31.setRotationPoint(-22F, 22F, -1F);
		Stone31.setTextureSize(128, 128);
		Stone31.mirror = true;
		setRotation(Stone31, 0F, 0F, 0F);
		Stone32 = new ModelRenderer(this, 0, 0);
		Stone32.addBox(0F, 0F, 0F, 4, 3, 6);
		Stone32.setRotationPoint(17F, 21F, -5F);
		Stone32.setTextureSize(128, 128);
		Stone32.mirror = true;
		setRotation(Stone32, 0F, 0F, 0F);
		Stone33 = new ModelRenderer(this, 0, 0);
		Stone33.addBox(0F, 0F, 0F, 4, 3, 6);
		Stone33.setRotationPoint(16F, 21.5F, -6.5F);
		Stone33.setTextureSize(128, 128);
		Stone33.mirror = true;
		setRotation(Stone33, 0F, 0F, 0F);
		Stone34 = new ModelRenderer(this, 0, 0);
		Stone34.addBox(0F, 0F, 0F, 2, 2, 4);
		Stone34.setRotationPoint(21F, 23F, -3.5F);
		Stone34.setTextureSize(128, 128);
		Stone34.mirror = true;
		setRotation(Stone34, 0F, 0F, 0F);
		Stone35 = new ModelRenderer(this, 0, 0);
		Stone35.addBox(0F, 0F, 0F, 2, 2, 1);
		Stone35.setRotationPoint(-11.8F, 22F, -12.8F);
		Stone35.setTextureSize(128, 128);
		Stone35.mirror = true;
		setRotation(Stone35, 0F, 0.7853982F, 0F);
		Stone36 = new ModelRenderer(this, 0, 0);
		Stone36.addBox(0F, 0F, 0F, 5, 3, 3);
		Stone36.setRotationPoint(-16F, 21F, -11F);
		Stone36.setTextureSize(128, 128);
		Stone36.mirror = true;
		setRotation(Stone36, 0F, 0.7853982F, 0F);
		Stone37 = new ModelRenderer(this, 0, 0);
		Stone37.addBox(0F, 0F, 0F, 2, 2, 5);
		Stone37.setRotationPoint(19.5F, 22.5F, -6F);
		Stone37.setTextureSize(128, 128);
		Stone37.mirror = true;
		setRotation(Stone37, 0F, 0F, 0F);
		Stone38 = new ModelRenderer(this, 0, 0);
		Stone38.addBox(0F, 0F, 0F, 1, 3, 3);
		Stone38.setRotationPoint(21F, 21.5F, -3F);
		Stone38.setTextureSize(128, 128);
		Stone38.mirror = true;
		setRotation(Stone38, 0F, 0F, 0F);
		Stone39 = new ModelRenderer(this, 0, 0);
		Stone39.addBox(0F, 0F, 0F, 2, 2, 5);
		Stone39.setRotationPoint(15.5F, 22.5F, -5F);
		Stone39.setTextureSize(128, 128);
		Stone39.mirror = true;
		setRotation(Stone39, 0F, 0F, 0F);
		Stone40 = new ModelRenderer(this, 0, 0);
		Stone40.addBox(0F, 0F, 0F, 3, 2, 1);
		Stone40.setRotationPoint(17.5F, 22.5F, 1F);
		Stone40.setTextureSize(128, 128);
		Stone40.mirror = true;
		setRotation(Stone40, 0F, 0F, 0F);
		Stone41 = new ModelRenderer(this, 0, 0);
		Stone41.addBox(0F, 0F, 0F, 2, 2, 1);
		Stone41.setRotationPoint(18F, 22F, 0.5F);
		Stone41.setTextureSize(128, 128);
		Stone41.mirror = true;
		setRotation(Stone41, 0F, 0F, 0F);
		Stone42 = new ModelRenderer(this, 0, 0);
		Stone42.addBox(0F, 0F, 0F, 1, 1, 1);
		Stone42.setRotationPoint(21.5F, 23F, 0F);
		Stone42.setTextureSize(128, 128);
		Stone42.mirror = true;
		setRotation(Stone42, 0F, 0F, 0F);
		Stone43 = new ModelRenderer(this, 0, 0);
		Stone43.addBox(0F, 0F, 0F, 1, 1, 1);
		Stone43.setRotationPoint(20.5F, 23F, 0.5F);
		Stone43.setTextureSize(128, 128);
		Stone43.mirror = true;
		setRotation(Stone43, 0F, 0F, 0F);
		Stone44 = new ModelRenderer(this, 0, 0);
		Stone44.addBox(0F, 0F, 0F, 3, 2, 4);
		Stone44.setRotationPoint(10F, 19.5F, -15F);
		Stone44.setTextureSize(128, 128);
		Stone44.mirror = true;
		setRotation(Stone44, 0F, 0.7853982F, 0F);
		Stone45 = new ModelRenderer(this, 0, 0);
		Stone45.addBox(0F, 0F, 0F, 2, 2, 1);
		Stone45.setRotationPoint(-11.8F, 22F, -12.8F);
		Stone45.setTextureSize(128, 128);
		Stone45.mirror = true;
		setRotation(Stone45, 0F, 0.7853982F, 0F);
		Stone46 = new ModelRenderer(this, 0, 0);
		Stone46.addBox(0F, 0F, 0F, 2, 2, 1);
		Stone46.setRotationPoint(-11.8F, 22F, -12.8F);
		Stone46.setTextureSize(128, 128);
		Stone46.mirror = true;
		setRotation(Stone46, 0F, 0.7853982F, 0F);
		Stone47 = new ModelRenderer(this, 0, 0);
		Stone47.addBox(0F, 0F, 0F, 3, 3, 2);
		Stone47.setRotationPoint(7F, 22F, -14.5F);
		Stone47.setTextureSize(128, 128);
		Stone47.mirror = true;
		setRotation(Stone47, 0F, 0.7853982F, 0F);
		Stone48 = new ModelRenderer(this, 0, 0);
		Stone48.addBox(0F, 0F, 0F, 3, 4, 6);
		Stone48.setRotationPoint(8F, 22F, -12F);
		Stone48.setTextureSize(128, 128);
		Stone48.mirror = true;
		setRotation(Stone48, 0F, 0.7853982F, 0F);
		Stone49 = new ModelRenderer(this, 0, 0);
		Stone49.addBox(0F, 0F, 0F, 5, 3, 3);
		Stone49.setRotationPoint(12F, 21.5F, -10F);
		Stone49.setTextureSize(128, 128);
		Stone49.mirror = true;
		setRotation(Stone49, 0F, 0.7853982F, 0F);
		Stone50 = new ModelRenderer(this, 0, 0);
		Stone50.addBox(0F, 0F, 0F, 3, 4, 6);
		Stone50.setRotationPoint(8F, 20.5F, -13F);
		Stone50.setTextureSize(128, 128);
		Stone50.mirror = true;
		setRotation(Stone50, 0F, 0.7853982F, 0F);
		Stone51 = new ModelRenderer(this, 0, 0);
		Stone51.addBox(0F, 0F, 0F, 5, 4, 7);
		Stone51.setRotationPoint(8F, 20F, -15F);
		Stone51.setTextureSize(128, 128);
		Stone51.mirror = true;
		setRotation(Stone51, 0F, 0.7853982F, 0F);
		Stone52 = new ModelRenderer(this, 0, 0);
		Stone52.addBox(0F, 0F, 0F, 2, 2, 3);
		Stone52.setRotationPoint(11.5F, 22F, -18.5F);
		Stone52.setTextureSize(128, 128);
		Stone52.mirror = true;
		setRotation(Stone52, 0F, 0.7853982F, 0F);
		Stone53 = new ModelRenderer(this, 0, 0);
		Stone53.addBox(0F, 0F, 0F, 4, 3, 5);
		Stone53.setRotationPoint(7F, 21.5F, -15.5F);
		Stone53.setTextureSize(128, 128);
		Stone53.mirror = true;
		setRotation(Stone53, 0F, 0.7853982F, 0F);
		Stone54 = new ModelRenderer(this, 0, 0);
		Stone54.addBox(0F, 0F, 0F, 4, 3, 5);
		Stone54.setRotationPoint(9F, 21F, -17F);
		Stone54.setTextureSize(128, 128);
		Stone54.mirror = true;
		setRotation(Stone54, 0F, 0.7853982F, 0F);
		Stone55 = new ModelRenderer(this, 0, 0);
		Stone55.addBox(0F, 0F, 0F, 3, 2, 3);
		Stone55.setRotationPoint(12F, 22F, -15F);
		Stone55.setTextureSize(128, 128);
		Stone55.mirror = true;
		setRotation(Stone55, 0F, 0.7853982F, 0F);
		Stone56 = new ModelRenderer(this, 0, 0);
		Stone56.addBox(0F, 0F, 0F, 3, 3, 2);
		Stone56.setRotationPoint(13F, 21F, -11F);
		Stone56.setTextureSize(128, 128);
		Stone56.mirror = true;
		setRotation(Stone56, 0F, 0.7853982F, 0F);
		Stone57 = new ModelRenderer(this, 0, 0);
		Stone57.addBox(0F, 0F, 0F, 6, 1, 3);
		Stone57.setRotationPoint(11F, 20.5F, 13.66667F);
		Stone57.setTextureSize(128, 128);
		Stone57.mirror = true;
		setRotation(Stone57, 0F, 0.7853982F, 0F);
		Stone58 = new ModelRenderer(this, 0, 0);
		Stone58.addBox(0F, 0F, 0F, 8, 3, 4);
		Stone58.setRotationPoint(10F, 21F, 14F);
		Stone58.setTextureSize(128, 128);
		Stone58.mirror = true;
		setRotation(Stone58, 0F, 0.7853982F, 0F);
		Stone59 = new ModelRenderer(this, 0, 0);
		Stone59.addBox(0F, 0F, 0F, 5, 3, 2);
		Stone59.setRotationPoint(14.5F, 23F, 15.5F);
		Stone59.setTextureSize(128, 128);
		Stone59.mirror = true;
		setRotation(Stone59, 0F, 0.7853982F, 0F);
		Stone69 = new ModelRenderer(this, 0, 0);
		Stone69.addBox(0F, 0F, 0F, 8, 3, 4);
		Stone69.setRotationPoint(11F, 22F, 14F);
		Stone69.setTextureSize(128, 128);
		Stone69.mirror = true;
		setRotation(Stone69, 0F, 0.7853982F, 0F);
		Stone70 = new ModelRenderer(this, 0, 0);
		Stone70.addBox(0F, 0F, 0F, 8, 3, 4);
		Stone70.setRotationPoint(11F, 22F, 14F);
		Stone70.setTextureSize(128, 128);
		Stone70.mirror = true;
		setRotation(Stone70, 0F, 0.7853982F, 0F);
		Stone71 = new ModelRenderer(this, 0, 0);
		Stone71.addBox(0F, 0F, 0F, 8, 3, 4);
		Stone71.setRotationPoint(11F, 22F, 14F);
		Stone71.setTextureSize(128, 128);
		Stone71.mirror = true;
		setRotation(Stone71, 0F, 0.7853982F, 0F);
		Stone72 = new ModelRenderer(this, 0, 0);
		Stone72.addBox(0F, 0F, 0F, 6, 3, 4);
		Stone72.setRotationPoint(10.5F, 22.5F, 15.5F);
		Stone72.setTextureSize(128, 128);
		Stone72.mirror = true;
		setRotation(Stone72, 0F, 0.7853982F, 0F);
		Stone60 = new ModelRenderer(this, 0, 0);
		Stone60.addBox(0F, 0F, 0F, 8, 3, 4);
		Stone60.setRotationPoint(10F, 22F, 12F);
		Stone60.setTextureSize(128, 128);
		Stone60.mirror = true;
		setRotation(Stone60, 0F, 0.7853982F, 0F);
		Stone61 = new ModelRenderer(this, 0, 0);
		Stone61.addBox(0F, 0F, 0F, 3, 3, 7);
		Stone61.setRotationPoint(-19F, 21F, 13.8F);
		Stone61.setTextureSize(128, 128);
		Stone61.mirror = true;
		setRotation(Stone61, 0F, 0.7853982F, 0F);
		Stone62 = new ModelRenderer(this, 0, 0);
		Stone62.addBox(0F, 0F, 0F, 3, 3, 6);
		Stone62.setRotationPoint(-18F, 21.5F, 13.8F);
		Stone62.setTextureSize(128, 128);
		Stone62.mirror = true;
		setRotation(Stone62, 0F, 0.7853982F, 0F);
		Stone63 = new ModelRenderer(this, 0, 0);
		Stone63.addBox(0F, 0F, 0F, 3, 3, 6);
		Stone63.setRotationPoint(-17.6F, 23F, 12.33333F);
		Stone63.setTextureSize(128, 128);
		Stone63.mirror = true;
		setRotation(Stone63, 0F, 0.7853982F, 0F);
		Stone64 = new ModelRenderer(this, 0, 0);
		Stone64.addBox(0F, 0F, 0F, 2, 3, 3);
		Stone64.setRotationPoint(-20F, 22F, 13.33333F);
		Stone64.setTextureSize(128, 128);
		Stone64.mirror = true;
		setRotation(Stone64, 0F, 0.7853982F, 0F);
		Stone65 = new ModelRenderer(this, 0, 0);
		Stone65.addBox(0F, 0F, 0F, 2, 3, 4);
		Stone65.setRotationPoint(-20F, 22F, 14.33333F);
		Stone65.setTextureSize(128, 128);
		Stone65.mirror = true;
		setRotation(Stone65, 0F, 0.7853982F, 0F);
		Stone66 = new ModelRenderer(this, 0, 0);
		Stone66.addBox(0F, 0F, 0F, 2, 3, 4);
		Stone66.setRotationPoint(-19F, 21.5F, 16.33333F);
		Stone66.setTextureSize(128, 128);
		Stone66.mirror = true;
		setRotation(Stone66, 0F, 0.7853982F, 0F);
		Stone67 = new ModelRenderer(this, 0, 0);
		Stone67.addBox(0F, 0F, 0F, 3, 2, 4);
		Stone67.setRotationPoint(-19F, 22.5F, 17.33333F);
		Stone67.setTextureSize(128, 128);
		Stone67.mirror = true;
		setRotation(Stone67, 0F, 0.7853982F, 0F);
		Stone68 = new ModelRenderer(this, 0, 0);
		Stone68.addBox(0F, 0F, 0F, 3, 3, 6);
		Stone68.setRotationPoint(-18.6F, 22F, 12.33333F);
		Stone68.setTextureSize(128, 128);
		Stone68.mirror = true;
		setRotation(Stone68, 0F, 0.7853982F, 0F);
		Wood1 = new ModelRenderer(this, 0, 68);
		Wood1.addBox(0F, 0F, 0F, 3, 18, 3);
		Wood1.setRotationPoint(4F, 8F, 3F);
		Wood1.setTextureSize(128, 128);
		Wood1.mirror = true;
		setRotation(Wood1, -0.5948578F, -2.157255F, 0F);
		Wood2 = new ModelRenderer(this, 0, 68);
		Wood2.addBox(0F, 0F, 0F, 3, 12, 3);
		Wood2.setRotationPoint(-1F, 14F, 0F);
		Wood2.setTextureSize(128, 128);
		Wood2.mirror = true;
		setRotation(Wood2, 0F, 0F, 0F);
		Wood3 = new ModelRenderer(this, 0, 68);
		Wood3.addBox(0F, 0F, 0F, 3, 12, 3);
		Wood3.setRotationPoint(0F, 14F, -1F);
		Wood3.setTextureSize(128, 128);
		Wood3.mirror = true;
		setRotation(Wood3, 0.5205006F, -2.174949F, 0F);
		Wood4 = new ModelRenderer(this, 0, 68);
		Wood4.addBox(0F, 0F, 0F, 3, 12, 3);
		Wood4.setRotationPoint(-2F, 14F, 2F);
		Wood4.setTextureSize(128, 128);
		Wood4.mirror = true;
		setRotation(Wood4, 0.5205006F, -0.8736974F, 0F);
		Wood5 = new ModelRenderer(this, 0, 68);
		Wood5.addBox(0F, 0F, 0F, 3, 12, 3);
		Wood5.setRotationPoint(3F, 14F, 1F);
		Wood5.setTextureSize(128, 128);
		Wood5.mirror = true;
		setRotation(Wood5, 0.5205006F, 2.806985F, 0F);
		Wood6 = new ModelRenderer(this, 0, 68);
		Wood6.addBox(0F, 0F, 0F, 3, 12, 3);
		Wood6.setRotationPoint(2F, 14F, 3F);
		Wood6.setTextureSize(128, 128);
		Wood6.mirror = true;
		setRotation(Wood6, 0.5205006F, 1.580091F, 0F);
		Wood7 = new ModelRenderer(this, 0, 68);
		Wood7.addBox(0F, 0F, 0F, 3, 18, 3);
		Wood7.setRotationPoint(-7F, 8F, 3F);
		Wood7.setTextureSize(128, 128);
		Wood7.mirror = true;
		setRotation(Wood7, -0.5948578F, 1.337534F, 0F);
		Wood8 = new ModelRenderer(this, 0, 68);
		Wood8.addBox(0F, 0F, 0F, 3, 18, 3);
		Wood8.setRotationPoint(-4F, 8F, 0F);
		Wood8.setTextureSize(128, 128);
		Wood8.mirror = true;
		setRotation(Wood8, -0.5948578F, 0.5939619F, 0F);
		Wood9 = new ModelRenderer(this, 0, 68);
		Wood9.addBox(0F, 0F, 0F, 3, 18, 3);
		Wood9.setRotationPoint(1F, 8F, 7F);
		Wood9.setTextureSize(128, 128);
		Wood9.mirror = true;
		setRotation(Wood9, -0.5948578F, 2.713143F, 0F);
		Wood10 = new ModelRenderer(this, 0, 68);
		Wood10.addBox(0F, 0F, 0F, 3, 18, 3);
		Wood10.setRotationPoint(0F, 8F, -3F);
		Wood10.setTextureSize(128, 128);
		Wood10.mirror = true;
		setRotation(Wood10, -0.5948578F, -0.0752531F, 0F);
		Wood11 = new ModelRenderer(this, 0, 68);
		Wood11.addBox(0F, 0F, 0F, 3, 18, 3);
		Wood11.setRotationPoint(-4F, 8F, 5F);
		Wood11.setTextureSize(128, 128);
		Wood11.mirror = true;
		setRotation(Wood11, -0.5948578F, 1.783677F, 0F);
		Wood12 = new ModelRenderer(this, 0, 68);
		Wood12.addBox(0F, 0F, 0F, 3, 18, 3);
		Wood12.setRotationPoint(5F, 8F, -1F);
		Wood12.setTextureSize(128, 128);
		Wood12.mirror = true;
		setRotation(Wood12, -0.5948578F, -1.339326F, 0F);
		Wood13 = new ModelRenderer(this, 0, 68);
		Wood13.addBox(0F, 0F, 0F, 3, 12, 3);
		Wood13.setRotationPoint(0F, 14F, 3F);
		Wood13.setTextureSize(128, 128);
		Wood13.mirror = true;
		setRotation(Wood13, 0.5205006F, 0.3160182F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		/*Old
		 * Stock4.render(f5); Stein1.render(f5); Stock3.render(f5);
		 * Stein2.render(f5); Stock2.render(f5); Stein3.render(f5);
		 * Stock1.render(f5); Stein4.render(f5); Stein5.render(f5);
		 * Stein6.render(f5); Stein7.render(f5); Stein8.render(f5);
		 * Stein9.render(f5); Stein10.render(f5); Stein11.render(f5);
		 * Stein12.render(f5); Stein13.render(f5); Stein14.render(f5);
		 * Stein15.render(f5); Stein16.render(f5); Stein17.render(f5);
		 * Stein18.render(f5); Stein19.render(f5); Stein20.render(f5);
		 * Stein21.render(f5); Stein22.render(f5); Stein23.render(f5);
		 * Stein24.render(f5); Stein25.render(f5); Stein26.render(f5);
		 * Stein27.render(f5); Stein28.render(f5); Stein29.render(f5);
		 * Stein30.render(f5); Stein31.render(f5); Stein32.render(f5);
		 * Stein33.render(f5); Stein34.render(f5); Stein35.render(f5);
		 * Stein36.render(f5); Stein37.render(f5); Stein38.render(f5);
		 * Stein39.render(f5); Stein40.render(f5); Stein41.render(f5);
		 * Stein42.render(f5); Stein43.render(f5); Stein44.render(f5);
		 */
		Stone1.render(f5);
		Stone2.render(f5);
		Stone3.render(f5);
		Stone4.render(f5);
		Stone5.render(f5);
		Stone6.render(f5);
		Stone7.render(f5);
		Stone8.render(f5);
		Stone9.render(f5);
		Stone10.render(f5);
		Stone11.render(f5);
		Stone12.render(f5);
		Stone13.render(f5);
		Stone14.render(f5);
		Stone15.render(f5);
		Stone16.render(f5);
		Stone17.render(f5);
		Stone18.render(f5);
		Stone19.render(f5);
		Stone20.render(f5);
		Stone21.render(f5);
		Stone22.render(f5);
		Stone23.render(f5);
		Stone24.render(f5);
		Stone25.render(f5);
		Stone26.render(f5);
		Stone27.render(f5);
		Stone28.render(f5);
		Stone29.render(f5);
		Stone30.render(f5);
		Stone31.render(f5);
		Stone32.render(f5);
		Stone33.render(f5);
		Stone34.render(f5);
		Stone35.render(f5);
		Stone36.render(f5);
		Stone37.render(f5);
		Stone38.render(f5);
		Stone39.render(f5);
		Stone40.render(f5);
		Stone41.render(f5);
		Stone42.render(f5);
		Stone43.render(f5);
		Stone44.render(f5);
		Stone45.render(f5);
		Stone46.render(f5);
		Stone47.render(f5);
		Stone48.render(f5);
		Stone49.render(f5);
		Stone50.render(f5);
		Stone51.render(f5);
		Stone52.render(f5);
		Stone53.render(f5);
		Stone54.render(f5);
		Stone55.render(f5);
		Stone56.render(f5);
		Stone57.render(f5);
		Stone58.render(f5);
		Stone59.render(f5);
		Stone69.render(f5);
		Stone70.render(f5);
		Stone71.render(f5);
		Stone72.render(f5);
		Stone60.render(f5);
		Stone61.render(f5);
		Stone62.render(f5);
		Stone63.render(f5);
		Stone64.render(f5);
		Stone65.render(f5);
		Stone66.render(f5);
		Stone67.render(f5);
		Stone68.render(f5);
		Wood1.render(f5);
		Wood2.render(f5);
		Wood3.render(f5);
		Wood4.render(f5);
		Wood5.render(f5);
		Wood6.render(f5);
		Wood7.render(f5);
		Wood8.render(f5);
		Wood9.render(f5);
		Wood10.render(f5);
		Wood11.render(f5);
		Wood12.render(f5);
		Wood13.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void renderModel(float f) {
		/*
		 * Stock4.render(f); Stein1.render(f); Stock3.render(f);
		 * Stein2.render(f); Stock2.render(f); Stein3.render(f);
		 * Stock1.render(f); Stein4.render(f); Stein5.render(f);
		 * Stein6.render(f); Stein7.render(f); Stein8.render(f);
		 * Stein9.render(f); Stein10.render(f); Stein11.render(f);
		 * Stein12.render(f); Stein13.render(f); Stein14.render(f);
		 * Stein15.render(f); Stein16.render(f); Stein17.render(f);
		 * Stein18.render(f); Stein19.render(f); Stein20.render(f);
		 * Stein21.render(f); Stein22.render(f); Stein23.render(f);
		 * Stein24.render(f); Stein25.render(f); Stein26.render(f);
		 * Stein27.render(f); Stein28.render(f); Stein29.render(f);
		 * Stein30.render(f); Stein31.render(f); Stein32.render(f);
		 * Stein33.render(f); Stein34.render(f); Stein35.render(f);
		 * Stein36.render(f); Stein37.render(f); Stein38.render(f);
		 * Stein39.render(f); Stein40.render(f); Stein41.render(f);
		 * Stein42.render(f); Stein43.render(f); Stein44.render(f);
		 */
		Stone1.render(f);
		Stone2.render(f);
		Stone3.render(f);
		Stone4.render(f);
		Stone5.render(f);
		Stone6.render(f);
		Stone7.render(f);
		Stone8.render(f);
		Stone9.render(f);
		Stone10.render(f);
		Stone11.render(f);
		Stone12.render(f);
		Stone13.render(f);
		Stone14.render(f);
		Stone15.render(f);
		Stone16.render(f);
		Stone17.render(f);
		Stone18.render(f);
		Stone19.render(f);
		Stone20.render(f);
		Stone21.render(f);
		Stone22.render(f);
		Stone23.render(f);
		Stone24.render(f);
		Stone25.render(f);
		Stone26.render(f);
		Stone27.render(f);
		Stone28.render(f);
		Stone29.render(f);
		Stone30.render(f);
		Stone31.render(f);
		Stone32.render(f);
		Stone33.render(f);
		Stone34.render(f);
		Stone35.render(f);
		Stone36.render(f);
		Stone37.render(f);
		Stone38.render(f);
		Stone39.render(f);
		Stone40.render(f);
		Stone41.render(f);
		Stone42.render(f);
		Stone43.render(f);
		Stone44.render(f);
		Stone45.render(f);
		Stone46.render(f);
		Stone47.render(f);
		Stone48.render(f);
		Stone49.render(f);
		Stone50.render(f);
		Stone51.render(f);
		Stone52.render(f);
		Stone53.render(f);
		Stone54.render(f);
		Stone55.render(f);
		Stone56.render(f);
		Stone57.render(f);
		Stone58.render(f);
		Stone59.render(f);
		Stone69.render(f);
		Stone70.render(f);
		Stone71.render(f);
		Stone72.render(f);
		Stone60.render(f);
		Stone61.render(f);
		Stone62.render(f);
		Stone63.render(f);
		Stone64.render(f);
		Stone65.render(f);
		Stone66.render(f);
		Stone67.render(f);
		Stone68.render(f);
		Wood1.render(f);
		Wood2.render(f);
		Wood3.render(f);
		Wood4.render(f);
		Wood5.render(f);
		Wood6.render(f);
		Wood7.render(f);
		Wood8.render(f);
		Wood9.render(f);
		Wood10.render(f);
		Wood11.render(f);
		Wood12.render(f);
		Wood13.render(f);
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
