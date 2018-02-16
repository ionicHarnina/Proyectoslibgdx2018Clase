package com.mygdx.game;

import javax.xml.crypto.dsig.SignatureProperties;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyGdxGame extends ApplicationAdapter {
	World world;
	Body roca;
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	static final float ESCALA = 100f;
	private Box2DDebugRenderer debugRenderer;
	private OrthographicCamera camera;
	private Matrix4 debugMatrix;
	private float elapsedTime = 0;
	Viewport viewport;
	Ball bola;

	@Override
	public void create() {
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		// camera = new OrthographicCamera(Gdx.graphics.getWidth()*2,
		// Gdx.graphics.getHeight()*2);
		viewport = new ScreenViewport(camera);
		camera.position.x = Gdx.graphics.getWidth() / 2;
		camera.position.y = Gdx.graphics.getHeight() / 2;
		world = new World(new Vector2(0, -1), true);
		debugRenderer = new Box2DDebugRenderer();
		batch = new SpriteBatch();
		this.img=new Texture("rock.png");
		this.sprite = new Sprite(img);
		createRoca();
		bola=new Ball(world, BallType.azul);
	}

	private void createRoca() {
		FileHandle file = Gdx.files.internal("rocapbe.json");
		String cadena = file.readString();
		BodyEditorLoader loader = new BodyEditorLoader(cadena);
		BodyDef bd = new BodyDef();
		bd.position.set(0, 0);
		bd.type = BodyDef.BodyType.DynamicBody;
		// 2. Create a FixtureDef, as usual.
		FixtureDef fd = new FixtureDef();
		fd.density = 1;
		fd.friction = 3f;
		fd.restitution = 0.0f;
		roca=world.createBody(bd);
		//usamos el body y le aplicamos la fixtura del loader
		loader.attachFixture(roca, "Name", fd,this.sprite.getWidth()/ESCALA);
		roca.setTransform(new Vector2(100/ESCALA, 300/ESCALA), roca.getAngle());
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		world.step(Gdx.graphics.getDeltaTime(), 6, 2);
		camera.update();		
		batch.setProjectionMatrix(camera.combined);
		debugMatrix = batch.getProjectionMatrix().cpy().scale(ESCALA, ESCALA, 0);
		bola.act(Gdx.graphics.getDeltaTime());
		
		sprite.setPosition(roca.getPosition().x*ESCALA, roca.getPosition().y*ESCALA);
		sprite.setRotation(roca.getAngle());
		roca.setFixedRotation(true);
		batch.begin();
		sprite.draw(batch);
		bola.draw(batch, 1);
		batch.end();
		debugRenderer.render(world, debugMatrix);
	}

	@Override
	public void dispose() {
	}
}
