package greymerk.roguelike.worldgen.spawners;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;
import greymerk.roguelike.worldgen.MetaBlock;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.spawner.AbstractSpawner;

public class Spawnable {

	private Spawner type;
	private List<SpawnPotential> potentials;

	public Spawnable(Spawner type) {
		this.potentials = new ArrayList<SpawnPotential>();
		this.type = type;
	}

	public Spawnable(JsonElement data) throws Exception {
		this.potentials = new ArrayList<SpawnPotential>();

		JsonArray arr = data.getAsJsonArray();
		for (JsonElement e : arr) {
			SpawnPotential potential = new SpawnPotential(e.getAsJsonObject());
			this.potentials.add(potential);
		}
	}

	public void generate(IWorldEditor editor, Random rand, Coord cursor, int level) {
		Coord pos = new Coord(cursor);
		editor.setBlock(pos, new MetaBlock(Blocks.SPAWNER.getDefaultState()), true, true);

		TileEntity tileentity = editor.getTileEntity(pos);
		if (!(tileentity instanceof MobSpawnerTileEntity))
			return;

		MobSpawnerTileEntity spawner = (MobSpawnerTileEntity) tileentity;
		AbstractSpawner spawnerLogic = spawner.getSpawnerBaseLogic();

		CompoundNBT nbt = new CompoundNBT();
		nbt.putInt("x", pos.getX());
		nbt.putInt("y", pos.getY());
		nbt.putInt("z", pos.getZ());

		nbt.put("SpawnPotentials", getSpawnPotentials(rand, level));

		spawnerLogic.read(nbt);
		spawnerLogic.tick();
		tileentity.markDirty();
	}

	private ListNBT getSpawnPotentials(Random rand, int level) {

		if (this.type != null) {
			SpawnPotential potential = new SpawnPotential(Spawner.getName(type));
			return potential.get(rand, level);
		}

		ListNBT potentials = new ListNBT();

		for (SpawnPotential potential : this.potentials) {
			CompoundNBT nbt = potential.get(level);
			potentials.add(nbt);
		}

		return potentials;
	}
}
