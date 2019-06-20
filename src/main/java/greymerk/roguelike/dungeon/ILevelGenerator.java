package greymerk.roguelike.dungeon;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import greymerk.roguelike.worldgen.Coord;

public interface ILevelGenerator {

	public void generate(Coord start);

	public ILevelLayout getLayout();

}
