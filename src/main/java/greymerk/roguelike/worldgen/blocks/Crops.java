package greymerk.roguelike.worldgen.blocks;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CocoaBlock;

public enum Crops {

	WHEAT, CARROTS, NETHERWART, MELON, PUMPKIN, POTATOES;

	public static MetaBlock get(Crops type) {
		switch (type) {
		case WHEAT:
			return new MetaBlock(Blocks.WHEAT.getDefaultState());
		case CARROTS:
			return new MetaBlock(Blocks.CARROTS.getDefaultState());
		case NETHERWART:
			return new MetaBlock(Blocks.NETHER_WART.getDefaultState());
		case MELON:
			return new MetaBlock(Blocks.MELON_STEM.getDefaultState());
		case PUMPKIN:
			return new MetaBlock(Blocks.PUMPKIN_STEM.getDefaultState());
		case POTATOES:
			return new MetaBlock(Blocks.POTATOES.getDefaultState());
		default:
			return new MetaBlock(Blocks.WHEAT.getDefaultState());
		}
	}

	public static MetaBlock getCocao(Cardinal dir) {
		MetaBlock cocao = new MetaBlock(Blocks.COCOA.getDefaultState());
		BlockState state = cocao.getState();
		state.with(CocoaBlock.AGE, 2);
		cocao.setState(state);
		return cocao;
	}

	public static MetaBlock getPumpkin(Cardinal dir, boolean lit) {
		MetaBlock pumpkin = new MetaBlock(Blocks.PUMPKIN.getDefaultState());
		//pumpkin.withProperty(PumpkinBlock.FACING, Cardinal.facing(Cardinal.reverse(dir))); TODO facing
		return pumpkin;
	}

}
