package greymerk.roguelike.monster;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import java.util.Random;

import net.minecraft.world.World;

public interface IMonsterProfile {

	public void addEquipment(World world, Random rand, int level, IEntity mob);

}
