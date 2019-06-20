package greymerk.roguelike.worldgen.blocks;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Random;

import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SkullBlock;
import net.minecraft.tileentity.SkullTileEntity;
import net.minecraft.tileentity.TileEntity;

public enum Skull {

	SKELETON, WITHER, ZOMBIE, STEVE, CREEPER;

	public static void set(IWorldEditor editor, Random rand, int x, int y, int z, Cardinal dir, Skull type) {

		MetaBlock skullBlock = new MetaBlock(Blocks.SKELETON_SKULL.getDefaultState());
		BlockState state = skullBlock.getState();
		
		// Makes the skull sit flush against the block below it.
		// skullBlock.withProperty(BlockSkull.FACING, Cardinal.facing(Cardinal.UP));
		state.with(SkullBlock.ROTATION, Integer.valueOf(getDirectionValue(Cardinal.UP)));
		skullBlock.setState(state);

		Coord pos = new Coord(x, y, z);

		if (!skullBlock.set(editor, pos))
			return;

		TileEntity skullEntity = editor.getTileEntity(pos);

		if (skullEntity == null)
			return;
		if (!(skullEntity instanceof SkullTileEntity))
			return;

		SkullTileEntity skull = (SkullTileEntity) skullEntity;

		setType(skull, type);
		setRotation(rand, skull, dir);
	}

	public static void set(IWorldEditor editor, Random rand, Coord cursor, Cardinal dir, Skull type) {
		int x = cursor.getX();
		int y = cursor.getY();
		int z = cursor.getZ();

		set(editor, rand, x, y, z, dir, type);
	}

	public static void setType(SkullTileEntity skull, Skull type) {
		//skull.setType(getSkullId(type)); TODO type ?
	}

	public static void setRotation(Random rand, SkullTileEntity skull, Cardinal dir) {

		int directionValue = getDirectionValue(dir);

		// nudge the skull so that it isn't perfectly aligned.
		directionValue += -1 + rand.nextInt(3);

		// make sure the skull direction value is less than 16
		directionValue = directionValue % 16;

		// skull.setSkullRotation(directionValue); TODO rotation ?

	}

	public static int getSkullId(Skull type) {
		switch (type) {
		case SKELETON:
			return 0;
		case WITHER:
			return 1;
		case ZOMBIE:
			return 2;
		case STEVE:
			return 3;
		case CREEPER:
			return 4;
		default:
			return 0;
		}
	}

	public static int getDirectionValue(Cardinal dir) {
		switch (dir) {
		case NORTH:
			return 0;
		case EAST:
			return 4;
		case SOUTH:
			return 8;
		case WEST:
			return 12;
		default:
			return 0;
		}
	}
}
