package greymerk.roguelike.worldgen;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import java.util.Random;

public interface IStair extends IBlockFactory {

	public MetaStair setOrientation(Cardinal dir, Boolean upsideDown);

	public boolean set(IWorldEditor editor, Coord pos);

	public boolean set(IWorldEditor editor, Random rand, Coord pos, boolean fillAir, boolean replaceSolid);

}
