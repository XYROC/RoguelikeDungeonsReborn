package greymerk.roguelike.util;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import java.util.Random;

public interface IWeighted<T> {

	public int getWeight();

	public T get(Random rand);

}
