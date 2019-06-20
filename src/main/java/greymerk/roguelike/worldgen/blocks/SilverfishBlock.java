package greymerk.roguelike.worldgen.blocks;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.worldgen.BlockJumble;
import greymerk.roguelike.worldgen.IBlockFactory;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.Blocks;

public enum SilverfishBlock {

	STONE, COBBLE, STONEBRICK, STONEBRICK_MOSSY, STONEBRICK_CRACKED, STONEBRICK_CHISELED;

	public static MetaBlock get(SilverfishBlock type) {

		MetaBlock block = new MetaBlock(Blocks.INFESTED_STONE.getDefaultState());

		switch (type) {
		case STONE:
			block = new MetaBlock(Blocks.INFESTED_STONE.getDefaultState());
			break;
		case COBBLE:
			block = new MetaBlock(Blocks.INFESTED_COBBLESTONE.getDefaultState());
			break;
		case STONEBRICK:
			block = new MetaBlock(Blocks.INFESTED_STONE_BRICKS.getDefaultState());
			break;
		case STONEBRICK_MOSSY:
			block = new MetaBlock(Blocks.INFESTED_MOSSY_STONE_BRICKS.getDefaultState());
			break;
		case STONEBRICK_CRACKED:
			block = new MetaBlock(Blocks.INFESTED_CRACKED_STONE_BRICKS.getDefaultState());
			break;
		case STONEBRICK_CHISELED:
			block = new MetaBlock(Blocks.INFESTED_CHISELED_STONE_BRICKS.getDefaultState());
			break;
		default:
			block = new MetaBlock(Blocks.INFESTED_STONE.getDefaultState());
			break;
		}

		return block;

	}

	public static IBlockFactory getJumble() {

		BlockJumble jumble = new BlockJumble();

		SilverfishBlock[] types = new SilverfishBlock[] { COBBLE, STONEBRICK, STONEBRICK_MOSSY, STONEBRICK_CRACKED };

		for (SilverfishBlock type : types) {
			jumble.addBlock(get(type));
		}

		return jumble;

	}

}
