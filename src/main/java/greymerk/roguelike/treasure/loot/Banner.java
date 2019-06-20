package greymerk.roguelike.treasure.loot;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Random;

import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.tileentity.BannerPattern;

public class Banner {

	public static ItemStack get(Random rand) {

		ItemStack banner = new ItemStack(Items.WHITE_BANNER);
		int n = rand.nextInt(8) + 1;
		for (int i = 0; i < n; ++i) {
			addPattern(banner, rand);
		}

		return banner;
	}

	public static ItemStack addPattern(ItemStack banner, Random rand) {
		BannerPattern pattern = BannerPattern.values()[rand.nextInt(BannerPattern.values().length)];
		DyeColor color = DyeColor.values()[rand.nextInt(DyeColor.values().length)];

		return addPattern(banner, pattern, color);
	}

	public static ItemStack addPattern(ItemStack banner, BannerPattern pattern, DyeColor color) {
		CompoundNBT nbt = banner.getTag();
		if (nbt == null) {
			banner.setTag(new CompoundNBT());
			nbt = banner.getTag();
		}

		CompoundNBT tag;

		if (nbt.contains("BlockEntityTag")) {
			tag = (CompoundNBT) nbt.get("BlockEntityTag");
		} else {
			tag = new CompoundNBT();
			nbt.put("BlockEntityTag", tag);
		}

		ListNBT patterns;

		if (tag.contains("Patterns")) {
			patterns = tag.getList("Patterns", 10);
		} else {
			patterns = new ListNBT();
			tag.put("Patterns", patterns);
		}

		CompoundNBT toAdd = new CompoundNBT();
		// TODO Color NBT writing ?
		toAdd.putInt("Color", color.getId());
		toAdd.putString("Pattern", pattern.getHashname());
		patterns.add(toAdd);

		return banner;
	}

}
