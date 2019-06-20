package greymerk.roguelike.monster;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.EvokerEntity;
import net.minecraft.entity.monster.HuskEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.StrayEntity;
import net.minecraft.entity.monster.VindicatorEntity;
import net.minecraft.entity.monster.WitchEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.world.World;

public enum MobType {

	ZOMBIE, ZOMBIEVILLAGER, HUSK, SKELETON, STRAY, SPIDER, CREEPER, WITHERSKELETON, PIGZOMBIE, EVOKER, VINDICATOR,
	WITCH;

	public static Entity getEntity(World world, MobType type) {
		switch (type) {
		case ZOMBIE:
			return new ZombieEntity(world);
		case ZOMBIEVILLAGER:
			return new ZombieVillagerEntity(EntityType.ZOMBIE_VILLAGER, world);
		case HUSK:
			return new HuskEntity(EntityType.HUSK, world);
		case SKELETON:
			return new SkeletonEntity(EntityType.SKELETON, world);
		case STRAY:
			return new StrayEntity(EntityType.STRAY, world);
		case SPIDER:
			return new SpiderEntity(EntityType.SPIDER, world);
		case CREEPER:
			return new CreeperEntity(EntityType.CREEPER, world);
		case WITHERSKELETON:
			return new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world);
		case PIGZOMBIE:
			return new ZombiePigmanEntity(EntityType.ZOMBIE_PIGMAN, world);
		case EVOKER:
			return new EvokerEntity(EntityType.EVOKER, world);
		case VINDICATOR:
			return new VindicatorEntity(EntityType.VINDICATOR, world);
		case WITCH:
			return new WitchEntity(EntityType.WITCH, world);

		default:
			return new ZombieEntity(world);
		}
	}
}
