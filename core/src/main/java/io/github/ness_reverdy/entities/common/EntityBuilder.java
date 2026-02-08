package io.github.ness_reverdy.entities.common;

public abstract class EntityBuilder<T extends EntityBuilder<T>> {
    public float x, y, speed, maxHealth, width, height;
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

    public T speed(float speed) {
        this.speed = speed;
        return self();
    }

    public T health(float maxHealth) {
        this.maxHealth = maxHealth;
        return self();
    }

    public T texture(String path) {
        this.texturePath = path;
        return self();
    }

    protected abstract T self();
}
