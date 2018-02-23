package elenco;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;

import interfaces.Colisionable;
import interfaces.Direccionable;
import interfaces.Elemento;

public class ActorPasota extends Actor implements Colisionable,Elemento {
	Body body;

	public ActorPasota() {
		super();
		body.setUserData(this);
	}

	@Override
	public void colisiona() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isColisionable() {
		return true;
	}

	
	
}
