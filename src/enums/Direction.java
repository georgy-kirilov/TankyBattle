package enums;

import java.util.Random;

public enum Direction
{
	UP,
	DOWN,
	LEFT,
	RIGHT;
	
	public static Direction random()
	{
		Random random = new Random();
		Direction[] directions = Direction.values();
		int index = random.nextInt(directions.length);
		return directions[index];
	}
}
