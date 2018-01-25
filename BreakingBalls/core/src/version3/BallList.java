package version3;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;

public class BallList implements Disposable {
	private ArrayList<ActorBola3> bolas;
	private ActorBola3 bola;
	private float elapsedTime = 1;
	private float birthMoment = 2;
	Stage stage;

	public BallList(Stage stage) {
		super();
		this.stage = stage;
		bolas = new ArrayList<ActorBola3>();
		ActorBola3 bola = new ActorBola3(50, 50, "bouncing.png");
		bolas.add(bola);
		Iterator<ActorBola3> iterator = bolas.iterator();
		while (iterator.hasNext()) {
			stage.addActor(iterator.next());
		}
	}

	public void act() {
		manageCollision();
		if (hasPassedEnoughTime()) {
			bolas.add(new ActorBola3(100, 100, "bouncing.png"));
			this.stage.addActor(bolas.get(bolas.size() - 1));
			this.elapsedTime = 0;
		}
	}

	private void manageCollision() {
		for (int i = 0; i < this.bolas.size() - 1; i++) {
			for (int j = i+1; j < this.bolas.size(); j++) {
				this.bolas.get(i).manageCollision(this.bolas.get(j));
			}
		}
	}

	private boolean hasPassedEnoughTime() {
		this.elapsedTime += Gdx.graphics.getDeltaTime();
		return this.elapsedTime > this.birthMoment;
	}

	@Override
	public void dispose() {
		Iterator<ActorBola3> iterator = bolas.iterator();
		while (iterator.hasNext()) {
			iterator.next().dispose();
		}
		
	}

}
