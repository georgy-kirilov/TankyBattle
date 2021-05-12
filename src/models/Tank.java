package models;

import enums.Directions;

public class Tank {
	/*
	private int health;
	private double strength;
	*/
	
	private double x;
	private double y;
	private double speed;
	private Directions directions;
	
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

	public double getSpeed() 
	{
		return speed;
	}

	public void setSpeed(double speed) 
	{
		this.speed = speed;
	}

	public Directions getDirections() 
	{
		return directions;
	}

	public void setDirections(Directions directions) 
	{
		this.directions = directions;
	}
	
	
	

}
