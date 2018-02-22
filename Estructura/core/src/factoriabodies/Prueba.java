package factoriabodies;

import javax.swing.plaf.ActionMapUIResource;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Prueba {
	public static void main(String[] args) {
		FactoryAbstractBodies miBody=new FactoryBall(world, bodyType, density, restituion, friction);
		FactoryAbstractBodies miBodyI
		=new FactoryIrregular(world, bodyType, density, restituion, friction).irregular(archivoIrregular);
		Body body=miBodyI.createBody(sprite);
		Actor actor;
		actor.setBody(body);
	}
}
