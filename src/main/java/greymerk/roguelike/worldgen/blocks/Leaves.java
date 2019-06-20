package greymerk.roguelike.worldgen.blocks;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class Leaves {

	public static MetaBlock get(Wood type, boolean decay) {

		Block base = getBlockId(type);

		MetaBlock leaf = new MetaBlock(base.getDefaultState());

		// Original minecraft leaves use a different variant property than
		// newer leaves like acacia and dark oak.
		/*if (base == Blocks.OAK_LEAVES.getBlock()) {
			leaf.withProperty(BlockOldLeaf.VARIANT, getType(type));
		} else {
			leaf.withProperty(BlockNewLeaf.VARIANT, getType(type));
		}

		leaf.withProperty(BlockLeaves.DECAYABLE, decay);*/

		return leaf;

	}

	public static Block getBlockId(Wood type) {
		switch (type) {
		case OAK:
			return Blocks.OAK_LEAVES;
		case SPRUCE:
			return Blocks.SPRUCE_LEAVES;
		case BIRCH:
			return Blocks.BIRCH_LEAVES;
		case JUNGLE:
			return Blocks.JUNGLE_LEAVES;
		case ACACIA:
			return Blocks.ACACIA_LEAVES;
		case DARKOAK:
			return Blocks.DARK_OAK_LEAVES;
		default:
			return Blocks.OAK_LOG;
		}
	}

	/*private static Planks.EnumType getType(Wood type) {

		switch (type) {
		case OAK:
			return BlockPlanks.EnumType.OAK;
		case SPRUCE:
			return BlockPlanks.EnumType.SPRUCE;
		case BIRCH:
			return BlockPlanks.EnumType.BIRCH;
		case JUNGLE:
			return BlockPlanks.EnumType.JUNGLE;
		case ACACIA:
			return BlockPlanks.EnumType.ACACIA;
		case DARKOAK:
			return BlockPlanks.EnumType.DARK_OAK;
		default:
			return BlockPlanks.EnumType.OAK;
		}
	}*/
}
