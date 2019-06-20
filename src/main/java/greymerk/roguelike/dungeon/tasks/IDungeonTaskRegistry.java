package greymerk.roguelike.dungeon.tasks;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import java.util.List;

import greymerk.roguelike.dungeon.DungeonStage;

public interface IDungeonTaskRegistry {

	public void addTask(IDungeonTask task, DungeonStage stage);

	public List<IDungeonTask> getTasks(DungeonStage stage);

}
