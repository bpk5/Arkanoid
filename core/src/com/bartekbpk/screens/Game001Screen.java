package com.bartekbpk.screens;

import com.badlogic.gdx.Gdx;
import com.bartekbpk.entities.PlayerPaddle;
import com.bartekbpk.game.Arkanoid;
import com.bartekbpk.ui.LeftButton;
import com.bartekbpk.ui.RightButton;

/**
 * Created by Bartlomiej Kulesa on 18.07.17.
 */

public class Game001Screen extends AbstractScreen {

    private boolean goLeft;
    private boolean goRight;

    private float speedPaddle;
    private final static int minPaddleX = 150;
    private int maxPaddleY;

    private PlayerPaddle playerPaddle;
    private LeftButton leftButton;
    private RightButton rightButton;

    public Game001Screen(Arkanoid game) {
        super(game);

        initial();
    }

    private void initial() {
        goLeft = false;
        goRight = false;
        speedPaddle = 10;

        playerPaddle = new PlayerPaddle();
        stage.addActor(playerPaddle);
        maxPaddleY = Arkanoid.WIDTH - 150 - (int)playerPaddle.getWidth();

        leftButton = new LeftButton();
        stage.addActor(leftButton);

        rightButton = new RightButton();
        stage.addActor(rightButton);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();

        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void update() {
        boolean isTouched = Gdx.input.isTouched();

        if (isTouched) {
            int touchX = Gdx.input.getX();
            int touchY = Arkanoid.HEIGHT - Gdx.input.getY();

            if (touchX < leftButton.getX() + leftButton.getWidth() &&
                    touchY < leftButton.getY() + leftButton.getHeight() &&
                    playerPaddle.getX() > minPaddleX) {
                playerPaddle.moveBy(-speedPaddle, 0);
            }

            if (touchX > rightButton.getX() &&
                    touchY < rightButton.getY() + rightButton.getHeight() &&
                    playerPaddle.getX() < maxPaddleY) {
                playerPaddle.moveBy(speedPaddle, 0);
            }
        }
    }
}
