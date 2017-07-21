package com.bartekbpk.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.bartekbpk.game.Arkanoid;

/**
 * Created by Bartlomiej Kulesa on 21.07.17.
 */

public class Ball extends Image {

    private final static int WIDTH = 10;
    private final static int HEIGHT = 10;

    public Ball(float y) {
        super(new Texture("ball.png"));

        this.setOrigin(WIDTH / 2, HEIGHT / 2);
        this.setSize(WIDTH, HEIGHT);

        this.setPosition((Arkanoid.WIDTH / 2) - (WIDTH / 2), y);
    }
}
