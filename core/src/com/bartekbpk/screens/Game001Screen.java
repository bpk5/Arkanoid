package com.bartekbpk.screens;

import com.badlogic.gdx.Gdx;
import com.bartekbpk.entities.Ball;
import com.bartekbpk.entities.PlayerPaddle;
import com.bartekbpk.game.Arkanoid;
import com.bartekbpk.ui.LeftButton;
import com.bartekbpk.ui.RightButton;

/**
 * Created by Bartlomiej Kulesa on 18.07.17.
 */

public class Game001Screen extends AbstractScreen {

    private boolean run; // Game run

    private float speedPaddle;
    private final static float minPaddleX = 150;
    private float maxPaddleY;

    private PlayerPaddle playerPaddle;
    private Ball ball;
    private LeftButton leftButton;
    private RightButton rightButton;

    public Game001Screen(Arkanoid game) {
        super(game);

        initial();
    }

    private void initial() {
        speedPaddle = 10;
        run = false;

        playerPaddle = new PlayerPaddle();
        stage.addActor(playerPaddle);
        maxPaddleY = Arkanoid.WIDTH - 150 - playerPaddle.getWidth();

        ball = new Ball(playerPaddle.getHeight() + playerPaddle.getY());
        stage.addActor(ball);

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
            touched();
            runBall();
        }
    }

    private void runBall() {
        if (!run) {
            ball.setX(playerPaddle.getX() + playerPaddle.getWidth() / 2 - ball.getWidth() / 2);
        }
    }

    private void touched() {

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
