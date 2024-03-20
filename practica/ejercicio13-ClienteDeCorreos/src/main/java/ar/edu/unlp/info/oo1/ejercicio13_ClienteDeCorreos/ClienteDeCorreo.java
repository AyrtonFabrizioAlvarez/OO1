package ar.edu.unlp.info.oo1.ejercicio13_ClienteDeCorreos;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {
	private Carpeta inbox;
	private List<Carpeta> carpetas;
	
	public ClienteDeCorreo() {
		this.inbox = new Carpeta("inbox");
		this.carpetas = new ArrayList<>();
		carpetas.add(inbox);
	}
	
	public void agregarCarpeta(Carpeta carpeta) {
		this.carpetas.add(carpeta);
	}
	
	public void recibir(Email email) {
		this.inbox.agregarEmail(email);
	}
	
	public void mover(Email email, Carpeta origen, Carpeta destino) {
		origen.borrarEmail(email);
		destino.agregarEmail(email);
	}
	
	public Email buscar(String texto) {
		return this.carpetas.stream().map(carpeta -> carpeta.buscar(texto)).filter(email -> email != null).findFirst().orElse(null);
	}
	
	public int espacioOcupado() {
		return this.carpetas.stream().mapToInt(carpeta -> carpeta.getTamanio()).sum();
	}
}
