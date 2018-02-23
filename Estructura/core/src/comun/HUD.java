package comun;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;



public class HUD implements Disposable{
	private BitmapFont font;
	public static boolean nivel=true;
	public static int puntuaciones=0;
	public static Integer highScore;
	private Texture azul,verde;
	float tamanoVida=90f;
	
	
	public HUD(){	
		verde=new Texture("verde.png");
		azul=new Texture("azul.png");
		this.font=new BitmapFont(Gdx.files.internal(""));
	}

	public void draw(SpriteBatch batch, Camera camera) {
		batch.draw(verde, camera.position.x-Gdx.graphics.getWidth()/2+10,  camera.position.y-Gdx.graphics.getHeight()/2+10,100,30);
		batch.draw(azul, camera.position.x-Gdx.graphics.getWidth()/2+15,camera.position.y-Gdx.graphics.getHeight()/2+15,tamanoVida*(1/1),20);
		font.draw(batch, "Llaves :"+"",camera.position.x-Gdx.graphics.getWidth()/2+20, camera.position.y+Gdx.graphics.getHeight()/2-10); 
		font.draw(batch, "Monedas : "+"", camera.position.x+Gdx.graphics.getWidth()/2-200, camera.position.y+Gdx.graphics.getHeight()/2-10);
	}

	@Override
	public void dispose() {
		font.dispose();
	}
}
