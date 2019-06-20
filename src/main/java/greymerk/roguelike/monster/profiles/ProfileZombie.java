package greymerk.roguelike.monster.profiles;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Random;

import greymerk.roguelike.monster.IEntity;
import greymerk.roguelike.monster.IMonsterProfile;
import greymerk.roguelike.monster.MonsterProfile;
import greymerk.roguelike.treasure.loot.Enchant;
import greymerk.roguelike.treasure.loot.Shield;
import greymerk.roguelike.treasure.loot.provider.ItemTool;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ProfileZombie implements IMonsterProfile {

	@Override
	public void addEquipment(World world, Random rand, int level, IEntity mob) {

		if (level == 4 && rand.nextInt(20) == 0) {
			MonsterProfile.get(MonsterProfile.PIGMAN).addEquipment(world, rand, level, mob);
			return;
		}

		if (level == 3 && rand.nextInt(100) == 0) {
			MonsterProfile.get(MonsterProfile.WITCH).addEquipment(world, rand, level, mob);
			return;
		}

		if (level == 2 && rand.nextInt(300) == 0) {
			MonsterProfile.get(MonsterProfile.EVOKER).addEquipment(world, rand, level, mob);
			return;
		}

		if (level == 1 && rand.nextInt(200) == 0) {
			MonsterProfile.get(MonsterProfile.JOHNNY).addEquipment(world, rand, level, mob);
			return;
		}

		if (rand.nextInt(100) == 0) {
			MonsterProfile.get(MonsterProfile.RLEAHY).addEquipment(world, rand, level, mob);
			return;
		}

		if (rand.nextInt(100) == 0) {
			MonsterProfile.get(MonsterProfile.ASHLEA).addEquipment(world, rand, level, mob);
			return;
		}

		if (rand.nextInt(40) == 0) {
			MonsterProfile.get(MonsterProfile.BABY).addEquipment(world, rand, level, mob);
			return;
		}

		if (level > 1 && rand.nextInt(20) == 0) {
			MonsterProfile.get(MonsterProfile.HUSK).addEquipment(world, rand, level, mob);
			return;
		}

		if (level < 3 && rand.nextInt(20) == 0) {
			MonsterProfile.get(MonsterProfile.VILLAGER).addEquipment(world, rand, level, mob);
			return;
		}

		ItemStack weapon = ItemTool.getRandom(rand, level, Enchant.canEnchant(world.getDifficulty(), rand, level));
		mob.setSlot(EquipmentSlotType.MAINHAND, weapon);
		mob.setSlot(EquipmentSlotType.OFFHAND, Shield.get(rand));
		MonsterProfile.get(MonsterProfile.TALLMOB).addEquipment(world, rand, level, mob);

	}

}
