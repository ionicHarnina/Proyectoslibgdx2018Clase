package com.adorno;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGameRegion extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	int altoPantalla,anchoPantalla,anchoImagen,altoImagen;
	//usando una region
	TextureRegion region;
	int incX=1;
	
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		anchoPantalla=Gdx.graphics.getWidth();
		altoPantalla=Gdx.graphics.getHeight();
		anchoImagen=img.getWidth();
		altoImagen=img.getHeight();
		//Creamos la region
		region=new TextureRegion(img, 0, altoImagen/2, anchoImagen/2, altoImagen/2);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		region.setRegion(region.getRegionX()+incX, region.getRegionY(),region.getRegionWidth(),region.getRegionHeight());
		batch.draw(region,0,0);
		batch.end();
	}

	@Override
	public void dispose() {
		img.dispose();
		batch.dispose();
	}
}
