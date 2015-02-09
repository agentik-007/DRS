package net.jtk.darkroleplay;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DarkRoleplayBlockBarrelEmpty extends BlockContainer {

	public static Block blockBarrelEmpty;

	public static Object instance;

	public DarkRoleplayBlockBarrelEmpty() {
		super(Material.wood);
	}

	static {

		blockBarrelEmpty = new DarkRoleplayBlockBarrelEmpty().setHardness(2.0F)
				.setResistance(10.0F).setLightLevel(0.0F)
				.setUnlocalizedName("blockBarrelEmpty")
				.setStepSound(Block.soundTypeWood)
				.setCreativeTab(DarkRoleplayTabs.drBlocksTab);
		blockBarrelEmpty.setBlockBounds(1.0F / 16F * 0F, 0.0F, 1.0F / 16F * 0F,
				1.0F / 16F * 16F, 1.0F / 16F * 16F, 1.0F / 16F * 16F);
	}

	public int getRenderType() {
		return -1;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityCustomBarrelEmpty();
	}

	public static void serverLoad(FMLServerStartingEvent event) {
	}

	public static void Init(FMLInitializationEvent event){
		GameRegistry.addRecipe(new ItemStack(DarkRoleplayBlockBarrelEmpty.blockBarrelEmpty, 1), "X X", "X X", "ZXZ", 'X', Blocks.planks, 'Z', Items.iron_ingot);
	}
	
	public static void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerBlock(blockBarrelEmpty, "blockBarrelEmpty");
		GameRegistry.registerTileEntity(TileEntityCustomBarrelEmpty.class, "TileEntityBarrelEmpty");
	}
}

class TileEntityCustomBarrelEmpty extends TileEntity {
}

