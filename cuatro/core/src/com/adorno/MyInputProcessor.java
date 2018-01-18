package com.adorno;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class MyInputProcessor implements InputProcessor {

	// Esto es dejar de usar polling y empezar a usar eventos

	// Lingdx no puede interpretar una teclado pulsada continuamente
	// as� que hay que levantarla. Para eso usamos banderas
	// Se trata de que una accion siga realizando hasta que la tecla se levanta
	boolean raised = false;
	boolean accelerate=false;

	@Override
	public boolean keyDown(int keycode) {
		System.out.println("procesor 1");
		if (!this.raised) {
			// Este keycode hace referencia al codigo que podemos igualar
			// con Input.Keys visto anteriormente+
			if(keycode==Input.Keys.ESCAPE) {
				System.out.println("has pulsado escape");
				accelerate=true;
			}
		}
		raised=false;
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		raised=true;
		accelerate=false;
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
