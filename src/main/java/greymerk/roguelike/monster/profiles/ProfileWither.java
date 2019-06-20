package greymerk.roguelike.monster.profiles;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Random;

import greymerk.roguelike.monster.IEntity;
import greymerk.roguelike.monster.IMonsterProfile;
import greymerk.roguelike.monster.MobType;
import greymerk.roguelike.monster.MonsterProfile;
import greymerk.roguelike.treasure.loot.Enchant;
import greymerk.roguelike.treasure.loot.provider.ItemWeapon;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.World;

public class ProfileWither implements IMonsterProfile {

	@Override
	public void addEquipment(World world, Random rand, int level, IEntity mob) {
		mob.setMobClass(MobType.WITHERSKELETON, false);
		mob.setSlot(EquipmentSlotType.MAINHAND, ItemWeapon.getSword(rand, level, Enchant.canEnchant(world.getDifficulty(), rand, level)));
		MonsterProfile.get(MonsterProfile.TALLMOB).addEquipment(world, rand, level, mob);
	}

}
