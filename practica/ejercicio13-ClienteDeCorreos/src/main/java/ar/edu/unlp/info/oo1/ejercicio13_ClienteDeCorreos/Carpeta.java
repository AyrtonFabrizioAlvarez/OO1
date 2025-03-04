package ar.edu.unlp.info.oo1.ejercicio13_ClienteDeCorreos;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
	private List<Email> emails;
	private String nombre;
	
	public Carpeta (String nombre) {
		this.nombre = nombre;
		this.emails = new ArrayList<>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void agregarEmail(Email email) {
		this.emails.add(email);
	}
	
	public void borrarEmail(Email email) {
		this.emails.remove(email);
	}
	
	public Email buscar(String textoBuscado) {
		return this.emails.stream().filter(email -> email.coincideCon(textoBuscado)).findFirst().orElse(null);
	}
	
	public int getTamanio() {
		return this.emails.stream().mapToInt(email -> email.getTamanio()).sum();
	}
	
	public int getCantEmails(){
		return this.emails.size();
	}
	
}
