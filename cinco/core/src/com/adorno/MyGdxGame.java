package com.adorno;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	
	SpriteBatch batch;
	MyImage image;
	private OrthographicCamera cam;

	@Override
	public void create() {
		batch = new SpriteBatch();
		image = new MyImage(0, 0);
		int h = Gdx.graphics.getHeight();
		int w = Gdx.graphics.getWidth();
		cam = new OrthographicCamera(w, h);
		batch = new SpriteBatch();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			image.derechear();
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
			image.izquierdear();
		if (Gdx.input.isKeyPressed(Input.Keys.UP))
			image.bajar();
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
			image.subir();
		image.draw(batch);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		image.dispose();
	}
}
