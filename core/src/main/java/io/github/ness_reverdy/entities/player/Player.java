package io.github.ness_reverdy.entities.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import io.github.ness_reverdy.entities.common.Entity;
import io.github.ness_reverdy.entities.enemy.Enemy;
import io.github.ness_reverdy.items.weapon.common.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {
    private final PlayerController controller;
    private float attackCooldown = 0;
    private boolean attackedThisFrame = false;
    private Enemy enemy;
    private List<Weapon> weapons = new ArrayList<>();
    private Weapon currentWeapon;

    public Player(PlayerBuilder playerBuilder) {
        super(playerBuilder);
        controller = new PlayerController();
    }

    @Override
    public void update(float delta){
        attackedThisFrame = false;

        controller.move(this, enemy, bounds, delta);

        attackCooldown -= delta;

        if(currentWeapon != null && Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            attack();
            attackedThisFrame = true;
        }
    }

    public void setEnemy(Enemy enemy){
        this.enemy = enemy;
    }

    public boolean didAttackThisFrame(){
        return attackedThisFrame;
    }

    public boolean isAttacking(){
        return attackCooldown > 0;
    }

    public void attack(){
        if(currentWeapon != null && enemy != null){
            currentWeapon.hit(this, enemy);
        }
        attackCooldown = 0.3f;
    }

    public List<Weapon> getWeapons(){ return weapons; }
    public Weapon getCurrentWeapon(){ return currentWeapon; }
    public void setCurrentWeapon(Weapon weapon){ this.currentWeapon = weapon; }
    public PlayerController getController(){ return controller; }
    public void addWeapon(Weapon weapon){
        weapons.add(weapon);
        if(currentWeapon == null) currentWeapon = weapon;
    }
}
