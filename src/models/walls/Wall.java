package models.walls;

import java.awt.Graphics2D;

import drawers.walls.WallDrawer;
import models.contracts.GameObject;

public abstract class Wall extends GameObject
{
	private final WallDrawer wallDrawer;
	
	public Wall(int x, int y, int height, int width, WallDrawer wallDrawer)
	{
		super(x, y, height, width);
		this.wallDrawer = wallDrawer;
	}
	
	@Override
	public void draw(Graphics2D g)
	{
		wallDrawer.drawWall(g, this);
	}
}
