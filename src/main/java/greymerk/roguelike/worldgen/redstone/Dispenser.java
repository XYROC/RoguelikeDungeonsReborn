package greymerk.roguelike.worldgen.redstone;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.DispenserTileEntity;
import net.minecraft.tileentity.TileEntity;

public class Dispenser {

	public static boolean generate(IWorldEditor editor, Cardinal dir, Coord pos) {

		MetaBlock container = new MetaBlock(Blocks.DISPENSER.getDefaultState().with(DispenserBlock.FACING, Cardinal.facing(dir)));
		container.set(editor, pos);
		return true;
	}

	public static void add(IWorldEditor editor, Coord pos, int slot, ItemStack item) {

		TileEntity te = editor.getTileEntity(pos);
		if (te == null)
			return;
		if (!(te instanceof DispenserTileEntity))
			return;
		DispenserTileEntity dispenser = (DispenserTileEntity) te;
		dispenser.setInventorySlotContents(slot, item);
	}
}
