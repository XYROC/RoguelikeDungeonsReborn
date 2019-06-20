package greymerk.roguelike.worldgen.blocks;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraftforge.common.PlantType;

public enum TallPlant {

	SUNFLOWER, LILAC, TALLGRASS, FERN, ROSE, PEONY;

	public static void generate(IWorldEditor editor, TallPlant type, Coord pos) {
		Coord cursor;

		// TODO generate flowers
		/*MetaBlock upper = new MetaBlock(Blocks.SUNFLOWER.getStateFromMeta(getMeta(type, true)));
		MetaBlock lower = new MetaBlock(Blocks.DOUBLE_PLANT.getStateFromMeta(getMeta(type, false)));

		cursor = new Coord(pos);
		lower.set(editor, cursor);
		cursor.add(Cardinal.UP);
		upper.set(editor, cursor);*/
		
	}

	public static int getMeta(TallPlant type, boolean top) {
		if (top)
			return 8;

		switch (type) {
		case SUNFLOWER:
			return 0;
		case LILAC:
			return 1;
		case TALLGRASS:
			return 2;
		case FERN:
			return 3;
		case ROSE:
			return 4;
		case PEONY:
			return 5;
		default:
			return 0;
		}

	}

	/*
	 * public static Flower getType(TallPlant type) { switch (type) { case
	 * SUNFLOWER: return PlantType.; case LILAC: return
	 * BlockDoublePlant.EnumPlantType.SYRINGA; case TALLGRASS: return
	 * BlockDoublePlant.EnumPlantType.GRASS; case FERN: return
	 * BlockDoublePlant.EnumPlantType.FERN; case ROSE: return
	 * BlockDoublePlant.EnumPlantType.ROSE; case PEONY: return
	 * BlockDoublePlant.EnumPlantType.PAEONIA; default: return
	 * BlockDoublePlant.EnumPlantType.GRASS; } }
	 */

}
