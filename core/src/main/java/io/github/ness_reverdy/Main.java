package io.github.ness_reverdy;

import com.badlogic.gdx.ApplicationAdapter;
import io.github.ness_reverdy.gameWorld.GameWorld;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    GameWorld gameWorld;

    @Override
    public void create() {
        gameWorld = new GameWorld();
        gameWorld.create();
    }

    @Override
    public void render() {
        gameWorld.render();
    }

    @Override
    public void dispose() {
        gameWorld.dispose();
    }
}
