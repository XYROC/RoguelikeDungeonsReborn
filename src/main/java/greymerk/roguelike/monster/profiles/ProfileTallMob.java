package greymerk.roguelike.monster.profiles;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Random;

import greymerk.roguelike.monster.IEntity;
import greymerk.roguelike.monster.IMonsterProfile;
import greymerk.roguelike.treasure.loot.Enchant;
import greymerk.roguelike.treasure.loot.Loot;
import greymerk.roguelike.treasure.loot.Slot;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ProfileTallMob implements IMonsterProfile {

	@Override
	public void addEquipment(World world, Random rand, int level, IEntity mob) {
		for(EquipmentSlotType slot : new EquipmentSlotType[]{
				EquipmentSlotType.HEAD,
				EquipmentSlotType.CHEST,
				EquipmentSlotType.LEGS,
				EquipmentSlotType.FEET
				}){
			ItemStack item = Loot.getEquipmentBySlot(rand, Slot.getSlot(slot), level, Enchant.canEnchant(world.getDifficulty(), rand, level));
			mob.setSlot(slot, item);
		}

	}

}
