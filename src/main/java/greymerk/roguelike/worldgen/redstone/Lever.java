package greymerk.roguelike.worldgen.redstone;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeverBlock;
import net.minecraft.state.properties.AttachFace;

public class Lever {

	public static void generate(IWorldEditor editor, Cardinal dir, Coord pos, boolean active) {
		MetaBlock lever = new MetaBlock(
				Blocks.LEVER.getDefaultState().with(LeverBlock.POWERED, Boolean.valueOf(active)));
		if (dir == Cardinal.UP) {
			lever.setState(lever.getState().with(LeverBlock.FACE, AttachFace.FLOOR));
		} else if (dir == Cardinal.DOWN) {
			lever.setState(lever.getState().with(LeverBlock.FACE, AttachFace.CEILING));
		} else {
			lever.setState(lever.getState().with(LeverBlock.FACE, AttachFace.WALL));
		}
		lever.set(editor, pos);
	}

}
