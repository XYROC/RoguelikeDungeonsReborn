package greymerk.roguelike.treasure.loot.provider;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import greymerk.roguelike.treasure.loot.Equipment;
import greymerk.roguelike.treasure.loot.Quality;

import java.util.Random;

import net.minecraft.item.ItemStack;

public class ItemSmithy extends ItemBase {

	public ItemSmithy(int weight, int level) {
		super(weight, level);
	}

	@Override
	public ItemStack getLootItem(Random rand, int level) {
		return ItemSpecialty.getRandomItem(Equipment.SWORD, rand, Quality.IRON);
	}
}
