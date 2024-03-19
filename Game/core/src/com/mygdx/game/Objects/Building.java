package com.mygdx.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.mygdx.game.HesHustle;

import java.util.Random;

public class Building extends GameObject{
    public String name;
    public Boolean interact;
    public BitmapFont font2;
    /** The constructor that creates a new building, a data stucture used to store a buildings name, position and if it has been interacted with
     *
     * @param height    The float representing building height
     * @param interact  The boolean representing if the building is interacted with
     * @param name      The string name of the building
     * @param width     The float width of the building
     * @param x         The float representing the x position of the building
     * @param y         The float representing the y position of the building
     */
    public Building(float x, float y, float width, float height,String name, Boolean interact) {
        super(x, y, width, height);
        this.name = name;
        this.interact = interact;
        font2 = new BitmapFont(Gdx.files.internal("font.fnt"));
    }
    /** a function that updates the value held in delta
     *
     * @param delta The float value delta
     */

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
        font2.draw(game.batch, name, pos.x+3, pos.y +bounds.height-3);
        game.batch.end();
    }

    public void event()
    {
        Gdx.app.log("hi",name);
    }
    @Override
    public void Dispose() {
        font2.dispose();
    }
}
