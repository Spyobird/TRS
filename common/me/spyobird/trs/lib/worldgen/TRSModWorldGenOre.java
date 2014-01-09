package me.spyobird.trs.lib.worldgen;

import java.util.Random;

import me.spyobird.trs.block.BlockRegister;
import me.spyobird.trs.lib.Values;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class TRSModWorldGenOre implements IWorldGenerator
{
	@Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
		switch (world.provider.dimensionId){
	        case -1:
	            generateNether(world, random, chunkX * 16, chunkZ * 16);
	            break;
	        case 0:
	            generateSurface(world, random, chunkX * 16, chunkZ * 16);
	            break;
	        case 1:
	            generateEnd(world, random, chunkX * 16, chunkZ * 16);
	            break;
	        }
		}

	private void generateNether(World world, Random rand, int chunkX, int chunkZ) {}
		
	private void generateSurface(World world, Random rand, int chunkX, int chunkZ)
	{
		if (Values.CUSTOMORESPAWNS == true)
		{
			for (int k = 0; k < 24; k++)
	    	{
	    		int firstBlockXCoord = chunkX + rand.nextInt(16);
	    		int firstBlockYCoord = rand.nextInt(72);
	        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
	        	(new WorldGenMinable(BlockRegister.TinOre.blockID, 4)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	    	}
	    	for (int k = 0; k < 16; k++)
	    	{
	        	int firstBlockXCoord = chunkX + rand.nextInt(16);
	        	int firstBlockYCoord = rand.nextInt(128);
	        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
	        	(new WorldGenMinable(BlockRegister.Granite.blockID, 48)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	    	}
		}
	}

	private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {}
}