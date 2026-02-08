package io.github.ness_reverdy.items.weapon.stone;

import io.github.ness_reverdy.items.weapon.common.WeaponBuilder;

public class StoneBuilder extends WeaponBuilder<StoneBuilder> {

    @Override
    protected StoneBuilder self() {
        return this;
    }

    public Stone build(){
        return new Stone(this);
    }
}
