package com.bartekbpk.screens;

import com.badlogic.gdx.Gdx;
import com.bartekbpk.entities.Ball;
import com.bartekbpk.entities.PlayerPaddle;
import com.bartekbpk.game.Arkanoid;
import com.bartekbpk.ui.GoButton;
import com.bartekbpk.ui.IClickCallback;
import com.bartekbpk.ui.Column;
import com.bartekbpk.ui.LhRhButton;

/**
 * Created by Bartlomiej Kulesa on 18.07.17.
 */

public class Game001Screen extends AbstractScreen {

    private boolean go; // Game run

    private float stepBallX;
    private float stepBallY;

    private float speedPaddle;
    private final static float minPaddleX = 150;
    private float maxPaddleX;

    private Column leftColumn;
    private Column rightColumn;
    private Column topColumn;

    private PlayerPaddle playerPaddle;
    private Ball ball;
    private LhRhButton leftButton;
    private LhRhButton rightButton;
    private GoButton goButton;

    public Game001Screen(Arkanoid game) {
        super(game);

        initial();
    }

    private void initial() {
        stepBallX = 100;
        stepBallY = 100;

        speedPaddle = 200;
        go = false;

        playerPaddle = new PlayerPaddle();
        stage.addActor(playerPaddle);
        maxPaddleX = Arkanoid.WIDTH - 150 - playerPaddle.getWidth();

        leftColumn = new Column("splachScreen.png", 150, 540, 0,0);
        stage.addActor(leftColumn);

        rightColumn = new Column("splachScreen.png", 150, 540, 810,0);
        stage.addActor(rightColumn);

        topColumn = new Column("splachScreen.png", 660, 20, 150, 520);
        stage.addActor(topColumn);

        ball = new Ball(playerPaddle.getHeight() + playerPaddle.getY());
        stage.addActor(ball);

        leftButton = new LhRhButton(1 + Arkanoid.MARGIN, Arkanoid.MARGIN);
        stage.addActor(leftButton);

        rightButton = new LhRhButton(Arkanoid.WIDTH - 100 - Arkanoid.MARGIN, Arkanoid.MARGIN);
        stage.addActor(rightButton);

        goButton = new GoButton(new IClickCallback() {
            @Override
            public void onClick() {
                go = true;
            }
        });
        stage.addActor(goButton);
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
