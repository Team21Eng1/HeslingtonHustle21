package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.HesHustle;

public class GameObject {
    public Vector2 pos;
    public final Rectangle bounds;

    /**The constructor for GameObject
     *
     * @param y      The float Y coordinate of the GameObject
     * @param x      The float X coordinate of the GameObject
     * @param width  The float width of the GameObject
     * @param height The float height of the GameObject
     */
    public GameObject (float x, float y, float width, float height) {
        this.pos = new Vector2(x, y);
        this.bounds = new Rectangle(x - width / 2, y - height / 2, width, height);
    }
    public void update(float delta){

    }

    public void render(Matrix4 projection, HesHustle game, ShapeRenderer shape) {

    }
    public void Dispose(){

    }
}
