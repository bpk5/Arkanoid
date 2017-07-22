package com.bartekbpk.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.bartekbpk.game.Arkanoid;

/**
 * Created by Bartlomiej Kulesa on 15.07.17.
 */

public class SplachScreen extends AbstractScreen {

    private Texture splashImg;

    public SplachScreen(final Arkanoid game) {
        super(game);

        initial();

        // Timer - uruchamia metodę run po 1 s.
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                game.setScreen(new MenuScreen(game));
            }
        }, 2);
    }

    private void initial() {
        splashImg = new Texture("bgdSplach.png");
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        spriteBatch.begin();
        spriteBatch.draw(splashImg, 0, 0);
        spriteBatch.end();
    }
}
