package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MyGdxGame extends ApplicationAdapter {
	private ActorBola bola1,bola2;
	private Stage stage;
	
	@Override
	public void create () {
		stage=new Stage();
		bola1 = new ActorBola(280, 230,"badlogic.jpg",null);
		bola2=new ActorBola(50, 50, "badlogic.jpg",bola1);
		stage.addActor(bola1);
		stage.addActor(bola2);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}
	
	@Override
	public void dispose () {
		stage.dispose();
	}
}
