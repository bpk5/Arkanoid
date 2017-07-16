package com.bartekbpk.screens;

import com.bartekbpk.entities.Player;
import com.bartekbpk.game.Arkanoid;

/**
 * Created by Bartlomiej Kulesa on 15.07.17.
 */

public class MenuScreen extends AbstractScreen {

    private Player player;

    public MenuScreen(Arkanoid game) {
        super(game);

        initial();
    }

    private void initial() {
        initPlayer();
    }

    private void initPlayer() {
        player = new Player();
        stage.addActor(player);
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
}
