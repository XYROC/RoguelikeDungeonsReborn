package greymerk.roguelike.dungeon.base;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import java.util.Random;

public interface IDungeonFactory {

	public IDungeonRoom get(Random rand);

}
