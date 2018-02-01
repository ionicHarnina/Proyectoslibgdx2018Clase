package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class Soldado extends Actor {

	private static final float FRAME_DURATION = 1 / 30f;
	
	public enum TipoAnimacion {
		ataca, danado, quieto, virtualizado
	}
	
	public enum TipoMovmiento {
		quieto, adelante, atras, salto		
	
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
	}

}
