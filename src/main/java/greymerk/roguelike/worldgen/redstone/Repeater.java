package greymerk.roguelike.worldgen.redstone;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Random;

import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.RepeaterBlock;

public class Repeater {

	public static void generate(IWorldEditor editor, Random rand, Cardinal dir, int delay, Coord pos) {
		generate(editor, rand, dir, delay, false, pos);
	}

	public static void generate(IWorldEditor editor, Random rand, Cardinal dir, int delay, boolean powered, Coord pos) {
		MetaBlock repeater = new MetaBlock(powered ? Blocks.REPEATER.getDefaultState().with(RepeaterBlock.POWERED, true)
				: Blocks.REPEATER.getDefaultState().with(RepeaterBlock.POWERED, true));
		repeater.setState(repeater.getState().with(RepeaterBlock.HORIZONTAL_FACING, Cardinal.facing(dir)));
		if (delay > 0 && delay <= 4)
			repeater.setState(repeater.getState().with(RepeaterBlock.DELAY, delay));
		repeater.set(editor, pos);
	}

}