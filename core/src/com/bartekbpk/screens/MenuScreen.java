package com.bartekbpk.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.bartekbpk.game.Arkanoid;
import com.bartekbpk.ui.ExitButton;
import com.bartekbpk.ui.IClickCallback;
import com.bartekbpk.ui.NewGameButton;

/**
 * Created by Bartlomiej Kulesa on 15.07.17.
 */

public class MenuScreen extends AbstractScreen {

    private NewGameButton newGameButton;
    private ExitButton exitButton;
    private Texture bgdTexture;
    private Image background;

    public MenuScreen(Arkanoid game) {
        super(game);

        initial();
    }

    private void initial() {
        initNewGameButton();
    }

    private void initNewGameButton() {
        loadImage();

        background = new Image(bgdTexture);
        background.setPosition(0, 0);
        stage.addActor(background);

        newGameButton = new NewGameButton(new IClickCallback() {
            @Override
            public void onClick() {
                game.setScreen(new Game001Screen(game));
            }
        });
        stage.addActor(newGameButton);

        exitButton = new ExitButton(new IClickCallback() {
            @Override
            public void onClick() {
                Gdx.app.exit();
            }
        });
        stage.addActor(exitButton);
    }

    @Override
    protected void loadImage() {
        bgdTexture = new Texture("bgdMenu.png");
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }
}
