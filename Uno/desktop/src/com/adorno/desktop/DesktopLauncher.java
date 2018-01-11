package com.adorno.desktop;

import com.adorno.MyGameRegion;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new MyGameRegion(), config);
//		new LwjglApplication(new MyGame(), config);
//		new LwjglApplication(new MyGdxGame(), config);
	}
}
