package data;

import static helpers.Artist.DrawQuadTex;
import static helpers.Artist.HEIGHT;
import static helpers.Artist.QuickLoad;
import static helpers.Artist.WIDTH;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import UI.UI;
import helpers.StateManager;
import helpers.StateManager.GameState;

public class Lose {
	
	private Texture background;
	private UI loseUI;

	public Lose(){
		background = QuickLoad("lose");
		loseUI = new UI();
	}
	
	public void updateState() {
		if(Mouse.isButtonDown(0))
			StateManager.setState(GameState.MAINMENU);
	}
	
	public void update(){
		DrawQuadTex(background, 0, 0, 2048, 1024);
		loseUI.draw();
		updateState();
	}
}
