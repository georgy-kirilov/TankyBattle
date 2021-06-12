package models.tanks;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import enums.Direction;

public class StandardTank extends Tank
{
	private static final int SPEED = 3;
	
	public StandardTank(int x, int y, Direction direction)
	{
		super(x, y, SPEED, direction);
	}

	@Override
	public void draw(Graphics2D g)
	{
		String fileName = getDirection().toString().toLowerCase();
		File imageFile = new File("resources/tanks/standard/" + fileName + ".png");
		
		try
		{
			BufferedImage image = ImageIO.read(imageFile);
			AffineTransform af = AffineTransform.getTranslateInstance(image.getWidth(), image.getHeight());
			af.rotate(Math.toRadians(90), image.getWidth() / 2, image.getHeight() / 2);
			g.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
