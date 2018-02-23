package comun;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import utiles.Constantes;


public class MyCamera extends OrthographicCamera {
	public Viewport viewport;
	Actor actor;
	/**
	 * Si la camara va a estar fija
	 */
	public MyCamera(){
		super(Gdx.graphics.getWidth() * Constantes.FACTOR_ZOOM_CAMERA,
				Gdx.graphics.getHeight() * Constantes.FACTOR_ZOOM_CAMERA);
		this.viewport=new ScreenViewport(this);
		
	}
	/**
	 * Si la camara va a seguir a un actor
	 * @param actor  al que sigue la camara
	 */
	public MyCamera(Actor actor){
		this.viewport=new ScreenViewport(this);
		this.actor=actor;
	}
	
	@Override
	public void update() {
		super.update();
		if (actor != null) {
			this.position.x = actor.getX();
			this.position.y = actor.getY();
		}
		
		
	}
	
	
	public void draw(SpriteBatch batch){
		batch.setProjectionMatrix(this.combined);
	}

}
