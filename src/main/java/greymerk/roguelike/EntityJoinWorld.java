package greymerk.roguelike;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.util.Collection;

import greymerk.roguelike.monster.IEntity;
import greymerk.roguelike.monster.MetaEntity;
import greymerk.roguelike.monster.MonsterProfile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntityJoinWorld {

	@SubscribeEvent
	public void OnEntityJoinWorld(EntityJoinWorldEvent event) {

		World world = event.getWorld();
		if (world.isRemote)
			return;

		Entity entity = event.getEntity();

		if (!(entity instanceof MobEntity)) {
			return;
		}

		LivingEntity mob = (LivingEntity) entity;

		Collection<?> effects = mob.getActivePotionEffects();
		for (Object buff : effects) {
			EffectInstance instance = (EffectInstance) buff;
			if (Effect.getId(instance.getPotion()) == 4) {
				int level = instance.getAmplifier();
				IEntity metaEntity = new MetaEntity((Entity) mob);
				MonsterProfile.equip(world, world.rand, level, metaEntity);
				if (!entity.isAlive())
					event.setCanceled(true);
				return;
			}
		}
	}
}
