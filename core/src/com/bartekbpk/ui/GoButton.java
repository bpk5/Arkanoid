package com.bartekbpk.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.bartekbpk.game.Arkanoid;
import com.bartekbpk.screens.AbstractScreen;

/**
 * Created by Bartlomiej Kulesa on 21.07.17.
 */

public class GoButton extends AbstractLhRhButton {

    private final static float X = Arkanoid.WIDTH - AbstractScreen.MARGIN - WIDTH;
    private final static float Y = AbstractScreen.MARGIN * 2 + HEIGHT;

    public GoButton(final IClickCallback callback) {
        super(X, Y);

        initialListener(callback);
    }

    private void initialListener(final IClickCallback callback) {
        this.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                callback.onClick();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }
}
