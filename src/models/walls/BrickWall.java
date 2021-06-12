package models.walls;

import java.awt.Color;
import java.awt.Graphics2D;

public class BrickWall extends Wall
{
	public BrickWall(int x, int y, int height, int width)
	{
		super(x, y, height, width);
	}

	@Override
	public void draw(Graphics2D g)
	{
		g.setColor(new Color(166, 42, 42));
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
}
