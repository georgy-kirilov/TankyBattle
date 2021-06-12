package models;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collection;

import models.contracts.GameObject;

public class Game
{
	private final Collection<GameObject> objects;
	private final Graphics2D graphics;
	
	public Game(Graphics2D graphics)
	{
		objects = new ArrayList<>();
		this.graphics = graphics;
	}
	
	public void draw()
	{
		
	}
}
