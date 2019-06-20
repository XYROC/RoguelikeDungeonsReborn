package greymerk.roguelike.dungeon.tasks;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import java.util.Random;

import greymerk.roguelike.dungeon.IDungeon;
import greymerk.roguelike.dungeon.settings.ISettings;
import greymerk.roguelike.worldgen.IWorldEditor;

public interface IDungeonTask {

	public void execute(IWorldEditor editor, Random rand, IDungeon dungeon, ISettings settings);

}
