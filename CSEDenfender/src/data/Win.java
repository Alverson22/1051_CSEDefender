package data;

import static helpers.Artist.DrawQuadTex;
import static helpers.Artist.QuickLoad;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import UI.UI;
import helpers.StateManager;
import helpers.StateManager.GameState;

public class Win {

	private Texture background;
	private UI winUI;

	public Win(){
		background = QuickLoad("win");
		winUI = new UI();
	}
	
	public void updateState() {
		if(Mouse.isButtonDown(0))
			StateManager.setState(GameState.MAINMENU);
	}
	
	public void update(){
		DrawQuadTex(background, 0, 0, 2048, 1024);
		winUI.draw();
		updateState();
	}
}
