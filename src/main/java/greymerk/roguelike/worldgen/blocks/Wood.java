package greymerk.roguelike.worldgen.blocks;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.Blocks;

public enum Wood {

	OAK, SPRUCE, BIRCH, JUNGLE, ACACIA, DARKOAK;

	public static MetaBlock get(WoodBlock block) {
		return get(OAK, block);
	}

	public static MetaBlock get(Wood type, WoodBlock block) {
		switch (block) {
		case LOG:
			return Log.getLog(type);
		case PLANK:
			return getPlank(type);
		case FENCE:
			return getFence(type);
		default:
			return Log.getLog(OAK);
		}
	}

	public static MetaBlock getPlank(Wood type) {

		MetaBlock plank;

		switch (type) {
		case OAK:
			plank = new MetaBlock(Blocks.OAK_PLANKS.getDefaultState());
			break;
		case SPRUCE:
			plank = new MetaBlock(Blocks.SPRUCE_PLANKS.getDefaultState());
			break;
		case BIRCH:
			plank = new MetaBlock(Blocks.BIRCH_PLANKS.getDefaultState());
			break;
		case JUNGLE:
			plank = new MetaBlock(Blocks.JUNGLE_PLANKS.getDefaultState());
			break;
		case ACACIA:
			plank = new MetaBlock(Blocks.ACACIA_PLANKS.getDefaultState());
			break;
		case DARKOAK:
			plank = new MetaBlock(Blocks.DARK_OAK_PLANKS.getDefaultState());
			break;
		default:
			plank = new MetaBlock(Blocks.OAK_PLANKS.getDefaultState());
		}

		return plank;
	}

	public static MetaBlock getFence(Wood type) {

		MetaBlock fence;

		switch (type) {
		case OAK:
			fence = new MetaBlock(Blocks.OAK_FENCE.getDefaultState());
			break;
		case SPRUCE:
			fence = new MetaBlock(Blocks.SPRUCE_FENCE.getDefaultState());
			break;
		case BIRCH:
			fence = new MetaBlock(Blocks.BIRCH_FENCE.getDefaultState());
			break;
		case JUNGLE:
			fence = new MetaBlock(Blocks.JUNGLE_FENCE.getDefaultState());
			break;
		case ACACIA:
			fence = new MetaBlock(Blocks.ACACIA_FENCE.getDefaultState());
			break;
		case DARKOAK:
			fence = new MetaBlock(Blocks.DARK_OAK_FENCE.getDefaultState());
			break;
		default:
			fence = new MetaBlock(Blocks.OAK_FENCE.getDefaultState());
			break;
		}

		return fence;
	}

	public static MetaBlock getSapling(Wood type) {
		MetaBlock sapling;

		switch (type) {
		case OAK:
			sapling = new MetaBlock(Blocks.OAK_SAPLING.getDefaultState());
			break;
		case SPRUCE:
			sapling = new MetaBlock(Blocks.SPRUCE_SAPLING.getDefaultState());
			break;
		case BIRCH:
			sapling = new MetaBlock(Blocks.BIRCH_SAPLING.getDefaultState());
			break;
		case JUNGLE:
			sapling = new MetaBlock(Blocks.JUNGLE_SAPLING.getDefaultState());
			break;
		case ACACIA:
			sapling = new MetaBlock(Blocks.ACACIA_SAPLING.getDefaultState());
			break;
		case DARKOAK:
			sapling = new MetaBlock(Blocks.DARK_OAK_SAPLING.getDefaultState());
			break;
		default:
			sapling = new MetaBlock(Blocks.OAK_SAPLING.getDefaultState());
			break;
		}

		return sapling;
	}

}
