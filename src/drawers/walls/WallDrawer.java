package drawers.walls;

import java.awt.Graphics2D;

import models.walls.Wall;

public interface WallDrawer
{
	void drawWall(Graphics2D g, Wall wall);
}
