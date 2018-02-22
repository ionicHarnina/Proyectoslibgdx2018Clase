package factoriabodies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import utiles.Constantes;

public class FactoryBox extends FactoryAbstractBodies {

	public FactoryBox(World world,BodyType bodyType, float density, float restituion, float friction) {
		super(world,bodyType, density, restituion, friction);
	}

	@Override
	public Body createBody(Sprite sprite) {
		PolygonShape shape = new PolygonShape();
		((PolygonShape) shape).setAsBox(sprite.getWidth() / 3 / Constantes.PIXELS_TO_METERS,
				sprite.getHeight() / 3 / Constantes.PIXELS_TO_METERS);
		closeBody(shape);
		return body;
	}

	
}
