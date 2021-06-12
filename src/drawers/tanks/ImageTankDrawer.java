package drawers.tanks;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
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
		AffineTransform af = AffineTransform.getTranslateInstance(image.getWidth(), image.getHeight());
		af.rotate(Math.toRadians(90), image.getWidth() / 2, image.getHeight() / 2);
		g.drawImage(image, tank.getX(), tank.getY(), tank.getWidth(), tank.getHeight(), null);
	}
}
