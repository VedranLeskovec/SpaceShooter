package com.seminar.igra;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Disposable;
import com.seminar.igra.util.Constants;

/**
 * Created by GLaDOS on 27.9.2016..
 */
public class Assets implements Disposable, AssetErrorListener {
    public static final String TAG = Assets.class.getName();
    public static final Assets instance = new Assets();
    private AssetManager assetManager;
    public AssetBrod svemBrod;
    public AssetMeteori meteor;
    public AssetPozadina pozadina;

    private Assets() {
    }

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.setErrorListener(this);
        assetManager.load(Constants.TEXTURE_ATLAS_OBJECT, TextureAtlas.class);
        assetManager.finishLoading();
        Gdx.app.debug(TAG, "# of assest loaded:" + assetManager.getAssetNames().size);
        for (String tmp : assetManager.getAssetNames())
            Gdx.app.debug(TAG, "Asset: " + tmp);

        TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS_OBJECT);
        for (Texture t : atlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }
        svemBrod=new AssetBrod(atlas);
        meteor=new AssetMeteori(atlas);
        pozadina= new AssetPozadina(atlas);
    }
    public class AssetBrod{
        public final AtlasRegion brod;
        public AssetBrod(TextureAtlas atlas) {
            brod= atlas.findRegion("playerShip1_blue");
        }
    }
    public class AssetPozadina{
        public final AtlasRegion svemir;
        public AssetPozadina(TextureAtlas atlas){ svemir= atlas.findRegion("purple");}
    }
    public class AssetMeteori{
        public final AtlasRegion meteor;

        public AssetMeteori(TextureAtlas atlas){
            meteor= atlas.findRegion("meteorBrown_big1");

        }
    }
    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG,"Nije moguce ucitati asset: "+
                asset.fileName+" "+
                throwable.getMessage());
    }

    @Override
    public void dispose() {
    assetManager.dispose();
    }
}
