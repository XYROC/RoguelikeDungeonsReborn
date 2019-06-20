package greymerk.roguelike;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Random;

import greymerk.roguelike.dungeon.Dungeon;
import greymerk.roguelike.dungeon.IDungeon;
import greymerk.roguelike.worldgen.IWorldEditor;
import greymerk.roguelike.worldgen.WorldEditor;
import net.minecraft.world.World;
import net.minecraft.world.chunk.AbstractChunkProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class DungeonGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, ChunkGenerator chunkGenerator,
			AbstractChunkProvider chunkProvider) {
		RoguelikeDungeonsReborn.LOGGER.info("DUNGEON GENERATOR!!");
		IWorldEditor editor = new WorldEditor(world);
		IDungeon dungeon = new Dungeon(editor);
		dungeon.spawnInChunk(random, chunkX, chunkZ);
	}
	
}