package io.github.ness_reverdy.entities.enemy;

import io.github.ness_reverdy.entities.common.EntityBuilder;

public class EnemyBuilder extends EntityBuilder<EnemyBuilder> {

    @Override
    protected EnemyBuilder self() {
        return this;
    }

    public Enemy build(){
        return new Enemy(this);
    }
}
