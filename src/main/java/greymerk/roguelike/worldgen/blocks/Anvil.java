package greymerk.roguelike.worldgen.blocks;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.config.RogueConfig;
import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
public enum Anvil {
	
	NEW_ANVIL, DAMAGED_ANVIL, VERY_DAMAGED_ANVIL;

	public static MetaBlock get(Anvil damage, Cardinal dir) {

		if (!RogueConfig.getBoolean(RogueConfig.FURNITURE)) {
			return BlockType.get(BlockType.ANDESITE_POLISHED);
		}

		MetaBlock anvil = new MetaBlock(Blocks.ANVIL.getDefaultState());
		BlockState state = anvil.getState();

		switch (damage) {
		case NEW_ANVIL:
			// anvil.withProperty(BlockAnvil.DAMAGE, 0); TODO anvil damage
			break;
		case DAMAGED_ANVIL:
			// anvil.withProperty(BlockAnvil.DAMAGE, 1);
			break;
		case VERY_DAMAGED_ANVIL:
			// anvil.withProperty(BlockAnvil.DAMAGE, 2);
			break;
		default:
		}

		state.with(AnvilBlock.FACING, Cardinal.facing(dir));
		anvil.setState(state);
		return anvil;
	}

}
