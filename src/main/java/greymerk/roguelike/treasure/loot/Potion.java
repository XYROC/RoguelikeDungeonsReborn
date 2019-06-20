package greymerk.roguelike.treasure.loot;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Random;

import com.google.gson.JsonObject;

import greymerk.roguelike.util.IWeighted;
import greymerk.roguelike.util.WeightedChoice;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;

public enum Potion {

	HEALING, HARM, REGEN, POISON, STRENGTH, WEAKNESS, SLOWNESS, SWIFTNESS, FIRERESIST;

	public static ItemStack getRandom(Random rand) {
		Potion type = Potion.values()[rand.nextInt(Potion.values().length)];
		return getSpecific(rand, type);
	}

	public static ItemStack getSpecific(Random rand, Potion effect) {
		return getSpecific(PotionForm.REGULAR, effect, rand.nextBoolean(), rand.nextBoolean());
	}

	public static ItemStack getSpecific(Random rand, PotionForm type, Potion effect) {
		return getSpecific(type, effect, rand.nextBoolean(), rand.nextBoolean());
	}

	public static IWeighted<ItemStack> get(JsonObject data, int weight) throws Exception {
		if (!data.has("name"))
			throw new Exception("Potion missing name field");
		String nameString = data.get("name").getAsString();
		net.minecraft.potion.Potion type = net.minecraft.potion.Potion.getPotionTypeForName(nameString);
		ItemStack item = !data.has("form") ? new ItemStack(Items.POTION)
				: data.get("form").getAsString().toLowerCase().equals("splash") ? new ItemStack(Items.SPLASH_POTION)
						: data.get("form").getAsString().toLowerCase().equals("lingering")
								? new ItemStack(Items.LINGERING_POTION)
								: new ItemStack(Items.POTION);
		return new WeightedChoice<ItemStack>(PotionUtils.addPotionToItemStack(item, type), weight);
	}

	public static ItemStack getSpecific(PotionForm type, Potion effect, boolean upgrade, boolean extend) {

		ItemStack potion;

		switch (type) {
		case REGULAR:
			potion = new ItemStack(Items.POTION);
			break;
		case SPLASH:
			potion = new ItemStack(Items.SPLASH_POTION);
			break;
		case LINGERING:
			potion = new ItemStack(Items.LINGERING_POTION);
			break;
		default:
			potion = new ItemStack(Items.POTION);
			break;
		}

		net.minecraft.potion.Potion data = getEffect(effect, upgrade, extend);

		return PotionUtils.addPotionToItemStack(potion, data);
	}

	public static net.minecraft.potion.Potion getEffect(Potion effect, boolean upgrade, boolean extend) {

		if (effect == null)
			return Potions.AWKWARD;

		switch (effect) {
		case HEALING:
			return upgrade ? Potions.STRONG_HEALING : Potions.HEALING;
		case HARM:
			return upgrade ? Potions.STRONG_HARMING : Potions.HARMING;
		case REGEN:
			if (extend) {
				return Potions.LONG_REGENERATION;
			} else {
				return upgrade ? Potions.STRONG_REGENERATION : Potions.REGENERATION;
			}
		case POISON:
			if (extend) {
				return Potions.LONG_POISON;
			} else {
				return upgrade ? Potions.STRONG_POISON : Potions.POISON;
			}
		case STRENGTH:
			if (extend) {
				return Potions.LONG_STRENGTH;
			} else {
				return upgrade ? Potions.STRONG_STRENGTH : Potions.STRENGTH;
			}
		case WEAKNESS:
			if (extend) {
				return Potions.LONG_WEAKNESS;
			} else {
				return Potions.WEAKNESS;
			}
		case SLOWNESS:
			if (extend) {
				return Potions.LONG_SLOWNESS;
			} else {
				return Potions.SLOWNESS;
			}
		case SWIFTNESS:
			if (extend) {
				return Potions.LONG_SWIFTNESS;
			} else {
				return upgrade ? Potions.STRONG_SWIFTNESS : Potions.SWIFTNESS;
			}
		case FIRERESIST:
			if (extend) {
				return Potions.LONG_FIRE_RESISTANCE;
			} else {
				return Potions.FIRE_RESISTANCE;
			}
		default:
			return Potions.AWKWARD;
		}
	}
}
