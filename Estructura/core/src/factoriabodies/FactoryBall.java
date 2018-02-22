package factoriabodies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

import utiles.Constantes;

public class FactoryBall extends FactoryAbstractBodies {


	public FactoryBall(World world, BodyType bodyType, float density, float restituion, float friction) {
		super(world, bodyType, density, restituion, friction);
	}

	@Override
	public Body createBody(Sprite sprite) {
		Shape shape=new CircleShape();
		shape.setRadius(sprite.getWidth()/2/Constantes.PIXELS_TO_METERS);
		closeBody((PolygonShape) shape);
		return body;
	}

}
