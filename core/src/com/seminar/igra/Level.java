package com.seminar.igra;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.seminar.igra.SvemirskiBrod;
/**
 * Created by GLaDOS on 28.9.2016..
 */
public class Level {

    public Meteori meteori;
    public SvemirskiBrod svemirskiBrod;
    public Pozadina pozadina;
    public Level(){
        init();
    }

    private void init() {
        meteori = new Meteori();
        svemirskiBrod= new SvemirskiBrod();
        pozadina= new Pozadina();
    }
    public void render(SpriteBatch batch){

    svemirskiBrod.render(batch);
    meteori.render(batch);
    }
}
