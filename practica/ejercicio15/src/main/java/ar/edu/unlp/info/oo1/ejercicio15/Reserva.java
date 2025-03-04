package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;

public class Reserva {
	private Usuario usuario;
	private Propiedad propiedad;
	private DateLapse lapso;
	
	public Reserva(Propiedad propiedad, DateLapse lapso, Usuario usuario) {
		this.usuario = usuario;
		this.propiedad = propiedad;
		this.lapso = lapso;
	}
	
	public double calcularPrecio() {
		return this.lapso.sizeInDays() * this.propiedad.getPrecioPorNoche();
	}
	
	public boolean isOverlapsed(DateLapse other) {
		return this.lapso.overlapse(other);
	}
	
	public boolean isFutura(LocalDate other) {
		boolean futura = false;
		if (this.lapso.getTo().isAfter(other)) {
			futura = true;
		}
		return futura;
	}
	
	public void eliminarReserva(Reserva reserva) {
		this.propiedad.eliminarReserva(reserva);
		this.usuario.eliminarReserva(reserva);
	}
}
