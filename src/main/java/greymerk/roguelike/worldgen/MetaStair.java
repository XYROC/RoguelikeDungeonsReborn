package greymerk.roguelike.worldgen;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.worldgen.blocks.StairType;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.state.properties.Half;

public class MetaStair extends MetaBlock implements IStair {

	public MetaStair(BlockState block) {
		super(block);
	}
	
	public MetaStair(MetaBlock block) {
		super(block.getState());
	}

	public MetaStair(StairType type) {
		super(StairType.getBlock(type).getDefaultState());
	}

	public MetaStair setOrientation(Cardinal dir, Boolean upsideDown) {
		BlockState stair = this.getBlock().getDefaultState();
		stair = stair.with(StairsBlock.FACING, Cardinal.facing(dir));
		stair = stair.with(StairsBlock.HALF, upsideDown ? Half.TOP : Half.BOTTOM);
		this.setState(stair);
		return this;
	}

}
