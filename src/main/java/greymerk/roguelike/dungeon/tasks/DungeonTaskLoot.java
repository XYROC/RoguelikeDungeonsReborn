package greymerk.roguelike.dungeon.tasks;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import java.util.Random;

import greymerk.roguelike.dungeon.IDungeon;
import greymerk.roguelike.dungeon.settings.ISettings;
import greymerk.roguelike.treasure.Treasure;
import greymerk.roguelike.treasure.TreasureManager;
import greymerk.roguelike.treasure.loot.books.BookStatistics;
import greymerk.roguelike.util.WeightedChoice;
import greymerk.roguelike.worldgen.IWorldEditor;
import net.minecraft.item.ItemStack;

public class DungeonTaskLoot implements IDungeonTask {

	@Override
	public void execute(IWorldEditor editor, Random rand, IDungeon dungeon, ISettings settings) {
		TreasureManager treasure = editor.getTreasure();
		settings.processLoot(rand, treasure);
		treasure.addItem(rand, Treasure.STARTER, new WeightedChoice<ItemStack>(new BookStatistics(editor).get(), 0), 1);
	}
}
