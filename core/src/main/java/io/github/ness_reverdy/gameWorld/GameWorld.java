package io.github.ness_reverdy.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import io.github.ness_reverdy.entities.enemy.EnemyBuilder;
import io.github.ness_reverdy.entities.enemy.Enemy;
import io.github.ness_reverdy.entities.player.Player;
import io.github.ness_reverdy.entities.player.PlayerBuilder;
import io.github.ness_reverdy.items.weapon.stone.Stone;
import io.github.ness_reverdy.items.weapon.stone.StoneBuilder;

public class GameWorld {
    private Stone stone;
    private Player player;
    private Enemy enemy;
    private SpriteBatch batch;
    private Stage stage;
    private ShapeRenderer shapeRenderer;
    GameWorldController gameWorldController;

    public void create(){
        stone = new StoneBuilder()
            .position(200, 150)
            .size(50, 50)
            .attackRange(100)
            .damage(10)
            .texture("stone.png")
            .build();
        enemy = new EnemyBuilder()
            .position(600, 500)
            .size(60, 60)
            .speed(70)
            .health(100)
            .texture("enemy.png")
            .build();
        player = new PlayerBuilder()
            .position(100, 100)
            .size(60, 60)
            .speed(200)
            .health(100)
            .texture("player.png")
            .build();

        player.setEnemy(enemy);
        enemy.setTarget(player);

        batch = new SpriteBatch();
        stage = new Stage();
        shapeRenderer = new ShapeRenderer();
        gameWorldController = new GameWorldController();
        gameWorldController.addBackground("back.jpg", stage);
        gameWorldController.addExitButton("exit.png", stage);

        InputMultiplexer mux = new InputMultiplexer();
        mux.addProcessor(stage);
        mux.addProcessor(player.getController());
        Gdx.input.setInputProcessor(mux);
    }

    public void render(){
        float delta = Gdx.graphics.getDeltaTime();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        player.update(delta);
        enemy.update(delta);
        stone.update(player);

        stage.act(delta);
        stage.draw();

        batch.begin();
        stone.render(batch);
        enemy.render(batch);
        player.render(batch);
        batch.end();

        gameWorldController.addHealthBar(player, 20, 40, shapeRenderer);
        gameWorldController.addHealthBar(enemy,  20, 90, shapeRenderer);
    }

    public void dispose(){
        shapeRenderer.dispose();
        batch.dispose();
        enemy.dispose();
        stone.dispose();
        player.dispose();
    }
}
