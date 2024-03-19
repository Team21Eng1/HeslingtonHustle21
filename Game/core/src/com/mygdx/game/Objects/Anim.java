package com.mygdx.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Anim {
    int curFrame=0;
    private final Texture SprSheet;
    private final int frameNo;
    double time,frameTime;
    int frameStart,width,height;

    /** A constructor for the animation class, which is used to properly animate a spritesheet
     *
     * @param fps          The framerate of the animation
     * @param frameEnd     The frame in which the animation ends
     * @param frameStart   The integer of the frame which the animation starts
     * @param frameTot     The total number of animation frames
     * @param SprSheet     The spritesheet used for the respective animation
     */
    public Anim(Texture SprSheet, int frameStart, int frameEnd,int frameTot,int fps)
    {
        this.SprSheet = SprSheet;
        this.frameStart = frameStart;
        this.frameNo = frameEnd-frameStart;

        this.width = SprSheet.getWidth()/frameTot;
        this.height = SprSheet.getHeight();

        this.time = 0;
        this.frameTime= (double) 1 /fps;

    }
    /**
     * Returns the texture of the sprite at a specific point in the animation
     *
     * @param deltaTime  the time at which the texture needs to be selected
     * @return  a texture at the specific frametime
     */

    public TextureRegion GetFrame(float deltaTime)
    {
        if (time > frameTime) {
            time = 0;
            curFrame +=1;
            if (curFrame > frameNo-1){
                curFrame = 0;
            }
        }
        time += deltaTime;
        return new TextureRegion(SprSheet,width*(frameStart+curFrame),0,width,height);
    }
}
