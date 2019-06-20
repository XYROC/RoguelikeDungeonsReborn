package greymerk.roguelike.treasure.loot;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public enum ItemHideFlags {

	ENCHANTMENTS, ATTRIBUTES, UNBREAKABLE, CANDESTROY, CANPLACEON, EFFECTS;

	public static void set(ItemHideFlags[] flags, ItemStack item) {
		int val = 0;

		for (ItemHideFlags flag : flags) {
			val += get(flag);
		}

		CompoundNBT nbt = item.getTag();
		nbt.putInt("HideFlags", val);
	}

	public static void set(ItemHideFlags flag, ItemStack item) {
		set(new ItemHideFlags[] { flag }, item);
	}

	public static int get(ItemHideFlags flag) {
		switch (flag) {
		case ENCHANTMENTS:
			return 1;
		case ATTRIBUTES:
			return 2;
		case UNBREAKABLE:
			return 4;
		case CANDESTROY:
			return 8;
		case CANPLACEON:
			return 16;
		case EFFECTS:
			return 32;
		default:
			return 0;
		}
	}

}
