package greymerk.roguelike.treasure.loot;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Random;

import greymerk.roguelike.util.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.IntArrayNBT;
import net.minecraft.nbt.ListNBT;

public class Firework {

	public static ItemStack get(Random rand, int stackSize) {
		ItemStack rocket = new ItemStack(Items.FIREWORK_ROCKET, stackSize);

		CompoundNBT tag = new CompoundNBT();
		CompoundNBT fireworks = new CompoundNBT();

		fireworks.putByte("Flight", (byte) (rand.nextInt(3) + 1));

		ListNBT explosion = new ListNBT();

		CompoundNBT properties = new CompoundNBT();
		properties.putByte("Flicker", (byte) (rand.nextBoolean() ? 1 : 0));
		properties.putByte("Trail", (byte) (rand.nextBoolean() ? 1 : 0));
		properties.putByte("Type", (byte) (rand.nextInt(5)));

		int size = rand.nextInt(4) + 1;
		int[] colorArr = new int[size];
		for (int i = 0; i < size; ++i) {
			colorArr[i] = DyeColor.HSLToColor(rand.nextFloat(), (float) 1.0, (float) 0.5);
		}

		IntArrayNBT colors = new IntArrayNBT(colorArr);
		properties.put("Colors", colors);

		explosion.add(properties);
		fireworks.put("Explosions", explosion);
		tag.put("Fireworks", fireworks);

		rocket.setTag(tag);

		return rocket;
	}
}
