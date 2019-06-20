package greymerk.roguelike.monster.profiles;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Random;

import greymerk.roguelike.monster.IEntity;
import greymerk.roguelike.monster.IMonsterProfile;
import greymerk.roguelike.monster.MonsterProfile;
import greymerk.roguelike.treasure.loot.Quality;
import greymerk.roguelike.treasure.loot.Slot;
import greymerk.roguelike.treasure.loot.provider.ItemArmour;
import greymerk.roguelike.treasure.loot.provider.ItemNovelty;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ProfileAshlea implements IMonsterProfile {

	@Override
	public void addEquipment(World world, Random rand, int level, IEntity mob) {
		
		mob.setChild(true);
		
		MonsterProfile.get(MonsterProfile.VILLAGER).addEquipment(world, rand, level, mob);
		
		ItemStack weapon = ItemNovelty.getItem(ItemNovelty.ASHLEA);
		mob.setSlot(EquipmentSlotType.MAINHAND, weapon);
		
		for(EquipmentSlotType slot : new EquipmentSlotType[]{
				EquipmentSlotType.HEAD,
				EquipmentSlotType.CHEST,
				EquipmentSlotType.LEGS,
				EquipmentSlotType.FEET
				}){
			ItemStack item = ItemArmour.get(rand, Slot.getSlot(slot), Quality.WOOD);
			ItemArmour.dyeArmor(item, 255, 100, 255);
			mob.setSlot(slot, item);
		}
	}
}
