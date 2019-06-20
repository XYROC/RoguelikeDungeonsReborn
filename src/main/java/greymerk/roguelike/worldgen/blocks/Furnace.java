package greymerk.roguelike.worldgen.blocks;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.config.RogueConfig;
import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.TileEntity;

public class Furnace {

	public static final int FUEL_SLOT = 1;
	public static final int OUTPUT_SLOT = 2;

	public static void generate(IWorldEditor editor, Cardinal dir, Coord pos) {
		generate(editor, null, false, dir, pos);
	}

	public static void generate(IWorldEditor editor, boolean lit, Cardinal dir, Coord pos) {
		generate(editor, null, lit, dir, pos);
	}

	public static void generate(IWorldEditor editor, ItemStack fuel, boolean lit, Cardinal dir, Coord pos) {

		if (!RogueConfig.getBoolean(RogueConfig.FURNITURE))
			return;

		MetaBlock furnace;

		if (lit) {
			furnace = new MetaBlock(
					Blocks.FURNACE.getDefaultState().with(AbstractFurnaceBlock.field_220091_b, Boolean.valueOf(true)));
		} else {
			furnace = new MetaBlock(Blocks.FURNACE.getDefaultState());
		}

		//furnace.withProperty(BlockFurnace.FACING, Cardinal.facing(Cardinal.reverse(dir)));

		furnace.set(editor, pos);

		if (fuel == null)
			return;

		TileEntity te = editor.getTileEntity(pos);
		if (te == null)
			return;
		if (!(te instanceof FurnaceTileEntity))
			return;
		FurnaceTileEntity teFurnace = (FurnaceTileEntity) te;
		teFurnace.setInventorySlotContents(FUEL_SLOT, fuel);
	}
}
