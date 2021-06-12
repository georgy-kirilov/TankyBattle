package models.tanks;

import enums.Direction;
import models.contracts.MovableGameObject;
import models.contracts.Rotatable;

public abstract class Tank extends MovableGameObject implements Rotatable
{
	private static final int HEIGHT = 40;
	private static final int WIDTH = 40;
	
	public Tank(int x, int y, int speed, Direction direction)
	{
		super(x, y, HEIGHT, WIDTH, speed, direction);
	}
	
	@Override
	public void rotate(Direction direction)
	{
		setDirection(direction);
	}
}
