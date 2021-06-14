package tests;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import drawers.tanks.ImageTankDrawer;
import enums.Direction;
import models.*;
import models.contracts.GameObject;
import models.tanks.QuickTank;
import models.tanks.Tank;
import models.walls.*;

public class Main
{
	public static void main(String[] args) throws InterruptedException
	{
		JFrame frame = new JFrame();
		frame.setBounds(0, 0, 650, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		
		Battlefield battlefield = new Battlefield();
		battlefield.setBounds(0, 0, 600, 600);
		battlefield.setPlayer(new QuickTank(90, 60, Direction.UP, new ImageTankDrawer()));
		
		attachKeyListener(battlefield);
		loadLevel(battlefield, "one");
		frame.add(battlefield);
		
		battlefield.run();
	}
	
	public static Direction getDirectionFromKey(char rawKey)
	{
		char key = Character.toString(rawKey).toLowerCase().charAt(0);
		
		switch (key)
		{
			case 'w': return Direction.UP;
			case 's': return Direction.DOWN;
			case 'a': return Direction.LEFT;
			case 'd': return Direction.RIGHT;
		}
		
		return null;
	}
	
	public static void attachMouseListener(Battlefield battlefield)
	{
		battlefield.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				if (e.getX() < battlefield.getPlayer().getX())
				{
					battlefield.rotatePlayer(Direction.LEFT);
				}
				else if (e.getX() > battlefield.getPlayer().getX() + battlefield.getPlayer().getWidth())
				{
					battlefield.rotatePlayer(Direction.RIGHT);
				}
				else if (e.getY() < battlefield.getPlayer().getY())
				{
					battlefield.rotatePlayer(Direction.UP);
				}
				else if (e.getY() > battlefield.getPlayer().getY() + battlefield.getPlayer().getHeight())
				{
					battlefield.rotatePlayer(Direction.DOWN);
				}
				
				battlefield.movePlayer();
			}
		});
	}
	
	public static void attachKeyListener(Battlefield battlefield)
	{
		battlefield.addKeyListener(new KeyAdapter()
		{		
			@Override
			public void keyTyped(KeyEvent e)
			{
				Direction currentDirection = getDirectionFromKey(e.getKeyChar());
				
				if (currentDirection == null)
				{
					return;
				}
				
				if (currentDirection != battlefield.getPlayer().getDirection())
				{
					battlefield.rotatePlayer(currentDirection);
				}
				else
				{
					battlefield.movePlayer();
				}
			}
		});
	}
	
	public static void loadLevel(Battlefield b, String level)
	{
		for (GameObject object : LevelParser.deserialize("./levels/level-" + level + ".txt"))
		{
			if (object instanceof Tank)
			{
				b.addEnemyTank((Tank) object);
			}
			if (object instanceof Wall)
			{
				b.addWall((Wall)object);				
			}
		}
	}
}
