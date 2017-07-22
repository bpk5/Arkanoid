package com.bartekbpk.screens;

/**
 * Created by Bartlomiej Kulesa on 15.07.17.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.bartekbpk.entities.Ball;
import com.bartekbpk.entities.PlayerPaddle;
import com.bartekbpk.game.Arkanoid;
import com.bartekbpk.ui.Column;
import com.bartekbpk.ui.GoButton;
import com.bartekbpk.ui.IClickCallback;
import com.bartekbpk.ui.LhRhButton;

/**
 * Po tej klasie dziedziczą wszystkie screeny.
 * Kod do zaimplementowania w innych projektach.
 */
public abstract class AbstractScreen implements Screen {

    public final static float MARGIN = 20;
    protected final static float minPaddleX = 150;

    protected PlayerPaddle playerPaddle;
    protected Column leftColumn;

    protected Column rightColumn;
    protected Column topColumn;
    protected Ball ball;
    protected LhRhButton leftButton;

    protected LhRhButton rightButton;

    protected GoButton goButton;

    protected boolean go; // Game run
    protected float stepBallX;
    protected float stepBallY;

    protected float speedPaddle;
    protected float maxPaddleX;

    protected Arkanoid game;

    protected Stage stage; // Scenes for actors.
    private OrthographicCamera camera;
    protected SpriteBatch spriteBatch;

    private Texture leftColumnTexture;
    private Texture rightColumnTexture;
    private Texture topColumnTexture;
    private Texture ballTexture;
    private Texture paddleTexture;

    public AbstractScreen(Arkanoid game) {
        this.game = game;

        stepBallX = 100;
        stepBallY = 100;
        speedPaddle = 200;
        go = false;

        createCamera();

        stage = new Stage(new StretchViewport(Arkanoid.WIDTH, Arkanoid.HEIGHT, camera));
        spriteBatch = new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
    }

    private void createCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Arkanoid.WIDTH, Arkanoid.HEIGHT);
        camera.update();
    }

    protected void initialBasicObject() {

        loadImage();

        playerPaddle = new PlayerPaddle(paddleTexture);
        stage.addActor(playerPaddle);
        maxPaddleX = Arkanoid.WIDTH - 150 - playerPaddle.getWidth();

        leftColumn = new Column(leftColumnTexture, 150, 540, 0,0);
        stage.addActor(leftColumn);

        rightColumn = new Column(rightColumnTexture, 150, 540, 810,0);
        stage.addActor(rightColumn);

        topColumn = new Column(topColumnTexture, 660, 20, 150, 520);
        stage.addActor(topColumn);

        ball = new Ball(ballTexture, playerPaddle.getHeight() + playerPaddle.getY());
        stage.addActor(ball);

        leftButton = new LhRhButton(1 + MARGIN, MARGIN);
        stage.addActor(leftButton);

        rightButton = new LhRhButton(Arkanoid.WIDTH - 100 - MARGIN, MARGIN);
        stage.addActor(rightButton);

        goButton = new GoButton(new IClickCallback() {
            @Override
            public void onClick() {
                go = true;
            }
        });
        stage.addActor(goButton);
    }

    protected void loadImage() {
        leftColumnTexture = new Texture("splachScreen.png");
        rightColumnTexture = new Texture("splachScreen.png");
        topColumnTexture = new Texture("splachScreen.png");
        ballTexture = new Texture("ball.png");
        paddleTexture = new Texture("paddle.png");
    }

    protected void collisionDetectionWall() {
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

    protected void runBall(float delta) {
        if (!go) {
            ball.setX(playerPaddle.getX() + playerPaddle.getWidth() / 2 - ball.getWidth() / 2);
            ball.updateRectangle();
        } else {
            ball.moveBy(stepBallX * delta, stepBallY * delta);
            ball.updateRectangle();
        }
    }

    protected void touchedLeftRight(float delta) {

        int touchX = Gdx.input.getX();
        int touchY = Arkanoid.HEIGHT - Gdx.input.getY();

        if ((touchX < (leftButton.getX() + leftButton.getWidth())) &&
                (touchY < (leftButton.getY() + leftButton.getHeight())) &&
                (playerPaddle.getX() > minPaddleX)) {

            playerPaddle.moveBy(-speedPaddle * delta, 0);
            playerPaddle.updateRectangle();
        }

        if ((touchX > rightButton.getX()) &&
                (touchY < (rightButton.getY() + rightButton.getHeight())) &&
                (playerPaddle.getX() < maxPaddleX)) {

            playerPaddle.moveBy(speedPaddle * delta, 0);
            playerPaddle.updateRectangle();
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        clearScreen();
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resume() {
        System.out.println("resume");
        game.setPaused(false);
    }

    @Override
    public void pause() {
        System.out.println("pause");
        game.setPaused(true);
    }

    @Override
    public void hide() {

    }

    @Override
    public void resize(int width, int height) {
        System.out.println("resize");
    }

    @Override
    public void dispose() {
        System.out.println("dispose");
        game.dispose();
    }
}
