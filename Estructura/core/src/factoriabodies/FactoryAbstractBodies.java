package factoriabodies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public abstract class FactoryAbstractBodies {
	protected BodyType bodyType;
	protected FixtureDef fixture;
	protected Body body;

	private void initBody(World world) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = this.bodyType;
		body = world.createBody(bodyDef);
	}
	protected void closeBody(PolygonShape shape) {
		this.fixture.shape = shape;
		body.createFixture(this.fixture);
		shape.dispose();
	}

	public FactoryAbstractBodies(World world, BodyType bodyType, float density, float restituion, float friction) {
		super();
		this.bodyType = bodyType;
		fixture = new FixtureDef();
		fixture.friction = friction;
		fixture.density = density;
		fixture.restitution = restituion;
		initBody(world);
	}

	/**Para añadir un parametro a un metodo en toda la jerarquia
	 * refactor-->change method signature
	 * @param sprite
	 * @return
	 */
	public abstract Body createBody(Sprite sprite);
}
