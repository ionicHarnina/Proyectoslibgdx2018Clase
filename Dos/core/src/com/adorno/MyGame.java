package com.adorno;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture imagen1;
	private OrthographicCamera cam;

	@Override
	public void create() {
		batch = new SpriteBatch();
		imagen1 = new Texture("badlogic.jpg");
		int w = Gdx.graphics.getWidth();
		int h = Gdx.graphics.getHeight();
		cam = new OrthographicCamera(w, h);
		// se puede decidir l aposicion incial del cursor
		Gdx.input.setCursorPosition(50, 50);
	}

	@Override
	public void render() {
		// Vamos a usar un sistema para detectar eventos
		// Es un tanto especial porque es un sondeo o polling
		// Te estan tocando
		Gdx.input.isTouched();
		// Para usar más de un dedo se usa
		// Se usa el pointerIndex
		Gdx.input.isTouched(0);
		// Obtener las coordenadas de la pulsacion
		Gdx.input.getX();
		Gdx.input.getY();
		// Se puede ajustar para más de un dedo
		Gdx.input.getX(0);
		// Otra cosa que podemos usar es getDeltaX
		// Delta nos da la variacion que se ha producido desde la ultima
		// pulsacion
		Gdx.graphics.getDeltaTime();
		Gdx.input.getDeltaX();
		Gdx.input.getDeltaY();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		System.out.println("pos x:" + Gdx.input.getX() + " pos y:" + Gdx.input.getY());
	}

	@Override
	public void dispose() {
		batch.dispose();
		imagen1.dispose();
	}
}
