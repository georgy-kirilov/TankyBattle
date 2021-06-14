package common;

import enums.Direction;

public class GlobalConstants
{
	public static final int CELL_SIZE = 40;
	public static final Direction INITIAL_TANK_DIRECTION = Direction.UP;
	
	public static class GameObjectSymbols
	{
		public static final char BrickWall = 'b';
		public static final char SteelWall = 's';
		public static final char StandardTank = 't';
		public static final char QuickTank = 'q';
		public static final char HeavyTank = 'h';
	}
}
