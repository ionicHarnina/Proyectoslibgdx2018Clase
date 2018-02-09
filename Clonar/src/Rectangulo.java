
public class Rectangulo implements Cloneable{
	private int lado;

	public Rectangulo(int lado) {
		super();
		this.lado = lado;
	}

	public int getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	};
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
