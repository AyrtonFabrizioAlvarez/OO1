package ar.edu.unlp.info.oo1.ejercicio8_distribuidoraElectrica;

import java.time.LocalDate;

public class Consumo {
	private LocalDate fecha;
	private double consumoEnergiaActiva;
	private double consumoEnergiaReactiva;
	
	public Consumo(LocalDate fecha, double energiaActiva, double energiaReactiva) {
		this.fecha = fecha;
		this.consumoEnergiaActiva = energiaActiva;
		this.consumoEnergiaReactiva = energiaReactiva;
	}
	
	public double costoEnBaseA(double precioKwh) {
		return this.consumoEnergiaActiva * precioKwh;
	}
	
	public double factorDePotencia() {
		return this.consumoEnergiaActiva / Math.sqrt((this.consumoEnergiaActiva * this.consumoEnergiaActiva) + (this.consumoEnergiaReactiva * this.consumoEnergiaReactiva));
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public Double getConsumoEnergiaActiva() {
		return this.consumoEnergiaActiva;
	}
}
