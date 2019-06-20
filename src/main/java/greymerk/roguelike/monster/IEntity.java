package greymerk.roguelike.monster;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public interface IEntity {

	public void setSlot(EquipmentSlotType slot, ItemStack item);

	public void setMobClass(MobType type, boolean clear);

	public void setChild(boolean child);

	public boolean instance(Class<?> type);

	public void setName(String name);

}
