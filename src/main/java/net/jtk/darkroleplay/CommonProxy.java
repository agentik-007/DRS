package net.jtk.darkroleplay;

import net.jtk.darkroleplay.items.itemFirewood;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	public void registerRandomStuff() {
	}
	public void registerInitStuff(){
	}
}

class DarkRoleplayFuelHandler implements IFuelHandler {
	@Override
	public int getBurnTime(ItemStack fuel) {
		// TODO Auto-generated method stub
		Item item = fuel.getItem();
		
		if(item.equals(itemFirewood.itemFirewood)){
			return 800;
		}
		
		return 0;
	}
}