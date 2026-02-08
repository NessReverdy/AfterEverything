package io.github.ness_reverdy.items.weapon.common;

public abstract class WeaponBuilder<T extends WeaponBuilder<T>> {
    public float x, y, attackRange, damage, width, height;
    public String texturePath;

    public T position(float x, float y) {
        this.x = x;
        this.y = y;
        return self();
    }

    public T size(float width, float height) {
        this.width = width;
        this.height = height;
        return self();
    }

    public T attackRange(float attackRange){
        this.attackRange = attackRange;
        return self();
    }

    public T damage(float damage) {
        this.damage = damage;
        return self();
    }

    public T texture(String texturePath) {
        this.texturePath = texturePath;
        return self();
    }

    protected abstract T self();
}
