package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

/*
 * Todos los elementos son actores. con comportamiento y con gestion de
 * eventos as� se mostraran mediante una evolucion de sucesos y temporal.
 * Todos parten de un Stage en el que se desarrollan y actualizan. No todos
 * los juegos se pueden hacer con Scene2D.
 */

//Otra herramienta
/*
 * El assetmanager es el gestor de recursos del juego lo hace static para
 * que sea accesible
 */

public class MyGdxGame extends ApplicationAdapter {
	public static final AssetManager manager = new AssetManager();
	/*
	 * Es el escenario del cual parte todos los actores . El escenario tiene su
	 * propio batch e inputprocessor
	 */
	private Stage stage;
	private ActorBola bola;

	@Override
	public void create() {
		// Lo primero que debemos hacer es cargar el manager de assets
		// para que sean usadaos de forma global (HORRRROOOOOORRRRROOOOSSOOOOO)
		manager.load("bola.png", Texture.class);
		// es obligatorio terminar la carga
		manager.finishLoading();
		// Creamos el escenario
		stage = new Stage();
		bola = new ActorBola(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage.addActor(bola);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}

	@Override
	public void dispose() {
		stage.dispose();
		manager.dispose();
	}
}
