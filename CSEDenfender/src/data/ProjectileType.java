package data;
import org.newdawn.slick.opengl.Texture;

import static helpers.Artist.*;

public enum ProjectileType {
	
	CannonBall(QuickLoad("bullet"),8,500),
	IceBall(QuickLoad("projectileIceball"),6,400),
	FireBall(QuickLoad("bulletfire"),24,300);
	
	Texture texture;
	int damage;
	float speed;


	ProjectileType(Texture texture , int damage, float speed)
	{
		this.texture = texture;
		this.damage = damage;
		this.speed = speed;
	}
}
