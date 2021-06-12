package models.walls;

import java.awt.Graphics2D;

import common.GlobalConstants;
import drawers.walls.WallDrawer;
import models.contracts.GameObject;

public abstract class Wall extends GameObject
{
	private static final int HEIGHT = GlobalConstants.CELL_SIZE;
	private static final int WIDTH = GlobalConstants.CELL_SIZE;
	
	private final WallDrawer wallDrawer;
	
	public Wall(int x, int y, WallDrawer wallDrawer)
	{
		super(x, y, HEIGHT, WIDTH);
		this.wallDrawer = wallDrawer;
	}
	
	@Override
	public void draw(Graphics2D g)
	{
		wallDrawer.drawWall(g, this);
	}
}
