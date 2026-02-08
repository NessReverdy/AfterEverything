package io.github.ness_reverdy.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import io.github.ness_reverdy.entities.common.Entity;


public class GameWorldController {
    public void addExitButton (String pickPath, Stage stage){
        Texture exitTexture = new Texture(pickPath);
        Drawable drawable = new TextureRegionDrawable(new TextureRegion(exitTexture));
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.up = drawable;
        style.down = drawable;
        style.font = new BitmapFont();

        TextButton exitButton = new TextButton("", style);
        exitButton.setPosition(20, Gdx.graphics.getHeight() - exitButton.getHeight() - 20);

        exitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                Gdx.app.exit();
            }
        });

        stage.addActor(exitButton);
    }

    public void addBackground(String pickPath, Stage stage){
        Image bg = new Image(new Texture(pickPath));
        bg.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage.addActor(bg);
    }

    public void addHealthBar(Entity entity, float pozX, float pozY, ShapeRenderer shapeRenderer){
        float barWidth = 200;
        float barHeight = 20;
        float x = Gdx.graphics.getWidth() - barWidth - pozX;
        float y = Gdx.graphics.getHeight() - barHeight - pozY;

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0.8f, 0, 0, 1);
        shapeRenderer.rect(x, y, barWidth, barHeight);

        shapeRenderer.setColor(0, 1, 0, 1);
        shapeRenderer.rect(x, y, barWidth * entity.getHealthPercent(), barHeight);
        shapeRenderer.end();
    }
}
