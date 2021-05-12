package models;

public class GameObject
{
	private int x;
	private int y;
	private int height;
	private int width;
	private boolean visible;
	
	public GameObject()
	{
		
	}
	
	public GameObject(int x, int y, int height, int width, boolean visible)
	{
		setX(x);
		setY(y);
		setHeight(height);
		setWidth(width);
		setVisible(visible);
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public boolean isVisible()
	{
		return visible;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public void setVisible(boolean visible)
	{
		this.visible = visible;
	}
	
	public boolean intersect(GameObject g)
	{
		if (this.getY() + this.getHeight() == g.getY())
		{
			return true;
		}
		
		if (this.getX() + this.getWidth() == g.getX())
		{
			return true;
		}
		
		if (g.getY() + g.getHeight() == this.getY())
		{
			return true;
		}
		
		if (g.getX() + g.getWidth() == this.getX())
		{
			return true;
		}
		return false;
	}
}
