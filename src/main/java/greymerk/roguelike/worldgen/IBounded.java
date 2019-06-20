package greymerk.roguelike.worldgen;

/*
 * Roguelike Dungeons Reborn
 * Original Source
 */

import greymerk.roguelike.worldgen.shapes.IShape;
import greymerk.roguelike.worldgen.shapes.Shape;

public interface IBounded {

	public BoundingBox getBoundingBox();

	public boolean collide(IBounded other);

	public IShape getShape(Shape type);

	public Coord getStart();

	public Coord getEnd();

}
