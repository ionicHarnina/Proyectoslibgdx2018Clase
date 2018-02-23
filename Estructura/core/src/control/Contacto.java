package control;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;

import interfaces.Colisionable;
import interfaces.Elemento;


public class Contacto extends ContactAdapter {
	Body bodyA, bodyB;

	@Override
	public void beginContact(Contact contact) {
		Elemento actor=(Elemento) contact.getFixtureA().getUserData();
		if(actor.isColisionable())
			((Colisionable)actor).colisiona();
	}

	

}
