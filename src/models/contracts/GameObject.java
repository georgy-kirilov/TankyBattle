package models.contracts;

import java.awt.Graphics2D;

public abstract class GameObject
{	
	private int x;
	private int y;
	private int height;
	private int width;
	
	public GameObject(int x, int y, int height, int width)
	{
		setX(x);
		setY(y);
		setHeight(height);
		setWidth(width);
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
	
	public int getHeight()
	{
		return height;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public boolean intersect(GameObject object)
	{
		return this.hasAnyCornersInside(object) || object.hasAnyCornersInside(this);
	}
	
	public abstract void draw(Graphics2D g);
	
	private boolean hasAnyCornersInside(GameObject object)
	{
		int rightX = object.getX(), leftX = object.getX() + object.getWidth();
		int topY = object.getY(), bottomY = object.getY() + object.getHeight();
		
		return isPointInside(rightX, topY) || isPointInside(rightX, bottomY) 
				|| isPointInside(leftX, topY) || isPointInside(leftX, bottomY);
	}
	
	private boolean isPointInside(int x, int y)
	{
		return getX() <= x && x <= getX() + getWidth() &&
			   getY() <= y && y <= getY() + getHeight();
	}
}
