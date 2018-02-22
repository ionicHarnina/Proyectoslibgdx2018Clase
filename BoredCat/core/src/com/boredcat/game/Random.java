package com.boredcat.game;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import estructuras.Cattillo;
import estructuras.DobleCaja;
import estructuras.Estructura;
import estructuras.Piruleta;
import estructuras.PuertaGatuna;

/**
 * Created by Mary on 03/03/2016.
 */
public class Random implements Sorteo {
    private Body bodyGato;

    public Random() {
    }

    public Random(World world, Stage stage) {
        colocarGanador(world, stage);
    }

    @Override
    public int sorteo(int maximo) {
        return (int) (Math.random() * maximo);
    }

    @Override
    public String sorteoGato() {
        String[] gatos = {"pusheen-ball.png", "pusheen-cut.png", "pusheen-viking.png"};
        return gatos[sorteo(gatos.length)];
    }

    @Override
    public void colocarGanador(World world, Stage stage) {
        switch (sorteo(4)) {
            case 0:
                DobleCaja dobleCaja=new DobleCaja();
                inicializarEstructura(world, stage, dobleCaja);
                inicializarGato(world,dobleCaja.posicionesGato(),stage);
                break;
            case 1:
                Piruleta piruleta=new Piruleta();
                inicializarEstructura(world, stage, piruleta);
                inicializarGato(world,piruleta.posicionesGato(),stage);
                break;
            case 2:
                PuertaGatuna puertaGatuna=new PuertaGatuna();
                inicializarEstructura(world, stage, puertaGatuna);
                inicializarGato(world,puertaGatuna.posicionesGato(),stage);
                break;
            case 3:
                Cattillo cattillo=new Cattillo();
                inicializarEstructura(world, stage, cattillo);
                inicializarGato(world,cattillo.posicionesGato(),stage);
                break;
            default:
                colocarGanador(world, stage);
                break;
        }
    }

    @Override
    public void inicializarEstructura(World world, Stage stage, Estructura estructura) {
        estructura.init(world);
        estructura.mover(Constants.INIX, Constants.GROUND_START);
        stage.addActor(estructura);
    }

    @Override
    public void inicializarGato(World world,float[] posicion,Stage stage) {
        GatoPorculero gatoPorculero=new GatoPorculero(world, posicion[0], posicion[1], sorteoGato());
        bodyGato= gatoPorculero.getBody();
        stage.addActor(gatoPorculero);
    }

    public Body getBodyGato() {
        return bodyGato;
    }

}
