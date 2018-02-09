
public class Grupo implements Cloneable{
	public String nombre;
	public Triangulo tritri;
	
	public Grupo(String nombre, Integer lado ) {
		super();
		this.nombre = nombre;
		this.tritri = new Triangulo();
		this.tritri.altura=lado;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
