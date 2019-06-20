package greymerk.roguelike.dungeon.segment;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import java.util.List;
import java.util.Random;

import greymerk.roguelike.dungeon.IDungeonLevel;
import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;

public interface ISegmentGenerator {

	public List<ISegment> genSegment(IWorldEditor editor, Random rand, IDungeonLevel level, Cardinal dir, Coord pos);

}
