package com.bartekbpk.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


/**
 * Created by Bartlomiej Kulesa on 21.07.17.
 */

public class Column extends Image {

    private Rectangle rectangle;

    public Column(String texture, float width, float height, float x, float y) {
        super(new Texture(texture));
//        this.height = texture.getHeight();
//        this.width = texture.getWidth();
        this.setSize(width, height);

        this.setPosition(x, y);

        rectangle = new Rectangle();
        updateRectangle();
        rectangle.setWidth(width);
        rectangle.setHeight(height);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void updateRectangle() {
        rectangle.setPosition(this.getX(), this.getY());
    }
}
