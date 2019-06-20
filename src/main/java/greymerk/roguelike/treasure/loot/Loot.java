package greymerk.roguelike.treasure.loot;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Random;

import com.google.gson.JsonObject;

import greymerk.roguelike.treasure.loot.provider.ItemArmour;
import greymerk.roguelike.treasure.loot.provider.ItemBlock;
import greymerk.roguelike.treasure.loot.provider.ItemBrewing;
import greymerk.roguelike.treasure.loot.provider.ItemEnchBonus;
import greymerk.roguelike.treasure.loot.provider.ItemEnchBook;
import greymerk.roguelike.treasure.loot.provider.ItemFood;
import greymerk.roguelike.treasure.loot.provider.ItemJunk;
import greymerk.roguelike.treasure.loot.provider.ItemMixture;
import greymerk.roguelike.treasure.loot.provider.ItemNovelty;
import greymerk.roguelike.treasure.loot.provider.ItemOre;
import greymerk.roguelike.treasure.loot.provider.ItemPotion;
import greymerk.roguelike.treasure.loot.provider.ItemRecord;
import greymerk.roguelike.treasure.loot.provider.ItemSmithy;
import greymerk.roguelike.treasure.loot.provider.ItemSpecialty;
import greymerk.roguelike.treasure.loot.provider.ItemSupply;
import greymerk.roguelike.treasure.loot.provider.ItemTool;
import greymerk.roguelike.treasure.loot.provider.ItemWeapon;
import greymerk.roguelike.util.IWeighted;
import greymerk.roguelike.util.TextFormat;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.util.text.StringTextComponent;

public enum Loot {

	WEAPON, ARMOUR, BLOCK, JUNK, ORE, TOOL, POTION, FOOD, ENCHANTBOOK, ENCHANTBONUS, SUPPLY, MUSIC, SMITHY, SPECIAL,
	REWARD, BREWING;

	public static ILoot getLoot() {

		LootProvider loot = new LootProvider();
		for (int i = 0; i < 5; ++i) {
			loot.put(i, new LootSettings(i));
		}

		return loot;
	}

	public static IWeighted<ItemStack> get(JsonObject data, int weight) throws Exception {

		if (!data.has("type"))
			return new WeightedRandomLoot(data, weight);

		String type = data.get("type").getAsString().toLowerCase();

		switch (type) {
		case "potion":
			return Potion.get(data, weight);
		case "mixture":
			return new ItemMixture(data, weight);
		case "weapon":
			return new ItemWeapon(data, weight);
		case "specialty":
			return new ItemSpecialty(data, weight);
		case "novelty":
			return ItemNovelty.get(data, weight);
		case "tool":
			return new ItemTool(data, weight);
		case "armour":
			return new ItemArmour(data, weight);
		case "enchanted_book":
			return new ItemEnchBook(data, weight);
		default:
			throw new Exception("No such loot type as: " + type);
		}
	}

	public static IWeighted<ItemStack> getProvider(Loot type, int level) {
		switch (type) {
		case WEAPON:
			return new ItemWeapon(0, level);
		case ARMOUR:
			return new ItemArmour(0, level);
		case BLOCK:
			return new ItemBlock(0, level);
		case JUNK:
			return new ItemJunk(0, level);
		case ORE:
			return new ItemOre(0, level);
		case TOOL:
			return new ItemTool(0, level);
		case POTION:
			return new ItemPotion(0, level);
		case BREWING:
			return new ItemBrewing(0, level);
		case FOOD:
			return new ItemFood(0, level);
		case ENCHANTBOOK:
			return new ItemEnchBook(0, level);
		case ENCHANTBONUS:
			return new ItemEnchBonus(0, level);
		case SUPPLY:
			return new ItemSupply(0, level);
		case MUSIC:
			return new ItemRecord(0, level);
		case SMITHY:
			return new ItemSmithy(0, level);
		case SPECIAL:
			return new ItemSpecialty(0, level);
		case REWARD:
		}

		return new WeightedRandomLoot(Items.STICK, 0, 1);
	}

	public static ItemStack getEquipmentBySlot(Random rand, EquipmentSlotType slot, int level, boolean enchant) {
		if (slot == EquipmentSlotType.MAINHAND) {
			return ItemWeapon.getRandom(rand, level, enchant);
		}

		return ItemArmour.getRandom(rand, level, Slot.getSlot(slot), enchant);
	}

	public static ItemStack getEquipmentBySlot(Random rand, Slot slot, int level, boolean enchant) {

		if (slot == Slot.WEAPON) {
			return ItemWeapon.getRandom(rand, level, enchant);
		}

		return ItemArmour.getRandom(rand, level, slot, enchant);
	}

	public static void setItemLore(ItemStack item, String loreText) {

		CompoundNBT tag = item.getTag();

		if (tag == null) {
			tag = new CompoundNBT();
			item.setTag(tag);
		}

		if (!tag.contains("display")) {
			tag.put("display", new CompoundNBT());
		}

		CompoundNBT display = (CompoundNBT) tag.get("display");

		if (!(display.contains("Lore"))) {
			display.put("Lore", new ListNBT());
		}

		ListNBT lore = display.getList("Lore", 0);

		StringNBT toAdd = new StringNBT(loreText);

		lore.add(toAdd);

		display.put("Lore", lore);
	}

	public static void setItemLore(ItemStack item, String loreText, TextFormat option) {
		setItemLore(item, TextFormat.apply(loreText, option));
	}

	public static void setItemName(ItemStack item, String name, TextFormat option) {

		if (option == null) {
			item.setDisplayName(new StringTextComponent(name));
			return;
		}

		item.setDisplayName(new StringTextComponent(TextFormat.apply(name, option)));
	}

	public static void setItemName(ItemStack item, String name) {
		setItemName(item, name, null);
	}
}
