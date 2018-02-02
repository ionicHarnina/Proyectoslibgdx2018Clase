package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class FisicasDos extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	Sprite sprite;
	Texture img;
	World world;
	Body body;
	Body bodyEdgeScreen;
	Box2DDebugRenderer debugRenderer;
	Matrix4 debugMatrix;
	OrthographicCamera camera;
	BitmapFont font;

	float torque = 0.0f;
	boolean drawSprite = true;
	final float PIXELS_TO_METERS = 100f;
	private float elapsed = 0;

	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		sprite = new Sprite(img);
		sprite.setPosition(-sprite.getWidth() / 2, -sprite.getHeight() / 2);
		// La gravedad negativa es hacia abajo, la positiva es hacia arriba
		world = new World(new Vector2(0, -7f), true);

		createSquare();
		createEdge();

		Gdx.input.setInputProcessor(this);
		debugRenderer = new Box2DDebugRenderer();

		// creando la fuente de letras
		font = new BitmapFont();
		font.setColor(Color.BLACK);

		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		// Step the physics simulation forward at a rate of 60hz
		world.step(1f / 60f, 6, 2);
		// ajustamos el sprite al body
		sprite.setPosition((body.getPosition().x * PIXELS_TO_METERS) - sprite.getWidth() / 2,
				(body.getPosition().y * PIXELS_TO_METERS) - sprite.getHeight() / 2);
		sprite.setRotation((float) Math.toDegrees(body.getAngle()));

		batch.setProjectionMatrix(camera.combined);
		debugMatrix = batch.getProjectionMatrix().cpy().scale(PIXELS_TO_METERS, PIXELS_TO_METERS, 0);
		// momento de dibujo
		batch.begin();
		if (drawSprite) {
			batch.draw(sprite, sprite.getX(), sprite.getY(), sprite.getOriginX(), sprite.getOriginY(),
					sprite.getWidth(), sprite.getHeight(), sprite.getScaleX(), sprite.getScaleY(),
					sprite.getRotation());
		}
		font.draw(batch, "Restitution: " + body.getFixtureList().first().getRestitution(), -Gdx.graphics.getWidth() / 2,
				Gdx.graphics.getHeight() / 2);
		batch.end();
		debugRenderer.render(world, debugMatrix);
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
		world.dispose();
	}

	private void createEdge() {
		// creamos el suelo
		BodyDef bodyDef2 = new BodyDef();
		bodyDef2.type = BodyDef.BodyType.StaticBody;
		float w = Gdx.graphics.getWidth() / PIXELS_TO_METERS;
		// Set the height to just 50 pixels above the bottom of the screen so we can see
		// the edge in the
		// debug renderer
		float h = Gdx.graphics.getHeight() / PIXELS_TO_METERS - 50 / PIXELS_TO_METERS;
		// bodyDef2.position.set(0,
		// h-10/PIXELS_TO_METERS);
		bodyDef2.position.set(0, 0);
		FixtureDef fixtureDef2 = new FixtureDef();

		EdgeShape edgeShape = new EdgeShape();
		edgeShape.set(-w / 2, -h / 2, w / 2, -h / 2);
		fixtureDef2.shape = edgeShape;

		bodyEdgeScreen = world.createBody(bodyDef2);
		bodyEdgeScreen.createFixture(fixtureDef2);
		edgeShape.dispose();
	}

	private void createSquare() {
		// crear el cuadrado

		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set((sprite.getX() + sprite.getWidth() / 2) / PIXELS_TO_METERS,
				(sprite.getY() + sprite.getHeight() / 2) / PIXELS_TO_METERS);

		body = world.createBody(bodyDef);

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(sprite.getWidth() / 2 / PIXELS_TO_METERS, sprite.getHeight() / 2 / PIXELS_TO_METERS);

		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 0.5f;
		fixtureDef.restitution = 0.3f;

		body.createFixture(fixtureDef);
		shape.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
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
