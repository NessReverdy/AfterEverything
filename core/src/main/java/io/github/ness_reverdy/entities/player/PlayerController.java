package io.github.ness_reverdy.entities.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import io.github.ness_reverdy.entities.enemy.Enemy;

public class PlayerController implements InputProcessor {

    public void move(Player player, Enemy enemy, Rectangle bounds, float delta){
        float oldX = player.getX();
        float oldY = player.getY();

        float x = oldX;
        float y = oldY;

        float speed = player.getSpeed();

        if (Gdx.input.isKeyPressed(Input.Keys.W)) y += speed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) y -= speed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) x -= speed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) x += speed * delta;

        x = MathUtils.clamp(x, 0, Gdx.graphics.getWidth() - player.getWidth());
        y = MathUtils.clamp(y, 0, Gdx.graphics.getHeight() - player.getHeight());

        bounds.setPosition(x, y);

        if(bounds.overlaps(enemy.getBounds())){
            bounds.setPosition(oldX, oldY);
            player.setPosition(oldX, oldY);
        } else {
            player.setPosition(x, y);
        }
    }

    @Override public boolean keyDown(int keycode) { return false; }
    @Override public boolean keyUp(int keycode) { return false; }
    @Override public boolean keyTyped(char character) { return false; }
    @Override public boolean touchDown(int screenX, int screenY, int pointer, int button) { return false; }
    @Override public boolean touchUp(int screenX, int screenY, int pointer, int button) { return false; }
    @Override public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }
    @Override public boolean touchDragged(int screenX, int screenY, int pointer) { return false; }
    @Override public boolean mouseMoved(int screenX, int screenY) { return false; }
    @Override public boolean scrolled(float amountX, float amountY) { return false; }

}
