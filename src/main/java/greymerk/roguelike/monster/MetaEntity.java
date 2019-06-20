package greymerk.roguelike.monster;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.StringTextComponent;

public class MetaEntity implements IEntity {

	private Entity mob;

	public MetaEntity(Entity mob) {
		this.mob = mob;
	}

	@Override
	public void setSlot(EquipmentSlotType slot, ItemStack item) {
		mob.setItemStackToSlot(slot, item);
	}

	@Override
	public void setMobClass(MobType type, boolean clear) {

		LivingEntity oldMob = (LivingEntity) this.mob;
		LivingEntity newMob = (LivingEntity) MobType.getEntity(this.mob.world, type);

		newMob.copyLocationAndAnglesFrom(oldMob);

		this.mob = (Entity) newMob;

		if (newMob instanceof ZombieEntity) {
			((ZombieEntity) newMob).setChild(((ZombieEntity) oldMob).isChild());
		}

		for (EquipmentSlotType slot : EquipmentSlotType.values()) {
			ItemStack toTrade = oldMob.getItemStackFromSlot(slot);
			newMob.setItemStackToSlot(slot, toTrade);
		}

		oldMob.remove();
		newMob.world.addEntity(newMob);
	}

	@Override
	public void setChild(boolean child) {
		if (!(this.mob instanceof ZombieEntity))
			return;

		((ZombieEntity) this.mob).setChild(child);
	}

	@Override
	public boolean instance(Class<?> type) {
		return type.isInstance(this.mob);
	}

	@Override
	public void setName(String name) {
		this.mob.setCustomName(new StringTextComponent(name));
		this.mob.setCustomNameVisible(true);
	}

}