package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import version3.MyGdxGame3;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new MyGdxGame3(), config);
//		new LwjglApplication(new MyGdxGame2(), config);
//		new LwjglApplication(new MyGdxGame(), config);
	}
}
