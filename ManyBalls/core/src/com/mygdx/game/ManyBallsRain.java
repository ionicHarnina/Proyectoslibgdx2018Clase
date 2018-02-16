package com.mygdx.game;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class ManyBallsRain extends ApplicationAdapter implements InputProcessor {
	private boolean levantada = false;
	
	private static final int NUMBER_OF_BALLS = 15000;
	private static final float GRAVEDAD_Y = -9f;
	public static final int FactorZoomCamara = 4;
	SpriteBatch batch;
	World world;
	// 100 pixeles son un metro
	float timeElapsed = 0, timeLapse = .001f;
	// El motor que renderiza la fisica dibujandolo con lineas para que veamos
	// si coincide el mundo fisico con las imagenes
	Box2DDebugRenderer debugRenderer;
	// una matriz de 4x4
	Matrix4 debugMatrix;
	// La camara
	OrthographicCamera camera;
	ArrayList<BallCristal> balls;
	Ground ground;
	ArrayList<Ground> grounds = new ArrayList<Ground>();
	Texture texture;
	BallCristal ejemplo;

	@Override
	public void create() {
		super.create();
		batch = new SpriteBatch();
		world = new World(new Vector2(0, GRAVEDAD_Y), true);
		debugRenderer = new Box2DDebugRenderer();
		camera = new OrthographicCamera(Gdx.graphics.getWidth() * FactorZoomCamara,
				Gdx.graphics.getHeight() * FactorZoomCamara);

		texture = new Texture(Gdx.files.internal("agua.png"));
		balls = new ArrayList<BallCristal>();

		ejemplo=new BallCristal(world, texture);

		Gdx.input.setInputProcessor(this);
		ground = new Ground(world, 0, -500, 300, 20);
		world.setContactListener(new RainBehaviour());
	}

	@Override
	public void render() {
		super.render();
		timeElapsed += Gdx.graphics.getDeltaTime();
		if (balls.size() < NUMBER_OF_BALLS && timeElapsed > timeLapse) {
			timeElapsed = 0;
			for (int i = 0; i < 30; i++) {
				try {
					BallCristal nueva=(BallCristal) ejemplo.clone();
					balls.add(nueva);
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
		}
		world.step(1f / 60f, 6, 2);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		debugMatrix = batch.getProjectionMatrix().cpy().scale(Utiles.PIXELS_TO_METERS, Utiles.PIXELS_TO_METERS, 0);
		// La mejor solucion es usar la clase iterator
		for (Iterator iterator = balls.iterator(); iterator.hasNext();) {
			BallCristal ball = (BallCristal) iterator.next();
			ball.update();
			if (ball.isDead())
				iterator.remove();
		}
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		if (Combinacion.isDraw()) {
			for (BallCristal ball : balls) {
				if (!ball.isDead())
					ball.draw(batch);
			}
		}

		ground.sprite.draw(batch);
		batch.end();
		if (Combinacion.isRender()) {
			debugRenderer.render(world, debugMatrix);
		}

	}

	@Override
	public boolean keyDown(int keycode) {
		Combinacion.reconocer(keycode);
		if (keycode == Input.Keys.NUMPAD_0)
			balls.get(1).body.applyForceToCenter(10, 0, true);
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		levantada = true;
		Combinacion.comprobarLevantada(keycode);
		return true;
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