class customRendererBarrelEmpty extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(
			DarkRoleplay.MODID, "textures/blockBarrelEmpty.png");

	private ModelBarrelEmpty model;

	public customRendererBarrelEmpty() {
		this.model = new ModelBarrelEmpty();
	}

	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f, int i) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		GL11.glRotatef(tileentity.getBlockMetadata() * 90, 0.0F, 1.0F, 0.0F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		this.model.renderModel(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}

class ModelBarrelEmpty extends ModelBase {
	//fields
    ModelRenderer Ground1;
    ModelRenderer Top2;
    ModelRenderer Top12;
    ModelRenderer Middle16;
    ModelRenderer Top9;
    ModelRenderer Top1;
    ModelRenderer Middle2;
    ModelRenderer Top3;
    ModelRenderer Top4;
    ModelRenderer Top7;
    ModelRenderer Top5;
    ModelRenderer Top10;
    ModelRenderer Ground4;
    ModelRenderer Ground2;
    ModelRenderer Ground3;
    ModelRenderer Ground;
    ModelRenderer Top6;
    ModelRenderer Top11;
    ModelRenderer Middle6;
    ModelRenderer Middle3;
    ModelRenderer Middle1;
    ModelRenderer Middle4;
    ModelRenderer Middle5;
    ModelRenderer Top8;
    ModelRenderer Middle7;
    ModelRenderer Middle8;
    ModelRenderer Middle9;
    ModelRenderer Middle10;
    ModelRenderer Middle11;
    ModelRenderer Middle12;
    ModelRenderer Middle13;
    ModelRenderer Middle14;
    ModelRenderer Middle15;
    ModelRenderer Bottom5;
    ModelRenderer Bottom3;
    ModelRenderer Bottom9;
    ModelRenderer Bottom7;
    ModelRenderer Bottom12;
    ModelRenderer Bottom11;
    ModelRenderer Bottom8;
    ModelRenderer Bottom4;
    ModelRenderer Bottom1;
    ModelRenderer Bottom10;
    ModelRenderer Bottom6;
    ModelRenderer Bottom2;
  
  public ModelBarrelEmpty()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Ground1 = new ModelRenderer(this, 40, 55);
      Ground1.addBox(0F, 0F, 0F, 6, 1, 1);
      Ground1.setRotationPoint(-3F, 22F, 5F);
      Ground1.setTextureSize(64, 64);
      Ground1.mirror = true;
      setRotation(Ground1, 0F, 0F, 0F);
      Top2 = new ModelRenderer(this, 0, 44);
      Top2.addBox(0F, 0F, 0F, 1, 3, 6);
      Top2.setRotationPoint(-7F, 8F, -3F);
      Top2.setTextureSize(64, 64);
      Top2.mirror = true;
      setRotation(Top2, 0F, 0F, 0F);
      Top12 = new ModelRenderer(this, 54, 49);
      Top12.addBox(0F, 0F, 0F, 2, 3, 1);
      Top12.setRotationPoint(-5F, 8F, -6F);
      Top12.setTextureSize(64, 64);
      Top12.mirror = true;
      setRotation(Top12, 0F, 0F, 0F);
      Middle16 = new ModelRenderer(this, 60, 53);
      Middle16.addBox(0F, 0F, 0F, 1, 10, 1);
      Middle16.setRotationPoint(-6F, 11F, 5F);
      Middle16.setTextureSize(64, 64);
      Middle16.mirror = true;
      setRotation(Middle16, 0F, 0F, 0F);
      Top9 = new ModelRenderer(this, 54, 57);
      Top9.addBox(0F, 0F, 0F, 1, 3, 2);
      Top9.setRotationPoint(5F, 8F, -5F);
      Top9.setTextureSize(64, 64);
      Top9.mirror = true;
      setRotation(Top9, 0F, 0F, 0F);
      Top1 = new ModelRenderer(this, 54, 44);
      Top1.addBox(0F, 0F, 0F, 1, 3, 2);
      Top1.setRotationPoint(-6F, 8F, -5F);
      Top1.setTextureSize(64, 64);
      Top1.mirror = true;
      setRotation(Top1, 0F, 0F, 0F);
      Middle2 = new ModelRenderer(this, 50, 22);
      Middle2.addBox(0F, 0F, 0F, 2, 10, 1);
      Middle2.setRotationPoint(3F, 11F, -7F);
      Middle2.setTextureSize(64, 64);
      Middle2.mirror = true;
      setRotation(Middle2, 0F, 0F, 0F);
      Top3 = new ModelRenderer(this, 48, 48);
      Top3.addBox(0F, 0F, 0F, 1, 3, 2);
      Top3.setRotationPoint(-6F, 8F, 3F);
      Top3.setTextureSize(64, 64);
      Top3.mirror = true;
      setRotation(Top3, 0F, 0F, 0F);
      Top4 = new ModelRenderer(this, 48, 44);
      Top4.addBox(0F, 0F, 0F, 2, 3, 1);
      Top4.setRotationPoint(-5F, 8F, 5F);
      Top4.setTextureSize(64, 64);
      Top4.mirror = true;
      setRotation(Top4, 0F, 0F, 0F);
      Top7 = new ModelRenderer(this, 42, 44);
      Top7.addBox(0F, 0F, 0F, 1, 3, 2);
      Top7.setRotationPoint(5F, 8F, 3F);
      Top7.setTextureSize(64, 64);
      Top7.mirror = true;
      setRotation(Top7, 0F, 0F, 0F);
      Top5 = new ModelRenderer(this, 28, 45);
      Top5.addBox(0F, 0F, 0F, 6, 3, 1);
      Top5.setRotationPoint(-3F, 8F, 6F);
      Top5.setTextureSize(64, 64);
      Top5.mirror = true;
      setRotation(Top5, 0F, 0F, 0F);
      Top10 = new ModelRenderer(this, 54, 53);
      Top10.addBox(0F, 0F, 0F, 2, 3, 1);
      Top10.setRotationPoint(3F, 8F, -6F);
      Top10.setTextureSize(64, 64);
      Top10.mirror = true;
      setRotation(Top10, 0F, 0F, 0F);
      Ground4 = new ModelRenderer(this, 40, 55);
      Ground4.addBox(0F, 0F, 0F, 6, 1, 1);
      Ground4.setRotationPoint(-3F, 22F, -6F);
      Ground4.setTextureSize(64, 64);
      Ground4.mirror = true;
      setRotation(Ground4, 0F, 0F, 0F);
      Ground2 = new ModelRenderer(this, 40, 57);
      Ground2.addBox(0F, 0F, 0F, 1, 1, 6);
      Ground2.setRotationPoint(-6F, 22F, -3F);
      Ground2.setTextureSize(64, 64);
      Ground2.mirror = true;
      setRotation(Ground2, 0F, 0F, 0F);
      Ground3 = new ModelRenderer(this, 40, 57);
      Ground3.addBox(0F, 0F, 0F, 1, 1, 6);
      Ground3.setRotationPoint(5F, 22F, -3F);
      Ground3.setTextureSize(64, 64);
      Ground3.mirror = true;
      setRotation(Ground3, 0F, 0F, 0F);
      Ground = new ModelRenderer(this, 0, 53);
      Ground.addBox(0F, 0F, 0F, 10, 1, 10);
      Ground.setRotationPoint(-5F, 22F, -5F);
      Ground.setTextureSize(64, 64);
      Ground.mirror = true;
      setRotation(Ground, 0F, 0F, 0F);
      Top6 = new ModelRenderer(this, 42, 49);
      Top6.addBox(0F, 0F, 0F, 2, 3, 1);
      Top6.setRotationPoint(3F, 8F, 5F);
      Top6.setTextureSize(64, 64);
      Top6.mirror = true;
      setRotation(Top6, 0F, 0F, 0F);
      Top11 = new ModelRenderer(this, 28, 49);
      Top11.addBox(0F, 0F, 0F, 6, 3, 1);
      Top11.setRotationPoint(-3F, 8F, -7F);
      Top11.setTextureSize(64, 64);
      Top11.mirror = true;
      setRotation(Top11, 0F, 0F, 0F);
      Middle6 = new ModelRenderer(this, 56, 33);
      Middle6.addBox(0F, 0F, 0F, 2, 10, 1);
      Middle6.setRotationPoint(3F, 11F, 6F);
      Middle6.setTextureSize(64, 64);
      Middle6.mirror = true;
      setRotation(Middle6, 0F, 0F, 0F);
      Middle3 = new ModelRenderer(this, 44, 22);
      Middle3.addBox(0F, 0F, 0F, 2, 10, 1);
      Middle3.setRotationPoint(-5F, 11F, -7F);
      Middle3.setTextureSize(64, 64);
      Middle3.mirror = true;
      setRotation(Middle3, 0F, 0F, 0F);
      Middle1 = new ModelRenderer(this, 28, 33);
      Middle1.addBox(0F, 0F, 0F, 6, 10, 1);
      Middle1.setRotationPoint(-3F, 11F, -8F);
      Middle1.setTextureSize(64, 64);
      Middle1.mirror = true;
      setRotation(Middle1, 0F, 0F, 0F);
      Middle4 = new ModelRenderer(this, 42, 33);
      Middle4.addBox(0F, 0F, 0F, 6, 10, 1);
      Middle4.setRotationPoint(-3F, 11F, 7F);
      Middle4.setTextureSize(64, 64);
      Middle4.mirror = true;
      setRotation(Middle4, 0F, 0F, 0F);
      Middle5 = new ModelRenderer(this, 56, 22);
      Middle5.addBox(0F, 0F, 0F, 2, 10, 1);
      Middle5.setRotationPoint(-5F, 11F, 6F);
      Middle5.setTextureSize(64, 64);
      Middle5.mirror = true;
      setRotation(Middle5, 0F, 0F, 0F);
      Top8 = new ModelRenderer(this, 14, 44);
      Top8.addBox(0F, 0F, 0F, 1, 3, 6);
      Top8.setRotationPoint(6F, 8F, -3F);
      Top8.setTextureSize(64, 64);
      Top8.mirror = true;
      setRotation(Top8, 0F, 0F, 0F);
      Middle7 = new ModelRenderer(this, 0, 28);
      Middle7.addBox(0F, 0F, 0F, 1, 10, 6);
      Middle7.setRotationPoint(7F, 11F, -3F);
      Middle7.setTextureSize(64, 64);
      Middle7.mirror = true;
      setRotation(Middle7, 0F, 0F, 0F);
      Middle8 = new ModelRenderer(this, 32, 21);
      Middle8.addBox(0F, 0F, 0F, 1, 10, 2);
      Middle8.setRotationPoint(6F, 11F, -5F);
      Middle8.setTextureSize(64, 64);
      Middle8.mirror = true;
      setRotation(Middle8, 0F, 0F, 0F);
      Middle9 = new ModelRenderer(this, 38, 21);
      Middle9.addBox(0F, 0F, 0F, 1, 10, 2);
      Middle9.setRotationPoint(6F, 11F, 3F);
      Middle9.setTextureSize(64, 64);
      Middle9.mirror = true;
      setRotation(Middle9, 0F, 0F, 0F);
      Middle10 = new ModelRenderer(this, 14, 21);
      Middle10.addBox(0F, 0F, 0F, 1, 10, 2);
      Middle10.setRotationPoint(-7F, 11F, 3F);
      Middle10.setTextureSize(64, 64);
      Middle10.mirror = true;
      setRotation(Middle10, 0F, 0F, 0F);
      Middle11 = new ModelRenderer(this, 26, 21);
      Middle11.addBox(0F, 0F, 0F, 1, 10, 2);
      Middle11.setRotationPoint(-7F, 11F, -5F);
      Middle11.setTextureSize(64, 64);
      Middle11.mirror = true;
      setRotation(Middle11, 0F, 0F, 0F);
      Middle12 = new ModelRenderer(this, 14, 28);
      Middle12.addBox(0F, 0F, 0F, 1, 10, 6);
      Middle12.setRotationPoint(-8F, 11F, -3F);
      Middle12.setTextureSize(64, 64);
      Middle12.mirror = true;
      setRotation(Middle12, 0F, 0F, 0F);
      Middle13 = new ModelRenderer(this, 1, 22);
      Middle13.addBox(0F, 0F, 0F, 1, 10, 1);
      Middle13.setRotationPoint(-6F, 11F, -6F);
      Middle13.setTextureSize(64, 64);
      Middle13.mirror = true;
      setRotation(Middle13, 0F, 0F, 0F);
      Middle14 = new ModelRenderer(this, 10, 22);
      Middle14.addBox(0F, 0F, 0F, 1, 10, 1);
      Middle14.setRotationPoint(5F, 11F, -6F);
      Middle14.setTextureSize(64, 64);
      Middle14.mirror = true;
      setRotation(Middle14, 0F, 0F, 0F);
      Middle15 = new ModelRenderer(this, 22, 22);
      Middle15.addBox(0F, 0F, 0F, 1, 10, 1);
      Middle15.setRotationPoint(5F, 11F, 5F);
      Middle15.setTextureSize(64, 64);
      Middle15.mirror = true;
      setRotation(Middle15, 0F, 0F, 0F);
      Bottom5 = new ModelRenderer(this, 54, 44);
      Bottom5.addBox(0F, 0F, 0F, 1, 3, 2);
      Bottom5.setRotationPoint(-6F, 21F, -5F);
      Bottom5.setTextureSize(64, 64);
      Bottom5.mirror = true;
      setRotation(Bottom5, 0F, 0F, 0F);
      Bottom3 = new ModelRenderer(this, 0, 44);
      Bottom3.addBox(0F, 0F, 0F, 1, 3, 6);
      Bottom3.setRotationPoint(-7F, 21F, -3F);
      Bottom3.setTextureSize(64, 64);
      Bottom3.mirror = true;
      setRotation(Bottom3, 0F, 0F, 0F);
      Bottom9 = new ModelRenderer(this, 48, 48);
      Bottom9.addBox(0F, 0F, 0F, 1, 3, 2);
      Bottom9.setRotationPoint(-6F, 21F, 3F);
      Bottom9.setTextureSize(64, 64);
      Bottom9.mirror = true;
      setRotation(Bottom9, 0F, 0F, 0F);
      Bottom7 = new ModelRenderer(this, 48, 44);
      Bottom7.addBox(0F, 0F, 0F, 2, 3, 1);
      Bottom7.setRotationPoint(-5F, 21F, 5F);
      Bottom7.setTextureSize(64, 64);
      Bottom7.mirror = true;
      setRotation(Bottom7, 0F, 0F, 0F);
      Bottom12 = new ModelRenderer(this, 28, 45);
      Bottom12.addBox(0F, 0F, 0F, 6, 3, 1);
      Bottom12.setRotationPoint(-3F, 21F, 6F);
      Bottom12.setTextureSize(64, 64);
      Bottom12.mirror = true;
      setRotation(Bottom12, 0F, 0F, 0F);
      Bottom11 = new ModelRenderer(this, 42, 49);
      Bottom11.addBox(0F, 0F, 0F, 2, 3, 1);
      Bottom11.setRotationPoint(3F, 21F, 5F);
      Bottom11.setTextureSize(64, 64);
      Bottom11.mirror = true;
      setRotation(Bottom11, 0F, 0F, 0F);
      Bottom8 = new ModelRenderer(this, 42, 44);
      Bottom8.addBox(0F, 0F, 0F, 1, 3, 2);
      Bottom8.setRotationPoint(5F, 21F, 3F);
      Bottom8.setTextureSize(64, 64);
      Bottom8.mirror = true;
      setRotation(Bottom8, 0F, 0F, 0F);
      Bottom4 = new ModelRenderer(this, 14, 44);
      Bottom4.addBox(0F, 0F, 0F, 1, 3, 6);
      Bottom4.setRotationPoint(6F, 21F, -3F);
      Bottom4.setTextureSize(64, 64);
      Bottom4.mirror = true;
      setRotation(Bottom4, 0F, 0F, 0F);
      Bottom1 = new ModelRenderer(this, 54, 57);
      Bottom1.addBox(0F, 0F, 0F, 1, 3, 2);
      Bottom1.setRotationPoint(5F, 21F, -5F);
      Bottom1.setTextureSize(64, 64);
      Bottom1.mirror = true;
      setRotation(Bottom1, 0F, 0F, 0F);
      Bottom10 = new ModelRenderer(this, 54, 53);
      Bottom10.addBox(0F, 0F, 0F, 2, 3, 1);
      Bottom10.setRotationPoint(3F, 21F, -6F);
      Bottom10.setTextureSize(64, 64);
      Bottom10.mirror = true;
      setRotation(Bottom10, 0F, 0F, 0F);
      Bottom6 = new ModelRenderer(this, 28, 49);
      Bottom6.addBox(0F, 0F, 0F, 6, 3, 1);
      Bottom6.setRotationPoint(-3F, 21F, -7F);
      Bottom6.setTextureSize(64, 64);
      Bottom6.mirror = true;
      setRotation(Bottom6, 0F, 0F, 0F);
      Bottom2 = new ModelRenderer(this, 54, 49);
      Bottom2.addBox(0F, 0F, 0F, 2, 3, 1);
      Bottom2.setRotationPoint(-5F, 21F, -6F);
      Bottom2.setTextureSize(64, 64);
      Bottom2.mirror = true;
      setRotation(Bottom2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    Ground1.render(f5);
    Top2.render(f5);
    Top12.render(f5);
    Middle16.render(f5);
    Top9.render(f5);
    Top1.render(f5);
    Middle2.render(f5);
    Top3.render(f5);
    Top4.render(f5);
    Top7.render(f5);
    Top5.render(f5);
    Top10.render(f5);
    Ground4.render(f5);
    Ground2.render(f5);
    Ground3.render(f5);
    Ground.render(f5);
    Top6.render(f5);
    Top11.render(f5);
    Middle6.render(f5);
    Middle3.render(f5);
    Middle1.render(f5);
    Middle4.render(f5);
    Middle5.render(f5);
    Top8.render(f5);
    Middle7.render(f5);
    Middle8.render(f5);
    Middle9.render(f5);
    Middle10.render(f5);
    Middle11.render(f5);
    Middle12.render(f5);
    Middle13.render(f5);
    Middle14.render(f5);
    Middle15.render(f5);
    Bottom5.render(f5);
    Bottom3.render(f5);
    Bottom9.render(f5);
    Bottom7.render(f5);
    Bottom12.render(f5);
    Bottom11.render(f5);
    Bottom8.render(f5);
    Bottom4.render(f5);
    Bottom1.render(f5);
    Bottom10.render(f5);
    Bottom6.render(f5);
    Bottom2.render(f5);
  }
  
  public void renderModel(float f5) {
	    Ground1.render(f5);
	    Top2.render(f5);
	    Top12.render(f5);
	    Middle16.render(f5);
	    Top9.render(f5);
	    Top1.render(f5);
	    Middle2.render(f5);
	    Top3.render(f5);
	    Top4.render(f5);
	    Top7.render(f5);
	    Top5.render(f5);
	    Top10.render(f5);
	    Ground4.render(f5);
	    Ground2.render(f5);
	    Ground3.render(f5);
	    Ground.render(f5);
	    Top6.render(f5);
	    Top11.render(f5);
	    Middle6.render(f5);
	    Middle3.render(f5);
	    Middle1.render(f5);
	    Middle4.render(f5);
	    Middle5.render(f5);
	    Top8.render(f5);
	    Middle7.render(f5);
	    Middle8.render(f5);
	    Middle9.render(f5);
	    Middle10.render(f5);
	    Middle11.render(f5);
	    Middle12.render(f5);
	    Middle13.render(f5);
	    Middle14.render(f5);
	    Middle15.render(f5);
	    Bottom5.render(f5);
	    Bottom3.render(f5);
	    Bottom9.render(f5);
	    Bottom7.render(f5);
	    Bottom12.render(f5);
	    Bottom11.render(f5);
	    Bottom8.render(f5);
	    Bottom4.render(f5);
	    Bottom1.render(f5);
	    Bottom10.render(f5);
	    Bottom6.render(f5);
	    Bottom2.render(f5);
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
