package drawers.tanks;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import enums.Direction;
import models.tanks.Tank;

public class ImageTankDrawer implements TankDrawer
{
	private static final String PATH_FORMAT = "./resources/tanks/%s/%s.png";
	private final HashMap<Direction, BufferedImage> directionImagePairs;
	
	public ImageTankDrawer()
	{
		directionImagePairs = new HashMap<>();
	}
	
	@Override
	public void drawTank(Graphics2D g, Tank tank)
	{
		if (!directionImagePairs.containsKey(tank.getDirection()))
		{
			String tankType = tank.getClass().getSimpleName().replaceAll("Tank", "").toLowerCase();
			String tankDirection = tank.getDirection().toString().toLowerCase();
			String filePath = String.format(PATH_FORMAT, tankType, tankDirection);
			File imageFile = new File(filePath);
			
			try
			{
				BufferedImage image = ImageIO.read(imageFile);
				directionImagePairs.put(tank.getDirection(), image);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		BufferedImage image = directionImagePairs.get(tank.getDirection());
		g.drawImage(image, tank.getX(), tank.getY(), tank.getWidth(), tank.getHeight(), null);
	}
}
