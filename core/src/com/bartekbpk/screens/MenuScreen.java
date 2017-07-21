package com.bartekbpk.screens;

import com.badlogic.gdx.Gdx;
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

    public MenuScreen(Arkanoid game) {
        super(game);

        initial();
    }

    private void initial() {
        initNewGameButton();
    }

    private void initNewGameButton() {
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
    public void render(float delta) {
        super.render(delta);
        update();

        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void update() {

    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
