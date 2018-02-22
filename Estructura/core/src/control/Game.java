package control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import utiles.Constantes;

public class Game {
	// las tipicas de Scene2d y Box2d
	Stage stage;
	SpriteBatch batch;
	World world;

	// accesorios
	InputAdapter input;
	OrthographicCamera camera;
	Box2DDebugRenderer debug;

	// lo que pondremos luego como propio
	public Game() {
		super();
		world=new World(new Vector2(Constantes.GRAVEDAD_X,Constantes.GRAVEDAD_Y), true);
		batch=new SpriteBatch();
		debug=new Box2DDebugRenderer();
		stage=new Stage();
		camera=(OrthographicCamera) stage.getViewport().getCamera();
	}

	public void act() {
		world.step(1f/60f, 6, 2);
		stage.act();		
	}
	public void render() {
		stage.draw();
	}
	public void dispose() {
		world.dispose();
		batch.dispose();
		stage.dispose();
	}
}
