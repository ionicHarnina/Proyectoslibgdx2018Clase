package elenco;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;

import interfaces.Elemento;

public class Suelo extends Actor implements Elemento{
	Body body;

	public Suelo() {
		super();
		body.setUserData(this);
	}

	@Override
	public boolean isColisionable() {
		return false;
	}

}
