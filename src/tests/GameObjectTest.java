package tests;

import java.awt.Color;

import javax.swing.JFrame;

import enums.Direction;
import models.GameObject;
import models.Tank;

public class GameObjectTest
{

	public static void main(String[] args)
	{
		GameObject obj1 = new GameObject(4,5,4,6);
		GameObject obj2 = new GameObject(4,9,4,6);
		GameObject obj3 = new GameObject(10,10, 15,15);
		
		System.out.println(obj1.intersect(obj2));
		
		JFrame window = new JFrame();
		window.setBounds(20,20,300,300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setLayout(null);
		
		
		Tank t1= new Tank(50,50,300,5,Direction.UP);
		t1.setVisible(true);
		
		window.add(obj3);
		window.add(t1);
		window.repaint();
	}

}
