package com.seminar.igra;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by GLaDOS on 28.9.2016..
 */
public class SvemirskiBrod extends AbstractGameObject {
    public static final String TAG= SvemirskiBrod.class.getName();
    private TextureRegion regBrod;
    public SvemirskiBrod(){
        init();
    }

    @Override
    public void update(float deltaTime) {
        brzina.x += smjerKretanja.x*deltaTime;
        brzina.y += smjerKretanja.y*deltaTime;

    }

    private void init() {
        dimension.set(1,1);
        scale.set(1,1);
        regBrod=Assets.instance.svemBrod.brod;
        origin.set(dimension.x/2,dimension.y/2);
        bounds.set(0,0,dimension.x,dimension.y);
        terminalnaBrzina.set(2.0f,2.0f);
        position.set(0,0);
        rotacija=0;

    }

    @Override
    public void render(SpriteBatch batch) {
        TextureRegion reg= null;
        reg=regBrod;
        batch.draw(reg.getTexture(),position.x,position.y,origin.x,origin.y,
                dimension.x,dimension.y,
                scale.x,scale.y,
                rotacija,
                reg.getRegionX(),reg.getRegionY(),
                reg.getRegionWidth(),reg.getRegionHeight(),
                false,false);
    }
}
