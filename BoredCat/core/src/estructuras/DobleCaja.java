package estructuras;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.boredcat.game.Constants;
import com.boredcat.game.Random;

/**
 * Created by Mary on 04/03/2016.
 */
public class DobleCaja extends Estructura {
    private final Cuadrado cajaUno;
    private final Cuadrado cajaDos;

    public DobleCaja() {
        cajaUno = new Cuadrado();
        cajaDos = new Cuadrado();
        materials.add(cajaUno);
        materials.add(cajaDos);
    }

    @Override
    public void init(World world) {
        super.init(world);
        cajaUno.move(0, 0);
        cajaDos.move(0, cajaUno.getAlto());
    }

    public float[] posicionesGato() {
        Random random = new Random();
        float[][] posiciones = {
                {(cajaUno.getX()-cajaUno.getAncho())* Constants.METERS_TO_PIXELS, cajaDos.getY()*Constants.METERS_TO_PIXELS},
                {cajaUno.getX()*Constants.METERS_TO_PIXELS, Constants.GROUND_START*Constants.METERS_TO_PIXELS},
                {(cajaUno.getX()-cajaUno.getAncho()*2)*Constants.METERS_TO_PIXELS,Constants.GROUND_START*Constants.METERS_TO_PIXELS}};
        int sorteo = random.sorteo(posiciones.length);
        Gdx.app.log("posicion: ",String.valueOf(sorteo));
        float[] resultado = {posiciones[sorteo][0], posiciones[sorteo][1]};
        return resultado;
    }
}
