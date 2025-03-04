package ar.edu.unlp.info.oo1.ejercicio5_genealogiaSalvaje;

import java.time.LocalDate;

public class Mamifero {
	private String identificador;
	private String especie;
	private LocalDate fechaNacimiento;
	private Mamifero padre;
	private Mamifero madre;
	
	public Mamifero (String nombre) {
		this.identificador = nombre;
	}
	
	public Mamifero() {
		
	}
	
	public String getIdentificador() {
		return this.identificador;
	}
	
	public void setIdentificador(String id) {
		this.identificador = id;
	}
	
	public String getEspecie() {
		return this.especie;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public LocalDate getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	
	public void setFechaNacimiento(LocalDate fecha) {
		this.fechaNacimiento = fecha;
	}
	
	public Mamifero getPadre() {
		return this.padre;			
	}
	
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	
	public Mamifero getMadre() {
		return this.madre;			
	}
	
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}	
	
	public Mamifero getAbueloMaterno() {
		Mamifero mamifero = this.getMadre();
		if (mamifero != null) {
			return mamifero.getPadre();
		}
		return mamifero;
	}
	
	public Mamifero getAbuelaMaterna() {
		Mamifero mamifero = this.getMadre();
		if (mamifero != null) {
			return mamifero.getMadre();
		}
		return mamifero;
	}
	
	public Mamifero getAbueloPaterno() {
		Mamifero mamifero = this.getPadre();
		if (mamifero != null) {
			return mamifero.getPadre();
		}
		return mamifero;
	}
	
	public Mamifero getAbuelaPaterna() {
		Mamifero mamifero = this.getPadre();
		if (mamifero != null) {
			return mamifero.getMadre();
		}
		return mamifero;
	}
	
	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		boolean encontre = false;
		if ((this.padre == unMamifero) || (this.madre == unMamifero)) {
			encontre = true;
		}
		else {
			if (this.padre != null) {
				encontre = this.padre.tieneComoAncestroA(unMamifero);
			}
			if ((!encontre) && (this.madre != null)) {
				encontre = this.madre.tieneComoAncestroA(unMamifero);
			}
		}
		return encontre;
	}
	
}
