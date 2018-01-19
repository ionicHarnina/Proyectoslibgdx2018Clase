package com.adorno;




//Esta clase para poder ser conertida en bits debe implementar la interfaz
//Serializble guia a java para la conversion en bytes
public class Cliente implements java.io.Serializable{
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//Vamos a guardar este objeto en un fichero
	private String dni;
	private String nombre;
	private int edad;
	Empresa empresa;
	
	
	public Cliente(String dni,String nombre,int edad, String CIF,int anno) {
		// TODO Auto-generated constructor stub
		this.dni=dni;
		this.nombre=nombre;
		this.edad=edad;

		
	}
	@Override
	public String toString() {
			return "Cliente:"+nombre+" dni:"+dni+"de edad "+edad+"a�os";
	}
}
