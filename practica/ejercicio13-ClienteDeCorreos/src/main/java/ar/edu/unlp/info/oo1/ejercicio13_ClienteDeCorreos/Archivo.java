package ar.edu.unlp.info.oo1.ejercicio13_ClienteDeCorreos;

public class Archivo {
	private String nombre;
	
	public Archivo (String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getTamanio() {
		return this.nombre.length();
	}
}
