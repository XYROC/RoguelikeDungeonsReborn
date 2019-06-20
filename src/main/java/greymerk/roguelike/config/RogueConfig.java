package greymerk.roguelike.config;

/*
 * Roguelike Dungeons Reborn
 * Modified Source
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.Tuple;

public enum RogueConfig {

	DONATURALSPAWN, SPAWNFREQUENCY, GENEROUS, MOBDROPS, DIMENSIONWL, DIMENSIONBL, PRECIOUSBLOCKS, LOOTING, UPPERLIMIT,
	LOWERLIMIT, ROGUESPAWNERS, ENCASE, FURNITURE, RANDOM, SPAWNBUILTIN, SPAWNCHANCE;

	public static final String configDirName = "config/roguelike_dungeons";
	public static final String configFileName = "roguelike.cfg";

	public static boolean testing = false;
	private static ConfigFile instance = null;

	public static String getName(RogueConfig option) {
		switch (option) {
		case DONATURALSPAWN:
			return "doNaturalSpawn";
		case SPAWNFREQUENCY:
			return "spawnFrequency";
		case SPAWNCHANCE:
			return "spawnChance";
		case GENEROUS:
			return "generous";
		case DIMENSIONWL:
			return "dimensionWL";
		case DIMENSIONBL:
			return "dimensionBL";
		case PRECIOUSBLOCKS:
			return "preciousBlocks";
		case LOOTING:
			return "looting";
		case UPPERLIMIT:
			return "upperLimit";
		case LOWERLIMIT:
			return "lowerLimit";
		case ROGUESPAWNERS:
			return "rogueSpawners";
		case ENCASE:
			return "encase";
		case FURNITURE:
			return "furniture";
		case RANDOM:
			return "random";
		case SPAWNBUILTIN:
			return "doBuiltinSpawn";
		default:
			return null;
		}
	}

	public static Tuple<String, ?> getDefault(RogueConfig option) {
		switch (option) {
		case DONATURALSPAWN:
			return new Tuple<String, Boolean>(getName(option), true);
		case SPAWNCHANCE:
			return new Tuple<String, Double>(getName(option), 1.0);
		case SPAWNFREQUENCY:
			return new Tuple<String, Integer>(getName(option), 10);
		case GENEROUS:
			return new Tuple<String, Boolean>(getName(option), true);
		case DIMENSIONWL:
			List<Integer> bl = new ArrayList<Integer>();
			bl.add(0);
			return new Tuple<String, List<Integer>>(getName(option), bl);
		case DIMENSIONBL:
			return new Tuple<String, List<Integer>>(getName(option), new ArrayList<Integer>());
		case PRECIOUSBLOCKS:
			return new Tuple<String, Boolean>(getName(option), true);
		case LOOTING:
			return new Tuple<String, Double>(getName(option), 0.085D);
		case UPPERLIMIT:
			return new Tuple<String, Integer>(getName(option), 100);
		case LOWERLIMIT:
			return new Tuple<String, Integer>(getName(option), 60);
		case ROGUESPAWNERS:
			return new Tuple<String, Boolean>(getName(option), true);
		case ENCASE:
			return new Tuple<String, Boolean>(getName(option), false);
		case FURNITURE:
			return new Tuple<String, Boolean>(getName(option), true);
		case RANDOM:
			return new Tuple<String, Boolean>(getName(option), false);
		case SPAWNBUILTIN:
			return new Tuple<String, Boolean>(getName(option), true);
		default:
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private static void setDefaults() {
		if (!instance.ContainsKey(getName(DONATURALSPAWN)))
			setBoolean(DONATURALSPAWN, (Boolean) getDefault(DONATURALSPAWN).getB());
		if (!instance.ContainsKey(getName(SPAWNFREQUENCY)))
			setInt(SPAWNFREQUENCY, (Integer) getDefault(SPAWNFREQUENCY).getB());
		if (!instance.ContainsKey(getName(SPAWNCHANCE)))
			setDouble(SPAWNCHANCE, (Double) getDefault(SPAWNCHANCE).getB());
		if (!instance.ContainsKey(getName(GENEROUS)))
			setBoolean(GENEROUS, (Boolean) getDefault(GENEROUS).getB());
		if (!instance.ContainsKey(getName(DIMENSIONWL)))
			setIntList(DIMENSIONWL, (List<Integer>) getDefault(DIMENSIONWL).getB());
		if (!instance.ContainsKey(getName(DIMENSIONBL)))
			setIntList(DIMENSIONBL, (List<Integer>) getDefault(DIMENSIONBL).getB());
		if (!instance.ContainsKey(getName(PRECIOUSBLOCKS)))
			setBoolean(PRECIOUSBLOCKS, (Boolean) getDefault(PRECIOUSBLOCKS).getB());
		if (!instance.ContainsKey(getName(LOOTING)))
			setDouble(LOOTING, (Double) getDefault(LOOTING).getB());
		if (!instance.ContainsKey(getName(UPPERLIMIT)))
			setInt(UPPERLIMIT, (Integer) getDefault(UPPERLIMIT).getB());
		if (!instance.ContainsKey(getName(LOWERLIMIT)))
			setInt(LOWERLIMIT, (Integer) getDefault(LOWERLIMIT).getB());
		if (!instance.ContainsKey(getName(ROGUESPAWNERS)))
			setBoolean(ROGUESPAWNERS, (Boolean) getDefault(ROGUESPAWNERS).getB());
		if (!instance.ContainsKey(getName(ENCASE)))
			setBoolean(ENCASE, (Boolean) getDefault(ENCASE).getB());
		if (!instance.ContainsKey(getName(FURNITURE)))
			setBoolean(FURNITURE, (Boolean) getDefault(FURNITURE).getB());
		if (!instance.ContainsKey(getName(RANDOM)))
			setBoolean(RANDOM, (Boolean) getDefault(RANDOM).getB());
		if (!instance.ContainsKey(getName(SPAWNBUILTIN)))
			setBoolean(SPAWNBUILTIN, (Boolean) getDefault(SPAWNBUILTIN).getB());
	}

	public static double getDouble(RogueConfig option) {
		if (testing)
			return (Double) getDefault(option).getB();
		reload(false);
		Tuple<String, ?> def = getDefault(option);
		return instance.GetDouble(getName(option), (Double) def.getB());
	}

	public static void setDouble(RogueConfig option, double value) {
		reload(false);
		instance.Set(getName(option), value);
	}

	public static boolean getBoolean(RogueConfig option) {
		if (testing)
			return (Boolean) getDefault(option).getB();
		reload(false);
		Tuple<String, ?> def = getDefault(option);
		return instance.GetBoolean(getName(option), (Boolean) def.getB());
	}

	public static void setBoolean(RogueConfig option, Boolean value) {
		reload(false);
		instance.Set(getName(option), value);
	}

	public static int getInt(RogueConfig option) {
		if (testing)
			return (Integer) getDefault(option).getB();
		reload(false);
		Tuple<String, ?> def = getDefault(option);
		return instance.GetInteger((String) def.getA(), (Integer) def.getB());
	}

	public static void setInt(RogueConfig option, int value) {
		reload(false);
		Tuple<String, ?> def = getDefault(option);
		instance.Set((String) def.getA(), value);
	}

	@SuppressWarnings("unchecked")
	public static List<Integer> getIntList(RogueConfig option) {
		if (testing)
			return (ArrayList<Integer>) getDefault(option).getB();
		reload(false);
		Tuple<String, ?> def = getDefault(option);
		return instance.GetListInteger((String) def.getA(), (ArrayList<Integer>) def.getB());
	}

	public static void setIntList(RogueConfig option, List<Integer> value) {
		reload(false);
		Tuple<String, ?> def = getDefault(option);
		instance.Set((String) def.getA(), value);
	}

	private static void init() {

		if (testing)
			return;

		// make sure file exists
		File configDir = new File(configDirName);
		if (!configDir.exists()) {
			configDir.mkdir();
		}

		File cfile = new File(configDirName + "/" + configFileName);

		if (!cfile.exists()) {
			try {
				cfile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// read in configs
		try {
			instance = new ConfigFile(configDirName + "/" + configFileName, new INIParser());
		} catch (Exception e) {
			e.printStackTrace();
		}

		setDefaults();

		try {
			instance.Write();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void reload(boolean force) {
		if (instance == null || force) {
			init();
		}
	}
}
