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

    private void collisionDetectionWall() {
        if (ball.getRectangle().overlaps(leftColumn.getRectangle())) {
            stepBallX = -stepBallX;
        }

        if (ball.getRectangle().overlaps(rightColumn.getRectangle())) {
            stepBallX = -stepBallX;
        }

        if (ball.getRectangle().overlaps(topColumn.getRectangle())) {
            stepBallY = -stepBallY;
        }
    }

    private void runBall(float delta) {
        if (!go) {
            ball.setX(playerPaddle.getX() + playerPaddle.getWidth() / 2 - ball.getWidth() / 2);
            ball.updateRectangle();
        } else {
            ball.moveBy(stepBallX * delta, stepBallY * delta);
            ball.updateRectangle();
        }
    }

    private void touchedLeftRight(float delta) {

        int touchX = Gdx.input.getX();
        int touchY = Arkanoid.HEIGHT - Gdx.input.getY();

        if (touchX < leftButton.getX() + leftButton.getWidth() &&
                touchY < leftButton.getY() + leftButton.getHeight() &&
                playerPaddle.getX() > minPaddleX) {
            playerPaddle.moveBy(-speedPaddle * delta, 0);
        }

        if (touchX > rightButton.getX() &&
                touchY < rightButton.getY() + rightButton.getHeight() &&
                playerPaddle.getX() < maxPaddleX) {
            playerPaddle.moveBy(speedPaddle * delta, 0);
        }
    }
}
