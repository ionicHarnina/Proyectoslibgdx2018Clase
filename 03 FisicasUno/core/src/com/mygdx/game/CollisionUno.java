package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
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
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class CollisionUno extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	Sprite sprite;
	Texture img;
	private boolean ocultar = false;

	// El objeto mundo que pertenece a box2d
	World world;
	// El cuerpo que pertencer� al mundo
	Body body;
	// El motor que renderiza la fisica dibujandolo con lineas para que veamos
	// si coincide el mundo fisico con las imagenes
	Box2DDebugRenderer debugRenderer;
	// una matriz de 4x4
	Matrix4 debugMatrix;
	// La camara
	OrthographicCamera camera;
	float torque = 0.0f;
	float derecha = 0f;
	boolean drawSprite = true;

	// 100 pixeles son un metro
	final float PIXELS_TO_METERS = 100f;

	@Override
	public void create() {
		super.create();
		this.batch = new SpriteBatch();
		this.img = new Texture("badlogic.jpg");
		this.sprite = new Sprite(this.img);
		this.sprite.setPosition(-this.sprite.getWidth() / 2, -this.sprite.getHeight() / 2);
		// creando el mundo
		// el vector2 le permite darle "gravedad" horizontal o vertical
		this.world = new World(new Vector2(0, -1), true);

		// ahora hay que definir el cuerpo
		BodyDef bodyDef = new BodyDef();
		// de que tipo es ?
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		// Si queremos que tenga las propiedades reales hay que pasarlo a metros
		bodyDef.position.set(this.escalar(sprite.getX() + sprite.getWidth() / 2),
				this.escalar(sprite.getY() + sprite.getHeight() / 2));
		// se lo metemos al mundo y creamos el body
		body = world.createBody(bodyDef);
		// definir las caracteristicas de un cuerpo y su forma se hace aparte porque es
		// mas dificil
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(this.escalar(this.sprite.getWidth() / 2), this.escalar(this.sprite.getHeight() / 2));
		// ahora podemos definir las caracterisiticas del cuerpo en ese mundo
		FixtureDef fixtureDef = new FixtureDef();
		// asociarle la forma
		fixtureDef.shape = shape;
		fixtureDef.density = 0.1f;
		// ya esta creada la fixture pues se aplica
		body.createFixture(fixtureDef);
		shape.dispose();

		// para controlar la fisica
		Gdx.input.setInputProcessor(this);

		// La clase Box2dDeburRenderer nos permite ver la simulacion fisica
		// controlar la escena
		debugRenderer = new Box2DDebugRenderer();
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		super.render();
		camera.update();
		// hay que darle la frecuencia de actualizacion del word
		world.step(1f / 60f, 6, 2);
		// para que muestre lo que la camara ve
		batch.setProjectionMatrix(camera.combined);
		debugMatrix = batch.getProjectionMatrix().cpy().scale(PIXELS_TO_METERS, PIXELS_TO_METERS, 0);
		sprite.setPosition((body.getPosition().x * PIXELS_TO_METERS) - sprite.getWidth() / 2,
				(body.getPosition().y * PIXELS_TO_METERS) - sprite.getHeight() / 2);
		sprite.setRotation((float) Math.toDegrees(body.getAngle()));
		batch.begin();
		if (!ocultar)
			sprite.draw(batch);
		batch.end();

		// Ahora calcula el mundo usando la matriz anterior, obser que es
		// opcional, solo para depurar
		debugRenderer.render(world, debugMatrix);

	}

	@Override
	public void dispose() {
		super.dispose();
		img.dispose();
		world.dispose();
	}

	private float escalar(float valor) {
		return valor / this.PIXELS_TO_METERS;
	}

	// El mundo esta hecho en metros

	@Override
	public boolean keyDown(int keycode) {
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// controla las velocidades laterales con impulsos
				// Observa como se para al poner el linearDamping a 4 tb actua en apply
				// force
				// pero no en torque
				if (keycode == Input.Keys.RIGHT)
					body.setLinearVelocity(1f, 0f);
				derecha = 1;
				if (keycode == Input.Keys.LEFT)
					body.setLinearVelocity(-1f, 0f);

				// Aplico fuerza Se suma a lo que haya en el movimiento si nos
				// estamos moviendo le a�ade esta fuerza a lo que se aplique
				if (keycode == Input.Keys.UP)
					body.applyForceToCenter(0f, 10f, true);
				if (keycode == Input.Keys.DOWN)
					body.applyForceToCenter(0f, -10f, true);

				// se aplica momento angular horario y antihorario
				// El torque se aplica en el render
				if (keycode == Input.Keys.NUMPAD_7)
					torque += 5f;
				if (keycode == Input.Keys.NUMPAD_9)
					torque -= 5f;

				// quitar el momento angular
				if (keycode == Input.Keys.NUMPAD_8)
					torque = 0.0f;

				// Es como la velocidad lineal pero angular se mantiene
				// El torque es una fuerza y por lo tanto actua contrarrestando lo que
				// pasar//antes torque es como empujar un coche y impulse es como darle
				// un empujon.
				if (keycode == Input.Keys.NUMPAD_5) {
					body.applyTorque(torque, true);
					System.out.println("torque " + torque);
				}

				// Es como un empujon que se suma a la velocidad
				// El impulso actua modificando inmediatamente la cosa
				if (keycode == Input.Keys.NUMPAD_1)
					body.applyAngularImpulse(5, true);

				if (keycode == Input.Keys.NUMPAD_3)
					body.applyAngularImpulse(-5, true);
				if (keycode == Input.Keys.NUMPAD_2)
					body.setAngularVelocity(5);
				// la barra espacidora lo pone todo a cero
				if (keycode == Input.Keys.SPACE) {
					body.setLinearVelocity(0f, 0f);
					body.setAngularVelocity(0f);
					torque = 0f;
					sprite.setPosition(0f, 0f);
					body.setTransform(0f, 0f, 0f);
				}
				// pone transparente el sprite
				if (keycode == Input.Keys.ESCAPE)
					drawSprite = !drawSprite;
				if (keycode == Input.Keys.NUMPAD_6) {
					// Lo principal es que la fuerza se aplica gradualmente y el impulso
					// a la vez
					// esto se usa m�s bien para touch porque los parametros tres y
					// cuatro
					// hacen referencia al sitio hacia donde se aplica la fuerza
					// es lineal le afecta el damping
					// son puntos del world (ojo hay que ajustarlos al cuerpo)
					body.applyForce(20, 20, 0, 0, true);
					System.out.println("6:" + body.getPosition().x + " " + body.getPosition().y);
				}
				if (keycode == Input.Keys.NUMPAD_4) {
					body.applyLinearImpulse(1, 1, 0, 0, true);
					//esto conviene para impulse y force
					body.getWorldCenter();
				}
				return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// Es como empujar
			body.applyForce(1f, 1f, screenX, screenY, true);
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
