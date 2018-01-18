package com.adorno;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Ante la posibilidad de que el sondeo de eventos sea demasiado costoso libgdx
 * provee de un sistema de eventos sin sondeo llamado InputProcesssor
 * 
 * @author jose
 *
 */
public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	OrthographicCamera cam;
	int posx = 0;
	boolean move;
	MyInputProcessor inputPro;

	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		// configuramos la camara con los valores de la pantalla
		int w = Gdx.graphics.getWidth();
		int h = Gdx.graphics.getHeight();
		cam = new OrthographicCamera(w, h);

		// Podemos poner el curso en una posicion inicial
		Gdx.input.setCursorPosition(50, 50);
		inputPro = new MyInputProcessor();
		// aqui le decimos a libgdx que use el gestor de eventos en vez del sondeo
		Gdx.input.setInputProcessor(inputPro);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		if (!inputPro.raised)
			this.posx++;
		batch.draw(img, this.posx, 0);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
