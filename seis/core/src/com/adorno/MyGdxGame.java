package com.adorno;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

//Este proyecto habla de como guardar preferencias del juego
//El hecho de que pinte un personaje es secundario
//Es multiplataforma y por lo tanto no sabemos como vamos a poder
//escribir en disco.
//Para guardar preferencias libgdx nos da preferences
//Si queremos guardar preferencias m�s complejas (valores de objetos)
//no podemos usar prederences

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	// Implementamos la interfaz de preferencias
	private Preferences prefs;

	@Override
	public void create() {
		// Archivos binarios
		// cinco tipos de archivos
		// para escritorio y android en la carpeta por defecto
		// Gdx.files.classpath(path);

		// Internos de la carpeta /assets
		// solo lectura
		// Funciona para todas las plataformas
		// Gdx.files.internal(path)

		// local
		// Tb es inttern es r/w no vale para la web
		// almacena en memoria interna
		// Gdx.files.local(path);

		// externo
		// se usa para guardar cosas muy grandes o que no
		// son vitales para la aplicacion si faltan
		// en desktop son en la carpta personal del usuario en android la sd
		// externa
		// /home en linux...
		// Gdx.files.external(path);

		// Absoluto NO SE DEBE USAR
		// Gdx.files.absolute(path);

		// Todos los m�todos devuelven un FileHandler sobre un fichero que
		// no debemos crear. Porque se crea s�lo la primera vez que intentamos
		// escribir
		// en el. Pero daria error si intentamos leer en �l. Hay un m�todo
		// exists()
		// FileHandle tiene algunos m�todos list(), child(),
		// readBytes(),writeBytes(), con parametro append.
		// exists(),length(),parent(),delete()
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		
		//si quieres guardar un dato concreto
		this.prefs=Gdx.app.getPreferences("posicional");
		float x2= prefs.getFloat("posX", 50);
		float y2= prefs.getFloat("posY", 50);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
		prefs.putFloat("posX", 100);
		prefs.putFloat("posY", 100);
		prefs.flush();
	}
}
