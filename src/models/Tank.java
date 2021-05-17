package models;

import enums.*;

@SuppressWarnings("serial")
public class Tank extends GameObject
{
	//TODO:
	//override paintComponent()
	//direction and speed from constructor
	//implement health
	//fix move()
	
	private static final int HEIGHT = 20;
	private static final int WIDTH = 10;
	
	/*
	private int health;
	*/
	
	private double speed = 2;
	private Direction direction;
	
	public Tank(int x, int y) 
	{
		super(x, y, HEIGHT, WIDTH);
	}

	public Direction getDirection() 
	{
		return direction;
	}

	public void setDirection(Direction direction) 
	{
		this.direction = direction;
	}
	
	public void move() 
	{
		switch(direction) 
		{
			case UP: ;
			case DOWN: 	y += speed;
			case LEFT: x-= speed;
			case RIGHT: x+= speed;
		}
	}
}
