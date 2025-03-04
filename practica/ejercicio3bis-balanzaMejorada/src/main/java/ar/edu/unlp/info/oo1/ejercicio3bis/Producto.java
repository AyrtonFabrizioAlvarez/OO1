package ar.edu.unlp.info.oo1.ejercicio3bis;

public class Producto {
	private double peso;
	private double precioPorKilo;
	private String descripcion;
	
	public double getPrecio() {
		return this.precioPorKilo * this.peso;
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public void setPrecioPorKilo(double precio) {
		this.precioPorKilo = precio;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public double getPrecioPorKilo() {
		return this.precioPorKilo;
	}
}
