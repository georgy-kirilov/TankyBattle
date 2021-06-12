package models.tanks;

import java.awt.Color;
import java.awt.Graphics2D;

import enums.Direction;

public class HeavyTank extends Tank
{
	private static final int SPEED = 2;
	
	public HeavyTank(int x, int y, Direction direction)
	{
		super(x, y, SPEED, direction);
	}

	@Override
	public void draw(Graphics2D g)
	{
		g.setColor(Color.GREEN);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
}
