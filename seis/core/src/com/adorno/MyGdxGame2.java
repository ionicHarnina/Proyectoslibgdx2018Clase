package com.adorno;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame2 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

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
	private FileHandle filehandle;
	private FileHandle objectHandle;
	Cliente yo;

	/*
	 * Necesitamos que se escriba en el archivo com bytes. y podemos perder el
	 * significado Por eso utilizamos ByteArrayStream (tanto inout como output) pero
	 * debemos convertir las cosas antes. Si vamos a guardar otro tipo b�sicos como
	 * int o float, debemos convertirlo primero a bytearray. Por eso usamos
	 * DataStream. Si lo que pasamos a un archivo es un objeto debemos usar
	 * ObjectStream
	 */

	@Override
	public void create() {
		filehandle = Gdx.files.local("archivoChicken.bin");
		objectHandle = Gdx.files.local("Clientes.bin");
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		// Output stream de entrada a flujo de bytes
		// Escribir pafuera
		// input de flujo a salida
		// leer pa dentro
		// Otras clases de trabajo con archivos
		// BufferedOutputStream, DataOutputStream y ObjectOutputStream
		// Que permiten hacer buffer
		// El segundo:Podemos escibir valores primitivos cmo enterios o cadena
		// El tercero: Permite volcar objetos directamente
		// ByteArrayOutputStream Escribe en el stream se puede asociar a los
		// anteriores
		// ByteArrayInputStream igual pero para leer del stream
		// El archivo se crea en el proyecto-desktop (hay que probart que pasa
		// en android)
		yo = new Cliente("3", "jo", 78, "33", 1978);
		System.out.println(yo.toString());

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	// un nuevo callback
	@Override
	public void pause() {
		super.pause();

		// va a ser el encargado de escribir unos datos raros
		escribir();
		leer();
		// escribir objetos7
		escribirObjeto();
		leerObjeto();
	}

	private void leerObjeto() {
		ByteArrayInputStream inp = null;
		ObjectInputStream objetoStream = null;

		try {
			inp = new ByteArrayInputStream(objectHandle.readBytes());
			objetoStream = new ObjectInputStream(inp);
			Cliente l = null;
			try {
				l = (Cliente) objetoStream.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("el datito: " + l.getNombre());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void escribirObjeto() {
		ByteArrayOutputStream out = null;
		ObjectOutputStream obj = null;

		out = new ByteArrayOutputStream();
		try {
			obj = new ObjectOutputStream(out);
			// Para poder grabar un objeto debe ser serializable
			obj.writeObject(yo);
			obj.flush();

			byte[] datos = out.toByteArray();
			objectHandle.writeBytes(datos, false);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				obj.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void leer() {
		ByteArrayInputStream inp = null;
		ObjectInputStream datoNoByte = null;
		try {
			inp = new ByteArrayInputStream(filehandle.readBytes());
			datoNoByte = new ObjectInputStream(inp);
			long l = datoNoByte.readLong();
			System.out.println("el datito: " + l);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void escribir() {
		// Esta forma se usa para guardar un �nico valor en un formato
		// no byte.
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream obj = null;
		try {
			obj = new ObjectOutputStream(out);
			obj.writeLong(123456789);
			obj.flush();
			byte[] datos = out.toByteArray();
			filehandle.writeBytes(datos, false);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				obj.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}
