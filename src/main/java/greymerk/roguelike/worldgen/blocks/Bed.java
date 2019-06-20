package greymerk.roguelike.worldgen.blocks;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.config.RogueConfig;
import greymerk.roguelike.util.DyeColor;
import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BedPart;

public class Bed {

	public static void generate(IWorldEditor editor, Cardinal dir, Coord pos, DyeColor color) {
		Coord cursor = new Coord(pos);

		if (RogueConfig.getBoolean(RogueConfig.FURNITURE)) {
			MetaBlock head = new MetaBlock(Blocks.RED_BED.getDefaultState());
			BlockState state = head.getState();
			state.with(BedBlock.PART, BedPart.HEAD);
			// state.with(BedBlock.FACING, Cardinal.facing(dir));
			head.setState(state);
			head.set(editor, cursor);
			// BedTileEntity bed = (BedTileEntity) editor.getTileEntity(cursor);
			// bed.setColor(DyeColor.get(color));
		} else {
			ColorBlock.get(ColorBlock.WOOL, DyeColor.WHITE).set(editor, cursor);
		}

		cursor.add(dir);
		if (RogueConfig.getBoolean(RogueConfig.FURNITURE)) {
			MetaBlock foot = new MetaBlock(Blocks.RED_BED.getDefaultState());
			BlockState state = foot.getState();
			state.with(BedBlock.PART, BedPart.FOOT);
			// foot.withProperty(BedBlock.FACING, Cardinal.facing(dir));
			foot.setState(state);
			foot.set(editor, cursor);
			// BedTileEntity bed = (BedTileEntity) editor.getTileEntity(cursor);
			// bed.setColor(DyeColor.get(color));
		} else {
			ColorBlock.get(ColorBlock.WOOL, DyeColor.RED).set(editor, cursor);
		}
	}

	public static void generate(IWorldEditor editor, Cardinal dir, Coord pos) {
		generate(editor, dir, pos, DyeColor.RED);
	}
}
