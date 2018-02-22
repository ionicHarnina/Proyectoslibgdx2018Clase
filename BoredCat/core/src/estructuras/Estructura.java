package estructuras;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mary on 04/03/2016.
 */
public abstract class Estructura extends Actor {

    protected List<Material> materials = new ArrayList<Material>();

    public void mover(float x, float y){
        for (Material m : materials) {
            m.move(x + m.getX(), y + m.getY());
        }
    }

    public void init(World world){
        for (Material m : materials) {
            m.init(world);
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        for (Material m : materials) {
            m.act();
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (Material m : materials) {
            m.draw(batch);
        }
    }
}
