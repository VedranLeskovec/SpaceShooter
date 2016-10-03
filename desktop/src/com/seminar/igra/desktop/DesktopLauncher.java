package com.seminar.igra.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.seminar.igra.SpaceShooterIgra;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;


public class DesktopLauncher {
	public static boolean rebuildAtlas=true;
	public static boolean drawDebugOutline = true;
	public static void main (String[] arg) {
		if(rebuildAtlas){
			Settings settings= new Settings();
			settings.maxWidth=2048;
			settings.maxHeight=2048;
			settings.duplicatePadding=false;
			settings.debug=drawDebugOutline;
			TexturePacker.process(settings,
					"assets-raw/images",
					"../android/assets/images",
					"spaceshooter.atlas");
		}
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new SpaceShooterIgra(), config);
		config.width=800;
		config.height=480;
	}
}
