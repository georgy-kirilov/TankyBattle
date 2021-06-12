package drawers.walls;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import models.walls.Wall;

public class ImageWallDrawer implements WallDrawer
{
	private static final String PATH_FORMAT = "./resources/walls/%s/%s.png";
	
	private BufferedImage vertical;
	private BufferedImage horizontal;
	
	@Override
	public void drawWall(Graphics2D g, Wall wall)
	{
		try
		{
			String wallType = wall.getClass().getSimpleName().replaceAll("Wall", "").toLowerCase();
			
			if (vertical == null)
			{
				vertical = ImageIO.read(new File(String.format(PATH_FORMAT, wallType, "vertical")));
			}
			
			if (horizontal == null)
			{
				horizontal = ImageIO.read(new File(String.format(PATH_FORMAT, wallType, "horizontal")));
			}
			
			BufferedImage image = wall.getWidth() > wall.getHeight() ? horizontal : vertical;
			g.drawImage(image, wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight(), null);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
