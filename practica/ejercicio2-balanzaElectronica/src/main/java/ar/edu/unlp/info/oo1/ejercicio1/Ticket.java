package ar.edu.unlp.info.oo1.ejercicio1;

import java.time.LocalDate;

public class Ticket {
	private java.time.LocalDate fecha;
	private int cantProductos;
	private double pesoTotal;
	private double precioTotal;
	
	
	public Ticket(int cantProductos, double peso, double precio) {
		this.fecha = LocalDate.now();
		this.cantProductos = cantProductos;
		this.pesoTotal = peso;
		this.precioTotal = precio;
	}
	
	public double impuesto() {
		return this.precioTotal * 0.21;
	}
	
	public int getCantidadDeProductos() {
		return this.cantProductos;
	}
	
	public double getPesoTotal() {
		return this.pesoTotal;
	}
	
	public double getPrecioTotal() {
		return this.precioTotal;
	}
	
	public java.time.LocalDate getFecha(){
		return this.fecha;
	}
}
