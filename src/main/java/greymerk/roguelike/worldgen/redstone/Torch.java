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
import net.minecraft.block.RedstoneTorchBlock;

public enum Torch {

	REDSTONE, WOODEN, REDSTONE_UNLIT;

	public static void generate(IWorldEditor editor, Torch type, Cardinal dir, Coord pos) {
		MetaBlock torch;


		switch (type) {
		case WOODEN:
			torch = new MetaBlock(Blocks.TORCH.getDefaultState());
			break;
		case REDSTONE:
			torch = new MetaBlock(Blocks.REDSTONE_TORCH.getDefaultState());
			break;
		case REDSTONE_UNLIT:
			torch = new MetaBlock(Blocks.REDSTONE_TORCH.getDefaultState().with(RedstoneTorchBlock.LIT, false));
			break;
		default:
			torch = new MetaBlock(Blocks.TORCH.getDefaultState());
			break;
		}

		/*if (dir == Cardinal.UP) {
			torch.withProperty(BlockTorch.FACING, EnumFacing.UP);
		} else if (dir == Cardinal.DOWN) {
			torch.withProperty(BlockTorch.FACING, EnumFacing.DOWN);
		} else {
			torch.withProperty(BlockTorch.FACING, Cardinal.facing(Cardinal.reverse(dir)));
		}*/

		torch.set(editor, pos);

	}

}
