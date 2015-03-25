package net.jtk.darkroleplay.blocks;

import net.jtk.darkroleplay.main.DarkRoleplayTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class blockPlaceholder extends Block{
	
	public static Block blockPlaceholder;
	public static Object instance;

	
	public blockPlaceholder(){
		super(Material.piston);
	}
	
	static{
		blockPlaceholder = (blockPlaceholder) (new blockPlaceholder()
		.setUnlocalizedName("blockPlaceholder")
		.setLightLevel(1F/15F*14.0F)
		.setCreativeTab(DarkRoleplayTabs.drBlocksTab)
		.setHardness(2.0F)
		.setStepSound(Block.soundTypePiston)
		.setResistance(10.0F));
		blockPlaceholder.setHarvestLevel("pickaxe", 0);
		blockPlaceholder.setBlockBounds(0.0F,0.0F,0.0F,1.0F,1.0F,1.0F);
	}	
}
