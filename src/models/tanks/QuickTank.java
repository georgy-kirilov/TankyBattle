package models.tanks;

import java.awt.Color;
import java.awt.Graphics2D;

import enums.Direction;

public class QuickTank extends Tank
{
	private static final int SPEED = 3;

	public QuickTank(int x, int y, Direction direction)
	{
		super(x, y, SPEED, direction);
	}

	@Override
	public void draw(Graphics2D g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
}
