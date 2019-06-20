package greymerk.roguelike.worldgen;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import greymerk.roguelike.treasure.ITreasureChest;
import greymerk.roguelike.treasure.TreasureManager;
import greymerk.roguelike.worldgen.blocks.BlockType;
import greymerk.roguelike.worldgen.shapes.RectSolid;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ServerChunkProvider;

public class WorldEditor implements IWorldEditor {

	World world;
	private Map<Block, Integer> stats;
	private TreasureManager chests;
	private static List<Material> invalid;
	{
		invalid = new ArrayList<Material>();
		invalid.add(Material.WOOD);
		invalid.add(Material.WATER);
		invalid.add(Material.CACTUS);
		invalid.add(Material.SNOW);
		invalid.add(Material.EARTH);
		invalid.add(Material.GOURD);
		invalid.add(Material.LEAVES);
		invalid.add(Material.PLANTS);
	};

	public WorldEditor(World world) {
		this.world = world;
		stats = new HashMap<Block, Integer>();
		this.chests = new TreasureManager();
	}

	private boolean setBlock(Coord pos, MetaBlock block, int flags, boolean fillAir, boolean replaceSolid) {

		MetaBlock currentBlock = new MetaBlock(getBlock(pos));

		if (currentBlock.getBlock() == Blocks.CHEST)
			return false;
		if (currentBlock.getBlock() == Blocks.TRAPPED_CHEST)
			return false;
		if (currentBlock.getBlock() == Blocks.SPAWNER)
			return false;

		// boolean isAir = world.isAirBlock(pos.getBlockPos());
		boolean isAir = currentBlock.getBlock() == Blocks.AIR;

		if (!fillAir && isAir)
			return false;
		if (!replaceSolid && !isAir)
			return false;

		try {
			world.setBlockState(pos.getBlockPos(), block.getState(), flags);
		} catch (NullPointerException npe) {
			// ignore it.
		}

		Block type = block.getBlock();
		Integer count = stats.get(type);
		if (count == null) {
			stats.put(type, 1);
		} else {
			stats.put(type, count + 1);
		}

		return true;

	}

	@Override
	public boolean setBlock(Coord pos, MetaBlock block, boolean fillAir, boolean replaceSolid) {
		return this.setBlock(pos, block, block.getFlag(), fillAir, replaceSolid);
	}

	@Override
	public boolean isAirBlock(Coord pos) {
		return world.isAirBlock(pos.getBlockPos());
	}

	@Override
	public long getSeed() {
		return this.world.getSeed();
	}

	@Override
	public Random getSeededRandom(int a, int b, int c) {
		return world.rand;
	}

	@Override
	public void spiralStairStep(Random rand, Coord origin, IStair stair, IBlockFactory fill) {

		MetaBlock air = BlockType.get(BlockType.AIR);
		Coord cursor;
		Coord start;
		Coord end;

		start = new Coord(origin);
		start.add(new Coord(-1, 0, -1));
		end = new Coord(origin);
		end.add(new Coord(1, 0, 1));

		RectSolid.fill(this, rand, start, end, air);
		fill.set(this, rand, origin);

		Cardinal dir = Cardinal.directions[origin.getY() % 4];
		cursor = new Coord(origin);
		cursor.add(dir);
		stair.setOrientation(Cardinal.left(dir), false).set(this, cursor);
		cursor.add(Cardinal.right(dir));
		stair.setOrientation(Cardinal.right(dir), true).set(this, cursor);
		cursor.add(Cardinal.reverse(dir));
		stair.setOrientation(Cardinal.reverse(dir), true).set(this, cursor);
	}

	@Override
	public void fillDown(Random rand, Coord origin, IBlockFactory blocks) {

		Coord cursor = new Coord(origin);

		while (!getBlock(cursor).isSolid() && cursor.getY() > 1) { // TODO use isOpaqueCube()
			blocks.set(this, rand, cursor);
			cursor.add(Cardinal.DOWN);
		}
	}

	@Override
	public BlockState getBlock(Coord pos) {
		return world.getBlockState(pos.getBlockPos());
	}

	@Override
	public TileEntity getTileEntity(Coord pos) {
		return world.getTileEntity(pos.getBlockPos());
	}

	@Override
	public boolean validGroundBlock(Coord pos) {
		if (isAirBlock(pos))
			return false;
		BlockState block = this.getBlock(pos);
		return !invalid.contains(block.getMaterial());
	}

	@Override
	public int getStat(Block type) {
		if (!this.stats.containsKey(type))
			return 0;
		return this.stats.get(type);
	}

	@Override
	public Map<Block, Integer> getStats() {
		return this.stats;
	}

	@Override
	public void addChest(ITreasureChest toAdd) {
		this.chests.add(toAdd);
	}

	@Override
	public TreasureManager getTreasure() {
		return this.chests;
	}

	@Override
	public boolean canPlace(MetaBlock block, Coord pos, Cardinal dir) {
		if (!this.isAirBlock(pos))
			return false;
		return block.getMaterial().isReplaceable();
		// return block.getBlock().canPlaceBlockOnSide(world, pos.getBlockPos(),
		// Cardinal.facing(dir)); TODO facing
	}

	@Override
	public IPositionInfo getInfo(Coord pos) {
		return new PositionInfo(this.world, pos);
	}

	@Override
	public Coord findNearestStructure(VanillaStructure type, Coord pos) {

		// ServerChunkProvider chunkProvider = ((ServerWorld) world).getChunkProvider();
		String structureName = VanillaStructure.getName(type);

		BlockPos structurebp = null;

		try {
			structurebp = world.findNearestStructure(structureName, new BlockPos(pos.getX(), pos.getY(), pos.getZ()), 1024, false);
			// structurebp = chunkProvider.getNearestStructurePos(world, structureName,
			// pos.getBlockPos(), false);
		} catch (NullPointerException e) {
			// happens for some reason if structure type is disabled in Chunk Generator
			// Settings
		}

		if (structurebp == null)
			return null;

		return new Coord(structurebp);
	}

	@Override
	public String toString() {
		String toReturn = "";

		for (Map.Entry<Block, Integer> pair : stats.entrySet()) {
			toReturn += pair.getKey().getNameTextComponent().getString() + ": " + pair.getValue() + "\n";
		}

		return toReturn;
	}
}
