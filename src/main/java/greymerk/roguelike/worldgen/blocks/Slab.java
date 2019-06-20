package greymerk.roguelike.worldgen.blocks;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.state.properties.SlabType;

public enum Slab {

	STONE, STONEBRICK, COBBLE, BRICK, NETHERBRICK, QUARTZ, LEGACY_OAK, SANDSTONE, SANDSTONE_RED, OAK, SPRUCE, BIRCH,
	JUNGLE, ACACIA, DARKOAK;

	public static MetaBlock get(Slab type, boolean upsideDown, boolean full, boolean seamless) {
		MetaBlock slab = null;

		switch (type) {
		case STONE:
			slab = full ? new MetaBlock(Blocks.STONE_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE))
					: new MetaBlock(Blocks.STONE_SLAB.getDefaultState());
			break;
		case SANDSTONE:
			slab = full ? new MetaBlock(Blocks.SANDSTONE_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE))
					: new MetaBlock(Blocks.SANDSTONE_SLAB.getDefaultState());
			break;
		case LEGACY_OAK:
			slab = full ? new MetaBlock(Blocks.OAK_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE))
					: new MetaBlock(Blocks.OAK_SLAB.getDefaultState());
			break;
		case COBBLE:
			slab = full ? new MetaBlock(Blocks.COBBLESTONE_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE))
					: new MetaBlock(Blocks.COBBLESTONE_SLAB.getDefaultState());
			break;
		case BRICK:
			slab = full ? new MetaBlock(Blocks.BRICK_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE))
					: new MetaBlock(Blocks.BRICK_SLAB.getDefaultState());
			break;
		case STONEBRICK:
			slab = full ? new MetaBlock(Blocks.STONE_BRICK_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE))
					: new MetaBlock(Blocks.STONE_BRICK_SLAB.getDefaultState());
			break;
		case NETHERBRICK:
			slab = full
					? new MetaBlock(Blocks.NETHER_BRICK_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE))
					: new MetaBlock(Blocks.NETHER_BRICK_SLAB.getDefaultState());
			break;
		case QUARTZ:
			slab = full ? new MetaBlock(Blocks.QUARTZ_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE))
					: new MetaBlock(Blocks.QUARTZ_SLAB.getDefaultState());
			break;
		case SANDSTONE_RED:
			slab = full
					? new MetaBlock(Blocks.RED_SANDSTONE_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE))
					: new MetaBlock(Blocks.RED_SANDSTONE_SLAB.getDefaultState());
			break;
		case OAK:
			slab = full ? new MetaBlock(Blocks.OAK_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE))
					: new MetaBlock(Blocks.OAK_SLAB.getDefaultState());
			break;
		case SPRUCE:
			slab = full ? new MetaBlock(Blocks.SPRUCE_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE))
					: new MetaBlock(Blocks.SPRUCE_SLAB.getDefaultState());
			break;
		case BIRCH:
			slab = full ? new MetaBlock(Blocks.BIRCH_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE))
					: new MetaBlock(Blocks.BIRCH_SLAB.getDefaultState());
			break;
		case JUNGLE:
			slab = full ? new MetaBlock(Blocks.JUNGLE_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE))
					: new MetaBlock(Blocks.JUNGLE_SLAB.getDefaultState());
			break;
		case ACACIA:
			slab = full ? new MetaBlock(Blocks.ACACIA_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE))
					: new MetaBlock(Blocks.ACACIA_SLAB.getDefaultState());
			break;
		case DARKOAK:
			slab = full ? new MetaBlock(Blocks.DARK_OAK_SLAB.getDefaultState().with(SlabBlock.TYPE, SlabType.DOUBLE))
					: new MetaBlock(Blocks.DARK_OAK_SLAB.getDefaultState());
			break;
		default:
		}

		BlockState state = slab.getState();
		if (!full && upsideDown)
			state.with(SlabBlock.TYPE, SlabType.TOP);

		if (full && seamless)
			state.with(SlabBlock.TYPE, SlabType.DOUBLE);

		slab.setState(state);
		return slab;

	}

	public static MetaBlock get(Slab type) {
		return get(type, false, false, false);
	}

	/*
	 * public static Block getBaseSlab(Slab type, boolean full) { switch (type) {
	 * case STONE: case SANDSTONE: case LEGACY_OAK: case COBBLE: case BRICK: case
	 * STONEBRICK: case NETHERBRICK: case QUARTZ: return full ?
	 * Blocks.DOUBLE_STONE_SLAB : Blocks.STONE_SLAB; case SANDSTONE_RED: return full
	 * ? Blocks.DOUBLE_STONE_SLAB2 : Blocks.STONE_SLAB2; case OAK: case SPRUCE: case
	 * BIRCH: case JUNGLE: case ACACIA: case DARKOAK: return full ?
	 * Blocks.DOUBLE_WOODEN_SLAB : Blocks.WOODEN_SLAB; default: return
	 * Blocks.STONE_SLAB; } }
	 */

}
