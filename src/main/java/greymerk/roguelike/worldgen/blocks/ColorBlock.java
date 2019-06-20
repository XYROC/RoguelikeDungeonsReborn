package greymerk.roguelike.worldgen.blocks;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Random;

import greymerk.roguelike.util.DyeColor;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public enum ColorBlock {

	CLAY, WOOL, CARPET, GLASS, PANE, CONCRETE, POWDER;

	public static MetaBlock get(ColorBlock type, DyeColor color) {
		Block b = getBlock(type);
		// DyeColor c = DyeColor.get(color); TODO color
		MetaBlock block = new MetaBlock(b.getDefaultState());
		return block;
	}

	public static MetaBlock get(ColorBlock type, Random rand) {
		DyeColor[] colors = DyeColor.values();
		DyeColor choice = colors[rand.nextInt(colors.length)];
		return get(type, choice);
	}

	public static Block getBlock(ColorBlock type) {
		switch (type) {
		case CLAY:
			return Blocks.CLAY;
		case WOOL:
			return Blocks.WHITE_WOOL;
		case CARPET:
			return Blocks.WHITE_CARPET;
		case GLASS:
			return Blocks.WHITE_STAINED_GLASS;
		case PANE:
			return Blocks.WHITE_STAINED_GLASS_PANE;
		case CONCRETE:
			return Blocks.WHITE_CONCRETE;
		case POWDER:
			return Blocks.WHITE_CONCRETE_POWDER;
		default:
			return Blocks.WHITE_WOOL;
		}
	}

}
