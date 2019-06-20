package greymerk.roguelike.treasure;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Objects;
import java.util.Random;

import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.TrappedChestBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.ChestType;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.util.ResourceLocation;

public class TreasureChest implements ITreasureChest {

	protected Inventory inventory;
	protected Treasure type;
	protected Random rand;
	private long seed;
	private ChestTileEntity chest;
	private int level;

	public TreasureChest(Treasure type) {
		this.type = type;
		this.level = 0;
	}

	public ITreasureChest generate(IWorldEditor editor, Random rand, Coord pos, int level, boolean trapped)
			throws ChestPlacementException {

		this.rand = rand;
		this.level = level;

		MetaBlock chestType = new MetaBlock(trapped ? Blocks.TRAPPED_CHEST.getDefaultState() : Blocks.CHEST.getDefaultState());

		boolean success = chestType.set(editor, pos);

		if (!success) {
			throw new ChestPlacementException("Failed to place chest in world");
		}

		this.chest = (ChestTileEntity) editor.getTileEntity(pos);
		this.inventory = new Inventory(rand, chest);
		this.seed = (long) Objects.hash(pos.hashCode(), editor.getSeed());

		editor.addChest(this);
		return this;
	}

	@Override
	public boolean setSlot(int slot, ItemStack item) {
		return this.inventory.setInventorySlot(slot, item);
	}

	@Override
	public boolean setRandomEmptySlot(ItemStack item) {
		return this.inventory.setRandomEmptySlot(item);
	}

	@Override
	public boolean isEmptySlot(int slot) {
		return this.inventory.isEmptySlot(slot);
	}

	@Override
	public Treasure getType() {
		return this.type;
	}

	@Override
	public int getSize() {
		return this.inventory.getInventorySize();
	}

	@Override
	public int getLevel() {
		if (level < 0)
			return 0;
		if (level > 4)
			return 4;
		return this.level;
	}

	@Override
	public void setLootTable(ResourceLocation table) {
		this.chest.setLootTable(table, seed);
	}
}
