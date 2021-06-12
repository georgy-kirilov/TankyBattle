package models.contracts;

public interface Damagable
{
	int getHealth();
	boolean isAlive();
	void takeDamage(int damage);
}
