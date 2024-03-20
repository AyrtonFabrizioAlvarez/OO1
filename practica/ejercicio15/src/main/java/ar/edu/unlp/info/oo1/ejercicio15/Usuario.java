package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private int dni;
	private String direccion;
	private List<Propiedad> propiedades;
	private List<Reserva> reservas;
	
	public Usuario(String nombre, int dni, String direccion) {
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
		this.propiedades = new ArrayList<>();
		this.reservas = new ArrayList<>();
	}
	
	public List<Propiedad> obtenerPropiedades(){
		return this.propiedades;
	}
	
	public List<Propiedad> obtenerPropiedadesDisponibles(DateLapse periodo){
		return this.propiedades.stream().filter(propiedad -> propiedad.isLibre(periodo)).toList();
	}
	
	public void añadirReserva(Reserva nuevaReserva) {
		this.reservas.add(nuevaReserva);
	}
	
	public void añadirPropiedad(Propiedad propiedad) {
		this.propiedades.add(propiedad);
	}
	
	public void eliminarReserva(Reserva reserva) {
		if (reserva.isFutura(LocalDate.now())) {
			this.reservas.remove(reserva);
		}
	}

	public List<Reserva> obtenerReservas(){
		return this.reservas;
	}
	
	public double calcularIngresos(LocalDate desde, LocalDate hasta) {
		return this.propiedades.stream().mapToDouble(p -> p.montoAlquilerEntreFechas(desde, hasta)).sum();
	}
}
