package greymerk.roguelike.worldgen.redstone;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.MetaBlock;
import greymerk.roguelike.worldgen.IWorldEditor;
import net.minecraft.block.Blocks;
import net.minecraft.block.DropperBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.DropperTileEntity;
import net.minecraft.tileentity.TileEntity;

public class Dropper {

	public boolean generate(IWorldEditor editor, Cardinal dir, Coord pos) {
		MetaBlock container = new MetaBlock(Blocks.DROPPER.getDefaultState().with(DropperBlock.FACING, Cardinal.facing(dir)));
		container.set(editor, pos);
		return true;
	}

	public void add(IWorldEditor editor, Coord pos, int slot, ItemStack item) {

		TileEntity te = editor.getTileEntity(pos);
		if (te == null)
			return;
		if (!(te instanceof DropperTileEntity))
			return;
		DropperTileEntity dropper = (DropperTileEntity) te;
		dropper.setInventorySlotContents(slot, item);
	}
}
