package comun;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import interfaces.Observador;
import utiles.Constantes;

public class MyDebug extends Box2DDebugRenderer implements Observador {
	public boolean debug=Constantes.START_WITH_DEBUG;
	
	public void draw(World world,SpriteBatch batch){
		if(debug)
			this.render(world, batch.getProjectionMatrix().cpy().scale(Constantes.PIXELS_TO_METERS, Constantes.PIXELS_TO_METERS, 0));
	}

	@Override
	public void update() {
		debug=!debug;
	}

}
