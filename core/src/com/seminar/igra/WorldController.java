package com.seminar.igra;


import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ModelInfluencer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.seminar.igra.util.CameraHelper;
import com.seminar.igra.util.Constants;


/**
 * Created by GLaDOS on 25.9.2016..
 */
public class WorldController extends InputAdapter{
    public static final String TAG = WorldController.class.getName();
    public Sprite[] testSprites;
    public Level level;
    public CameraHelper cameraHelper;
    int mouseX;
    int mouseY;
    float x;
    float y;
    float rot;
    float rot2;


    public WorldController() {
        Gdx.input.setInputProcessor(this);
        init();
    }


    private void init() {
        cameraHelper=new CameraHelper();
        initTestObjects();
        level=new Level();
    }
    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.R)
        {
            init();
            Gdx.app.debug(TAG,"Igra resetirana");
        }
        else if(keycode== Input.Keys.ENTER){
            cameraHelper.setTarget(cameraHelper.hasTarget() ? null: level.svemirskiBrod);
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        mouseX= screenX-Gdx.graphics.getWidth()/2;
        mouseY= Gdx.graphics.getHeight()-screenY-Gdx.graphics.getHeight()/2;
        mouseX = mouseX* 15/800;
        mouseY= mouseY*15/480;
        x=mouseX-level.svemirskiBrod.position.x;
        y=mouseY-level.svemirskiBrod.position.y;
        rot= MathUtils.radiansToDegrees*MathUtils.atan2(y,x);
        Gdx.app.debug(TAG,""+mouseX+" "+mouseY+" "+level.svemirskiBrod.position.x+" "+level.svemirskiBrod.position.y+" "+rot+" "+x+" "+y);
        level.svemirskiBrod.rotacija = rot-90;
        float delta= Gdx.graphics.getDeltaTime();
        level.svemirskiBrod.smjerKretanja.x= (mouseX-level.svemirskiBrod.position.x)*delta;
        level.svemirskiBrod.smjerKretanja.y= (mouseY-level.svemirskiBrod.position.y)*delta;
        level.svemirskiBrod.position.x +=level.svemirskiBrod.smjerKretanja.x*0.5;
        level.svemirskiBrod.position.y +=level.svemirskiBrod.smjerKretanja.y*0.5;

        return super.touchDragged(screenX, screenY, pointer);
    }

    //@Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        mouseX= screenX-Gdx.graphics.getWidth()/2+(int)level.svemirskiBrod.position.x;
        mouseY= Gdx.graphics.getHeight()-screenY-Gdx.graphics.getHeight()/2+(int)level.svemirskiBrod.position.y;
        mouseX = mouseX* 15/800;
        mouseY= mouseY*15/480;

        x=mouseX-level.svemirskiBrod.position.x;
        y=mouseY-level.svemirskiBrod.position.y;

        float delta= Gdx.graphics.getDeltaTime();
        level.svemirskiBrod.smjerKretanja.x= (mouseX-level.svemirskiBrod.position.x)*delta;
        level.svemirskiBrod.smjerKretanja.y= (mouseY-level.svemirskiBrod.position.y)*delta;
        level.svemirskiBrod.position.x +=level.svemirskiBrod.smjerKretanja.x;
        level.svemirskiBrod.position.y +=level.svemirskiBrod.smjerKretanja.y;
        Gdx.app.debug(TAG,""+level.svemirskiBrod.smjerKretanja.x+" "+level.svemirskiBrod.smjerKretanja.y);
        return super.touchDown(screenX, screenY, pointer, button);

    }


    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        mouseX= screenX-Gdx.graphics.getWidth()/2;
        mouseY= Gdx.graphics.getHeight()-screenY-Gdx.graphics.getHeight()/2;
        mouseX = mouseX*15/800;
        mouseY= mouseY*15/480;
        x=mouseX-level.svemirskiBrod.position.x;
        y=mouseY-level.svemirskiBrod.position.y;
        rot= MathUtils.radiansToDegrees*MathUtils.atan2(y,x);
        Gdx.app.debug(TAG,""+mouseX+" "+mouseY+" "+level.svemirskiBrod.position.x+" "+level.svemirskiBrod.position.y+" "+rot+" "+x+" "+y);
        float deltaTime=Gdx.graphics.getDeltaTime();
        level.svemirskiBrod.rotacija = rot-90;
        return super.mouseMoved(screenX,screenY);
    }



    private void handleDebugInput(float deltaTime) {

        if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
            float cameraZoomSpeed = 1 * deltaTime;
            float cameraZoomSpeedAccelerationFactor = 5;
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
                cameraZoomSpeed = cameraZoomSpeed * cameraZoomSpeedAccelerationFactor;
            if (Gdx.input.isKeyPressed(Input.Keys.COMMA))
                cameraHelper.addZoom(cameraZoomSpeed);
            if (Gdx.input.isKeyPressed(Input.Keys.PERIOD))
                cameraHelper.addZoom(-cameraZoomSpeed);
            if (Gdx.input.isKeyPressed(Input.Keys.M))
                cameraHelper.setZoom(1);
        }

        if(Gdx.input.isTouched()){
            mouseX= Gdx.input.getX()-Gdx.graphics.getWidth()/2;
            mouseY= Gdx.graphics.getHeight()-Gdx.input.getY()-Gdx.graphics.getHeight()/2;
            
            x=mouseX-level.svemirskiBrod.position.x;
            y=mouseY-level.svemirskiBrod.position.y;

            Gdx.app.debug(TAG,""+mouseX+" "+mouseY+" "+level.svemirskiBrod.position.x+" "+level.svemirskiBrod.position.y+" "+rot+" "+x+" "+y);
            float delta= Gdx.graphics.getDeltaTime();
            level.svemirskiBrod.smjerKretanja.x= (mouseX-level.svemirskiBrod.position.x)*delta;
            level.svemirskiBrod.smjerKretanja.y= (mouseY-level.svemirskiBrod.position.y)*delta;
            level.svemirskiBrod.position.x +=level.svemirskiBrod.smjerKretanja.x;
            level.svemirskiBrod.position.y +=level.svemirskiBrod.smjerKretanja.y;
        }

    }
    private void initTestObjects() {
       /*testSprites = new Sprite[5];
        Array<TextureRegion> regions= new Array<TextureRegion>();
        regions.add(Assets.instance.svemBrod.brod);
        regions.add(Assets.instance.meteori.meteor1);
        regions.add(Assets.instance.meteori.meteor2);
        regions.add(Assets.instance.meteori.meteor3);
        regions.add(Assets.instance.meteori.meteor4);
        regions.add(Assets.instance.pozadina.svemir);
        int width=32;
        int height=32;
        Pixmap pixmap = napPix(width,height);
        Texture texture= new Texture(pixmap);
        for(int i=0;i<testSprites.length;i++)
        {
            Sprite spr= new Sprite(regions.random());
            spr.setSize(1,1);
            spr.setOrigin(spr.getWidth()/2,spr.getHeight()/2);
            spr.setPosition(MathUtils.random(-2.0f,2.0f),MathUtils.random(-2.0f,2.0f));
            testSprites[i]=spr;
        }*/


    }

    private Pixmap napPix(int width, int height) {
        Pixmap pixmap= new Pixmap(width,height, Pixmap.Format.RGBA8888);
        pixmap.setColor(1,0,0,0.5f);
        pixmap.fill();
        pixmap.setColor(1,1,0,1);
        pixmap.drawLine(0,0,width,height);
        pixmap.drawLine(width,0,0,height);
        pixmap.setColor(0,1,1,1);
        pixmap.drawRectangle(0,0,width,height);
        return pixmap;
    }


    public void update(float deltaTime) {
        handleDebugInput(deltaTime);
        level.meteori.update(deltaTime);
        cameraHelper.update(deltaTime);
    }
}

