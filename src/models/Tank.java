package models;

import enums.Direction;

public class Tank {
	/*
	private int health;
	private double strength;
	*/
	
	private double x;
	private double y;
	private double speed = 2;
	private Direction direction;
	
	public Tank(double x, double y) 
	{
		setX(x);
		setY(y);
	}
	
	public double getX()
	{
		return x;
	}
	
	public void setX(double x) 
	{
		this.x = x;
	}
	
	public double getY() 
	{
		return y;
	}
	
	public void setY(double y) 
	{
		this.y = y;
	}

	public Direction getDirections() 
	{
		return direction;
	}

	public void setDirections(Direction direction) 
	{
		this.direction = direction;
	}
	public void move() 
	{
		switch(direction) 
		{
		case UP: y -= speed;
		case DOWN: 	y += speed;
		case LEFT: x-= speed;
		case RIGHT: x+= speed;
		}
	}
	
	

}
