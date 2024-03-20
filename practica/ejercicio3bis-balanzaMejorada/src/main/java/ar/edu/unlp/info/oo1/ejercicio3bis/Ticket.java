package ar.edu.unlp.info.oo1.ejercicio3bis;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ticket {
	private java.time.LocalDate fecha;
	private List<Producto> productos;
	
	
	public Ticket(List<Producto> productos) {
		this.fecha = LocalDate.now();
		this.productos = productos;
	}
	
	public double impuesto() {
		return this.getPrecioTotal() * 0.21;
	}
	
	public int getCantidadDeProductos() {
		return this.productos.size();
	}
	
	public double getPesoTotal() {
		double peso = 0;
		for (Producto prod : this.productos) {
			peso += prod.getPeso();
		}
		return peso;
	}
	
	public double getPrecioTotal() {
		double precio = 0;
		for (Producto prod : this.productos) {
			precio += prod.getPrecio();
		}
		return precio;
	}
	
	public java.time.LocalDate getFecha(){
		return this.fecha;
	}
}
