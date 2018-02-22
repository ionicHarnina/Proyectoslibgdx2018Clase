package estructuras;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.boredcat.game.Constants;
import com.boredcat.game.Random;

/**
 * Created by usuario on 08/03/2016.
 */
public class PuertaGatuna extends Estructura {
    private Cuadrado cuadro1, cuadro2, cuadro3, cuadro4;
    private TablaHorizontal tabla;

    public PuertaGatuna() {

        cuadro1 = new Cuadrado();
        cuadro2 = new Cuadrado();
        cuadro3 = new Cuadrado();
        cuadro4 = new Cuadrado();
        tabla = new TablaHorizontal(true);
        materials.add(cuadro1);
        materials.add(cuadro2);
        materials.add(cuadro3);
        materials.add(cuadro4);
        materials.add(tabla);

    }

    @Override
    public void init(World world) {
        super.init(world);
        float alto = cuadro1.getAlto();
        float ancho = cuadro1.getAncho();
        cuadro1.move(0,0);
        cuadro2.move(0, alto);
        cuadro3.move(ancho * 2, 0);
        cuadro4.move(ancho * 2, alto);
        tabla.move(ancho/2, alto*2);

    }

    public float[] posicionesGato() {
        Random random = new Random();
        float[][] posiciones = {
                {(cuadro1.getX()-cuadro1.getAncho()*2)*Constants.METERS_TO_PIXELS,Constants.GROUND_START*Constants.METERS_TO_PIXELS},
                {(cuadro1.getX())* Constants.METERS_TO_PIXELS,(cuadro1.getAlto()*2+tabla.getAlto()+Constants.GROUND_START)* Constants.METERS_TO_PIXELS},
                {(cuadro1.getX())* Constants.METERS_TO_PIXELS,Constants.GROUND_START* Constants.METERS_TO_PIXELS},
                {cuadro3.getX()*Constants.METERS_TO_PIXELS,Constants.GROUND_START*Constants.METERS_TO_PIXELS}};
        int sorteo = random.sorteo(posiciones.length);
        Gdx.app.log("posicion: ",String.valueOf(sorteo));
        float[] resultado = {posiciones[sorteo][0], posiciones[sorteo][1]};
        return resultado;
    }
}
