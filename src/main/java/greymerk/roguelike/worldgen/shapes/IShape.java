package greymerk.roguelike.worldgen.shapes;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */


import java.util.List;
import java.util.Random;

import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IBlockFactory;
import greymerk.roguelike.worldgen.IWorldEditor;

public interface IShape extends Iterable<Coord> {

	public void fill(IWorldEditor editor, Random rand, IBlockFactory block);

	public void fill(IWorldEditor editor, Random rand, IBlockFactory block, boolean fillAir, boolean replaceSolid);

	public List<Coord> get();

}
