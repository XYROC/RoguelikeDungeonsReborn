package greymerk.roguelike.treasure.loot;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import greymerk.roguelike.treasure.loot.books.BookStarter;
import net.minecraft.item.ItemStack;

public enum Book {

	CREDITS;

	public static ItemStack get(Book type) {
		switch (type) {

		default:
			return new BookStarter().get();
		}
	}

}
