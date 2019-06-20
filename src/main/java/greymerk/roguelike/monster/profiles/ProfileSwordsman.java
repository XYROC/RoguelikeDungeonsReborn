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
import greymerk.roguelike.treasure.loot.provider.ItemNovelty;
import greymerk.roguelike.treasure.loot.provider.ItemWeapon;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ProfileSwordsman implements IMonsterProfile {

	@Override
	public void addEquipment(World world, Random rand, int level, IEntity mob) {
		ItemStack weapon = rand.nextInt(20) == 0
				? ItemNovelty.getItem(ItemNovelty.VALANDRAH)
				: ItemWeapon.getSword(rand, level, Enchant.canEnchant(world.getDifficulty(), rand, level));
		
		mob.setSlot(EquipmentSlotType.MAINHAND, weapon);
		mob.setSlot(EquipmentSlotType.OFFHAND, Shield.get(rand));
		MonsterProfile.get(MonsterProfile.TALLMOB).addEquipment(world, rand, level, mob);
	}

}
