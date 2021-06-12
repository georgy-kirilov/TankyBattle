package models.contracts;

import enums.Direction;

public interface Movable
{
	int getSpeed();
	void setSpeed(int speed);
	void move();
	void moveBack();
	Direction getDirection();
}
