
public class main {

	public static void main(String[] args) throws CloneNotSupportedException {
		Rectangulo rectangulo = new Rectangulo(5);
		Rectangulo recII=(Rectangulo) rectangulo.clone();
		System.out.println(recII.getLado());
		
		Grupo grupI=new Grupo("juan", 10);
		Grupo grupII=(Grupo) grupI.clone();
		System.out.println(grupII.tritri.altura);
		System.out.println(grupII.nombre);
		System.out.println(grupII.tritri.mote);
	}

}
