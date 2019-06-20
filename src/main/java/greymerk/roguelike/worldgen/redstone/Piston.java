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
import net.minecraft.block.PistonBlock;

public class Piston {

	public static void generate(IWorldEditor editor, Coord origin, Cardinal dir, boolean sticky) {

		MetaBlock piston = new MetaBlock(sticky
				? Blocks.STICKY_PISTON.getDefaultState().with(PistonBlock.FACING,
						Cardinal.facing(Cardinal.reverse(dir)))
				: Blocks.PISTON.getDefaultState().with(PistonBlock.FACING, Cardinal.facing(Cardinal.reverse(dir))));
		piston.set(editor, origin);
	}

}
