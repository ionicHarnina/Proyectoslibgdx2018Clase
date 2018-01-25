package version3;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Disposable;

public class ActorBola3 extends Actor implements Disposable {
	// La forma se define com ocirculo
	private Circle circle;
	// un vector bidimensional de libgdx
	private Vector2 velocidad;
	private float velX = 9;
	private float velY = 9;
	private float elapsedTime = 0;
	private float timeToReduce = .5f;
	private float minSize = 32;
	private Image image;

	public ActorBola3(int posX, int posY, String texture) {
		super();
		this.image=new Image(new Texture(texture));
		// tamaño al actor
		this.setSize(this.image.getWidth(), this.image.getHeight());
		this.setPosition(posX, posY);
		// como todavia no usamos la fisica
		// vamos a gestionarla nosotros con la forma
		circle = new Circle();
		circle.setX(posX);
		circle.setY(posY);
		circle.setRadius(((float) this.image.getWidth()) / 2);
		velocidad = new Vector2(velX, velY);
	}

	// para definir lo que le pasa a la forma
	@Override
	public void act(float delta) {
		super.act(delta);
		if (isTimeToDecrease(delta)) {
			reduceSize();
		}
		this.moveBy(this.velocidad.x, this.velocidad.y);
		this.testingBoundsCollide();
		// la posicion a la forma
		circle.setPosition(this.getX(), this.getY());
	}

	private void reduceSize() {
		
		if (this.getWidth() > this.minSize) {
			// voy a cambiar el tamaño del actor
			this.setSize(this.getWidth() - 1, this.getHeight() - 1);
			//voy a cambiar el tamaño de la forma
			circle.setRadius(this.getWidth()/2);
			//cambio la imagen
			this.image.setSize(this.getWidth(), this.getHeight());
		}

	}

	private boolean isTimeToDecrease(float delta) {
		this.elapsedTime += delta;
		return this.elapsedTime > this.timeToReduce;
	}

	public void fixCollision(ActorBola3 bola2) {
		if (this.velocidad.x / bola2.velocidad.x == -1) {
			velocidad.x *= -1;
			bola2.velocidad.x *= -1;
		}
		if (this.velocidad.y / bola2.velocidad.y == -1) {
			velocidad.y *= -1;
			bola2.velocidad.y *= -1;
		}	
//		terminar con la persistencia de la colision
//		while (this.circle.overlaps(bola2.circle)) {
//			bola2.moveBy(bola2.velocidad.x+1, bola2.velocidad.y+1);
//		}
	}

	public boolean testingCollision(ActorBola3 bola2) {
		boolean collision = false;
		if (bola2 != null) {
			if (this.circle.overlaps(bola2.circle)) {
				collision = true;
			}
		}
		return collision;
	}
	public void manageCollision(ActorBola3 bola2) {
		if(this.testingCollision(bola2))
			this.fixCollision(bola2);
	}

	// para definir lo que le pasa a lo que vemos
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		// lo doy la posicion a la imagen
		this.image.setPosition(this.getX(), this.getY());
		this.image.draw(batch, 1);		
	}

	@Override
	public void dispose() {
	}

	/**
	 * comprueba si hay colision con los bordes hace dos cosas, luego esta mal,
	 * comprueba y rectifica
	 */
	private void testingBoundsCollide() {
		if (this.getX() < 0) {
			this.setX(0);
			velocidad.x *= -1;

		} else if (this.getRight() > Gdx.graphics.getWidth()) {
			this.setX(Gdx.graphics.getWidth() - getWidth());
			velocidad.x *= -1;
		}
		if (this.getY() < 0) {
			this.setY(0);
			velocidad.y *= -1;
		} else if (this.getTop() > Gdx.graphics.getHeight()) {
			this.setY(Gdx.graphics.getHeight() - getHeight());
			velocidad.y *= -1;
		}
	}
}
