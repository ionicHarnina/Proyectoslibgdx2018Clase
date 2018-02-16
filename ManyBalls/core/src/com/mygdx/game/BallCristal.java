package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class BallCristal implements Cloneable {
	private static final int MORTAL_BOUND_Y = 1500;
	Sprite sprite;

	Body body;
	boolean aleatoria = true;
	boolean dead = false;
	//con groups
	final short GROUP_BALL = -1;
	World world;

	public BallCristal(World world,Texture agua) {
		this.world=world;
		
		sprite = new Sprite(agua);
		body=createBody();
	}

	private Body createBody() {
		Body body;
		if (aleatoria)
			sprite.setPosition(-Utiles.getEnteroIntervalo(Gdx.graphics.getWidth() / 20),
					Utiles.getEnteroIntervalo(Gdx.graphics.getHeight() / 2));
		else
			sprite.setPosition(-sprite.getWidth() / 2, -sprite.getHeight() / 2);
		BodyDef bodyDef = new BodyDef();
		// Si queremos que tenga las propiedades reales
		// hay que pasarlo a metros El valor es m�s peque�o en el mundo que en
		// el sprite
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set((sprite.getX() + sprite.getWidth() / 2) / Utiles.PIXELS_TO_METERS,
				(sprite.getY() + sprite.getHeight() / 2) / Utiles.PIXELS_TO_METERS);
		body = world.createBody(bodyDef);
		// PolygonShape shape = new PolygonShape();
		CircleShape shape = new CircleShape();
		shape.setRadius(sprite.getWidth() / 2 / Utiles.PIXELS_TO_METERS);
		// shape.setAsBox(sprite.getWidth() / 2 / Utiles.PIXELS_TO_METERS,
		// sprite.getHeight() / 2 / Utiles.PIXELS_TO_METERS);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		// 1 m2 tiene 100 gramos de peso
		fixtureDef.density = 1f;
		fixtureDef.filter.groupIndex=GROUP_BALL;
		body.setLinearDamping(4);
		body.createFixture(fixtureDef);
		shape.dispose();
		body.setFixedRotation(false);
		body.setUserData("agua");
//		body.setActive(false);
		return body;
	}

	public boolean isAleatoria() {
		return aleatoria;
	}

	public void setAleatoria(boolean aleatoria) {
		this.aleatoria = aleatoria;
	}

	public void update() {
		if (!isDead()) {
			sprite.setPosition((body.getPosition().x * Utiles.PIXELS_TO_METERS) - sprite.getWidth() / 2,
					(body.getPosition().y * Utiles.PIXELS_TO_METERS) - sprite.getHeight() / 2);
			if (sprite.getY() < -MORTAL_BOUND_Y)
				dead = true;
		}
	}

	public void draw(SpriteBatch batch) {
		sprite.draw(batch);

	}

	public void dispose() {

	}

	public boolean isDead() {
		return dead;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		BallCristal nueva=(BallCristal) super.clone();
		nueva.body=createBody();
		nueva.body.setTransform(100, 100, nueva.body.getAngle());
		nueva.sprite=new Sprite(sprite.getTexture());
		return nueva;
	}
}
