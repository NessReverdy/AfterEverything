package io.github.ness_reverdy.entities.player;

import io.github.ness_reverdy.entities.common.EntityBuilder;

public class PlayerBuilder extends EntityBuilder<PlayerBuilder> {

    @Override
    protected PlayerBuilder self() {
        return this;
    }

    public Player build() {
        return new Player(this);
    }
}
