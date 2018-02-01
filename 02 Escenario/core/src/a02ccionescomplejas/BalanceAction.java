package a02ccionescomplejas;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.utils.Pool;

public class BalanceAction extends MoveToAction {
	
	public BalanceAction(float x, float y) {
		setPosition(x, y);
		setDuration(5f);	
		//probar el pool como un Queue de actions
	}
}
