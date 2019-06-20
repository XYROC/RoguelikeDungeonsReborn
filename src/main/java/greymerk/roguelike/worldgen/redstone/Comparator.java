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
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComparatorBlock;
import net.minecraft.state.properties.ComparatorMode;

public class Comparator {

	public static void generate(IWorldEditor world, Random rand, Cardinal dir, boolean subtraction, Coord pos) {
		MetaBlock comparator = new MetaBlock(
				Blocks.COMPARATOR.getDefaultState().with(ComparatorBlock.POWERED, Boolean.valueOf(false)));
		BlockState state = comparator.getState();
		state = state.with(ComparatorBlock.HORIZONTAL_FACING, Cardinal.facing(dir));
		if (subtraction)
			state = state.with(ComparatorBlock.MODE, ComparatorMode.SUBTRACT);
		else
			state = state.with(ComparatorBlock.MODE, ComparatorMode.COMPARE);
		comparator.set(world, pos);
	}

}
