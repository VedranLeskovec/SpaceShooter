package com.seminar.igra;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by GLaDOS on 28.9.2016..
 */
public abstract class AbstractGameObject {
    public Vector2 position;
    public Vector2 dimension;
    public Vector2 scale;
    public float rotacija;

    public float rot;
    public Vector2 origin;
    public Vector2 smjerKretanja;
    public Vector2 brzina;
    public Vector2 terminalnaBrzina;
    public Rectangle bounds;

    public AbstractGameObject(){
        position= new Vector2();
        dimension= new Vector2();
        scale= new Vector2();
        rotacija=0;
        origin= new Vector2();
        smjerKretanja= new Vector2();
        brzina= new Vector2();
        terminalnaBrzina= new Vector2();
        bounds= new Rectangle();
    }

    public void update(float deltaTime){


    }
    public abstract void render(SpriteBatch batch);
}
