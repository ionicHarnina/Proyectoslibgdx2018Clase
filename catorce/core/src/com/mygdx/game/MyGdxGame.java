package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

public class MyGdxGame extends ApplicationAdapter implements GestureListener {
	SpriteBatch batch;
	Texture img;
	private Sprite sprite;
	// Creamos la camara
	private OrthographicCamera camera;
	float limiteXIzq, limiteXDch, diferencia;

	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture(Gdx.files.internal("2048.jpg"));
		sprite = new Sprite(img);
		sprite.setOrigin(0, 0);
		sprite.setPosition(-sprite.getWidth() / 2, -sprite.getHeight() / 2);
		camera = new OrthographicCamera(640, 480);
		// para que reconozca este listener
		Gdx.input.setInputProcessor(new GestureDetector(this));
		diferencia = sprite.getWidth() - camera.viewportWidth;
		// establecemos los limites
		limiteXDch = diferencia / 2;
		limiteXIzq = -diferencia / 2;
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// aqui le decimos al batch que debe mostrar la camara
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		batch.end();
	}

	@Override
	public void dispose() {
		img.dispose();
		batch.dispose();
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		if (camera.position.x >= limiteXIzq && camera.position.x <= limiteXDch) {
			camera.translate(-deltaX, 0);
			camera.update();
		} else
		// Si se sale de los limites x la izq la volvemos a meter en el limite
		if (camera.position.x < limiteXIzq)
			camera.position.x = limiteXIzq;
		else
		// o por la derecha
		if (camera.position.x > limiteXDch)
			camera.position.x = limiteXDch;
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void pinchStop() {
		// TODO Auto-generated method stub

	}
}
