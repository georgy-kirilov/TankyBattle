package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JPanel;

import enums.Direction;
import models.contracts.GameObject;
import models.tanks.Tank;
import models.walls.Wall;

public class Battlefield extends JPanel
{
	private static final int SLEEP_DURATION = 30;
	
	private static final long serialVersionUID = 1L;
	
	private final Collection<GameObject> gameObjects;
	private final Collection<Tank> enemyTanks;
	
	private Tank player;
	
	public Battlefield()
	{
		gameObjects = new ArrayList<GameObject>();
		enemyTanks = new ArrayList<Tank>();
		
		this.setBackground(Color.LIGHT_GRAY);
		this.setFocusable(true);
	}
	
	public void run()
	{
		new Thread()
		{
			public void run()
			{
				while (true)
				{
					try
					{
						Thread.sleep(SLEEP_DURATION);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					
					update();
					repaint();
				}
			}
		}
		.run();
	}
	
	public void setPlayer(Tank player)
	{
		gameObjects.remove(this.player);
		addGameObject(player);
		this.player = player;
	}
	
	public Tank getPlayer()
	{
		return player;
	}
	
	public void movePlayer()
	{
		getPlayer().move();
		
		for (GameObject object : gameObjects)
		{
			if (object != getPlayer() && object.intersects(getPlayer()))
			{
				getPlayer().moveBack();
				break;
			}
		}
	}
	
	public void rotatePlayer(Direction direction)
	{
		getPlayer().rotate(direction);
	}
	
	public void addWall(Wall wall)
	{
		addGameObject(wall);
	}
	
	public void addEnemyTank(Tank enemyTank)
	{	
		addGameObject(enemyTank);
		enemyTanks.add(enemyTank);
	}
	
	private void update()
	{
		for (Tank enemyTank : enemyTanks)
		{
			enemyTank.move();
			
			for (GameObject object : gameObjects)
			{
				if (enemyTank != object && enemyTank.intersects(object))
				{
					enemyTank.moveBack();
					enemyTank.rotate(Direction.random());
					break;
				}
			}
		}
	}
	
	@Override
	public void paint(Graphics graphics)
	{
		super.paint(graphics);
		Graphics2D g = (Graphics2D) graphics;
		
		for (GameObject object : gameObjects)
		{
			object.draw(g);
		}
	}
	
	private void addGameObject(GameObject object)
	{
		if (object == null)
		{
			throw new IllegalArgumentException("You cannot add GameObject with null value");
		}
		
		if (gameObjects.contains(object))
		{
			throw new IllegalStateException("You cannot have have duplicate game objects on the battlefield");
		}
		
		gameObjects.add(object);
	}
}
