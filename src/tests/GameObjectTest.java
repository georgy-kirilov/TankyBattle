package tests;

import models.GameObject;

public class GameObjectTest
{

	public static void main(String[] args)
	{
		GameObject obj1 = new GameObject(4,5,4,6,true);
		GameObject obj2 = new GameObject(4,3,4,6,true);
		
		System.out.println(obj1.intersect(obj2));
		
		
	}

}
