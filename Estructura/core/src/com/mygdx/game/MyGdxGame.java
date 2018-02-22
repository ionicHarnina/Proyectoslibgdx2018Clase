package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import control.Game;
import utiles.Constantes;

public class MyGdxGame extends ApplicationAdapter {
	Game game;

	@Override
	public void create() {
		game = new Game();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.act();
		game.render();
	}

	@Override
	public void dispose() {
		game.dispose();
	}
}
