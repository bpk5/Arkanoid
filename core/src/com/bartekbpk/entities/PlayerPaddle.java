package com.bartekbpk.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.bartekbpk.game.Arkanoid;

/**
 * Created by Bartlomiej Kulesa on 16.07.17.
 */

public class PlayerPaddle extends Image {

    private final static int WIDTH = 60;
    private final static int HEIGHT = 17;

    private final static int STARTING_X = (Arkanoid.WIDTH / 2) - (WIDTH / 2);
    private final static int STARTING_Y = 50;

    public PlayerPaddle() {
        super(new Texture("paddle.png"));

        this.setOrigin(WIDTH / 2, HEIGHT / 2);
        this.setSize(WIDTH, HEIGHT);

        this.setPosition(STARTING_X, STARTING_Y);
    }
}
