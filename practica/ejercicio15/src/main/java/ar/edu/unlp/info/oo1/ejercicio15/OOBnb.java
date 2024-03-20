package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OOBnb {
	private List<Usuario> usuarios;
	
	public OOBnb() {
		this.usuarios = new ArrayList<>();
	}
	
	public Usuario registrarUsuario(String nombre, int dni, String descripcion) {
		Usuario nuevoUsuario = new Usuario(nombre, dni, descripcion);
		this.usuarios.add(nuevoUsuario);
		return nuevoUsuario;
	}
	
	public Propiedad registrarPropiedad(String nombre, String descripcion, double precio, String direccion, Usuario dueño) {
		Propiedad nuevaPropiedad = new Propiedad(nombre, descripcion, precio, direccion); 
		dueño.añadirPropiedad(nuevaPropiedad);
		return nuevaPropiedad;
	}
	
	public List<Propiedad> propiedadesDisponibles(DateLapse periodo){
		return this.usuarios.stream().flatMap(usuario -> usuario.obtenerPropiedadesDisponibles(periodo).stream()).toList();
	}
	
	public Reserva hacerReserva(Propiedad propiedad, DateLapse periodo, Usuario usuario) {
		Reserva nuevaReserva = null;
		if (propiedad.isLibre(periodo)) {
			nuevaReserva = new Reserva(propiedad, periodo, usuario);
			propiedad.añadirReserva(nuevaReserva);
			usuario.añadirReserva(nuevaReserva);
		}
		return nuevaReserva;
	}
	
	public double calcularPrecio(Reserva reserva) {
		return reserva.calcularPrecio();
	}
	
	public void eliminarReserva(Reserva reserva) {
		reserva.eliminarReserva(reserva);
	}
	
	public List<Reserva> obtenerReservas(Usuario usuario){
		return usuario.obtenerReservas();
	}
	
	public double ingresosPropietario(Usuario usuario, LocalDate desde, LocalDate hasta) {
		return usuario.calcularIngresos(desde, hasta);
	}
}
