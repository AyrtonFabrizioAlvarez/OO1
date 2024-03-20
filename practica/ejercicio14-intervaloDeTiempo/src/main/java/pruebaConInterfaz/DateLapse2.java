package pruebaConInterfaz;

import java.time.LocalDate;

import ar.edu.unlp.info.oo1.ejercicio14_intervaloDeTiempo.Lapse;

public class DateLapse2 implements Lapse{
	private LocalDate from;
	private int sizeInDays;
	
	
	public DateLapse2() {
		
	}
	
	public LocalDate getFrom() {
		return this.from;
	}
	
	public LocalDate getTo() {
		return this.from.plusDays(this.sizeInDays);
	}
	
	public void setFrom(LocalDate from) {
		this.from = from;
	}
	
	public int sizeInDays() {
		return this.sizeInDays;
	}
	
	public void setSizeInDays(int sizeInDays) {
		this.sizeInDays = sizeInDays;
	}
	
	public boolean includesDate(LocalDate other) {
		boolean enRango = false;
		if ( (other.isAfter(this.from)) && (other.isBefore(this.getTo())) ) {
			enRango = true;
		}
		return enRango;
	}
	
}
