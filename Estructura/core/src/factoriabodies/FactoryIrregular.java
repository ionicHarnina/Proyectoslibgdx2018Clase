package factoriabodies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;

import comun.BodyEditorLoader;
import utiles.Constantes;

public class FactoryIrregular extends FactoryAbstractBodies  {

	private String archivoIrregular;
	public FactoryIrregular(World world, BodyType bodyType, float density, float restituion,
			float friction) {
		super(world, bodyType, density, restituion, friction);
	}

	public FactoryIrregular irregular(String archivoIrregular) {
		this.archivoIrregular=archivoIrregular;
		return this;
	}

	@Override
	public Body createBody(Sprite sprite) {
		FileHandle file = Gdx.files.internal(archivoIrregular);
		String cadena = file.readString();
		BodyEditorLoader loader = new BodyEditorLoader(cadena);
		loader.attachFixture(body, "Name", this.fixture, sprite.getWidth() / Constantes.PIXELS_TO_METERS);
		return body;
	}

	
}
