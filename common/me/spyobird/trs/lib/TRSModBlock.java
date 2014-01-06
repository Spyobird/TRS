package me.spyobird.trs.lib;

import me.spyobird.trs.lib.interfaces.IAdvancedID;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TRSModBlock extends Block implements IAdvancedID
{
	private String texture;
	private String key;
	private String catagory;
	private int code;
	
	public TRSModBlock(int id, Material material, int code)
    {
	    super(id, material);
	    this.setCreativeTab(CreativeTabs.tabMisc);
	    this.setHardness(1.5F);
	    this.setResistance(10.0F);
	    this.setCode(code);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
        blockIcon = register.registerIcon(String.format("%s:%s", References.MODID, this.getTextureName()));
	}
	
	public Block setTextureName(String texture)
	{
		this.texture = texture;
		return this;
	}
	
	public Block setKey(String key)
	{
		this.key = key;
		return this;
	}
	
	public Block setCatagory(String catagory)
	{
		this.catagory = catagory;
		return this;
	}
	
	public String getTextureName()
	{
		return this.texture;
	}
	
	public String getKey()
	{
		return "BLOCK_" + this.key;
	}
	
	public String getCatagory()
	{
		return "BLOCK_CATAGORY_" + this.catagory;
	}
	
	public String getSimpleUnlocalizedName()
	{
		return this.getUnlocalizedName().substring(5);
	}
	
	public String getSimpleKey()
	{
		return this.key;
	}
	
	public String getSimpleCatagory()
	{
		return this.catagory;
	}
	
	@Override
    public boolean setCode(int code)
    {
	    return true;
    }

	@Override
    public int getCode()
    {
	    return code;
    }
	
	public String getAdvancedID()
	{
		String cat;
		String key;
		if (this.catagory == null)
		{
			cat = "BLOCK";
		}
		else
		{
			cat = this.getSimpleCatagory();
		}
		if (this.key == null)
		{
			key = this.getSimpleUnlocalizedName();
		}
		else
		{
			key = this.getSimpleKey();
		}
		return String.format("[%n:%n:%n:#%n]", References.MODID.toUpperCase(), cat, key, this.blockID + this.getCode());
	}
}