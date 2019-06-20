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
import greymerk.roguelike.treasure.loot.TippedArrow;
import greymerk.roguelike.treasure.loot.provider.ItemWeapon;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.World;

public class ProfileArcher implements IMonsterProfile {

	@Override
	public void addEquipment(World world, Random rand, int level, IEntity mob) {

		if (Enchant.canEnchant(world.getDifficulty(), rand, level) && rand.nextInt(10) == 0) {
			mob.setSlot(EquipmentSlotType.OFFHAND, TippedArrow.getHarmful(rand, 1));
		}

		mob.setSlot(EquipmentSlotType.MAINHAND,
				ItemWeapon.getBow(rand, level, Enchant.canEnchant(world.getDifficulty(), rand, level)));
		MonsterProfile.get(MonsterProfile.TALLMOB).addEquipment(world, rand, level, mob);
	}

}
