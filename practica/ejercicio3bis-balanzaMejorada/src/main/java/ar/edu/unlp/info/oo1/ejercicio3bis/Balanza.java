package ar.edu.unlp.info.oo1.ejercicio3bis;

import java.util.ArrayList;
import java.util.List;

public class Balanza {
	private List<Producto> productos;
	
	public Balanza() {
		this.productos = new ArrayList<Producto>();
	}
	
	public void ponerEnCero() {
		this.productos.clear();
	}
	
	public List<Producto> getProductos() {
		return this.productos;
	}
	
	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}
	
	public Ticket emitirTicket() {
		double peso = 0;
		double precio = 0;
		for(Producto prod : this.productos) {
			peso += prod.getPeso();
			precio += prod.getPrecio();
		}
		return new Ticket(this.productos);
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
}
