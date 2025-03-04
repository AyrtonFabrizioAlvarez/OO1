package ar.edu.unlp.info.oo1.ejercicio1;

public class Balanza {
	private int cantProductos;
	private double precioTotal;
	private double pesoTotal;
	
	public Balanza() {
		this.ponerEnCero();
	}
	
	public void ponerEnCero() {
		this.cantProductos = 0;
		this.precioTotal = 0;
		this.pesoTotal = 0;
	}
	
	public void agregarProducto(Producto producto) {
		this.cantProductos++;
		this.precioTotal = this.precioTotal + producto.getPrecio();
		this.pesoTotal = this.pesoTotal + producto.getPeso();
	}
	
	public Ticket emitirTicket() {
		return new Ticket(this.cantProductos, this.pesoTotal, this.precioTotal);
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
}
