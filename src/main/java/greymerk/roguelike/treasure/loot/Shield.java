package greymerk.roguelike.treasure.loot;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;

public class Shield {

	public static ItemStack get(Random rand) {

		ItemStack banner = Banner.get(rand);

		ItemStack shield = new ItemStack(() -> Items.SHIELD, 1);

		applyBanner(banner, shield);

		return shield;
	}

	public static void applyBanner(ItemStack banner, ItemStack shield) {

		CompoundNBT bannerNBT = banner.getChildTag("BlockEntityTag");
		CompoundNBT shieldNBT = bannerNBT == null ? new CompoundNBT() : bannerNBT.copy();
		shieldNBT.putInt("Base", banner.getDamage()/* TODO banner metadata banner.getMetadata() */ & 15);
		// BannerItem
		shield.setTagInfo("BlockEntityTag", shieldNBT);

	}

}
