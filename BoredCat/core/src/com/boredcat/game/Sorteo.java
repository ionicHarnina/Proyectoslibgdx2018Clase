package com.boredcat.game;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import estructuras.Estructura;

/**
 * Created by Mary on 08/03/2016.
 */
public interface Sorteo {
    int sorteo(int maximo);

    String sorteoGato();

    void colocarGanador(World world, Stage stage);

    void inicializarEstructura(World world, Stage stage, Estructura estructura);

    void inicializarGato(World world,float[] posicion, Stage stage);
}
