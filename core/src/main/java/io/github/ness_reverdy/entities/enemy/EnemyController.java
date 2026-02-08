package io.github.ness_reverdy.entities.enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import io.github.ness_reverdy.entities.player.Player;

public class EnemyController {
    public void move(Enemy enemy, Player player, float delta, Rectangle bounds) {
        float oldX = enemy.getX();
        float oldY = enemy.getY();

        float enemyX = oldX;
        float enemyY = oldY;

        float playerX = player.getX();
        float playerY = player.getY();

        if(playerX > enemyX) enemyX += enemy.getSpeed() * delta;
        if(playerX < enemyX) enemyX -= enemy.getSpeed() * delta;
        if(playerY > enemyY) enemyY += enemy.getSpeed() * delta;
        if(playerY < enemyY) enemyY -= enemy.getSpeed() * delta;

        enemyX = MathUtils.clamp(enemyX, 0, Gdx.graphics.getWidth() - enemy.getWidth());
        enemyY = MathUtils.clamp(enemyY, 0, Gdx.graphics.getHeight() - enemy.getHeight());

        bounds.setPosition(enemyX, enemyY);

        if (bounds.overlaps(player.getBounds())) {
            player.takeDamage(20 * delta);
            bounds.setPosition(oldX, oldY);
            enemy.setPosition(oldX, oldY);
        } else {
            enemy.setPosition(enemyX, enemyY);
        }
    }
}
