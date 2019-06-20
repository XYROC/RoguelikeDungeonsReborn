package greymerk.roguelike.treasure.loot.books;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.RoguelikeDungeonsReborn;
import greymerk.roguelike.treasure.loot.BookBase;

public class BookStarter extends BookBase {

	public BookStarter() {
		super("greymerk", "Roguelike Dungeons");

		this.addPage("RoguelikeDungeonsReborn Dungeons v" + RoguelikeDungeonsReborn.VERSION + "\n"
				+ RoguelikeDungeonsReborn.DATE + "\n\n" + "Credits\n\n" + "Original Author: Greymerk\n\n"
				+ "Author: XIROC\n\n" + "Bits: Drainedsoul\n\n" + "Ideas: Eniko @enichan");
	}
}
