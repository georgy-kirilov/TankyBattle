package models;

import java.awt.Color;
import java.awt.Graphics;

import enums.Direction;

public class Bullet extends GameObject{
	private int x;
	private int y;
	
    private Direction face;
    private int speed=5;
	
	public Bullet(int x, int y) 
	{
		setX(x);
		setY(y);
	}
	
	public int getX() 
	{
		return x;
	}
	
	public void setX(int x) 
	{
		this.x = x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	public void move() 
	{
		switch(face) 
		{
		case UP: y -= speed;
		case DOWN: 	y += speed;
		case LEFT: x-= speed;
		case RIGHT: x+= speed;
		}
		
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.yellow);
		g.fillOval((int) x, (int) y, 10, 10);
	}
	

}
