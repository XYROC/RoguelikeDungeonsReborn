package greymerk.roguelike.treasure.loot;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import greymerk.roguelike.util.IWeighted;
import net.minecraft.item.ItemStack;

public interface ILoot {

	public IWeighted<ItemStack> get(Loot type, int level);

}
