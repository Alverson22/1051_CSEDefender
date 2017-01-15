package data;

import helpers.Music;
import helpers.StateManager;
import helpers.StateManager.GameState;

public class WaveManager {
	
	private float timeSinceLastWave, timeBetweenEnemies;
	private int waveNumber, enemiesPerWave;
	private Enemy[] enemyTypes;
	private Wave currentWave;
	
	
	public WaveManager(Enemy[] enemyTypes, float timeBetweenEnemies, int enemiesPerWave){
		this.enemyTypes = enemyTypes;
		this.timeBetweenEnemies = timeBetweenEnemies;
		this.enemiesPerWave = enemiesPerWave;
		this.timeSinceLastWave = 0;
		this.waveNumber = 0;
		
		this.currentWave = null;
		
		newWave();
	}
	public void update(){
		if(!currentWave.isCompleted())
			currentWave.update();
		else
			newWave();
	}
	public void newWave(){
		if(waveNumber < 2) {
			currentWave = new Wave(enemyTypes, timeBetweenEnemies, enemiesPerWave);
			waveNumber++;
			System.out.println("Beginning Wave " + waveNumber);
		}
		else if(waveNumber == 2) {
			Wave.boss = true;
			currentWave = new Wave(enemyTypes, timeBetweenEnemies, enemiesPerWave);
			waveNumber++;
			System.out.println("Beginning Wave " + waveNumber);
		}
		else {
			Music.victory();
			StateManager.setState(GameState.WIN);
		}
	}
	
	public Wave getCurrentWave()
	{
		return currentWave;
	}
	
	public int getWaveNumber(){
		return waveNumber;
	}
}
