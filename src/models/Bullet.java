package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import enums.Direction;

public class Bullet extends GameObject
{
	private static final int HEIGHT = 10;
	private static final int WIDTH = 3;
	

	private int speed;
    private Direction face;
	
	public Bullet(int x, int y, int speed, Direction face) 
	{
		super(x, y, HEIGHT, WIDTH);
		setSpeed(speed);
		setFace(face);
	}
	
	public void move() 
	{
		switch(face) 
		{
			case UP: setY(getY() - speed);
			case DOWN: setY(getY() + speed);
			case LEFT: setX(getX() - speed);
			case RIGHT: setX(getX() + speed);
		}
		
	}
	public Direction getFace() {
		return face;
	}

	public void setFace(Direction face) {
		this.face = face;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
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
