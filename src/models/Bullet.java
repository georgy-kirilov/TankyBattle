package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import enums.Direction;

public class Bullet extends GameObject
{
	// TODO:
	// speed and direction from constructor
	// fix move() -> getters and setters
	
	private static final int HEIGHT = 10;
	private static final int WIDTH = 3;
	
    private Direction face;
    
    private int speed = 5;
	
	public Bullet(int x, int y) 
	{
		super(x, y, HEIGHT, WIDTH);
	}
	
	public void move() 
	{
		switch(face) 
		{
			case UP: setY(getY() - speed);
			case DOWN: 	y += speed;
			case LEFT: x-= speed;
			case RIGHT: x+= speed;
		}
		
	}
	
	@Override
	public void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;
		g.setColor(Color.yellow);
		g.fillOval(getX(), getY(), getWidth(), getHeight());
	}
}
