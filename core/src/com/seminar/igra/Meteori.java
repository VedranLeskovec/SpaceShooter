package com.seminar.igra;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

/**
 * Created by GLaDOS on 28.9.2016..
 */
public class Meteori extends AbstractGameObject {
    public static final String TAG= Meteori.class.getName();
    private TextureRegion regMeteor;


    public Meteori(){
        init();
    }

    @Override
    public void update(float deltaTime) {
        rotacija +=5*deltaTime;
    }


    private void init() {
        dimension.set(3,3);
        origin.set(dimension.x/2,dimension.y/2);
        position.set(2,2);
        scale.set(1,1);
        rotacija=0;
        bounds.set(0,0,dimension.x,dimension.y);
        regMeteor= Assets.instance.meteor.meteor;
    }

    @Override
    public void render(SpriteBatch batch) {
        TextureRegion reg= null;
        reg=regMeteor;
        batch.draw(reg.getTexture(),
                position.x,position.y,
                origin.x,origin.y,
                dimension.x,dimension.y,
                scale.x,scale.y,
                rotacija,
                reg.getRegionX(),reg.getRegionY(),
                reg.getRegionWidth(),reg.getRegionHeight(),
                false,false);

    }
}
