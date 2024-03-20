package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Propiedad {
	private String nombre;
	private String descripcion;
	private double precioPorNoche;
	private String direccion;
	private List<Reserva> reservas;
	
	public Propiedad (String nombre, String descripcion, double precio, String direccion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioPorNoche = precio;
		this.direccion = direccion;
		this.reservas = new ArrayList<>();
	}
	
	public double getPrecioPorNoche() {
		return this.precioPorNoche;
	}
	
	public boolean isLibre(DateLapse periodo) {
		return this.reservas.stream().noneMatch(reserva -> reserva.isOverlapsed(periodo));
	}
	
	public void añadirReserva(Reserva nuevaReserva) {
		this.reservas.add(nuevaReserva);
	}
	
	public void eliminarReserva(Reserva reserva) {
		if (reserva.isFutura(LocalDate.now())) {
			this.reservas.remove(reserva);
		}
	}
	
	public List<Reserva> getReservas(){
		return this.reservas;
	}
	
	public double montoAlquilerEntreFechas(LocalDate desde, LocalDate hasta) {
		DateLapse periodo = new DateLapse(desde, hasta);
		return this.reservas.stream().filter(reserva -> reserva.isOverlapsed(periodo)).mapToDouble(r -> r.calcularPrecio()).sum();
	}
}
