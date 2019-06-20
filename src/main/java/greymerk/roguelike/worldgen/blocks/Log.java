package greymerk.roguelike.worldgen.blocks;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.util.Direction;

public class Log {

	public static MetaBlock get(Wood type, Cardinal dir) {

		MetaBlock log = new MetaBlock(getBlockId(type).getDefaultState());
		BlockState state = log.getState();

		setType(log, type);

		if (dir == null) {
			state.with(RotatedPillarBlock.AXIS, Direction.Axis.X);
			log.setState(state);
			return log;
		}

		switch (dir) {
		case UP:
		case DOWN:
			state.with(RotatedPillarBlock.AXIS, Direction.Axis.Y);
			log.setState(state);
			break;
		case EAST:
		case WEST:
			state.with(RotatedPillarBlock.AXIS, Direction.Axis.X);
			log.setState(state);
			break;
		case NORTH:
		case SOUTH:
			state.with(RotatedPillarBlock.AXIS, Direction.Axis.Z);
			log.setState(state);
			break;
		default:
			state.with(RotatedPillarBlock.AXIS, Direction.Axis.X);
			log.setState(state);
			break;
		}

		return log;

	}

	public static MetaBlock getLog(Wood type) {
		return get(type, Cardinal.UP);
	}

	public static Block getBlockId(Wood type) {
		switch (type) {
		case OAK:
			return Blocks.OAK_LOG;
		case SPRUCE:
			return Blocks.SPRUCE_LOG;
		case BIRCH:
			return Blocks.BIRCH_LOG;
		case JUNGLE:
			return Blocks.JUNGLE_LOG;
		case ACACIA:
			return Blocks.ACACIA_LOG;
		case DARKOAK:
			return Blocks.DARK_OAK_LOG;
		default:
			return Blocks.OAK_LOG;
		}
	}

	public static void setType(MetaBlock log, Wood type) {
		switch (type) {
		case OAK:
			log.setState(Blocks.OAK_LOG.getDefaultState().with(RotatedPillarBlock.AXIS, log.getState().get(RotatedPillarBlock.AXIS))); 
			return;
		case SPRUCE:
			log.setState(Blocks.SPRUCE_LOG.getDefaultState().with(RotatedPillarBlock.AXIS, log.getState().get(RotatedPillarBlock.AXIS))); 
			return;
		case BIRCH:
			log.setState(Blocks.BIRCH_LOG.getDefaultState().with(RotatedPillarBlock.AXIS, log.getState().get(RotatedPillarBlock.AXIS))); 
			return;
		case JUNGLE:
			log.setState(Blocks.JUNGLE_LOG.getDefaultState().with(RotatedPillarBlock.AXIS, log.getState().get(RotatedPillarBlock.AXIS))); 
			return;
		case ACACIA:
			log.setState(Blocks.ACACIA_LOG.getDefaultState().with(RotatedPillarBlock.AXIS, log.getState().get(RotatedPillarBlock.AXIS))); 
			return;
		case DARKOAK:
			log.setState(Blocks.DARK_OAK_LOG.getDefaultState().with(RotatedPillarBlock.AXIS, log.getState().get(RotatedPillarBlock.AXIS))); 
		default:
			log.setState(Blocks.OAK_LOG.getDefaultState().with(RotatedPillarBlock.AXIS, log.getState().get(RotatedPillarBlock.AXIS))); 
			return;
		}
	}
}
