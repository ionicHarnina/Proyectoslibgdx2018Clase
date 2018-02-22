package estructuras;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.boredcat.game.Constants;
import com.boredcat.game.Random;

/**
 * Created by Mary on 04/03/2016.
 */
public class Piruleta extends Estructura {
    private final Cuadrado cuadrado;
    private final TablaVertical tablaUno;
    private final TablaVertical tablaDos;

    public Piruleta() {
        cuadrado = new Cuadrado();
        tablaUno = new TablaVertical(false);
        tablaDos = new TablaVertical(false);
        materials.add(cuadrado);
        materials.add(tablaUno);
        materials.add(tablaDos);
    }

    @Override
    public void init(World world) {
        super.init(world);
        tablaUno.move(0, 0);
        tablaDos.move(cuadrado.getAncho() - tablaDos.getAncho(), 0);
        cuadrado.move(0, tablaUno.getAlto());
    }

    public float[] posicionesGato() {
        Random random = new Random();
        float[][] posiciones = {
                {(tablaDos.getX()+tablaUno.getAncho())* Constants.METERS_TO_PIXELS, Constants.GROUND_START* Constants.METERS_TO_PIXELS},
                {(tablaUno.getX())* Constants.METERS_TO_PIXELS, cuadrado.getY()* Constants.METERS_TO_PIXELS},
                {(cuadrado.getX()-(cuadrado.getAncho()*2))* Constants.METERS_TO_PIXELS, Constants.GROUND_START* Constants.METERS_TO_PIXELS}};
        int sorteo = random.sorteo(posiciones.length);
        Gdx.app.log("posicion: ",String.valueOf(sorteo));
        float[] resultado = {posiciones[sorteo][0], posiciones[sorteo][1]};
        return resultado;
    }
}
