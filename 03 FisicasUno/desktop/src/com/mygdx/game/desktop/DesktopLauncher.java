package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.FisicasCinco;
import com.mygdx.game.FisicasCuatro;

import filtro.ManyBallsFilter;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//		new LwjglApplication(new CollisionUno(), config);
//		new LwjglApplication(new FisicasDos(), config);
//		new LwjglApplication(new FisicasTres(), config);
//		new LwjglApplication(new FisicasCuatro(), config);
//		new LwjglApplication(new FisicasCinco(), config);
		new LwjglApplication(new ManyBallsFilter(), config);
	}
}
