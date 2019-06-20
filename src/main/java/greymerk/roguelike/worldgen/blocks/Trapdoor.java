package greymerk.roguelike.worldgen.blocks;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.state.properties.Half;

public enum Trapdoor {

	OAK, IRON;

	public static MetaBlock get(Trapdoor type, Cardinal dir, boolean bottom, boolean open) {

		MetaBlock block;

		switch (type) {
		case OAK:
			block = new MetaBlock(Blocks.OAK_TRAPDOOR.getDefaultState());
			break;
		case IRON:
			block = new MetaBlock(Blocks.IRON_TRAPDOOR.getDefaultState());
			break;
		default:
			block = new MetaBlock(Blocks.OAK_TRAPDOOR.getDefaultState());
			break;
		}
		BlockState state = block.getState();
		// state.with(TrapDoorBlock.HORIZONTAL_FACING, Direction.Plane.HORIZONTAL);

		if (bottom) {
			state.with(TrapDoorBlock.HALF, Half.BOTTOM);
		}

		if (open) {
			state.with(TrapDoorBlock.OPEN, true);
		}
		block.setState(state);
		return block;

	}

}
