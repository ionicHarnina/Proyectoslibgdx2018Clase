package version3;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MyGdxGame3 extends ApplicationAdapter {
	private Stage stage;
	private BallList list;

	@Override
	public void create() {
		stage = new Stage();
		list=new BallList(stage);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		list.act();
		stage.act();
		stage.draw();
	}

	
	@Override
	public void dispose() {
		this.stage.dispose();
		this.list.dispose();
	}
}
