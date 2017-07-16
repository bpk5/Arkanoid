package com.bartekbpk.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.bartekbpk.game.Arkanoid;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = Arkanoid.GAME_NAME;
		config.width = Arkanoid.WIDTH;
		config.height = Arkanoid.HEIGHT;
		config.resizable = false;

		new LwjglApplication(new Arkanoid(), config);
	}
}
