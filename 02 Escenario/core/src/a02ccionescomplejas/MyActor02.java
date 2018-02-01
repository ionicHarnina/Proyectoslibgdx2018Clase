package a02ccionescomplejas;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Disposable;

public class MyActor02 extends Actor implements Disposable {
	Texture texture = new Texture(Gdx.files.internal("001.png"));
	public boolean started = false;

	public MyActor02() {
		super();
		this.addAction(new BalanceAction(100, 100));
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw(texture, this.getX(), this.getY());
	}

	@Override
	public void act(float delta) {
		super.act(delta);		
	}

	@Override
	public void dispose() {
		texture.dispose();

	}
}
