package greymerk.roguelike.monster.profiles;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Random;

import greymerk.roguelike.monster.IEntity;
import greymerk.roguelike.monster.IMonsterProfile;
import greymerk.roguelike.monster.MobType;
import greymerk.roguelike.treasure.loot.Equipment;
import greymerk.roguelike.treasure.loot.provider.ItemSpecialty;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.World;

public class ProfileVindicator implements IMonsterProfile {

	@Override
	public void addEquipment(World world, Random rand, int level, IEntity mob) {
		mob.setMobClass(MobType.VINDICATOR, true);
		mob.setSlot(EquipmentSlotType.MAINHAND, ItemSpecialty.getRandomItem(Equipment.AXE, rand, level));
	}

}
