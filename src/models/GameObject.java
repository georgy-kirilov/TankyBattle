package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class GameObject extends JComponent
{
	private int x;
	private int y;
	private int height;
	private int width;
	private boolean visible;
	private final static Color BACKGROUND_COLOR = new Color(21,43,22);
	
	public GameObject(int x, int y, int height, int width)
	{
		setX(x);
		setY(y);
		setHeight(height);
		setWidth(width);
		setVisible(true);
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
			return ((this.getY() + this.getHeight() == g.getY()) 
						|| (this.getX() + this.getWidth() == g.getX())
							|| (g.getY() + g.getHeight() == this.getY()) 
								|| (g.getX() + g.getWidth() == this.getX()));
	}
	
	@Override
	public void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D)graphics;
		g.setColor(BACKGROUND_COLOR);
		if (visible == true)
		{
			g.fillRect(x, y, x + width, y + height);
			g.drawRect(x, y, width, height);			
		}
	}
}
