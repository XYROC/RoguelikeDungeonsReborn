package greymerk.roguelike.monster.profiles;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Random;

import greymerk.roguelike.monster.IEntity;
import greymerk.roguelike.monster.IMonsterProfile;
import greymerk.roguelike.monster.MobType;
import greymerk.roguelike.treasure.loot.Enchant;
import greymerk.roguelike.treasure.loot.Potion;
import greymerk.roguelike.treasure.loot.Quality;
import greymerk.roguelike.treasure.loot.Slot;
import greymerk.roguelike.treasure.loot.TippedArrow;
import greymerk.roguelike.treasure.loot.provider.ItemArmour;
import greymerk.roguelike.treasure.loot.provider.ItemWeapon;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ProfileMagicArcher implements IMonsterProfile {

	@Override
	public void addEquipment(World world, Random rand, int level, IEntity mob) {

		mob.setMobClass(MobType.STRAY, false);

		mob.setSlot(EquipmentSlotType.OFFHAND, TippedArrow.get(Potion.HARM));
		mob.setSlot(EquipmentSlotType.MAINHAND,
				ItemWeapon.getBow(rand, level, Enchant.canEnchant(world.getDifficulty(), rand, level)));

		for (EquipmentSlotType slot : new EquipmentSlotType[] { EquipmentSlotType.HEAD, EquipmentSlotType.CHEST,
				EquipmentSlotType.LEGS, EquipmentSlotType.FEET }) {
			ItemStack item = ItemArmour.get(rand, Slot.getSlot(slot), Quality.WOOD);
			Enchant.enchantItem(rand, item, 20);
			ItemArmour.dyeArmor(item, 51, 0, 102);
			mob.setSlot(slot, item);
		}
	}

}
