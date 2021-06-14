package models;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import common.GlobalConstants;
import drawers.tanks.ImageTankDrawer;
import drawers.walls.ImageWallDrawer;
import models.contracts.GameObject;
import models.tanks.StandardTank;
import models.walls.BrickWall;

public class LevelParser
{	
	public static Collection<GameObject> deserialize(String path)
	{
		Collection<GameObject> objects = new ArrayList<>();
		
		try
		{
			List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
			
			for (int row = 0; row < lines.size(); row++)
			{
				String line = lines.get(row);
				int y = row * GlobalConstants.CELL_SIZE;
				
				for (int col = 0; col < line.length(); col++)
				{
					char symbol = line.charAt(col);

					if (symbol == '0')
					{
						continue;
					}
					
					int x = col * GlobalConstants.CELL_SIZE;
					GameObject object = null;
					
					if (symbol == GlobalConstants.GameObjectSymbols.BrickWall)
					{
						object = new BrickWall(x, y, new ImageWallDrawer());
					}
					
					if (symbol == GlobalConstants.GameObjectSymbols.StandardTank)
					{
						object = new StandardTank(x, y, GlobalConstants.INITIAL_TANK_DIRECTION, new ImageTankDrawer());
					}
					
					objects.add(object);
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return objects;
	}
}
