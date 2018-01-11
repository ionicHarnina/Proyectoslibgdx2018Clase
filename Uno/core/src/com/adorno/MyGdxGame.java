package com.adorno;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	//los Sprites son imagenes que permiten ciertas operaciones
	//y las hacen más adecuadas que las texturas para ciertas cosas
	//como por ejemplo los actores
	SpriteBatch batch;
	//una texture es una imagen basica
	Texture img;
	
	//se ejecuta una vez al comienzo del programa
	@Override
	public void create () {
		//creacion de objetos e iniciacion de atributos
		batch = new SpriteBatch();
		//los assets son las imagenes, sonidos, mapas, etc
		//si tenemos el envoltorio android estaran en la 
		//carpeta xxx-android/assets
		img = new Texture("badlogic.jpg");
	}

	//se ejecuta tantas veces como pueda, es decir, el sistema ejecuta el metodo render cada vez
	//que el metodo render acaba
	@Override
	public void render () {
		//Gdx son utilidades de las OpenGL en este caso 
		//sirven para borrar la pantalla. Si no lo hiciesemos las 
		//imagenes sobreescribirian a las anteriores
		Gdx.gl.glClearColor(1, 1, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//Aqui, pronto, ira la actuacion de los actores
		
		//y despues su pintado en pantalla
		//lo que se pinta es el batch
		//se tarda lo mismo en pintar una imagen que 40
		//pero se tarda 40 veces mas en cargar en memoria 
		//40 imagenes que una
		//cargar todas las imagenes en el lote y dibujarlas una vez
		//begin comienza el proceso de carga del lote
		batch.begin();
		//draw es el proceso de carga del lote
		//si es una textura se dice en draw que textura es y donde se dibuja
		//en la pantalla la posicion 0,0 la esquina inferior izquierda
		batch.draw(img, 0, 0);
		//end finaliza el proceso de carga y envia a la grafica el propio lote
		//para que se dibuje
		batch.end();
		//aqui se pueden hacer más cosas
	}
	
	//sirve para borrar todos los elementos que hayna sido subbidos a la ram de video
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
