package greymerk.roguelike.dungeon.towers;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import java.util.Random;

import greymerk.roguelike.theme.ITheme;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;

public interface ITower {

	public void generate(IWorldEditor editor, Random rand, ITheme theme, Coord origin);

}
