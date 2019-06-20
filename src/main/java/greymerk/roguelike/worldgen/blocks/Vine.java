package greymerk.roguelike.worldgen.blocks;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Random;

import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;
import greymerk.roguelike.worldgen.MetaBlock;
import greymerk.roguelike.worldgen.shapes.RectSolid;
import net.minecraft.block.BlockState;
import net.minecraft.block.VineBlock;

public class Vine {

	public static void fill(IWorldEditor editor, Random rand, Coord start, Coord end) {
		for (Coord cursor : new RectSolid(start, end)) {
			set(editor, cursor);
		}
	}

	public static void set(IWorldEditor editor, Coord origin) {
		if (!editor.isAirBlock(origin))
			return;
		MetaBlock vine = BlockType.get(BlockType.VINE);
		for (Cardinal dir : Cardinal.directions) {
			Coord c = new Coord(origin);
			c.add(dir);
			if (editor.canPlace(vine, c, dir)) {
				setOrientation(vine, dir).set(editor, c);
				return;
			}
		}
	}

	public static MetaBlock setOrientation(MetaBlock vine, Cardinal dir) {
		BlockState state = vine.getState();
		state.with(VineBlock.NORTH, Boolean.valueOf(dir == Cardinal.NORTH));
		state.with(VineBlock.EAST, Boolean.valueOf(dir == Cardinal.EAST));
		state.with(VineBlock.SOUTH, Boolean.valueOf(dir == Cardinal.SOUTH));
		state.with(VineBlock.WEST, Boolean.valueOf(dir == Cardinal.WEST));
		vine.setState(state);
		return vine;
	}
}
