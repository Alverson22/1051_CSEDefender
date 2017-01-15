package data;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import helpers.Clock;
import helpers.Music;
import helpers.StateManager;
import helpers.StateManager.GameState;

import static helpers.Artist.*;

import java.util.ArrayList;

public class Player {
 
	private TileGrid grid;
	private TileType[] types;
	private WaveManager waveManager;
	private ArrayList<Tower> towerList;
	private boolean leftMouseButtonDown, rightMouseButtonDown,holdingTower;
	private Tower tempTower;
	private int deadTime = 0;
	public static int Cash, Lives;
	
	public Player(TileGrid grid, WaveManager waveManager) {
		this.grid = grid;
		this.types = new TileType[12];
		this.types[0] = TileType.Grass;
		this.types[1] = TileType.Dirt;
		this.types[2] = TileType.Water;
		this.types[3] = TileType.castle1;
		this.types[4] = TileType.castle2;
		this.types[5] = TileType.castle3;
		this.types[6] = TileType.castle4;
		this.types[7] = TileType.castle5;
		this.types[8] = TileType.castle6;
		this.types[9] = TileType.castle7;
		this.types[10] = TileType.castle8;
		this.types[11] = TileType.castle9;
		this.waveManager = waveManager;
		this.towerList = new ArrayList<Tower>();
		this.leftMouseButtonDown = false;
		this.rightMouseButtonDown = false;
		this.holdingTower = false;
		this.tempTower = null;
		Cash = 0;
		Lives = 0;
	}
	
	public void setup() {
		Cash = 150;
		Lives = 3;
	}
	
	//Check if player can afford tower, if so: charge player tower cost
	public static boolean modifyCash(int amount) {
		if(Cash + amount >= 0) {
			Cash += amount;
			System.out.println(Cash);
			return true;
		}
		System.out.println(Cash);
		return false;
	}
	
	public static void modifyLives(int amount) {
		Lives += amount;
	}
	
	public void update() {
		gameOver();
		if(holdingTower){
			tempTower.setX(getMouseTile().getX());
			tempTower.setY(getMouseTile().getY());
			tempTower.draw();
		}
		
		for(Tower t : towerList)
		{
			t.update();
			t.draw();
			t.updateEnemyList(waveManager.getCurrentWave().getEnemiyList());
		}
		//Handle mouse input
		if(Mouse.isButtonDown(0) && !leftMouseButtonDown) {
			placeTower();
			Music.mouseClick();
		}
		
		if(Mouse.isButtonDown(1) && !rightMouseButtonDown) {
			System.out.println("Right Clicked");
		}
		
		leftMouseButtonDown = Mouse.isButtonDown(0);
		rightMouseButtonDown = Mouse.isButtonDown(1);
		
		//Handle keyboard input
		while (Keyboard.next()){
				if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) 
				{
					Clock.ChangeMultiplier(0.2f);
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()) 
				{
					Clock.ChangeMultiplier(-0.2f);
				}
		}
	}
	
	private void placeTower(){
		Tile currentTile = getMouseTile();
		if(holdingTower){
			if ( !currentTile.getOccupied() && modifyCash(tempTower.getCost())){
				towerList.add(tempTower);
				currentTile.setOccupied(true);
				holdingTower = false;
				tempTower = null;
			}
		}
	}
	
	public void pickTower(Tower t){
		tempTower = t;
		holdingTower =true;
	}
	
	public void gameOver() {
		if(Lives == 0 && deadTime == 0) {
			Lives = 0;
			Music.defeat();
			StateManager.setState(GameState.LOSE);
			deadTime++;
		}
		else if(Lives < 0)
			Lives = 0;
	}
	
	private Tile getMouseTile(){
		 return grid.getTile(Mouse.getX() / TILE_SIZE, (HEIGHT - Mouse.getY() - 1) / TILE_SIZE); 
	}
}
