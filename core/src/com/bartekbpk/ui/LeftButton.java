package com.bartekbpk.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Button;

/**
 * Created by Bartlomiej Kulesa on 18.07.17.
 */

public class LeftButton extends Button {

    public LeftButton() {
        super(new Button.ButtonStyle());

        initial();
    }

    private void initial() {
        this.setWidth(100);
        this.setHeight(100);
        this.setX(1);
        this.setY(0);

        this.setDebug(true);
    }

    private static Button.ButtonStyle newGameButtonStyle() {
        // TODO: 18.07.17 add new button style
        Button.ButtonStyle buttonStyle = new Button.ButtonStyle();
        return buttonStyle;
    }
}
