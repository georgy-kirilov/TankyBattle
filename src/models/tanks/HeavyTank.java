package models.tanks;

import java.awt.Color;
import java.awt.Graphics2D;

import drawers.tanks.TankDrawer;
import enums.Direction;

public class HeavyTank extends Tank
{
	private static final int SPEED = 2;
	
	public HeavyTank(int x, int y, Direction direction, TankDrawer tankDrawer)
	{
		super(x, y, SPEED, direction, tankDrawer);
	}
}
