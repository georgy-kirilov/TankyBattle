package models.tanks;

import drawers.tanks.TankDrawer;
import enums.Direction;

public class QuickTank extends Tank
{
	private static final int SPEED = 3;

	public QuickTank(int x, int y, Direction direction, TankDrawer tankDrawer)
	{
		super(x, y, SPEED, direction, tankDrawer);
	}
}