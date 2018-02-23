package input;

import java.util.ArrayList;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.scenes.scene2d.Actor;

import interfaces.Observable;
import interfaces.Observador;


public class InputDesktop extends InputAdapter implements Observable{
	private ArrayList<Observador> observadores = new ArrayList<Observador>();

	private boolean ctrl = false;

	private Actor actor;

	public InputDesktop() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Si el teclado interactua con el actor
	 * 
	 * @param actor
	 */
	public InputDesktop(Actor actor) {
		this.actor = actor;
	}

	@Override
	public boolean keyDown(int keycode) {
		comprobarCombinacion(keycode);
		// TODO Auto-generated method stub

		if (keycode == Keys.LEFT) {
			((MyActor)actor).moverIzquierda();
		}
		if (keycode == Keys.RIGHT) {
			((MyActor)actor).moverDerecha();
		}
		if (keycode == Keys.UP) {
			((MyActor)actor).moverArriba();
		}
		if (keycode == Keys.DOWN) {
			((MyActor)actor).moverAbajo();
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.DOWN||keycode == Keys.UP||keycode == Keys.RIGHT||keycode == Keys.LEFT){
			((MyActor)actor).parar();
		}
		return true;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return true;
	}

	public void comprobarCombinacion(int keycode) {
		if (ctrl) {
			if (keycode == Input.Keys.R) {
				notifyObservers();
			}
		}
		if (keycode == Keys.CONTROL_LEFT) {
			ctrl = true;
		}
	}

	@Override
	public void addObserver(Observador observador) {
		observadores.add(observador);
		
	}

	@Override
	public void removeObserver(Observador observador) {
		observadores.remove(observador);
		
	}

	@Override
	public void notifyObservers() {
		for (Observador observador : observadores) {
			observador.update();
		}
		
	}

	

}
