package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

//Multipantalla con game y screen
public class Nueve extends Game {
	/*
	 * Pantallas que expresan diferentes estados del juego (presentacion, menu,
	 * puntuacion...) Game hereda de application listener En game tenemos una
	 * variable screen, que es un pantalla para dibujar
	 */

	public PantallaNumero uno;
	public PantallaNumero dos;

	private SpriteBatch lote;

	@Override
	public void create() {
		lote = new SpriteBatch();
		uno = new PantallaNumero(this, 1);
		dos = new PantallaNumero(this, 2);
		setScreen(uno);
	}

	public void setLote(SpriteBatch lote) {
		this.lote = lote;
	}

	public SpriteBatch getLote() {

		return this.lote;
	}
}
