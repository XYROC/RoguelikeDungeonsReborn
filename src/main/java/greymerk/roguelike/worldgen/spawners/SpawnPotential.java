package greymerk.roguelike.worldgen.spawners;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Random;

import com.google.gson.JsonObject;

import greymerk.roguelike.config.RogueConfig;
import greymerk.roguelike.treasure.loot.Equipment;
import greymerk.roguelike.treasure.loot.Quality;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.ListNBT;

public class SpawnPotential {

	String name;
	int weight;
	boolean equip;
	CompoundNBT nbt;

	public SpawnPotential(String name) {
		this(name, 1);
	}

	public SpawnPotential(String name, int weight) {
		this(name, true, weight, null);
	}

	public SpawnPotential(String name, boolean equip, int weight) {
		this(name, equip, weight, null);
	}

	public SpawnPotential(String name, boolean equip, int weight, CompoundNBT nbt) {
		this.name = name;
		this.equip = equip;
		this.weight = weight;
		this.nbt = nbt;
	}

	public SpawnPotential(JsonObject entry) throws Exception {
		this.weight = entry.has("weight") ? entry.get("weight").getAsInt() : 1;
		if (!entry.has("name")) {
			throw new Exception("Spawn potential missing name");
		}

		this.name = entry.get("name").getAsString();
		this.equip = entry.has("equip") ? entry.get("equip").getAsBoolean() : false;

		if (entry.has("nbt")) {
			String metadata = entry.get("nbt").getAsString();
			this.nbt = JsonToNBT.getTagFromJson(metadata);
		}
	}

	public CompoundNBT get(int level) {
		CompoundNBT nbt = this.nbt == null ? new CompoundNBT() : this.nbt.copy();
		return getPotential(getRoguelike(level, this.name, nbt));
	}

	public ListNBT get(Random rand, int level) {

		ListNBT potentials = new ListNBT();

		if (name.equals(Spawner.getName(Spawner.ZOMBIE))) {
			for (int i = 0; i < 24; ++i) {
				CompoundNBT mob = new CompoundNBT();
				mob = getRoguelike(level, this.name, mob);

				Equipment tool;
				switch (rand.nextInt(3)) {
				case 0:
					tool = Equipment.SHOVEL;
					break;
				case 1:
					tool = Equipment.AXE;
					break;
				case 2:
					tool = Equipment.PICK;
					break;
				default:
					tool = Equipment.PICK;
					break;
				}

				mob = equipHands(mob, Equipment.getName(tool, Quality.getToolQuality(rand, level)), "minecraft:shield");
				mob = equipArmour(mob, rand, level);

				potentials.add(getPotential(mob));
			}

			return potentials;
		}

		if (name.equals(Spawner.getName(Spawner.SKELETON))) {
			for (int i = 0; i < 12; ++i) {
				CompoundNBT mob = new CompoundNBT();
				mob = getRoguelike(level, this.name, mob);
				mob = equipHands(mob, "minecraft:bow", null);
				mob = equipArmour(mob, rand, level);
				potentials.add(getPotential(mob));
			}

			return potentials;
		}

		potentials.add(getPotential(getRoguelike(level, this.name, new CompoundNBT())));
		return potentials;
	}

	private CompoundNBT getPotential(CompoundNBT mob) {
		CompoundNBT potential = new CompoundNBT();
		potential.put("Entity", mob);
		potential.putInt("Weight", this.weight);
		return potential;
	}

	private CompoundNBT equipHands(CompoundNBT mob, String weapon, String offhand) {
		ListNBT hands = new ListNBT();
		hands.add(getItem(weapon));
		hands.add(getItem(offhand));
		mob.put("HandItems", hands);

		return mob;
	}

	private CompoundNBT equipArmour(CompoundNBT mob, Random rand, int level) {

		ListNBT armour = new ListNBT();
		armour.add(getItem(Equipment.getName(Equipment.FEET, Quality.getArmourQuality(rand, level))));
		armour.add(getItem(Equipment.getName(Equipment.LEGS, Quality.getArmourQuality(rand, level))));
		armour.add(getItem(Equipment.getName(Equipment.CHEST, Quality.getArmourQuality(rand, level))));
		armour.add(getItem(Equipment.getName(Equipment.HELMET, Quality.getArmourQuality(rand, level))));
		mob.put("ArmorItems", armour);

		return mob;
	}

	private CompoundNBT getItem(String itemName) {
		CompoundNBT item = new CompoundNBT();
		if (itemName == null)
			return item;
		item.putString("id", itemName);
		item.putInt("Count", 1);
		return item;
	}

	private CompoundNBT getRoguelike(int level, String type, CompoundNBT tag) {

		tag.putString("id", type);

		if (!(RogueConfig.getBoolean(RogueConfig.ROGUESPAWNERS) && this.equip))
			return tag;

		ListNBT activeEffects = new ListNBT();
		tag.put("ActiveEffects", activeEffects);

		CompoundNBT buff = new CompoundNBT();
		activeEffects.add(buff);

		buff.putByte("Id", (byte) 4);
		buff.putByte("Amplifier", (byte) level);
		buff.putInt("Duration", 10);
		buff.putByte("Ambient", (byte) 0);

		return tag;
	}

}
