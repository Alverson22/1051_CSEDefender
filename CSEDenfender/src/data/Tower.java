package data;

import org.newdawn.slick.opengl.Texture;

import static helpers.Artist.DrawQuadTex;
import static helpers.Artist.DrawQuadTexRot;
import static helpers.Clock.Delta;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Tower implements Entity
{
	private float x, y, timeSinceLastShot, firingSpeed, angle;
	private int width, height, range, cost;
	public Enemy target;	
	private Texture[] textures;
	private CopyOnWriteArrayList<Enemy> enemies;
	private boolean targeted;
	public ArrayList<Projectile> projectiles;
	public TowerType type; 
	
	public Tower(TowerType type, Tile startTile, CopyOnWriteArrayList<Enemy> enemies)
	{
		this.type = type;
		this.textures = type.textures;
		this.range = type.range;
		this.cost = type.cost;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = startTile.getWidth();
		this.height = startTile.getHeight();
		this.enemies = enemies;
		this.targeted = false;
		this.timeSinceLastShot = 0f;
		this.projectiles = new ArrayList<Projectile>();
		this.firingSpeed = type.firingSpeed;
		this.angle = 0f;
	}
	
	private Enemy acquireTarget(){
		Enemy closest = null;
		float closestDistance = 10000;
		for(Enemy e: enemies){
			if(isInRange(e) && findDistance(e) < closestDistance && e.getHiddenHealth()>0){
				closestDistance = findDistance(e);
				closest = e;
			}
		}
		if(closest != null){
			targeted = true;
		}
		return closest;
	}
	
	private boolean isInRange(Enemy e){
		float xDistance = Math.abs(e.getX() - x);
		float yDistance = Math.abs(e.getX() - y);
		if(xDistance < range && yDistance < range){
			return true;
		}
		return false;
	}
	
	private float findDistance(Enemy e){
		float xDistance = Math.abs(e.getX() - x);
		float yDistance = Math.abs(e.getX() - y);
		return xDistance + yDistance;
	}
	
	private float calculateAngle(){
		double angleTemp = Math.atan2(target.getY() - y , target.getX() - x);
		return (float) Math.toDegrees(angleTemp) - 90;
	}
	
	public abstract void shoot(Enemy target);
		
	public void updateEnemyList(CopyOnWriteArrayList<Enemy> newList){
		enemies = newList;
	}
	@Override
	public void update() {
		if(!targeted || target.getHiddenHealth() < 0){
			target = acquireTarget();
		} else{
			angle = calculateAngle();
			if(timeSinceLastShot > firingSpeed) {
				shoot(target);
				timeSinceLastShot = 0;
			}
		}
		if(target == null || target.isAlive() == false) {
			targeted = false;
		}
		
		timeSinceLastShot += Delta();
		
		for(Projectile p : projectiles) {
			p.update();
		}
		draw();
	}
	
	@Override
	public void draw() {
		DrawQuadTex(textures[0], x , y , width , height);
		if(textures.length > 1){
			for(int i = 1 ; i < textures.length; i++){
				DrawQuadTexRot(textures[i], x , y , width , height, angle);			
				}
		}
				
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setX(float x) {
		this.x = x;
		
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public Enemy getTarget() {
		return target;
	}
	
	public int getCost() {
		return cost;
	}
}
