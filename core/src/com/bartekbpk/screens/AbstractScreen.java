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
import com.bartekbpk.game.Arkanoid;

/**
 * Po tej klasie dziedziczą wszystkie screeny.
 * Kod do zaimplementowania w innych projektach.
 */
public abstract class AbstractScreen implements Screen {

    protected Arkanoid game;

    protected Stage stage; // Scenes for actors.
    private OrthographicCamera camera;

    protected SpriteBatch spriteBatch;

    public AbstractScreen(Arkanoid game) {
        this.game = game;
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
