package com.mygdx.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.mygdx.game.HesHustle;

import java.util.Random;

/**
 * Basic Building object the player can interact with
 * Basic Red Square but easily changed, String name is public so accessed by GameScreen
 */
public class Building extends GameObject{
    public String name;


    public Building(float x, float y, float width, float height,String name) {
        super(x, y, width, height);
        this.name = name;

    }

    public void update(float delta)
    {
        super.update(delta);

    }

    @Override
    public void render(Matrix4 projection, HesHustle game, ShapeRenderer shape) {
        shape.setProjectionMatrix(projection);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.RED);
        shape.rect(pos.x, pos.y, 100, 100);
        shape.end();

        game.batch.begin();
        game.font.draw(game.batch, name, pos.x+3, pos.y +bounds.height-3);
        game.batch.end();
    }
    @Override
    public void Dispose() {

    }
}
