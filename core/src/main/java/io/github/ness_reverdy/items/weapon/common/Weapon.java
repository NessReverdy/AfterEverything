package io.github.ness_reverdy.items.weapon.common;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import io.github.ness_reverdy.entities.enemy.Enemy;
import io.github.ness_reverdy.entities.player.Player;

public abstract class Weapon {
    protected float x, y, attackRange, damage, width, height;
    protected Texture texture;
    protected Rectangle bounds;
    protected boolean pickedUp = false;

    protected Weapon(WeaponBuilder<?> builder) {
        this.x = builder.x;
        this.y = builder.y;
        this.width = builder.width;
        this.height = builder.height;
        this.attackRange = builder.attackRange;
        this.damage = builder.damage;
        this.texture = new Texture(builder.texturePath);
        this.bounds = new Rectangle(x, y, width, height);
    }

    public void update(Player player) {
        if(!pickedUp && bounds.overlaps(player.getBounds())){
            pickedUp = true;
            player.addWeapon(this);
        }
    }

    public boolean isInRange(Player player, Enemy enemy){
        float dx = enemy.getX() - player.getX();
        float dy = enemy.getY() - player.getY();
        float distance = (float)Math.sqrt(dx*dx + dy*dy);
        return distance <= attackRange;
    }

    public void hit(Player player, Enemy enemy){
        if(isInRange(player, enemy)){
            enemy.takeDamage(damage);
        }
    }

    public void render(SpriteBatch batch){
        if(!pickedUp){
            batch.draw(texture, x, y, width, height);
        }
    }

    public void dispose(){
        texture.dispose();
    }
}
