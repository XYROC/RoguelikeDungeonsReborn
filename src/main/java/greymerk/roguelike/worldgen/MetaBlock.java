package greymerk.roguelike.worldgen;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Random;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import greymerk.roguelike.worldgen.shapes.IShape;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class MetaBlock implements IBlockFactory {

	private BlockState state;
	private int flag;

	public MetaBlock(BlockState stateIn) {
		this.flag = 2;
		setState(stateIn);
	}

	@SuppressWarnings("deprecation")
	public MetaBlock(JsonElement e) throws Exception {
		JsonObject json = (JsonObject) e;
		String name = json.get("name").getAsString();
		ResourceLocation location = new ResourceLocation(name);
		if (!ForgeRegistries.BLOCKS.containsKey(location)) {
			throw new Exception("No such block: " + name);
		}
		Block block = ForgeRegistries.BLOCKS.getValue(location);
		int meta = json.has("meta") ? json.get("meta").getAsInt() : 0;
		this.setState(block.getDefaultState()); // TODO state from meta
		flag = json.has("flag") ? json.get("flag").getAsInt() : 2;
	}

	public void setState(BlockState state) {
		this.state = state;
	}

	public boolean set(IWorldEditor editor, Coord pos) {
		return editor.setBlock(pos, this, true, true);
	}
	
	public Material getMaterial() {
		return state.getMaterial();
	}
	
	@Override
	public boolean set(IWorldEditor editor, Random rand, Coord pos, boolean fillAir, boolean replaceSolid) {
		return editor.setBlock(pos, this, fillAir, replaceSolid);
	}

	public Block getBlock() {
		return this.state.getBlock();
	}


	public int getFlag() {
		return this.flag;
	}

	@Override
	public String toString() {
		return this.state.getBlock().getNameTextComponent().getString();
	}


	@Override
	public boolean equals(Object other) {
		if (other == this)
			return true;
		if (other == null)
			return false;
		if (!(other instanceof MetaBlock))
			return false;

		MetaBlock otherBlock = (MetaBlock) other;
		return this.getState().equals(otherBlock.getState());
	}

	public BlockState getState() {
		return this.state;
	}

	@Override
	public boolean set(IWorldEditor editor, Random rand, Coord pos) {
		return set(editor, rand, pos, true, true);
	}

	@Override
	public void fill(IWorldEditor editor, Random rand, IShape shape) {
		shape.fill(editor, rand, this, true, true);
	}

	@Override
	public void fill(IWorldEditor editor, Random rand, IShape shape, boolean fillAir, boolean replaceSolid) {
		shape.fill(editor, rand, this, fillAir, replaceSolid);
	}
}
