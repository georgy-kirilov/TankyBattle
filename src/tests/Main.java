package tests;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import drawers.tanks.ImageTankDrawer;
import drawers.walls.ImageWallDrawer;
import enums.Direction;
import models.*;
import models.tanks.HeavyTank;
import models.tanks.QuickTank;
import models.tanks.StandardTank;
import models.walls.*;

public class Main
{
	public static void main(String[] args) throws InterruptedException
	{
		JFrame f = new JFrame();
		f.setBounds(0, 0, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setLayout(null);
		
		Battlefield b = new Battlefield();
		b.setBounds(0, 0, 500, 500);
		b.addWall(new BrickWall(20, 20, 30, 100, new ImageWallDrawer()));
		b.addEnemyTank(new HeavyTank(180, 60, Direction.RIGHT, new ImageTankDrawer()));
		b.setPlayer(new HeavyTank(90, 60, Direction.DOWN, new ImageTankDrawer()));
		b.addWall(new BrickWall(120, 400, 30, 100, new ImageWallDrawer()));
		
		b.addWall(new BrickWall(40, 300, 30, 100, new ImageWallDrawer()));
		b.addKeyListener(new KeyListener()
		{
			
			@Override
			public void keyTyped(KeyEvent e)
			{
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e)
			{
				Direction currentDirection = getDirectionFromKey(e.getKeyChar());
				
				if (currentDirection == null)
				{
					return;
				}
				
				if (currentDirection != b.getPlayer().getDirection())
				{
					b.rotatePlayer(currentDirection);
				}
				else
				{
					b.movePlayer();
				}
			}
		});
		b.addWall(new BrickWall(140, 20, 10, 30, new ImageWallDrawer()));
		//b.addEnemyTank(new HeavyTank(120, 60, Direction.DOWN));
		f.add(b);
		
		
		new Thread() {
			public void run()
			{
				while (true)
				{
					try
					{
						Thread.sleep(60);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					b.update();
					b.repaint();
				}
			}
		}.run();
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
}
