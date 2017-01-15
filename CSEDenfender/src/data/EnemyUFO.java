package data;


public class EnemyUFO extends Enemy{

	public EnemyUFO(int tileX, int tileY, TileGrid grid) {
		super(tileX, tileY, grid);
		this.setTexture("UFO64");
		this.setSpeed(200);
		this.setHealth(30);
	}

}
