package models.contracts;

import enums.Direction;

public abstract class MovableGameObject extends GameObject implements Movable
{
	private int speed;
	private Direction direction;
	
	public MovableGameObject(int x, int y, int height, int width, int speed, Direction direction)
	{
		super(x, y, height, width);
		setSpeed(speed);
		setDirection(direction);
	}
	
	@Override
	public int getSpeed()
	{
		return speed;
	}

	@Override
	public void setSpeed(int speed)
	{	
		this.speed = speed;
	}
	
	@Override
	public Direction getDirection()
	{
		return direction;
	}
	
	protected void setDirection(Direction direction)
	{
		this.direction = direction;
	}
	
	@Override
	public void move()
	{
		int newX = getX(), newY = getY();
		
		if (direction == Direction.UP)
		{
			newY -= getSpeed();
		}
		
		if (direction == Direction.DOWN)
		{
			newY += getSpeed();
		}
		
		if (direction == Direction.LEFT)
		{
			newX -= getSpeed();
		}
		
		if (direction == Direction.RIGHT)
		{
			newX += getSpeed();
		}
		
		setX(newX);
		setY(newY);
	}
	
	@Override
	public void moveBack()
	{
		setSpeed(-getSpeed());
		move();
		setSpeed(-getSpeed());
	}
}
