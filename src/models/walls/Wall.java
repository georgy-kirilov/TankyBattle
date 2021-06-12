package models.walls;

import models.contracts.GameObject;

public abstract class Wall extends GameObject
{
	public Wall(int x, int y, int height, int width)
	{
		super(x, y, height, width);
	}
}
