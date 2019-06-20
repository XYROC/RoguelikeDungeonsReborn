package greymerk.roguelike.treasure.loot;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;

public enum PotionEffect {

	SPEED(1), SLOWNESS(2), HASTE(3), FATIGUE(4), STRENGTH(5), HEALTH(6), DAMAGE(7), JUMP(8), NAUSIA(9), REGEN(10),
	RESISTANCE(11), FIRERESIST(12), WATERBREATH(13), INVISIBILITY(14), BLINDNESS(15), NIGHTVISION(16), HUNGER(17),
	WEAKNESS(18), POISON(19), WITHER(20), HEALTHBOOST(21), ABSORPTION(22), SATURATION(23), GLOWING(24), LEVITATION(25),
	LUCK(26), BAD_LUCK(27);

	public static int TICKS_PER_SECOND = 20;

	private int id;

	PotionEffect(int id) {
		this.id = id;
	}

	public static int getEffectID(PotionEffect type) {
		return type.id;
	}

	public static void addCustomEffect(ItemStack potion, PotionEffect type, int amplifier, int duration) {

		final String CUSTOM = "CustomPotionEffects";

		CompoundNBT tag = potion.getTag();
		if (tag == null) {
			tag = new CompoundNBT();
			potion.setTag(tag);
		}

		ListNBT effects;
		effects = tag.getList(CUSTOM, 10);
		if (effects == null) {
			effects = new ListNBT();
			tag.put(CUSTOM, effects);
		}

		CompoundNBT toAdd = new CompoundNBT();

		toAdd.putByte("Id", (byte) type.id);
		toAdd.putByte("Amplifier", (byte) (amplifier - 1));
		toAdd.putInt("Duration", duration * TICKS_PER_SECOND);
		toAdd.putBoolean("Ambient", true);

		effects.add(toAdd);
		tag.put(CUSTOM, effects);
		potion.setTag(tag);
	}
}
