package greymerk.roguelike.worldgen.filter;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

public enum Filter {
	VINE, ENCASE, WIREFRAME, COBWEB, MUD;

	public static IFilter get(Filter type) {
		switch (type) {
		case VINE:
			return new VineFilter();
		case ENCASE:
			return new EncaseFilter();
		case WIREFRAME:
			return new WireframeFilter();
		case COBWEB:
			return new CobwebFilter();
		case MUD:
			return new MudFilter();
		default:
			return new VineFilter();
		}
	}
}
