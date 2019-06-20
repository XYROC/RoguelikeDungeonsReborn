package greymerk.roguelike.worldgen.filter;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import java.util.Random;

import greymerk.roguelike.theme.ITheme;
import greymerk.roguelike.worldgen.IBounded;
import greymerk.roguelike.worldgen.IWorldEditor;

public interface IFilter {

	public void apply(IWorldEditor editor, Random rand, ITheme theme, IBounded box);

}
