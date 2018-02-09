package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

public class RainBehaviour implements ContactListener {
	Vector2 vec2=new Vector2(0, 1);

	@Override
	public void beginContact(Contact contact) {
		Body gota;
		if(contact.getFixtureA().getBody().getUserData().toString().equals("suelo"))
			gota=contact.getFixtureB().getBody();
		else
			gota=contact.getFixtureA().getBody();
		gota.applyLinearImpulse(-0.16f, .056f,gota.getWorldCenter().x, gota.getWorldCenter().y, true);
//		gota.applyForceToCenter(vec2, true);
	}

	@Override
	public void endContact(Contact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub

	}

}
