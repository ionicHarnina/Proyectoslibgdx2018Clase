package com.adorno;


//Pruebalo sin serializar para ver que falla al guardar aunque cliente sea serializable
//Esto quiere decir que todas las clases deben ser serializables
public class Empresa implements java.io.Serializable {
private String CIF;
private int anno;
public Empresa(String CIF,int anno) {
	// TODO Auto-generated constructor stub
	this.CIF=CIF;
	this.anno=anno;
}
}
