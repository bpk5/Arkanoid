package com.bartekbpk.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Button;


/**
 * Created by Bartlomiej Kulesa on 21.07.17.
 */

public abstract class AbstractLhRhButton extends Button {

    protected final static float WIDTH = 100;
    protected final static float HEIGHT = 100;

    public AbstractLhRhButton(float x, float y) {
        super(new Button.ButtonStyle());
        initial(x, y);
    }


    private void initial(float x, float y) {
        this.setWidth(WIDTH);
        this.setHeight(HEIGHT);
        this.setPosition(x, y);

        this.setDebug(true);
    }

}
