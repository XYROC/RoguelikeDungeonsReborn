package greymerk.roguelike.command;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

import greymerk.roguelike.command.routes.CommandRouteRoguelike;
import net.minecraft.command.CommandException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;

public class CommandRoguelike extends CommandBase {

	private ICommandRouter router;

	public CommandRoguelike() {
		this.router = new CommandRouteRoguelike();
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return null;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		ICommandContext context = new CommandContext(server, sender);
		router.execute(context, Arrays.asList(args));
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			@Nullable BlockPos targetPos) {
		return router.getTabCompletion(Arrays.asList(args));
	}
}
