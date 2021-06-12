package models.contracts;

public abstract class DestroyableGameObject extends GameObject implements Destroyable
{
	private final int damagePerHit;
	
	public DestroyableGameObject(int x, int y, int height, int width, int damagePerHit)
	{
		super(x, y, height, width);
		
		if (damagePerHit < 0)
		{
			throw new IllegalArgumentException("DamagePerHit cannot be negative");
		}
		
		this.damagePerHit = damagePerHit;
	}

	@Override
	public void destroy(Damagable object)
	{
		object.takeDamage(damagePerHit);
	}
}
