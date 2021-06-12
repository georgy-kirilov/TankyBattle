package drawers.walls;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import models.walls.Wall;

public class ImageWallDrawer implements WallDrawer
{
	private static final String PATH_FORMAT = "./resources/walls/%s.png";
	
	private BufferedImage image;
	
	@Override
	public void drawWall(Graphics2D g, Wall wall)
	{
		try
		{
			if (image == null)
			{
				String wallType = wall.getClass().getSimpleName().replaceAll("Wall", "").toLowerCase();
				image = ImageIO.read(new File(String.format(PATH_FORMAT, wallType)));
			}
		
			g.drawImage(image, wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight(), null);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
