package com.adorno;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyImage {
	private static final String IMAGEN_EJEMPLO = "badlogic.jpg";
	private Texture imagen;
	private float x, y;

	public MyImage(float x, float y) {
		imagen = new Texture(Gdx.files.internal(IMAGEN_EJEMPLO));
		this.x = x;
		this.y = y;
	}

	public void dispose() {
		imagen.dispose();
	}

	public void draw(SpriteBatch lote) {
		lote.draw(imagen, x, Gdx.graphics.getHeight() - imagen.getHeight() - y);
	}

	public void subir() {
		this.y++;
	}

	public void bajar() {
		this.y--;
	}

	public void izquierdear() {
		this.x--;
	}

	public void derechear() {
		this.x++;
	}
}
