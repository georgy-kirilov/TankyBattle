package models;

import java.awt.Color;
import java.awt.Graphics;

import enums.Directions;

public class Bullet {
	private double x;
	private double y;
	
	public Bullet(double x, double y) 
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
	public void move(Directions face) 
	{
		if(face.equals("DOWN")) 
		{
			x -= 5;
		}
		else if(face.equals("UP")) 
		{
			y -= 5;
		}
		else if(face.equals("LEFT")) 
		{
			x -= 5;
		}
		else 
		{
			x += 5;
		}
		
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.yellow);
		g.fillOval((int) x, (int) y, 10, 10);
	}
	

}
