package greymerk.roguelike.worldgen.blocks;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.Blocks;
public class Cake {

	public static MetaBlock get() {
		return new MetaBlock(Blocks.CAKE.getDefaultState());
	}

}
