package net.jtk.darkroleplay.handler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class DarkRPExtendedPlayer implements IExtendedEntityProperties
{

public final static String EXT_PROP_NAME = "DarkRPMana";

private final EntityPlayer player;

private int currentMana, maxMana;

public DarkRPExtendedPlayer(EntityPlayer player)
{
this.player = player;
// Start with max mana. Every player starts with the same amount.
this.currentMana = this.maxMana = 50;
}

/*
Used to register these extended properties for the player during EntityConstructing event
This method is for convenience only; it will make your code look nicer
*/
public static final void register(EntityPlayer player)
{
player.registerExtendedProperties(DarkRPExtendedPlayer.EXT_PROP_NAME, new DarkRPExtendedPlayer(player));
}

/*
 Returns DarkRPMana properties for player
 This method is for convenience only; it will make your code look nicer
*/
public static final DarkRPExtendedPlayer get(EntityPlayer player)
{
return (DarkRPExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
}

// Save any custom data that needs saving here
@Override
public void saveNBTData(NBTTagCompound compound)
{
// We need to create a new tag compound that will save everything for our Extended Properties
NBTTagCompound properties = new NBTTagCompound();

// We only have 2 variables currently; save them both to the new tag
properties.setInteger("CurrentMana", this.currentMana);
properties.setInteger("MaxMana", this.maxMana);


compound.setTag(EXT_PROP_NAME, properties);
}

// Load whatever data you saved
@Override
public void loadNBTData(NBTTagCompound compound)
{
NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
this.currentMana = properties.getInteger("CurrentMana");
this.maxMana = properties.getInteger("MaxMana");
}

@Override
public void init(Entity entity, World world)
{
}


public boolean consumeMana(int amount)
{
boolean sufficient = amount <= this.currentMana;
this.currentMana -= (amount < this.currentMana ? amount : this.currentMana);
return sufficient;
}

public void refillMana()
{
this.currentMana = this.maxMana;
}

public int getMaxMana()
{
	return this.maxMana;
}
public int getCurrentMana()
{
	return this.currentMana;
}
}
