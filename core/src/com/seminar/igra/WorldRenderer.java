package com.seminar.igra;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;
import com.seminar.igra.util.Constants;



/**
 * Created by GLaDOS on 25.9.2016..
 */
public class WorldRenderer implements Disposable{
    private OrthographicCamera camera;
    private WorldController worldController;
    private SpriteBatch batch;

    public WorldRenderer (WorldController worldController){
        this.worldController=worldController;
        init();
    }

    private void init() {
        batch= new SpriteBatch();
        camera= new OrthographicCamera(Constants.VIEWPORT_WIDTH,Constants.VIEWPORT_HEIGHT);
        camera.position.set(0,0,0);
        camera.update();

    }
    public void render(){
    renderTestObjects();
    }

    private void renderTestObjects() {
        worldController.cameraHelper.applyTo(camera);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        worldController.level.render(batch);

        batch.end();
    }

    public void resize(int width, int height){
        camera.viewportWidth=(Constants.VIEWPORT_HEIGHT/height)*width;
        camera.update();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
