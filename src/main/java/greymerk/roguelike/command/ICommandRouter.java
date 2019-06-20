package greymerk.roguelike.command;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import java.util.List;

public interface ICommandRouter {

	public void execute(ICommandContext context, List<String> args);

	public List<String> getTabCompletion(List<String> args);

}
