package io.github.ness_reverdy.entities.enemy;

import io.github.ness_reverdy.entities.common.Entity;
import io.github.ness_reverdy.entities.player.Player;

public class Enemy extends Entity {
    private final EnemyController controller;
    private Player player;

    public Enemy(EnemyBuilder enemyBuilder){
        super(enemyBuilder);
        controller = new EnemyController();
    }

    @Override
    public void update(float delta) {
        controller.move(this, player, delta, bounds);
    }

    public void setTarget(Player player){
        this.player = player;
    }
}
