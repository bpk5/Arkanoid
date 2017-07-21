package com.bartekbpk.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.bartekbpk.game.Arkanoid;

/**
 * Created by Bartlomiej Kulesa on 18.07.17.
 */

public class NewGameButton extends Button {

    private final static int WIDTH = 300;
    private final static int HEIGHT = 80;

    private final static int Y = 400;

    public NewGameButton(final IClickCallback callback) {
        super(new ButtonStyle());

        initial(callback);
    }

    private void initial(final IClickCallback callback) {
        this.setWidth(WIDTH);
        this.setHeight(HEIGHT);
        this.setX(Arkanoid.WIDTH / 2 - WIDTH / 2);
        this.setY(Y);

        this.setDebug(true);

        this.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                callback.onClick();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private static ButtonStyle newGameButtonStyle() {
        // TODO: 18.07.17 add new button style
        ButtonStyle buttonStyle = new ButtonStyle();
        return buttonStyle;
    }
}
