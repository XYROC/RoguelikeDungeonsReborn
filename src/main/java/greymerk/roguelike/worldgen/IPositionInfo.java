package greymerk.roguelike.worldgen;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import net.minecraft.world.biome.Biome;

public interface IPositionInfo {

	int getDimension();

	Biome getBiome();

}
