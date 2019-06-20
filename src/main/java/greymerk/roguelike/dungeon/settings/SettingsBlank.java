package greymerk.roguelike.dungeon.settings;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import java.util.HashMap;

import greymerk.roguelike.treasure.loot.LootRuleManager;

public class SettingsBlank extends DungeonSettings {

	public static final SettingIdentifier ID = new SettingIdentifier(SettingsContainer.BUILTIN_NAMESPACE, "blank");

	public SettingsBlank() {
		this.id = ID;
		levels = new HashMap<Integer, LevelSettings>();
		this.lootRules = new LootRuleManager();
	}
}
