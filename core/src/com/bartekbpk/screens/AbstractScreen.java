package com.bartekbpk.screens;

/**
 * Created by Bartlomiej Kulesa on 15.07.17.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
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

    protected final static float minPaddleX = 150;
    protected float maxPaddleX;


    protected Arkanoid game;

    public final static float MARGIN = 20;

    protected Stage stage; // Scenes for actors.
    private OrthographicCamera camera;

    protected SpriteBatch spriteBatch;

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
