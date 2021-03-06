package com.adorno;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGame extends ApplicationAdapter {
	SpriteBatch batch;
	//Las dimensiones de cualquier imagen deben ser potencias de 2 en pixeles
	Texture img;
	//en este momento no sabemos estos valores
	int altoPantalla,anchoPantalla,anchoImagen,altoImagen;
	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		anchoPantalla=Gdx.graphics.getWidth();
		altoPantalla=Gdx.graphics.getHeight();
		anchoImagen=img.getWidth();
		altoImagen=img.getHeight();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img,0,0);
		batch.end();
	}

	@Override
	public void dispose() {
		img.dispose();
		batch.dispose();
	}
}
