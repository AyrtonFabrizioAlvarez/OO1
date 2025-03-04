package ar.edu.unlp.info.oo1.ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
	private java.time.LocalDate fecha;
	private String cliente;
	private List<Item> items;
	
	public Presupuesto(String cliente) {
		this.cliente = cliente;
		this.fecha = LocalDate.now();
		this.items = new ArrayList<Item>();
	}
	
	public String getCliente() {
		return this.cliente;
	}
	
	public java.time.LocalDate getFecha(){
		return this.fecha;
	}
	
	public void agregarItem(Item item) {
		this.items.add(item);
	}
	
	public double calcularTotal() {
		int total = 0;
		for(Item item : this.items) {
			total += item.costo();
		}
		return total;
	}
	
}
