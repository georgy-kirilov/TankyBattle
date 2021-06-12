package models.tanks;

import drawers.tanks.TankDrawer;
import enums.Direction;

public class StandardTank extends Tank
{
	private static final int SPEED = 3;
	
	public StandardTank(int x, int y, Direction direction, TankDrawer tankDrawer)
	{
		super(x, y, SPEED, direction, tankDrawer);
	}
}
