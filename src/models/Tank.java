package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import enums.*;

@SuppressWarnings("serial")
public class Tank extends GameObject
{
	//TODO:
	//override paintComponent()
	
	
	private static final int HEIGHT = 20;
	private static final int WIDTH = 10;
	
	private int health;
	private int speed;
	private Direction direction;
	
	public Tank(int x, int y, int health, int speed, Direction direction) 
	{
		super(x, y, HEIGHT, WIDTH);
		setHealth(health);
		setSpeed(speed);
		setDirection(direction);
		
		
	}

	public Direction getDirection() 
	{
		return direction;
	}

	public void setDirection(Direction direction) 
	{
		this.direction = direction;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void move() 
	{
		switch(direction) 
		{
			case UP: setY(getY() - speed);
			case DOWN: setY(getY() + speed);
			case LEFT: setX(getX() - speed);
			case RIGHT: setX(getX() + speed);
		}
	}
	@Override
	public void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;
		g.setColor(Color.yellow);
		switch(direction) 
		{
		case UP: 
			g.fillRect(getX(), getY(), 5, 25);
			g.fillRect(getX()+20, getY(), 5, 25);
			g.fillRect(getX()+10, getY(), 10, 20);
			g.fillOval(getX()+5, getY()+10, 10, 10);
			g.drawLine(getX()+10, getY()+10, 15, 5);
		case DOWN: 
			g.fillRect(getX(), getY(), 5, 25);
			g.fillRect(getX()+20, getY(), 5, 25);
			g.fillRect(getX()+10, getY(), 10, 20);
			g.fillOval(getX()+5, getY()+10, 10, 10);
			g.drawLine(getX()+15, getY()+10, 15, 15);
		case RIGHT:
			g.fillRect(getX(), getY(), 25, 5);
			g.fillRect(getX()+20, getY(), 25, 5);
			g.fillRect(getX()+10, getY(), 20, 10);
			g.fillOval(getX()+5, getY()+10, 10, 10);
			g.drawLine(getX()+10, getY()+10, 25, 5);
		
		case LEFT: 
			g.fillRect(getX(), getY(), 25, 5);
			g.fillRect(getX()+20, getY(), 25, 5);
			g.fillRect(getX()+10, getY(), 20, 10);
			g.fillOval(getX()+5, getY()+10, 10, 10);
			g.drawLine(getX()+10, getY()+10, 5, 5);
		}
	}
}
