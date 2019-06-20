package greymerk.roguelike.worldgen.redstone;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Arrays;

import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.HopperBlock;

public class Hopper {

	public static void generate(IWorldEditor editor, Cardinal dir, Coord pos) {
		MetaBlock hopper = new MetaBlock(Blocks.HOPPER.getDefaultState());
		if (Arrays.asList(Cardinal.directions).contains(dir))
			hopper.setState(hopper.getState().with(HopperBlock.FACING, Cardinal.facing(Cardinal.reverse(dir))));
		hopper.set(editor, pos);
	}
}
