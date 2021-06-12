package models.tanks;

import java.awt.Color;
import java.awt.Graphics2D;

import enums.Direction;

public class StandardTank extends Tank
{
	private static final int HEIGHT = 30;
	private static final int WIDTH = 20;
	private static final int SPEED = 5;
	
	public StandardTank(int x, int y, Direction direction)
	{
		super(x, y, HEIGHT, WIDTH, SPEED, direction);
	}

	@Override
	public void draw(Graphics2D g)
	{
		g.setColor(Color.BLUE);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
}
