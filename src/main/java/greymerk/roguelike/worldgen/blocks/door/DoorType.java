package greymerk.roguelike.worldgen.blocks.door;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public enum DoorType {

	IRON, OAK, BIRCH, SPRUCE, JUNGLE, ACACIA, DARKOAK;

	public static MetaBlock get(DoorType type) {

		BlockState door;
		switch (type) {
		case IRON:
			door = Blocks.IRON_DOOR.getDefaultState();
			break;
		case BIRCH:
			door = Blocks.BIRCH_DOOR.getDefaultState();
			break;
		case SPRUCE:
			door =  Blocks.SPRUCE_DOOR.getDefaultState();
			break;
		case JUNGLE:
			door = Blocks.JUNGLE_DOOR.getDefaultState();
			break;
		case ACACIA:
			door = Blocks.ACACIA_DOOR.getDefaultState();
			break;
		case DARKOAK:
			door = Blocks.DARK_OAK_DOOR.getDefaultState();
			break;
		default:
			door = Blocks.OAK_DOOR.getDefaultState();
			break;
		}

		return new MetaBlock(door);
	}

}
