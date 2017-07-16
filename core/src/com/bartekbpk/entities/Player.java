package com.bartekbpk.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Bartlomiej Kulesa on 16.07.17.
 */

public class Player extends Image {

    private final static int WIDTH = 77;
    private final static int HEIGHT = 100;

    private final static int STARTING_X = 200;
    private final static int STARTING_Y = 200;

    public Player() {
        super(new Texture("badlogic.jpg"));

        this.setOrigin(WIDTH / 2, HEIGHT / 2);
        this.setSize(WIDTH, HEIGHT);

        this.setPosition(STARTING_X, STARTING_Y);
    }
}
