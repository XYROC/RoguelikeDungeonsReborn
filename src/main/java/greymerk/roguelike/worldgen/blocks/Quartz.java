package greymerk.roguelike.worldgen.blocks;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.util.Direction;

public enum Quartz {

	SMOOTH, CHISELED, PILLAR;

	public static MetaBlock get(Quartz type) {
		MetaBlock block;
		switch (type) {
		case CHISELED:
			block = new MetaBlock(Blocks.CHISELED_QUARTZ_BLOCK.getDefaultState());
		case PILLAR:
			block = new MetaBlock(Blocks.QUARTZ_PILLAR.getDefaultState());
		case SMOOTH:
			block = new MetaBlock(Blocks.SMOOTH_QUARTZ.getDefaultState());
		default:
			return new MetaBlock(Blocks.QUARTZ_BLOCK.getDefaultState());
		}
	}

	public static MetaBlock getPillar(Cardinal dir) {
		MetaBlock block = new MetaBlock(Blocks.QUARTZ_BLOCK.getDefaultState());
		BlockState state = block.getState();
		switch (dir) {
		case EAST:
		case WEST:
			state.with(RotatedPillarBlock.AXIS, Direction.Axis.X);
			block.setState(state);
			break;
		case NORTH:
		case SOUTH:
			state.with(RotatedPillarBlock.AXIS, Direction.Axis.Z);
			block.setState(state);
			break;
		case UP:
		case DOWN:
		default:
			state.with(RotatedPillarBlock.AXIS, Direction.Axis.Y);
			block.setState(state);
			break;
		}

		return block;
	}

}
