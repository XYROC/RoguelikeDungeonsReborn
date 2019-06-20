package greymerk.roguelike.command.routes;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.List;
import java.util.Set;

import greymerk.roguelike.command.CommandRouteBase;
import greymerk.roguelike.command.ICommandContext;
import greymerk.roguelike.command.MessageType;
import greymerk.roguelike.util.ArgumentParser;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

public class CommandRouteBiome extends CommandRouteBase {

	@Override
	public void execute(ICommandContext context, List<String> args) {

		ArgumentParser ap = new ArgumentParser(args);

		IWorldEditor editor = context.createEditor();
		Coord pos;
		if (!ap.hasEntry(0)) {
			pos = context.getPos();
		} else {
			int x;
			int z;
			try {
				x = CommandBase.parseInt(ap.get(0));
				z = CommandBase.parseInt(ap.get(1));
			} catch (NumberInvalidException e) {
				context.sendMessage("Failure: Invalid Coords: X Z", MessageType.ERROR);
				return;
			}
			pos = new Coord(x, 0, z);
		}

		context.sendMessage("Biome Information for " + pos.toString(), MessageType.SPECIAL);

		Biome biome = editor.getInfo(pos).getBiome();
		context.sendMessage(biome.getBiomeName(), MessageType.SPECIAL);

		Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(biome);
		String types = "";
		for (BiomeDictionary.Type type : biomeTypes) {
			types += type.getName() + " ";
		}

		context.sendMessage(types, MessageType.SPECIAL);
		return;
	}
}
