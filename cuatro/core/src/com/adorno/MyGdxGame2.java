package com.adorno;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Estamos probando mas de un input processor a la vez
 * 
 * @author jose
 *
 */
public class MyGdxGame2 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	OrthographicCamera cam;
	int posx = 0;
	boolean move;
	MyInputProcessor inputPro;
	MyOtherInputProcessor otherIP;

	// para trabajar con varios procesadores de eventos
	InputMultiplexer multiplexerIP;

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
		otherIP = new MyOtherInputProcessor();

		// una forma de incluir inputs al multiplexor
		// multiplexerIP=new InputMultiplexer(inputPro,otherIP);
		//Otra forma de incluirlos
		multiplexerIP=new InputMultiplexer();
		multiplexerIP.addProcessor(0,inputPro);
		multiplexerIP.addProcessor(1,otherIP);
		//asignamos el multiplexor al gdx
		Gdx.input.setInputProcessor(multiplexerIP);

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();		
		batch.draw(img, this.posx, 0);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
