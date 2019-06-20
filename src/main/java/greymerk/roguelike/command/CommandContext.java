package greymerk.roguelike.command;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.util.TextFormat;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;
import greymerk.roguelike.worldgen.WorldEditor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class CommandContext implements ICommandContext {

	MinecraftServer server;
	ICommandSender sender;

	public CommandContext(MinecraftServer server, ICommandSender sender) {
		this.server = server;
		this.sender = sender;
	}

	public void sendMessage(String message, MessageType type) {
		TextFormat format = MessageType.getFormat(type);
		String formattedMessage = TextFormat.apply(message, format);
		StringTextComponent text = new StringTextComponent(formattedMessage);
		sender.sendMessage(text);
	}

	public IWorldEditor createEditor() {
		World world = sender.getEntityWorld();
		return new WorldEditor(world);
	}

	public Coord getPos() {
		BlockPos bp = sender.getPosition();
		return new Coord(bp.getX(), bp.getY(), bp.getZ());
	}

	public void give(ItemStack item) {
		Entity player = sender.getCommandSenderEntity();
		ItemEntity drop = player.entityDropItem(item, 0);
		drop.setNoPickupDelay();
	}
}
