package net.jtk.darkroleplay.handler;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class DarkRPExtendedPlayer implements IExtendedEntityProperties
{

public final static String EXT_MONEY = "DarkRPMoney";

private final EntityPlayer player;

private int BronzeCoins, SilverCoins, GoldCoins;

public DarkRPExtendedPlayer(EntityPlayer player)
{
this.player = player;
this.BronzeCoins = this.SilverCoins = this.GoldCoins = 0;
}

public static final void register(EntityPlayer player)
{
player.registerExtendedProperties(DarkRPExtendedPlayer.EXT_MONEY, new DarkRPExtendedPlayer(player));
}

public static final DarkRPExtendedPlayer get(EntityPlayer player)
{
return (DarkRPExtendedPlayer) player.getExtendedProperties(EXT_MONEY);
}

// Save any custom data that needs saving here
@Override
public void saveNBTData(NBTTagCompound compound)
{
// We need to create a new tag compound that will save everything for our Extended Properties
NBTTagCompound properties = new NBTTagCompound();

// We only have 2 variables currently; save them both to the new tag
properties.setInteger("BronzeCoins", this.BronzeCoins);
properties.setInteger("SilverCoins", this.SilverCoins);
properties.setInteger("GoldCoins", this.GoldCoins);


compound.setTag(EXT_MONEY, properties);
}

// Load whatever data you saved
@Override
public void loadNBTData(NBTTagCompound compound)
{
NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_MONEY);
this.BronzeCoins = properties.getInteger("BronzeCoins");
this.SilverCoins = properties.getInteger("SilverCoins");
this.GoldCoins = properties.getInteger("GoldCoins");
}

@Override
public void init(Entity entity, World world)
{
}


public boolean consumeMoney(int takeGoldCoins,int takeSilverCoins, int takeBronzeCoins)
{
	
boolean sufficient = takeGoldCoins <= this.GoldCoins;
if(sufficient = true)
{
	sufficient = takeSilverCoins <= this.SilverCoins;
	if(sufficient = true){
		sufficient = takeBronzeCoins <= this.BronzeCoins;
		if(sufficient = true){
			this.GoldCoins -= (takeGoldCoins < this.GoldCoins ? takeGoldCoins : this.GoldCoins);
			this.SilverCoins -= (takeSilverCoins < this.SilverCoins ? takeSilverCoins : this.SilverCoins);
			this.BronzeCoins -= (takeBronzeCoins < this.BronzeCoins ? takeBronzeCoins : this.BronzeCoins);
			return true;
		}else{return false;}
	}else{return false;}	
}else{return false;}
}

public void giveMoney(int giveGoldCoins, int giveSilverCoins,int giveBronzeCoins)
{
this.GoldCoins = this.GoldCoins + giveGoldCoins;
this.SilverCoins = this.SilverCoins + giveSilverCoins;
this.BronzeCoins = this.BronzeCoins + giveBronzeCoins;
while(this.BronzeCoins >=100){
	this.BronzeCoins -= 100;
	this.SilverCoins += 1;
}
while(this.SilverCoins >= 100){
	this.SilverCoins -= 100;
	this.GoldCoins += 1;
}
}
public ArrayList<Integer> getCurrentMoney()
{
	ArrayList<Integer> AllMoney = new ArrayList<Integer>();
	AllMoney.add(this.GoldCoins);
	AllMoney.add(this.SilverCoins);
	AllMoney.add(this.BronzeCoins);
	return AllMoney;
}
}
