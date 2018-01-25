package version1;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MyGdxGame extends ApplicationAdapter {
	private ArrayList<ActorBola> bolas;
	private Stage stage;
	private ActorBola bola;
	private float elapsedTime = 1;
	private float birthMoment = 2;

	@Override
	public void create() {
		stage = new Stage();
		bolas = new ArrayList<ActorBola>();
		ActorBola bola = new ActorBola(50, 50, "bouncing.png");
		bolas.add(bola);
		// El iterator se usa porque permite la modificacion
		// de un arraylist cosa que no se puede hacer desde el
		// propio arraylist
		Iterator<ActorBola> iterator = bolas.iterator();
		while (iterator.hasNext()) {
			stage.addActor(iterator.next());
		}
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (hasPassedEnoughTime()) {
			bolas.add(new ActorBola(100, 100, "bouncing.png"));
			stage.addActor(bolas.get(bolas.size() - 1));
			this.elapsedTime = 0;
		}
		stage.act();
		stage.draw();
	}

	private boolean hasPassedEnoughTime() {
		this.elapsedTime += Gdx.graphics.getDeltaTime();
		return this.elapsedTime > this.birthMoment;
	}

	@Override
	public void dispose() {
		this.stage.dispose();
	}
}
