package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PantallaNumero extends PantallaBase {

	// Esta clase va a ser una pantalla que muestre un
	// acontecimeinto concreto
	private int numero;
	private BitmapFont fuente;
	private SpriteBatch lote;
	
	public PantallaNumero(Nueve nueve,int numero) {
		super(nueve);
		this.numero=numero;
		fuente=new BitmapFont(Gdx.files.internal("miFuente.fnt"), Gdx.files.internal("miFuente.png"), false);
		lote=nueve.getLote();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		lote.begin();
			fuente.draw(lote, Integer.toString(numero), 200, 200);
		lote.end();
		if (Gdx.input.isKeyPressed(Input.Keys.NUMPAD_1))
			nueve.setScreen(nueve.uno);
		else if (Gdx.input.isKeyPressed(Input.Keys.NUMPAD_2))
			nueve.setScreen(nueve.dos);
		
	}
	@Override
	public void dispose() {
		
		super.dispose();
		fuente.dispose();
	}
}
