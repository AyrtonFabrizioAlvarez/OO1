package ar.edu.unlp.info.oo1.ejercicio8_distribuidoraElectrica;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private String domicilio;
	private List<Factura> facturas;
	private List<Consumo> consumos;
	
	public Usuario(String nombre, String domicilio) {
		this.domicilio = domicilio;
		this.nombre = nombre;
		this.facturas = new ArrayList<>();
		this.consumos = new ArrayList<>();
	}
	
	public void agregarMedicion(Consumo medicion) {
		this.consumos.add(medicion);
	}
	
	public double ultimoConsumoActiva() {
		Consumo consumo = this.ultimoConsumo();
		double ultimoConsumo = 0;
		if (consumo != null) {
			ultimoConsumo = consumo.getConsumoEnergiaActiva();
		}
		return ultimoConsumo;
	}
	
	public Factura facturarEnBaseA(double precioKwh) {
		Consumo ultimo = this.ultimoConsumo();
		double descuento = 0;
		if(ultimo != null) {
			double pfe = ultimo.factorDePotencia();
			if (pfe > 0.8) {
				descuento = 10;
			}
		}
		return new Factura(this.ultimoConsumoActiva()*precioKwh, descuento, this);
	}
	
	public List<Factura> facturas(){
		return this.facturas;
	}
	
	public Consumo ultimoConsumo() {
		return this.consumos.stream().max((c1, c2) -> c1.getFecha().compareTo(c2.getFecha())).orElse(null);
	}
}
