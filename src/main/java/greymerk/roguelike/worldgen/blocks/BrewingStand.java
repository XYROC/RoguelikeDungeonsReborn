package greymerk.roguelike.worldgen.blocks;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.BrewingStandTileEntity;
import net.minecraft.tileentity.TileEntity;

public enum BrewingStand {

	LEFT(0), MIDDLE(1), RIGHT(2), INGREDIENT(3), FUEL(4);

	private int id;

	BrewingStand(int id) {
		this.id = id;
	}

	public static boolean generate(IWorldEditor editor, Coord pos) {
		MetaBlock stand = new MetaBlock(Blocks.BREWING_STAND.getDefaultState());
		return stand.set(editor, pos);
	}

	public static BrewingStandTileEntity get(IWorldEditor editor, Coord pos) {
		MetaBlock stand = new MetaBlock(editor.getBlock(pos));
		if (stand.getBlock() != Blocks.BREWING_STAND)
			return null;
		TileEntity te = editor.getTileEntity(pos);
		if (te == null)
			return null;
		if (!(te instanceof BrewingStandTileEntity))
			return null;
		BrewingStandTileEntity brewingTE = (BrewingStandTileEntity) te;
		return brewingTE;
	}

	public static boolean add(IWorldEditor editor, Coord pos, BrewingStand slot, ItemStack item) {
		BrewingStandTileEntity stand = get(editor, pos);
		if (stand == null)
			return false;
		stand.setInventorySlotContents(slot.id, item);
		return true;
	}
}
