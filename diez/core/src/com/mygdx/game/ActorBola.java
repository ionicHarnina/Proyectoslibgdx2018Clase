package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;
public class ActorBola  extends Actor{

	private Texture textureBola;
	private float anchoPantalla, altoPantalla;
	private float xactual;
	private float yactual;
	//vamos a crear una velocidad
	public Vector2 velocidad;
	
	public ActorBola(float anchoPantalla, float altoPantalla) {
		super();
		this.anchoPantalla = anchoPantalla;
		this.altoPantalla = altoPantalla;
		this.textureBola=MyGdxGame.manager.get("bola.png");
		setSize(this.textureBola.getWidth(), this.textureBola.getHeight());
		this.velocidad=new Vector2(90, 90);
		this.setX(anchoPantalla/2);
		this.setY(altoPantalla/2);
	}
	//el actor se dibuja
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(textureBola,this.getX(),this.getY());
	}
	//el actor hace algo
	@Override
	public void act(float delta) {
		moveBy(this.velocidad.x*delta, this.velocidad.y*delta);
	}

}
