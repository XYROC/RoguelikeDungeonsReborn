package greymerk.roguelike.worldgen.blocks;

import greymerk.roguelike.util.DyeColor;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.Blocks;

public class Terracotta {

	public static MetaBlock get(DyeColor color, Cardinal dir) {
		MetaBlock block = getByColor(color);
		// block.withProperty(BlockGlazedTerracotta.FACING, Cardinal.facing(dir));
		return block;
	}

	public static MetaBlock getByColor(DyeColor color) {
		switch (color) {
		case WHITE:
			return new MetaBlock(Blocks.WHITE_GLAZED_TERRACOTTA.getDefaultState());
		case ORANGE:
			return new MetaBlock(Blocks.ORANGE_GLAZED_TERRACOTTA.getDefaultState());
		case MAGENTA:
			return new MetaBlock(Blocks.MAGENTA_GLAZED_TERRACOTTA.getDefaultState());
		case LIGHT_BLUE:
			return new MetaBlock(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA.getDefaultState());
		case YELLOW:
			return new MetaBlock(Blocks.YELLOW_GLAZED_TERRACOTTA.getDefaultState());
		case LIME:
			return new MetaBlock(Blocks.LIME_GLAZED_TERRACOTTA.getDefaultState());
		case PINK:
			return new MetaBlock(Blocks.PINK_GLAZED_TERRACOTTA.getDefaultState());
		case GRAY:
			return new MetaBlock(Blocks.GRAY_GLAZED_TERRACOTTA.getDefaultState());
		case LIGHT_GRAY:
			return new MetaBlock(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA.getDefaultState());
		case CYAN:
			return new MetaBlock(Blocks.CYAN_GLAZED_TERRACOTTA.getDefaultState());
		case PURPLE:
			return new MetaBlock(Blocks.PURPLE_GLAZED_TERRACOTTA.getDefaultState());
		case BLUE:
			return new MetaBlock(Blocks.BLUE_GLAZED_TERRACOTTA.getDefaultState());
		case BROWN:
			return new MetaBlock(Blocks.BROWN_GLAZED_TERRACOTTA.getDefaultState());
		case GREEN:
			return new MetaBlock(Blocks.GREEN_GLAZED_TERRACOTTA.getDefaultState());
		case RED:
			return new MetaBlock(Blocks.RED_GLAZED_TERRACOTTA.getDefaultState());
		case BLACK:
			return new MetaBlock(Blocks.BLACK_GLAZED_TERRACOTTA.getDefaultState());
		}
		return null;
	}

}
