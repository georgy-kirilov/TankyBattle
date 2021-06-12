package models;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import common.GlobalConstants;
import drawers.walls.ImageWallDrawer;
import models.contracts.GameObject;
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
					
					if (symbol == 'b')
					{
						object = new BrickWall(x, y, new ImageWallDrawer());
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
