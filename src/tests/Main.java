package tests;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import models.Battlefield;
import models.walls.Wall;

public class Main
{
	public static void main(String[] args)
	{
		JFrame f = new JFrame();
		f.setBounds(0, 0, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setLayout(null);
		
		Battlefield b = new Battlefield();
		b.setBounds(0, 0, 300, 300);
		f.add(b);
		
	}
}
