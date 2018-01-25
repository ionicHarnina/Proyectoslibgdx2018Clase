package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class ActorBola extends Actor implements Disposable {
	// Vamos a darle una imagen
	private Texture texture;
	// La forma se define com ocirculo
	private Circle circle;
	// un vector bidimensional de libgdx
	private Vector2 velocidad;
	private float velX = 9;
	private float velY = 9;
	private ActorBola bola2;

	public ActorBola(int posX, int posY, String texture,ActorBola bola2) {
		super();
		this.texture = new Texture(texture);
		// tamaño al actor
		this.setSize(this.texture.getWidth(), this.texture.getHeight());
		this.setPosition(posX, posY);
		// como todavia no usamos la fisica
		// vamos a gestionarla nosotros con la forma
		circle = new Circle();
		circle.setX(posX);
		circle.setY(posY);
		circle.setRadius(((float) this.texture.getWidth()) / 2);
		velocidad = new Vector2(velX, velY);
		//meto el actor con el que se puede chocar
		this.bola2=bola2;
	}

	// para definir lo que le pasa a la forma
	@Override
	public void act(float delta) {
		super.act(delta);
		this.moveBy(this.velocidad.x, this.velocidad.y);
		this.testingBoundsCollide();
		// la posicion a la forma
		circle.setPosition(this.getX(), this.getY());
		if(testingCollision()) {
			fixCollision();
		}
	}
	
	private void fixCollision() {
		this.velocidad.x *= -1;
		this.bola2.velocidad.x *= -1;
		this.velocidad.y *= -1;
		this.bola2.velocidad.y *= -1;
	}

	private boolean testingCollision() {
		boolean collision=false;
		if(bola2!=null) {
			if(this.circle.overlaps(this.bola2.circle)) {
				collision=true;
			}
		}
		return collision;
	}
	// para definir lo que le pasa a lo que vemos
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		// lo doy la posicion a la imagen
		batch.draw(texture, this.getX(), this.getY());
	}

	@Override
	public void dispose() {
		texture.dispose();
	}
	/**
	 * comprueba si hay colision con los bordes
	 * hace dos cosas, luego esta mal, comprueba y rectifica
	 */
	private void testingBoundsCollide() {
		if (this.getX() < 0) {
			this.setX(0);
			velocidad.x *= -1;

		} else if (this.getRight() > Gdx.graphics.getWidth()) {
			this.setX(Gdx.graphics.getWidth() - getWidth());
			velocidad.x *= -1;
		}
		if (this.getY() < 0) {
			this.setY(0);
			velocidad.y *= -1;
		} else if (this.getTop() > Gdx.graphics.getHeight()) {
			this.setY(Gdx.graphics.getHeight() - getHeight());
			velocidad.y *= -1;
		}
	}
}
