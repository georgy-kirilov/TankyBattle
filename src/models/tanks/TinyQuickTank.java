package models.tanks;

import java.awt.Color;
import java.awt.Graphics2D;

import enums.Direction;

public class TinyQuickTank extends Tank
{
	private static final int HEIGHT = 20;
	private static final int WIDTH = 10;
	private static final int SPEED = 8;

	public TinyQuickTank(int x, int y, Direction direction)
	{
		super(x, y, HEIGHT, WIDTH, SPEED, direction);
	}

	@Override
	public void draw(Graphics2D g)
	{
		g.setColor(Color.CYAN);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
}
