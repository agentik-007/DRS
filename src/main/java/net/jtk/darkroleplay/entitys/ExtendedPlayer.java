package net.jtk.darkroleplay.entitys;

import net.jtk.darkroleplay.entitys.inventory.AbstractInventory;
import net.jtk.darkroleplay.entitys.inventory.InventoryCustom;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties{

	public final static String EXT_PROP_NAME = "DRPPlayerData";
	
	private final EntityPlayer player;
	
	private int currentMana;

	private int maxMana;
	
	public final AbstractInventory inventory = new AbstractInventory();
	
	public ExtendedPlayer(EntityPlayer player){
		this.player = player;
		// Start with max mana. Every player starts with the same amount.
		this.currentMana = this.maxMana = 20;
	}
	
	/**
	* Used to register these extended properties for the player during EntityConstructing event
	* This method is for convenience only; it will make your code look nicer
	*/
	public static final void register(EntityPlayer player){
	player.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer(player));
	}
	
	/**
	* Returns ExtendedPlayer properties for player
	* This method is for convenience only; it will make your code look nicer
	*/
	public static final ExtendedPlayer get(EntityPlayer player){
		return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}
	
	public void copy(ExtendedPlayer props){
		inventory.copy(props.inventory);
	}
	
	@Override
	public void saveNBTData(NBTTagCompound compound){
		NBTTagCompound nbtData = new NBTTagCompound();
	
		inventory.writeToNBT(nbtData);

		nbtData.setInteger("CurrentMana", this.currentMana);
		nbtData.setInteger("MaxMana", this.maxMana);

		compound.setTag(EXT_PROP_NAME, nbtData);
	}

	// Load whatever data you saved
	@Override
	public void loadNBTData(NBTTagCompound compound){
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		
		this.currentMana = properties.getInteger("CurrentMana");
		this.maxMana = properties.getInteger("MaxMana");
		
		inventory.readFromNBT(properties);
		System.out.println("[TUT PROPS] Mana from NBT: " + this.currentMana + "/" + this.maxMana);
	}
	
	@Override
	public void init(Entity entity, World world){}
	
	
	/**
	* Returns true if the amount of mana was consumed or false
	* if the player's current mana was insufficient
	*/
	public boolean consumeMana(int amount){
		// Does the player have enough mana?
		boolean sufficient = amount <= this.currentMana;
		// Consume the amount anyway; if it's more than the player's current mana,
		// mana will be set to 0
		if(sufficient){
			this.currentMana -= (amount < this.currentMana ? amount : this.currentMana);
		}
		// Return if the player had enough mana
		return sufficient;
	}
	
	/**
	* Simple method sets current mana to max mana
	*/
	public void addMana(int amount){
		this.currentMana = this.currentMana + amount;
	}
	
	public void refillMana(){
		this.currentMana = this.maxMana;
	}

	public int getCurrentMana() {
		return currentMana;
	}
	
	public int getMaxMana(){
		return this.maxMana;
	}
}
