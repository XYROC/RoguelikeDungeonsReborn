package greymerk.roguelike.treasure.loot;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import java.util.HashMap;
import java.util.Map;

import greymerk.roguelike.util.IWeighted;
import net.minecraft.item.ItemStack;

public class LootProvider implements ILoot {

	Map<Integer, LootSettings> loot;

	public LootProvider() {
		loot = new HashMap<Integer, LootSettings>();
	}

	public void put(int level, LootSettings settings) {
		loot.put(level, settings);
	}

	@Override
	public IWeighted<ItemStack> get(Loot type, int level) {
		if (level < 0)
			return loot.get(0).get(type);
		if (level > 4)
			return loot.get(4).get(type);
		return loot.get(level).get(type);
	}
}
