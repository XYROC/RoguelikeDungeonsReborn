package greymerk.roguelike.worldgen.blocks;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Arrays;

import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.EnderChestBlock;
import net.minecraft.util.Direction;


public class EnderChest {
	public static void set(IWorldEditor editor, Cardinal dir, Coord pos) {

		Direction facing = Arrays.asList(Cardinal.directions).contains(dir) ? Cardinal.facing(Cardinal.reverse(dir))
				: Cardinal.facing(Cardinal.SOUTH);

		MetaBlock chest = new MetaBlock(Blocks.ENDER_CHEST.getDefaultState());
		BlockState state = chest.getState();
		state.with(EnderChestBlock.FACING, facing);
		chest.setState(state);
		chest.set(editor, pos);
	}
}
