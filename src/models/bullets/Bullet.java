package models.bullets;

import models.contracts.DestroyableGameObject;

public abstract class Bullet extends DestroyableGameObject
{
	public Bullet(int x, int y, int height, int width, int damagePerHit)
	{
		super(x, y, height, width, damagePerHit);
	}
}
