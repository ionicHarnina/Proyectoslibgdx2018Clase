package com.adorno.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.adorno.MyGdxGame;
import com.adorno.MyGdxGame2;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new MyGdxGame2(), config);
//		new LwjglApplication(new MyGdxGame(), config);
	}
}
