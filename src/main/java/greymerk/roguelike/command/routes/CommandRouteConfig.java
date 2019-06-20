package greymerk.roguelike.command.routes;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import java.util.List;

import greymerk.roguelike.command.CommandRouteBase;
import greymerk.roguelike.command.ICommandContext;
import greymerk.roguelike.command.MessageType;
import greymerk.roguelike.config.RogueConfig;
import greymerk.roguelike.util.ArgumentParser;

public class CommandRouteConfig extends CommandRouteBase {

	@Override
	public void execute(ICommandContext context, List<String> args) {
		ArgumentParser ap = new ArgumentParser(args);

		if (!ap.hasEntry(0)) {
			context.sendMessage("Usage: roguelike config reload", MessageType.INFO);
			return;
		}
		if (ap.match(0, "reload")) {
			RogueConfig.reload(true);
			context.sendMessage("Success: Configurations Reloaded", MessageType.SUCCESS);
			return;
		}
		return;
	}

}
