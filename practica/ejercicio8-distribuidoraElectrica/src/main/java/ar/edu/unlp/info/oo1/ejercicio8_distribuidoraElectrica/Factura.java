package ar.edu.unlp.info.oo1.ejercicio8_distribuidoraElectrica;

import java.time.LocalDate;

public class Factura {
	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario usuario;
	
	public Factura(double energiaActiva, double descuento, Usuario usuario) {
		this.montoEnergiaActiva = energiaActiva;
		this.descuento = descuento;
		this.usuario = usuario;
		this.fecha = LocalDate.now();
	}
	
	public double montoTotal() {
		double montoDescuento = (this.montoEnergiaActiva * this.descuento) / 100;
		return this.montoEnergiaActiva - montoDescuento;
	}
	
	public Usuario usuario() {
		return this.usuario;
	}
	
	public LocalDate fecha() {
		return this.fecha;
	}
	
	public double getMontoEnergiaActiva() {
		return this.montoEnergiaActiva;
	}
	
	public double getDescuento() {
		return this.descuento;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
}
