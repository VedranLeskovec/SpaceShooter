package com.seminar.igra;


import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;

public class SpaceShooterIgra implements ApplicationListener {
	private WorldController worldController;
	private WorldRenderer worldRenderer;
	private boolean pauza;

	@Override
	public void create() {
	Gdx.app.setLogLevel(Application.LOG_DEBUG);
	Assets.instance.init(new AssetManager());
	worldController=new WorldController();
	worldRenderer= new WorldRenderer(worldController);
	pauza= false;
	}

	@Override
	public void resize(int width, int height) {
		worldRenderer.resize(width,height);
	}

	@Override
	public void render() {
		if(!pauza) {
			worldController.update(Gdx.graphics.getDeltaTime());
		}
		Gdx.gl.glClearColor(0,0,1,1);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		worldRenderer.render();
	}

	@Override
	public void pause() {
	pauza=true;
	}

	@Override
	public void resume() {
	pauza= false;
	}

	@Override
	public void dispose() {

		worldRenderer.dispose();
		Assets.instance.dispose();
	}
}
