package io.github.ness_reverdy.entities.common;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Entity {
    protected float x, y, speed, maxHealth, currentHealth, width, height;
    protected Texture texture;
    protected Rectangle bounds;

    protected Entity(EntityBuilder<?> builder) {
        this.x = builder.x;
        this.y = builder.y;
        this.width = builder.width;
        this.height = builder.height;
        this.speed = builder.speed;
        this.maxHealth = builder.maxHealth;
        this.currentHealth = maxHealth;

        texture = new Texture(builder.texturePath);
        bounds = new Rectangle(x, y, width, height);
    }

    public abstract void update(float delta);

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height);
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
        bounds.setPosition(x, y);
    }

    public void takeDamage(float damage) {
        currentHealth -= damage;
        if (currentHealth < 0) currentHealth = 0;
    }

    public float getHealthPercent() {
        return maxHealth == 0 ? 0 : currentHealth / maxHealth;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose() {
        texture.dispose();
    }

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public void setX(float x) {
        this.x = x;
        bounds.x = x;
    }
    public void setY(float y) {
        this.y = y;
        bounds.y = y;
    }
    public float getSpeed(){ return speed; }
    public void setSpeed(float speed) {
        this.speed = speed;
    }
    public float getCurrentHealth() {
        return currentHealth;
    }
    public void setCurrentHealth(float health) {
        this.currentHealth = health;
    }
    public float getMaxHealth(){ return maxHealth; }
    public void setMaxHealth(float maxHealth){
        this.maxHealth = maxHealth;
    }
    public float getWidth(){ return width; }
    public float getHeight(){ return height; }
}
