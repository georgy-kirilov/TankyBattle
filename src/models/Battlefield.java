package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import models.walls.Wall;

public class Battlefield extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	@Override
	public void paint(Graphics graphics)
	{
		super.paint(graphics);
		Graphics2D g = (Graphics2D) graphics;
	}
}
