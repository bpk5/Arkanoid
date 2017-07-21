package com.bartekbpk.entities;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.bartekbpk.game.Arkanoid;

/**
 * Created by Bartlomiej Kulesa on 21.07.17.
 */

public class Ball extends Image {

    private Rectangle rectangle;

    private final static int WIDTH = 10;

    private final static int HEIGHT = 10;
    public Ball(Texture texture, float y) {
        super(texture);

        this.setOrigin(WIDTH / 2, HEIGHT / 2);
        this.setSize(WIDTH, HEIGHT);

        this.setPosition((Arkanoid.WIDTH / 2) - (WIDTH / 2), y);

        rectangle = new Rectangle();
        updateRectangle();
        rectangle.setWidth(WIDTH);
        rectangle.setHeight(HEIGHT);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void updateRectangle() {
        rectangle.setPosition(this.getX(), this.getY());
    }
}
