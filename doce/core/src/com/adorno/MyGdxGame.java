package com.adorno;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	//cosas especiales para la animacion
	private float elapsedTime=0;
	private Animation animation;
	private TextureAtlas textureAtlas;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//la animacion carga el fichero atlas que es un mapa de las regiones de la imagen
		textureAtlas=new TextureAtlas(Gdx.files.internal("tioanda.atlas"));
		//creamos la animacion
		animation=new Animation(1/15f, textureAtlas.getRegions());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//controlando la animation en el render
		elapsedTime += Gdx.graphics.getDeltaTime();
		batch.draw((TextureRegion)animation.getKeyFrame(elapsedTime, true), 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
