package greymerk.roguelike.dungeon.segment.part;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import java.util.Random;

import greymerk.roguelike.dungeon.IDungeonLevel;
import greymerk.roguelike.dungeon.base.IDungeonRoom;
import greymerk.roguelike.dungeon.base.SecretFactory;
import greymerk.roguelike.theme.ITheme;
import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IBlockFactory;
import greymerk.roguelike.worldgen.IStair;
import greymerk.roguelike.worldgen.IWorldEditor;
import greymerk.roguelike.worldgen.MetaBlock;
import greymerk.roguelike.worldgen.blocks.BlockType;
import greymerk.roguelike.worldgen.shapes.RectSolid;

public class SegmentWall extends SegmentBase {

	@Override
	protected void genWall(IWorldEditor editor, Random rand, IDungeonLevel level, Cardinal dir, ITheme theme,
			Coord origin) {

		MetaBlock air = BlockType.get(BlockType.AIR);
		IStair stair = theme.getSecondary().getStair();

		Coord cursor = new Coord(origin);
		Coord start;
		Coord end;

		Cardinal[] orth = Cardinal.orthogonal(dir);

		cursor.add(dir, 2);
		start = new Coord(cursor);
		start.add(orth[0], 1);
		end = new Coord(cursor);
		end.add(orth[1], 1);
		end.add(Cardinal.UP, 2);
		RectSolid.fill(editor, rand, start, end, air);

		SecretFactory secrets = level.getSettings().getSecrets();
		IDungeonRoom room = secrets.genRoom(editor, rand, level.getSettings(), dir, new Coord(origin));

		start.add(dir, 1);
		end.add(dir, 1);
		RectSolid.fill(editor, rand, start, end, theme.getSecondary().getWall(), false, true);

		cursor.add(Cardinal.UP, 2);
		for (Cardinal d : orth) {
			Coord c = new Coord(cursor);
			c.add(d, 1);
			stair.setOrientation(Cardinal.reverse(d), true);
			stair.set(editor, c);
		}

		if (room != null) {
			cursor = new Coord(origin);
			IBlockFactory wall = theme.getPrimary().getWall();
			cursor.add(dir, 3);
			wall.set(editor, rand, cursor);
			cursor.add(Cardinal.UP);
			wall.set(editor, rand, cursor);
		}
	}
}
