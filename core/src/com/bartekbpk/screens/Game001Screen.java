package com.bartekbpk.screens;

import com.badlogic.gdx.Gdx;
import com.bartekbpk.game.Arkanoid;

/**
 * Created by Bartlomiej Kulesa on 18.07.17.
 */

public class Game001Screen extends AbstractScreen {

    public Game001Screen(Arkanoid game) {
        super(game);
        initial();
    }

    private void initial() {
        initialBasicObject();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void update(float delta) {
        boolean isTouched = Gdx.input.isTouched();

        if (isTouched) {
            touchedLeftRight(delta);
        }

        runBall(delta);
        collisionDetectionWall();
    }
}
