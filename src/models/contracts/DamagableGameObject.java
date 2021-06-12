package models.contracts;

public abstract class DamagableGameObject extends GameObject implements Damagable
{
	private int health;
	
	public DamagableGameObject(int x, int y, int height, int width, int health)
	{
		super(x, y, height, width);
		
		if (health < 0)
		{
			throw new IllegalArgumentException("Health cannot be negative");
		}
		
		this.health = health;
	}

	@Override
	public int getHealth()
	{
		return health;
	}

	@Override
	public boolean isAlive()
	{
		return getHealth() > 0;
	}

	@Override
	public void takeDamage(int damage)
	{
		if (damage < 0)
		{
			throw new IllegalArgumentException("Damage cannot be negative");
		}
		
		health -= damage;
	}
}
