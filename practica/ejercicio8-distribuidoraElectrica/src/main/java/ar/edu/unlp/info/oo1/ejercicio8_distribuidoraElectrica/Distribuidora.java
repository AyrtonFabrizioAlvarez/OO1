package ar.edu.unlp.info.oo1.ejercicio8_distribuidoraElectrica;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Distribuidora {
	private double precioKwh;
	private List <Usuario> usuarios;
	
	public Distribuidora(double precio) {
		this.precioKwh = precio;
		this.usuarios = new ArrayList<>();
	}
	
	
	public void agregarUsuario(Usuario user) {
		this.usuarios.add(user);
	}
	
	public List<Factura> facturar() {
		return this.usuarios.stream().map(usuario -> usuario.facturarEnBaseA(this.precioKwh)).collect(Collectors.toList());
	}
	
	public double consumoTotalActiva() {
		return this.usuarios.stream().mapToDouble(usuario -> usuario.ultimoConsumoActiva()).sum();
	}
	
	public void precioKwh(double precio) {
		this.precioKwh = precio;
	}
	
	public List<Usuario> getUsuarios(){
		return this.usuarios;
	}
	
	public double getPrecioKW() {
		return this.precioKwh;
	}
}
