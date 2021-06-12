package drawers.tanks;

import java.awt.Graphics2D;

import models.tanks.Tank;

public interface TankDrawer
{
	void drawTank(Graphics2D g, Tank tank);
}
