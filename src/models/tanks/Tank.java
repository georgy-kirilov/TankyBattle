package models.tanks;

import java.awt.Graphics2D;

import drawers.tanks.TankDrawer;
import enums.Direction;
import models.contracts.MovableGameObject;
import models.contracts.Rotatable;

public abstract class Tank extends MovableGameObject implements Rotatable
{
	private static final int HEIGHT = 40;
	private static final int WIDTH = 40;
	
	private final TankDrawer tankDrawer;
	
	public Tank(int x, int y, int speed, Direction direction, TankDrawer tankDrawer)
	{
		super(x, y, HEIGHT, WIDTH, speed, direction);
		this.tankDrawer = tankDrawer;
	}
	
	@Override
	public void rotate(Direction direction)
	{
		setDirection(direction);
	}
	
	@Override
	public void draw(Graphics2D g)
	{
		tankDrawer.drawTank(g, this);
	}
}
