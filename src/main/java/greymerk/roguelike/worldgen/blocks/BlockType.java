package greymerk.roguelike.worldgen.blocks;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import greymerk.roguelike.config.RogueConfig;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneLampBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public enum BlockType {

	AIR, WATER_STILL, WATER_FLOWING, LAVA_STILL, LAVA_FLOWING, FIRE, IRON_BAR, STONE_SMOOTH, GRANITE, GRANITE_POLISHED,
	DIORITE, DIORITE_POLISHED, ANDESITE, ANDESITE_POLISHED, GRASS, DIRT, DIRT_COARSE, DIRT_PODZOL, COBBLESTONE,
	COBBLESTONE_WALL, BEDROCK, SAND, SAND_RED, GRAVEL, ORE_GOLD, ORE_IRON, ORE_COAL, GLASS, ORE_LAPIS, ORE_EMERALD,
	LAPIS_BLOCK, SANDSTONE, SANDSTONE_CHISELED, SANDSTONE_SMOOTH, GOLD_BLOCK, IRON_BLOCK, BRICK, COBBLESTONE_MOSSY,
	OBSIDIAN, ORE_DIAMOND, DIAMOND_BLOCK, FARMLAND, ORE_REDSTONE, ICE, SNOW, CLAY, NETHERRACK, SOUL_SAND, GLOWSTONE,
	STONE_BRICK, STONE_BRICK_MOSSY, STONE_BRICK_CRACKED, STONE_BRICK_CHISELED, MYCELIUM, NETHERBRICK, END_STONE,
	EMERALD_BLOCK, ORE_QUARTZ, PRISMITE, PRISMARINE, PRISMARINE_DARK, SEA_LANTERN, COAL_BLOCK, ICE_PACKED,
	SANDSTONE_RED, SANDSTONE_RED_CHISELED, SANDSTONE_RED_SMOOTH, QUARTZ, REDSTONE_BLOCK, PRESSURE_PLATE_STONE,
	PRESSURE_PLATE_WOODEN, SHELF, REDSTONE_WIRE, COCAO, REEDS, CRAFTING_TABLE, NOTEBLOCK, REDSTONE_LAMP,
	REDSTONE_LAMP_LIT, JUKEBOX, FENCE, TNT, ENCHANTING_TABLE, FENCE_NETHER_BRICK, WEB, PUMPKIN_LIT, VINE, PURPUR_BLOCK,
	PURPUR_PILLAR, PURPUR_STAIR, PURPUR_DOUBLE_SLAB, PURPUR_SLAB, ENDER_BRICK, MAGMA, RED_NETHERBRICK,
	NETHER_WART_BLOCK, BONE_BLOCK;

	public static MetaBlock get(BlockType type) {

		MetaBlock block;

		switch (type) {
		case AIR:
			return new MetaBlock(Blocks.AIR.getDefaultState());
		case WATER_STILL:
			return new MetaBlock(Blocks.WATER.getDefaultState());
		case WATER_FLOWING:
			return new MetaBlock(Blocks.WATER.getDefaultState()); // TODO flowing
		case LAVA_STILL:
			return new MetaBlock(Blocks.LAVA.getDefaultState());
		case LAVA_FLOWING:
			return new MetaBlock(Blocks.LAVA.getDefaultState()); // TODO flowing
		case FIRE:
			return new MetaBlock(Blocks.FIRE.getDefaultState());
		case IRON_BAR:
			return new MetaBlock(Blocks.IRON_BARS.getDefaultState());
		case STONE_SMOOTH:
			return new MetaBlock(Blocks.STONE.getDefaultState());
		case GRANITE:
			block = new MetaBlock(Blocks.GRANITE.getDefaultState());
			return block;
		case GRANITE_POLISHED:
			block = new MetaBlock(Blocks.POLISHED_GRANITE.getDefaultState());
			return block;
		case DIORITE:
			block = new MetaBlock(Blocks.DIORITE.getDefaultState());
			return block;
		case DIORITE_POLISHED:
			block = new MetaBlock(Blocks.POLISHED_DIORITE.getDefaultState());
			return block;
		case ANDESITE:
			block = new MetaBlock(Blocks.ANDESITE.getDefaultState());
			return block;
		case ANDESITE_POLISHED:
			block = new MetaBlock(Blocks.POLISHED_ANDESITE.getDefaultState());
			return block;
		case GRASS:
			return new MetaBlock(Blocks.GRASS.getDefaultState());
		case DIRT:
			return new MetaBlock(Blocks.DIRT.getDefaultState());
		case DIRT_COARSE:
			block = new MetaBlock(Blocks.COARSE_DIRT.getDefaultState());
			return block;
		case DIRT_PODZOL:
			block = new MetaBlock(Blocks.PODZOL.getDefaultState());
			return block;
		case COBBLESTONE:
			return new MetaBlock(Blocks.COBBLESTONE.getDefaultState());
		case COBBLESTONE_WALL:
			return new MetaBlock(Blocks.COBBLESTONE_WALL.getDefaultState());
		case BEDROCK:
			return new MetaBlock(Blocks.BEDROCK.getDefaultState());
		case SAND:
			return new MetaBlock(Blocks.SAND.getDefaultState());
		case SAND_RED:
			block = new MetaBlock(Blocks.RED_SAND.getDefaultState());
			return block;
		case GRAVEL:
			return new MetaBlock(Blocks.GRAVEL.getDefaultState());
		case ORE_GOLD:
			return new MetaBlock(Blocks.GOLD_ORE.getDefaultState());
		case ORE_IRON:
			return new MetaBlock(Blocks.IRON_ORE.getDefaultState());
		case GLASS:
			return new MetaBlock(Blocks.GLASS.getDefaultState());
		case ORE_LAPIS:
			return new MetaBlock(Blocks.LAPIS_ORE.getDefaultState());
		case LAPIS_BLOCK:
			return new MetaBlock(Blocks.LAPIS_BLOCK.getDefaultState());
		case ORE_EMERALD:
			return new MetaBlock(Blocks.EMERALD_ORE.getDefaultState());
		case SANDSTONE:
			return new MetaBlock(Blocks.SANDSTONE.getDefaultState());
		case SANDSTONE_CHISELED:
			block = new MetaBlock(Blocks.CHISELED_SANDSTONE.getDefaultState());
			return block;
		case SANDSTONE_SMOOTH:
			block = new MetaBlock(Blocks.SMOOTH_SANDSTONE.getDefaultState());
			return block;
		case GOLD_BLOCK:
			return new MetaBlock(Blocks.GOLD_BLOCK.getDefaultState());
		case IRON_BLOCK:
			return new MetaBlock(Blocks.IRON_BLOCK.getDefaultState());
		case BRICK:
			return new MetaBlock(Blocks.BRICKS.getDefaultState());
		case COBBLESTONE_MOSSY:
			return new MetaBlock(Blocks.MOSSY_COBBLESTONE.getDefaultState());
		case OBSIDIAN:
			return new MetaBlock(Blocks.OBSIDIAN.getDefaultState());
		case ORE_DIAMOND:
			return new MetaBlock(Blocks.DIAMOND_ORE.getDefaultState());
		case DIAMOND_BLOCK:
			return new MetaBlock(Blocks.DIAMOND_BLOCK.getDefaultState());
		case FARMLAND:
			return new MetaBlock(Blocks.FARMLAND.getDefaultState());
		case ORE_REDSTONE:
			return new MetaBlock(Blocks.REDSTONE_ORE.getDefaultState());
		case ICE:
			return new MetaBlock(Blocks.ICE.getDefaultState());
		case SNOW:
			return new MetaBlock(Blocks.SNOW.getDefaultState());
		case CLAY:
			return new MetaBlock(Blocks.CLAY.getDefaultState());
		case NETHERRACK:
			return new MetaBlock(Blocks.NETHERRACK.getDefaultState());
		case SOUL_SAND:
			return new MetaBlock(Blocks.SOUL_SAND.getDefaultState());
		case GLOWSTONE:
			return new MetaBlock(Blocks.GLOWSTONE.getDefaultState());
		case STONE_BRICK:
			return new MetaBlock(Blocks.STONE_BRICKS.getDefaultState());
		case STONE_BRICK_MOSSY:
			block = new MetaBlock(Blocks.MOSSY_STONE_BRICKS.getDefaultState());
			return block;
		case STONE_BRICK_CRACKED:
			block = new MetaBlock(Blocks.CRACKED_STONE_BRICKS.getDefaultState());
			return block;
		case STONE_BRICK_CHISELED:
			block = new MetaBlock(Blocks.CHISELED_STONE_BRICKS.getDefaultState());
			return block;
		case MYCELIUM:
			return new MetaBlock(Blocks.MYCELIUM.getDefaultState());
		case NETHERBRICK:
			return new MetaBlock(Blocks.NETHER_BRICKS.getDefaultState());
		case END_STONE:
			return new MetaBlock(Blocks.END_STONE.getDefaultState());
		case EMERALD_BLOCK:
			return new MetaBlock(Blocks.EMERALD_BLOCK.getDefaultState());
		case ORE_QUARTZ:
			return new MetaBlock(Blocks.NETHER_QUARTZ_ORE.getDefaultState());
		case PRISMITE:
			block = new MetaBlock(Blocks.PRISMARINE_BRICKS.getDefaultState());
			return block;
		case PRISMARINE:
			block = new MetaBlock(Blocks.PRISMARINE.getDefaultState());
			return block;
		case PRISMARINE_DARK:
			block = new MetaBlock(Blocks.DARK_PRISMARINE.getDefaultState());
			return block;
		case SEA_LANTERN:
			return new MetaBlock(Blocks.SEA_LANTERN.getDefaultState());
		case COAL_BLOCK:
			return new MetaBlock(Blocks.COAL_BLOCK.getDefaultState());
		case ICE_PACKED:
			return new MetaBlock(Blocks.PACKED_ICE.getDefaultState());
		case SANDSTONE_RED:
			return new MetaBlock(Blocks.RED_SANDSTONE.getDefaultState());
		case SANDSTONE_RED_CHISELED:
			block = new MetaBlock(Blocks.CHISELED_RED_SANDSTONE.getDefaultState());
			return block;
		case SANDSTONE_RED_SMOOTH:
			block = new MetaBlock(Blocks.SMOOTH_RED_SANDSTONE.getDefaultState());
			return block;
		case QUARTZ:
			return new MetaBlock(Blocks.QUARTZ_BLOCK.getDefaultState());
		case REDSTONE_BLOCK:
			return new MetaBlock(Blocks.REDSTONE_BLOCK.getDefaultState());
		case PRESSURE_PLATE_STONE:
			return new MetaBlock(Blocks.STONE_PRESSURE_PLATE.getDefaultState());
		case PRESSURE_PLATE_WOODEN:
			return new MetaBlock(Blocks.OAK_PRESSURE_PLATE.getDefaultState());
		case SHELF:
			return new MetaBlock(Blocks.BOOKSHELF.getDefaultState());
		case REDSTONE_WIRE:
			return new MetaBlock(Blocks.REDSTONE_WIRE.getDefaultState());
		case COCAO:
			return new MetaBlock(Blocks.COCOA.getDefaultState());
		case REEDS:
			return new MetaBlock(Blocks.SUGAR_CANE.getDefaultState());
		case CRAFTING_TABLE:
			if (!RogueConfig.getBoolean(RogueConfig.FURNITURE))
				return Wood.getPlank(Wood.OAK);
			return new MetaBlock(Blocks.CRAFTING_TABLE.getDefaultState());
		case NOTEBLOCK:
			return new MetaBlock(Blocks.NOTE_BLOCK.getDefaultState());
		case REDSTONE_LAMP:
			return new MetaBlock(Blocks.REDSTONE_LAMP.getDefaultState());
		case REDSTONE_LAMP_LIT:
			return new MetaBlock(Blocks.REDSTONE_LAMP.getDefaultState().with(RedstoneLampBlock.LIT, Boolean.valueOf(true)));
		case JUKEBOX:
			return new MetaBlock(Blocks.JUKEBOX.getDefaultState());
		case FENCE:
			return new MetaBlock(Blocks.OAK_FENCE.getDefaultState());
		case TNT:
			return new MetaBlock(Blocks.TNT.getDefaultState());
		case ENCHANTING_TABLE:
			return new MetaBlock(Blocks.ENCHANTING_TABLE.getDefaultState());
		case FENCE_NETHER_BRICK:
			return new MetaBlock(Blocks.NETHER_BRICK_FENCE.getDefaultState());
		case WEB:
			return new MetaBlock(Blocks.COBWEB.getDefaultState());
		case PUMPKIN_LIT:
			return new MetaBlock(Blocks.PUMPKIN.getDefaultState());
		case VINE:
			return new MetaBlock(Blocks.VINE.getDefaultState());
		case PURPUR_BLOCK:
			return new MetaBlock(Blocks.PURPUR_BLOCK.getDefaultState());
		case PURPUR_PILLAR:
			return new MetaBlock(Blocks.PURPUR_PILLAR.getDefaultState());
		case PURPUR_STAIR:
			return new MetaBlock(Blocks.PURPUR_STAIRS.getDefaultState());
		case PURPUR_DOUBLE_SLAB:
			return new MetaBlock(Blocks.PURPUR_SLAB.getDefaultState());
		case PURPUR_SLAB:
			return new MetaBlock(Blocks.PURPUR_SLAB.getDefaultState());
		case ENDER_BRICK:
			return new MetaBlock(Blocks.END_STONE_BRICKS.getDefaultState());
		case MAGMA:
			return new MetaBlock(Blocks.MAGMA_BLOCK.getDefaultState());
		case RED_NETHERBRICK:
			return new MetaBlock(Blocks.RED_NETHER_BRICKS.getDefaultState());
		case NETHER_WART_BLOCK:
			return new MetaBlock(Blocks.NETHER_WART_BLOCK.getDefaultState());
		case BONE_BLOCK:
			block = new MetaBlock(Blocks.BONE_BLOCK.getDefaultState());
			return block;
		default:
			return new MetaBlock(Blocks.AIR.getDefaultState());
		}
	}

	public static ItemStack getItem(BlockType type) {

		MetaBlock block = BlockType.get(type);
		Block b = block.getBlock();
		Item i = Item.getItemFromBlock(b);
		ItemStack item = new ItemStack(i);

		return item;
	}
}
