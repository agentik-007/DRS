package net.jtk.darkroleplay.handler;

import org.lwjgl.input.Keyboard;

import net.jtk.darkroleplay.main.network.PacketCraft;
import net.jtk.darkroleplay.main.network.PacketHandler;
import net.jtk.darkroleplay.main.network.PacketOpenCraftingGui;
import net.jtk.darkroleplay.main.network.PacketOpenInventoryGui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class KeyBindingManager {

	public static KeyBinding openCrafting = new KeyBinding("keyBinding.openCrafting", Keyboard.KEY_C, "Dark Roleplay");
	public static KeyBinding openInventory = new KeyBinding("keyBinding.openInventory", Keyboard.KEY_X, "Dark Roleplay");
	
	@SubscribeEvent
	public void KeyInput(KeyInputEvent event){
		if(this.openCrafting.isKeyDown()){
			PacketHandler.sendToServer(new PacketOpenCraftingGui());
		}
		if(this.openInventory.isKeyDown()){
			PacketHandler.sendToServer(new PacketOpenInventoryGui());
		}
	}
	
}


