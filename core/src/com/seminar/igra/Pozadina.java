package com.seminar.igra;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by GLaDOS on 28.9.2016..
 */
public class Pozadina extends AbstractGameObject {
    private TextureRegion regSvem;

    public Pozadina(){
        init();
    }

    private void init() {
        dimension.set(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        regSvem=Assets.instance.pozadina.svemir;
        bounds.set(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

    }

    @Override
    public void render(SpriteBatch batch) {
        TextureRegion reg=null;
        reg=regSvem;
        batch.draw(reg.getTexture(),-10,-10,dimension.x,dimension.y);
    }
}
