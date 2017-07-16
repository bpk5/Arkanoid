package com.bartekbpk.game;

import com.badlogic.gdx.Game;
import com.bartekbpk.screens.SplachScreen;

public class Arkanoid extends Game {

	public final static String GAME_NAME = "Arkanoid";

	public final static int WIDTH = 480;
	public final static int HEIGHT = 700;

	private boolean paused;

	@Override
	public void create () {

		// To splachScrean we pass this object.
		this.setScreen(new SplachScreen(this));
	}


	// ****************** Getters and setters **********************

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}
}
