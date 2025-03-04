package ar.edu.unlp.info.oo1.ejercicio13_ClienteDeCorreos;

import java.util.ArrayList;
import java.util.List;

public class Email {
	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;
	
	public Email(String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.adjuntos = new ArrayList<>();
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getCuerpo() {
		return this.cuerpo;
	}
	
	public List<Archivo> adjuntos(){
		return this.adjuntos;
	}
	
	public void agregarAdjunto(Archivo archivo) {
		this.adjuntos.add(archivo);
	}
	
	public boolean coincideCon(String texto) {
		if ( (this.cuerpo.equals(texto)) | (this.titulo.equals(texto)) ) {
			return true;
		}
		return false;
	}
	
	public int getTamanio () {
		int adjuntos = this.adjuntos.stream().mapToInt(adjunto -> adjunto.getTamanio()).sum();
		return adjuntos + this.titulo.length() + this.cuerpo.length();
	}
}
