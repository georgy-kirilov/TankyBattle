package models.tanks;

import java.awt.Color;
import java.awt.Graphics2D;

import enums.Direction;

public class LargeHeavyTank extends Tank
{
	private static final int HEIGHT = 40;
	private static final int WIDTH = 30;
	private static final int SPEED = 3;
	
	public LargeHeavyTank(int x, int y, Direction direction)
	{
		super(x, y, HEIGHT, WIDTH, SPEED, direction);
	}

	@Override
	public void draw(Graphics2D g)
	{
		g.setColor(Color.GREEN);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
}
