package models.tanks;

import enums.Direction;
import models.contracts.MovableGameObject;
import models.contracts.Rotatable;

public abstract class Tank extends MovableGameObject implements Rotatable
{
	public Tank(int x, int y, int height, int width, int speed, Direction direction)
	{
		super(x, y, height, width, speed, direction);
	}
	
	@Override
	public void rotate(Direction direction)
	{
		setDirection(direction);
	}
}
